/*
package com.gla.datacenter.config;

*/
/**
 * @Description: 接收处理 MQ发送的消息
 * @Author: zzh
 * @Date: 2018/9/27 10:02
 *//*


import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.OrderInfoService;
import com.limp.framework.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "api.order")
public class MQReceiveHandler {
    private Logger log= LoggerFactory.getLogger(MQReceiveHandler.class);
    @Autowired
    OrderInfoService orderInfoService;



    @RabbitHandler
    public void process(OrderInfo  orderInfo){
        orderInfoService.saveOrderAndDetailMQ(orderInfo);
        log.debug("接收MQ发送的消息:->"+ JsonUtils.toJson(orderInfo));
    }
}
*/
