package com.wb.tdp.ms.common.exception;


/**This class is used when there is a issue in loading resource file..
 * 
 * @author anangupt
 *
 */

public class PropertyFileLoadingException extends RuntimeException {


	private static final long serialVersionUID = -4460537230753930153L;

	/** This constructor is used when string and cause are used to report the exception.
	* @param message - holds the exception message
	 * @param cause - object of Throwable
	 */
	public PropertyFileLoadingException(String message, Throwable cause) {
		super(message , cause);
	}

	/**
	 * This constructor is used when string and cause are used to report the
	 * exception.
	 * 
	 * @param message - holds the exception message
	 */
	public PropertyFileLoadingException(String message) {
		super(message);
	}

	/**
	 * This constructor is used when only cause is used to report the exception.
	 * 
	 * @param cause -object of Throwable
	 */
	public PropertyFileLoadingException(Throwable cause) {
		super(cause);
	}


}
