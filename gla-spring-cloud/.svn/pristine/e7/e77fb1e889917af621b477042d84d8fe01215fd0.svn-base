package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.*;
import com.limp.framework.boss.mapper.oracle.MenuMapper;
import com.limp.framework.boss.mapper.oracle.RoleMapper;
import com.limp.framework.boss.mapper.oracle.RoleMenuMapMapper;
import com.limp.framework.boss.service.RoleService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
@Service
public class RoleServiceImpl implements RoleService {

    private Logger log= LoggerFactory.getLogger(RoleServiceImpl.class);

    /**
     * 注入mapper
     */
   @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuMapMapper roleMenuMapMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public boolean save(Role entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增角色{0}", entry.getId()));
        try {
            return  roleMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Role get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据用户Id{0},获取实体类信息",id));
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Role entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug(TextUtils.format("根据Id{0},更新实体类信息",entry.getId()));
        return roleMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete( String id) {
        log.debug(TextUtils.format("根据Id{0},删除实体类信息", id));
        //逻辑删除
        Role entry=new Role();
        entry.setId(id);
        entry.setState(Short.parseShort(Constant.STRING_DEL_STATE));
        return  roleMapper.updateByPrimaryKeySelective(entry)== 1?true:false;
    }

    @Override
    public List<Role> getList(Role entry) {
        //初始化Example
        RoleExample entryExample = new RoleExample();

        //创建查询条件
        RoleExample.Criteria criteria = entryExample.createCriteria();

        //如果用户状态不为空，则更具用户状态查询用户列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(entry.getKeyword())) {
            criteria.andKeywordEqualTo(entry.getKeyword());
        }
        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andKeywordEqualTo(entry.getKeyword());
        }

        return  roleMapper.selectByExample(entryExample);
    }

    @Override
    public Pager<Role> getPageList(Role entity, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询角色列表【分页方法】"));
        //初始化Example
        RoleExample entityExample = new RoleExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        RoleExample.Criteria criteria = entityExample.createCriteria();

        //如果用户状态不为空，则更具用户状态查询用户列表
        if (!StrUtils.isBlank(entity.getState())) {
            criteria.andStateEqualTo(entity.getState());
        }

        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(entity.getLpsort())){
            entityExample.setOrderByClause(entity.getLpsort());
        }else{
            entityExample.setOrderByClause("STATE  DESC");
        }
        List<Role> users=roleMapper.selectByExample(entityExample);

        pager.setPagerInfo(users,roleMapper.countByExample(entityExample));

        return pager;

    }

    @Override
    public boolean setRolePerms(String roleId,List<String> menuIds) {
        //查询该角色拥有的
        List<String> foreMenuIds=selectRolePermsID(roleId);

        //最终删除
        List oldPermsListTemp=StrUtils.compSourceListDiff(foreMenuIds,menuIds);
        //最终新增
        List permsListTemp=StrUtils.compSourceListDiff(menuIds,foreMenuIds);

        if(!StrUtils.isBlank(oldPermsListTemp)&&oldPermsListTemp.size()!=0){
            deleteMenuByRoleId(roleId, oldPermsListTemp);
        }
        if(!StrUtils.isBlank(permsListTemp)&&permsListTemp.size()!=0){
           addMenuById(roleId, permsListTemp);
        }

        return true;
    }

    @Override
    public List<String> selectRolePermsID(String roleId) {
        log.info(TextUtils.format("根据角色id获取角色对应的所有菜单id : {0}", roleId));
        RoleMenuMapExample roleMenuMapExample = new RoleMenuMapExample();
        roleMenuMapExample.createCriteria().andRoleidEqualTo(roleId);
        List<String> menIdsList = new ArrayList<String>();
        List<RoleMenuMap> roleMenuMapList = roleMenuMapMapper.selectByExample(roleMenuMapExample);
        for (RoleMenuMap roleMenuMap : roleMenuMapList) {
            menIdsList.add(roleMenuMap.getMenuid());
        }
        log.info(TextUtils.format("menuIdsList: {0}", menIdsList));
        return menIdsList;
    }

    @Override
    public List<Menu> selectRoleMenus(String roleId) {
        return menuMapper.selectRoleMenus(roleId);
    }

    @Override
    public boolean deleteMenuByRoleId(String roleId, List<String> menuIds) {
        log.info(TextUtils.format("根据角色{0},批量删除菜单权限 :", roleId));
        if (roleId == null) {
            return false;
        }
        RoleMenuMapExample roleMenuMapExample = new RoleMenuMapExample();
        roleMenuMapExample.createCriteria().andRoleidEqualTo(roleId).andMenuidIn(menuIds);
        return roleMenuMapMapper.deleteByExample(roleMenuMapExample) > 0;
    }

    @Override
    public boolean addMenuById(String roleId, List<String> menuIds) {
        log.info(TextUtils.format("角色{0}/绑定菜单{1} :", roleId, Arrays.toString(menuIds.toArray(new String[0]))));
        if (roleId == null) {
            return false;
        }
        for (String menuId:menuIds) {
            if (StrUtils.isBlank(menuId)) {
                continue;
            }
            RoleMenuMap roleMenuMap = new RoleMenuMap();
            roleMenuMap.setRoleid(roleId);
            roleMenuMap.setMenuid(menuId);
            roleMenuMapMapper.insert(roleMenuMap);
        }
        return true;
    }
}
