package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.OrderClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component // 不要忘记添加，不要忘记添加
public class OrderClientServiceFallbackFactory implements FallbackFactory<OrderClientService>
{

    @Override
    public OrderClientService create(Throwable throwable) {
        return new OrderClientService() {
            @Override
            public String get(String id) {

                return "system is error";
            }

            @Override
            public String getOrderDetailByOrderNo(String orderNo) {
                return null;
            }

            @Override
            public String getOrderInfoList(OrderInfo orderInfo) {
                return null;
            }

            @Override
            public String sendOrderMQMsg(OrderInfo orderInfo) {
                return null;
            }

        };  //To change body of implemented methods use File | Settings | File Templates.
    }
}
