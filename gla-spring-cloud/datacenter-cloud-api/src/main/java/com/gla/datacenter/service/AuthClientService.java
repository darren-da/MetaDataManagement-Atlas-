package com.gla.datacenter.service;

import com.gla.datacenter.service.fallback.AuthClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:shinians email:shiniandate@163.com
 * @date:Created in 19:43 2018/9/23
 * @modified By:
 * @Description:
   框架中通用的方法可以集中在 此service填写
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api4",fallbackFactory=AuthClientServiceFallbackFactory.class)
//@RequestMapping("/api4")
public interface AuthClientService {

    /**
     * 用户登录
     * @param request
     * @param account
     * @param password
     * @param roleCode
     * @param validateCode
     * @return
     */
    @RequestMapping(value = "/auth/login",method= RequestMethod.POST)
    public String login(@RequestParam(name = "request") HttpServletRequest request, @RequestParam(name = "account") String account, @RequestParam(name = "password") String password
            , @RequestParam (name = "roleCode")  String roleCode, @RequestParam(name = "validateCode") String validateCode);



}
