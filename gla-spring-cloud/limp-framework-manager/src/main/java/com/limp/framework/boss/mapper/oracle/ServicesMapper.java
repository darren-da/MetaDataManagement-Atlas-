
package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.Services;
import com.limp.framework.boss.domain.ServicesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ServicesMapper {
    int countByExample(ServicesExample example);

    int deleteByExample(ServicesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Services record);

    int insertSelective(Services record);

    List<Services> selectByExample(ServicesExample example);

    Services selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Services record, @Param("example") ServicesExample example);

    int updateByExample(@Param("record") Services record, @Param("example") ServicesExample example);

    int updateByPrimaryKeySelective(Services record);

    int updateByPrimaryKey(Services record);
}