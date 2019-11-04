package com.gla.datacenter.service.fallback;

import com.gla.datacenter.service.OperationLogClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/30 10:58
 * @Description:
 */
@Component
public class OperationLogClientServiceFallbackFactory implements FallbackFactory<OperationLogClientService> {


    @Override
    public OperationLogClientService create(Throwable throwable) {
        return new OperationLogClientService(){
            @Override
            public String addOperationLogs(Map<String, Object> map) {
                return null;
            }
        };

    }


}
