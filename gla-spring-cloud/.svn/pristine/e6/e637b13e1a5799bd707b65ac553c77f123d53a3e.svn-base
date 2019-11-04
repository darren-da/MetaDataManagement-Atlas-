package com.gla.datacenter.zuul.filter;

import com.netflix.client.http.HttpResponse;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.ribbon.RibbonHttpResponse;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * @Description: 统一处理返回结果
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/12/4 13:54
 */
@Configuration
public class ResponseFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(ResponseFilter.class);
    private static Integer NUM = 1;
    @Override
    public Object run() {

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //Object zuulResponse = RequestContext.getCurrentContext().get("zuulResponse");
        try {
            // 获取返回值内容，加以处理
            /*RibbonHttpResponse resp = (RibbonHttpResponse) zuulResponse;
            System.err.println("resp.getBody()的值:" + resp.getBody());
            System.err.println("resp.getStatusCode()的值:" + resp.getStatusCode());
            System.err.println("resp.getStatusText()的值:" + resp.getStatusText());*/
            request.getParameterMap();
            Map<String, List<String>> requestQueryParams = context.getRequestQueryParams();
            Map<String, String> zuulRequestHeaders = context.getZuulRequestHeaders();
            ServletInputStream inputStream = request.getInputStream();
            if(inputStream != null){
                //部分参数
                String requestParam = IOUtils.toString(inputStream);
                System.err.println("requestParam的值:" + requestParam);
            }


            InputStream stream = context.getResponseDataStream();
            int status = context.getResponseStatusCode();
            String body = IOUtils.toString(stream);
            System.out.println(body);
            logger.info("返回编码stream：");
            //你的处理逻辑，加密，添加新的返回值等等.....
            // 内容重新写入
            context.setResponseBody(body);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public boolean shouldFilter() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        System.err.println(request.getRequestURI());
        //String requestURI = String.valueOf(ctx.get("requestURI"));
        String requestURI = String.valueOf(request.getRequestURI());

        if(requestURI.indexOf("api/center/v1") < 0){
            return false;
        }
        /*if (requestURI.indexOf("demo")==-1||requestURI.indexOf("csp")==-1||requestURI.indexOf("api/center/v1")==-1) {
            //不需要处理的URL请求，返回false
            return false;
        }*/
        return true;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 3;
    }

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;// 在请求被处理之后，会进入该过滤器
    }

}
