
package com.limp.framework.core.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.limp.framework.boss.service.CommonService;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.core.service.CoreService;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.log4j.Logger;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @author: zzh
 * Date: 16-6-12
 * Time: 下午11:55
 * To change this template use File | Settings | File Templates.
 */
public class Result implements Serializable {


    private static Logger log= Logger.getLogger(Result.class);

    /**
     * 字符串
     */
    private static  final String EMPTY_STRING="";
    /**
     * 返回状态码 ： 如 200
     */
    private static  final String CODE="code";
    /**
     * 返回提示信息：如 更新成功
     */
    private static  final String MSG="msg";
    /**
     * 返回数据集合：如list对象等
     */
    private static  final String RESULT="result";
    /**
     * 额外参数：如Map个格式的其他数据
     */
    private static  final String EXT="ext";
    /**
     * 返回状态代码
     */
    private String code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    /**
     * 返回结果map
     */
    private Map resultMap;

    /**
     * 格式化数据字符串
     */
    private String formatJsonStr;



    /**
     * 返回结果
     * @param code 状态码
     * @param msg  提示信息
     * @param data  结果集合
     * @param param 额外参数
     */
    public Result(String code,String msg,Object data,Object param){
        this.code=code;
        this.msg=msg;
        this.data=data;
        resultMap=new HashMap();
        resultMap.put(CODE,code);
        resultMap.put(MSG,this.msg);
        if(!StrUtils.isBlank(data)){
            resultMap.put(RESULT,this.data);
        }
        if(!StrUtils.isBlank(param)){
            resultMap.put(EXT,param);
        }
        this.resultMap=resultMap;
    }

    /**
     * 正确的返回结果
     * @param data
     */
    public Result(Object data){
        this.msg=msg;
        this.data=data;
        resultMap=new HashMap();
        resultMap.put(CODE,200);
        resultMap.put(MSG,"success");
        if(!StrUtils.isBlank(data)){
            resultMap.put(RESULT,this.data);
        }
        this.resultMap=resultMap;
    }
    /**
     * 返回异常信息
     * @param exceptionEnum
     * @return
     */
    public final static Result getException(ExceptionEnum exceptionEnum) {
        String arr[]= exceptionEnum.getKey().split("_");
        return new Result(arr.length>1?arr[0]:ResultCode.ERROR.toString(),arr.length>1?arr[1]: ResultMsg.ERROR.toString(),exceptionEnum.getValue(),"");
    }

    /**
     *  返回异常信息
     * @param exceptionStr
     * @return
     */
    public final static Result getException(String exceptionStr) {
        return new Result(ResultCode.ERROR.toString(),exceptionStr,"","");
    }


    /**
     * 返回结果格式化
     * @param code 状态值 200成功 500错误
     * @param msg 提示信息
     * @param data 返回数据
     * @param param ext其他参数
     * @return  调用Result.getJson()返回json数据
     */
    public final static Result getInstance(String code,String msg,Object data,Object param) {
        return new Result(code,msg,data,param);
    }

    /**
     * 正确返回结果
     * @return
     */
    public final static Result Success() {
        return new Result(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,"","");
    }

    /**
     * 错误返回结果
     * @return
     */
    public final static Result Error() {
        return new Result(ResultCode.ERROR.toString(),ResultMsg.ERROR,"","");
    }

    /**
     * FASTjson【obj】转化为【json】
     * @param obj
     * @return
     */
    public static String toJSONString(Object obj) {
        if (StrUtils.isBlank(obj)) {
            return EMPTY_STRING;
        }
        return JSON.toJSONString(obj);
    }
    public final static String transCodeZN(CoreService commonService, Object obj){

        //定义返回JSON字符串
        String returnJson = "";
        SerializeConfig ser = new SerializeConfig();
    /*    *
         * 注意：有些json字符串返回的不是如下时间格式，校验方式：检查该字段是否是Date类型（其他Object类型无效）
      */
        ser.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd  HH:mm:ss"));
        try {

          /*  1、格式化时间
             2、禁止循环
             3、fastjson将bean转成字符串时首字母变小写问题：方案在bean的属性get方法上加注解 @JSONField(name = "RC2") public String getRC2() return RC2;
           */
            returnJson = JSON.toJSONString(obj, ser, SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {

        }
        //格式化数据字符串使用
        //转码方法
            Long start=System.currentTimeMillis();
            returnJson= commonService.transCodeZN(returnJson);
            Long end=System.currentTimeMillis();
            log.info(TextUtils.format("码表转换解析需要时间为:{0}毫秒",end-start));
        return returnJson;

    }

    /**
     *第一个参数为转码service
     * 格式JSON数据（ resultMap的json格式数据）
     * @return 转换后的json字符串
     */
   public String getJson(CoreService... commonServices) {
//    public String getJson() {
        if (StrUtils.isBlank(this.resultMap)) {
            return null;
        }
        //定义返回JSON字符串
        String returnJson = "";
        SerializeConfig ser = new SerializeConfig();
        ser.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd  HH:mm:ss"));
        try {
            /*
            1、格式化时间
             2、禁止循环
             3、fastjson将bean转成字符串时首字母变小写问题：方案在bean的属性get方法上加注解 @JSONField(name = "RC2") public String getRC2() return RC2;
             */
            returnJson = JSON.toJSONString(this.resultMap, ser, SerializerFeature.WriteNullListAsEmpty,
                    SerializerFeature.DisableCircularReferenceDetect);
        } catch (Exception e) {
            log.error("-----JSON转换异常【实体类Timestamp类型请定义为Date类型接收】-----");

            Gson gson2 = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").enableComplexMapKeySerialization()
                    .registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter()).create();
            log.error(e);
            returnJson= gson2.toJson(this.resultMap);
            this.formatJsonStr = returnJson;
            return returnJson;
        }
        //格式化数据字符串使用
        this.formatJsonStr=returnJson;
        //转码方法
        if (commonServices.length>0) {
            Long start=System.currentTimeMillis();
            log.debug(TextUtils.format("-----码表转换开始-----"));
            log.debug(returnJson);
            returnJson= commonServices[0].transCodeZN(returnJson);
            Long end=System.currentTimeMillis();
            log.debug(TextUtils.format("-----码表转换结束-----"));

            log.debug(TextUtils.format("码表转换解析需要时间为:{0}毫秒", end - start));
        }
        return returnJson;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Map getResultMap() {
        return resultMap;
    }

    public void setResultMap(Map resultMap) {
        this.resultMap = resultMap;
    }

}
