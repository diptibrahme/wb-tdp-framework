package com.wb.tdp.ms.common.validation;

import java.io.Serializable;

import lombok.Data;

/**
 * For validating Enums via common framework
 * Usage:
 * enumTypeRule: {
 * 	"errorCode":"",
 * 	"enumClass":"AddressType",
 *  "ignoreCase":"false"
 * }
 */
@Data
public class EnumTypeRule implements Serializable {
	
	private String errorCode;

	private String enumClass;
	
	private boolean ignoreCase;
	
}