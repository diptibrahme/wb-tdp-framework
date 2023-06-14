package com.wb.tdp.ms.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * This exception is thrown whenever a system exception occurs, i.e. an exception when performing
 * an operation to invoke or call third party or remote server operation.
 * @author jaireddy
 *
 */
@Setter
@Getter
public class SystemException extends RuntimeException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4462736229055600723L;

	/**
	 * Error code for message text
	 */
	private String errorCode;
	/**
	 * Args for message text place holder
	 */
	private Object[] args;
	
	/**
	 * Parameterized constructor
	 * @param message The description of the exception.
	 */
	private SystemException(final String message) {
		super(message);
	}

	/**
	 * Parameterized constructor
	 * @param message The description of the exception.
	 * @param cause
	 */
	private SystemException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Parameterized constructor
	 * @param errorCode errorCode associated with ErrorType
	 * @param message The description of the exception.
	 */
	private SystemException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * Parameterized constructor
	 * @param errorCode - errorCode associated with ErrorType
	 * @param message - the description of the exception.
	 * @param args - holds the array of object type
	 */
	public SystemException(String errorCode, String message, Object[] args) {
		super(message);
		this.errorCode = errorCode;
		this.args = args;
	}
	
	/**
	 * Construct an Exception with message.
	 *
	 * @param message The description of the exception.
	 * @return An instance of the Exception.
	 */
	public static SystemException getInstance(final String message) {
		return new SystemException(message);
	}

	/**
	 * Construct an Exception with message and cause.
	 *
	 * @param message The description of the exception.
	 * @param cause   The cause of the exception.
	 * @return An instance of the Exception.
	 */
	public static SystemException getInstance(final String message, final Throwable cause) {
		return new SystemException(message, cause);
	}
	
	/**
	 * Construct an Exception with message and errorCode.
	 *
	 * @param errorCode The errorCode related to exception.
	 * @param message  The description cause of the exception.
	 * @return An instance of the Exception.
	 */
	public static SystemException getInstance(final String errorCode, final String message) {
		return new SystemException(errorCode, message);
	}
	
}
