package com.gla.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:1
 * @Date: 2018/10/24 11:38
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableFeignClients(basePackages= {"com.gla.datacenter"})
public class ProviderCore {
    public static void main(String[] args)
    {
        SpringApplication.run(ProviderCore.class, args);
        System.out.println("/****************ProviderCore_8006提供者启动成功*************/");
    }
}
