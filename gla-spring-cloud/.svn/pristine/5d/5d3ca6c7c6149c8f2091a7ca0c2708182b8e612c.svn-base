package com.limp.framework.core.bean;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-6-13
 * Time: 上午12:12
 * To change this template use File | Settings | File Templates.
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS("200"),
    /**
     * 错误
     */
    ERROR("500"),
    /**
     * 用户未登录
     */
    ERROR_NOT_LOGIN("510"),

    /**
     * 用户无权限
     */
    ERROR_NO_PRIVILEGE("511"),
    /**
     * 用户已经删除
     */
    ERROR_USER_502("502"),
    /**
     * 用户待审核
     */
    ERROR_USER_501("501"),
    /**
     * 原密码输入有误
     */
    ERROR_PASSWORD_503("503");
    private  String val;

    private ResultCode(String en){
        this.val=en;
    }
    @Override
    public String toString() {
        return this.val;
    }
}
