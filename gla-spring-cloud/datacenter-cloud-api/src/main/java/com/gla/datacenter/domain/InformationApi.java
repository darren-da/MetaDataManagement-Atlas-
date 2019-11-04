package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class InformationApi extends AbstractModel implements Serializable {
    private String id;

    private String apiName;

    private String apiCode;

    private String url;

    private String method;

    private Byte requestType;

    private Byte apiType;

    private Byte apiStatus;

    private String producerId;

    private String producerOrgId;

    private String categoryId;

    private String description;

    private String lable;

    private Byte shareLevel;

    private Byte shareType;

    private String shareCode;

    private Byte checkStatus;

    private Byte parmsFlag;

    private Byte expireFlag;

    private Date expireTime;

    private Byte deleteFlag;

    private String interParamType;

    private String outerParamType;

    private String header;

    private Date idt;

    private String createId;

    private Date udt;

    private String updateId;

    private String rc1;

    /**    列表查询接收参数专用(全部)     **/
    private String rc2;

    private Integer rc3;

    private Date rc4;

    /** 只是作为授权人数展示 **/
    private Integer personNum;

    /** 只用作接收api的查询状态 1:use 可用  2:error 异常  3: expire 过期 **/
    private String[] apiTerm;

    /** 只用作接收1：未授权 2：已授权 3：已加入 **/
    private String type;

    private List<?> item;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode == null ? null : apiCode.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Byte getRequestType() {
        return requestType;
    }

    public void setRequestType(Byte requestType) {
        this.requestType = requestType;
    }

    public Byte getApiType() {
        return apiType;
    }

    public void setApiType(Byte apiType) {
        this.apiType = apiType;
    }

    public Byte getApiStatus() {
        return apiStatus;
    }

    public void setApiStatus(Byte apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId == null ? null : producerId.trim();
    }

    public String getProducerOrgId() {
        return producerOrgId;
    }

    public void setProducerOrgId(String producerOrgId) {
        this.producerOrgId = producerOrgId == null ? null : producerOrgId.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable == null ? null : lable.trim();
    }

    public Byte getShareLevel() {
        return shareLevel;
    }

    public void setShareLevel(Byte shareLevel) {
        this.shareLevel = shareLevel;
    }

    public Byte getShareType() {
        return shareType;
    }

    public void setShareType(Byte shareType) {
        this.shareType = shareType;
    }

    public String getShareCode() {
        return shareCode;
    }

    public void setShareCode(String shareCode) {
        this.shareCode = shareCode == null ? null : shareCode.trim();
    }

    public Byte getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Byte checkStatus) {
        this.checkStatus = checkStatus;
    }

    public List<?> getItem() {
        return item;
    }

    public void setItem(List<?> item) {
        this.item = item;
    }

    /**
     *  是否有参 0:无 1:有'

     */
    public Byte getParmsFlag() {
        return parmsFlag;
    }

    public void setParmsFlag(Byte parmsFlag) {
        this.parmsFlag = parmsFlag;
    }

    public Byte getExpireFlag() {
        return expireFlag;
    }

    public void setExpireFlag(Byte expireFlag) {
        this.expireFlag = expireFlag;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getInterParamType() {
        return interParamType;
    }

    public void setInterParamType(String interParamType) {
        this.interParamType = interParamType == null ? null : interParamType.trim();
    }

    public String getOuterParamType() {
        return outerParamType;
    }

    public void setOuterParamType(String outerParamType) {
        this.outerParamType = outerParamType == null ? null : outerParamType.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
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

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public String[] getApiTerm() {
        return apiTerm;
    }

    public void setApiTerm(String[] apiTerm) {
        this.apiTerm = apiTerm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}