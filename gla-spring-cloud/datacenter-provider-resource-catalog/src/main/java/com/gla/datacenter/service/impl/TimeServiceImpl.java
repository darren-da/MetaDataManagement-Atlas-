package com.gla.datacenter.service.impl;

import com.gla.datacenter.mapper.mysql.RcsResourceCateMapper;
import com.gla.datacenter.service.DeptClientService;
import com.gla.datacenter.service.TimeService;
import com.limp.framework.core.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/8/6 11:34
 * @Description:
 */
@Service
public class TimeServiceImpl implements TimeService{

    @Autowired
    private RcsResourceCateMapper rcsResourceCateMapper;

    @Autowired
    private DeptClientService deptClientService;


    @Override
    public void updateDept() {
        //获取当前目录数据(部门)
        List<Map<String, Object>> mapList = rcsResourceCateMapper.getGrandsonResourceByCode(Constant.STRING_3);
        if(mapList != null && !mapList.isEmpty()){
            //调用插入到dept中
            int i = deptClientService.insertDeptByList(mapList);
            System.err.println("插入数据返回:" + i);
        }
    }
}
