package com.limp.framework.boss.config;

import com.limp.framework.boss.component.MyLocaleResolver;
import com.limp.framework.boss.filter.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/17 14:45
 */
@Configuration
public class WebMvcFilterConfigurerAdapter implements WebMvcConfigurer {
    @Bean
    public HandlerInterceptor getSecurityInterceptor(){
        return new SecurityInterceptor();
    }
    /**
     * 配置静态资源
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截

        //暂时添加的是 log日志拦截，暂未新增权限方面
        registry.addInterceptor(getSecurityInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/system/login") //登录页
                .excludePathPatterns("/system/user/sendEmail") //发送邮箱
                .excludePathPatterns("/system/user/register") //用户注册
                .excludePathPatterns("/system/user/login"); //用户登录
//            addInterceptors(registry);
    }

    /**
     * 注入国际化 ：bean
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }


}
