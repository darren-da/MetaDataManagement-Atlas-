package com.gla.datacenter.service;


import com.gla.datacenter.service.fallback.OperationLogClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "DATACENTER-GATEWAY",path = "/api4/operationLogService",fallbackFactory = OperationLogClientServiceFallbackFactory.class)
//@RequestMapping(value = "/api4/operationLogService")
public interface OperationLogClientService {

    /**
     *
     * 功能描述: 
     *
     * @param: 需要的前期处理再调用此接口
     *  Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(entry,true);
        stringObjectMap = operationLogService.converMap(stringObjectMap, "DeptUpdate");
        Map<String, Object> deptMap = JavaBeanConverMapUtils.bean2Map(dept,false);
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 16:21
     */
    
    @RequestMapping(value = "/operationLog/add")
    public String addOperationLogs(@RequestBody Map<String, Object> map);


}
