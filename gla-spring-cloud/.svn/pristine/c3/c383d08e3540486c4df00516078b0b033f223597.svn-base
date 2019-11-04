package com.limp.framework.boss.service.impl;

import com.limp.framework.auth.AuthUtils;
import com.limp.framework.boss.domain.*;
import com.limp.framework.boss.mapper.oracle.RoleMapper;
import com.limp.framework.boss.mapper.oracle.UserInfoMapper;
import com.limp.framework.boss.mapper.oracle.UserRoleMapMapper;
import com.limp.framework.boss.service.OperationLogService;
import com.limp.framework.boss.service.RoleService;
import com.limp.framework.boss.service.UserInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.JavaBeanConverMapUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private Logger log= LoggerFactory.getLogger(UserInfoServiceImpl.class);

    /**
     * 注入mapper
     */
   @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRoleMapMapper userRoleMapMapper;

    @Autowired
    private RoleMapper  roleMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    private OperationLogService operationLogService;



    @Override
    public boolean save(UserInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        //密码加密
        if(!StrUtils.isBlank(entry.getPassword())){
            entry.setPassword(AuthUtils.encodeMD5(entry.getPassword(),""));
        }
        log.debug(TextUtils.format("新增用户{0}", entry.getId()));
        try {
            boolean flag = userInfoMapper.insertSelective(entry) == 1 ? true : false;
            if(flag){
                operationLogService.insertOperationLog(entry,null,"UserInfo","add");
            }
            return flag;
        } catch (Exception e) {
            log.error(TextUtils.format("用户新增失败"));
            return false;
        }
    }

    @Override
    public UserInfo get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据用户Id{0},获取实体类信息",id));
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(UserInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(entry.getId());
        boolean flag = userInfoMapper.updateByPrimaryKeySelective(entry)==1?true:false;
        if(flag){
            try {
                Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(entry,true);
                stringObjectMap = operationLogService.converMap(stringObjectMap, "UserInfoUpdate");
                Map<String, Object> deptMap = JavaBeanConverMapUtils.bean2Map(userInfo,false);
                try {
                    operationLogService.getRunable(stringObjectMap,deptMap,"UserInfo","update");
                }catch (Exception e){
                    log.debug(TextUtils.format( "方法{0}调用插入日志失败","updateUserInfo"));
                    return false;
                }
            }catch (Exception e){
                log.debug(TextUtils.format( "{0}转换map失败","UserInfo"));
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return flag;

    }

    @Override
    public boolean delete(@NotBlank String id) {
        log.debug(TextUtils.format("根据用户Id{0},删除实体类信息", id));
        //逻辑删除
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setState(Short.parseShort(Constant.STRING_DEL_STATE) );
        boolean flag = userInfoMapper.updateByPrimaryKeySelective(userInfo)== 1?true:false;
        if(flag){
            UserInfo userInfo1 = userInfoMapper.selectByPrimaryKey(id);
            Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(userInfo1, false);
            stringObjectMap = operationLogService.converMap(stringObjectMap, "UserInfoDelete");
            operationLogService.getRunable(stringObjectMap,null,"UserInfo","delete");
        }
        return flag;
    }

    @Override
    public List<UserInfo> getList(UserInfo userInfo) {
        //初始化Example
        UserInfoExample userExample = new UserInfoExample();

        //创建查询条件
        UserInfoExample.Criteria userCriteria = userExample.createCriteria();

        //如果用户状态不为空，则更具用户状态查询用户列表
        if (!StrUtils.isBlank(userInfo.getState())) {
            userCriteria.andStateEqualTo(userInfo.getState());
        }
        //根据邮箱登陆查询列表
        if (!StrUtils.isBlank(userInfo.getEmail())) {
            userCriteria.andEmailEqualTo(userInfo.getEmail());
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(userInfo.getAccount())) {
            userCriteria.andAccountEqualTo(userInfo.getAccount());
        }


        return  userInfoMapper.selectByExample(userExample);
    }

    @Override
    public Pager<UserInfo> getPageList(UserInfo userInfo, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询用户列表【分页方法】"));
        //初始化Example
        UserInfoExample userExample = new UserInfoExample();
        //设置分页对象
        userExample.setPage(pager);
        //创建查询条件
        UserInfoExample.Criteria userCriteria = userExample.createCriteria();

        //如果用户状态不为空，则更具用户状态查询用户列表
        if (!StrUtils.isBlank(userInfo.getState())) {
            userCriteria.andStateEqualTo(userInfo.getState());
        }
        if (!StrUtils.isBlank(userInfo.getCreatedate())) {
             userCriteria.andCreatedateBetween(userInfo.getCreatedate(), userInfo.getLpEndDate() == null ? new Date() : userInfo.getLpEndDate());
        }
        //如果用户类型不为空，则根据用户类型查询用户列表

      //扩展：可设置相等、大于、小于、between ，like等匹配条件，此外可以自定义
        if (!StrUtils.isBlank(userInfo.getRc3())) {
            userCriteria.andRc3EqualTo(userInfo.getRc3());
        }
        if (!StrUtils.isBlank(userInfo.getUnitcode())) {
            userCriteria.andUnitcodeEqualTo(userInfo.getUnitcode());
        }

        //根据账号：模糊查询
        if (!StrUtils.isBlank(userInfo.getAccount())) {
            userCriteria.andAccountLike("%" + userInfo.getAccount() + "%");
        }

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(userInfo.getLpsort())){
            userExample.setOrderByClause(userInfo.getLpsort());
        }
        List<UserInfo> users=userInfoMapper.selectByExample(userExample);

        pager.setPagerInfo(users,userInfoMapper.countByExample(userExample));

        return pager;

    }

    @Override
    public List<Role> getUserRoleList(String userId) {

        //roleIdList集合
        List<String> roleIdList=getUserRoleIDS(userId);

       //  获取所有的角色列表
        Role role=new Role();
        role.setState(Short.parseShort(Constant.STRING_1));
        List<Role> roles= roleService.getList(role);

        //判断用户是否在角色列表是否被选中
        List<Role> rolesList=new ArrayList<Role>();
        if(roleIdList.size()>0){
            for(Role roleBak:roles){
                if(roleIdList.contains(roleBak.getId())){
                    roleBak.setChecked(true);
                }
                rolesList.add(roleBak);
            }
            //返回初始化后的角色列表
            return rolesList;
        }

        return roles;
    }

    @Override
    public List<String> getUserRoleIDS(String userId) {
        //获取用户的角色ID
        UserRoleMapExample userRoleMapExample=new UserRoleMapExample();
        UserRoleMapExample.Criteria criteria=userRoleMapExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<UserRoleMap> userRoleMaps=userRoleMapMapper.selectByExample(userRoleMapExample);

        //将用户角色id放在roleIdList集合
        List<String> roleIdList=new ArrayList<String>();
        for(UserRoleMap userRoleMap:userRoleMaps){
            roleIdList.add(userRoleMap.getRoleid());
        }
        return roleIdList;
    }

    @Override
    public boolean addUserRoleList(String userId, List<String>roleIds) {
        //roleIdList集合
        List<String> roleIdList=getUserRoleIDS(userId);
        String []delRoleIDs;
        String []addRoleIDs;
        //循环授权的角色ID，如果没有则新增
        for(String roleId:roleIds){
            if(!roleIdList.contains(roleId)){
                UserRoleMap userRoleMap=new UserRoleMap();
                userRoleMap.setUserid(userId);
                userRoleMap.setRoleid(roleId);
                userRoleMapMapper.insertSelective(userRoleMap);

            }
        }
        //循环曾经 角色列表，如果里面角色未在新的角色列表则删除该角色
        for(String roleId:roleIdList){
            if(!roleIds.contains(roleId)){
                UserRoleMapExample roleMapExample=new UserRoleMapExample();
                roleMapExample.createCriteria().andUseridEqualTo(userId).andRoleidEqualTo(roleId);
                userRoleMapMapper.deleteByExample(roleMapExample);
            }
        }


        return true;
    }
}
