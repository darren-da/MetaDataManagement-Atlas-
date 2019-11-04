package com.limp.framework.core.service;

/**
 * @Description: 核心一站式解决方案Service
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/19 17:13
 */
public interface CoreService {

    /**
     * 将jsonStr中的码表转换
     * @param jsonStr
     * @return
     */
    public String transCodeZN(String jsonStr);

    /**
     * 获取码表中的valu值
     * @param key 码表code
     * @return value
     */
    public String getCacheCodeValue(String key);
}
