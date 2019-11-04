package com.gla.datacenter.filter;

import com.alibaba.fastjson.JSON;
import com.gla.datacenter.domain.RoutePlug;
import com.limp.framework.utils.StrUtils;
import io.netty.buffer.ByteBufAllocator;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.commons.io.IOUtils;

//import com.gla.datacenter.service.RoutePlugService;

/**
 * @Description: 全局类型的filter：鉴权、认证
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/12/3 17:18
 */
@Component
public class AuthSignatureFilter implements GlobalFilter, Ordered {

    private Logger logger = LoggerFactory.getLogger(AuthSignatureFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("/********route-plug获取详细信息***************/");
        ServerHttpRequest request = exchange.getRequest();
        RoutePlug routePlug = new RoutePlug();

        String url = exchange.getRequest().getPath().pathWithinApplication().value();
        if (url.indexOf("/auth/login") != -1) {
            return chain.filter(exchange);
        }
        URI requestUri = request.getURI();
        String method = exchange.getRequest().getMethodValue();
        //地址
        logger.info("请求URL：{}", url);
        logger.info("requestUri：{}", requestUri);
        logger.info("method：{}", method);
        routePlug.setUrl(url);
        routePlug.setUri(requestUri.toString());
        routePlug.setMethod(method);

        //开始 时间
        exchange.getAttributes().put("startTime", System.currentTimeMillis());

        //参数
        logger.info("QueryParams：{}", exchange.getRequest().getQueryParams());
        logger.info("QueryParamsJSON：{}", JSON.toJSON(exchange.getRequest().getQueryParams()));

        routePlug.setQueryParams(JSON.toJSON(exchange.getRequest().getQueryParams()).toString());

        HttpHeaders headers = exchange.getRequest().getHeaders();
        String contentType = headers.getFirst("Content-Type");
        logger.info("Host：{}", headers.getHost());
        logger.info("contentType", contentType);
        logger.info("headersJson：{}", JSON.toJSON(headers));
        routePlug.setHost(headers.getHost().toString());
        routePlug.setQueryHeard(JSON.toJSON(headers).toString());

        URI ex = UriComponentsBuilder.fromUri(requestUri).build(true).toUri();
        ServerHttpRequest newRequest = request.mutate().uri(ex).build();


        //记录发送的参数：获取requstBody体中信息
        if (!StrUtils.isBlank(contentType) && "POST".equals(method) && !contentType.startsWith("multipart/form-data")) {
            String bodyStr = resolveBodyFromRequest(request);
            //下面将请求体再次封装写回到 request 里,传到下一级.
            DataBuffer bodyDataBuffer = stringBuffer(bodyStr);
            Flux<DataBuffer> bodyFlux = Flux.just(bodyDataBuffer);
            newRequest = new ServerHttpRequestDecorator(newRequest) {
                @Override
                public Flux<DataBuffer> getBody() {
                    return bodyFlux;
                }
            };
            routePlug.setBody(formatStr(bodyStr));
            logger.info("requesBody:{}", bodyStr);
            logger.info("requesBody:{}", formatStr(bodyStr));
        }


        //解决respnse被截断的问题，设置 CONTENT_LENGTH的长度；参考链接 https://github.com/spring-cloud/spring-cloud-gateway/issues/47
        /*HttpHeaders myHeaders = new HttpHeaders();
        copyMultiValueMap(request.getHeaders(), myHeaders);
        myHeaders.remove(HttpHeaders.CONTENT_LENGTH);
        Integer len=1024*1000;
        myHeaders.set(HttpHeaders.CONTENT_LENGTH, String.valueOf(len));*/


        //记录response的 返回数据
        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();


        /********************token鉴权End******************************/


        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    return super.writeWith(fluxBody.map(dataBuffer -> {
                        byte[] content = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(content);
                        //释放掉内存
                        DataBufferUtils.release(dataBuffer);
                       /* String s = new String(content, Charset.forName("UTF-8"));
                        //TODO，s就是response的值，想修改、查看就随意而为了
                        byte[] uppedContent = new String(content, Charset.forName("UTF-8")).getBytes();*/

                        String responseData = null;
                        try {
                            //赋值给实体类
//                            responseData = IOUtils.toString(content);
//                            routePlug.setSize(responseData.getBytes().length);
                            routePlug.setResultdata(responseData);

                            //请求用时
                            Long startTime = exchange.getAttribute("startTime");
                            if (startTime != null) {
                                long executeTime = (System.currentTimeMillis() - startTime);
                                routePlug.setUsetime(Integer.parseInt(executeTime + ""));
                            }
//                            routePlugService.save(routePlug);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        logger.debug("/*************返回content*******/");
                        return bufferFactory.wrap(content);
                    }));
                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };

//        return chain.filter(exchange.mutate().request(request).build());
        return chain.filter(exchange.mutate().request(newRequest).response(decoratedResponse).build());
    }

    private static <K, V> void copyMultiValueMap(MultiValueMap<K, V> source, MultiValueMap<K, V> target) {
        source.forEach((key, value) -> target.put(key, new LinkedList<>(value)));
    }

    private Mono<Void> returnMono(GatewayFilterChain chain, ServerWebExchange exchange, String accessRecord) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute("startTime");
            if (startTime != null) {
                long executeTime = (System.currentTimeMillis() - startTime);
//                accessRecord.setExpendTime(executeTime);
//                accessRecord.setHttpCode(Objects.requireNonNull(exchange.getResponse().getStatusCode()).value());
//                writeAccessLog(JSON.toJSONString(accessRecord) + "\r\n");
            }
        }));
    }

    @Override
    public int getOrder() {
        return 2;
    }

    /**
     * 获取请求体中的字符串内容
     *
     * @param serverHttpRequest
     * @return
     */
    private String resolveBodyFromRequest(ServerHttpRequest serverHttpRequest) {
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


    private DataBuffer stringBuffer(String value) {
        byte[] bytes = value.getBytes(StandardCharsets.UTF_8);
        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(ByteBufAllocator.DEFAULT);
        DataBuffer buffer = nettyDataBufferFactory.allocateBuffer(bytes.length);
        buffer.write(bytes);
        return buffer;
    }

    /**
     * 去掉空格,换行和制表符
     *
     * @param str
     * @return
     */
    private String formatStr(String str) {
        if (str != null && str.length() > 0) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            return m.replaceAll("");
        }
        return str;
    }

    private void writeAccessLog(String str) {
        File file = new File("access.log");
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    file.setWritable(true);
                }
            } catch (IOException e) {
                logger.error("创建访问日志文件失败.{}", e.getMessage(), e);
            }
        }

        try (FileWriter fileWriter = new FileWriter(file.getName(), true)) {
            fileWriter.write(str);
        } catch (IOException e) {
            logger.error("写访问日志到文件失败. {}", e.getMessage(), e);
        }

    }

}
