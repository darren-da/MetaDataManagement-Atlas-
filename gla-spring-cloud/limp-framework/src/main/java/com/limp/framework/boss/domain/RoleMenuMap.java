package com.limp.framework.boss.domain;

import com.limp.framework.core.abs.AbstractModel;

import java.io.Serializable;

public class RoleMenuMap  extends AbstractModel implements Serializable {
    private String roleid;

    private String menuid;

    private static final long serialVersionUID = 1L;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
    }
}