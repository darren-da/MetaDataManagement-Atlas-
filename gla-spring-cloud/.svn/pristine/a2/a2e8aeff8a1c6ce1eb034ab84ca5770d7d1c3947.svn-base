package com.limp.framework.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 17-1-8
 * Time: 下午1:12
 * To change this template use File | Settings | File Templates.
 */
public class RegUtils {
    public static void main(String[] args) {
        System.out.println(RegUtils.checkUserReg("213123333"));
    }
    public static boolean checkUserReg(String str) {
        //是否允许
        boolean isAllow = true;
        /**************Reg************************/
        //存放需要通过的验证
        List<String> regMustArr = new ArrayList<String>();
        //1、匹配是否是数字7-12位
        regMustArr.add("\\d{7,12}");

        for (String reg : regMustArr) {
            Pattern pat = Pattern.compile(reg);    // 实例化Pattern类
            Matcher m = pat.matcher(str);    // 实例化Matcher类
            if (!m.matches()) {        // 进行验证的匹配，使用正则
                isAllow = false;
                break;
            }
        }
        /**************notReg************************/
        //存放不能通过的验证
        List<String> regNotMustArr = new ArrayList<String>();
        //匹配5-9位顺增
        // regNotMustArr.add("(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){4,9}\\d");

        //匹配5-9位顺降
        //regNotMustArr.add("(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){4,9}\\d");

        //匹配5-9位顺增 或者 匹配5-9位顺降
        regNotMustArr.add("(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){4,9}|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){4,9})\\d");

        //匹配4-9位连续的数字
        regNotMustArr.add("(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)){3,}|(?:9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){3,})\\d");

        // 4-8 位置重复
        regNotMustArr.add("^\\d*(\\d)\\1{3,}\\d*$");

        // 4位以上 位递增或者递减（7890也是递增）
        regNotMustArr.add("^[0-9]*(?:(?:0(?=1)|1(?=2)|2(?=3)|3(?=4)|4(?=5)|5(?=6)|6(?=7)|7(?=8)|8(?=9)|9(?=0)){3,}|(?:0(?=9)|9(?=8)|8(?=7)|7(?=6)|6(?=5)|5(?=4)|4(?=3)|3(?=2)|2(?=1)|1(?=0)){3,})\\d[0-9]*");

        for (String reg : regNotMustArr) {
            Pattern pat = Pattern.compile(reg);    // 实例化Pattern类
            Matcher m = pat.matcher(str);    // 实例化Matcher类
            if (m.matches()) {        // 进行验证的匹配，使用正则
                isAllow = false;
                break;
            }
        }
        //2、 匹配7-12位顺增
        return isAllow;
    }
}
