package com.gla.datacenter.service;

import com.gla.datacenter.domain.LoginLog;
import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.service.fallback.LimpFrameworkClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:shinians email:shiniandate@163.com
 * @date:Created in 19:43 2018/9/23
 * @modified By:
 * @Description:
   框架中通用的方法可以集中在 此service填写
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api0",fallbackFactory=LimpFrameworkClientServiceFallbackFactory.class)
//@RequestMapping("/api0")
public interface LimpFrameworkClientService {

    /**
     * 新增用户
     * @param loginLog 新增登陆日志信息
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/system/loginLog",method= RequestMethod.POST)
    public String insertLoginLog(@RequestBody LoginLog loginLog);

    /**
     * 加入page访问记录
     * @param pageLog
     * @return
     */
    @RequestMapping(value = "/system/pageLogs",method= RequestMethod.POST)
    public String savePageLogs(@RequestBody PageLog pageLog);



}
