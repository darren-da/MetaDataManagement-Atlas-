package com.limp.framework.utils;

import java.util.List;

/**
 * @author:shinians email:shiniandate@163.com
 * @description: www.shinians.com
 * @date:Created in 15:26 2018/5/25
 * @modified By:
 */
public class LPUtils {
    private static String WINDOWS = "WINDOWS";
    private static String LINUX = "LINUX";

    public static String getSystemType() {
        String type = System.getProperties().getProperty("os.name");
        if (type.startsWith("Win")) {
            return WINDOWS;
        } else {
            return LINUX;
        }
    }

    /**
     * 转换类型：类反射参数类型
     * @param type
     * @return
     */
    public static Class<?> getClass(String type){
        if(StrUtils.isBlank(type)){
            return null;
        }
        if("String".equals(type)){
            return String.class;
        }
        if("String[]".equals(type)){
            return List.class;
        }
        else if("int".equals(type)){
            return int.class;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getSystemType());
    }

}
