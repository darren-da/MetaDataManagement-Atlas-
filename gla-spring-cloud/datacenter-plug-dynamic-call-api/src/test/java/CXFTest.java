import com.alibaba.fastjson.JSON;
import com.gla.datacenter.service.CallAPIService;
import com.gla.datacenter.service.impl.CallAPIServiceImpl;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: $集合测试类
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/26 10:38
 */
public class CXFTest {
    private static  String   wsdlUrl="http://192.168.26.113:8001/demo/HelloServiceDemoUrl?wsdl";
    //	private static final QName SERVICE_NAME = new QName("namespace", "serviceName");
    private static final QName SERVICE_NAME = new QName("http://service.limp.com/", "HelloServiceDemo");

    //定义缓存，加快创建效率
    public static Map<String,Endpoint> factoryMap=new HashMap<String, Endpoint>();
    public static Map<String,Client> clientMap=new HashMap<String, Client>();
    public static void main(String[] args) throws Exception{

        CallAPIService  callAPIService=new CallAPIServiceImpl();
        /*********************参数初始化过程************************************/

//		pojoInvokes1();
        List<Object> listParam=new ArrayList<>();
        String params="{\"id\":\"zhangsan\",\"money\":23}";
        listParam.add(params);

        //////
        List<Object> listParam2=new ArrayList<>();
        String obj0="超级管理员";
        String obj1="{\"id\":\"zhangsan\",\"money\":23}";
        String obj2="{\"name\":\"one test\",\"intro\":\"这是订单详情\"}";
        listParam2.add(obj0);
        listParam2.add(obj1);
        listParam2.add(obj2);

        /////
        List<Object> listParam1=new ArrayList<>();
        listParam1.add("zhangsan");
        listParam1.add("lisi");
        listParam1.add(6);

        /////
        List<Object> listParam4=new ArrayList<>();
        //[{"id":"NO.2","money":24},{"money":0}]
        listParam4.add("[{\"id\":\"NO.2\",\"money\":24},{\"money\":0}]");

        List<Object> listParam6=new ArrayList<>();
        listParam6.add("北京");

        /*********************方法动态调用测试************************************/

        for(int i=0;i<2;i++){
            Long start=System.currentTimeMillis();
            //多个参数情况
            System.out.println(callAPIService.dynamicCallWebServiceByCXF(wsdlUrl,"sayHello2", "http://service.limp.com/",
                    "HelloServiceDemo",listParam1));
            //单个对象

            System.out.println(callAPIService.dynamicCallWebServiceByCXF(wsdlUrl,"selectOrderInfo", "http://service.limp.com/","HelloServiceDemo",listParam));
            //多个对象
            System.out.println(callAPIService.dynamicCallWebServiceByCXF(wsdlUrl,"selectOrderInfoAndOrderDetail", "http://service.limp.com/","HelloServiceDemo",listParam2));
            //集合测试
            System.out.println(callAPIService.dynamicCallWebServiceByCXF(wsdlUrl,"getOrderList", "http://service.limp.com/","HelloServiceDemo",listParam4));

            //net创建的webservice通过其他方式获取
//			System.out.println(dynamicCallWebServiceByCXF("http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl","getSupportCity",
//					"http://WebXml.com.cn/","",listParam6));
            Long end=System.currentTimeMillis();
            System.out.println(i+"调用用时"+(end-start));
        }
    }
}
