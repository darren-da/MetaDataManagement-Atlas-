package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.LoginLog;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.core.bean.Pager;

public interface LoginLogService {


    String getLogList(LoginLog loginLog, Pager pager);

    /**
     * 新增登录日志
     * @param loginLog
     */
    boolean  insert(LoginLog loginLog);

    /**
     * 初始化新增对象实体类
     * @param user
     * @param ip
     * @param logType
     * @return
     */
    LoginLog getLogin(UserInfo user, String ip, Integer logType);

    /**
     * 验证用户是否过期
     * @param user
     * @return
     */
    public boolean validateExpired(UserInfo user);
}
