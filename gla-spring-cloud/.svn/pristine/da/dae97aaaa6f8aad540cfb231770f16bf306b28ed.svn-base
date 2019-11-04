package com.limp.framework.utils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class TextUtils {
    public final static String format(String pattern, Object... param) {
        return new MessageFormat(pattern.replaceAll("'", "`")).format(param);
    }

    public final static String formatCode(String content, Map<String, String> map) {
       Set<Map.Entry<String, String>> sets = map.entrySet();
        for(Map.Entry<String, String> entry : sets) {
            String regex = "\\{" + entry.getKey() + "\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll(entry.getValue());
        }
        return content;

    }


    public static void main(String[] args) {
        System.out.println(TextUtils.format("中华{0}共和国{1}","人民","万岁"));
        Map<String,String> map=new HashMap<String, String>();
        map.put("0","人民");
        map.put("1","亿岁");


        System.out.println(TextUtils.formatCode("中华{0}共和国{1}",map));
    }
}
