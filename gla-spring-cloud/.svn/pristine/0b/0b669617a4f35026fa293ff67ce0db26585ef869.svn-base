package com.gla.datacenter.zuul.filter;

import com.gla.datacenter.core.utils.URLUtils;
import com.gla.datacenter.service.ApiManagerClientService;
import com.limp.framework.core.constant.ConstantClazz;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2018/12/7 16:03
 * @Description: 动态路由动态修改其路由路径
 */
@Component
public class RouteFilter extends ZuulFilter{

    private Logger logger = LoggerFactory.getLogger(RouteFilter.class);

    @Autowired
    private ApiManagerClientService apiManagerClientService;

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String requestURI = "";
        if(StringUtils.isNotBlank(request.getRequestURI())){
            requestURI = request.getRequestURI().toString();
        }
        //根据requestURI获取apiCode
        if(StringUtils.isNotBlank(requestURI)){
            String code = URLUtils.subStringUrl(requestURI);
            logger.info("根据requestURI获取apiCode的code值为:{}",code);
            if(StringUtils.isNotBlank(code)){
                //根据apicode获取api信息
                Map<String, Object> apiInformation = apiManagerClientService.getApiInformationByCode(code);
                if(apiInformation != null && !apiInformation.isEmpty()){
                    //筛选需要转发的api(api接口为转发才需要)
                    if(Byte.parseByte(apiInformation.get("API_TYPE").toString()) != ConstantClazz.API_TYPE_FORWARD){
                    }else{
                        String url = (String)apiInformation.get("URL");
                        if(StringUtils.isNotBlank(url)){
                            URL uri = URLUtils.getIP(url);
                            String urlPath = URLUtils.getUrlPath(url);
                            try {
                                //重新设置requestURI和routeHost
                                ctx.setRouteHost(uri);
                                ctx.put(FilterConstants.REQUEST_URI_KEY,urlPath);
                                /*HttpServletRequest request1 = ctx.getRequest();
                                System.out.println("获取项目名称:" + request1.getContextPath());

                                System.out.println("获取请求使用的协议名:" + request1.getScheme());

                                System.out.println("获取请求协议版本:" + request1.getProtocol());

                                System.out.println("获取请求URL上的主机名（内网未转发时，一般为项目部署服务器主机ip）:" + request1.getServerName());

                                System.out.println("获取请求URL上的端口号:" + request1.getServerPort());

                                System.out.println("获取最终接收请求的主机地址:" + request1.getLocalAddr());

                                System.out.println("获取最终接收请求的主机名:" + request1.getLocalName());

                                System.out.println("获取最终接收请求的主机:" + request1.getLocalName());

                                System.out.println("获取最终接收请求的端口:" + request1.getLocalPort());

                                System.out.println("获取请求的方法:" + request1.getMethod());

                                System.out.println("获取请求URL从端口到请求参数中间的部分:" + request1.getRequestURI());
                                System.out.println("获取请求全路径:" + request1.getRequestURL());

                                System.out.println("获取请求URL中访问servlet的那部分路径:" + request1.getServletPath());

                                System.out.println("获取给定虚拟路径在服务端的真实路径:" + request1.getServletContext().getRealPath("/"));

                                System.out.println("获取给定虚拟路径在服务端的真实路径:" + request1.getSession().getServletContext().getRealPath("/"));

                                System.out.println("获取发送请求的客户端地址（如果经过Apache等转发，则不是真实的DCN网地址）:" + request1.getRemoteAddr());

                                System.out.println("获取发送请求的客户端主机名:" + request1.getRemoteHost());

                                System.out.println("获取发送请求的客户端端口:" + request1.getRemotePort());*/

                                //判断url其是否拼接参数，并把参数绑定到request
                                if(url.indexOf("?") != -1){
                                    Map<String, String> parmsMap = URLUtils.URLRequest(url);
                                    if(parmsMap != null && !parmsMap.isEmpty()){
                                        Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();
                                        if (requestQueryParams==null) {
                                            requestQueryParams=new HashMap<>();
                                        }
                                        for(Map.Entry<String,String> entry : parmsMap.entrySet()){
                                            ArrayList<String> arrayList = new ArrayList<>();
                                            arrayList.add(entry.getValue());
                                            requestQueryParams.put(entry.getKey(),arrayList);
                                        }
                                        ctx.setRequestQueryParams(requestQueryParams);
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
