package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.AppApiMap;
import com.gla.datacenter.domain.AppApiMapExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AppApiMapMapper {
    int countByExample(AppApiMapExample example);

    int deleteByExample(AppApiMapExample example);

    int insert(AppApiMap record);

    int insertSelective(AppApiMap record);

    List<AppApiMap> selectByExample(AppApiMapExample example);

    int updateByExampleSelective(@Param("record") AppApiMap record, @Param("example") AppApiMapExample example);

    int updateByExample(@Param("record") AppApiMap record, @Param("example") AppApiMapExample example);

    int batchInsert(@Param("id") String id, @Param("apiIds") String[] apiIds);

    int deleteAppApiMap(@Param("ids") String[] ids);

    List<String> getApiListByAppId(String appId);
}