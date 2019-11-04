package com.gla.datacenter.service.fallback;

import com.gla.datacenter.service.ApiCenterClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;

/**
 * @author zhangbo
 * @Date: 2018/9/26 10:04
 * @Description:
 */
@Component
public class ApiCenterClientServiceFallbackFactory implements FallbackFactory<ApiCenterClientService> {
    @Override
    public ApiCenterClientService create(Throwable throwable) {

        return new ApiCenterClientService() {
            @Override
            public String requestApi(Map<String, Object> params,String code,String dsbkey) {
                System.out.println("调用失败返回");

                return "调用失败返回";
            }

            @Override
            public InputStream getppp(Map<String, Object> params) {
                return null;
            }

            @Override
            public String requestMethod(Map<String, Object> params, String code) {
                return null;
            }
        };
    }
}
