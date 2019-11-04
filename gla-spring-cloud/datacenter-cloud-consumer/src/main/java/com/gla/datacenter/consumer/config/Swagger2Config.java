
package com.gla.datacenter.consumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2

/**
 * Swagger2配置类
 * @ClassName: Swagger2Config
 * @Description: TODO
 * @author: zhangbo
 * @date: 2018年9月19日 下午4:43:14
 */

public class Swagger2Config {
	
	static final Logger log = LoggerFactory.getLogger(Swagger2Config.class);

	@Profile({"dev"})
	@Bean
    public Docket createRestApi() {
		System.err.println("开始加载 Swagger2Config 配置类！");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()) 
                .select()  // 选择那些路径和ape会生成document
                //扫描所有有注解的api
                .apis(RequestHandlerSelectors.basePackage("com.gla.datacenter.consumer.controller"))
                /*.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))*/
                .paths(PathSelectors.any())
                .build();
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("")
                .description("")
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))
                .version("1.0")
                .build();
    }


}

