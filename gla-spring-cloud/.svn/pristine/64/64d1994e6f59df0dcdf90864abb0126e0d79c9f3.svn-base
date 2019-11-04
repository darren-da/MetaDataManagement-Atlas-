package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.service.AppCenterClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/2/21 13:58
 * @Description:
 */
@CrossOrigin
@RestController
public class AppCenterControllerFeign {


    private Logger loger = LoggerFactory.getLogger(AppCenterControllerFeign.class);

    @Autowired
    private AppCenterClientService appCenterClientService;

    /**
     *
     * 功能描述: app汇聚调用统一入口
     *
     * @param: 
     * @param params
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/26 15:56
     */
    @RequestMapping(value = "/app/center/v1/{code}")
    public String requestApp(@RequestBody List<Map<String, Object>> params, @PathVariable("code") String code){
        return appCenterClientService.requestApp(params,code);
    }
}
