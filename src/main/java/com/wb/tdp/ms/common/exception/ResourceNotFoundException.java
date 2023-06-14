package com.wb.tdp.ms.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * This exception is thrown whenever a resource is not available
 * @author satprasa
 *
 */
@Setter
@Getter
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6437199107326301638L;
	/**
	 * Error code for message text
	 */
	private String errorCode;
	/**
	 * Args for message text place holder
	 */
	private Object[] args;
	
	/**
	 * Construct an Exception with message.
	 * @param errorCode
	 * @param message
	 * @param args
	 */
	public ResourceNotFoundException(String errorCode, String message, Object[] args) {
		super(message);
		this.errorCode = errorCode;
		this.args = args;
	}

}
