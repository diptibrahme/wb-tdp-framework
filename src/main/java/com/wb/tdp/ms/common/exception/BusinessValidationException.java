package com.wb.tdp.ms.common.exception;

import com.wb.tdp.ms.common.validation.Message;

/**This exception is thrown when the input criteria is not met or there is a issue 
 * in issue in input is provided to process. The main use of this class is in request
 * validation.
 * 
 * @author anangupt
 *
 */
public class BusinessValidationException extends RuntimeException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -56558604243935434L;
	
	/**
	 * Hold the message object which is raised while validation.
	 * 
	 */

	private Message messages;
	
	private String language;

	/**
	 * Parameterized constructor
	 * @param message
	 * @param language
	 */
	public BusinessValidationException(Message message, String language) {
		super();
		this.messages = message;
		this.language = language;
	}
	
	public BusinessValidationException(Message message) {
		super();
		this.messages = message;
	}

	public Message getMessages() {
		return messages;
	}

	public String getLanguage() {
		return language;
	}

 

	
}
