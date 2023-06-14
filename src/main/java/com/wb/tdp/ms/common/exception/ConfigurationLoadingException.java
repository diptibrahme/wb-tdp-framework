package com.wb.tdp.ms.common.exception;
/**
 * This exception is thrown when the application faces some error while loading validation configuaration
 * @author satprasa
 *
 */
public class ConfigurationLoadingException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -4460537230753930153L;
	/**
	 * Class for request bean for which exception occurred
	 */
	private String beanName;
	
	/**
	 * This constructor is used when string and cause are used to report the exception.
	 * @param message - holds the exception message
	 * @param cause - object of Throwable
	 * @param beanName
	 */
	public ConfigurationLoadingException(String message, Throwable cause,String beanName) {
		super(message , cause);
		this.beanName = beanName;
	}

	/**
	 * @return the beanName
	 */
	public String getBeanName() {
		return beanName;
	}

	/**
	 * @param beanName the beanName to set
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
