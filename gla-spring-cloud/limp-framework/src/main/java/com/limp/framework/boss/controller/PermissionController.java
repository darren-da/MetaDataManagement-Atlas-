package com.limp.framework.boss.controller;

import com.limp.framework.boss.ApplicationContext;
import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.service.PermissionService;
import com.limp.framework.core.abs.AbstractAction;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 权限控制
 * Created with IntelliJ IDEA.
 * @author:zzh
 * Date: 17-6-27
 * Time: 上午9:14
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RestController
@RequestMapping("/system/perm")
public class PermissionController extends AbstractAction {

    private static Logger log = Logger.getLogger(PermissionController.class);

    @Autowired
    private PermissionService permissionService;


    /**
     * 初始化用户权限｜重新加载用户权限
     * @return
     */
    @RequestMapping(value ="initSessionAuth",produces = "text/plain;charset=UTF-8")
    public String initSessionAuth() {
        if (!permissionService.initSessionAuth()){
            return  new Result(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
        }
        //todo 系统配置部分 增加
       /* try {
            //重新加载系统环境:第二部加载【在加载initSessionAuth之后追加】
            permissionService.initSessionConfig(session);
        } catch (Exception e) {
            log.error(e);
        }*/
        return  new Result(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
    }

    /**
     *  根据菜单的父类id获得权限菜单集合 【session中获得】
     * @param request
     * @param session
     * @param id
     * @return
     */
    @Access(login=true,privilege = false)
    @RequestMapping(value ="getMenuById",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String getMenuById(HttpServletRequest request, HttpSession session, String id) {
        List<Menu> menusbak=(ArrayList<Menu>)session.getAttribute(Constant.KEY_MENU);
        if(StrUtils.isBlank(menusbak)){
            menusbak = ApplicationContext.getMenuList();
        }
        if(StrUtils.isBlank(menusbak)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, menusbak, new HashMap<String,String>()).getJson();
        }
        List<Menu> menus=new ArrayList<Menu>();
        for(Menu menub:menusbak){
            if(menub.getType()<10){
                menus.add(menub) ;
            }
        }
        if(StrUtils.isBlank(menus)){
            return  Result.getInstance(ResultCode.ERROR.toString(),"error","未登录","").getJson();
        }
        List<Menu>authMenus=new ArrayList<Menu>();
        for (Menu menu:menus){
            //如果是查询id的子目录
            if(menu.getParentId().equals(id)){
                //查找一级菜单 以及它的子类
                List<Menu> menuChilds=new ArrayList<Menu>();
                for (Menu menuChild:menus){
                    if(menuChild.getParentId().equals(menu.getId())){
                        //查找二级菜单以及子类
                        List<Menu> menuChildChild=new ArrayList<Menu>();
                        for (Menu menuChildC:menus){
                            if(menuChildC.getParentId().equals(menuChild.getId())){
                                //查找三级菜单以及子类
                                List<Menu> lastChilds=new ArrayList<Menu>();
                                for (Menu lastChild:menus){
                                    if(lastChild.getParentId().equals(menuChildC.getId())){
                                        //查找四级菜单以及子类
                                        List<Menu> lastChildsLast=new ArrayList<Menu>();
                                        for(Menu lastChildLast:menus){
                                            if(lastChildLast.getParentId().equals(lastChild.getId())){
                                                lastChildsLast.add(lastChildLast);
                                            }
                                        }
                                        lastChild.setChildren(lastChildsLast);
                                        lastChilds.add(lastChild);
                                    }
                                }
                                menuChildC.setChildren(lastChilds);
                                menuChildChild.add(menuChildC);
                            }
                            menuChild.setChildren(menuChildChild);
                        }
                        menuChilds.add(menuChild);
                    }
                }
                menu.setChildren(menuChilds);
                authMenus.add(menu);
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, authMenus, new HashMap<String,String>()).getJson();
    }

}
