package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.ServicesParams;
import com.limp.framework.boss.domain.ServicesParamsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicesParamsMapper {
    int countByExample(ServicesParamsExample example);

    int deleteByExample(ServicesParamsExample example);

    int deleteByPrimaryKey(String id);

    int insert(ServicesParams record);

    int insertSelective(ServicesParams record);

    List<ServicesParams> selectByExample(ServicesParamsExample example);

    ServicesParams selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ServicesParams record, @Param("example") ServicesParamsExample example);

    int updateByExample(@Param("record") ServicesParams record, @Param("example") ServicesParamsExample example);

    int updateByPrimaryKeySelective(ServicesParams record);

    int updateByPrimaryKey(ServicesParams record);
}