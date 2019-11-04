package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.ModelContent;
import com.gla.datacenter.domain.ModelContentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ModelContentMapper {
    int countByExample(ModelContentExample example);

    int deleteByExample(ModelContentExample example);

    int deleteByPrimaryKey(String id);

    int insert(ModelContent record);

    int insertSelective(ModelContent record);

    List<ModelContent> selectByExample(ModelContentExample example);

    ModelContent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ModelContent record, @Param("example") ModelContentExample example);

    int updateByExample(@Param("record") ModelContent record, @Param("example") ModelContentExample example);

    int updateByPrimaryKeySelective(ModelContent record);

    int updateByPrimaryKey(ModelContent record);
}