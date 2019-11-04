package com.gla.datacenter.service.impl;

import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.domain.LoginLog;
import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.mapper.mysql.UserInfoMapper;
import com.gla.datacenter.service.AuthService;
import com.gla.datacenter.service.LimpFrameworkClientService;
import com.gla.datacenter.service.UserInfoService;
import com.limp.framework.auth.AuthUtils;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.IpUtils;
import com.limp.framework.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Description: 用户认证模块
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/1 13:22
 */
@Service
public class AuthServiceImpl  implements AuthService {

    private Logger logger=LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    LimpFrameworkClientService limpFrameworkClientService;




    /**
     * 注入mapper
     */
    @Autowired
    private UserInfoMapper userInfoMapper;



    @Override
    public Result login(String account, String password, String roleCode, String validateCode, HttpServletRequest  request) {

        //用户【账号、密码】登录认证
        //获取登录IP
        String ip= IpUtils.getIpAddr(request);
        //获取用户的输入的账号.
        UserInfo userParam=new UserInfo();
        if(account.indexOf(Constant.FLAY_EMAIL)>-1){
            userParam.setEmail(account);
        }else{
            userParam.setAccount(account);
        }
        //登录用户列表
        List<UserInfo> loginUserList=userInfoService.getList(userParam);
        if(loginUserList.size()==0){
            //用户不存在
            return  Result.getException(ExceptionEnum.UserNotFond);
        }
        //登录用户
        UserInfo loginUser=loginUserList.get(0);
        //用户密码错误1
        if(!loginUser.getPassword().equals(AuthUtils.encodeMD5(password, ""))){
            limpFrameworkClientService.insertLoginLog(getLogin(loginUser,ip,Constant.NUMBER_2));

            return  Result.getException(ExceptionEnum.UserPwdError);
        }

        //账户冻结 2
        if (loginUser.getState()!=null&&loginUser.getState() == Short.parseShort(Constant.STRING_2)) {
            limpFrameworkClientService.insertLoginLog(getLogin(loginUser,ip,Constant.NUMBER_3));

            return  Result.getException(ExceptionEnum.UserSTAENoAuth);
        }
        //账号已经删除不可用：注销状态 -1
        if (loginUser.getState()!=null&&loginUser.getState() == Short.parseShort(Constant.STRING_DEL)) {
            return Result.getException(ExceptionEnum.UserSTAEDel);
        }
        //用户待审核
        if(loginUser.getState()!=null&&!Constant.STRING_1.equalsIgnoreCase(loginUser.getState().toString())){
            limpFrameworkClientService.insertLoginLog(getLogin(loginUser, ip, Constant.NUMBER_5));

            return Result.getException(ExceptionEnum.UserStateError);
        }
        //验证是否过期
        if(validateExpired(loginUser)){
            limpFrameworkClientService.insertLoginLog(getLogin(loginUser, ip, Constant.NUMBER_5));
            return Result.getException(ExceptionEnum.UserExpired);
        }

        //角色 判断
        List<Map<String,String>> listMap=userInfoMapper.selectUsersByUserIdAndRoleCode(loginUser.getId(),roleCode);
       if(StrUtils.isBlank(listMap)||listMap.size()==0){
           return Result.getException(ExceptionEnum.UserRoleNotFind);
       }

        //用户未初始化 密码
        if(loginUser.getPassword().equals(AuthUtils.encodeMD5("123456", ""))){
            return  Result.getException(ExceptionEnum.UserPwdNotInit);
        }
            //登录成功
            Map<String,Object> loginMap = new HashMap<String,Object>();
            //创建token
            loginMap.put("token", JwtUtil.getInstance().generateToken(loginUser));
            loginMap.put("url", "#");
            loginMap.put("name",loginUser.getName());
            loginMap.put("account",loginUser.getAccount());
            loginMap.put("roleCode",roleCode);
            loginMap.put("id",loginUser.getId());
            /*******************test*****************************/

            //记录登录日志
        try {
            limpFrameworkClientService.insertLoginLog(getLogin(loginUser,ip, Constant.NUMBER_1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.LOGIN_SUCCESS,loginMap,"");

    }

    /**
     * 实例化登录日志
     * @param user
     * @param ip
     * @param logType
     * @return
     */
    public LoginLog getLogin(UserInfo user, String ip, Integer logType) {
        LoginLog loginLog=new LoginLog();
        loginLog.setId(UUID.randomUUID().toString());
        loginLog.setAccount(user.getAccount());
        loginLog.setIp(ip);
        loginLog.setMsg(logType==Constant.NUMBER_1?"登陆成功":"登录失败");
        //操作类型 登录
        loginLog.setType(Constant.NUMBER_1);
        loginLog.setLogtype(logType);
        loginLog.setState(Constant.NUMBER_1);
        loginLog.setIdt(new Date());
        return   loginLog;
    }

    /**
     * 验证是否过期
     * @param user
     * @return
     */
    public boolean validateExpired(UserInfo user) {
        //是否过期
        Integer usrIsautoexpire = user.getIsautoexpire();
        if (usrIsautoexpire != null && usrIsautoexpire.intValue() == 1) {
            Date expire = user.getExpiredate();
            if (expire == null) {
                return false;
            }
            return new Date().after(expire);
        }
        return false;
    }

}
