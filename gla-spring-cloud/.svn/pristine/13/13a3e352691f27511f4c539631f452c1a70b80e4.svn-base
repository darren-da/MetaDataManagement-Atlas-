package com.limp.framework.boss;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 *session相关配置
 * @author: zzh
 * Date: 16-2-4
 * Time: 下午11:19
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContext {

    //获得session用户信息

    /**
     * 获取登录用户信息
     * @param request
     * @return
     */
    public static final UserInfo getLoginUser(HttpServletRequest request){
        if(StrUtils.isBlank(request.getSession().getAttribute(Constant.KEY_USER))){
            return null;
        }
        return  (UserInfo)(request.getSession().getAttribute(Constant.KEY_USER));
    }
    /**
     * 获取登录用户信息
     * @return
     */
    public static final UserInfo getLoginUser(){
        Subject subject = SecurityUtils.getSubject();

        if(StrUtils.isBlank(subject.getSession().getAttribute(Constant.KEY_USER))){
            return null;
        }
        return  (UserInfo)subject.getSession().getAttribute(Constant.KEY_USER);
    }
    /**
     * 获取登录用户信息
     * @param session
     * @return
     */
    public static final UserInfo getLoginUser(HttpSession session){
        if(StrUtils.isBlank(session.getAttribute(Constant.KEY_USER))){
            return null;
        }
        return  (UserInfo)(session.getAttribute(Constant.KEY_USER));
    }

    /**
     * 获得用户和角色的 菜单列表权限
     * 获得session List<Menu>
     * @param request
     * @return
     */
    public static final List<Menu> getMenuList(HttpServletRequest request){
        if(StrUtils.isBlank(request.getSession().getAttribute(Constant.KEY_MENU))){
            return null;
        }
        return  (List<Menu>)(request.getSession().getAttribute(Constant.KEY_MENU));
    }
    /**
     * 获得用户和角色的 菜单列表权限
     * 通过市shiro 的 Subject获取
     * 获得session List<Menu>
     * @return
     */
    public static final List<Menu> getMenuList(){
        Subject subject = SecurityUtils.getSubject();
        if(StrUtils.isBlank(subject.getSession().getAttribute(Constant.KEY_MENU))){
            return null;
        }
        return  (List<Menu>)(subject.getSession().getAttribute(Constant.KEY_MENU));
    }
    /**
     * 获得用户和角色的 菜单列表权限
     * @param session
     * @return
     */
    public static final List<Menu> getMenuList(HttpSession session){
        if(StrUtils.isBlank(session.getAttribute(Constant.KEY_MENU))){
            return null;
        }
        return  (List<Menu>)(session.getAttribute(Constant.KEY_MENU));
    }
    /**
     * 获得用户和角色的 菜单列表权限 id:menumap
     * @param session
     * @return
     */
    public static final Map<String,Menu> getMenuKVMap(HttpSession session){
        if(StrUtils.isBlank(session.getAttribute(Constant.KEY_MENU_KVMAP))){
            return null;
        }
        return (Map<String,Menu>)session.getAttribute(Constant.KEY_MENU_KVMAP);
    }
    /**
     * 获得系统配置Map key:menumap
     * @param session
     * @return
     */
    /*public static final Map<String,ConfigField> getConfFieldKVMap(HttpSession session){
        if(StrUtils.isBlank(session.getAttribute(Constant.KEY_CONFFIELD_KVMAP))){
            return null;
        }
        return (Map<String,ConfigField>)session.getAttribute(Constant.KEY_CONFFIELD_KVMAP);
    }*/
    /**
     * 获得角色
     * 获得session List<Role>
     * @param request
     * @return
     */
    public static final List<Role> getRoleList(HttpServletRequest request){
        if(StrUtils.isBlank(request.getSession().getAttribute(Constant.KEY_ROLE))){
            return null;
        }
        return  (List<Role>)(request.getSession().getAttribute(Constant.KEY_ROLE));
    }
    /**
     * 获得角色
     * @param session
     * @return
     */
    public static final List<Role> getRoleList(HttpSession session){
        if(StrUtils.isBlank(session.getAttribute(Constant.KEY_ROLE))){
            return null;
        }
        return  (List<Role>)(session.getAttribute(Constant.KEY_ROLE));
    }

}
