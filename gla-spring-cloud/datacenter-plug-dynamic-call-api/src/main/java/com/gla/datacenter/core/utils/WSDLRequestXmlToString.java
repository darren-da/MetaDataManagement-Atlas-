package com.gla.datacenter.core.utils;

import com.eviware.soapui.impl.wsdl.WsdlInterface;
import com.eviware.soapui.impl.wsdl.WsdlOperation;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.support.wsdl.WsdlImporter;
import com.eviware.soapui.model.iface.Operation;
import com.eviware.soapui.support.SoapUIException;
import com.gla.datacenter.core.model.OperationMethodInfo;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import net.sf.json.xml.XMLSerializer;
import org.apache.commons.cli.ParseException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.XmlException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangbo
 * @Date: 2018/11/21 10:34
 * @Description:
 */
public class WSDLRequestXmlToString {

    private final static String password_key="soapui.loader.password";
    private final static String username_key="soapui.loader.username";
    /**
     *
     * @return
     * @throws XmlException
     * @throws IOException
     * @throws SoapUIException
     */
    private static WsdlProject init() throws XmlException, IOException, SoapUIException {
        //new 会有一个守护进程???
        WsdlProject WSDL_PROJECT = new WsdlProject();
        return WSDL_PROJECT;
    }

    /**
     * auth
     * @param userName
     * @param password
     * @param auth
     */
    private static void initAuth(String userName,String password,boolean auth){
        if(auth){
            Preconditions.checkArgument(StringUtils.isNotBlank(userName), "username can not be empty or null");
            Preconditions.checkArgument(StringUtils.isNotBlank(password), "password can not be empty or null");
            System.setProperty(password_key, password);
            System.setProperty(username_key, userName);
        }
    }

    /**
     * 解析WSDL
     * @param address
     * @param method
     * @param userName
     * @param password
     * @param auth
     * @return
     * @throws
     */
    private final static OperationMethodInfo operationMethodInfo(String address, String method, String userName, String password, boolean auth) throws Exception{
        Preconditions.checkArgument(StringUtils.isNotBlank(method), "method can not be empty or null");
        List<OperationMethodInfo> infos=convertOperation(address, userName, password, auth);
        for (OperationMethodInfo operationMethodInfo : infos) {
            if(method.equals(operationMethodInfo.getOperationName())){
                return operationMethodInfo;
            }
        }
        return null;
    }

    public final static OperationMethodInfo operationMethodInfo(String address,String method) throws Exception{
        return operationMethodInfo(address, method,null,null,false);
    }

    public final static OperationMethodInfo operationMethodInfo(String address,String method,String userName,String password) throws Exception{
        return operationMethodInfo(address, method,userName,password,true);
    }


    /**
     * 解析WSDL 返回SOAP协议参数XML
     * @param address
     * @param method
     * @return
     * @throws
     */
    public final static String soapRequestXML(String address,String method) throws Exception{
        OperationMethodInfo operationMethodInfo=operationMethodInfo(address, method);
        return null==operationMethodInfo?null:operationMethodInfo.getRequestXml();
    }

    /**
     * 解析WSDL 返回SOAP协议参数XML(需要授权)
     * @param address
     * @param method
     * @return
     * @throws
     */
    public final static String soapRequestXML(String address,String method,String userName,String password) throws Exception{
        OperationMethodInfo operationMethodInfo=operationMethodInfo(address, method,userName,password);
        return null==operationMethodInfo?null:operationMethodInfo.getRequestXml();
    }

    /**
     * convert WSDL Operation
     * @param address
     * @param
     * @param userName
     * @param password
     * @param auth
     * @return
     * @throws
     */
    private static List<OperationMethodInfo> convertOperation(String address,String userName,String password,boolean auth) throws Exception{
        initAuth(userName, password, auth);
        WsdlInterface wsdlInterface=getWsdlInterface(address);
        return convertOperation(wsdlInterface);
    }

    public final static List<OperationMethodInfo> convertOperation(String address) throws Exception{
        return convertOperation(address,null,null,false);
    }

    public final static List<OperationMethodInfo> convertOperation(String address,String userName,String password) throws Exception{
        return convertOperation(address,userName, password, true);
    }

    /**
     * convert WSDL Operation
     * @param wsdlInterface
     * @return
     */
    private static List<OperationMethodInfo> convertOperation(WsdlInterface wsdlInterface) {
        List<Operation> operationList = wsdlInterface.getOperationList();
        return new ArrayList<>(Lists.transform(operationList, action->{
            return new OperationMethodInfo((WsdlOperation) action);
        }));
    }

    /**
     * getWsdlInterface
     * @param address
     * @return
     * @throws
     */
    private static WsdlInterface getWsdlInterface(String address) throws Exception {
        Preconditions.checkArgument(StringUtils.isNotBlank(address), "address can not be empty or null");
        try {
            WsdlInterface[] wsdls = WsdlImporter.importWsdl(init(), address.endsWith("wsdl")||address.endsWith("WSDL")?address:address+"?wsdl");
            return wsdls[0];
        } catch (XmlException e) {
            //throw new ConvertWSDLException(e);
        } catch (IOException e) {
            //throw new ConvertWSDLException(e);
        } catch (SoapUIException e) {
            //throw new ConvertWSDLException(e);
        } catch (Exception e) {
            //throw new ConvertWSDLException(e);
        }
        //自己加的
        return null;
    }

    final static String charset="UTF-8";

    public static String xmlToJson(String responseXml){
        if (responseXml != null && !"".equals(responseXml)) {
            int beginIndex = responseXml.indexOf("<return>");
            int endIndex = responseXml.indexOf("</return>");
            responseXml = responseXml.substring(beginIndex, endIndex+9);
        }
        return StringUtils.isNotBlank(responseXml)?new XMLSerializer().read(responseXml).toString():null;
        //return responseXml;
    }

    /**
     *
     * @param address
     * @param charset
     * @param requestXml
     * @throws MalformedURLException
     * @throws IOException
     */
    @SuppressWarnings("unused")
    @Deprecated
    private static String doPostSoap_(String address,String charset,String requestXml) throws MalformedURLException, IOException{
        HttpURLConnection httpURLConnection=null;
        try {
            httpURLConnection=(HttpURLConnection) new URL(address).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestProperty("Content-Type","text/xml;charset="+charset);
            OutputStream outputStream=httpURLConnection.getOutputStream();
            outputStream.write(requestXml.getBytes(charset));
            int responseCode = httpURLConnection.getResponseCode();
            StringBuffer stringBuffer=new StringBuffer();
            if(HttpStatus.SC_OK==responseCode){
                InputStream inputStream=httpURLConnection.getInputStream();
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = inputStream.read(buffer)) > 0) {
                    stringBuffer.append(new String(buffer, 0, len));
                }
            }
            return xmlToJson(stringBuffer.toString());
        } finally {
            if(null!=httpURLConnection){
                httpURLConnection.disconnect();
            }
        }
    }

    public static String doPostSoap(String address,String requestXml) throws ParseException, IOException{
        return doPostSoap(address,requestXml,charset);
    }

    public static String doPostSoap(String address,String requestXml,String charset) throws ParseException, IOException{
        return doPostSoap(address,charset, requestXml,null,null,null,false);
    }

    public static String doPostSoap(String address,String requestXml,String charset,String username,String password) throws ParseException, IOException{
        return doPostSoap(address,charset, requestXml,null,username,password,true);
    }

    public static String doPostSoap(String address,String requestXml,String username,String password) throws ParseException, IOException{
        return doPostSoap(address,requestXml,charset,username,password);
    }
    /**
     *
     * @param url
     * @param charset
     * @param requestXml
     * @param methodName
     * @param username
     * @param password
     * @param auth
     * @return
     * @throws ParseException
     * @throws IOException
     */
    private static String doPostSoap(String url, String charset, String requestXml, String methodName, String username,
                                     String password, boolean auth) throws ParseException, IOException {
        CloseableHttpClient httpClient = null;
        try {
            HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
            httpClient = httpClientBuilder.build();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60 * 1000)
                    .setConnectTimeout(60 * 1000).build();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-Type", "text/xml;charset=" + charset);
            httpPost.setHeader("SOAPAction", methodName);
            if (auth){
                httpPost.setHeader("Authorization", authHeader(username, password, charset));
            }
            StringEntity data = new StringEntity(requestXml, Charset.forName(charset));
            httpPost.setEntity(data);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                HttpEntity httpEntity = response.getEntity();
                if (httpEntity != null) {
                    return xmlToJson(EntityUtils.toString(httpEntity, charset));
                }
            }
        } finally {
            // 释放资源
            httpClient.close();
        }
        return null;
    }


    private static String authHeader(String userName, String password, String charset) {
        String auth = userName + ":" + password;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName(charset)));
        String authHeader = "Basic " + new String(encodedAuth);
        return authHeader;
    }

    public static void main(String[] args){
        String url = "http://www.webxml.com.cn/webservices/weatherwebservice.asmx?wsdl";
        String method = "getSupportDataSet";
        try{
            String result = soapRequestXML(url,method);
            System.out.println(result);
            result = doPostSoap(url,"utf-8",result,method,null,null,false);
            System.err.println(result);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
