package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.domain.PageLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PageLogMapper {
    int countByExample(PageLogExample example);

    int deleteByExample(PageLogExample example);

    int deleteByPrimaryKey(String id);

    int insert(PageLog record);

    int insertSelective(PageLog record);

    List<PageLog> selectByExample(PageLogExample example);

    PageLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PageLog record, @Param("example") PageLogExample example);

    int updateByExample(@Param("record") PageLog record, @Param("example") PageLogExample example);

    int updateByPrimaryKeySelective(PageLog record);

    int updateByPrimaryKey(PageLog record);
}