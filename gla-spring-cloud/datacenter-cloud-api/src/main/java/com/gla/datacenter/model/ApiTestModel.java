package com.gla.datacenter.model;

import java.util.Map;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/8 13:27
 * @Description:
 */
public class ApiTestModel {

    private String apiId;

    private Map<String, Object> parms;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public Map<String, Object> getParms() {
        return parms;
    }

    public void setParms(Map<String, Object> parms) {
        this.parms = parms;
    }
}
