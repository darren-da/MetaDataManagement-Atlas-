package com.gla.datacenter.config;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.Receiver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;

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
    public RedisTemplate<Object, OrderInfo> OrderInfoRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    throws UnknownHostException {
        RedisTemplate<Object,OrderInfo> template=new RedisTemplate<Object, OrderInfo>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<OrderInfo> jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<OrderInfo>(OrderInfo.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return  template;
    }

    /**
     * 定义注解时使用 的Manager
//     * @param orderInfoRedisTemplate
     * @return
     */
    @Bean
//    public RedisCacheManager orderManagerCacheManager(RedisTemplate<Object,OrderInfo> orderInfoRedisTemplate){
    public RedisCacheManager orderManagerCacheManager(RedisConnectionFactory redisConnectionFactory){

//        RedisCacheManager cacheManager=new RedisCacheManager(orderInfoRedisTemplate);
//        return  cacheManager;
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
//                .entryTtl(Duration.ofHours(24)); // 设置缓存有效期一小时
        return RedisCacheManager
                .builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory))
                .cacheDefaults(redisCacheConfiguration).build();


    }
    /**
     * orderRedisTemple序列化对象采用json的格式
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, String> StrRedisTemplate(RedisConnectionFactory redisConnectionFactory)
    throws UnknownHostException {
        RedisTemplate<Object,String> template=new RedisTemplate<Object, String>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<String> jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer<String>(String.class);
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        return  template;
    }

    /**
     * 定义注解时使用 的Manager
     * @return
    @Bean
    public RedisCacheManager strManagerCacheManager(RedisTemplate<Object,String> strRedisTemplate){
        RedisCacheManager cacheManager=new RedisCacheManager(strRedisTemplate);
        cacheManager.setUsePrefix(true);
        return  cacheManager;
    }*/

   //以下三个方法新增解决消息队列问题
    @Bean
    Receiver receiver(CountDownLatch latch) {
        return new Receiver(latch);
    }

    @Bean
    CountDownLatch latch() {
        return new CountDownLatch(1);
    }

    @Bean
    StringRedisTemplate template(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    /**
     * 在spring data redis中，利用redis发送一条消息和接受一条消息，需要三样东西：
       一个连接工厂
       一个消息监听容器
     Redis template
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                            MessageListenerAdapter listenerAdapter) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic("order"));

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}
