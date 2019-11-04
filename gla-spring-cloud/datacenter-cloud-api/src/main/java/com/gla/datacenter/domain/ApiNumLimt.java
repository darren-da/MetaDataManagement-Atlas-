package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class ApiNumLimt extends AbstractModel implements Serializable {
    private String id;

    private String apiid;

    private String userid;

    private String account;

    private Integer auditStatus;

    private Integer numFlag;

    private Integer totalnum;

    private Integer leavelnum;

    private Integer usednum;

    private Date idt;

    private Date udt;

    private String cateid;

    private String deptid;

    private Integer limtType;

    private String rc1;

    private String rc2;

    private String rc3;
//    t2.api_name,t2.api_code,t2.description
    private String apiName;

    private String apiCode;

    private String description;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApiid() {
        return apiid;
    }

    public void setApiid(String apiid) {
        this.apiid = apiid == null ? null : apiid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Integer getNumFlag() {
        return numFlag;
    }

    public void setNumFlag(Integer numFlag) {
        this.numFlag = numFlag;
    }

    public Integer getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(Integer totalnum) {
        this.totalnum = totalnum;
    }

    public Integer getLeavelnum() {
        return leavelnum;
    }

    public void setLeavelnum(Integer leavelnum) {
        this.leavelnum = leavelnum;
    }

    public Integer getUsednum() {
        return usednum;
    }

    public void setUsednum(Integer usednum) {
        this.usednum = usednum;
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

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid == null ? null : cateid.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public Integer getLimtType() {
        return limtType;
    }

    public void setLimtType(Integer limtType) {
        this.limtType = limtType;
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
}