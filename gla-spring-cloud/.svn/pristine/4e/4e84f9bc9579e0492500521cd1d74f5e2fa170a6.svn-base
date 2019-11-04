package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.UserCatalogChangeMap;
import com.gla.datacenter.domain.UserCatalogChangeMapExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCatalogChangeMapMapper {
    int countByExample(UserCatalogChangeMapExample example);

    int deleteByExample(UserCatalogChangeMapExample example);

    int insert(UserCatalogChangeMap record);

    int insertSelective(UserCatalogChangeMap record);

    List<UserCatalogChangeMap> selectByExample(UserCatalogChangeMapExample example);

    int updateByExampleSelective(@Param("record") UserCatalogChangeMap record, @Param("example") UserCatalogChangeMapExample example);

    int updateByExample(@Param("record") UserCatalogChangeMap record, @Param("example") UserCatalogChangeMapExample example);
}