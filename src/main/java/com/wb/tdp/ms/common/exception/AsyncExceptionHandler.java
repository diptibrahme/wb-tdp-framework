package com.wb.tdp.ms.common.exception;

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class AsyncExceptionHandler.
 */
@Slf4j
@NoArgsConstructor
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

	/**
	 * Handle uncaught exception.
	 *
	 * @param throwable the throwable
	 * @param method the method
	 * @param obj the obj
	 */
	@Override
	public void handleUncaughtException(final Throwable throwable, final Method method, 
			final Object... obj) {
		log.error("Exception message - " + throwable.getMessage());
		log.error("Method name - " + method.getName());
		for (final Object param : obj) {
			log.error("Param - " + param);
		}
	}

}
