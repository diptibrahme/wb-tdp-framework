package com.wb.tdp.ms.common.utils;

/**
 * Every request is grouped by CorrelationID used to identify request flow in distributed service calls.
 * This class holds correlationId during request lifecylce for it to available as part of API communication flow - synchronous or asynchronous.
 * @author hbeg
 *
 */
public class CurrentCorrelationId {
	
	private static ThreadLocal<String> threadLocalCorrelationId = new ThreadLocal<String>();

	public static String get() {
		return threadLocalCorrelationId.get();
	}

	public static void set(String tenantId) {
		threadLocalCorrelationId.set(tenantId);
	}

	public static void clear() {
		threadLocalCorrelationId.remove();
	}
}
