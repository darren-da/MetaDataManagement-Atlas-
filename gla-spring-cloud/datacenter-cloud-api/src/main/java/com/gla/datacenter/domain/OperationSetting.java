package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class OperationSetting extends AbstractModel implements Serializable {
    private String id;

    private String pojoKey;

    private String bussinessName;

    private String urlTemplate;

    private String fieldTemplate;

    private Integer logType;

    private Integer state;

    private Date idt;

    private Date udt;

    private String contentTemplate;

    private String createAccount;

    private String updateAccount;

    private String rc1;

    private String rc2;

    private String rc3;

    private Integer rc4;

    private Date rc5;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPojoKey() {
        return pojoKey;
    }

    public void setPojoKey(String pojoKey) {
        this.pojoKey = pojoKey == null ? null : pojoKey.trim();
    }

    public String getBussinessName() {
        return bussinessName;
    }

    public void setBussinessName(String bussinessName) {
        this.bussinessName = bussinessName == null ? null : bussinessName.trim();
    }

    public String getUrlTemplate() {
        return urlTemplate;
    }

    public void setUrlTemplate(String urlTemplate) {
        this.urlTemplate = urlTemplate == null ? null : urlTemplate.trim();
    }

    public String getFieldTemplate() {
        return fieldTemplate;
    }

    public void setFieldTemplate(String fieldTemplate) {
        this.fieldTemplate = fieldTemplate == null ? null : fieldTemplate.trim();
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getIdt() {
        return idt;
    }

    public void setIdt(Date idt) {
        this.idt = idt;
    }

    public Date getUdt() {
        return udt;
    }

    public void setUdt(Date udt) {
        this.udt = udt;
    }

    public String getContentTemplate() {
        return contentTemplate;
    }

    public void setContentTemplate(String contentTemplate) {
        this.contentTemplate = contentTemplate == null ? null : contentTemplate.trim();
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount == null ? null : createAccount.trim();
    }

    public String getUpdateAccount() {
        return updateAccount;
    }

    public void setUpdateAccount(String updateAccount) {
        this.updateAccount = updateAccount == null ? null : updateAccount.trim();
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

    public Integer getRc4() {
        return rc4;
    }

    public void setRc4(Integer rc4) {
        this.rc4 = rc4;
    }

    public Date getRc5() {
        return rc5;
    }

    public void setRc5(Date rc5) {
        this.rc5 = rc5;
    }
}