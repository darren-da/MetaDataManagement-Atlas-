package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.MenuExample;
import com.limp.framework.boss.mapper.oracle.MenuMapper;
import com.limp.framework.boss.mapper.oracle.MenuMapper;
import com.limp.framework.boss.mapper.oracle.RoleMapper;
import com.limp.framework.boss.service.MenuService;
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
import java.util.Date;
import java.util.List;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 13:42 2018/8/18
 * @modified By:
 */
@Service
public class MenuServiceImpl implements MenuService {

    private Logger log= LoggerFactory.getLogger(MenuServiceImpl.class);

    /**
     * 注入mapper
     */
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public boolean save(Menu entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增菜单{0}", entry.getId()));
        try {
            return menuMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Menu get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据菜单Id{0},获取实体类信息",id));
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Menu entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug(TextUtils.format("根据Id{0},更新实体类信息",entry.getId()));
        return menuMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete( String id) {
        log.debug(TextUtils.format("根据Id{0},删除实体菜单信息", id));

        //如果含有下一级菜单则不允许删除【需要先删除下一级菜单】
        Menu menuSearch=new Menu();
        menuSearch.setState(Short.parseShort(Constant.STRING_1));
        menuSearch.setParentId(id);
        if(getList(menuSearch).size()>0){
            log.error(TextUtils.format("该菜单Id{0},需要先删除子菜单,方可删除", id));
            return false;
        };
        //逻辑删除
        Menu entry=new Menu();
        entry.setId(id);
        entry.setState(Short.parseShort(Constant.STRING_DEL_STATE) );
        //更新时间
        entry.setUpdatetime(new Date());
        return  menuMapper.updateByPrimaryKeySelective(entry)== 1?true:false;
    }

    @Override
    public List<Menu> getList(Menu entry) {
        //初始化Example
        MenuExample entryExample = new MenuExample();

        //创建查询条件
        MenuExample.Criteria criteria = entryExample.createCriteria();

        //如果菜单状态不为空，则根据菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        }
        //父级别菜单id
        if (!StrUtils.isBlank(entry.getParentId())) {
            criteria.andParentIdEqualTo(entry.getParentId());
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(entry.getKeyword())) {
            criteria.andKeywordEqualTo(entry.getKeyword());
        }
        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andKeywordEqualTo(entry.getKeyword());
        }

        return  menuMapper.selectByExample(entryExample);
    }

    @Override
    public Pager<Menu> getPageList(Menu entity, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询菜单列表【分页方法】"));
        //初始化Example
        MenuExample entityExample = new MenuExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        MenuExample.Criteria criteria = entityExample.createCriteria();

        //如果菜单状态不为空，则更具菜单状态查询菜单列表
        if (!StrUtils.isBlank(entity.getState())) {
            criteria.andStateEqualTo(entity.getState());
        }else{
            criteria.andStateEqualTo(Short.parseShort(Constant.STRING_1));
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entity.getParentId())) {
            criteria.andParentIdEqualTo(entity.getParentId());
        }
        if (!StrUtils.isBlank(entity.getPerms())) {
            criteria.andPermsEqualTo(entity.getPerms());
        }

        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(entity.getLpsort())){
            entityExample.setOrderByClause(entity.getLpsort());
        }else{
            entityExample.setOrderByClause("MEN_SORT ASC");
        }
        List<Menu> menus=menuMapper.selectByExample(entityExample);

        //若，传递过来roleId，则需要初始化该菜单是否被选中
        if(!StrUtils.isBlank(entity.getRoleId())){
            List<Menu> roleMenus=new ArrayList<Menu>();
            List<String> permsIdList=roleService.selectRolePermsID(entity.getRoleId());
            for(Menu menu:menus){
                if(permsIdList.size()>0&&permsIdList.contains(menu.getId())){
                    menu.setChecked(true);
                }else{
                    menu.setChecked(false);
                }
                roleMenus.add(menu);
            }
            pager.setPagerInfo(roleMenus,menuMapper.countByExample(entityExample));
            return pager;
        }

        pager.setPagerInfo(menus,menuMapper.countByExample(entityExample));

        return pager;

    }
}
