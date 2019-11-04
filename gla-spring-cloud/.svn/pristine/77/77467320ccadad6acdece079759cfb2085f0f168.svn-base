package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.model.ParamModel;
import com.gla.datacenter.service.RestRequestService;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.DateUtils;
import com.limp.framework.utils.MapUrlUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2018/9/27 13:47
 * @Description:
 */
@Service
public class RestRequestServiceImpl implements RestRequestService{

    private Logger loger = LoggerFactory.getLogger(RestRequestServiceImpl.class);


    @Autowired
    private RestTemplate restTemplateCenter;

    @Override
    public String restMethod(Map<String, Object> map, InformationApi informationApi) {

        //调用请求
        if(map == null || map.size() <= 0){
            map = new HashMap<>();
        }
        String url = "";
        url = informationApi.getUrl();
        String requestType = ConstantClazz.requestType.get(informationApi.getRequestType());
        ResponseEntity<String> exchange = null;
        //不能捕获异常
        HttpHeaders headers = new HttpHeaders();
        if(informationApi.getShareType() == 2){
            String token = ApplicationContextHolder.currentToken();
            headers.add(JwtUtil.HEADER_AUTH,token);
        }
        //存放数据流量和状态
        Map<String, Object> param = new HashMap<>();
        //if(informationApi.getRequestType() == (byte) 1 && !informationApi.getUrl().contains("{")){
            if(map != null && !map.isEmpty()){
                url = url + "?" + MapUrlUtils.buildMap(map).substring(0,MapUrlUtils.buildMap(map).length()-1);
                loger.debug("请求url:{}",url);
            }
            //map = new HashMap<>();
            /*MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);*/
        //}
        HttpEntity<Map<String, Object>> paramMap = new HttpEntity<>(map,headers);
        //基本包含所有应用场景

        try {
            exchange = restTemplateCenter.exchange(url,
                    HttpMethod.valueOf(requestType), paramMap, String.class, map);
            loger.info("接口名称:{}在{}请求结果返回{}", informationApi.getApiName(), DateUtils.getFormatDate("yyyy-MM-dd HH:mm:ss"),exchange.getBody());
        } catch (RestClientException e) {
            e.printStackTrace();
            loger.error("接口名称:{}在{}请求结果返回{}", informationApi.getApiName(), DateUtils.getFormatDate("yyyy-MM-dd HH:mm:ss"),exchange.getBody());
            return Result.getInstance(ResultCode.ERROR.toString(),"请求失败",null,null).getJson();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            loger.error("接口名称:{}在{}请求结果返回{}", informationApi.getApiName(), DateUtils.getFormatDate("yyyy-MM-dd HH:mm:ss"),exchange.getBody());
            return Result.getInstance(ResultCode.ERROR.toString(),"请求失败",null,null).getJson();
        }
        if("200".equals(String.valueOf(exchange.getStatusCode().value()))){
            param.put("flux",exchange.getBody().toString().getBytes().length);
        }else{
            param.put("flux",0);
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,exchange.getBody(),param).getJson();

    }

    @Override
    public Result restMethodV0(List<ParamModel> paramResult, InformationApi informationApi) {

        Map<String, Object> maps = new HashMap<>();

        if(paramResult != null && !paramResult.isEmpty()){
            for(ParamModel paramModel : paramResult){
                maps.put(paramModel.getParamKey(),paramModel.getParamValue());
            }
        }
        String url = "";
        url = informationApi.getUrl();
        String requestType = ConstantClazz.requestType.get(informationApi.getRequestType());
        ResponseEntity<Object> exchange = null;
        //不能捕获异常
        HttpHeaders headers = new HttpHeaders();
        if(informationApi.getShareType() == 2){
            String token = ApplicationContextHolder.currentToken();
            headers.add(JwtUtil.HEADER_AUTH,token);
        }
        //存放数据流量和状态
        Map<String, Object> param = new HashMap<>();
        if(informationApi.getRequestType() == (byte) 1 && !informationApi.getUrl().contains("{")){
            if(maps != null && !maps.isEmpty()){
                url = url + "?" + MapUrlUtils.buildMap(maps).substring(0,MapUrlUtils.buildMap(maps).length()-1);
                loger.debug("请求url:{}",url);
            }
            /*maps = new HashMap<>();
            MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
            headers.setContentType(type);*/

            HttpEntity<Map<String, Object>> paramMap = new HttpEntity<>(maps,headers);
            exchange = restTemplateCenter.exchange(url,
                    HttpMethod.valueOf(requestType), paramMap, Object.class, maps);
            System.err.println(exchange.getBody());
        }else{
            //header没有设置
            if(maps != null && !maps.isEmpty()){
                url = url + "?" + MapUrlUtils.buildMap(maps).substring(0,MapUrlUtils.buildMap(maps).length()-1);
                loger.debug("请求url:{}",url);
            }else{
                maps = new HashMap<>();
            }
            HttpEntity<Map<String, Object>> paramMap = new HttpEntity<>(maps,headers);
            //基本包含所有应用场景
            exchange = restTemplateCenter.exchange(url,
                    HttpMethod.valueOf(requestType), paramMap, Object.class, maps);
        }

        loger.debug(TextUtils.format(informationApi.getApiCode() +"访问返回结果集为:{}",exchange.getBody()));
        if("200".equals(exchange.getStatusCode())){
            param.put("flux",exchange.getBody().toString().getBytes().length);
        }else{
            param.put("flux",0);
        }
        param.put("code",exchange.getStatusCode());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,exchange.getBody(),param);
    }

}
