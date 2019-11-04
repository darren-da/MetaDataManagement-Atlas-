package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.core.abs.AbstractService;

import java.util.List;

/**
 * 用户service
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
public interface UserInfoService extends AbstractService<UserInfo> {

    /**
     * 根据用户Id获取该用户所有的角色
     * @param userId
     * @return
     */
    public List<Role> getUserRoleList(String userId);

    /**
     * 获取用户的角色ID
     * @param userId
     * @return
     */
    public List<String> getUserRoleIDS(String userId);


    /**
     * 设置用户角色信息
     * @param userId
     * @param roleIds
     * @return
     */
    public boolean addUserRoleList (String userId,List<String>roleIds);

}