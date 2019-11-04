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
public class StoreControl {

    private static final Properties PROPERTIES = new Properties();
        static {
            try {
                //TODO 注意路径
                InputStream inputStream = StoreControl.class.getClassLoader().getResourceAsStream("store.properties");
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

    }


