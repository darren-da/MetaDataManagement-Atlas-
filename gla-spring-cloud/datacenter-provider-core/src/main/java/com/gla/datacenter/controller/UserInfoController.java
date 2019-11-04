package com.gla.datacenter.controller;


import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.service.UserInfoService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserInfoController {


    private Logger log = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;

    /**
     * 设置默认页面显示的条数
     */
    public static final Integer DEFAULT_ROW = 10;

    /**
     * 功能描述: 新增用户
     *
     * @param userInfo 用户实体
     * @param:
     * @return: com.gla.datacenter.domain.UserInfo
     * @auther: zhengshien
     * @date: 2018/11/16 15:18
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUserInfo(@RequestBody UserInfo userInfo) {
        log.debug(TextUtils.format("/***新增用户信息{0}**/",userInfo));
        try {
            UserInfo user = userInfoService.saveUser(userInfo);
            if (StrUtils.isBlank(user)) {
                return Result.getException(ExceptionEnum.UserAddErrorByEmail).getJson();
            }
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, user, "").getJson();
        } catch (Exception e) {
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
        }
    }

    /**
     * 功能描述: 根据id删除用户（可多选）
     *
     * @param id 用户id
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:15
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delUserInfo(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据用户id{0}，删除用户记录**/", id));
        String[] ids = id.split(Constant.DHAO);
        if (id.split(Constant.DHAO).length > DEFAULT_ROW) {
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY, "", "").getJson();
        }
        Boolean flay = true;
        for (String did : ids) {
            if (!userInfoService.delete(did)) {
                flay = false;
            }
        }
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 修改用户信息
     *
     * @param userInfo 用户实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:16
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUserInfo(@RequestBody UserInfo userInfo) {
        log.debug(TextUtils.format("/***更新用户信息{0}**/",userInfo));
        Boolean flay = userInfoService.update(userInfo);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 修改密码
     * @param:
     * @param userInfo
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/22 9:56
     */
    @RequestMapping(value = "/user/password/open", method = RequestMethod.PUT)
    public String updatePassword(@RequestBody UserInfo userInfo) {
        log.debug(TextUtils.format("/***用户修改密码{0}**/",userInfo));
        Boolean flay = userInfoService.updatePassword(userInfo);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 启用/禁用 用户
     *
     * @param
     * @param
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:15
     */
    @RequestMapping(value = "/user/state", method = RequestMethod.PUT)
    public String updateUserInfoState(@RequestBody UserInfo userInfo) {
        String id = userInfo.getId();
        String state = userInfo.getState().toString();
        log.debug(TextUtils.format("/***更新用户{0}状态{1}**/",id,state));
        Boolean flay = userInfoService.updateUserInfoState(id, state);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 根据id查询用户信息
     *
     * @param id 用户id
     * @param:
     * @return: com.gla.datacenter.domain.UserInfo
     * @auther: zhengshien
     * @date: 2018/11/16 15:17
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String selectUserInfo(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据用户id{0}，获取用户基本信息**/", id));
        UserInfo userInfo = userInfoService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, userInfo, "").getJson();
    }

    /**
     * 功能描述: 查询用户列表（不分页）
     *
     * @param userInfo 用户实体（携带查询条件）
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:14
     */
    @RequestMapping(value = "/user/open")
    public String getUsers(@RequestBody UserInfo userInfo) {
        log.debug(TextUtils.format("/***根据用户account{0}，获取用户基本信息**/", userInfo));
        List<UserInfo> userInfoList = userInfoService.getList(userInfo);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, userInfoList, "").getJson();
    }

    /**
     *
     * 功能描述: 查询用户列表（分页）(v2.0)
     *
     * @param: 
     * @param userInfo
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/24 9:48
     */
    @RequestMapping(value = "/user/list")
    public String getPageUserList(@RequestBody UserInfo userInfo){
        log.debug(TextUtils.format("/***分页查询用户列表**/", userInfo));
        return userInfoService.getPageUserList(userInfo,userInfo.getPager());
    }

    /**
     *
     * 功能描述: 分角色统计用户数量
     *
     * @param: 
     * @param
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/24 11:36
     */
    @RequestMapping(value = "/user/count")
    public String countRoleUserNum(){
        return userInfoService.countRoleUserNum();
    }

    /**
     *
     * 功能描述: 获取管理员详情
     *
     * @param:
     * @return: com.gla.datacenter.domain.UserInfo
     * @author: zhangbo
     * @date: 2019/3/14 9:34
     */
    @RequestMapping(value = "/user/admin")
    public UserInfo getAdminInfo(){
        return userInfoService.getAdminInfo();
    }

    /**
     * 功能描述: 获取全部生产者信息（写信页面使用）
     *
     * @param keyword 关键字
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:03
     */
    @RequestMapping(value = "/provider")
    public String selectProvider(@RequestParam(required = false) String keyword) {
        log.debug(TextUtils.format("/***根据账号或邮箱{0},获取符合条件的生产者列表**/",keyword));
        List<UserInfo> providers = userInfoService.getProviderList(keyword);
        if (true) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, providers, "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }


    /**
     * 功能描述: 获取用户列表（分页）
     *
     * @param userInfo 用户实体（携带查询条件）
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.UserInfo>
     * @auther: zhengshien
     * @date: 2018/11/16 15:09
     */
    @RequestMapping(value = "/users")
    public String selectUserInfoList(@RequestBody UserInfo userInfo) {
        log.debug(TextUtils.format("/***根据条件，查询用户,返回用户列表{0}**/",userInfo));
        Pager<UserInfo> userInfoPager = userInfoService.getPageList(userInfo, userInfo.getPager());
//        if(true){
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, userInfoPager, "").getJson();
//        }
//        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 功能描述: 获取验证码
     *
     * @param account   用户账号
     * @param userEmail 用户邮箱
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:08
     */
    @RequestMapping(value = "/getCode")
    public String getCode(@RequestParam("account") String account, @RequestParam("userEmail") String userEmail) {
        log.debug(TextUtils.format("/***用户：{0}获取验证码**/"), account);
        Boolean flay = userInfoService.getCode(account, userEmail);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 密码找回
     *
     * @param account   用户账号
     * @param userEmail 用户邮箱
     * @param code      验证码
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:08
     */
    @RequestMapping(value = "/findPassword")
    public String findPassword(@RequestParam("account") String account, @RequestParam("userEmail") String userEmail, @RequestParam("code") String code) {
        log.debug(TextUtils.format("/***用户：{0}找回密码**/"), account);
        Boolean flay = userInfoService.findPassword(account, userEmail, code);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 新用户修改默认密码
     *
     * @param account     用户账号
     * @param oldPassword 原密码
     * @param newPassword 新密码
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:07
     */
    @RequestMapping(value = "/modifyDefaultPWD")
    public String modifyDefaultPWD(@RequestParam("account") String account, @RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
        log.debug(TextUtils.format("/***用户：{0}**/"), account);
        Integer result = userInfoService.modifyDefaultPWD(account, oldPassword, newPassword);
        if (result==Constant.NUMBER_1){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }else if (result==Constant.NUMBER_2){
            return Result.getInstance(ResultCode.ERROR_PASSWORD_503.toString(), ResultMsg.PASSWOED_DEFAULT_WRONG, "", "").getJson();
        }else {
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
        }
    }

    /**
     * 功能描述: 密码重置（管理员使用）
     *
     * @param userid 用户id
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:04
     */
    @RequestMapping(value = "/resetPassword")
    public String resetPassword(@RequestParam("userid") String userid) {
        log.debug(TextUtils.format("/***用户：{0}，校验验证码：{1}**/"), userid);
        Boolean flay = userInfoService.resetPassword(userid);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }

    /**
     *
     * 功能描述: 获取消费者的apikey
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 16:47
     */
    @RequestMapping("/apikey")
    public String getConsumerApikey(){
        return userInfoService.getConsumerApikey();
    }

    /**
     *
     * 功能描述: 欢迎页首页用户统计
     *
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.UserInfo>
     * @author: zhangbo
     * @date: 2019/4/12 10:09
     */
    @RequestMapping(value = "/remote/users")
    public List<UserInfo> getUserByPortal(){
        return userInfoService.getUserByPortal();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         *  yyyy-MM-dd hh:mm:ss
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
    }
}
