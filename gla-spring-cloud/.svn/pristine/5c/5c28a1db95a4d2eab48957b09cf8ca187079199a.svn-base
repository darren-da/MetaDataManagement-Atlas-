package com.gla.datacenter.timer;

import com.gla.datacenter.service.ApiManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/10 17:13
 * @Description:
 */
@Component
public class TimerManagers {

    @Autowired
    private ApiManagerService apiManagerService;

    //@Scheduled(cron = "0 */1 * * * ?")
    /*public void test(){
        apiManagerService.apiTestTask();
    }*/

    @Scheduled(cron = "0/5 * * * * ?")
    public void monitorDB(){
        apiManagerService.monitorDB();
    }

    /**
     *
     * 功能描述: 监控过期api并且修改过期状态
     *
     * @param:
     * @return: void
     * @auther: zhangbo
     * @date: 2018/12/12 15:05
     */
    @Scheduled(cron = "0/5 * * * * ?")//"0 */30 * * * ?"
    public void monitorExpireApi(){
        apiManagerService.monitorExpireApi();
    }
}
