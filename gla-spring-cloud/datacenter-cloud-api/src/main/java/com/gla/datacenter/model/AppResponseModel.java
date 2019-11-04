package com.gla.datacenter.model;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;

/**
 * @Author: zhangbo
 * @Date: 2019/1/29 15:02
 * @Description:
 */
public class AppResponseModel extends AbstractModel implements Serializable {
    /**  appId  **/
    private String id;
    /**  app名称  **/
    private String appName;
    /**  appCode  **/
    private String appCode;
    /**  描述  **/
    private String description;
/*    *//**  申请状态 1:已授权  2:待申请 3:审核中  **//*
    private Integer applyStatus;
    *//**  是否自定义  1:是  2:否  **//*
    private String isCustomFlag;*/
    /**  共享级别  0: 全网 1:需申请 2:不共享  **/
    private String shareType;

    /**  申请状态 0:自定义 1:已授权  2:待申请 3:审核中 （只是用作消费者列表分页查询返回） **/
    private Integer checkStatus;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getIsCustomFlag() {
        return isCustomFlag;
    }

    public void setIsCustomFlag(String isCustomFlag) {
        this.isCustomFlag = isCustomFlag;
    }*/

    public String getShareType() {
        return shareType;
    }

    public void setShareType(String shareType) {
        this.shareType = shareType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}
