
package com.limp.framework.boss.controller;

import com.limp.framework.auth.AuthUtils;
import com.limp.framework.boss.domain.LoginLog;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.boss.service.CommonService;
import com.limp.framework.boss.service.LoginLogService;
import com.limp.framework.boss.service.UserInfoService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.IpUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 用户相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class UserInfoController extends BaseController {
    private Logger loger= LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    private CommonService commonService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    @Autowired
    LoginLogService loginLogService;

    /**
     * 新增用户信息
     * @param userInfo
     * @return
     */
    @ApiOperation(value="创建用户", notes="根据UserInfo对象创建用户")
    @ApiImplicitParam(name = "userInfo", value = "用户详细实体userInfo", required = true, dataType = "UserInfo")
    @RequiresPermissions("user:add")
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增用户")
    @RequestMapping(value = "/user",method= RequestMethod.POST)
//    @Transactional  事物
    public String saveUserInfo(UserInfo userInfo) {
        loger.debug(TextUtils.format("/***新增用户信息**/"));
        Boolean flay= userInfoService.save(userInfo);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 删除用户
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @ApiOperation(value="删除用户", notes="根据url的id来指定删除用户")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequiresPermissions("user:del")
    @RequestMapping(value = "/user/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "删除用户信息")
    public String delUserInfo( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据用户id{0}，删除用户记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!userInfoService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }
    /**
     * 更新用户信息
     * @param userInfo userInfo
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新用户信息")
    @RequiresPermissions("user:update")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "user", value = "用户实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/user",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新用户信息")
    public String updateUserInfo(UserInfo userInfo) {
        loger.debug(TextUtils.format("/***更新用户信息**/"));
        Boolean flay= userInfoService.update(userInfo);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 更新用户状态
     * @param id
     * @param state
     * @return
     */
    @ApiOperation(value="更新用户状态", notes="根据url的id来指定更新用户状态")
    @RequestMapping(value = "/user/{id}/state/{state}",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新用户状态")
    public String updateUserInfoState(@PathVariable("id") String id,@PathVariable("state") String state) {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setState(Short.parseShort(state));
        loger.debug(TextUtils.format("/***更新用户状态**/"));
        Boolean flay= userInfoService.update(userInfo);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 获取用户信息根据用户id
     * @param model
     * @param id 查询的id
     * @return
     */
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/user/{id}",method= RequestMethod.GET)
    public String selectUserInfo(Model model, @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据用户id{0}，获取用户基本信息**/", id));
        UserInfo userInfo= userInfoService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,userInfo,"").getJson();
    }
    /**
     * 获取用户信的角色根据用户id
     * @param model
     * @param id 查询的id
     * @return
     */
    @ApiOperation(value="获取用户角色信息", notes="根据url的id来获取用户角色列表列表")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/user/{id}/roles",method= RequestMethod.GET)
    public String selectUserRole(Model model, @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据用户id{0}，获取用户角色列表信息**/", id));
        List<Role> roleList= userInfoService.getUserRoleList(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,roleList,"").getJson();
    }

    /**
     * 给用户授予角色
     * @param model
     * @param id
     * @param roleIds
     * @return
     */
    @RequiresPermissions("user:role:update")
    @RequestMapping(value = "/user/{id}/roles",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新用户角色")
    public String saveUserRole(Model model, @PathVariable("id") String id,String roleIds) {
        loger.debug(TextUtils.format("/***根据用户id{0}，修改用户角色列表信息**/", id));
        boolean flay= userInfoService.addUserRoleList(id, Arrays.asList(roleIds.split(Constant.DHAO)));
        if(flay){
            return Result.Success().getJson();
        }else{
            return  Result.Error().getJson();
        }
    }
    /**
     * 查询用于列表
     * @param userInfo
     * @return
     */

    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @RequestMapping(value = "/users",method= RequestMethod.GET)
    public String selectUserInfoList(UserInfo userInfo,Pager pager) {
        loger.debug(TextUtils.format("/***查询用户,返回用户列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<UserInfo> userInfoPager= userInfoService.getPageList(userInfo, pager);
        if(true){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,userInfoPager,"").getJson(commonService);
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * ajax用户登陆
     * @param userInfo
     * @return
     */
    @ApiOperation(value="用户登录", notes="ajax用户登录")
    @RequestMapping(value = "/user/login",method= RequestMethod.GET)
    @Access(operationLog = OPERATION.INSERT,operationIntro = "用户登录")
    public String selectUserInfoList(UserInfo userInfo,HttpServletRequest request) {
        //参数校验
        if(StrUtils.isBlank(userInfo.getAccount())||StrUtils.isBlank(userInfo.getPassword())){
            return Result.getException(ExceptionEnum.ParamIllegal).getJson();
        }

        //用户【账号、密码】登录认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getAccount(), AuthUtils.encodeMD5(userInfo.getPassword(), ""));
        //获取登录IP
        String ip= IpUtils.getIpAddr(request);
        try {
            //登录成功
            Map<String,Object> loginMap = new HashMap<String,Object>();
            subject.login(token);
            loginMap.put("token", subject.getSession().getId());
            loginMap.put("url", "/system/nav/main");
            /*******************test*****************************/
            //授权的权限控制
            //====布尔值判断
            //功能权限
            if(subject.isPermitted("staff")){
                //必须拥有staff功能权限才能执行代码
                System.out.println("我是一段代码。。。。。");
            }
            //角色权限
            if(subject.hasRole("0")){
                //必须拥有staff功能权限才能执行代码
                System.out.println("我是一段代码。。。。。");
            }

            /************************************************/

            //记录登录日志
            loginLogService.insert(loginLogService.getLogin(userInfo,ip,Constant.NUMBER_1));
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.LOGIN_SUCCESS,loginMap,"").getJson();
        } catch (IncorrectCredentialsException e) {
            //账号密码不匹配
            loginLogService.insert(loginLogService.getLogin(userInfo,ip,Constant.NUMBER_2));
            return Result.getException(ExceptionEnum.UserPwdError).getJson();

        } catch (LockedAccountException e) {

            //账号已经锁定
            loginLogService.insert(loginLogService.getLogin(userInfo,ip,Constant.NUMBER_3));
            return Result.getException(ExceptionEnum.UserSTAENoAuth).getJson();

        } catch (DisabledAccountException e) {
            //账号已注销
            loginLogService.insert(loginLogService.getLogin(userInfo, ip, Constant.STATE_DELETE));
            return Result.getException(ExceptionEnum.UserSTAEDel).getJson();

        } catch (AccountException e) {

            //用户待审核 ｜状态问题  或者是过期
            loginLogService.insert(loginLogService.getLogin(userInfo, ip, Constant.NUMBER_5));
            return Result.getException(ExceptionEnum.UserStateError).getJson();

        } catch (AuthenticationException e) {
            return Result.getException(ExceptionEnum.UserNotFond).getJson();

        } catch (Exception e) {
            e.printStackTrace();
        }
         return Result.getException(ExceptionEnum.SysErrorUnexpected).getJson();
    }

    @ApiIgnore//使用该注解忽略这个API
    @RequestMapping(value = "/h1", method = RequestMethod.GET)
    public String  jsonTest() {
        return " hi you!";
    }
    @RequestMapping(value = "/h2", method = RequestMethod.GET)
    public String  jsonTest2() {
        return " hi you!";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         *  yyyy-MM-dd hh:mm:ss
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }


}
