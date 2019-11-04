package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;

public class Message extends AbstractModel implements Serializable {
    private String id;

    private Date sendtime;

    private String messagetype;

    private String senderid;

    private String receiverid;

    private Integer isread;

    private String status;

    private String isdeal;

    private String title;

    private Date readtime;

    private Date dealtime;

    private Integer level;

    private String replyrule;

    private String apprule;

    private Integer star;

    private Integer rc1;

    private String rc2;

    private String rc3;

    private String content;

    private String senderName;

    private String senderAccount;

    private static final long serialVersionUID = 1L;

    public String getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(String senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype == null ? null : messagetype.trim();
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid == null ? null : senderid.trim();
    }

    public String getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(String receiverid) {
        this.receiverid = receiverid == null ? null : receiverid.trim();
    }

    public Integer getIsread() {
        return isread;
    }

    public void setIsread(Integer isread) {
        this.isread = isread;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsdeal() {
        return isdeal;
    }

    public void setIsdeal(String isdeal) {
        this.isdeal = isdeal == null ? null : isdeal.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getReadtime() {
        return readtime;
    }

    public void setReadtime(Date readtime) {
        this.readtime = readtime;
    }

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getReplyrule() {
        return replyrule;
    }

    public void setReplyrule(String replyrule) {
        this.replyrule = replyrule == null ? null : replyrule.trim();
    }

    public String getApprule() {
        return apprule;
    }

    public void setApprule(String apprule) {
        this.apprule = apprule == null ? null : apprule.trim();
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getRc1() {
        return rc1;
    }

    public void setRc1(Integer rc1) {
        this.rc1 = rc1;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}