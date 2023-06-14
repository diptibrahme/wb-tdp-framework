package com.wb.tdp.ms.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class ReflectionUtil {
	public static String getAttributeClassName(String className, String property) throws ClassNotFoundException {
		Field[] fields = Class.forName(className).getDeclaredFields();
		for(Field field : fields) {
			if(field.getName().equals(property)) {
				if(field.getGenericType() instanceof ParameterizedType) {
					ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
					className = parameterizedType.getActualTypeArguments()[0].getTypeName();
				}else {
					className =  field.getType().getName();
				}
			}
		}
		return className;
	}
}
