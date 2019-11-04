package com.gla.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zhangbo
 * @Date: 2019/6/18 14:22
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
@EnableFeignClients(basePackages= {"com.gla.datacenter"})
//@ComponentScan({"com.limp.framework.boss","com.gla.datacenter"})
//@ComponentScan(basePackages = "com.limp.framework.boss")
//@MapperScan({"com.  limp.framework.boss.mapper.oracle","com.gla.datacenter.mapper.mysql"})
public class ProviderMDM {
//com.limp.framework.boss.domain,
    public static void main(String[] args) {
        SpringApplication.run(ProviderMDM.class,args);
        System.out.println("ProviderMDM 启动完成");
    }
}
