



package com.gla.datacenter.filter;

import com.gla.datacenter.core.utils.URLUtils;
import com.gla.datacenter.service.ApiManagerClientService;
import com.limp.framework.core.constant.ConstantClazz;
import io.netty.buffer.ByteBufAllocator;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;





/**
 * @Author: zhangbo
 * @Date: 2019/2/27 15:13
 * @Description: 修改gateway路由地址
 */





@Component
public class RouteFilter implements GlobalFilter,Ordered {

    @Autowired
    private ApiManagerClientService apiManagerClientService;


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        URI uri2 = request.getURI();
        String method = request.getMethodValue();
        HttpHeaders headers=exchange.getRequest().getHeaders();
        String contentType = headers.getFirst("Content-Type");
        String requestURI = uri2.getRawPath();
        //根据requestURI获取apiCode
        if(StringUtils.isNotBlank(requestURI)){
            String code = URLUtils.subStringUrl(requestURI);
            if(StringUtils.isNotBlank(code)){
                //根据apicode获取api信息
                Map<String, Object> apiInformation = apiManagerClientService.getApiInformationByCode(code);
                if(apiInformation != null && !apiInformation.isEmpty()){
                    //筛选需要转发的api(api接口为转发才需要)
                    if(Byte.parseByte(apiInformation.get("API_TYPE").toString()) != ConstantClazz.API_TYPE_FORWARD){
                    }else{
                        String url = (String)apiInformation.get("URL");
                        if(StringUtils.isNotBlank(url)){
                            URI uri = UriComponentsBuilder.fromHttpUrl(url).build().toUri();
                            ServerHttpRequest req = request.mutate().uri(uri).build();
                            Route route = (Route) exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
                            Route newRoute = Route.async()
                                    .asyncPredicate(route.getPredicate())
                                    .filters(route.getFilters())
                                    .id(route.getId())
                                    .order(route.getOrder())
                                    .uri(uri).build();
                            exchange.getAttributes().put(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR, newRoute);
                            //ServerHttpRequest newRequest = exchange.getRequest();
                            if ("POST".equals(method) && !contentType.startsWith("multipart/form-data")){
                                String bodyStr = resolveBodyFromRequest(req);
                                //下面将请求体再次封装写回 到 request 里,传到下一级.
                                DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
                                Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
                                req = new ServerHttpRequestDecorator(req) {
                                    @Override
                                    public Flux<DataBuffer> getBody() {
                                        return bodyFlux;
                                    }
                                };
                            }
                            /*ServerWebExchange build = exchange.mutate().request(req).build();
                            URI uri1 = build.getRequest().getURI();
                            System.err.println("最后的url:" + uri1.toString());
                            Route attribute = (Route)build.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
                            URI routeUri = attribute.getUri();
                            System.err.println("最后的route:" + attribute.getUri().toString());
                            boolean encoded = ServerWebExchangeUtils.containsEncodedParts(uri1);
                            URI mergedUrl = UriComponentsBuilder.fromUri(uri1).scheme(routeUri.getScheme()).host(routeUri.getHost()).port(routeUri.getPort()).build(encoded).toUri();*/
                            return chain.filter(exchange.mutate().request(req).build());
                        }
                    }
                }
            }
        }
        //ServerWebExchangeUtils.addOriginalRequestUrl(exchange,request.getURI());
        //exchange.getResponse().setComplete();
        return chain.filter(exchange.mutate().build());
    }

    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest){
        //获取请求体
        Flux<DataBuffer> body = serverHttpRequest.getBody();
        StringBuilder sb = new StringBuilder();

        body.subscribe(buffer -> {
            byte[] bytes = new byte[buffer.readableByteCount()];
            buffer.read(bytes);
            DataBufferUtils.release(buffer);
            String bodyString = new String(bytes, StandardCharsets.UTF_8);
            sb.append(bodyString);
        });
        return sb.toString();
    }


    private DataBuffer stringBuffer(String value){
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }


    @Override
    public int getOrder() {
        return 5;
    }

}



