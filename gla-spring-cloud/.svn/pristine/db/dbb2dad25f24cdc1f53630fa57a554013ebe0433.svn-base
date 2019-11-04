package com.gla.datacenter.service;

import com.gla.datacenter.service.fallback.ApiCenterClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;
import java.util.Map;

@FeignClient(value = "DATACENTER-GATEWAY",path = "/api7",fallbackFactory = ApiCenterClientServiceFallbackFactory.class)
//@RequestMapping("/api7")
public interface ApiCenterClientService {


    /**
     *
     * 功能描述: 对外暴漏的rest调用接口
     *
     * @param: [params]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 15:05
     */
    @RequestMapping(value = "/api/center/v1/{code}/{dsbkey}")
    String requestApi(@RequestBody Map<String, Object> params, @PathVariable("code") String code,@PathVariable("dsbkey") String dsbkey);

    @RequestMapping(value = "api/center/v0/{code}")
    String requestMethod(@RequestBody Map<String, Object> params,@PathVariable("code") String code);

    @RequestMapping(value = "/api/centers")
    InputStream getppp(@RequestBody Map<String, Object> params);


}
