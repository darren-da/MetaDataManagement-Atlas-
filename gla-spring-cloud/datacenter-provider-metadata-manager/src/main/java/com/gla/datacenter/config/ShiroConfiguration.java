/*
package com.gla.datacenter.config;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.util.LinkedHashMap;

*/
/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 20:56 2018/7/10
 * @modified By:
 *//*

//@Configuration
public class ShiroConfiguration {
    @Value("${redis.shiro.host}")
    private String host;

    @Value("${redis.shiro.port}")
    private int port;

    @Value("${redis.shiro.password}")
    private String password;

    @Value("${redis.shiro.timeout}")
    private int timeout;

    */
/**
     *
     * @param securityManager
     * @return
     *//*

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置访问权限 拦截器.
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<String, String>();
        //注意过滤器配置顺序 不能颠倒
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了，登出后跳转配置的loginUrl
        filterChainDefinitionMap.put("/logout", "logout");
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/druid/**", "anon");

        filterChainDefinitionMap.put("/static/**", "anon");
        //静态页面
        filterChainDefinitionMap.put("/systemsite/**", "anon");
        //登录页面
        filterChainDefinitionMap.put("/system/nav/login", "anon");
        //工作桌面
        filterChainDefinitionMap.put("/system/nav/desk", "anon");
        //ajax登陆
        filterChainDefinitionMap.put("/system/user/login", "anon");
//        anon不用认证（登录）就能访问（单词注意大小写）
        filterChainDefinitionMap.put("/login", "anon");
//        - authc: 需要认证(登录)才能使用，例如/admins/user/**=authc，没有参数
        filterChainDefinitionMap.put("/**", "authc");
        //配置shiro默认登录界面地址，前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
//        shiroFilterFactoryBean.setLoginUrl("/system/nav/login");
        shiroFilterFactoryBean.setLoginUrl("/system/nav/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/system/nav/main");
        //未授权界面;
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    */
/**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     *
     * @return
     *//*

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    */
/**
     *将自己的验证方式加入容器
     *//*

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        //用自定义的用户密码策略进行校验
//        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    */
/**
     *注入bean：shiro 的核心安全接口
     * @return
     *//*

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        return securityManager;
    }

    //自定义sessionManager
    @Bean
    public SessionManager sessionManager() {
        MySessionManager mySessionManager = new MySessionManager();
        mySessionManager.setSessionDAO(redisSessionDAO());
        return mySessionManager;
    }

    */
/**
     * 配置shiro redisManager
     * <p>
     * 使用的是shiro-redis开源插件
     *todo
     * @return
     *//*

//    @ConfigurationProperties(prefix = "redis.shiro")
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setPassword(password);
        //用户权限信息缓存时间
        redisManager.setExpire(timeout);// 配置过期时间
        return redisManager;
    }

    */
/**
     * cacheManager 缓存 redis实现
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     *//*

    @Bean
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    */
/**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * <p>
     * 使用的是shiro-redis开源插件
     *//*

    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
//      Custom your redis key prefix for session management, if you doesn't define this parameter,
//      shiro-redis will use 'shiro_redis_session:' as default prefix
//      redisSessionDAO.setKeyPrefix("");
        return redisSessionDAO;
    }

    */
/***
     * 【注释掉一下两个bean可以屏蔽权限】
     * 异常问题：springboot 与shiro整合是发现@value获取不到值；
     * 两种方案:1、注释掉  2、或者改成 public static（添加static） LifecycleBeanPostProcessor lifecycleBeanPostProcessor()
     * 参考链接-->https://stackoverflow.com/questions/15539485/specifying-shiros-lifecyclebeanpostprocessor-in-programmatic-spring-configurat
     * 配置Shiro是多了这个配置 shiro生命周期处理器
     * @return
     *//*

    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor(Ordered.LOWEST_PRECEDENCE);
    }

    */
/**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     *//*

    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }
        */
/**
         * 开启shiro aop注解支持.
         * 使用代理方式;所以需要开启代码支持;
         * @param securityManager
         * @return
         *//*

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    */
/**
     * 注册全局异常处理
     * @return
     *//*

    @Bean(name = "exceptionHandler")
    public HandlerExceptionResolver handlerExceptionResolver() {
        return new MyExceptionHandler();
    }
}
*/
