package com.wb.tdp.ms.common.validation;

import java.io.Serializable;

import com.wb.tdp.ms.common.security.DecryptionBase64;

import lombok.Data;

/**
 * This class defines Pattern Matching validation rule for a Attribute
 * @author satprasa
 *
 */
@Data
public class PatternMatchingRule implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7596361485158186237L;
	
	/**
	 * Defines base64 encrypted regex pattern validation rule
	 */
	private String pattern;
	/**
	 * Defines Error Code to be thrown if validation check gets failed
	 */
	private String errorCode;

	/**
	 * This method decrypts regex pattern rule which is base 64 encripted
	 * @return the pattern
	 */
	public String getPatternDecrypt() {
		return DecryptionBase64.decryptBase64(pattern);
	}
}
