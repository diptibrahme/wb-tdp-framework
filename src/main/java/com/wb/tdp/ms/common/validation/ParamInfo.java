package com.wb.tdp.ms.common.validation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**Stores the information of a parameter used in Message.
 * 
 * @author anangupt
 *
 */
@Data
public class ParamInfo implements Serializable {
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -3419650297382560317L;
	/**
	 * Used to hold the value of message.
	 */
	private String value;

	/**
	 * Used to hold the value of key.
	 */
	private String key;
	/**
	 * Used to hold the value of list key. 
	 */
	private List<String> keys = new ArrayList<>(1);
	/**
	 * Used to hold the value of list which will not picked from Resource bundle,
	 *  i.e., Constant values, which will showed as comma separated. 
	 */
	private List<String> values = new ArrayList<String>(1);
	/**
	 * Parameterized constructor
	 * @param key
	 * @param value
	 */
	public ParamInfo(String key, String value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * Parameterized constructor
	 * @param value
	 */
	public ParamInfo( String value ) {
		this.value = value;
	}
	/**
	 * Parameterized constructor
	 * @param values
	 */
	public ParamInfo(List<String> values ) {
		this.values = values;
	}
	/**
	 * default constructor
	 */
	public ParamInfo() {
	}
}
