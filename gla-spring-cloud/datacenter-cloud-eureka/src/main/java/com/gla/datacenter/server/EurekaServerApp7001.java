package com.gla.datacenter.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaServerApp7001
{
	public static void main(String[] args)
	{
		SpringApplication.run(EurekaServerApp7001.class, args);
		System.out.println("/*****EurekaServerApp启动成功7001***************/");
	}
}
