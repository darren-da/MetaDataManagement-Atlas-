package com.gla.datacenter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Auther: zhangbo
 * @Date: 2018/11/7 16:11
 * @Description:
 */
@Component
public class UrlConfig {

    @Value("${api.config.url}")
    private String url;

    @Value("${api.config.forwardurl}")
    private String forwardUrl;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForwardUrl() {
        return forwardUrl;
    }

    public void setForwardUrl(String forwardUrl) {
        this.forwardUrl = forwardUrl;
    }
}
