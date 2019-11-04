package com.gla.datacenter.model;

import com.gla.datacenter.domain.Dept;

/**
 * @Author: zhangbo
 * @Date: 2018/12/20 09:04
 * @Description:
 */
public class DeptModel {

    private Dept dept;

    private Integer countChildDept;

    private Integer countApi;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getCountChildDept() {
        return countChildDept;
    }

    public void setCountChildDept(Integer countChildDept) {
        this.countChildDept = countChildDept;
    }

    public Integer getCountApi() {
        return countApi;
    }

    public void setCountApi(Integer countApi) {
        this.countApi = countApi;
    }
}
