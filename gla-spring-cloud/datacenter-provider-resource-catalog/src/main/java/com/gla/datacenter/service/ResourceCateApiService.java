package com.gla.datacenter.service;

import com.gla.datacenter.domain.RcsResourceCate;
import com.limp.framework.core.bean.Pager;

import java.util.List;
import java.util.Map;

public interface ResourceCateApiService {

    List<RcsResourceCate> getResourceCatalogByCodes(String[] code);

    String getResourcePageListByResourceCode(RcsResourceCate rcsResourceCate, Pager pager);

    String getFoundationalLibraryCatalog();

    String getThreeLibraryCatalog();

    Integer getResourceCOunt();

    Map<String,Object> getResourcePcodesByCode(String[] list);
}
