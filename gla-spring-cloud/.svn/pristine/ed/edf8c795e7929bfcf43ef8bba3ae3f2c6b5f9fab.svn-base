package com.limp.framework.utils;



import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/29 18:52
 * @Description:
 */
public class MapUrlUtils {


    public static String buildMap(Map<String, Object> map) {
        StringBuffer sb = new StringBuffer();
        if (map.size() > 0) {
            for (String key : map.keySet()) {
                sb.append(key + "=");
                if (StrUtils.isBlank(map.get(key))) {
                    sb.append("&");
                } else {
                    String value = String.valueOf(map.get(key));
                    try {
                        value = URLEncoder.encode(value, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    sb.append(value + "&");
                }
            }
        }
        return sb.toString();
    }

}

