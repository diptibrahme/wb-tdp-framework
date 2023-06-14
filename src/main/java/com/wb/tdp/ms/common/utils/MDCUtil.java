package com.wb.tdp.ms.common.utils;

import java.util.HashMap;
import java.util.Set;

import org.slf4j.MDC;

/**
 * Util class to add and remove sl4j MDC attribute. 
 * @author satprasa: Capgemini
 *
 */
public class MDCUtil {
	
	public void addMDCAttributes(HashMap<String,String> map) {
		if(map != null) {
			map.forEach((k,v) ->{
				MDC.put(k, v);
			});
		}
	}
	
	public void removeMDCAttributes(Set<String> set) {
		if(set != null) {
			set.forEach((k) ->{
				MDC.remove(k);
			});
		}
	}
}
