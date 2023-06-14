package com.wb.tdp.ms.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ApplicationContextWrapper class to get bean injection.
 * This class is adapter for ApplicationContext providing capability to mock it in junit tests without need of loading up spring context.
 * @author HBEG
 *
 */
@Component
public class ApplicationContextWrapper {

	@Autowired
	private ApplicationContext context;
	
	/**
	 * Adapter method to get passed Bean type object wrapping context.getBean method.
	 * To be used where we need to manually inject bean instead of using applicationContext getBean
	 * @param <T> - any type
	 * @param requiredType - holds the requrired type object
	 * @return - it returning the  requiredType object 
	 */
	public <T> T getBean(Class<T> requiredType) {
		return context.getBean(requiredType);
	}
}
