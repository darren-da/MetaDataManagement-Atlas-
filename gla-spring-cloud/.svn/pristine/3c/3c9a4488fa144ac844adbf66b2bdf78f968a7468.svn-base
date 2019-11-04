package com.gla.datacenter.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClientResponse;

/**
 * @Description: 访问耗时拦截
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/12/3 17:21
 */
public class APIGatewayFilter implements GatewayFilter, Ordered {
    private Logger logger= LoggerFactory.getLogger(AuthSignatureFilter.class);
    private static final String COUNT_Start_TIME = "countStartTime";


    /**
     *
     * @param exchange
     * @param chain
     * @return
     */

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(COUNT_Start_TIME, System.currentTimeMillis());

        return chain.filter(exchange).then(

                Mono.fromRunnable(() -> {
                    Long startTime = exchange.getAttribute(COUNT_Start_TIME);
                    Long endTime=(System.currentTimeMillis() - startTime);



                    /**
                     * 访问用时
                     */
                    if (startTime != null) {
                        logger.info("访问耗时:");
                        logger.info(exchange.getRequest().getURI().getRawPath() + ": " + endTime + "ms");
                    }
                    logger.info( "host地址");
                    logger.info( exchange.getRequest().getURI().getHost());
                    if("localhost".equals(exchange.getRequest().getURI().getHost())){


//                        exchange.getRequest().getURI().getHost()
                                //;http://192.168.26.113:8001
                    }

                    /**
                     * 访问流量统计
                     */


                    /**
                     * 访问聚合
                     */
                    ServerHttpResponse response = exchange.getResponse();
                    HttpClientResponse clientResponse = exchange.getAttribute(ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR);
                    if (clientResponse == null) {
//                        return Mono.empty();
                    }
//                   logger.info(clientResponse.currentContext());



                })
        ).then(
                Mono.defer(() -> {
                    ServerHttpRequest request = exchange.getRequest();
                    ServerHttpResponse response = exchange.getResponse();
                    HttpClientResponse clientResponse = exchange.getAttribute(ServerWebExchangeUtils.CLIENT_RESPONSE_ATTR);
                    if (clientResponse == null) {
                        return Mono.empty();
                    }
                    //FIXME I want to cache body and rewrite it
                   /* NettyDataBufferFactory factory = (NettyDataBufferFactory) response.bufferFactory();
                    Flux<DataBuffer> body = clientResponse.receive().retain().map(factory::wrap);
                    boolean isOkStatus = response.getStatusCode() == HttpStatus.OK;
                    boolean filterFlag = isOkStatus && clientResponse != null;
                    if (filterFlag) {
                        MediaType contentType = response.getHeaders().getContentType();
                        if (contentType != null && contentType.includes(MediaType.TEXT_HTML)) {
                            body.flatMap(dataBuffer -> rebuildFluxBody(exchange, dataBuffer));
                        }
                    }
//                    request = new ServerHttpRequestDecorator(request) {
//                        @Override
//                        public Flux<DataBuffer> getBody() {
//                            return Flux.just(stringBuffer(html));
//                        }
//                    };//封装我们的request*/
                    return chain.filter(exchange.mutate().request(request).build());
                }));
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
