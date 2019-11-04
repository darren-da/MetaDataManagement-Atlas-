package com.gla.datacenter.filter;

import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.UserInfo;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Description: header信息过滤
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/4/1 17:49
 */
public class HeaderAuthFilter implements GlobalFilter,Ordered {

    private Logger logger= LoggerFactory.getLogger(HeaderAuthFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("request = {}", JsonUtils.toJson( exchange.getRequest()) );
//        String token = exchange.getRequest().getQueryParams().getFirst("authToken");

        /*****************token鉴权开始*********************************/
        HttpHeaders headers=exchange.getRequest().getHeaders();
        //获取token
        String   token = headers.getFirst(JwtUtil.HEADER_AUTH);

        //request
        ServerHttpRequest request = exchange.getRequest();

        //记录response的 返回数据
        ServerHttpResponse originalResponse = exchange.getResponse();

        //是否开启 token认证,获取登陆用户
        if(!StrUtils.isBlank(token)){
            try {
                UserInfo userInfo=JwtUtil.getInstance().validateToken(token);
                if(!StrUtils.isBlank(userInfo)) {
                    //下方这种方式是不能向 headers中放数据得！！！！
//                    headers.remove(JwtUtil.HEADER_AUTH);
//                    headers.set("x-user-id", userInfo.getId());

                    //正确设置header的 方式
                    request.mutate().header(JwtUtil.HEADER_AUTH, token).build();
                    request.mutate().header("x-user-id", userInfo.getId()).build();
                    request.mutate().header(JwtUtil.HEADER_X_USER_TOKEN, token).build();
                    System.out.println(1);
                    //将现在的request 变成 change对象
//                    ServerWebExchange build = exchange.mutate().request(host).build();
                }
            }catch (Exception e){
                //过滤该请求，不往下级服务去转发请求，到此结束
                logger.error("access token is error{}",e.getMessage());
                originalResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
                e.printStackTrace();
//                返回错误异常
                return originalResponse.setComplete();
            }

            //如果有token，则进行路由转发
            logger.info("/****token access ******/ ");
        }
        return chain.filter(exchange.mutate().request(request).build());
    }

    /**
     * 数字越小：优先级越高
     * @return
     */

    @Override
    public int getOrder() {
        return 1;
    }
}
