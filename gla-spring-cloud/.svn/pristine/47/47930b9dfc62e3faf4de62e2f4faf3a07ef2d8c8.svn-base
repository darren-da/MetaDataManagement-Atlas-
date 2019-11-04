package com.limp.framework.boss.utils;

import java.util.*;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 19:31 2018/5/27
 * @modified By:
 */
public class ConvertUtils {
    /**
     * 处理返回数据的格式
     * @param data
     * @return
     */
   public static Object covertResultData(Object data){
       System.out.println("/****************todo covertResultData************/");
       return data;
   }

    /**
     * 方法待修正
     * 接口查询结果集转换成大写以及别名
     *
     * @param result            查询结果集
     * @param serviceAttributes 权限
     * @return 转换后结果集*/


    public static Map<String, Object> convertNameToUpperCase(Map<String, Object> result, Map serviceAttributes) {
       Map<String, Object> resultMap = new HashMap<String, Object>();
        Map<String, String> dimensionMap = null;
       /*  List<UserServiceDimensionMap> metadata = serviceAttributes != null ? ((List) serviceAttributes.getAuthorityBean().getSecurityMap().get("dimension")) : null;
        Map<String, String> dimensionMap = null;
        if (metadata != null) {
            dimensionMap = new HashMap<String, String>();
            for (UserServiceDimensionMap userServiceDimension : metadata) {
                dimensionMap.put(userServiceDimension.getDimensionName(), userServiceDimension.getAlise());
            }
        }*/

        Set<String> layerSet = result.keySet();
        List<Map<String, Object>> tempList = null;
        //外层循环
        for (String key : layerSet) {
            Object obj = result.get(key);
            if (obj instanceof HashMap) {
                resultMap.put(key.toUpperCase(), convertNameToUpperCase((Map<String, Object>) result.get(key), serviceAttributes));
            } else if (obj instanceof List) {
                tempList = new ArrayList<Map<String, Object>>();
                for (Map<String, Object> map : (List<Map<String, Object>>) obj) {
                    Set<String> layerSet1 = map.keySet();
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    for (String key1 : layerSet1) {
                        if (map.get(key1) instanceof HashMap) {
                            tempMap.put(key1.toUpperCase(), convertNameToUpperCase((Map<String, Object>) map.get(key1), serviceAttributes));
                        } else {
                            tempMap.put(dimensionMap!=null&&dimensionMap.size() > 0 && dimensionMap.containsKey(key1)&& dimensionMap.get(key1)!=null ? dimensionMap.get(key1).toUpperCase() : key1.toUpperCase(), map.get(key1)==null?"":map.get(key1));
                        }

                    }
                    tempList.add(tempMap);
                }
                resultMap.put(key.toUpperCase(), tempList);
            } else {
                resultMap.put(key.toUpperCase(), result.get(key));
            }
        }

        return resultMap;

    }

}
