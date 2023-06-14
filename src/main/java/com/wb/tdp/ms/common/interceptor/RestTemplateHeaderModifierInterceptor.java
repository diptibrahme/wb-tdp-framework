package com.wb.tdp.ms.common.interceptor;

import java.io.IOException;
import java.util.Map;

import org.slf4j.MDC;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import com.wb.tdp.ms.common.constants.AppConstants;
import com.wb.tdp.ms.common.dto.RequestDto;
import com.wb.tdp.ms.common.utils.CurrentCommonHeaders;
/**
 * Header modifier interceptor for RestTemplate
 * 
 * @author anangupt
 *
 */
public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {

	/**
	 * adding headers
	 */
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		RequestDto requestDto = CurrentCommonHeaders.get();
		if(requestDto != null) {
			request.getHeaders().set(AppConstants.HEADER_KEY_CORRELATION, requestDto.getCorrelationId());
			request.getHeaders().set(AppConstants.HEADER_KEY_LOCALE, "en");
			request.getHeaders().set(AppConstants.HEADER_KEY_PROXY_USER, requestDto.getProxyUser());
			request.getHeaders().set(AppConstants.HEADER_KEY_ORIGIN_SOURCE, requestDto.getOriginSource().getVal());
			request.getHeaders().set(AppConstants.HEADER_KEY_ORIGIN_IP, requestDto.getOriginIP());
			request.getHeaders().set(AppConstants.HEADER_KEY_PRINCIPAL_NAME, requestDto.getPrincipal());			
			if(null != requestDto.getClientRoles() && requestDto.getClientRoles().length > 0) {
				request.getHeaders().set(AppConstants.HEADER_KEY_CLIENT_ROLES, String.join(",", requestDto.getClientRoles()));
			}									
		}else {
			//Fetch from MdcTaskDecorator
			Map<String, String> contextMap = MDC.getCopyOfContextMap();
			if (contextMap != null) {
				request.getHeaders().set(AppConstants.HEADER_KEY_CORRELATION,
						contextMap.get(AppConstants.HEADER_KEY_CORRELATION));
				request.getHeaders().set(AppConstants.HEADER_KEY_LOCALE, contextMap.get(AppConstants.HEADER_KEY_LOCALE));
				request.getHeaders().set(AppConstants.HEADER_KEY_PROXY_USER,
						contextMap.get(AppConstants.HEADER_KEY_PROXY_USER));
				request.getHeaders().set(AppConstants.HEADER_KEY_ORIGIN_SOURCE,
						contextMap.get(AppConstants.HEADER_KEY_ORIGIN_SOURCE));
				request.getHeaders().set(AppConstants.HEADER_KEY_ORIGIN_IP,
						contextMap.get(AppConstants.HEADER_KEY_ORIGIN_IP));
				request.getHeaders().set(AppConstants.HEADER_KEY_PRINCIPAL_NAME,
						contextMap.get(AppConstants.HEADER_KEY_PRINCIPAL_NAME));
				
				if(null != contextMap.get(AppConstants.HEADER_KEY_CLIENT_ROLES)) {
					request.getHeaders().set(AppConstants.HEADER_KEY_CLIENT_ROLES,
							contextMap.get(AppConstants.HEADER_KEY_CLIENT_ROLES));	
				}
			}
		}
		request.getHeaders().setContentType(MediaType.APPLICATION_JSON_UTF8);
		return execution.execute(request, body);		
	}
}
