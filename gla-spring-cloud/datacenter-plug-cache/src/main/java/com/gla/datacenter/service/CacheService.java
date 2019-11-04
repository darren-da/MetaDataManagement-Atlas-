package com.gla.datacenter.service;

/**
 * @Description: 缓存管理
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/25 17:15
 */
public interface CacheService {


    /**
     * 设置缓存
     * @param key key值
     * @param value value值
     * @param time 过期时间
     * @return 是否成功
     */
    public boolean setCache(String key,Object value,long time);

    /**
     * 通过key获取缓存
     * @param key 缓存key
     * @return 缓存对象
     */
    public Object getCache(String key);

    /**
     * 通过key删除缓存
     * @param key 缓存key
     */
    public void delCache(String ... key);

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public boolean getLock(final String lockKey,final String requestId, final int expireTime);

}
