package com.limp.framework.boss.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 来标注一个主程序：是springboot应用
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.limp.framework.boss")
@MapperScan("com.limp.framework.boss.mapper.oracle")
//开启定时任务
@EnableScheduling
//新增
public class LpFrameStart {

	public static void main(String[] args) {
		SpringApplication.run(LpFrameStart.class, args);
		System.out.println("启动成功...");
	}
}
