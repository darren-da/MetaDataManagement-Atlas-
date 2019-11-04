
package com.gla.datacenter.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients(basePackages= {"com.gla.datacenter.service"})
@ComponentScan("com.gla.datacenter")
public class DataCenterZuulApp
{
	public static void main(String[] args)
	{
		SpringApplication.run(DataCenterZuulApp.class, args);
        System.out.println("/******zuul启动成功 8100***************/");
    }
}
