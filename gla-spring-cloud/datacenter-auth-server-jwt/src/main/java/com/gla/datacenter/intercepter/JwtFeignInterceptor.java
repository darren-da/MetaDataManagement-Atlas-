package com.gla.datacenter.intercepter;

import com.limp.framework.utils.StrUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/1 21:33
 */
@Component
public class JwtFeignInterceptor implements RequestInterceptor {
    private final String key = "Authorization";


    @Override
    public void apply(RequestTemplate template) {

        if (!template.headers().containsKey(key)) {
            String currentToken = ApplicationContextHolder.currentToken();
            if (!StrUtils.isBlank(currentToken)){
                template.header(key, currentToken);
            }
        }
    }

}
