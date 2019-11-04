package com.gla.datacenter.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.gla.datacenter.service"})
@ComponentScan("com.gla.datacenter")
public class DataCenterConsumer
{
	public static void main(String[] args)
	{
		SpringApplication.run(DataCenterConsumer.class, args);

		System.err.println("/***********消费者启动成功8002*********/");
	}

}
