package com.wb.tdp.ms.common.exception;


import com.wb.tdp.ms.common.validation.Message;

/**This exception is thrown when the input criteria is not met or there is a issue 
 * in issue in input is provided to process. The main use of this class is in request
 * validation.
 * 
 * @author anangupt
 *
 */
public class ValidationException extends RuntimeException {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 890807732883576355L;
	/**
	 * Hold the message object which is raised while validation.
	 */
	private final Message messages;

	/**
	 * Parameterized constructor
	 * @param message The description of the exception.
	 */
	public ValidationException(Message message) {
		super();
		this.messages = message;
	}

	public Message getMessages() {
		return messages;
	}


	
}
