package com.gla.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/26 09:13
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients(basePackages= {"com.gla.datacenter"})
public class ProviderApi8010 {
    public static void main(String[] args)
    {
        SpringApplication.run(ProviderApi8010.class, args);
        System.err.println("/****************Provider_Api_8010提供者启动成功*************/");
    }


}
