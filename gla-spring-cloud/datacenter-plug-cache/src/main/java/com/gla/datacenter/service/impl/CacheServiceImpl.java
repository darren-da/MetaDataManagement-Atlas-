package com.gla.datacenter.service.impl;

import com.gla.datacenter.service.CacheService;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import redis.clients.jedis.*;

import java.util.concurrent.TimeUnit;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/25 19:47
 */
@Service
public class CacheServiceImpl  implements CacheService{
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    // EX = seconds; PX = milliseconds 单位
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private Logger log= LoggerFactory.getLogger(CacheServiceImpl.class);


    @Autowired
    private RedisTemplate cacheRedisTemplate;


    @Override
    public boolean setCache(String key, Object value, long time) {
        log.debug("/*****************进入设置set缓存方法*****************/");

        try {
            if(time>0){
                cacheRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else{
                cacheRedisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Object getCache(String key) {
        log.debug("/*****************进入设置获取缓存方法*****************/");
        log.debug(TextUtils.format("/**********获取 缓存：key-->{0}************************/",key));
        return  key==null?null:cacheRedisTemplate.opsForValue().get(key);
    }

    @Override
    public void delCache(String ... key) {
        log.debug("/*****************进入设置删除缓存方法*****************/");
        log.debug(TextUtils.format("/**********删除缓存：key-->{0}************************/",key));
        if(key!=null&&key.length>0){
            if(key.length==1){
                cacheRedisTemplate.delete(key[0]);
            }else{
                cacheRedisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }



    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    @Override
    public boolean getLock(final String lockKey,final String requestId, final int expireTime){
        String status = (String) cacheRedisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    JedisCommands commands = (JedisCommands)  connection.getNativeConnection();
                    String status = commands.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
                    return status;
                }
            });
            if ("OK".equals(status)) {//抢到锁
                return true;
            }


        return false;
    }

}

