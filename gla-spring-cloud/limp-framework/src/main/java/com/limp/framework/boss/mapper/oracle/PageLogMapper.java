package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.PageLog;
import com.limp.framework.boss.domain.PageLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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