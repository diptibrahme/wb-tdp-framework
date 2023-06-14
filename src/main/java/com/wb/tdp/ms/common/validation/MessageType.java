package com.wb.tdp.ms.common.validation;
/**
 * Enum to hold all available message types
 * @author satprasa
 *
 */
public enum MessageType {
    /**
     * Constant to indicate that the  type of the message is Error
     */
    ERROR("ERROR"),
    /**
     * Constant to indicate that the  type of the message is Warning
     */
    WARNING("WARNING"),
    /**
     * Constant to indicate that the type of the message is Information
     */
    INFO("INFO"),
    /**
     * Constant to indicate that type of message is Confirmation
     */
    CONFIRMATION("CONFIRMATION");
	
	
	/**
	 * Hold the constant property.
	 */
	private String val;

	MessageType(String val){
		this.val = val;
	}
	
	public String getVal() {
		return this.val.toString();
	}

}
