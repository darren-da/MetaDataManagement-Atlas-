package com.limp.framework.utils;

import com.limp.framework.core.constant.Constant;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 17-7-25
 * Time: 下午1:45
 * To change this template use File | Settings | File Templates.
 */
public class RequestUtil {
    /**
     *  获取request中参数
     * @param request 页面请求
     */
    public static Map<String, Object> getRequestParameters(HttpServletRequest request) {
        String parameters="";//请求参数
        if(Constant.GET.equals(request.getMethod())){//GET请求时的参数
            String urlParameter=request.getQueryString();//网址中的参数
            if(urlParameter!=null&&!"".equals(urlParameter)){
                try {
                    urlParameter= URLDecoder.decode(urlParameter, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }else {
                urlParameter="";
            }
            parameters=urlParameter;
        }else if(Constant.DELETE_METHOD.equals(request.getMethod())
                ||Constant.PUT.equals(request.getMethod())||Constant.POST.equals(request.getMethod())){//POST请求时的参数
            String totalParameter="";//表单及网址中全部参数
            Map<String, String[]> params = request.getParameterMap();
            int parametersNum=request.getParameterMap().size();//参数个数
            int flag=1;
            for (String key : params.keySet()) {

                String[] values = params.get(key);
                for (int i = 0; i < values.length; i++) {
                    String value = values[i];
                    totalParameter+= key + "=" + value;
                }
                if(flag<parametersNum){
                    totalParameter+="&";
                }
                flag+=1;
            }
            parameters=totalParameter;
        }
        Map<String, Object> map=new HashMap<String, Object>();
        String[] arr=parameters.split("&");
        for (int i = 0; i <arr.length; i++) {
            if(arr[i].indexOf("=")>-1){
                String key=arr[i].substring(0, arr[i].indexOf("="));
                String value=arr[i].substring( arr[i].indexOf("=")+1);
                map.put(key, value);
            }
        }
        return map;
    }
}
