package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.service.CacheService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述:单机版实现类
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 17-7-9
 * Time: 下午8:26
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CacheServiceImpl  implements CacheService {

    private static Logger logger= Logger.getLogger(CacheServiceImpl.class);

    /**
     * todo：需要切换为redis缓存
     */

    public   static Map<String,String> cacheMap=new HashMap<String,String>();

    /**
     *  异常信息说明：at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations:
     *
     */
//    @Autowired
//    private static  JedisPool jedisPool=SpringContextHolder.getBean(JedisPool.class);

    public CacheServiceImpl() {
    }

    @Override
    public String get(String key) {
//      String string=  RedisCacheUtil.get(key); //通过静态方法获取value
//        String value=SpringContextHolder.getBean(RedisCacheUtil.class).get(key);
        String value=cacheMap.get(key);
        return value;
    }

    @Override
    public String set(String key, String value) {
//        String value1=SpringContextHolder.getBean(RedisCacheUtil.class).set(key,value);
        cacheMap.put(key,value);
        return value;
    }

}
