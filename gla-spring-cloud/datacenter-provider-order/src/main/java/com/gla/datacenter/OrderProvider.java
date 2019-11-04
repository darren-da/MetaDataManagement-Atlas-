package com.gla.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableCaching  //2 开启缓存
//@EnableRabbit //开启MQ-
@EnableFeignClients(basePackages= {"com.gla.datacenter"})
public class OrderProvider

{
	public static void main(String[] args)
	{
		SpringApplication.run(OrderProvider.class, args);
		System.out.println("/****************OrderProvider_8004提供者启动成功*************/");
	}
}
