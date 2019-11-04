package com.limp.framework.boss.exception;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zzh
 * Date: 15-5-13
 * Time: 上午9:49
 * class:对分类信息统一管理
 * @author zzh
 */
public enum ExceptionEnum {

     //异常代码_异常内容  解决方案

    /**
     * 服务错误信息
     * 00101
     */
    ServiceNameIsNull("0010101_未传入服务名称", "解决方案:请校验服务名称"),

    ServiceIsNull("0010102_服务不存在", "解决方案:请校验服务名称"),

    /**
     * 加密解密
     * 00102
     */
    CryptRSAPrivateKeyNotFind("0010201_RSA私钥未找到", "解决方案:校验私钥路径是否正确"),
    CryptRSADecError("0010202_RSA解密错误", "解决方案:验证公私钥是否匹配"),
    CryptDESDecError("0010203_DES解密错误", "解决方案:请联系管理员"),
    CryptESADESDecError("0010204_ESA和DES解密错误", "解决方案:验证公私钥是否匹配"),


    /**
     * 用户信息错误
     * 00103
     */
    UserIdError("0010301_用户ID错误", "解决方案:请联系管理员"),
    UserIpError("0010302_用户IP授权错误", "解决方案:请联系管理员"),
    UserAuthorityError("0010303_用户权限信息错误", "解决方案:请联系管理员"),
    UserStateError("0010304_用户状态为无效", "解决方案:请联系管理员"),
    UserExpired("0010305_用户已过期", "解决方案:请联系管理员"),
    UserNotFond("0010306_用户不存在", "解决方案:请重新账号信息"),

    /**
     * 参数格式 解析
     * 00104
     */
    ParamFormatError("0010401_数据参数格式格式错误", "解决方案:请联系管理员"),
    ParamISNUll("0010402_输入参数为空", "解决方案:请联系管理员"),
    ParamIllegal("0010403_输入参数非法", "解决方案:请联系管理员"),
    ParamNumIllegal("0010404_输入参数数量有误", "解决方案:请确认方法参数数量"),

    /**
     * 订单部分
     * 00105
     */
    OrderException("0010501_订单生成异常", "解决方案:请联系管理员"),
    OrderIsNotInsert("0010502_订单未生成", "解决方案:请联系管理员"),

    /**
     * 权限部分
     * 00106
     */
     AuthorityException("0010601_没有权限访问此接口", "解决方案:请联系管理员"),

     AuthorityLIMITEDException("0010602_权限不足", "解决方案:请联系管理员");

    /**分类描述*/
    private String value;
    /**分类ID*/
    private String key;


    /**
     *
     * 创建一个新的实例 ZtEnum.
     *
     * @param value		状态值
     * @param key		状态key
     */
    private ExceptionEnum(String key, String value) {
        this.setValue(value);
        this.setKey(key);
    }

    /**
     *
     * getAllMap(获取所有状态key、value关系，主要用于ServiceImpl拼接json转换显示状态)
     * @return  	Map<Integer,Object> 	 返回的键值容器
     */
    public static Map<String, Object> getAllMap() {
        // 定义Map容器用以存放状态键值关系
        Map<String, Object> map = new HashMap<String, Object>();
        // 遍历所有状态
        for (ExceptionEnum item : ExceptionEnum.values()) {
            // 将键值关系放入Map中
            map.put(item.getKey().split("_")[0], item.getValue());
        }
        // 返回容器
        return map;
    }

    /**
     *
     * getAllList(获取所有状态key、value关系，主要用于jsp中下拉框显示)
     * @return  	Map<Integer,Object> 	 返回的键值容器
     */
    public static List<Map<String, Object>> getAllList() {
        // 定义List容器，用以存放键值对
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        // 遍历所有状态
        for (ExceptionEnum item : ExceptionEnum.values()) {
            // 定义Map容器用以存放状态键值关系
            Map<String, Object> map = new HashMap<String, Object>();
            // 将key关系放入Map中
            map.put("key", item.getKey());
            // 将value关系放入Map中
            map.put("value", item.getValue());
            // 将map放入集合中
            list.add(map);
        }
        // 返回容器
        return list;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }

  /*  public static void main(String[] args) {
//        System.out.println(ExceptionEnum.getAllMap());
//        System.out.println(ExceptionEnum.getAllList());
        System.out.println(Result.getException(ExceptionEnum.UserExpired).getJson());
    }*/



}
