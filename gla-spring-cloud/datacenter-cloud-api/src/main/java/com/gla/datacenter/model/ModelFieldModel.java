package com.gla.datacenter.model;

import com.gla.datacenter.domain.ModelField;

/**
 * @Author: zhangbo
 * @Date: 2019/7/5 17:57
 * @Description:
 */
public class ModelFieldModel extends ModelField{

    private String ncTerm;

    private String ncdTerm;

    public String getNcTerm() {
        return ncTerm;
    }

    public void setNcTerm(String ncTerm) {
        this.ncTerm = ncTerm;
    }

    public String getNcdTerm() {
        return ncdTerm;
    }

    public void setNcdTerm(String ncdTerm) {
        this.ncdTerm = ncdTerm;
    }
}
