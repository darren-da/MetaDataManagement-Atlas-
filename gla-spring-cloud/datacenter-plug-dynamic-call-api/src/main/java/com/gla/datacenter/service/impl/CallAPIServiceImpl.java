package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.gla.datacenter.service.CallAPIService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.namespace.QName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: API 调用核心方法
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/26 10:24
 */
public class CallAPIServiceImpl implements CallAPIService{

    Logger logger= LoggerFactory.getLogger(CallAPIServiceImpl.class);

    //定义缓存，加快创建效率
    public static Map<String,Endpoint> factoryMap=new HashMap<String, Endpoint>();

    public static Map<String,Client> clientMap=new HashMap<String, Client>();


    @Override
    public String dynamicCallWebServiceByCXF(String wsdlUrl, String methodName, String targetNamespace, String name, List<Object> paramList) {
        //临时增加缓存，增加创建速度
        if(!factoryMap.containsKey(methodName)){
            // 创建动态客户端
            JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
            // 创建客户端连接
            Client client = factory.createClient(wsdlUrl);
            ClientImpl clientImpl = (ClientImpl) client;
            Endpoint endpoint = clientImpl.getEndpoint();
            factoryMap.put(methodName,endpoint);
            clientMap.put(methodName,client);
            System.out.println("初始化");
        }
        //从缓存中换取 endpoint、client
        Endpoint endpoint=factoryMap.get(methodName);
        Client client=clientMap.get(methodName);
        // Make use of CXF service model to introspect the existing WSDL
        ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
        // 创建QName来指定NameSpace和要调用的service
        String localPart=name+"SoapBinding";
        QName bindingName = new QName(targetNamespace, localPart);
        BindingInfo binding = serviceInfo.getBinding(bindingName);

        //创建QName来指定NameSpace和要调用的方法绑定方法
        QName opName = new QName(targetNamespace, methodName);//selectOrderInfo

        BindingOperationInfo boi = binding.getOperation(opName);
//		BindingMessageInfo inputMessageInfo = boi.getInput();
        BindingMessageInfo inputMessageInfo = null;
        if (!boi.isUnwrapped()) {
            //OrderProcess uses document literal wrapped style.
            inputMessageInfo = boi.getWrappedOperation().getInput();
        } else {
            inputMessageInfo = boi.getUnwrappedOperation().getInput();
        }

        List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();

        /***********************以下是初始化参数，组装参数；处理返回结果的过程******************************************/
        Object[] parameters = new Object[parts.size()];
        for(int m=0;m<parts.size();m++){
            MessagePartInfo  part=parts.get(m);
            // 取得对象实例
            Class<?> partClass = part.getTypeClass();//OrderInfo.class;
            System.out.println(partClass.getCanonicalName()); // GetAgentDetails
            //实例化对象
            Object initDomain=null;
            //普通参数的形参，不需要fastJson转换直接赋值即可
            if("java.lang.String".equalsIgnoreCase(partClass.getCanonicalName())||
                    "int".equalsIgnoreCase(partClass.getCanonicalName())){
                initDomain=paramList.get(m);
            }
            //如果是数组
            else if(partClass.getCanonicalName().indexOf("[]")>-1){
                //转换数组
                initDomain=JSON.parseArray(paramList.get(m).toString(),partClass.getComponentType());
            }else{
                initDomain=JSON.parseObject(paramList.get(m).toString(),partClass);
            }
            parameters[m]=initDomain;

        }
        //定义返回结果集
        Object[] result=null;
        //普通参数情况 || 对象参数情况  1个参数 ||ArryList集合
        try {
            result = client.invoke(opName,parameters);
        }catch (Exception ex){
            ex.printStackTrace();
            return "参数异常"+ex.getMessage();
        }
        //返回调用结果
        if(result.length>0){
            logger.debug("返回结果是：{}", JSON.toJSON(result[0]).toString());
            return  JSON.toJSON(result[0]).toString();
        }
        return  "invoke success, but is void ";
    }
}
