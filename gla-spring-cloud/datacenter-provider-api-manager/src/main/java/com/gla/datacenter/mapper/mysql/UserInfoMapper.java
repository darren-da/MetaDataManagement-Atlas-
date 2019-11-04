package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.domain.UserInfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
    int countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    @Select("select id,account,name,unitcode from lp_users where account = #{userId}")
    UserInfo selectUserByAccount(String userId);

    UserInfo selectConsumerUserByAccount(String str);

    List<UserInfo> getUserAccountByLike(String account);

    List<String> getUserIdsByAccounts(String[] accounts);
}