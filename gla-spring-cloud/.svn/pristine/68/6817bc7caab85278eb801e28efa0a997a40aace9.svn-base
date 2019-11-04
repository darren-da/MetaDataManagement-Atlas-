package com.gla.datacenter.model;

import com.gla.datacenter.domain.RcsResourceCate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/3/1 09:26
 * @Description:
 */
public class ResourceApplyDeptResponseModel implements Serializable{

    public ResourceApplyDeptResponseModel(){
        this.deptList = new ArrayList<Map<String, Object>>();
    }

    private RcsResourceCate rcsResourceCate;

    private List<Map<String, Object>> deptList;

    private Boolean isChild;

    public RcsResourceCate getRcsResourceCate() {
        return rcsResourceCate;
    }

    public void setRcsResourceCate(RcsResourceCate rcsResourceCate) {
        this.rcsResourceCate = rcsResourceCate;
    }

    public List<Map<String, Object>> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Map<String, Object>> deptList) {
        this.deptList = deptList;
    }

    public Boolean getChild() {
        return isChild;
    }

    public void setChild(Boolean child) {
        isChild = child;
    }
}
