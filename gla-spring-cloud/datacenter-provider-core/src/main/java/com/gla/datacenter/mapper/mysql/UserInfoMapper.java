package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.domain.UserInfoExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<String> selectRoleNameList(@Param("userid") String userid);
//    String selectRoleNameList(@Param("userid") String userid);
    /**
     * 查询用户list  根据用户 id和roleCode：如果roleCode为空则查询该用户的角色列表
     * @param userId
     * @param roleCode
     * @return
     */
    List<Map<String,String>> selectUsersByUserIdAndRoleCode(@Param("userId") String userId, @Param("roleCode") String roleCode);

    String selectDeptName(@Param("userid") String userid);

    List<UserInfo>  selectUserAndRole(@Param("account") String account,@Param("email") String email);

    Map<String,Integer> countRoleUserNum();

    List<UserInfo> getPageUserList(Map<String, Object> paramMap);

    int updateBatchState(@Param("ids") String[] ids,@Param("state") String state);

    UserInfo getAdminInfo();
}