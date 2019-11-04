/*
package com.gla.datacenter.contrall;

import com.gla.datacenter.domain.OrderInfo;
import com.limp.framework.utils.StrUtils;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 2018/9/25
 * Time: 15:30
 * Intro:...
 * To change this template use File | Settings | File Templates.
 *//*

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate OrderInfoRedisTemplate;


    @Autowired
    RabbitTemplate rabbitTemplate;


    @Autowired
    JestClient  jestClient;

    Map map=new HashMap<String,String>(){{
        put("1","order1");
        put("3","order2");
    }};

    @Test
    public void addESDoc(){

        OrderInfo  orderInfo=new OrderInfo();
        orderInfo.setId("1");
        orderInfo.setIdt(new Date());
        orderInfo.setIp("127.0.0.1");
        String StrResult="{code:200,result:'更新成功:java中可以用.getBytes().length获取字符串占用内容的大小，原理是java中任何字符都采用Unicode编码，所以衡量占用内存大小采用占用的字节数。'}";
        orderInfo.setOrderResult(StrResult);
        orderInfo.setServiceId("API的ID-->【todo存放API编码】");
        orderInfo.setServiceName("API名称");
        orderInfo.setUsrid("操作用户ID");
        orderInfo.setParamsKey("分析的关键参数");
        orderInfo.setParms("所有的请求参数");
        orderInfo.setUrl("");
        //构建一个 索引功能
       Index index=new  Index.Builder(orderInfo).index("datacenter").type("orders").build();
        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
    @Test
    public void searchEs(){
        String json="{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"orderResult\" : \"200\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search=new Search.Builder(json).addIndex("datacenter").addType("orders").build();
        try {
            SearchResult searchResult=jestClient.execute(search);
            System.out.println("search result...");
            System.out.println(searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public  void TongJByte(){
        String str="ceafhafpodkdpasfdasfdsa fssafdsafds";
        System.out.println("流量统计"+str.getBytes().length);
    }

    */
/**
     * 添加订单信息 向MQ
     *//*

    @Test
    public  void  RabbitMQTest(){
        for (int i=0;i<1;i++){
            try {
                Thread.sleep(500);
                System.out.println("test send message to MQ-->"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //初始化订单信息 并发送到MQ
            OrderInfo orderInfo=new OrderInfo();
            orderInfo.setOrderNo(StrUtils.getOrderNo());
            orderInfo.setIdt(new Date());
            orderInfo.setIp("127.0.0.1");
            String StrResult="{code:200,result:'更新成功:java中可以用.getBytes().length获取字符串占用内容的大小，原理是java中任何字符都采用Unicode编码，所以衡量占用内存大小采用占用的字节数。'}";
            if(i%2==0){
                StrResult+=StrResult;
            }
            orderInfo.setOrderResult(StrResult);
            orderInfo.setServiceId("API的ID-->【todo存放API编码】");
            orderInfo.setServiceName("API名称"+i
            );
            orderInfo.setUsrid("操作用户ID");
            orderInfo.setParamsKey("分析的关键参数");
            orderInfo.setParms("所有的请求参数");
            orderInfo.setUrl("");
            rabbitTemplate.convertAndSend("datacenter.direct","api.order",orderInfo);
        }

    }

    */
/**
     * 接收信息
     *//*

    @Test
    public void  receive(){
        for(int i=0;i<1;i++){
            Object  obj= rabbitTemplate.receiveAndConvert("api.order");
            System.out.println("Test receive");
            System.out.println(obj);
        }



    }

    */
/**
     * 测试 redis相关工具类
     *//*

    @Test
    public void  redisTest(){
        Map student=new HashMap<String,String>(){
            {
                put("name","zhangzan");
                put("age","");
            }
        };
        OrderInfo orderInfo=new OrderInfo();
        orderInfo.setId("23");
        orderInfo.setOrderNo("No.124444");
//        redisTemplate.opsForHash().put("test5",orderInfo,orderInfo);
        OrderInfoRedisTemplate.opsForHash().put("test6",orderInfo,orderInfo);
    }
    @Test
    public  void   testAdd(){
        System.out.println("test spring");
    }

}
*/
