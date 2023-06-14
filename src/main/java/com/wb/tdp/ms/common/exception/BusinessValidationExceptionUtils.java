/**
 * 
 */
package com.wb.tdp.ms.common.exception;

import com.wb.tdp.ms.common.dto.BusinessValidationExceptionBuilder;
import com.wb.tdp.ms.common.validation.MessageType;

/**
 * @author anangupt
 *
 */

public class BusinessValidationExceptionUtils {
	
	
	private static BusinessValidationExceptionUtils businessValidationExceptionUtils;
	  
	private BusinessValidationExceptionUtils() {
		if (businessValidationExceptionUtils != null) {
			throw new AssertionError();
		}
	}
	  
	/**
	 * Singleton get instance method
	 * 
	 * @return validationUtils
	 */
	public static synchronized BusinessValidationExceptionUtils getInstance() {
		if (businessValidationExceptionUtils == null) {
			businessValidationExceptionUtils = new BusinessValidationExceptionUtils();
		}
		return businessValidationExceptionUtils;
	}
			 
	
	/**
	 * This method build the BusinessValidationException and through it.
	 * 
	 * @param errorCode String
	 * @param fieldName String
	 * @param errorType MessageType
	 */
	public BusinessValidationException buildBusinessValidationExecption(String errorCode, String fieldName, 
					MessageType errorType) {
		BusinessValidationExceptionBuilder.Builder error = new BusinessValidationExceptionBuilder.Builder();
		return error.errorCode(errorCode).fieldName(fieldName)
				.errorType(errorType).build();
	}

	/**
	 * This method build the BusinessValidationException and through it.
	 * 
	 * @param errorCode String
	 * @param errorType MessageType
	 */
	public BusinessValidationException buildBusinessValidationExecption(String errorCode, MessageType errorType) {
		BusinessValidationExceptionBuilder.Builder error = new BusinessValidationExceptionBuilder.Builder();
		return error.errorCode(errorCode).errorType(errorType).build();
	}
	
	/**
	 * This method build the BusinessValidationException and through it.
	 * 
	 * @param errorCode String
	 * @param fieldName String
	 * @param errorType MessageType
	 * @param args Object[]
	 */
	public BusinessValidationException buildBusinessValidationExecption(String errorCode, String fieldName, 
			MessageType errorType,Object[] args) {
		BusinessValidationExceptionBuilder.Builder error = new BusinessValidationExceptionBuilder.Builder();
		return error.errorCode(errorCode).fieldName(fieldName).errorType(errorType).args(args).build();
	}
	
	/**
	 * @return
	 */
	protected Object readResolve() {
	    return getInstance();
	}

}
