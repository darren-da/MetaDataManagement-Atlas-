package com.gla.datacenter.zuul.filter;

//import com.gla.auth.jwt.filter.JwtUtil;

import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.UserInfo;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Description: Token拦截
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/15 16:55
 */
@Component
public class AccessFilter  extends ZuulFilter {

    private Logger log= LoggerFactory.getLogger(ZuulFilter.class);

    /**
     * 前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {

        //优先级，数字越大，优先级越低
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        //是否执行该过滤器，true代表需要过滤
        return true;
    }


    @Override
    public Object run() {
        log.info("/*************AccessFilter run方法 进入*************/");
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {},ServletPath is {}", request.getMethod(), request.getRequestURL().toString(),request.getServletPath());

        Enumeration headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            log.info("zuul 访问 key->"+key + ": " + request.getHeader(key));
        }

        //获取传来的参数accessToken
         String token=  request.getHeader(JwtUtil.HEADER_AUTH);

        log.info("访问token{}",token);

        //是否开启 token认证,获取登陆用户
        if(!StrUtils.isBlank(token)){
         try {
             UserInfo userInfo=JwtUtil.getInstance().validateToken(token);
             if(!StrUtils.isBlank(userInfo)) {
                 //设置header信息，绑定信息传递给生产者
                 ctx.addZuulRequestHeader(JwtUtil.HEADER_AUTH,token);
                 ctx.addZuulRequestHeader("x-user-id", userInfo.getId());
                 ctx.addZuulRequestHeader(JwtUtil.HEADER_X_USER_TOKEN,token);
//                 ctx.addZuulRequestHeader("x-role-code", request.getRequestURL().toString());
             }
         }catch (Exception ex){
             log.error("access token is error");
             //过滤该请求，不往下级服务去转发请求，到此结束
             ctx.setSendZuulResponse(false);
             ctx.setResponseStatusCode(401);
             ctx.setResponseBody(Result.getException(ex.getMessage()).getJson());
          /*   try {
                 ctx.getResponse().getWriter().write(ex.getMessage());
             } catch (IOException e) {
                 e.printStackTrace();
             }*/
             return ex.getMessage();
         }

            //如果有token，则进行路由转发
            log.info("access token ok");
        }
        // 解决中文乱码问题
        ctx.getResponse().setContentType(Constant.CONTENT_TYPE);

        //这里return的值没有意义，zuul框架没有使用该返回值

        return null;
    }
}
