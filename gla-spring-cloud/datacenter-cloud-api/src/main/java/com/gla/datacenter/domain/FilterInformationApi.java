package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class FilterInformationApi extends AbstractModel implements Serializable {
    private String id;

    private String userId;

    private String filterVisit;

    private String filterName;

    private String filterDesc;

    private Integer filterType;

    private Integer listType;

    private String accountVisit;

    private String deptnameVisit;

    private Byte deleteFlag;

    private Date idt;

    private String rc1;

    private String rc2;

    private List<String> personType;

    public List<String> getPersonType() {
        return personType;
    }

    public void setPersonType(List<String> personType) {
        this.personType = personType;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getFilterVisit() {
        return filterVisit;
    }

    public void setFilterVisit(String filterVisit) {
        this.filterVisit = filterVisit == null ? null : filterVisit.trim();
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName == null ? null : filterName.trim();
    }

    public String getFilterDesc() {
        return filterDesc;
    }

    public void setFilterDesc(String filterDesc) {
        this.filterDesc = filterDesc == null ? null : filterDesc.trim();
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getListType() {
        return listType;
    }

    public void setListType(Integer listType) {
        this.listType = listType;
    }

    public String getAccountVisit() {
        return accountVisit;
    }

    public void setAccountVisit(String accountVisit) {
        this.accountVisit = accountVisit == null ? null : accountVisit.trim();
    }

    public String getDeptnameVisit() {
        return deptnameVisit;
    }

    public void setDeptnameVisit(String deptnameVisit) {
        this.deptnameVisit = deptnameVisit == null ? null : deptnameVisit.trim();
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
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
}