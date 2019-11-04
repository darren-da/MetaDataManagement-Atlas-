package com.gla.datacenter.service;

import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.ParmsApi;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CxfWebServicexClient {

    /**
     *
     * 功能描述: cxf框架soap协议webservice请求
     *
     * @param: [map 消费者传递参数(默认值), informationApi api信息, shamParms api参数]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/14 15:43
     */
    
    String sendSoapRequest(Map<String, Object> map, InformationApi informationApi, List<ParmsApi> shamParms);


    String sendHttpRequest(Map<String, Object> map, InformationApi informationApi) throws IOException;
}
