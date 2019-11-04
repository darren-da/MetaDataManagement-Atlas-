package com.limp.framework.utils;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-6-12
 * Time: 下午11:38
 * To change this template use File | Settings | File Templates.
 */
public class StrUtils {

    private  static String randomArr[]= new String[]{"0","1","2","3","4","5","6","7","8"
            ,"9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v"
            ,"w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V"
            ,"W","X","Y","Z"};

    /**
     * sql语句是否含有特殊字符
     * @param sql
     * @return
     */
    public static boolean isCommandIllSql(String sql){
        String []illSqlKeyArr=new String[]{"create","drop","delete","insert","*","truncate","create"
                ,"update"};
        if(StrUtils.isBlank(sql)){
            return true;
        }
        for(String key:illSqlKeyArr){
            if(sql.indexOf(key)>-1){
                return true;
            }
            if(sql.indexOf(key.toUpperCase())>-1){
                return true;
            }
        }
        return false;
    }
    /**
     * 通过正则获取匹配的结果
     * @param str  需要匹配的字符串
     * @param rgex 正则表达式
     * @return
     */
    public static List<String> getRegGroupList(String str,String rgex){
        List<String> list = new ArrayList<String>();
        // 匹配的模式
        Pattern pattern = Pattern.compile(rgex);
        Matcher m = pattern.matcher(str);
        while (m.find()) {
            int i = 1;
            list.add(m.group(i));
        }
        return list;
    }
    /**
     * 主要用于对比
     * 比较源集合 得出sourceList在compList没有的选项
     * @param sourceList 比较的源b
     * @param compList 参照的源
     * @return
     */
    public static  List compSourceListDiff(List sourceList,List compList){
        //循环compList：得出需要sourceList元素中在compList中没有集合
        List sourceDiffList=new ArrayList(); //最终异同的
        for (Object source:sourceList){
            if(!compList.contains(source)){
                sourceDiffList.add(source);
            }
        }
        return  sourceDiffList;
    }

    /**
     * 判断用户是否为空
     * @param str 判断字符串
     * @return
     */
    public static boolean isBlank(String str){
        if(str==null||"".equals(str)||str.trim().length()==0){
            return true;
        }
        return false;
    }

    /**
     * 随机数
     * @param strLength 返回的字符串长度
     * @return  返回指定长度随机的字符串
     */
    public static String randomStr(Integer strLength){
        Random random = new Random();
        if (StrUtils.isBlank(strLength)) {
            return "";
        }
        if (strLength instanceof Integer) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < strLength; i++) {
                str.append(randomArr[random.nextInt(randomArr.length)]);
            }
            return str.toString();
        } else {
            return "";
        }
    }

    /**
     * 获得uuid，去除-符号的标志位
     * @return
     */
    public static String randomUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }


    /**
     * 获取订单号
     * 规则：时间+随机数（4位）
     * @return
     */
    public static   String getOrderNo() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Double s = Math.random() * 90000 + 100000;
        return df.format(new Date())+s.toString().substring(0, 5);
    }
    /**
     * 是否为空
     * @param obj
     * @return
     */
    public static boolean isBlank(Object obj){
        if(obj==null||"".equals(obj.toString())||obj.toString().trim().length()==0){
            return true;
        }
        return false;
    }

    /**
     * 转化为String
     * @param obj
     * @return
     */
    public static String toString(Object obj){
        if(obj==null||"".equals(obj.toString())||obj.toString().trim().length()==0){
            return "";
        }
        return obj.toString();
    }

  /*  *//**
     * 获得访问的ip地址
     * @param request
     * @return ip地址
     *//*
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip != null&&"127.0.0.1".equals(ip)){
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
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }*/

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
     * 判断字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        // 先判空
        if (isBlank(str)) {
            return false;
        }
        // 用JAVA自带的函数
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        /*
        // 用ascii码
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57)
                return false;
        }*/

        return true;
    }

    /**
     * 首字符转大写
     * @param str
     * @return
     */
    public static String toUpperCaseFirstOne(String str){
        if(Character.isUpperCase(str.charAt(0))){
            return str;
        }else{
            return (new StringBuilder()).append(Character.toUpperCase(str.charAt(0))).append(str.substring(1)).toString();
        }
    }


    public static void main(String[] args) {

        System.out.println(StrUtils.getOrderNo());
    }
}
