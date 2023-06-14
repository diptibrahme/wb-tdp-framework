package com.wb.tdp.ms.common.requesthandler;

import com.wb.tdp.ms.common.authorization.AuthorizationInfo;
import com.wb.tdp.ms.common.dto.RequestDto;
import com.wb.tdp.ms.common.utils.CurrentCommonHeaders;

/**
 * 
 * This abstract contains  the abstract methods and which are the part of request life cycle.
 * 
 */
public abstract class AbstractRequestHandler<T1, T2> implements RequestHandler<T1,T2> {

	/**
	 * This method is used to call other method and will be called first to start processing of input.
	 * @param t1 - input type
	 * @param authInfo- object of AuthorizationInfo
	 * 
	 */
	@Override
	public T2 handler(T1 t1, AuthorizationInfo authInfo) {
		handleCommonHeaders(t1);
		doValidation(t1);
		return doProcess(t1);
	}
	
	/**
	 * Handle common headers.
	 *
	 * @param t1 the t 1
	 */
	protected void handleCommonHeaders(T1 t1) {
		if(t1 instanceof RequestDto) {
			RequestDto requestDto = CurrentCommonHeaders.get();
			((RequestDto) t1).setCorrelationId(requestDto.getCorrelationId());
			((RequestDto) t1).setLocale(requestDto.getLocale());
			((RequestDto) t1).setChannelType(requestDto.getChannelType());
			((RequestDto) t1).setOriginSource(requestDto.getOriginSource());
			((RequestDto) t1).setOriginIP(requestDto.getOriginIP());
			((RequestDto) t1).setProxyUser(requestDto.getProxyUser());
			((RequestDto) t1).setChannelName(requestDto.getChannelName());
			((RequestDto) t1).setClientRoles(requestDto.getClientRoles());
		}
	}


	/**
	 * This is a abstract method definition will be in implemented class 
	 * @param t1
	 * @return
	 */
	public abstract T2 doProcess(T1 t1);

	/**
	 * Not Implemented ... place holder for any future requirement
	 * @param t1 - input type
	 */
	public void doFilter(T1 t1) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * This method tells the request life cycle whether to check for authorization or not.
	 * Not Implemented ... place holder for any future requirement
	 * @param authorization -
	 */
	public void authorization(boolean authorization) {
		throw new UnsupportedOperationException();
	}

	
}
