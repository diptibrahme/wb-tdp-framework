package com.wb.tdp.ms.common.dto;


import java.io.Serializable;

import com.wb.tdp.ms.common.validation.Message;
import com.wb.tdp.ms.common.validation.MessageData;
import com.wb.tdp.ms.common.validation.MessageType;
import com.wb.tdp.ms.common.exception.BusinessValidationException;

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
public class BusinessValidationExceptionBuilder implements Serializable {

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
	private String fieldName;
	
	/**
	 * Error Message.
	 * 
	 */
	private MessageType errorType;
	
	private Object[] args;

	public BusinessValidationExceptionBuilder(Builder builder) {
		super();
		this.errorCode = builder.getErrorCode();
		this.errorType = builder.getErrorType();
		this.fieldName = builder.getfieldName();
		this.args=builder.getArgs();
	}

	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public MessageType getErrorType() {
		return errorType;
	}

	public void setErrorType(MessageType erroType) {
		this.errorType = erroType;
	}

	/**
	 * @return the args
	 */
	public Object[] getArgs() {
		return args;
	}

	/**
	 * @param args the args to set
	 */
	public void setArgs(Object[] args) {
		this.args = args;
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
		private MessageType errorType;
		
		/**
		 * Error cause.
		 * 
		 */
		private String fieldName;
		
		private Object[] args;

		public Builder() {
		}

		public BusinessValidationException build() {
			
			Message message = new Message();
			MessageData messageData = new MessageData(fieldName,errorCode,errorType,args);
			message.addMessage(messageData);
			return new BusinessValidationException(message);
		}
		
		public Builder errorCode(String errorCode) {
			this.errorCode = errorCode;
			return this;
		}

		public Builder errorType(MessageType errorType) {
			this.errorType = errorType;
			return this;
		}
		
		public Builder fieldName(String fieldName) {
			this.fieldName = fieldName;
			return this;
		}
		
		public Builder args(Object[] args) {
			this.args = args;
			return this;
		}

		public String getErrorCode() {
			return errorCode;
		}
		
		public String getfieldName() {
			return fieldName;
		}


		public MessageType getErrorType() {
			return errorType;
		}

		public void setErrorType(MessageType errorType) {
			this.errorType = errorType;
		}

		/**
		 * @return the fieldName
		 */
		public String getFieldName() {
			return fieldName;
		}

		/**
		 * @param fieldName the fieldName to set
		 */
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		/**
		 * @return the args
		 */
		public Object[] getArgs() {
			return args;
		}

		/**
		 * @param args the args to set
		 */
		public void setArgs(Object[] args) {
			this.args = args;
		}

		/**
		 * @param errorCode the errorCode to set
		 */
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		

	}

}
