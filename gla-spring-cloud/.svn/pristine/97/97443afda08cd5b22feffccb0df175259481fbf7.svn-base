package com.gla.datacenter.controller;

import com.gla.datacenter.service.CacheService;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 缓存控制
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/25 20:11
 */
@RestController
public class PlugCacheController {

    private Logger loger = LoggerFactory.getLogger(PlugCacheController.class);

    @Autowired
    CacheService cacheService;

    /**
     * 设置 缓存
     *
     * @param key   缓存key
     * @param value 缓存value
     * @param time  缓存时间
     * @return
     */
    @RequestMapping(value = "/setCache")
    public String setCache(@RequestParam("key") String key, @RequestParam("value") String value, @RequestParam("time") Long time) {
        loger.info("/**进入设置缓存controller********/");
        loger.info(TextUtils.format("/**设置缓存:key-->{0}********/", key));
        Boolean flay = cacheService.setCache(key, value, time);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }

    /**
     * 通过key获取缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/getCache")
    public String getCache(@RequestParam("key") String key) {
        loger.info("/**进入获取缓存controller********/");
        loger.info(TextUtils.format("/**获取缓存:key-->{0}********/", key));
        Object obj = cacheService.getCache(key);
        if(!StrUtils.isBlank(obj)){
            return obj.toString();
        }
        return JsonUtils.toJson(obj);
    }

    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    @RequestMapping(value = "/getLock")
    public String getLock(@RequestParam("lockKey") String lockKey,@RequestParam("requestId") String requestId,
    @RequestParam("expireTime") String expireTime) {
        boolean flay= cacheService.getLock(lockKey,requestId,Integer.parseInt(expireTime));
       if(flay){
           return "true";
       }
        return "false";
    }

    /**
     * 通过key获取缓存
     *
     * @param key
     * @return
     */
    @RequestMapping(value = "/delCache")
    public String delCache(@RequestParam("key") String key) {
        loger.info("/**进入删除缓存controller********/");
        loger.info(TextUtils.format("/**删除缓存:key-->{0}********/", key));
        cacheService.delCache(key);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
    }

}
