/*
package com.gla.datacenter.core.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

*/
/**
 * @Author: zhangbo
 * @Date: 2018/12/10 15:56
 * @Description:
 *//*

public class URLUtils {

    */
/**
     *
     * 功能描述: 获取url的ip+port或者域名
     *
     * @param: 
     * @param url
     * @return: java.net.URI
     * @auther: zhangbo
     * @date: 2018/12/10 16:01
     *//*

    public static URL getIP(String url) {

        URI ipPort = null;
        try {
            URI uri = new URI(url);
            ipPort = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
            return ipPort.toURL();
        } catch (Exception var4) {
            ipPort = null;
        }

        return null;
    }

    */
/**
     *
     * 功能描述: 根据url获取apicode
     *
     * @param: 
     * @param url
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/10 16:46
     *//*

    
    public static String subStringUrl(String url){
        String[] split = url.split("/");
        String substring = "";
        for(int i = 0; i<split.length;i++){
            if("v1".equals(split[i])){
                if(split[i+1].length() == 8){
                    substring = split[i+1];
                    break;
                }
            }
        }
        */
/*String te = "/api/center/";
        int index = url.indexOf(te);
        String substring = "";
        if(index != -1){
            substring = url.substring(index);
            substring = url.substring(index+te.length(),url.length());
            substring = substring.substring(0, substring.indexOf("/"));
        }*//*

        return substring;
    }

    */
/**
     *
     * 功能描述: 根据url获取path
     *
     * @param: 
     * @param url
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/11 10:12
     *//*

    
    public static String getUrlPath(String url){
        String path = "";
        try {
            URI uri = new URI(url);
            path = uri.getPath();
            if("wsdl".equalsIgnoreCase(uri.getQuery())){
                //path = path + "?" + uri.getQuery();
            }
        } catch (URISyntaxException e) {
            return null;
        }
        return path;
    }


    */
/**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     * @param URL  url地址
     * @return  url请求参数部分
     *//*

    public static Map<String, String> URLRequest(String URL){
        Map<String, String> mapRequest = new HashMap<String, String>();
        String[] arrSplit = null;
        String strUrlParam = TruncateUrlPage(URL);
        if(strUrlParam == null){
            return mapRequest;
        }
        //每个键值为一组
        arrSplit = strUrlParam.split("[&]");
        for(String strSplit : arrSplit){
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值
            if(arrSplitEqual.length > 1){
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);
            }else{
                if(arrSplitEqual[0]!=""){
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "");
                }
            }
        }
        return mapRequest;
    }

    */
/**
     * 去掉url中的路径，留下请求参数部分
     * @param strURL url地址
     * @return url请求参数部分
     *//*

    public static String TruncateUrlPage(String strURL){
        String strAllParam=null;
        String[] arrSplit=null;

        //strURL=strURL.trim().toLowerCase();
        strURL = strURL.trim();
        arrSplit=strURL.split("[?]");
        if(strURL.length()>1){
            if(arrSplit.length>1){
                if(arrSplit[1]!=null){
                    strAllParam=arrSplit[1];
                }
            }
        }
        return strAllParam;
    }

    public static void main(String[] args){
        //URI uri = new URI("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
        URL ip = getIP("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl");
        System.out.println(ip);

        */
/*String url = "http://localhost:8100/webservice/api/center/v1/VRET8632/apikeytestkey";
        String s = subStringUrl(url);
        System.out.println(s);*//*

    }
}
*/
