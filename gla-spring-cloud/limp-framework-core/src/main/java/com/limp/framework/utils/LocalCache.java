package com.limp.framework.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 17-1-21
 * Time: 下午4:02
 * To change this template use File | Settings | File Templates.
 */
public class LocalCache {

    public static final Integer CACHE_NUM=800;

    public static Map<String,Object> cache=new HashMap<String, Object>();

    public static  Map<String,Object>  cacheMap(){
        return cache;
    }

    /**
     * 添加
     * @param key
     * @param obj
     */
    public static void add(String key,Object obj){
        if(cache.size()<CACHE_NUM){
            cache.put(key,obj);
        } else{
            cache.clear();
        }
    }
    public static boolean contain(String key){
        if(cache.containsKey(key)){
            return true;
        }
        return false;
    }
    public static Object get(String key){
        return cache.get(key);
    }
}
