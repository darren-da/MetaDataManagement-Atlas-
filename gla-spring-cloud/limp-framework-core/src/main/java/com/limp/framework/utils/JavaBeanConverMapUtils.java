package com.limp.framework.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/22 15:43
 * @Description: map相应转换工具类
 */
public class JavaBeanConverMapUtils {

    /**
     *
     * 功能描述:bean 转 map
     *
     * @param: [bean][flag] 为true去除空值
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/10/22 16:00
     */
    
    public static Map<String, Object> bean2Map(Object bean,boolean flag){
        Class type = bean.getClass();
        Map<String, Object> returnMap = new HashMap();
        try{
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (!StrUtils.isBlank(result) && !propertyName.equalsIgnoreCase("pager")) {
                        returnMap.put(propertyName, result);
                    }
                    if(flag){
                    }else{
                        if (!StrUtils.isBlank(result)&& !propertyName.equalsIgnoreCase("pager")) {
                        } else {
                            returnMap.put(propertyName, "");
                        }
                    }
                }
            }
        }catch (Exception e){
            System.err.println("bean转map转换失败!");
        }

        return returnMap;
    }


}
