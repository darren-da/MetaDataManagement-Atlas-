package com.limp.framework.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: zhangzenghuan
 * Date: 15-8-24
 * Time: 上午9:20
 *
 * @author zhangzenghuan
 */
public class SysStoreUtil {

    private static final Properties PROPERTIES = new Properties();
        static {
            try {
                InputStream inputStream = StoreControl.class.getClassLoader().getResourceAsStream("com/limp/framework/utils/resources.properties");
                PROPERTIES.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getDirPath(String key){
            return (String)PROPERTIES.get(key);
        }

        public static String getValue(String key){
            return (String)PROPERTIES.get(key);
        }

    public static void main(String[] args) {
        System.out.println(SysStoreUtil.getValue("user.img.url"));
    }
  }


