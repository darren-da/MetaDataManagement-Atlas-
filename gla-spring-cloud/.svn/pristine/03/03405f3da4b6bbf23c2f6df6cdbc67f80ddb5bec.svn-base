package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(String id);

    /**
     * 查找某角色有的菜单权限
     * @param roleId
     * @return
     */
    List<Menu> selectRoleMenus(@Param("roleId") String roleId);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    /**
     * 查询根据用户id查询用户菜单权限
     *todo :可以参照之前的权限，用户绑定菜单权限，用户组绑定菜单权限未设置
     * @param userId 用户Id
     * @return 用户菜单列表
     */
    List<Menu> selectUserMenus(@Param("userId") String userId);
}