package com.limp.framework.utils;


/**
 *
 * 功能描述: 打印异常工具类
 *
 * @param:
 * @return: 
 * @auther: zhangbo
 * @date: 2018/11/6 17:53
 */

public class PrintExceptionUtils {
	
	public static String getException(Exception e) {
		String str = "";
		StackTraceElement[] stackTrace = e.getStackTrace();
		for(StackTraceElement stackTraceElement : stackTrace) {
			String methodName = stackTraceElement.getMethodName();
			String className = stackTraceElement.getClassName();
			str += "异常类:"+className + ",异常方法:" + methodName + "异常类型:"  + e;
		}
		return str;
	}
	
}
