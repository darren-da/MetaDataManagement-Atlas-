package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 21:19 2018/7/14
 * @modified By:
 */
public class BaseController {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前用户
     * @return
     */
    public UserInfo getUserInfo() {
        Object object = getSubject().getPrincipal();
        return (UserInfo)object;
    }

    //todo:分页基本属性，时间格式话方法等...

}
