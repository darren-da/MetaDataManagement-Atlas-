package com.limp.framework.utils;

import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;


public class ReflectionUtils {

    public static Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
        Class<?> searchType = clazz;
        while (searchType != null) {
            Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods());
            for (Method method : methods) {
                if (name.equals(method.getName())
                        && (paramTypes == null || Arrays.equals(paramTypes, method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    public static Object invokeMethod(Method method, Object target, Object... args) {
        try {
            return method.invoke(target, args);
        } catch (Exception ex) {
            throw new IllegalStateException(new MessageFormat("can't invoke method : {0}.{1}({2})").format(new Object[]{target, method, args}));
        }
    }
}
