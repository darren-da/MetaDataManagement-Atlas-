package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class OperationLog extends AbstractModel implements Serializable {
    private String id;

    private Integer optType;

    private String optUser;

    private Date optTime;

    private String businessName;

    private String pojoKey;

    private String content;

    private String viewContent;

    private Integer state;

    private String rc1;

    private String rc2;

    private String rc3;

    private String rc4;

    private Integer rc5;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getOptType() {
        return optType;
    }

    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser == null ? null : optUser.trim();
    }

    public Date getOptTime() {
        return optTime;
    }

    public void setOptTime(Date optTime) {
        this.optTime = optTime;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public String getPojoKey() {
        return pojoKey;
    }

    public void setPojoKey(String pojoKey) {
        this.pojoKey = pojoKey == null ? null : pojoKey.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getViewContent() {
        return viewContent;
    }

    public void setViewContent(String viewContent) {
        this.viewContent = viewContent == null ? null : viewContent.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRc1() {
        return rc1;
    }

    public void setRc1(String rc1) {
        this.rc1 = rc1 == null ? null : rc1.trim();
    }

    public String getRc2() {
        return rc2;
    }

    public void setRc2(String rc2) {
        this.rc2 = rc2 == null ? null : rc2.trim();
    }

    public String getRc3() {
        return rc3;
    }

    public void setRc3(String rc3) {
        this.rc3 = rc3 == null ? null : rc3.trim();
    }

    public String getRc4() {
        return rc4;
    }

    public void setRc4(String rc4) {
        this.rc4 = rc4 == null ? null : rc4.trim();
    }

    public Integer getRc5() {
        return rc5;
    }

    public void setRc5(Integer rc5) {
        this.rc5 = rc5;
    }
}