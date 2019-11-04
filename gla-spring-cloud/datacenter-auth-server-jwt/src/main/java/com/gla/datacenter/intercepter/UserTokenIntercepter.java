package com.gla.datacenter.intercepter;

import com.gla.auth.jwt.filter.JwtUtil;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: $usertoken拦截器
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/2 8:55
 */
public class UserTokenIntercepter extends HandlerInterceptorAdapter {
    private static final Logger log = LoggerFactory.getLogger(UserTokenIntercepter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse respone, Object arg2) throws Exception {
        String token=  request.getHeader(JwtUtil.HEADER_AUTH);
        //默认情况下,zuul不会将敏感的http首部,如(Cookie,Set-Cookie)和Authorization转发到下游服务,要让Zuul传播HTTP首部Authorization,需要在zuul服务网关的application.yml或者application.properties中,设置以下配置:zuul.sensitive-headers="Cookie","Set-Cookie"

        //如果无法传递换成其他的字段传递token
        if(StrUtils.isBlank(token)){
            token=  request.getHeader(JwtUtil.HEADER_X_USER_TOKEN);
        }
        //respone.setCharacterEncoding(Constant.CONTENT_TYPE);
        if (!StrUtils.isBlank(token)){
            ApplicationContextHolder.setToken(token);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse respone, Object arg2, Exception arg3)
            throws Exception {
//        ApplicationContextHolder.shutdownUser();
        ApplicationContextHolder.shutdownToken();
    }
}
