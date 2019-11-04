package com.gla.datacenter.model;

import com.gla.datacenter.domain.AppService;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/1/25 10:03
 * @Description: app应用的model
 */
public class AppServiceModel extends AppService{

    private List<Map<String, Object>> apiList;

    public List<Map<String, Object>> getApiList() {
        return apiList;
    }

    public void setApiList(List<Map<String, Object>> apiList) {
        this.apiList = apiList;
    }
}
