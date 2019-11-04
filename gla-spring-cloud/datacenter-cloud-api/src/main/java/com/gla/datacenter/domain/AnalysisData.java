package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class AnalysisData extends AbstractModel implements Serializable {
    private String id;

    private String userid;

    private String roletype;

    private Integer apicounts;

    private Integer apiinvokings;

    private Integer failtimes;

    private Integer apiabnormals;

    private Integer waittime;

    private Integer score;

    private Date idt;

    private String batch;

    private String rc1;

    private String rc2;

    private Integer rc3;

    private Integer rc4;

    private Integer rc5;

    private Date rc6;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }

    public Integer getApicounts() {
        return apicounts;
    }

    public void setApicounts(Integer apicounts) {
        this.apicounts = apicounts;
    }

    public Integer getApiinvokings() {
        return apiinvokings;
    }

    public void setApiinvokings(Integer apiinvokings) {
        this.apiinvokings = apiinvokings;
    }

    public Integer getFailtimes() {
        return failtimes;
    }

    public void setFailtimes(Integer failtimes) {
        this.failtimes = failtimes;
    }

    public Integer getApiabnormals() {
        return apiabnormals;
    }

    public void setApiabnormals(Integer apiabnormals) {
        this.apiabnormals = apiabnormals;
    }

    public Integer getWaittime() {
        return waittime;
    }

    public void setWaittime(Integer waittime) {
        this.waittime = waittime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getIdt() {
        return idt;
    }

    public void setIdt(Date idt) {
        this.idt = idt;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
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

    public Integer getRc3() {
        return rc3;
    }

    public void setRc3(Integer rc3) {
        this.rc3 = rc3;
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
}