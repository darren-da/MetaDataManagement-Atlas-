package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.CatalogUserMapExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface CatalogUserMapMapper {
    int countByExample(CatalogUserMapExample example);

    int deleteByExample(CatalogUserMapExample example);

    int insert(CatalogUserMap record);

    int insertSelective(CatalogUserMap record);

    List<CatalogUserMap> selectByExample(CatalogUserMapExample example);

    int updateByExampleSelective(@Param("record") CatalogUserMap record, @Param("example") CatalogUserMapExample example);

    int updateByExample(@Param("record") CatalogUserMap record, @Param("example") CatalogUserMapExample example);

    List<String> getSubscribeResourceCode(String userId);
}