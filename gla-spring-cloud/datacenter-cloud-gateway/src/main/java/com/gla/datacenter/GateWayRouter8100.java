package com.gla.datacenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com.gla.datacenter"})
@ComponentScan("com.gla.datacenter")
public class GateWayRouter8100 {

	/**
	 * https://www.imooc.com/qadetail/197921?t=319803
	 * 这是因为spring boot 会默认加载
	 * org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration 这个类
	 * DataSourceAutoConfiguration类使用了@Configuration注解向spring注入了dataSource bean。因为工程中没有关于dataSource相关的配置信息，当spring创建dataSource bean因缺少相关的信息就会报错。
	 * 解决办法发是： 在Application类上增加
	 */
	/**
	 * 基本的转发
	 * 当访问http://localhost:8010/jd
	 * 转发到http://jd.com
	 * @param builder
	 * @return
	 */
	/*@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		//生成比当前时间早一个小时的UTC时间
//		ZonedDateTime minusTime = LocalDateTime.now().minusHours(1).atZone(ZoneId.systemDefault());

		return builder.routes()
				//basic proxy
//				.route("after_route", r -> r.after(minusTime)
//						.uri("http://baidu.com")

				.route(r ->r.path("/demo/**")
						//过滤器
						.filters(f -> f.filter(new APIGatewayFilter())
								.filter(new GatewayRateLimitFilterByIP(10,1, Duration.ofSeconds(1))))
						.uri("http://192.168.26.113:8001/demo/HelloServiceDemoUrl?wsdl").order(0).id("demo_route"))

				.route(r ->r.path("/orders1/**")
								.filters(f->f.filter(new APIGatewayFilter())
										.filter(new GatewayRateLimitFilterByIP(10,1, Duration.ofSeconds(1)))
						.stripPrefix(1))
				.uri("http://192.168.26.10:8002/").id("1jd_route"))
						.route(r ->r.path("/test1/**")
								.uri("http://192.168.26.113:8001/").id("jd_route1"))
						.route(r ->r.path("/test2/**")
								.uri("http://192.168.26.10:8002/").id("jd_route2")
				).build();
	}*/

	public static void main(String[] args) {
		SpringApplication.run(GateWayRouter8100.class, args);
		System.out.println("启动success");
	}

}
