package com.gla.datacenter.domain;

import java.io.Serializable;
import java.util.Date;

public class MonitorData implements Serializable {
    private String id;

    private Integer monitorType;

    private Integer num;

    private Integer batch;

    private String userId;

    private Integer roleType;

    private Date idt;

    private String rc1;

    private String rc2;

    private String rc3;

    private Integer rc4;

    private Integer rc5;

    private Date rc6;

    private String result;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
        this.batch = batch;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Date getIdt() {
        return idt;
    }

    public void setIdt(Date idt) {
        this.idt = idt;
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

    public Integer getRc5() {
        return rc5;
    }

    public void setRc5(Integer rc5) {
        this.rc5 = rc5;
    }

    public Date getRc6() {
        return rc6;
    }

    public void setRc6(Date rc6) {
        this.rc6 = rc6;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}