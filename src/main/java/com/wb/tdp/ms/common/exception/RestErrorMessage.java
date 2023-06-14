package com.wb.tdp.ms.common.exception;


import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;
import lombok.Setter;

/**This class is used when there is a HTTP 400 exception from calling the REST API.
 * 
 * @author anangupt
 * 
 * ChangeLog: 
 * 11-05-2019: Husain Beg extending class with ResponseStatusException and added super class constructor.
 *
 *
 */
@Setter @Getter
public class RestErrorMessage extends ResponseStatusException implements Serializable {


	/**
	 * Constructor with a response status.
	 * @param status the HTTP status (required)
	 */
	public RestErrorMessage(HttpStatus status) {
		super(status, null, null);
	}

	/**
	 * Constructor with a response status and a reason to add to the exception
	 * message as explanation.
	 * @param status the HTTP status (required)
	 * @param reason the associated reason (optional)
	 */
	public RestErrorMessage(HttpStatus status, @Nullable String reason) {
		super(status, reason, null);
	}

	/**
	 * Constructor with a response status and a reason to add to the exception
	 * message as explanation, as well as a nested exception.
	 * @param status the HTTP status (required)
	 * @param reason the associated reason (optional)
	 * @param cause a nested exception (optional)
	 */
	public RestErrorMessage(HttpStatus status, @Nullable String reason, @Nullable Throwable cause) {
		super(status, reason, cause);
	}

	/**
	 * Constructor with a response status and a reason to add to the exception
	 * message as explanation, as well as a nested exception, errorCode, errorId and errorLink.
	 * @param status the HTTP status (required)
	 * @param reason the associated reason (optional)
	 * @param cause a nested exception (optional)
	 * @param errorCode Application errorCode to return (optional)
	 */
	public RestErrorMessage(HttpStatus status, @Nullable String reason, 
			@Nullable Throwable cause, String errorCode) {
		super(status, reason, cause);
		this.errorCode = errorCode;
	}
	
	private static final long serialVersionUID = -6432248706702724487L;

	/**
	 * Error code of the response
	 * 
	 */
	private String errorCode;


	/**
	 * Error link of the validation response
	 * 
	 */
	private String errorLink;

	/**
	 * Error id of the validation response.
	 * 
	 */
	private String errorId;

}
