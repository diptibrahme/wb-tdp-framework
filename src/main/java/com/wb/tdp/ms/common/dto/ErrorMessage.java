package com.wb.tdp.ms.common.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Class used to encapsulate the message String , type and summary. Which will
 * display to user as a warning, success and error.
 * 
 * @author anangupt
 *
 */
@NoArgsConstructor 
@AllArgsConstructor
public class ErrorMessage implements Serializable {

	private static final long serialVersionUID = 8032118104883700919L;

	/**
	 * Error code of the response
	 * 
	 */
	private String errorCode;

	/**
	 * Error cause.
	 * 
	 */
	private String errorType;
	
	/**
	 * Error Message.
	 * 
	 */
	private String errorMessage;

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

	/**
	 * Parameterized constructor.
	 * 
	 * @param builder - builder object contains list of properties errorCode,  errorType, errorLink, errorId
	 
	 */
	public ErrorMessage(Builder builder) {
		super();
		this.errorCode = builder.getErrorCode();
		this.errorType = builder.getErrorType();
		this.errorLink = builder.getErrorLink();
		this.errorId = builder.getErrorId();
		this.errorMessage = builder.getErrorMessage();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorType() {
		return errorType;
	}

	public String getErrorLink() {
		return errorLink;
	}

	public String getErrorId() {
		return errorId;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}



	/**
	 * build and return the exception object.
	 * 
	 * @author anangupt
	 *
	 */
	public static class Builder {

		/**
		 * Error code of the response
		 * 
		 */
		private String errorCode;

		/**
		 * Error cause.
		 * 
		 */
		private String errorType;
		
		/**
		 * Error cause.
		 * 
		 */
		private String errorMessage;

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

		public Builder() {
		}

		public ErrorMessage build() {
			return new ErrorMessage(this);
		}
		
		public Builder errorCode(String errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder errorType(String errorType) {
			this.errorType = errorType;
			return this;
		}
		
		public Builder errorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
			return this;
		}

		public Builder errorLink(String errorLink) {
			this.errorLink = errorLink;
			return this;
		}

		public Builder errorId(String errorId) {
			this.errorId = errorId;
			return this;
		}

		public String getErrorCode() {
			return errorCode;
		}

		public String getErrorType() {
			return errorType;
		}

		public void setErrorType(String errorType) {
			this.errorType = errorType;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public String getErrorLink() {
			return errorLink;
		}
		public String getErrorId() {
			return errorId;
		}



	}

}
