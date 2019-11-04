package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.MonitorData;
import com.gla.datacenter.domain.MonitorDataExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MonitorDataMapper {
    int countByExample(MonitorDataExample example);

    int deleteByExample(MonitorDataExample example);

    int insert(MonitorData record);

    int insertSelective(MonitorData record);

    List<MonitorData> selectByExampleWithBLOBs(MonitorDataExample example);

    List<MonitorData> selectByExample(MonitorDataExample example);

    int updateByExampleSelective(@Param("record") MonitorData record, @Param("example") MonitorDataExample example);

    int updateByExampleWithBLOBs(@Param("record") MonitorData record, @Param("example") MonitorDataExample example);

    int updateByExample(@Param("record") MonitorData record, @Param("example") MonitorDataExample example);

    Integer getNewVersionByUserId(@Param("userId") String userId);
}