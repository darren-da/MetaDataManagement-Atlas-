package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.ApplicationContext;
import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.boss.mapper.oracle.MenuMapper;
import com.limp.framework.boss.mapper.oracle.RoleMapper;
import com.limp.framework.boss.mapper.oracle.RoleMenuMapMapper;
import com.limp.framework.boss.service.PermissionService;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 17-6-29
 * Time: 上午11:30
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    /**
     * 角色菜单mapper
     */
    @Resource
    RoleMenuMapMapper  roleMenuMapMapper;
    /**
     * 用户角色mapper
     */
    /**
     * menumapper
     */
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMapper roleMapper;

   /* @Resource
    private ConfigFieldService configFieldService;*/

    private static Logger log = Logger.getLogger(PermissionServiceImpl.class.getName());


    @Override
    public List<Menu> getMenusById(String uid) {
        return  menuMapper.selectUserMenus(uid);
    }

    @Override
    public boolean initSessionAuth() {

        Subject subject = SecurityUtils.getSubject();
        Session session=subject.getSession();
        //只有登录的用户才可绑定权限  用户信息session获取
        UserInfo userInfo= ApplicationContext.getLoginUser();
        if(StrUtils.isBlank(userInfo)){
            return false;
        }
        //绑定角色
        List<Role> roleList=roleMapper.selectRolesByUserId(userInfo.getId());
        session.setAttribute(Constant.KEY_ROLE,roleList);

        //绑定单位:todo


        //绑定用户菜单权限【2】
        List<Menu> menuList=menuMapper.selectUserMenus(userInfo.getId());
        //通过MenKeyword获取 CODE、URL、NAME、VALUE :包括menu、permission两部分权限
        Map  mapKeyAuth=new  HashMap<String,Map<String,String>>();
        //id:menu json格式
        HashMap menuMap=new HashMap<String,Object>();
        for(final Menu menu:menuList){
            menuMap.put(menu.getId(),menu);

            //todo: 前端通过shiro判断 根据code绑定用户权限，前台可通过${KEY_CODE.特定CODE.VALUE==1}判定是否有该权限
            if(!StrUtils.isBlank(menu.getPerms())){
                mapKeyAuth.put(menu.getPerms(),new HashMap<String,String>(){
                    {
                    put("CODE", StrUtils.isBlank(menu.getPerms())?"":menu.getPerms());
                    put("URL", StrUtils.isBlank(menu.getUrl())?"":menu.getUrl());
                    put("NAME", StrUtils.isBlank(menu.getName())?"":menu.getName());
                    put("VALUE", Constant.STRING_1);
                }
               });
            }
        }
        //绑定角色：演示角色 SYS_ROLE_VIEW
        for(final Role role:roleList){
            //根据code绑定用户权限，前台可通过${KEY_CODE.特定CODE.VALUE==1}判定是否有该权限
            if(!StrUtils.isBlank(role.getKeyword())){
                mapKeyAuth.put(role.getKeyword(),new HashMap<String,String>(){
                    {
                    put("CODE", StrUtils.isBlank(role.getKeyword())?"":role.getKeyword());
                    put("URL", "");
                    put("NAME", StrUtils.isBlank(role.getName())?"":role.getName());
                    put("VALUE", Constant.STRING_1);
                }
               });
            }
        }

        //id:menu json格式
        session.setAttribute(Constant.KEY_MENU_JSON, JsonUtils.toJson(menuMap));
        //id:menu map格式
        session.setAttribute(Constant.KEY_MENU_KVMAP, menuMap);
         //  List<Menu> 获取权限菜单
        session.setAttribute(Constant.KEY_MENU, menuList);
        log.debug(TextUtils.format("获取登录用户session账号{0},菜单权限数量{1}个",
                userInfo.getAccount(), menuList.size()));

//        session.setAttribute(Constant.KEY_CODE, mapKeyAuth);

        return true;
    }

//    @Override
    /*public boolean initSessionConfig(HttpSession session) {
        //只有登录的用户才可绑定权限  用户信息session获取
        List<ConfigField> configFieldList=new ArrayList<ConfigField>();
        try {
            Pager<ConfigField> configFieldsPager=configFieldService.getConfigFieldList(new Pager(1, 1000), new ConfigField());

            configFieldList=configFieldsPager.getDataList();
        }catch (Exception e){
            log.error("--->【获取系统配置异常】<---" + e.getMessage());
            return false;
        }


        Map  mapKeyAuth=new  HashMap<String,Map<String,String>>();
        //id:configField json格式
        HashMap configFieldMap=new HashMap<String,Object>();
        HashMap authMap=new HashMap<String,String>();
        for(final ConfigField configField:configFieldList){
            //根据code绑定用户权限，前台可通过${KEY_CODE.特定CODE.VALUE==1}判定是否有该权限
            if(!StrUtils.isBlank(configField.getKey())&&!StrUtils.isBlank(configField.getValue())){
                configFieldMap.put(configField.getKey(),configField);

                mapKeyAuth.put(configField.getKey(),new HashMap<String,String>(){
                    {
                        put("CODE",configField.getKey());
                        put("NAME", StrUtils.isBlank(configField.getTitle())?"":configField.getTitle());
                        put("VALUE",configField.getValue());
                        put("URL","");
                    }
                });
            }


        }


        session.setAttribute(Constant.KEY_CONFFIELD_KVMAP, configFieldMap);
        //  List<Menu> 获取权限菜单
        session.setAttribute(Constant.KEY_CONFFIELD, configFieldList);

        log.debug(TextUtils.format("系统配置数量{0}个", configFieldList.size()));

        //在之前的权限上进行追加
        if(!StrUtils.isBlank(session.getAttribute(Constant.KEY_CODE))){
            HashMap<String, Map<String, String>> mapKeyAuthBefore =
                    (HashMap<String, Map<String, String>>) session.getAttribute(Constant.KEY_CODE);
            for(String key:mapKeyAuthBefore.keySet()){
                mapKeyAuth.put(key,mapKeyAuthBefore.get(key));
            }

        }
        session.setAttribute(Constant.KEY_CODE, mapKeyAuth);


        return true;
    }*/
}
