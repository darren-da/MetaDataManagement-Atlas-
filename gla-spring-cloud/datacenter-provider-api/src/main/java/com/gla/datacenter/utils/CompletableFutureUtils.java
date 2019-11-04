package com.gla.datacenter.utils;

import com.alibaba.fastjson.JSONObject;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.MapUrlUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/3/29 11:12
 * @Description:
 */
public class CompletableFutureUtils {

    public static Map<String, Object> reloadHttp(RestTemplate rest, String code, String url, String requestType,
                                                 String apiType, String params){
        Map<String, Object> map = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        Map<String, Object> result = new HashMap<>();
        HttpEntity<Map<String, Object>> paramMap = new HttpEntity<>(map,headers);
        if(apiType.equals("0")){
            Map<String, Object> paramsMap = new HashMap<>();
            ResponseEntity<String> exchange = null;
            if(StringUtils.isNotBlank(params) /*&& !url.contains("{")*/){
                try{
                    paramsMap = JSONObject.parseObject(params);
                }catch (Exception e){
                }
                url = url + "?" + MapUrlUtils.buildMap(paramsMap).substring(0,MapUrlUtils.buildMap(paramsMap).length()-1);
            }
            String name = Thread.currentThread().getName();
            System.err.println(code + "的线程名称:" + name);
            try{
                exchange = rest.exchange(url, HttpMethod.valueOf(requestType), paramMap, String.class, paramsMap);
                System.err.println(code + "返回结果时间:" + new Date());
                result.put("code",code);
                //result.put("data", Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,exchange.getBody(),null).getResultMap());
                result.put("data",exchange.getBody());
            }catch(Exception e){
                result.put("code",code);
                result.put("data","网络请求失败，请检查参数后重试！");
            }
        }
        return result;
    }


}
