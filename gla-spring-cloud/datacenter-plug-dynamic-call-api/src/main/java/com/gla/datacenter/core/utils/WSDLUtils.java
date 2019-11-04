package com.gla.datacenter.core.utils;

import javax.wsdl.Definition;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.wsdl.xml.WSDLWriter;
import java.io.*;

/**
 * @Author: zhangbo
 * @Date: 2018/11/19 10:43
 * @Description:
 */
public class WSDLUtils {

    /**
     * 根据wsdlurl,返回网页内容
     * @param wsdlUrl
     * @return
     */
    public static InputStream getUrlInputStream(String wsdlUrl) {
        InputStream inputStream = null;
        //定义字符数组输出流对象
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Definition definition = null;
        WSDLFactory wsdlFactory = null;

        try {
            wsdlFactory = WSDLFactory.newInstance();
            WSDLReader reader = wsdlFactory.newWSDLReader();
            definition = reader.readWSDL(wsdlUrl);
            WSDLWriter wsdlWriter = wsdlFactory.newWSDLWriter();

            Writer wr = new OutputStreamWriter(bos, "utf-8");
            //wsdlWriter.writeWSDL(definition, bos);
            wsdlWriter.writeWSDL(definition, wr);
            inputStream = new ByteArrayInputStream(bos.toString().getBytes());
        } catch (WSDLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return inputStream;
    }
    /**
     * 将输入流转换成String类型
     * @param inputStream
     * @return
     */
    public static String convertStreamToString(InputStream inputStream) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


    /**
     * 将inputStream 转换成byte数组
     * @param input
     * @return
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    public static String convertWsdlToString(String url){
        InputStream urlInputStream = getUrlInputStream(url);
        String result = convertStreamToString(urlInputStream);
        return result.toString();
    }

    public static void main(String[] args) {
        String url = "http://www.webxml.com.cn/webservices/weatherwebservice.asmx?wsdl";
        System.out.printf(convertWsdlToString(url));
    }
}
