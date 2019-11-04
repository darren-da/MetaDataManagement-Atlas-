
package com.limp.framework.boss.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class PageLog extends AbstractModel implements Serializable {
    private String id;

    private String userid;

    private String optType;

    private String menuid;

    private String optUrl;

    private String optParams;

    private String optForeParams;

    private String remarks;

    private Date idt;

    private Integer state;

    private String optDetail;

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType == null ? null : optType.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }

    public String getOptUrl() {
        return optUrl;
    }

    public void setOptUrl(String optUrl) {
        this.optUrl = optUrl == null ? null : optUrl.trim();
    }

    public String getOptParams() {
        return optParams;
    }

    public void setOptParams(String optParams) {
        this.optParams = optParams == null ? null : optParams.trim();
    }

    public String getOptForeParams() {
        return optForeParams;
    }

    public void setOptForeParams(String optForeParams) {
        this.optForeParams = optForeParams == null ? null : optForeParams.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getIdt() {
        return idt;
    }

    public void setIdt(Date idt) {
        this.idt = idt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOptDetail() {
        return optDetail;
    }

    public void setOptDetail(String optDetail) {
        this.optDetail = optDetail == null ? null : optDetail.trim();
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