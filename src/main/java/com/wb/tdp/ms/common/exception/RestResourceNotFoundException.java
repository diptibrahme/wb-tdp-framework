package com.wb.tdp.ms.common.exception;

import com.wb.tdp.ms.common.validation.Message;

/**This exception is thrown when the Resource does not exits in the data base. 
 * 
 * @author anangupt
 *
 */
public class RestResourceNotFoundException extends RuntimeException {


	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -6554422973738537404L;
	
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
	public RestResourceNotFoundException(Message message, String language) {
		super();
		this.messages = message;
		this.language = language;
	}
	
	public RestResourceNotFoundException(Message message) {
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
