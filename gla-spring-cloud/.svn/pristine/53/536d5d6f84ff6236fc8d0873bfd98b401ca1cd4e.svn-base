package com.limp.framework.boss.controller;

import com.limp.framework.auth.AuthUtils;
import org.xidea.el.json.JSONDecoder;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/10 19:56
 */
public class test {
    public static void main(String[] args) {
        String data="{1:{name:'zs'},2:{name:'lise'}}";
        Map<String, Object> _data = (Map<String, Object>) JSONDecoder.decode(data);

        Map<String, Object> data2 = (Map<String, Object>)_data.get("1");

        System.out.println(_data);
        System.out.println(data2.get("name"));
//        AuthUtils.base64StrToByte()

        /*************************动态加载jar*****************************/
        URL[] urls = new URL[] {};
        MyClassLoader classLoader = new MyClassLoader(urls, null);

        try {
            classLoader.addJar(new File("C:\\datacenter\\boss-jar\\limp-framework-core-2.0-SNAPSHOT.jar").toURI().toURL());
            Class<?> clazz = classLoader.loadClass("com.limp.framework.utils.StrUtils");
            Method method = clazz.getDeclaredMethod("getOrderNo");
            System.out.println( method.invoke(null));
            classLoader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class MyClassLoader extends URLClassLoader {

        public MyClassLoader(URL[] urls) {
            super(urls);
        }

        public MyClassLoader(URL[] urls, ClassLoader parent) {
            super(urls, parent);
        }

        public void addJar(URL url) {
            this.addURL(url);
        }

    }

}
