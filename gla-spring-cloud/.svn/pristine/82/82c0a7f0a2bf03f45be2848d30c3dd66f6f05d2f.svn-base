package com.gla.datacenter.config;

import com.limp.framework.boss.domain.Menu;
import com.limp.framework.boss.domain.Role;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.boss.service.LoginLogService;
import com.limp.framework.boss.service.PermissionService;
import com.limp.framework.boss.service.RoleService;
import com.limp.framework.boss.service.UserInfoService;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * 自定义权限匹配和账号密码匹配
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger log= LoggerFactory.getLogger(MyShiroRealm.class);

    /**
     * 用户基本信息相关service
     */
    @Resource
    private UserInfoService userInfoService;
    /**
     * 用户角色相关
     */
    @Resource
    private RoleService roleService;
    @Resource
    private PermissionService permissionService;

    @Resource
    private LoginLogService loginLogService;

    /**
     * 授权方法：获取用户的权限信息  授权:回调方法
     *如果返回null，说明没有权限，shiro会自动跳到<property name="unauthorizedUrl" value="/unauthorized.jsp" />
     *如果不返回null，根据配置/page_base_subarea.action = roles["weihu"]，去自动匹配
     *给授权提供数据的
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

        //给当前用户授权的权限（功能权限、角色）
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //方式1：工具类来获取(首长-)
        //     User user=(User)SecurityUtils.getSubject().getPrincipal();
        //方式2：通过参数获取首长(推荐)
        UserInfo user = (UserInfo) principals.getPrimaryPrincipal();

        try {
            //暂且所有的角色
            List<Role> roles = roleService.getList(new Role());

            List<String> roleIds = userInfoService.getUserRoleIDS(user.getId());
            for (String roleId : roleIds) {
                authorizationInfo.addRole(roleId);
               //P普通角色
                //导航查询,获取某角色的拥有的功能权限
                List<Menu> menus = roleService.selectRoleMenus(roleId);
                for (Menu menu : menus) {
                    if(!StrUtils.isBlank(menu.getPerms())){
                        authorizationInfo.addStringPermission(menu.getPerms());
                    }
                }
            }


            /**
             * 绑定其它权限
             */
            //绑定用户权限
            Subject subject = SecurityUtils.getSubject();

            permissionService.initSessionAuth();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //将授权信息交给安全管理器接口
        return authorizationInfo;
    }

    /**
     * 认证:回调，认证管理器会将认证令牌放到这里（action层的令牌AuthenticationToken）
     * 发现如果返回null，抛出用户不存在的异常UnknownAccountException
     * 简而言之：主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        //获取用户的输入的账号.
        String account = (String) token.getPrincipal();
        log.debug("认证:回调-校验登录用户:"+account);
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userParam=new UserInfo();
        userParam.setAccount(account);
        //登录用户列表
        List<UserInfo> loginUserList=userInfoService.getList(userParam);
        if(loginUserList.size()==0){
            throw new UnknownAccountException("用户不存在");
        }
        //登录用户
        UserInfo loginUser=loginUserList.get(0);
        //账户冻结 2
        if (loginUser.getState()!=null&&loginUser.getState() == Short.parseShort(Constant.STRING_2)) {
            throw new LockedAccountException("用户被锁定");
        }
        //账号已经删除不可用：注销状态 -1
        if (loginUser.getState()!=null&&loginUser.getState() == Short.parseShort(Constant.STRING_DEL)) {
            throw new DisabledAccountException("用户已注销");
        }
        if(loginUser.getState()!=null&&!Constant.STRING_1.equalsIgnoreCase(loginUser.getState().toString())){
           //用户待审核

            throw new AccountException("用户状态异常");
        }
        //验证是否过期
        if(loginLogService.validateExpired(loginUser)){
            throw new AccountException("用户已经过期");

        }
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute(Constant.KEY_USER,loginUser);





        // 可以是username，也可以是数据表对应的用户的实体类对象
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                //用户名
                loginUser,
                //密码
                loginUser.getPassword(),
                //salt=username+salt
                ByteSource.Util.bytes(loginUser.getAccount()),
                //realm name
                getName()
        );

        permissionService.initSessionAuth();
        return authenticationInfo;
    }

}
