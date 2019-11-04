package com.gla.datacenter.service.impl;

import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.service.RestClient;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.DateUtils;
import com.limp.framework.utils.MapUrlUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/8 19:41
 * @Description:
 */
@Service
public class RestClientImpl implements RestClient {

    private Logger loger = LoggerFactory.getLogger(RestClientImpl.class);

    @Autowired
    private RestTemplate restTemplateApi;

    @Autowired
    private RequestContextHolderUtil requestContextHolderUtil;

    @Override
    public String   httpRequest(Map<String, Object> map, InformationApi informationApi) {

        Map<String, Object> resultMap = new HashMap<>();

        //调用请求
        if(map == null || map.size() <= 0){
            map = new HashMap<>();
        }
        String url = "";
        url = informationApi.getUrl();
        String requestType = ConstantClazz.requestType.get(informationApi.getRequestType());
        ResponseEntity<String> exchange = null;
        HttpHeaders headers = new HttpHeaders();
        if(informationApi.getShareType() == 2){
            String token = ApplicationContextHolder.currentToken();
            headers.add(JwtUtil.HEADER_AUTH,token);
        }
        //if(informationApi.getRequestType() == (byte) 1 && !informationApi.getUrl().contains("{")){
            if(map != null && !map.isEmpty()){
                url = url + "?" + MapUrlUtils.buildMap(map).substring(0,MapUrlUtils.buildMap(map).length()-1);
            }
            //map = new HashMap<>();
            //loger.info("---------------访问接口的url为:" + url);
        //}
        loger.info("---------------访问接口的url为:" + url);
        HttpEntity<Map<String, Object>> paramMap = new HttpEntity<>(map,headers);
        //基本包含所有应用场景
        //try{
            exchange = restTemplateApi.exchange(url, HttpMethod.valueOf(requestType), paramMap, String.class, map);
            loger.info("接口返回结果集:{}",exchange.getBody());
            if("200".equals(String.valueOf(exchange.getStatusCode().value()))){
                resultMap.put("flux",exchange.getBody().toString().getBytes().length);
            }else{
                resultMap.put("flux",0);
            }
            loger.info("接口名称:{}_在{}请求结果返回{}", informationApi.getApiName(),DateUtils.getFormatDate("yyyy-MM-dd HH:mm:ss"),exchange.getBody());
        /*}catch(Exception e){
            e.printStackTrace();
            loger.error("接口名称:{}在{}请求结果返回{}", informationApi.getApiName(), DateUtils.getFormatDate("yyyy-MM-dd HH:mm:ss"),exchange.getBody());
            loger.error("请求错误:" + e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(),"请求失败",null,null).getJson();
        }*/
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,exchange.getBody(),resultMap).getJson();
    }

    /**
     *
     * 功能描述: 代码写的较乱，待优化
     *
     * @param: [map, informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/13 10:16
     */
    
    @Override
    public String fileHttpRequest(Map<String, Object> map, InformationApi informationApi) {
        String token = ApplicationContextHolder.currentToken();
        String fileType = "";
        HttpServletResponse response = requestContextHolderUtil.getResponse();
        HttpHeaders headers = new HttpHeaders();
        InputStream inputStream = null;
        headers.add(JwtUtil.HEADER_AUTH,token);
        ResponseEntity<byte[]> responseResult = restTemplateApi.exchange(
                "http://192.168.26.57:8002/imageCode",
                HttpMethod.GET,
                new HttpEntity<byte[]>(headers),
                byte[].class);
        byte[] result = responseResult.getBody();
        MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
        MediaType contentType = responseResult.getHeaders().getContentType();
        try{
            MimeType jpeg = allTypes.forName(contentType.getType().toString() + "/" + contentType.getSubtype().toString());
            fileType = jpeg.getExtension();
        }catch(Exception e){
            loger.error(e.getMessage());
        }
        inputStream = new ByteArrayInputStream(result);
        OutputStream outputStream = null;
        try {
            inputStream.close();
            outputStream = response.getOutputStream();
            int len = 0;
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            if(StringUtils.isBlank(fileType)){
                fileType = ".doc";
            }
            response.addHeader("Content-Disposition", "attachment;filename=" + System.currentTimeMillis() + fileType);
            response.setContentType("application/octet-stream");
            outputStream.write(buffer);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.ERROR,null,null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,null,null).getJson();
    }

}
