package com.gla.datacenter.service;

import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.service.fallback.UserInfoClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: zhengshien
 * @date: 2018/11/16 15:18
 * @modified By:
 * @Description:
   根据已经有的MessageClientService接口新建一个实现了FallbackFactory接口的类MessageClientServiceFallbackFactory
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api4",fallbackFactory=UserInfoClientServiceFallbackFactory.class)
//@RequestMapping("/api4")
public interface UserInfoClientService  {

    /**
     * 功能描述: 新增用户
     * @param:
     * @param userInfo 用户实体
     * @return: com.gla.datacenter.domain.UserInfo
     * @auther: zhengshien
     * @date: 2018/11/16 15:18
     */
    @RequestMapping(value = "/user",method= RequestMethod.POST)
    public String saveUserInfo(@RequestBody UserInfo userInfo);

    /**
     * 功能描述: 根据id删除用户（可多选）
     * @param:
     * @param id 用户id
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:15
     */
    @RequestMapping(value = "/user/{id}",method= RequestMethod.DELETE)
    public String delUserInfo( @PathVariable("id") String id);

    /**
     * 功能描述: 修改用户信息
     * @param:
     * @param userInfo 用户实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:16
     */
    @RequestMapping(value = "/user",method= RequestMethod.PUT)
    public String updateUserInfo(@RequestBody UserInfo userInfo);


    /**
     * 功能描述: 修改密码
     * @param:
     * @param userInfo
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/22 9:56
     */
    @RequestMapping(value = "/user/password/open", method = RequestMethod.PUT)
    public String updatePassword(@RequestBody UserInfo userInfo);

    /**
     * 功能描述: 启用/禁用 用户
     * @param:
     * @param
     * @param
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:15
     */
    @RequestMapping(value = "/user/state",method= RequestMethod.PUT)
    public String updateUserInfoState(@RequestBody UserInfo userInfo);

    /**
     * 功能描述: 根据id查询用户信息
     * @param:
     * @param id 用户id
     * @return: com.gla.datacenter.domain.UserInfo
     * @auther: zhengshien
     * @date: 2018/11/16 15:17
     */
    @RequestMapping(value = "/user/{id}",method= RequestMethod.GET)
    public String selectUserInfo(@PathVariable("id") String id);

    /**
     * 功能描述: 查询用户列表（不分页）
     * @param:
     * @param userInfo 用户实体（携带查询条件）
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:14
     */
    @RequestMapping(value = "/user/open")
    public String getUsers(@RequestBody UserInfo userInfo);

    /**
     * 功能描述: 获取全部生产者信息（写信页面使用）
     * @param:
     * @param keyword 关键字
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:03
     */
    @RequestMapping(value = "/provider")
    public String selectProvider(@RequestParam(name = "keyword",required = false) String keyword);

    /**
     * 功能描述: 获取用户列表（分页）
     * @param:
     * @param userInfo 用户实体（携带查询条件）
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:09
     */
    @RequestMapping(value = "/users")
    public String selectUserInfoList(@RequestBody UserInfo userInfo);

    /**
     * 功能描述: 获取验证码
     * @param:
     * @param account 用户账号
     * @param userEmail 用户邮箱
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:08
     */
    @RequestMapping(value = "/getCode")
    public String getCode(@RequestParam("account")String account, @RequestParam("userEmail") String userEmail);


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
    @RequestMapping(value = "/findPassword")
    public String findPassword(@RequestParam("account")String account, @RequestParam("userEmail") String userEmail,@RequestParam("code")String code);

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
    @RequestMapping(value = "/modifyDefaultPWD")
    public String modifyDefaultPWD(@RequestParam("account")String account, @RequestParam("oldPassword") String oldPassword,@RequestParam("newPassword") String newPassword);

    /**
     * 功能描述: 密码重置（管理员使用）
     * @param:
     * @param userid 用户id
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:04
     */
    @RequestMapping(value = "/resetPassword")
    public String resetPassword(@RequestParam("userid") String userid);

    /**
     * 功能描述: 根据用户ID获取角色列表
     * @param:
     * @param userid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/7 10:10
     */
    @RequestMapping(value = "/getUserRoleIDS")
    public String getUserRoleIDS(@RequestParam("userid") String userid);

    /**
     *
     * 功能描述: 获取消费者的apikey
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 16:46
     */
    
    @RequestMapping(value = "/apikey")
    String getConsumerApikey();

    /**
     *
     * 功能描述: 分角色统计用户数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/14 9:33
     */
    @RequestMapping(value = "/user/count")
    String countRoleUserNum();

    /**
     *
     * 功能描述: 获取管理员详情
     *
     * @param:
     * @return: com.gla.datacenter.domain.UserInfo
     * @author: zhangbo
     * @date: 2019/3/14 9:32
     */
    @RequestMapping(value = "/user/admin")
    UserInfo getAdminInfo();

    /**
     *
     * 功能描述: 分页查询用户列表(v2.0)
     *
     * @param: 
     * @param userInfo
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/26 14:39
     */
    @RequestMapping(value = "/user/list")
    String getPageUserList(UserInfo userInfo);

    /**
     *
     * 功能描述: 欢迎页首页用户统计
     *
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @author: zhangbo
     * @date: 2019/4/12 9:52
     */
    @RequestMapping(value = "/remote/users")
    List<UserInfo> getUserByPortal();
}
