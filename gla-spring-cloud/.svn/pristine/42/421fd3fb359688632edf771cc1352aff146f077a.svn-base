package com.gla.datacenter.service;


import com.gla.datacenter.domain.UserInfo;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 权限接口
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/24 11:44
 */
public interface AuthService {


    /**
     * 登陆认证
     * @param account
     * @param password
     * @param roleCode
     * @param validateCode
     * @return
     */
    Result login(String account, String password, String roleCode, String validateCode, HttpServletRequest  request);
}
