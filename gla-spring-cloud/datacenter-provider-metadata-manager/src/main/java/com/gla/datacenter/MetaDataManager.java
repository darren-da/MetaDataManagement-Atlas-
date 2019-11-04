package com.gla.datacenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 16:51
 */
@SpringBootApplication
@ComponentScan({"com.limp.framework.boss","com.gla.datacenter"})
//@ComponentScan(basePackages = "com.gla.datacenter")
//@MapperScan("com.gla.datacenter.mapper.mysql")
@MapperScan({"com.limp.framework.boss.mapper.oracle","com.gla.datacenter.mapper.mysql"})
public class MetaDataManager {

    public static void main(String[] args) {
        SpringApplication.run(MetaDataManager.class, args);
        System.out.println("启动成功...");
    }
}
