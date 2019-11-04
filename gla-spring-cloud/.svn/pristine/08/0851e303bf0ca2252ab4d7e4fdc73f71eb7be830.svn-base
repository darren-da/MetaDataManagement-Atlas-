package com.gla.datacenter.service;

import com.alibaba.fastjson.JSON;
import com.gla.datacenter.domain.OrderInfo;
import com.limp.framework.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 创建一个消息接收者
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/20 16:47
 */
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    OrderInfoService orderInfoService;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String  message) {
        LOGGER.info("Received <" + message + ">");
        OrderInfo  orderInfo=JSON.parseObject(message,OrderInfo.class);
        orderInfoService.saveOrderAndDetailMQ(JSON.parseObject(message,OrderInfo.class));
        LOGGER.debug("接收MQ发送的消息:->"+ JsonUtils.toJson(orderInfo));
        latch.countDown();
    }
}
