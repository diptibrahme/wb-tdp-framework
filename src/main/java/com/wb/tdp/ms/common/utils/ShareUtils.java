package com.wb.tdp.ms.common.utils;

import java.util.UUID;

import org.springframework.util.DigestUtils;

/**
 * 
 * @author Panera
 *
 */
public class ShareUtils {

	public final static int maxGUIDWithDashes = 36, maxGUIDWithoutDashes = 32;
	
	
    public static String createGUID(int length, boolean includeDashes) throws IllegalArgumentException { 
        if (length < 1) { 
            throw new IllegalArgumentException("length must be at least 1"); 
        } 
        if (!includeDashes && length > maxGUIDWithoutDashes) { 
            throw new IllegalArgumentException("length must be no more than " + String.valueOf(maxGUIDWithoutDashes)); 
        } else if (includeDashes && length > maxGUIDWithDashes) { 
            throw new IllegalArgumentException("length must be no more than " + String.valueOf(maxGUIDWithDashes)); 
        } 
        String guid = UUID.randomUUID().toString(); 
        if (!includeDashes) { 
            guid = guid.replace("-", ""); 
        } 
        return guid.substring(0, length); 
    }

    /** 
     * Creates a GUID 
     * 
     * @return A 36 character GUID 
     */ 
    public static String createGUID() { 
        return createGUID(maxGUIDWithDashes, true); 
    } 
    /** 
     * Creates a GUID 
     * 
     * @param length The length of the GUID (1-maxGUIDWithDashes) 
     * @return A n character GUID 
     * @throws IllegalArgumentException Exception if the length is out of bounds 
     */ 
    public static String createGUID(int length) throws IllegalArgumentException { 
        return createGUID(length, true); 
    } 
    /** 
     * Creates a GUID 
     * 
     * @param includeDashes Include dashes 
     * @return A 36 character GUID with/without dashes 
     */ 
    public static String createGUID(boolean includeDashes) { 
        return createGUID((includeDashes) ? maxGUIDWithDashes : maxGUIDWithoutDashes, includeDashes); 
    }
    /** 
     * Creates an MD5 hash of the given object bits 
     * 
     * @param bits The bits that will be concatenated into the hash 
     * @return The 32 character MD5 hash 
     */ 
    public static String createMD5Hash(Object... bits) { 
        StringBuilder sb = new StringBuilder(); 
        for (Object bit : bits) { 
            sb.append(bit.toString()); 
        } 
		return DigestUtils.md5DigestAsHex(sb.toString().getBytes()); 
    }


}
