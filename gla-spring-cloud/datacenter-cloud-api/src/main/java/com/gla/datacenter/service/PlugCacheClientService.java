
package com.gla.datacenter.service;

import com.gla.datacenter.service.fallback.OrderClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author:shinians email:shiniandate@163.com
 * @date:Created in 19:43 2018/9/23
 * @modified By:
 * @Description: 缓存组件
   FallbackFactory
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api5",fallbackFactory=OrderClientServiceFallbackFactory.class)
//@RequestMapping("/api5")
public interface PlugCacheClientService {

    /**
     * 设置 缓存
     * @param key 缓存key
     * @param value 缓存value
     * @param time 缓存时间
     * @return
     */
    @RequestMapping(value = "/setCache")
    public String setCache(@RequestParam("key") String key, @RequestParam("value") String value,
                           @RequestParam("time") Long time) ;

    /**
     * 通过key获取缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "/getCache")
    public String getCache(@RequestParam("key") String key) ;

    /**
     * 通过key获取缓存
     * @param key
     * @return
     */
    @RequestMapping(value = "/delCache")
    public String delCache(@RequestParam("key") String key) ;

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功 true or false
     */

    @RequestMapping(value = "/getLock")
    public String getLock(@RequestParam("lockKey") String lockKey,@RequestParam("requestId") String requestId,
                          @RequestParam("expireTime") String expireTime);


}
