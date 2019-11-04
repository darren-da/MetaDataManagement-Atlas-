package com.gla.datacenter.config;

import com.gla.datacenter.httpMessageConverter.WxMappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/26 12:37
 * @Description:
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplateCenter(ClientHttpRequestFactory factory){
        RestTemplate restTemplate = new RestTemplate(factory);
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        for(int i = 0; i < messageConverters.size(); i++){
            if(messageConverters.get(i) instanceof StringHttpMessageConverter){
                messageConverters.remove(i);
                messageConverters.add(i, converter);
            }
        }
        messageConverters.add(new WxMappingJackson2HttpMessageConverter());
        messageConverters.add(converter);
        messageConverters.add(new WxMappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //时间单位都为ms
        factory.setReadTimeout(5_000);
        factory.setConnectTimeout(5_000);

        return factory;
    }


}


