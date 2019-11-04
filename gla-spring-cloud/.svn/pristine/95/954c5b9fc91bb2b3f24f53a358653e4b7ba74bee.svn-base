package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.TimerCenter;
import com.gla.datacenter.domain.TimerCenterExample;
import com.gla.datacenter.mapper.mysql.TimerCenterMapper;
import com.gla.datacenter.service.TaskService;
import com.limp.framework.core.constant.ConstantClazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/11 10:38
 * @Description:
 */
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TimerCenterMapper timerCenterMapper;

    @Override
    public List<TimerCenter> getTimerInfor() {
        List<TimerCenter> list = new ArrayList<>();
        TimerCenterExample ex = new TimerCenterExample();
        TimerCenterExample.Criteria criteria = ex.createCriteria();
        criteria.andIsFlagEqualTo(ConstantClazz.DELETE_FLAG_FALSE);
        criteria.andDeleteFlagEqualTo(ConstantClazz.DELETE_FLAG_FALSE);
        try {
            list = timerCenterMapper.selectByExample(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
