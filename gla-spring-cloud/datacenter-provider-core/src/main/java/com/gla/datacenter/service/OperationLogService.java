package com.gla.datacenter.service;

import java.util.Map;

public interface OperationLogService {

    String addOperationLogs(Map<String, Object> mapParams, Map<String, Object> objectMap, String type, String tableName);

    Map<String, Object> converMap(Map<String, Object> map, String str);
}
