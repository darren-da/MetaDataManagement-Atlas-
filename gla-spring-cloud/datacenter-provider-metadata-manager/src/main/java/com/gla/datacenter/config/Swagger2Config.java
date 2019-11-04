package com.gla.datacenter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:用 @Configuration注解该类，等价于XML中配置beans；用@Bean标注方法等价于XML中配置bean。
 *  @EnableSwagger2 表示开启Swagger
 * @date:Created in 21:35 2018/7/9
 * @modified By:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                   //为当前包路径
//                .apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.limp.framework.boss.controller"))
                .paths(PathSelectors.any())
                .build();
    }
// 构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("swagger构建api文档(功能测试)")
                        //描述
                .description("limp-framework框架V2.0基于restfun风格构建")
                .termsOfServiceUrl("http://wwww.shinians.com")
                        //创建人
                .contact(new Contact("shinians", "shiniandate@163.com", "xxx@qq.com"))
                .version("1.0")
                .build();
    }

}
