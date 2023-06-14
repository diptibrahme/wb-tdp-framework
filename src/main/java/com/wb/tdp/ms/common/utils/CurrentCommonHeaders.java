package com.wb.tdp.ms.common.utils;

import com.wb.tdp.ms.common.dto.RequestDto;

/**
 * Thread Local containing common headers as part of Request
 * @author anangupt
 *
 */
public class CurrentCommonHeaders {
	
	private static ThreadLocal<RequestDto> threadLocalCommonHeaders = new ThreadLocal<>();

	public static RequestDto get() {
		return threadLocalCommonHeaders.get();
	}

	public static void set(RequestDto requestDto) {
		threadLocalCommonHeaders.set(requestDto);
	}

	public static void clear() {
		threadLocalCommonHeaders.remove();
	}
}
