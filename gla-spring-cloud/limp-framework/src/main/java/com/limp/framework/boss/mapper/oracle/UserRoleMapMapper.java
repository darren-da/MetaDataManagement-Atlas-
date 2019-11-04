package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.UserRoleMap;
import com.limp.framework.boss.domain.UserRoleMapExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapMapper {
    int countByExample(UserRoleMapExample example);

    int deleteByExample(UserRoleMapExample example);

    int insert(UserRoleMap record);

    int insertSelective(UserRoleMap record);

    List<UserRoleMap> selectByExample(UserRoleMapExample example);

    int updateByExampleSelective(@Param("record") UserRoleMap record, @Param("example") UserRoleMapExample example);

    int updateByExample(@Param("record") UserRoleMap record, @Param("example") UserRoleMapExample example);
}