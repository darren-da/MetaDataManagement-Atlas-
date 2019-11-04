package com.gla.datacenter.service;

import com.gla.datacenter.domain.Command;
import com.gla.datacenter.model.PublishApiModel;
import com.limp.framework.core.abs.AbstractService;

import java.util.List;
import java.util.Map;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 13:40 2018/8/18
 * @modified By:
 */
public interface CommandService extends AbstractService<Command> {

    List<Map<String,Object>> runCommand(String code, Map<String, String> param);

    /**
     * 获取格式之后的sql
     * @param code
     * @param param
     * @return
     */
    public String  getFormatSqlByCode(String code, Map<String, String> param);

    /**
     * 预览sql
     * @param sql
     * @param param
     * @return
     */
    List<Map<String,Object>> runTestSQL(String sql, Map<String, String> param);

    /**
     *
     * 功能描述: 发布api
     *
     * @param: 
     * @param id
     * @param publishApiModel
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/8/16 14:26
     */
    String publishApi(String id, PublishApiModel publishApiModel);

    /**
     *
     * 功能描述: 重置api为可发布状态
     *
     * @param: 
     * @param codes
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/8/16 14:26
     */
    String resetApiStatusByCodeList(List<String> codes);
}
