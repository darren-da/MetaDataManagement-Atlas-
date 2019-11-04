package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.service.ApiCenterClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/26 09:41
 * @Description:
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@Api(value = "api管理消费者",description = "api管理消费者")
public class ApiCenterControllerFeign {

    private Logger loger = LoggerFactory.getLogger(ApiCenterControllerFeign.class);

    @Autowired
    private ApiCenterClientService apiCenterClientService;

    /**
     *
     * 功能描述: 对外暴漏的rest调用接口
     *
     * @param: [params] 包含url(url+code),参数
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 15:05
     */
    @ApiOperation(value = "对外暴漏的rest调用接口")
    @RequestMapping(value = "/center/v1/{code}/{dsbkey}")
    public String requestApi(@RequestBody Map<String, Object> params,@PathVariable("code") String code,@PathVariable("dsbkey") String dsbkey){
        loger.debug(TextUtils.format("调用开始------"));
        return apiCenterClientService.requestApi(params,code,dsbkey);
    }

    /**                            以下全是测试方法，需要删除                                       **/
    @PostMapping(value = "/center/v0/{code}")
    public String requestMethod(@RequestBody Map<String, Object> params,@PathVariable("code") String code){
        return apiCenterClientService.requestMethod(params,code);
    }

    //get或者post都可以
    @GetMapping(value = "/get")
    public String get(@RequestParam("apiId") String apiId, @RequestParam("userId") String userId){
        System.out.println(apiId);
        System.out.println(userId);
        return apiId+userId;
    }

    @PostMapping(value = "/get1/{id}/{name}")
    public String getUrl(@PathVariable("id") String id,@PathVariable("name") String name){
        System.out.println(id);
        System.out.println(name);
        return id+name;
    }

    @PostMapping(value = "/getBody")
    public String getBody(@RequestBody Map<String, Object> map){
        System.out.println(map.get("id"));
        System.out.println(map.get("name"));
        return map.get("id").toString()+map.get("name").toString();
    }

    @PostMapping(value = "/getMap")
    public List<Map<String, Object>> getMap(@RequestBody Map<String, Object> map){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> maps = new HashMap<>();
        maps.put("111","111");
        maps.put("222","222");
        list.add(map);
        list.add(maps);
        return list;
    }

    @PostMapping(value = "/aaa")
    public InputStream getppp(@RequestBody Map<String, Object> params){
        InputStream obj = apiCenterClientService.getppp(params);
        String name = obj.getClass().getName();
        System.err.println(name);
        return obj;
    }


}
