package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.UserRoleMap;
import com.gla.datacenter.domain.UserRoleMapExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserRoleMapMapper {
    int countByExample(UserRoleMapExample example);

    int deleteByExample(UserRoleMapExample example);

    int insert(UserRoleMap record);

    int insertSelective(UserRoleMap record);

    List<UserRoleMap> selectByExample(UserRoleMapExample example);

    int updateByExampleSelective(@Param("record") UserRoleMap record, @Param("example") UserRoleMapExample example);

    int updateByExample(@Param("record") UserRoleMap record, @Param("example") UserRoleMapExample example);
}