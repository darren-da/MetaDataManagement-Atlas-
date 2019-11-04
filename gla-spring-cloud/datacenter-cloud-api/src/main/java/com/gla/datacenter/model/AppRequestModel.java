package com.gla.datacenter.model;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;

/**
 * @Author: zhangbo
 * @Date: 2019/1/29 14:28
 * @Description:
 */
public class AppRequestModel extends AbstractModel implements Serializable {

    /**  消费者:未申请:check1    申请中:check2   已加入:check3  开放:check4   已授权:check5  **/
    /**  生产者:全网:open    需申请:noapply   不共享:noshare  **/
    private String[] appTerm;

    /**  自定义app  **/
    private String custom;

    /**  app名称  **/
    private String appName;

    /**  appCode  **/
    private String appCode;

    /**  描述  **/
    private String description;

    /**   全部(appName和description)   **/
    private String rc2;

    /**  1：未授权 2：已授权 3：已加入  **/
    private String type;

    /**  已加入appId  **/
    private String appJoin;

    /**  用户id  **/
    private String userId;

    public String[] getAppTerm() {
        return appTerm;
    }

    public void setAppTerm(String[] appTerm) {
        this.appTerm = appTerm;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRc2() {
        return rc2;
    }

    public void setRc2(String rc2) {
        this.rc2 = rc2;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAppJoin() {
        return appJoin;
    }

    public void setAppJoin(String appJoin) {
        this.appJoin = appJoin;
    }

}
