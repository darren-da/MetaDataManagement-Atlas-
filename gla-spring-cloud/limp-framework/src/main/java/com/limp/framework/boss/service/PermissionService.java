package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.Menu;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 17-6-29
 * Time: 上午11:19
 * To change this template use File | Settings | File Templates.
 */
public interface PermissionService  {
     /**
     * 获取 List<Menu>
     * @param uid 用户id
     * @return 所有的角色菜单
     */
    public List<Menu> getMenusById(String uid);


    /**
     * 初始化用户的权限信息
     * @return
     */
    public boolean initSessionAuth() ;

    /**
     * 初始化系统配置属性
     * @param session
     * @return
     */
//    public boolean initSessionConfig(HttpSession session) ;
}
