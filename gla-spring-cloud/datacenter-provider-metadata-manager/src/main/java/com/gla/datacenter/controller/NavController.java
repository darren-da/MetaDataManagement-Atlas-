package com.gla.datacenter.controller;

import com.limp.framework.boss.service.UserInfoService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.TextUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@Controller
@RequestMapping("/system/nav")
public class NavController {
    private Logger loger= LoggerFactory.getLogger(NavController.class);
    /**
     * 主题风格
     */
    private static final String theme="m1";

    @Autowired
    UserInfoService userInfoService;


    /*********************业务层*******************************/
    /**
     * 登录日志页面
     * @return
     */
    @RequestMapping(value = "loginlog")
    public String LoginLog() {
        loger.debug("visit sys_login_log ...");
        return "systemsite/"+theme+"/pages/log/sys_login_log";
    }

    /**
     * 系统命令管理
     * @return
     */
    @RequestMapping(value = "command")
    public String Command() {
        loger.debug("visit sys_command_list ...");
        return "systemsite/"+theme+"/pages/command/sys_command_list";
    }
    /**
     * 博客管理
     * @return
     */
    @RequestMapping(value = "blog")
    public String BolgList() {
        loger.debug("visit sys_blog_list ...");
        return "systemsite/"+theme+"/pages/blog/sys_blog_list";
    }
    /**
     * 新增博客
     * @return
     */
    @RequestMapping(value = "blogAdd")
    public String blogAdd() {
        loger.debug("visit sys_blog_list ...");
        return "systemsite/"+theme+"/pages/blog/sys_blog_add";
    }

    /**
     * 快速构建数据库
     * @return
     */
    @RequestMapping(value = "commandDB")
    public String bu() {
        loger.debug("visit sys_command_db ...");
        return "systemsite/"+theme+"/pages/command/sys_command_db";
    }

    @RequestMapping(value = "modelContent")
    public String ModelContent() {
        loger.debug("visit sys_modelContent ...");
        return "systemsite/"+theme+"/pages/model/sys_modelContent";
    }

    /**
     * 访问pageLog页面
     * @return
     */
    @RequestMapping(value = "pagelog")
    public String PageLog() {
        loger.debug("visit sys_page_log ...");
        return "systemsite/"+theme+"/pages/log/sys_page_log";
    }

    /**
     * 访问operationLog页面
     * @return
     */
    @RequestMapping(value = "operationLog")
    public String operationLog(){
        loger.debug("visit sys_operation_log ...");
        return "systemsite/"+theme+"/pages/log/sys_operation_log";
    }

    @RequestMapping(value = "setting")
    public String setSetting(){
        loger.debug("visit sys_operation_log ...");
        return "systemsite/"+theme+"/pages/log/sys_operation_setting";
    }


    @RequestMapping(value = "area")
    public String areaIndex() {

        loger.debug("visit sys_area ...");
        return "systemsite/"+theme+"/pages/sys/sys_area";
    }

    /**
     * 部门首页
     * @return
     */
    @RequestMapping(value = "dept")
//    @RequiresPermissions("nav:dept")
    public String deptIndex() {
        loger.debug("visit dept ...");
        return "systemsite/"+theme+"/pages/dept/sys_dept";
    }
    @RequestMapping(value = "code")
    public String codeIndex() {
        loger.debug("visit sys_code ...");
        return "systemsite/"+theme+"/pages/sys/sys_code";
    }
    @RequestMapping(value = "tagslib")
    public String tagslibIndex() {
        loger.debug("visit sys_tagslib ...");
        return "systemsite/"+theme+"/pages/sys/sys_tagslib";
    }
    /****************************************************/

    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "main")
    @RequiresPermissions("nav:main")
    @Access(privilege = true,login = true)
    public String main() {
        loger.debug("visit main ...");
        return "systemsite/"+theme+"/main";
    }
    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "login")
    public String Login() {
        loger.debug("visit sys_login ...");
        return "systemsite/"+theme+"/sys_login";
    }
    /**
     * 登录页面
     * @return
     */
    @RequestMapping(value = "desk")
    public String indexDesk() {
        loger.debug("visit sys_login ...");
        return "systemsite/"+theme+"/sys_desk";
    }
    /**
     * 欢迎页面
     * @return
     */
    @RequestMapping(value = "welcome")
    public String welcome() {
        loger.debug("visit sys_welcome ...");
        return "systemsite/"+theme+"/pages/sys_welcome";
    }
    /***********************用户相关***************************************/
    /**
     * 用户中心
     * @return
     */
    @RequiresPermissions("nav:user:index")
    @RequestMapping(value = "/user/index")
    public String userList() {
        loger.debug("visit sys_user_list ...");
        return "systemsite/"+theme+"/pages/user/sys_user_list";
    }
    /**
     * 菜单权限中心
     * @return
     */
    @RequiresPermissions("nav:menu:index")
    @RequestMapping(value = "/menu/index")
    public String menuList() {
        loger.debug("visit sys_menu_list ...");
        return "systemsite/"+theme+"/pages/menu/sys_menu_list";
    }
    /**
     * 角色管理
     * @return
     */
    @RequiresPermissions("nav:role:index")
    @RequestMapping(value = "/role/index")
    public String roleList() {
        loger.debug("visit sys_welcome ...");
        return "systemsite/"+theme+"/pages/role/sys_role_list";
    }
    /**
     * demo演示
     * @return
     */
    @RequestMapping(value = "/demo/{id}")
    public String demo( @PathVariable("id") String id) {
        loger.debug("visit demo ...");
        return "systemsite/"+theme+"/pages/demo/demo"+id;
    }
    /**
     * demo演示
     * @return
     */
    @RequestMapping(value = "/error/{code}")
    public String error(@PathVariable("code") String code) {

        if(Constant.ERROR_403.equalsIgnoreCase(code)||Constant.ERROR_404.equalsIgnoreCase(code)
                ||Constant.ERROR_500.equalsIgnoreCase(code)){
            loger.debug(TextUtils.format("访问资源错误{0},请开发人员排查",code));
            return "systemsite/"+theme+"/"+code;
        }
       return "systemsite/"+theme+"/error";
    }

}
