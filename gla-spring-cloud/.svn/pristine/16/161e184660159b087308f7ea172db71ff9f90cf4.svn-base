package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.DBSource;
import com.gla.datacenter.domain.DBSourceExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DBSourceMapper {
    int countByExample(DBSourceExample example);

    int deleteByExample(DBSourceExample example);

    int deleteByPrimaryKey(String id);

    int insert(DBSource record);

    int insertSelective(DBSource record);

    List<DBSource> selectByExample(DBSourceExample example);

    DBSource selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DBSource record, @Param("example") DBSourceExample example);

    int updateByExample(@Param("record") DBSource record, @Param("example") DBSourceExample example);

    int updateByPrimaryKeySelective(DBSource record);

    int updateByPrimaryKey(DBSource record);
}