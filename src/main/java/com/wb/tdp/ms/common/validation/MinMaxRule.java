package com.wb.tdp.ms.common.validation;

import java.io.Serializable;

import lombok.Data;

/**
 * This class defines Min Max validation rule for a Attribute
 * @author satprasa
 *
 */
@Data
public class MinMaxRule implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 6031203804268026746L;
	/**
	 * Defines min value for min max validation rule
	 */
	private Integer min;
	/**
	 * Defines max value for min max validation rule
	 */
	private Integer max;
	/**
	 * Defines Error Code to be thrown if validation check gets failed
	 */
	private String errorCode;
}
