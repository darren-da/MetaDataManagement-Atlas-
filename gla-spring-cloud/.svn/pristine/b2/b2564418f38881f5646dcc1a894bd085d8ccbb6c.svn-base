package com.gla.datacenter.service.fallback;

import com.gla.datacenter.service.AuthClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 熔断
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/9/28 16:18
 */
@Component
public class AuthClientServiceFallbackFactory implements FallbackFactory<AuthClientService> {
    @Override
    public AuthClientService create(Throwable throwable) {

        return new AuthClientService() {
            @Override
            public String login(HttpServletRequest request, String account, String password, String roleCode, String validateCode) {
                return null;
            }
        };
    }
}
