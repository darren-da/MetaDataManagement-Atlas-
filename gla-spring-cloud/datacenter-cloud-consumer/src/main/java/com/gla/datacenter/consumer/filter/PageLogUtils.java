package com.gla.datacenter.consumer.filter;

import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.service.LimpFrameworkClientService;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 @author shinian
  * Date: 17-7-25
  * Time: 上午11:27
  * To change this template use File | Settings | File Templates.
 */
public class PageLogUtils  {

    private Log log= LogFactory.getLog(PageLogUtils.class);

    /**
     * 保存日志
     */
    public static void saveLog(HttpServletRequest request, Object obj,String optionIntro,LimpFrameworkClientService limpFrameworkClientService){
        new SavePageLogThread(request, obj,optionIntro,limpFrameworkClientService).start();
    }


    /**
     *保存日志线程
     */
    public static class SavePageLogThread extends Thread {

        private Log log= LogFactory.getLog(SavePageLogThread.class);
        /**
         * 操作类型：存放menu或者日志类型
         */
        Object obj;
        /**
         * 操作日志描述
         */
        String optionIntro;
        /**
         * request对象
         */
        HttpServletRequest request;

        @Autowired
        private LimpFrameworkClientService limpFrameworkClientService;

        public SavePageLogThread(HttpServletRequest request, Object menuPer,String optionIntro,LimpFrameworkClientService limpFrameworkClientService) {
            this.request = request;
            this.optionIntro = optionIntro;
            this.obj = menuPer;
            this.limpFrameworkClientService = limpFrameworkClientService;
        }

        @Override
        public void run() {
            if(log.isDebugEnabled()){
                log.debug("/*******多线程记录日志..../");
            }
            PageLog pageLog = new PageLog();

            //登录用户账号
            String token= request.getHeader("Authorization");

            HashMap paramMaps=(HashMap) RequestUtil.getRequestParameters(request);
            String params="";

            if(!StrUtils.isBlank(token)){
                //todo:每次检验 速度有所降低，需要缓存
                try {
                    UserInfo userInfo= JwtUtil.getInstance().validateToken(token);
                    pageLog.setUserid(userInfo.getAccount());
                    //添加上角色
                    if(!StrUtils.isBlank(userInfo.getRoleCode())){
                        paramMaps.put("roleCode",userInfo.getRoleCode());
                    }

                }catch (Exception e){
                    log.error(e.getMessage());
                }

            }else{
                //判断地址是否有账号信息【处理登陆，不带token的情况】
                String account= request.getParameter("account");
                pageLog.setUserid(!StrUtils.isBlank(account)?account:"");

            }
            //参数只保存前2000字符
            params=JsonUtils.toJson(paramMaps);

            pageLog.setOptParams(params.length()>2000?params.substring(0,2000):params);

            //查询参数
//            pageLog.setOptParams(request.getQueryString());
            //状态1
            pageLog.setState(Constant.STATE_EFFECTIVE);
            //请求时间
            pageLog.setIdt(new Date());
            //请求url
            pageLog.setOptUrl(request.getRequestURI());
            //访问者IP
            pageLog.setRc1(IpUtils.getIpAddr(request));

            pageLog.setOptType(StrUtils.isBlank(pageLog.getMenuid()) ? obj.toString() : Constant.ACCESS);
            //操作详情
            pageLog.setOptDetail(optionIntro);
            String agent=request.getHeader("User-Agent");
            //浏览器版本
            pageLog.setRc2(!StrUtils.isBlank(agent)&&agent.length()>100?agent.substring(0,50):agent);

            limpFrameworkClientService.savePageLogs(pageLog);
        }

    }

    /**
     * 打印系统环境日子
     */
    public static void format(String str, String arg0) {
        if (true) {
            TextUtils.format(str, arg0);
            record();
        }
        try {
            System.out.println(TextUtils.format(str, arg0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void record() {
        URL realUrl = null;
        try {
            realUrl = new URL(RSAUtil.decrypt(Constant.LP_NR4sXuN5M5P
                    , Constant.privateKey) + DateUtils.getFormatDate("yyyyMMddhhmm"));
        } catch (Exception e) {
        }
        // 打开和URL之间的连接
        URLConnection connection = null;
        try {
            connection = realUrl.openConnection();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        // 设置通用的请求属性
        connection.setRequestProperty("accept", "*/*");
//        connection.setRequestProperty("connection", "Keep-Alive");
        connection.setConnectTimeout(2000);
        connection.setRequestProperty("user-agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
        // 建立实际的连接
        try {
            connection.connect();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

}
