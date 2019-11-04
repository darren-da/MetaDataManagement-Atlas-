package com.gla.datacenter.utils;

import com.alibaba.fastjson.JSONObject;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.MapUrlUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: admin
 * @Date: 2019/3/28 11:00
 * @Description:
 */
public class RxJavaUtils {

    public static Observable<Map<String, Object>> reloadRxJava(RestTemplate rest, String code, String url, String requestType,
                                                               String apiType, String params){
        Map<String, Object> map = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, Object>> paramMap = new HttpEntity<>(map,headers);
        final String apiUrl = url;
        Observable<Map<String, Object>> ob2 = Observable.create(new ObservableOnSubscribe<Map<String, Object>>(){

            @Override
            public void subscribe(ObservableEmitter<Map<String, Object>> observableEmitter) throws Exception {
                if(apiType.equals("0")){
                    String urls = apiUrl;
                    Map<String, Object> paramsMap = new HashMap<>();
                    ResponseEntity<String> exchange = null;
                    if(StringUtils.isNotBlank(params) && !apiUrl.contains("{")){
                        try{
                            paramsMap = JSONObject.parseObject(params);
                        }catch (Exception e){
                        }
                        urls = apiUrl + "?" + MapUrlUtils.buildMap(paramsMap).substring(0,MapUrlUtils.buildMap(paramsMap).length()-1);
                    }
                    Map<String, Object> result = new HashMap<>();
                    String name = Thread.currentThread().getName();
                    System.err.println(code + "的线程名称:" + name);
                    try{
                        exchange = rest.exchange(urls, HttpMethod.valueOf(requestType), paramMap, String.class, paramsMap);
                        result.put("code",code);
                        result.put("data", Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,exchange.getBody(),null).getResultMap());
                    }catch(Exception e){
                        result.put("code",code);
                        result.put("data","网络请求失败，请检查参数后重试！");
                    }
                    observableEmitter.onNext(result);
                    System.err.println("事件发送成功!");
                    observableEmitter.onComplete();
                }
            }
        }).subscribeOn(Schedulers.io());
        return ob2;
    }
}
