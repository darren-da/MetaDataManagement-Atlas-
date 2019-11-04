package com.limp.framework.boss.controller;

import com.limp.framework.boss.service.UserInfoService;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.TextUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@Controller
@RequestMapping("/page")
public class PageController {
    private Logger loger= LoggerFactory.getLogger(PageController.class);


    /*********************业务层*******************************/

    /**
     * servies列表
     * @return
     */
    @RequestMapping(value = "services")
    public String main() {
        loger.debug("visit main ...");
        return "uums/pages/services/services_list";
    }
    /**
     * servies列表
     * @return
     */
    @RequestMapping(value = "/services/port")
    public String port() {
        loger.debug("visit main ...");
        return "uums/pages/services/services_port";
    }
    /**
     * servies列表
     * @return
     */
    @RequestMapping(value = "/order")
    public String order() {
        loger.debug("visit main ...");
        return "uums/pages/order/order_list";
    }
    /****************************************************/

}
