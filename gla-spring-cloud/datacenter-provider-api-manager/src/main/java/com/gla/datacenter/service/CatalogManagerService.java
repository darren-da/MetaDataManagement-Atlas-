package com.gla.datacenter.service;

import com.gla.datacenter.domain.ApiCatalogChange;
import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.InformationApi;
import com.limp.framework.core.abs.AbstractService;

import java.util.List;

/**
 * @Author: zhengshien
 * @Date: 2019/3/4 14:43
 * @Description: 数据资源目录管理
 */
public interface CatalogManagerService extends AbstractService<CatalogUserMap> {
    Boolean saveApiCatalogChange(ApiCatalogChange apiCatalogChange);

    List<ApiCatalogChange> selectApiCatalogChange(ApiCatalogChange apiCatalogChange);

    /**
     * 插入 api资源目录变动情况
     * @param api
     * @return
     */
    public Boolean recordCateChange(InformationApi api);
}
