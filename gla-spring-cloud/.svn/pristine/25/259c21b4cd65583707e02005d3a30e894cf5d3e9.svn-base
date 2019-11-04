package com.gla.datacenter.controller;

import com.gla.datacenter.service.ApiCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/26 10:13
 * @Description: api调用生产者
 */
@RestController
public class ApiCenterController {

    @Autowired
    private ApiCenterService apiCenterService;

    /**
     *
     * 功能描述: 对外暴漏的接口地址供消费者调用
     *
     * @param: [params]包含url(url+code http://localhost:8080/api/center/111111),参数
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/6 15:06
     */

    @RequestMapping(value = "/api/center/v1/{code}/{dsbkey}")
    public String requestApi(@RequestBody Map<String, Object> params, @PathVariable("code") String code,@PathVariable("dsbkey") String dsbkey){
        return apiCenterService.requestApi(params,code,dsbkey);
    }

    /**
     *
     * 功能描述: app汇聚调用统一入口
     *
     * @param: 
     * @param params
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/26 16:55
     */
    @RequestMapping(value = "/app/center/v1/{code}")
    public String requestApp(@RequestBody List<Map<String, Object>> params, @PathVariable("code") String code){
        return apiCenterService.requestApp(params,code);
    }

    /**
     *
     * 功能描述: 暂时
     *
     * @param: 
     * @param params
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/8 17:24
     */
    @RequestMapping(value = "/api/center/v0/{code}")
    public String requestMethod(@RequestBody Map<String, Object> params,@PathVariable("code") String code){
        return apiCenterService.requestMethod(params,code);
    }

}
