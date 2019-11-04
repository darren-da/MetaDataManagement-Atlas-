package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.ApiCatalogChange;
import com.gla.datacenter.domain.ApiCatalogChangeExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiCatalogChangeMapper {
    int countByExample(ApiCatalogChangeExample example);

    int deleteByExample(ApiCatalogChangeExample example);

    int insert(ApiCatalogChange record);

    int insertSelective(ApiCatalogChange record);

    List<ApiCatalogChange> selectByExample(ApiCatalogChangeExample example);

    int updateByExampleSelective(@Param("record") ApiCatalogChange record, @Param("example") ApiCatalogChangeExample example);

    int updateByExample(@Param("record") ApiCatalogChange record, @Param("example") ApiCatalogChangeExample example);
}