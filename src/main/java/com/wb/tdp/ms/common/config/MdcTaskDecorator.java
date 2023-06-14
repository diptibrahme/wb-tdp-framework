package com.wb.tdp.ms.common.config;

import java.util.Map;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

/**
 * Task Decorator Class to set Web MDC data in asynchronous 
 * thread MDC for logging tracing. 
 * @author anangupt
 *
 */
public class MdcTaskDecorator implements TaskDecorator {

	/**
	 * Current thread logging events
	 */
	  @Override
	  public Runnable decorate(Runnable runnable) {
	    // Get current Web thread context !
	    Map<String, String> contextMap = MDC.getCopyOfContextMap();
	    return () -> {
	      try {
	        // (Set the Web thread context's MDC data to @Async thread context)
	        MDC.setContextMap(contextMap);
	        runnable.run();
	      } finally {
	        MDC.clear();
	      }
	    };
	  }
}
