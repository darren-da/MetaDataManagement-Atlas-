package com.gla.datacenter.service;

import java.util.List;

/**
 * @Description: API 调用核心方法
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/26 10:24
 */
public interface CallAPIService {

    /**
     *
     * @param wsdlUrl  wsdl的地址：http://localhost:8001/demo/HelloServiceDemoUrl?wsdl
     * @param methodName 调用的方法名称 selectOrderInfo
     * @param targetNamespace 命名空间 http://service.limp.com/
     * @param name  name HelloServiceDemo
     * @param paramList 参数集合
     */
     String dynamicCallWebServiceByCXF(String wsdlUrl,String methodName,String targetNamespace,String name,List<Object> paramList);

    /**
     * 尚未处理：
     * 1.targetNamespace、name的的解析
     * 2.net的webservice处理逻辑
     * 3.httpClient调用过程的处理（核心方法转移到此处）
     *
     */



}
