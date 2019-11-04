package com.gla.datacenter.service.impl;

import com.gla.datacenter.core.utils.WSDLUtils;
import com.gla.datacenter.core.utils.XMLTextToFile;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.ParmsApi;
import com.gla.datacenter.service.CxfWebServicexClient;
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
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2018/11/14 15:23
 * @Description:
 */
@Service
public class CxfWebServicexClientImpl implements CxfWebServicexClient {

    @Override
    public String sendSoapRequest(Map<String, Object> map, InformationApi informationApi, List<ParmsApi> shamParms) {

        Object[] obj = new Object[shamParms.size()];
        String url = informationApi.getUrl();
        String method = informationApi.getMethod();
        if(shamParms != null && !shamParms.isEmpty()){
            for(int i=0;i<shamParms.size();i++){
                if(map.containsKey(shamParms.get(i).getShamParms())){
                    obj[i] = map.get(shamParms.get(i).getShamParms());
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
        //client.getEndpoint().getEndpointInfo().setAddress(wsdlUrl);
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
    public String sendHttpRequest(Map<String, Object> map, InformationApi informationApi) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost= new HttpPost(informationApi.getUrl());
        //根据url获取请求体
        String requestXml = "";
        /*//保存处理后的带参请求体
        String requestXmlAfter = "";
        String url = informationApi.getUrl();
        String method = informationApi.getMethod();*/
        try{
            for(Map.Entry<String, Object> entry : map.entrySet()){
                if(StringUtils.isNotBlank(entry.getValue().toString())){
                    requestXml = entry.getValue().toString();
                }
            }
            if(StringUtils.isBlank(requestXml)){
                return Result.getException(ExceptionEnum.ParamISNUll).getJson();
            }
            //requestXml = informationApi.getRc1();
            //requestXml = WSDLRequestXmlToString.soapRequestXML(url,method);
            /*if(StringUtils.isNotBlank(requestXml)){
                //存在参数去除body内容
                if(requestXml.indexOf("?") != -1){
                    //不是对象
                    if(StringUtils.isBlank(informationApi.getInterParamType())){
                        String startStr = "<web:" + method + ">";
                        String beforeStr = requestXml.substring(0, requestXml.indexOf(startStr)+startStr.length());
                        String endStr = "</web:" + method + ">";
                        String after = requestXml.substring(requestXml.indexOf(endStr),requestXml.length());
                        //循环拼接参数
                        String centerParams = "";
                        for(Map.Entry<String, Object> entry : map.entrySet()){
                            centerParams += "<web:" + entry.getKey() + ">" + entry.getValue() + "</web:" + entry.getKey() + ">";
                        }
                        requestXmlAfter = beforeStr + centerParams + after;
                    }else{
                        requestXmlAfter = informationApi.getRc2();
                        //是对象封装
                        *//*Document document = DocumentHelper.parseText(requestXml);
                        Element rootElement = document.getRootElement();
                        Element element = rootElement.element("web:" + method);
                        Element parent = element.getParent();
                        //获取元素文本内容
                        String textTrim = parent.getTextTrim();
                        //获取元素名称
                        String name = parent.getName();*//*
                    }
                }else{
                    //requestXmlAfter = requestXml;
                }
            }*/
        }catch (Exception e){
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
            //result = WSDLRequestXmlToString.xmlToJson(result);
        }catch(Exception e){
            httpclient.close();
            e.getStackTrace();
            return Result.Error().getJson();
        }
        httpclient.close();
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,result,null).getJson();
    }
}
