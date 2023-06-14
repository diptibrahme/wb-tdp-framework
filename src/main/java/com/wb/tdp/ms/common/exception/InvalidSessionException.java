package com.wb.tdp.ms.common.exception;


import java.util.List;

import com.wb.tdp.ms.common.validation.ErrorMessage;

/**This class is used when there is no valid session for the user.
 * 
 * @author anangupt
 *
 */

public class InvalidSessionException extends RuntimeException {

	private static final long serialVersionUID = 3297560633698602201L;
	
	private final  List<ErrorMessage> errorMessage;
	
	/**This constructor is used when only errorMessage are used to report the exception.
	 * 
	 * @param errorMessage - list of ErrorMessage
	 */
	
	public InvalidSessionException(List<ErrorMessage> errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	/** This constructor is used when string and cause are used to report the exception.
	 * 
	 * @param message - holds the exception message
	 * @param cause - object of Throwable
	 */
	public InvalidSessionException(String message, Throwable cause) {
		super(message , cause);
		errorMessage = null;
	}
	
   /** This constructor is used when only cause is used to report the exception.
    * 
    * @param cause - object of Throwable
    */
	public InvalidSessionException(Throwable cause) {
		super(cause);
		errorMessage = null;
	}

	public List<ErrorMessage> getErrorMessage() {
		return errorMessage;
	}
	
}
