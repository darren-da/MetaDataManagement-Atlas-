package com.gla.datacenter.consumer.config;

import com.gla.datacenter.consumer.filter.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 配置
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/17 14:45
 */
@Configuration
public class WebMvcFilterConfigurerAdapter implements WebMvcConfigurer {
    /**
     * 解决跨域的问题
     * @return
     */
 @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 允许cookies跨域
        config.addAllowedOrigin("*");// #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        config.addAllowedHeader("*");// #允许访问的头信息,*表示全部
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

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
//        addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截

        //暂时添加的是 log日志拦截，新增权限方面
        registry.addInterceptor(getSecurityInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/system/login") //登录页  ：：增加需要拦截的信息
                .excludePathPatterns("/system/user/sendEmail") //发送邮箱
                .excludePathPatterns("/system/user/register") //用户注册
                .excludePathPatterns("/system/user/login"); //用户登录
//             addInterceptors(registry);
    }

}
