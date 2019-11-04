package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.TagsLib;
import com.limp.framework.boss.domain.TagsLibExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagsLibMapper {
    int countByExample(TagsLibExample example);

    int deleteByExample(TagsLibExample example);

    int deleteByPrimaryKey(String key);

    int insert(TagsLib record);

    int insertSelective(TagsLib record);

    List<TagsLib> selectByExample(TagsLibExample example);

    TagsLib selectByPrimaryKey(String key);

    int updateByExampleSelective(@Param("record") TagsLib record, @Param("example") TagsLibExample example);

    int updateByExample(@Param("record") TagsLib record, @Param("example") TagsLibExample example);

    int updateByPrimaryKeySelective(TagsLib record);

    int updateByPrimaryKey(TagsLib record);
}