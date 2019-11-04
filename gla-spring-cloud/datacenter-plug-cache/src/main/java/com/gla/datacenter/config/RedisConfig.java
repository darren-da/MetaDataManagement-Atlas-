package com.gla.datacenter.config;

import com.gla.datacenter.domain.OrderInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 2018/9/25
 * Time: 16:09
 * Intro:...
 * To change this template use File | Settings | File Templates.
 */
@Configuration
public class RedisConfig {

    /**
     * orderRedisTemple序列化对象采用json的格式
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, String> cacheRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    throws UnknownHostException {
        RedisTemplate<Object,String> template=new RedisTemplate<Object, String>();
        RedisSerializer<String> stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer);
        template.setValueSerializer(stringSerializer);
        template.setHashKeySerializer(stringSerializer);
        template.setHashValueSerializer(stringSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<String> jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<String>(String.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return  template;
    }


}
