package com.wb.tdp.ms.common.requesthandler;

import com.wb.tdp.ms.common.authorization.AuthorizationInfo;

/**
 * This interface contains all the abstract methods which are the part of request life cycle.
 * 
 * @author ssuryana
 *
 * @param <T1> -todo
 * @param <T2>  -todo
 */
public interface RequestHandler<T1,T2> {

	/**
	 * This method is the starting point of the request life cycle and will call the other methods
	 * for request life cycle.
	 * 
	 * @param t1 -todo
	 * @param authInfo -todo
	 * @return - todo
	 */
	T2 handler(T1 t1, AuthorizationInfo authInfo);
	
	/**
	 * This method does the input validation.
	 * 
	 * @param t1 -todo
	 */
	default void doValidation(T1 t1) {
		
	}
	
	/**
	 * This method tells the request life cycle whether to check for authorization or not.
	 * 
	 * @param authorization -todo
	 */
	public void authorization(boolean authorization) ;
	
}