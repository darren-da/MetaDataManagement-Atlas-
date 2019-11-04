package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.LoginLog;
import com.limp.framework.boss.domain.LoginLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginLogMapper {
    int countByExample(LoginLogExample example);

    int deleteByExample(LoginLogExample example);

    int insert(LoginLog record);

    int insertSelective(LoginLog record);

    List<LoginLog> selectByExample(LoginLogExample example);

    int updateByExampleSelective(@Param("record") LoginLog record, @Param("example") LoginLogExample example);

    int updateByExample(@Param("record") LoginLog record, @Param("example") LoginLogExample example);
}