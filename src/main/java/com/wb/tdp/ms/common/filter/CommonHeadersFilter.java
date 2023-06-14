package com.wb.tdp.ms.common.filter;

import java.io.IOException;
import java.net.InetAddress;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.wb.tdp.ms.common.constants.AppConstants;
import com.wb.tdp.ms.common.constants.OriginSource;
import com.wb.tdp.ms.common.dto.RequestDto;
import com.wb.tdp.ms.common.utils.CurrentCommonHeaders;
import com.wb.tdp.ms.common.utils.CurrentCorrelationId;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Filter to intercept incoming request to check for CorrelationID.
 * If not present generate for log tracing.
 * @author anangupt
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CommonHeadersFilter implements Filter {

//	@Value("${spring.application.name}")
	@Value("booking-core-ms")
	private String appName;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				// Referenced from logging configuration.
				MDC.put(AppConstants.HEADER_KEY_CORRELATION, correlationId
										(httpRequest.getHeader(AppConstants.HEADER_KEY_CORRELATION)));
				MDC.put("HostName", InetAddress.getLocalHost().getHostName());
				MDC.put("ServiceName", appName);				
				
				MDC.put(AppConstants.HEADER_KEY_LOCALE, "en");
				MDC.put(AppConstants.HEADER_KEY_PROXY_USER, httpRequest.getHeader(AppConstants.HEADER_KEY_PROXY_USER));
				MDC.put(AppConstants.HEADER_KEY_ORIGIN_SOURCE, 
						OriginSource.getByDisplayName(httpRequest.getHeader(AppConstants.HEADER_KEY_ORIGIN_SOURCE)).getVal());
				MDC.put(AppConstants.HEADER_KEY_ORIGIN_IP, httpRequest.getHeader(AppConstants.HEADER_KEY_ORIGIN_IP));
				MDC.put(AppConstants.HEADER_KEY_CLIENT_ROLES, httpRequest.getHeader(AppConstants.HEADER_KEY_CLIENT_ROLES));
				MDC.put(AppConstants.HEADER_KEY_PRINCIPAL_NAME, httpRequest.getHeader(AppConstants.HEADER_KEY_PRINCIPAL_NAME));
				
				setCommonHeaders(httpRequest);
			}
			
			// call filter(s) upstream for processing of the request
			chain.doFilter(request, response);
		} finally {
			// important to clean the correlationId from the MDC, 
			MDC.clear();
		}
	}

	/**
	 * Sets the common headers.
	 *
	 * @param httpRequest the new common headers
	 */
	private void setCommonHeaders(HttpServletRequest httpRequest) {
		
		RequestDto requestDto = new RequestDto();
		requestDto.setCorrelationId(MDC.get(AppConstants.HEADER_KEY_CORRELATION));
		requestDto.setLocale(httpRequest.getHeader(AppConstants.HEADER_KEY_LOCALE));
		requestDto.setProxyUser(httpRequest.getHeader(AppConstants.HEADER_KEY_PROXY_USER));
		String originSource = httpRequest.getHeader(AppConstants.HEADER_KEY_ORIGIN_SOURCE);
		requestDto.setOriginSource(OriginSource.getByDisplayName(originSource));
		requestDto.setChannelType(OriginSource.getChannelType(requestDto.getOriginSource()));
		requestDto.setChannelName(requestDto.getChannelType().getVal());
		requestDto.setOriginIP(httpRequest.getHeader(AppConstants.HEADER_KEY_ORIGIN_IP));
		requestDto.setPrincipal(httpRequest.getHeader(AppConstants.HEADER_KEY_PRINCIPAL_NAME));
		
		if(null != httpRequest.getHeader(AppConstants.HEADER_KEY_CLIENT_ROLES)) {
			requestDto.setClientRoles(httpRequest.getHeader(AppConstants.HEADER_KEY_CLIENT_ROLES).split(","));
		}
		
		CurrentCommonHeaders.set(requestDto);
	}

	/**
	 * Method to return correlationId to set to MDC
	 * If comes as non-empty string use it else generate new correlation for tracing.
	 * @param correlationId
	 * @return
	 */
	private String correlationId(String correlationId) {
		String correlationID = null;
		if(null != correlationId && correlationId.length() > 0) {
			correlationID = correlationId;
		} else {
			correlationID = "SBM-" + UUID.randomUUID().toString();
		}
		// Setting correlation in threadlocal context for using it as part of header for API to API call 
		// and to pass correlationID to message header.
		CurrentCorrelationId.set(correlationID);
		return correlationID;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
