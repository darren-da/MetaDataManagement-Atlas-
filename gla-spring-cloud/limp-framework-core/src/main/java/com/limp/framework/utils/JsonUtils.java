package com.limp.framework.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.limp.framework.core.bean.TimestampTypeAdapter;
import com.limp.framework.core.service.CoreService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-6-29
 * Time: 下午11:17
 * To change this template use File | Settings | File Templates.
 */
public class JsonUtils {
    /**
     * 将map转化为json
     * @param map
     * @return
     */
    public static String toJson(HashMap<String,Object> map){
        Gson gson=new Gson();
        return gson.toJson(map);
    }

    /**
     *
     * @param obj
     * @return
     */
    public static String getJson(Object obj) {
        if (StrUtils.isBlank(obj)) {
            return null;
        }
        //定义返回JSON字符串
        String returnJson = "";
        SerializeConfig ser = new SerializeConfig();
        ser.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd  HH:mm:ss"));
        try {
            /*
            1、格式化时间
             2、禁止循环
             3、fastjson将bean转成字符串时首字母变小写问题：方案在bean的属性get方法上加注解 @JSONField(name = "RC2") public String getRC2() return RC2;
             */
            returnJson = JSON.toJSONString(obj, ser, SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return returnJson;
    }


    /**
     * 字符串转换map格式
     * @param jsonStr
     * @return
     */
    public static Map convertJsonStrToMap(String jsonStr){
        Map<String, Object> map = JSON.parseObject(
                jsonStr,new TypeReference<Map<String, Object>>(){} );
        return map;
    }

    /**
     *json转化为数据
     * @param jsonStr json字符串
     * @return list集合
     */
    public static List convertJsonStrToArray(String jsonStr){
        return JSON.parseArray(jsonStr, Map.class);
    }

    /**
     * Object 转化为Json
     * @param obj
     * @return Json字符串
     */
    public static String toJson(Object obj){
        Gson gson=new Gson();
        return gson.toJson(obj);
    }

    public static String toDefultJson(Object obj){
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        return gson.toJson(obj);
    }


}
