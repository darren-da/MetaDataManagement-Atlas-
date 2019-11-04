package com.gla.datacenter.model;

import java.util.Date;

/**
 * @Author: zhangbo
 * @Date: 2019/7/10 09:21
 * @Description:
 */
public class PublishApiModel {

    private byte shareLevel;

    private byte apiType;

    private byte requestType;

    private Date expireTime;

    public byte getShareLevel() {
        return shareLevel;
    }

    public void setShareLevel(byte shareLevel) {
        this.shareLevel = shareLevel;
    }

    public byte getApiType() {
        return apiType;
    }

    public void setApiType(byte apiType) {
        this.apiType = apiType;
    }

    public byte getRequestType() {
        return requestType;
    }

    public void setRequestType(byte requestType) {
        this.requestType = requestType;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
