package com.gla.datacenter.service;

import com.gla.datacenter.service.fallback.AppCenterClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@FeignClient(value = "DATACENTER-GATEWAY",path = "/api7",fallbackFactory = AppCenterClientServiceFallbackFactory.class)
//@RequestMapping(value = "/api7")
public interface AppCenterClientService {

    /**
     *
     * 功能描述: app汇聚调用统一入口
     *
     * @param:
     * @param params
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/26 16:53
     */
    @RequestMapping(value = "/app/center/v1/{code}")
    String requestApp(@RequestBody List<Map<String, Object>> params, @PathVariable("code") String code);
}
