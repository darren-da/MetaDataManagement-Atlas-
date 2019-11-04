package com.gla.datacenter.domain;

import java.io.Serializable;
import java.util.Date;

public class ParmsApi implements Serializable {
    private String id;

    private String apiId;

    private String realParms;

    private String defaultValue;

    private String shamParms;

    private String desription;

    private Integer length;

    private Byte type;

    private Byte required;

    private Byte isHeader;

    private Integer parmsNo;

    private Byte pwdType;

    private String remark;

    private Date idt;

    private String createId;

    private Date udt;

    private String updateId;

    private String rc1;

    private String rc2;

    private Integer rc3;

    private Date rc4;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId == null ? null : apiId.trim();
    }

    public String getRealParms() {
        return realParms;
    }

    public void setRealParms(String realParms) {
        this.realParms = realParms == null ? null : realParms.trim();
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    public String getShamParms() {
        return shamParms;
    }

    public void setShamParms(String shamParms) {
        this.shamParms = shamParms == null ? null : shamParms.trim();
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription == null ? null : desription.trim();
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getRequired() {
        return required;
    }

    public void setRequired(Byte required) {
        this.required = required;
    }

    public Byte getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(Byte isHeader) {
        this.isHeader = isHeader;
    }

    public Integer getParmsNo() {
        return parmsNo;
    }

    public void setParmsNo(Integer parmsNo) {
        this.parmsNo = parmsNo;
    }

    public Byte getPwdType() {
        return pwdType;
    }

    public void setPwdType(Byte pwdType) {
        this.pwdType = pwdType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getIdt() {
        return idt;
    }

    public void setIdt(Date idt) {
        this.idt = idt;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public Date getUdt() {
        return udt;
    }

    public void setUdt(Date udt) {
        this.udt = udt;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
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

    public Date getRc4() {
        return rc4;
    }

    public void setRc4(Date rc4) {
        this.rc4 = rc4;
    }

    @Override
    public String toString() {
        return "ParmsApi{" +
                "id='" + id + '\'' +
                ", apiId='" + apiId + '\'' +
                ", realParms='" + realParms + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", shamParms='" + shamParms + '\'' +
                ", desription='" + desription + '\'' +
                ", length=" + length +
                ", type=" + type +
                ", required=" + required +
                ", parmsNo=" + parmsNo +
                ", pwdType=" + pwdType +
                ", remark='" + remark + '\'' +
                ", idt=" + idt +
                ", createId='" + createId + '\'' +
                ", udt=" + udt +
                ", updateId='" + updateId + '\'' +
                ", rc1='" + rc1 + '\'' +
                ", rc2='" + rc2 + '\'' +
                ", rc3=" + rc3 +
                ", rc4=" + rc4 +
                '}';
    }
}