package com.wb.tdp.ms.common.security;

import java.util.Base64;

import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionBase64 {
	
	/**
	 * @param key String
	 * @return String
	 */
	public static String encryptBase64(String key) {
		
		 String encryptedKey = Base64.getEncoder().encodeToString(key.getBytes()); 
		 return encryptedKey;
	}
}
