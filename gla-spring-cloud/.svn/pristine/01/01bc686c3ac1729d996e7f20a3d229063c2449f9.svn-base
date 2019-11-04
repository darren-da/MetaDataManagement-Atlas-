package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.service.RoleService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 角色相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class RoleController extends BaseController {

    private Logger loger= LoggerFactory.getLogger(RoleController.class);

    @Autowired
    RoleService roleService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 新增角色信息
     * @param role
     * @return
     */
    @ApiOperation(value="创建角色", notes="根据Role对象创建角色")
    @ApiImplicitParam(name = "role", value = "角色详细实体role", required = true, dataType = "Role")
    @RequiresPermissions("role:add")
    @RequestMapping(value = "/role",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增角色信息")
    public String saveRole(Role role) {
        loger.debug("/***新增角色信息**/");
        Boolean flay= roleService.save(role);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 新增角色菜单权限信息
     * @param menu
     * @return
     */
    @ApiOperation(value="角色设置菜单权限")
    @RequiresPermissions("role:menu:update")
    @RequestMapping(value = "/role/{id}/menu",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新角色权限信息")
    public String setRolePerms(@PathVariable("id") String id,Menu menu) {
        TextUtils.format("/***为角色{0}设置菜单权限{1}**/", id,menu.getMenuIds());
        if(StrUtils.isBlank(menu.getMenuIds())){
            return Result.getException(ExceptionEnum.ParamISNUll).getJson();
        }
        if(roleService.setRolePerms(id, Arrays.asList(menu.getMenuIds().split(Constant.DHAO)))){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除角色
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @ApiOperation(value="删除角色", notes="根据url的id来指定删除角色")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "String", paramType = "path")
    @RequiresPermissions("role:del")
    @RequestMapping(value = "/role/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除角色")
    public String delRole( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据角色id{0}，删除角色记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!roleService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 更新角色信息
     * @param role role
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新角色信息")
    @RequiresPermissions("role:update")
    @RequestMapping(value = "/role",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新角色信息")
    public String updateRole(Role role) {
        loger.debug(TextUtils.format("/***更新角色信息**/"));
        Boolean flay= roleService.update(role);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 获取角色信息根据角色id
     * @param model
     * @param id 查询的id
     * @return
     */
    @ApiOperation(value="获取角色详细信息", notes="根据url的id来获取角色详细信息")
    @ApiImplicitParam(name = "id", value = "角色ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/role/{id}",method= RequestMethod.GET)
    public String selectRole(Model model, @PathVariable("id") String id) {
        Integer.parseInt(id);
        loger.debug(TextUtils.format("/***根据角色id{0}，获取角色基本信息**/", id));
        Role role= roleService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,role,"").getJson();
    }
    /**
     * 查询用于列表
     * @param role
     * @return
     */

    @ApiOperation(value="获取角色列表", notes="获取角色列表")
    @RequestMapping(value = "/roles",method= RequestMethod.GET)
    public String selectRoleList(Role role,Pager pager) {
        loger.debug(TextUtils.format("/***查询角色,返回角色列表**/"));
        pager = new Pager(pager.getPage(), DEFAULT_ROW);
        Pager<Role> rolePager= roleService.getPageList(role, pager);
        if(true){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,rolePager,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
    }


}
