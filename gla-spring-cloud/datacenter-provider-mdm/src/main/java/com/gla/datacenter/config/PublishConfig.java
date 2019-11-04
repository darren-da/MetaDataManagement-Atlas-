package com.gla.datacenter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: zhangbo
 * @Date: 2019/7/10 14:06
 * @Description:
 */
@Component
public class PublishConfig {

    @Value("${publish.url}")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
