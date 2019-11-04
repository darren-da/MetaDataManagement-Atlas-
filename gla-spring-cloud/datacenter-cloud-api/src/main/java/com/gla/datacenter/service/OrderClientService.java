
package com.gla.datacenter.service;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.fallback.OrderClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * @author:shinians email:shiniandate@163.com
 * @date:Created in 19:43 2018/9/23
 * @modified By:
 * @Description:
   根据已经有的ORDERClientService接口新建一个实现了FallbackFactory接口的类OrderClientServiceFallbackFactory
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api1",fallbackFactory=OrderClientServiceFallbackFactory.class)
//@RequestMapping("/api1")
public interface OrderClientService {

    /**
     * 根据订单id获取订单基本信息
     * @param id 订单id
     * @return 订单信息
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") String id);

    /**
     * 根据订单号获取订单详情信息
     * @param orderNo  订单号
     * @return 订单详情
     */
    @RequestMapping(value = "/orderDetail/{orderNo}", method = RequestMethod.GET)
    public String getOrderDetailByOrderNo(@PathVariable("orderNo") String orderNo);


    /**
     * 根据订单实体对象获取订单列表
     * @return
     * [1] 当使用Feign时，如果发送的是get请求，那么需要在请求参数前加上@RequestParam注解修饰
     * [2] feign中你可以有多个@RequestParam，但只能有不超过一个@RequestBody
     * [3]当userName没有被@RequestParam注解修饰时，会自动被当做request body来处理。只要有body，就会被feign认为是post请求，所以整个服务是被当作带有request parameter和body的post请求发送出去的
     */
    @RequestMapping(value = "/orders")
    public String getOrderInfoList(@RequestBody OrderInfo orderInfo);

    /**
     * 发送订单数据到MQ
     * @param orderInfo 订单基本信息
     * @return
     */
    @RequestMapping(value = "/sendOrderMQMsg")
    public String sendOrderMQMsg(@RequestBody OrderInfo orderInfo) ;





}
