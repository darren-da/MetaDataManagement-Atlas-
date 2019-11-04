package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.OperationLog;
import com.limp.framework.boss.domain.OperationSetting;
import com.limp.framework.core.bean.Pager;

import java.util.List;
import java.util.Map;

public interface OperationLogService {


    /**
     *
     * 功能描述: 
     *
     * @param: [mapParams:更新参数, objectMap:原始数据, tableName:表名(对象名称), type:操作类型]
     * @return: void
     * @auther: zhangbo
     * @date: 2018/10/22 13:55
     */
    void getRunable(Map<String, Object> mapParams, Map<String, Object> objectMap,String tableName, String type);

    /**
     *
     * 功能描述: 查询行为审计日志列表(分页)
     *
     * @param: [operationLog, pager]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/23 11:05
     */
    
    String getOperationList(OperationLog operationLog, Pager pager);

    /**
     *
     * 功能描述: 查询行为审计日志配置别表(分页)
     *
     * @param: [operationSetting, pager]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/23 11:05
     */
    
    String getOperationSettingList(OperationSetting operationSetting, Pager pager);

    /**
     *
     * 功能描述: 新增或者编辑行为审计日志配置
     *
     * @param: [operationSetting]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/23 11:06
     */
    
    String saveOperationSetting(OperationSetting operationSetting);

    /**
     *
     * 功能描述: 批量删除行为审计日志配置
     *
     * @param: [ids]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/23 11:06
     */
    
    String deleteOperationSetting(String ids);

    /**
     *
     * 功能描述: 根据id获取行为审计日志详情
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/23 11:06
     */
    
    String getOperationById(String id);

    String getOperation(String pojoName);

    Map<String, Object> converMap(Map<String, Object> map, String str);

    void insertOperationLog(Object beanAfter,Object beanBefor,String tableName,String type);
}
