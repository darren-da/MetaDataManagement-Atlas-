package com.gla.datacenter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhangbo
 * @Date: 2019/6/18 14:50
 * @Description:
 */
@RestController
public class TestController {

    @RequestMapping(value = "/mdm")
    public String getTest(){
        return "success";
    }

}
