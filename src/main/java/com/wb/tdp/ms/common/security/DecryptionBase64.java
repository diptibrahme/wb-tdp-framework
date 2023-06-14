package com.wb.tdp.ms.common.security;

import java.util.Base64;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DecryptionBase64 {
	
	/**
	 * @param encodedKey String
	 * @return String
	 */
	public static String decryptBase64(String encodedKey) {
		
		byte[] actualByte = Base64.getDecoder().decode(encodedKey);
		String decodedKey = new String(actualByte); 
		
		return decodedKey;
	} 

}
