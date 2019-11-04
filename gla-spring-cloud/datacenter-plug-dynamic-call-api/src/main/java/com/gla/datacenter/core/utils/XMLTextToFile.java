package com.gla.datacenter.core.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: zhangbo
 * @Date: 2018/11/19 11:06
 * @Description:
 */
public class XMLTextToFile {


    /**
     *
     * 功能描述: 
     *
     * @param: 
     * @param str 文本内容
     * @param fileName 文件名称 url+方法名经过md5加密后的字符串
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/19 11:45
     */
    
    public static String XmlTextToXmlFile(String str,String fileName) throws IOException {
        String pathUrl = "";
        pathUrl = new File("").getCanonicalPath() + File.separator + "wsdl";
        System.err.println(pathUrl);
        if(StringUtils.isNotBlank(str) && StringUtils.isNotBlank(fileName)){
            str = str.replaceAll("element ref=\"s:schema\"","any minOccurs=\"2\" maxOccurs=\"2\"");
            str = str.replaceAll("<s:any/>","");
            File path = new File(pathUrl);
            if(!path.exists()){
                path.mkdir();
            }
            pathUrl = pathUrl + File.separator + fileName + ".xml";
            File filePath = new File(pathUrl);
            PrintWriter fw;
            if(!filePath.exists()){
                filePath.createNewFile();
                fw = new PrintWriter(pathUrl);
                BufferedWriter bw = new BufferedWriter (fw);
                bw.write(str);
                bw.flush();
                bw.close();
                /*byte bytes[] = new byte[1024];
                bytes=str.getBytes();
                int b=bytes.length;
                FileOutputStream fos = new FileOutputStream(filePath);
                fos.write(bytes,0,b);
                fos.write(bytes);
                fos.close();*/
            }
        }
        return pathUrl;
    }

}
