package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.core.abs.AbstractService;

import java.util.List;

/**
 * 用户service
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
public interface RoleService extends AbstractService<Role> {


    /**
     * 为某一角色设置菜单权限
     * @param roleId
     * @param menuIds
     * @return
     */
    public boolean setRolePerms(String roleId,List<String> menuIds);

    /**
     * 查询该角色还有的菜单权限id集合
     * @param roleId
     * @return
     */
    public List<String> selectRolePermsID(String roleId);

    public List<Menu> selectRoleMenus(String roleId);

    /**
     * 根据roleId批量删除菜单权限
     * @param roleId
     * @param menuIds
     * @return
     */
    public boolean deleteMenuByRoleId(String roleId, List<String> menuIds);

    /**
     * 为某角色授权
     * @param roleId
     * @param menuIds
     * @return
     */
    public boolean addMenuById(String roleId, List<String> menuIds);



}