package com.gla.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableScheduling
@EnableFeignClients(basePackages= {"com.gla.datacenter"})
public class AnalysisProvider
{
	public static void main(String[] args)
	{
		SpringApplication.run(AnalysisProvider.class, args);
		System.out.println("/****************AnalysisProvider_8007提供者启动成功*************/");
	}
}
