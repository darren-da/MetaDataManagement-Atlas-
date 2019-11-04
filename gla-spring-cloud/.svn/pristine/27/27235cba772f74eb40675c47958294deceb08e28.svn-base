package com.gla.datacenter.service.fallback;

import com.gla.datacenter.service.AppCenterClientService;
import feign.hystrix.FallbackFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: admin
 * @Date: 2019/2/21 14:04
 * @Description:
 */
public class AppCenterClientServiceFallbackFactory implements FallbackFactory<AppCenterClientService> {

    @Override
    public AppCenterClientService create(Throwable throwable) {
        return new AppCenterClientService() {

            @Override
            public String requestApp(List<Map<String, Object>> params, String code) {
                System.out.println("调用失败返回");

                return "调用失败返回";
            }
        };
    }
}
