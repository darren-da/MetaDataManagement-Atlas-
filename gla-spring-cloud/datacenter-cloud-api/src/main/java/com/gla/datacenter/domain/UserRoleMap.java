package com.gla.datacenter.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;

public class UserRoleMap extends AbstractModel implements Serializable {
    private String urmUserid;

    private String urmRoleid;

    private static final long serialVersionUID = 1L;

    public String getUrmUserid() {
        return urmUserid;
    }

    public void setUrmUserid(String urmUserid) {
        this.urmUserid = urmUserid == null ? null : urmUserid.trim();
    }

    public String getUrmRoleid() {
        return urmRoleid;
    }

    public void setUrmRoleid(String urmRoleid) {
        this.urmRoleid = urmRoleid == null ? null : urmRoleid.trim();
    }
}