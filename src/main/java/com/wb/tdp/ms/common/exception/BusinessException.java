package com.wb.tdp.ms.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * This exception is thrown whenever a business exception occurs, i.e. an exception when performing
 * an operation in the business validation.
 * @author HBEG
 *
 */
@Setter
@Getter
public class BusinessException extends RuntimeException {

    /**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6437199107326301638L;
    /**
	 * Error Code for exception
	 */
	private String errorCode;
	/**
	 * args - holds the array of object type
	 */
	private Object[] args;
	/**
	 * Parameterized constructor
	 * @param message
	 */
	private BusinessException(final String message) {
		super(message);
	}
	/**
	 * Parameterized constructor
	 * @param message
	 * @param cause
	 */
	private BusinessException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameterized constructor
	 * @param errorCode errorCode associated with ErrorType
	 * @param message The description of the exception.
	 */
	private BusinessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Parameterized constructor
	 * @param errorCode - errorCode associated with ErrorType
	 * @param message - the description of the exception.
	 * @param args - holds the array of object type
	 */
	public BusinessException(String errorCode, String message, Object[] args) {
		super(message);
		this.errorCode = errorCode;
		this.args = args;
	}
	
	/**
	 * Construct an Exception with message.
	 * @param message The description of the exception.
	 * @return An instance of the Exception.
	 */
	public static BusinessException getInstance(final String message) {
		return new BusinessException(message);
	}

	/**
	 * Construct an Exception with message and cause.
	 * @param message The description of the exception.
	 * @param cause   The cause of the exception.
	 * @return An instance of the Exception.
	 */
	public static BusinessException getInstance(final String message, final Throwable cause) {
		return new BusinessException(message, cause);
	}
	
	/**
	 * Construct an Exception with message and errorCode.
	 * @param errorCode The errorCode related to exception.
	 * @param message  The description cause of the exception.
	 * @return An instance of the Exception.
	 */
	public static BusinessException getInstance(final String errorCode, final String message) {
		return new BusinessException(errorCode, message);
	}
	
}
