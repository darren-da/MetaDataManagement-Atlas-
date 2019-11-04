package com.gla.datacenter.service;


import com.gla.datacenter.domain.UserInfo;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @Description: 用户管理
 * @Author: zhengshien
 * @Modified By:
 * @Date: 2018/11/16 11:50
 */
public interface UserInfoService extends AbstractService<UserInfo>{

    /**
     * 功能描述: 新增用户
     * @param:
     * @param userInfo 用户实体
     * @return: com.gla.datacenter.domain.UserInfo
     * @auther: zhengshien
     * @date: 2018/11/16 15:18
     */
    UserInfo saveUser(UserInfo userInfo);

    /**
     * 功能描述: 启用/禁用 用户
     * @param:
     * @param id 用户id
     * @param state 用户状态
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:15
     */
    boolean updateUserInfoState(String id, String state);

    /**
     * 功能描述: 获取验证码
     * @param:
     * @param account 用户账号
     * @param userEmail 用户邮箱
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:08
     */
    boolean getCode(String account,String userEmail);

    /**
     * 功能描述: 密码重置（管理员使用）
     * @param:
     * @param userid 用户id
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:04
     */
    Boolean resetPassword(String userid);

    /**
     * 功能描述: 密码找回
     * @param:
     * @param account 用户账号
     * @param userEmail 用户邮箱
     * @param code 验证码
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:08
     */
    Boolean findPassword(String account, String userEmail, String code);

    /**
     * 功能描述: 新用户修改默认密码
     * @param:
     * @param account 用户账号
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:07
     */
    Integer modifyDefaultPWD(String account, String oldPassword,String newPassword);

    /**
     * 功能描述: 获取全部生产者信息（写信页面使用）
     * @param:
     * @param keyword 关键字
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:03
     */
    List<UserInfo> getProviderList(String keyword);

    /**
     *
     * 功能描述: 获取消费者的apikey
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/24 10:08
     */

    String getConsumerApikey();

    /**
     *
     * 功能描述: 查询用户列表（分页）
     *
     * @param:
     * @param userInfo
     * @param pager
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/24 10:08
     */
    String getPageUserList(UserInfo userInfo, Pager pager);

    /**
     *
     * 功能描述: 分角色统计用户数量
     *
     * @param:
     * @param
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/24 11:37
     */
    String countRoleUserNum();

    Boolean updatePassword(UserInfo userInfo);

    /**
     *
     * 功能描述: 获取管理员用户信息
     *
     * @param:
     * @return: com.gla.datacenter.domain.UserInfo
     * @author: zhangbo
     * @date: 2019/3/14 9:35
     */
    UserInfo getAdminInfo();

    /**
     *
     * 功能描述: 欢迎页首页用户统计
     *
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @author: zhangbo
     * @date: 2019/4/12 10:21
     */
    List<UserInfo> getUserByPortal();
}
