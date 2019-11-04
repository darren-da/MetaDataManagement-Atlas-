package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.LoginLog;
import com.limp.framework.boss.service.LoginLogService;
import com.limp.framework.core.bean.Result;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 登录日志
 * @author:XXX
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class LoginLogController extends BaseController {

    private Logger loger= LoggerFactory.getLogger(LoginLogController.class);

    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping(value = "/login/log/list",method = RequestMethod.GET)
    public String getLogList(LoginLog loginLog){
        loger.debug(TextUtils.format("/***查询登陆日志,返回登陆日志列表(分页)**/"));
        return loginLogService.getLogList(loginLog,loginLog.getPager());
    }

    /**
     * 新增登录日志
     * @param loginLog
     * @return
     */
    @RequestMapping(value = "/loginLog",method = RequestMethod.POST)
    public String insertLoginLog(LoginLog loginLog){
        loger.debug(TextUtils.format("/***新增登录日志**/"));
        if(loginLogService.insert(loginLog)){
            return Result.Success().getJson();
        }
         return Result.Error().getJson();
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
