package com.gla.datacenter.controller;


import com.gla.auth.jwt.filter.JwtUtil;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.service.AuthService;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.utils.StrUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * auth认证授权相关
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private Logger log= LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthService authService;



    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    /**
     * 用户
     * @param account
     * @param password
     * @param roleCode
     * @param validateCode
     * @return
     */
   @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(HttpServletRequest request,@RequestParam String account, @RequestParam String password
           , @RequestParam String roleCode, @RequestParam String validateCode) {
        log.debug("/***用户登陆*{}*/",account);
       //参数校验
       if(StrUtils.isBlank(account)||StrUtils.isBlank(password)
               ||StrUtils.isBlank(roleCode)||StrUtils.isBlank(validateCode)){
           return Result.getException(ExceptionEnum.ParamIllegal).getJson();
       }
        Result loginResult = authService.login(account,password,roleCode,validateCode,request);
       log.info("登录返回的结果集为:{}",loginResult.getJson());
        return loginResult.getJson();
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         *  yyyy-MM-dd hh:mm:ss
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
