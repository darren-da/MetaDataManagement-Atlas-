package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.AreaCode;
import com.limp.framework.boss.domain.AreaCodeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaCodeMapper {
    int countByExample(AreaCodeExample example);

    int deleteByExample(AreaCodeExample example);

    int insert(AreaCode record);

    int insertSelective(AreaCode record);

    List<AreaCode> selectByExample(AreaCodeExample example);

    int updateByExampleSelective(@Param("record") AreaCode record, @Param("example") AreaCodeExample example);

    int updateByExample(@Param("record") AreaCode record, @Param("example") AreaCodeExample example);
}