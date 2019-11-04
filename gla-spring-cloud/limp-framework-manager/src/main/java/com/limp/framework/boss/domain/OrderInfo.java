package com.limp.framework.boss.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class OrderInfo extends AbstractModel implements Serializable {
    private String id;

    private String serviceId;

    private String serviceName;

    private String orderNo;

    private String usrid;

    private String parms;

    private String ip;

    private String paramsKey;

    private Date idt;

    private Date udt;

    private String status;

    private String url;

    private String rc1;

    private String rc2;

    private String rc3;

    private String rc4;

    private String rc5;

    private String rc6;

    private int rc7;

    private int rc8;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getUsrid() {
        return usrid;
    }

    public void setUsrid(String usrid) {
        this.usrid = usrid == null ? null : usrid.trim();
    }

    public String getParms() {
        return parms;
    }

    public void setParms(String parms) {
        this.parms = parms == null ? null : parms.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getParamsKey() {
        return paramsKey;
    }

    public void setParamsKey(String paramsKey) {
        this.paramsKey = paramsKey == null ? null : paramsKey.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public String getRc5() {
        return rc5;
    }

    public void setRc5(String rc5) {
        this.rc5 = rc5 == null ? null : rc5.trim();
    }

    public String getRc6() {
        return rc6;
    }

    public void setRc6(String rc6) {
        this.rc6 = rc6 == null ? null : rc6.trim();
    }

    public int getRc7() {
        return rc7;
    }

    public void setRc7(int rc7) {
        this.rc7 = rc7;
    }

    public int getRc8() {
        return rc8;
    }

    public void setRc8(int rc8) {
        this.rc8 = rc8;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}