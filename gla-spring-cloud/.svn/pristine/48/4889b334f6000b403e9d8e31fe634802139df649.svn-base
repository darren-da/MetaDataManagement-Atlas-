package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.LoginLog;
import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.service.LimpFrameworkClientService;
import com.gla.datacenter.service.UserInfoClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 熔断
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/9/28 16:18
 */
@Component
public class LimpFrameworkClientServiceFallbackFactory implements FallbackFactory<LimpFrameworkClientService> {
    @Override
    public LimpFrameworkClientService create(Throwable throwable) {

        return new LimpFrameworkClientService() {

            @Override
            public String insertLoginLog(LoginLog loginLog) {
                return null;
            }

            @Override
            public String savePageLogs(PageLog pageLog) {
                return null;
            }
        };
    }
}
