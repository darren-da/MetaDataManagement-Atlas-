package com.gla.datacenter.zuul.config;

import com.gla.datacenter.zuul.DynamicZuulRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: DynamicZuulConfig动态路由
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/12/5 15:28
 */
@Configuration
public class DynamicZuulConfig {

    @Autowired
    private ZuulProperties zuulProperties;

    @Autowired
    private ServerProperties serverProperties;

    @Bean
    public DynamicZuulRouteLocator routeLocator() {
        DynamicZuulRouteLocator routeLocator = new DynamicZuulRouteLocator(
                //todo
                serverProperties.getServlet().getContextPath(), zuulProperties);
        return routeLocator;
    }
}
