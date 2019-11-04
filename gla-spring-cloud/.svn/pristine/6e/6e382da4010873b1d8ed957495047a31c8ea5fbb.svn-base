package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.OrderClientService;
import com.gla.datacenter.service.PlugCacheClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class PlugCacheClientServiceFallbackFactory implements FallbackFactory<PlugCacheClientService>
{

    @Override
    public PlugCacheClientService create(Throwable throwable) {
        return new PlugCacheClientService() {

            @Override
            public String setCache(String key, String value, Long time) {
                return "设置缓存失败";
            }

            @Override
            public String getCache(String key) {
                return "服务已下线";
            }

            @Override
            public String delCache(String key) {
                return null;
            }

            @Override
            public String getLock(String lockKey, String requestId, String expireTime) {
                return null;
            }
        };  //To change body of implemented methods use File | Settings | File Templates.
    }
}
