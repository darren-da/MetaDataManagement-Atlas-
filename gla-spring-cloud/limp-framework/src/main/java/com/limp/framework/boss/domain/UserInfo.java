package com.limp.framework.boss.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.limp.framework.core.abs.AbstractModel;
import com.limp.framework.core.constant.Constant;

import java.io.Serializable;
import java.util.Date;

public class UserInfo  extends AbstractModel implements Serializable {
    private String id;

    private String account;

    private String name;

    private String remarks;

    private String password;

    private String ip;

    private String mac;

    private Short isautoexpire;

    private Short isbindip;

    private Short isbindmac;

    private Date lasttime;

    private String lastip;

    private String lastmac;

    private Short logincount;

    private Date createdate;

    private Date updatetime;

    private Short state;

    private String icn;

    private String unitcode;

    private String phone;

    private Short utype;

    private Short uversion;

    private String keypath;

    private Date expiredate;

    private String email;

    private String conaccount;

    private String apptype;


    @JSONField(name= Constant.CODE_TRANS_PRE+"rc1")
    private String rc1;

    private String rc2;

    private Short rc3;

    private String optaccount;

    private String rc4;

    private String rc5;

    private Date rc6;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public Short getIsautoexpire() {
        return isautoexpire;
    }

    public void setIsautoexpire(Short isautoexpire) {
        this.isautoexpire = isautoexpire;
    }

    public Short getIsbindip() {
        return isbindip;
    }

    public void setIsbindip(Short isbindip) {
        this.isbindip = isbindip;
    }

    public Short getIsbindmac() {
        return isbindmac;
    }

    public void setIsbindmac(Short isbindmac) {
        this.isbindmac = isbindmac;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip == null ? null : lastip.trim();
    }

    public String getLastmac() {
        return lastmac;
    }

    public void setLastmac(String lastmac) {
        this.lastmac = lastmac == null ? null : lastmac.trim();
    }

    public Short getLogincount() {
        return logincount;
    }

    public void setLogincount(Short logincount) {
        this.logincount = logincount;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public String getIcn() {
        return icn;
    }

    public void setIcn(String icn) {
        this.icn = icn == null ? null : icn.trim();
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode == null ? null : unitcode.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Short getUtype() {
        return utype;
    }

    public void setUtype(Short utype) {
        this.utype = utype;
    }

    public Short getUversion() {
        return uversion;
    }

    public void setUversion(Short uversion) {
        this.uversion = uversion;
    }

    public String getKeypath() {
        return keypath;
    }

    public void setKeypath(String keypath) {
        this.keypath = keypath == null ? null : keypath.trim();
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getConaccount() {
        return conaccount;
    }

    public void setConaccount(String conaccount) {
        this.conaccount = conaccount == null ? null : conaccount.trim();
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype == null ? null : apptype.trim();
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

    public Short getRc3() {
        return rc3;
    }

    public void setRc3(Short rc3) {
        this.rc3 = rc3;
    }

    public String getOptaccount() {
        return optaccount;
    }

    public void setOptaccount(String optaccount) {
        this.optaccount = optaccount == null ? null : optaccount.trim();
    }

    public String getRc4() {
        return rc4;
    }

    public void setRc4(String rc4) {
        this.rc4 = rc4 == null ? null : rc4.trim();
    }

    public String getRc5() {
        return rc5;
    }

    public void setRc5(String rc5) {
        this.rc5 = rc5 == null ? null : rc5.trim();
    }

    public Date getRc6() {
        return rc6;
    }

    public void setRc6(Date rc6) {
        this.rc6 = rc6;
    }
}