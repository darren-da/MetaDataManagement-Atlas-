package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.ModelContent;
import com.limp.framework.boss.domain.ModelContentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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