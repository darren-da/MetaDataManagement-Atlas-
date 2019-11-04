package com.gla.datacenter.service.impl;

import com.gla.datacenter.core.utils.WSDLUtils;
import com.gla.datacenter.core.utils.XMLTextToFile;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.ParmsApi;
import com.gla.datacenter.model.ParamModel;
import com.gla.datacenter.service.SoapWebserviceClient;
import com.limp.framework.auth.AuthUtils;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2018/11/20 10:22
 * @Description:
 */

@Service
public class SoapWebserviceClientImpl implements SoapWebserviceClient {
    @Override
    public String cxfMethod(Map<String, Object> maps, InformationApi informationApi, List<ParmsApi> shamParms) {
        Object[] obj = new Object[shamParms.size()];
        String url = informationApi.getUrl();
        String method = informationApi.getMethod();
        if(shamParms != null && !shamParms.isEmpty()){
            for(int i=0;i<shamParms.size();i++){
                if(maps.containsKey(shamParms.get(i).getShamParms())){
                    obj[i] = maps.get(shamParms.get(i).getShamParms());
                }else{
                    return Result.getException("参数:" + shamParms.get(i).getShamParms() + "不可为空，请重新输入！").getJson();
                }
            }
        }
        //创建对象
        JaxWsDynamicClientFactory jdcf = JaxWsDynamicClientFactory.newInstance();
        String str = WSDLUtils.convertWsdlToString(url);
        String wsdlUrl = "";
        if(str.indexOf("element ref=\"s:schema\"") != -1){
            String fileName = AuthUtils.encodeMD5(url+method,null);
            try{
                wsdlUrl = XMLTextToFile.XmlTextToXmlFile(str, fileName);
            }catch (IOException e){
                e.getStackTrace();
            }
        }else{
            wsdlUrl = url;
        }
        //创建webservices客户端
        Client client = jdcf.createClient(wsdlUrl);
        Object object = null;
        try{
            if(obj != null && obj.length > 0){
                object = client.invoke(method,obj);
            }else{
                object = client.invoke(method);
            }
        }catch(Exception e){
            e.getStackTrace();
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,object,null).getJson();
    }

    @Override
    public String cxfMethodV0(List<ParamModel> paramResult, InformationApi informationApi, List<ParmsApi> shamParms) throws IOException{

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost= new HttpPost(informationApi.getUrl());
        String requestXml = "";
        if(paramResult != null && !paramResult.isEmpty()){
            requestXml = paramResult.get(0).getParamValue().toString();
        }
        if(StringUtils.isBlank(requestXml)){
            return Result.getException(ExceptionEnum.ParamISNUll).getJson();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(requestXml);
        StringEntity myEntity = new StringEntity(sb.toString(), ContentType.create("text/xml", "UTF-8"));
        httpPost.setEntity(myEntity);
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            @Override
            public String handleResponse(
                    final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    if(null!=entity){
                        String result = EntityUtils.toString(entity);
                        return result;
                    }else{
                        return null;
                    }
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        String result = "";
        try{
            result = httpclient.execute(httpPost,responseHandler);
        }catch(Exception e){
            httpclient.close();
            e.getStackTrace();
            return Result.Error().getJson();
        }
        httpclient.close();
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,result,null).getJson();
    }

    @Override
    public String sendHttpRequest(Map<String, Object> maps, InformationApi informationApi) throws IOException{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost= new HttpPost(informationApi.getUrl());
        String requestXml = "";
        try{
            for(Map.Entry<String, Object> entry : maps.entrySet()){
                if(StringUtils.isNotBlank(entry.getValue().toString())){
                    requestXml = entry.getValue().toString();
                    break;
                }
            }
        }catch(Exception e){
        }
        StringBuilder sb = new StringBuilder();
        sb.append(requestXml);
        StringEntity myEntity = new StringEntity(sb.toString(), ContentType.create("text/xml", "UTF-8"));
        httpPost.setEntity(myEntity);
        ResponseHandler<Map<String, Object>> responseHandler = new ResponseHandler<Map<String, Object>>() {
            @Override
            public Map<String, Object> handleResponse(final HttpResponse response) {
                Map<String, Object> map = new HashMap<>();
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    if(null!=entity){

                        String result = null;
                        try {
                            result = EntityUtils.toString(entity);
                        } catch (IOException e) {
                        }
                        map.put("flux",result.getBytes().length);
                        map.put("result",result);
                        return map;
                    }else{
                        return null;
                    }
                }else{
                    return null;
                }
            }
        };
        Map<String, Object> map = new HashMap<>();
        String result = "";
        try{
            map = httpclient.execute(httpPost,responseHandler);
            if(map != null && !map.isEmpty()){
                result = map.get("result").toString();
            }
        }catch(Exception e){
            httpclient.close();
            e.getStackTrace();
            return Result.Error().getJson();
        }
        httpclient.close();
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,result,map).getJson();
    }
}
