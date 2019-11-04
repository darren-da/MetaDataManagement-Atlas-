package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.service.MenuService;
import com.limp.framework.boss.service.MenuService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
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
import java.util.Date;

/**
 * 菜单相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/8/18
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class MenuController extends BaseController {

    private Logger loger= LoggerFactory.getLogger(MenuController.class);

    @Autowired
    MenuService menuService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 新增菜单信息
     * @param menu
     * @return
     */
    @ApiOperation(value="创建菜单", notes="根据Menu对象创建菜单")
    @ApiImplicitParam(name = "menu", value = "菜单详细实体menu", required = true, dataType = "Menu")
    @RequiresPermissions("menu:add")
    @RequestMapping(value = "/menu",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增菜单信息")
    public String saveMenu(Menu menu) {
        loger.debug("/***新增菜单信息**/");
        Boolean flay= menuService.save(menu);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除菜单
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @ApiOperation(value="删除菜单", notes="根据url的id来指定删除菜单")
    @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "String", paramType = "path")
    @RequiresPermissions("menu:del")
    @RequestMapping(value = "/menu/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除菜单信息")
    public String delMenu( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据菜单id{0}，删除菜单记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!menuService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 更新菜单信息
     * @param menu menu
     * @return
     */
    @ApiOperation(value="更新菜单信息", notes="根据url的id来指定更新菜单信息")
    @RequiresPermissions("menu:update")
    @RequestMapping(value = "/menu",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新菜单信息")
    public String updateMenu(Menu menu) {
        loger.debug(TextUtils.format("/***更新菜单信息**/"));
        Boolean flay= menuService.update(menu);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 获取菜单信息根据菜单id
     * @param model
     * @param id 查询的id
     * @return
     */
    @ApiOperation(value="获取菜单详细信息", notes="根据url的id来获取菜单详细信息")
    @ApiImplicitParam(name = "id", value = "菜单ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/menu/{id}",method= RequestMethod.GET)
    public String selectMenu(Model model, @PathVariable("id") String id) {
        Integer.parseInt(id);
        loger.debug(TextUtils.format("/***根据菜单id{0}，获取菜单基本信息**/", id));
        Menu menu= menuService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,menu,"").getJson();
    }
    /**
     * 查询用于列表
     * @param menu
     * @return
     */

    @ApiOperation(value="获取菜单列表", notes="获取菜单列表")
    @RequestMapping(value = "/menus",method= RequestMethod.GET)
    public String selectMenuList(Menu menu,Pager pager) {
        loger.debug(TextUtils.format("/***查询菜单,返回菜单列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<Menu> menuPager
                = menuService.getPageList(menu, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,menuPager,"").getJson();
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

  /*
    传递数组： 前端的 [1,2,3]
    @PostMapping("/batchRemove")
   void batchRemove(@RequestParam("ids[]") Long[] ids) {
        int r = logService.batchRemove(ids);
    }*/

}
