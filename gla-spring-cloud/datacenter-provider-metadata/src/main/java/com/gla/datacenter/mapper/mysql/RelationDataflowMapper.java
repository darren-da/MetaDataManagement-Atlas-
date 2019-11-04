package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.RelationDataflow;
import com.gla.datacenter.domain.RelationDataflowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationDataflowMapper {
    int countByExample(RelationDataflowExample example);

    int deleteByExample(RelationDataflowExample example);

    int insert(RelationDataflow record);

    int insertSelective(RelationDataflow record);

    List<RelationDataflow> selectByExample(RelationDataflowExample example);

    int updateByExampleSelective(@Param("record") RelationDataflow record, @Param("example") RelationDataflowExample example);

    int updateByExample(@Param("record") RelationDataflow record, @Param("example") RelationDataflowExample example);
}