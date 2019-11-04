package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class MasterDataManager extends AbstractModel implements Serializable {
    private String id;

    private String name;

    private String code;

    private String masterDescribe;

    private String modelId;

    private String masterSql;

    private Integer status;

    private String createId;

    private Date idt;

    private String updateId;

    private Date udt;

    private String rc1;

    private Integer rc2;

    private Date rc3;

    private Date rc4;

    private String termAll;

    private Integer dataNum;

    public Integer getDataNum() {
        return dataNum;
    }

    public void setDataNum(Integer dataNum) {
        this.dataNum = dataNum;
    }

    public String getTermAll() {
        return termAll;
    }

    public void setTermAll(String termAll) {
        this.termAll = termAll;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getMasterDescribe() {
        return masterDescribe;
    }

    public void setMasterDescribe(String masterDescribe) {
        this.masterDescribe = masterDescribe == null ? null : masterDescribe.trim();
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId == null ? null : modelId.trim();
    }

    public String getMasterSql() {
        return masterSql;
    }

    public void setMasterSql(String masterSql) {
        this.masterSql = masterSql == null ? null : masterSql.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public Date getIdt() {
        return idt;
    }

    public void setIdt(Date idt) {
        this.idt = idt;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public Date getUdt() {
        return udt;
    }

    public void setUdt(Date udt) {
        this.udt = udt;
    }

    public String getRc1() {
        return rc1;
    }

    public void setRc1(String rc1) {
        this.rc1 = rc1 == null ? null : rc1.trim();
    }

    public Integer getRc2() {
        return rc2;
    }

    public void setRc2(Integer rc2) {
        this.rc2 = rc2;
    }

    public Date getRc3() {
        return rc3;
    }

    public void setRc3(Date rc3) {
        this.rc3 = rc3;
    }

    public Date getRc4() {
        return rc4;
    }

    public void setRc4(Date rc4) {
        this.rc4 = rc4;
    }
}