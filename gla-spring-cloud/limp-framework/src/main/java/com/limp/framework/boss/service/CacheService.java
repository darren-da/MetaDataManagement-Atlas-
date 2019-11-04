package com.limp.framework.boss.service;

/**
 * @Description: 缓存管理
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/17 17:15
 */
public interface CacheService {

    /**
     *
     * @param key
     * @return
     */
    public String get(String key);

    public String set(String key, String value);
}
