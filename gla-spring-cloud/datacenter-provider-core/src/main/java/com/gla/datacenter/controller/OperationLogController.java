package com.gla.datacenter.controller;

import com.gla.datacenter.service.OperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/30 14:49
 * @Description:
 */
@RestController
//@RequestMapping(value = "/operation")
public class OperationLogController {


    @Autowired
    private OperationLogService operationLogService;

    @RequestMapping(value = "/operationLogService/operationLog/add")
    public String addOperationLogs(@RequestBody Map<String, Object> map){
        Map<String, Object> mapParams = (Map<String, Object>)map.get("mapParams");
        Map<String, Object> objectMap = (Map<String, Object>)map.get("objectMap");
        String type = map.get("type").toString();
        String tableName = map.get("tableName").toString();
        return operationLogService.addOperationLogs(mapParams,objectMap,type,tableName);
    }
}
