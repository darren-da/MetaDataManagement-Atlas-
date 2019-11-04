package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.domain.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据角色id获取角色对应的所有菜单id
     *
     * @param rid
     * @return
     */
    List<String> selectMenusByRoleId(String rid);

    /**
     * 根据用户id获取角色列表
     * @param userId 用户Id
     * @return 角色列表
     */
    List<Role> selectRolesByUserId(String userId);

    /**
     * :todo : 数据权限
     * 获取登录用户角色对应的数据范围
     * @param roleIds
     * @return
     */
//    List<Role> getRoleListByKid(@Param("roleIds") List<String> roleIds);
}