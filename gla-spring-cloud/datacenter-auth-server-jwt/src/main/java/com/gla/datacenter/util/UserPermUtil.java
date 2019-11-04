package com.gla.datacenter.util;

import com.gla.datacenter.domain.UserInfo;
import com.limp.framework.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/2 9:07
 */
public class UserPermUtil {
    private static Logger logger= LoggerFactory.getLogger(UserPermUtil.class);

    /**
     * 模拟权限校验, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     * @param user
     */
    public static boolean verify(UserInfo user, HttpServletRequest request){
        logger.info("/******开始验证权限********/");
        String url = request.getHeader("x-user-serviceName");
        if(StrUtils.isBlank(user)) {
            return false;
        }else {
          /*  List<String> str = user.getAllowPermissionService();
            for (String permissionService : str) {
                if(url.equalsIgnoreCase(permissionService)) {
                    return true;
                }
            }*/
          return  true;
//            return false;
        }
    }

    /**
     * 模拟权限赋值, 可以根据自己项目需要定制不同的策略,如查询数据库获取具体的菜单url或者角色等等.
     * @param user
     */
    public static void permission(UserInfo user){
        logger.info("/******开始初始化权限********/");

      /*  if(user.getName()!=null&&user.getName().equals("meet")) {
            List allowPermissionService = new ArrayList();
            allowPermissionService.add("client-service");
            allowPermissionService.add("provider-service");
            user.setAllowPermissionService(allowPermissionService);
        }else if(user.getUserName()!=null&&user.getUserName().equals("spring")) {
            List allowPermissionService = new ArrayList();
            allowPermissionService.add("client-service");
            user.setAllowPermissionService(allowPermissionService);
        } else {
            List allowPermissionService = new ArrayList();
            user.setAllowPermissionService(allowPermissionService);
        }*/
    }
}
