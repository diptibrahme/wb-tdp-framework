package com.wb.tdp.ms.common.exception;

/**
 * This class lists out the constants to be used.
 * @author anangupt
 *
 */
public enum ErrorCodeConstant {

	E00001("E00001");
	
	private String value;

	ErrorCodeConstant(String val) {
		this.value = val;
	}


	public String val() {
		return value;
	}}
