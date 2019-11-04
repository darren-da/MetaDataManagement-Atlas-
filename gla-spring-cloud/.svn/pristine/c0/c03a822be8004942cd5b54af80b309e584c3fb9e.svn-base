package com.gla.datacenter.zuul.service;

import com.gla.datacenter.zuul.domain.ZuulRouteEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 动态路由添加
 * @Author:  shinians
 * @Modified By:
 * @Date: 2018/12/5 15:20
 */
@Component
public class PropertiesService {

    public Map<String, ZuulRoute> getProperties() {
        Map<String, ZuulRoute> routes = new LinkedHashMap<>();
        List<ZuulRouteEntity> list = new ArrayList<>();
        ZuulRouteEntity zuulRouteEntity=new ZuulRouteEntity();
        zuulRouteEntity.setId("testdemo");
        zuulRouteEntity.setUrl("http://www.baidu.com");
        zuulRouteEntity.setPath("/baidu/**");
        list.add(zuulRouteEntity);
        list.forEach(entity -> {
            if (StringUtils.isEmpty(entity.getPath())) return;
            ZuulRoute zuulRoute = new ZuulRoute();
            BeanUtils.copyProperties(entity, zuulRoute);
            routes.put(zuulRoute.getPath(), zuulRoute);
        });
        return routes;
    }
}
