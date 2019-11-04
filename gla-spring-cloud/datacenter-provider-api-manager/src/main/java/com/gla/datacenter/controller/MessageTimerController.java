package com.gla.datacenter.controller;

import com.gla.datacenter.service.MessageTimerService;
import com.gla.datacenter.service.PlugCacheClientService;
import com.limp.framework.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhengshien
 * @Date: 2019/3/17 16:10
 * @Description:
 */
@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageTimerController {

    private Logger log = LoggerFactory.getLogger(MessageTimerController.class);

    private static final String TIMING_MONDAY = "TIMING_MONDAY";
    private static final String EXPIRE_TIME = "3600000";
    /**
     * 引入service
     */
    @Autowired
    MessageTimerService messageTimerService;

    /**
     * 引入PlugCacheClientService 缓存服务
     */
    @Autowired
    private PlugCacheClientService plugCacheClientService;


    /**
     * 定时任务表达式(每周一早上七点)
     */
    private static final String TIMING_TASK = "0 0 7 ? * MON";


    @Scheduled(cron= TIMING_TASK)
    @RequestMapping(value = "/timer",method = RequestMethod.GET)
    public void messageTimer(){
        //获取锁并加给key赋值，如果当天已经执行过定时任务，则不再执行
//        String lock = plugCacheClientService.getLock(TIMING_MONDAY, StrUtils.randomUUID(), EXPIRE_TIME);
//        if ("true".equals(lock)) {
            messageTimerService.messageTimer();
//        }
    }
}