package com.wb.tdp.ms.common.validation;

import java.io.Serializable;

import lombok.Data;

/**
 * This class defines Mandatory validation rule for a Attribute
 * @author satprasa
 *
 */
@Data
public class MandatoryRule implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -326405999164144110L;
	/**
	 * Defines web access channels for which attribute is mandatory
	 */
	private String mandatoryChannels;
	/**
	 * Defines Error Code to be thrown if mandatory check gets failed
	 */
	private String errorCode;
}
