package com.gla.datacenter.utils;

import com.limp.framework.utils.RandomUtils;

/**
 * @Author: zhangbo
 * @Date: 2019/1/25 09:41
 * @Description:
 */
public class StrCodeUtils {


    public static String createCode(String firstStr){

        //暂时先返回随机字符串和随机数拼接
        String rondowNum = String.valueOf((int)(Math.random()*9000+1000));
        StringBuilder sb = new StringBuilder(firstStr).append(RandomUtils.generateUpperStr(3)).append(rondowNum);
        return sb.toString();

    }

//    public static void main(String[] args){
//        System.err.println(createCode("I"));
//    }
}
