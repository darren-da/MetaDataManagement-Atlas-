package com.gla.datacenter.timer;

import com.gla.datacenter.service.TimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zhangbo
 * @Date: 2019/8/6 11:31
 * @Description:
 */
@Component
public class TimeController {

    private Logger logger = LoggerFactory.getLogger(TimeController.class);

    @Autowired
    private TimeService timeService;

    /**
     *  每周六凌晨3点执行
     */
    @Scheduled(cron = "0 0 3 ? * SAT")
    public void updateDept(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logger.info("定时器开始执行时间 : {}" ,sdf.format(new Date()));
        timeService.updateDept();
    }

}
