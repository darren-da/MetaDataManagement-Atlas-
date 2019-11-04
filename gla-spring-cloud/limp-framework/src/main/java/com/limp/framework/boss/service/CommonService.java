package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.PageLog;
import com.limp.framework.core.service.CoreService;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/17 16:53
 */
public interface CommonService extends CoreService{
    /**
     * 保存日志 pageLog全局性日志
     * @param pageLog
     */
    public void insertPageLog(PageLog pageLog);

   /* *//**
     * 将jsonStr中的码表转换
     * @param jsonStr
     * @return
     *//*
    public String transCodeZN(String jsonStr);

    *//**
     * 获取码表中的valu值
     * @param key 码表code
     * @return value
     *//*
    public String getCacheCodeValue(String key);*/
}
