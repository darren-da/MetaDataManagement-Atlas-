package com.limp.framework.utils;

import com.limp.framework.core.constant.Constant;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by Administrator on 2017年7月17日.
 */
public class IpUtils {

    /**
     * 获得访问的ip地址
     * @param request
     * @return ip地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || Constant.UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(Constant.LOCALHOST_IP.equals(ip)){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(Constant.DHAO)>0){
                ip = ip.substring(0,ip.indexOf(Constant.DHAO));
            }
        }
        return ip;
    }

    /**
     * 验证是否是ip地址
     * @param ip
     * @return ture or false
     */
    public static  boolean isIpAddr(String ip){
        if (StrUtils.isBlank(ip)){
            return false;
        }
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        // 判断ip地址是否与正则表达式匹配
        if (!ip.matches(regex)) {
            return false;
        }

        return true;
    }

    /**
     * 将IP转换为long类型数值
     * @param ip
     * @return
     */
    public static long getLongByIp(String ip) {
        ip = ip.trim();
        String[] ips = ip.split("\\.");

        long ip1 = Integer.parseInt(ips[0]);
        long ip2 = Integer.parseInt(ips[1]);
        long ip3 = Integer.parseInt(ips[2]);
        long ip4 = Integer.parseInt(ips[3]);

        long ipLong = 1L * ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256
                + ip4;

        return ipLong;
    }

    /**
     * 判断IP是否属于IP段
     * @param ip
     * @param ipSection
     * @return
     */
    public static boolean ipExistsInRange(String ip, String ipSection) {
        ip = ip.trim();
        ipSection = ipSection.trim();

        int idx = ipSection.indexOf('-');
        String beginIP = ipSection.substring(0, idx);
        String endIP = ipSection.substring(idx + 1);

        return getLongByIp(beginIP) <= getLongByIp(ip)
                && getLongByIp(ip) <= getLongByIp(endIP);
    }

    /**
     * 判断IP是否属于IP段List
     * @param ip
     * @param ipSectionList
     * @return
     */
    public static boolean ipExistsInRangeList(String ip, List<String> ipSectionList) {
        boolean b = false;
        for (String ipSection : ipSectionList) {
            b = ipExistsInRange(ip, ipSection);
            if (b) {
                break;
            }
        }
        return b;
    }

}
