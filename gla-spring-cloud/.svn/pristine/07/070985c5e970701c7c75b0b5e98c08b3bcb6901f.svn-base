package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.LoginLog;
import com.limp.framework.boss.domain.LoginLogExample;
import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.boss.mapper.oracle.LoginLogMapper;
import com.limp.framework.boss.service.LoginLogService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.DateUtils;
import com.limp.framework.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: zhangbo
 * @Date: 2018/10/16 16:40
 * @Description:系统管理-登陆日志实现
 */
@Service
public class LoginLogServiceImpl implements LoginLogService{

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public String getLogList(LoginLog loginLog, Pager pager) {

        List<LoginLog> list = new ArrayList<>();
        LoginLogExample ex = new LoginLogExample();
        ex.setPage(pager);
        LoginLogExample.Criteria criteria = ex.createCriteria();
        if (loginLog.getState() != null){
            criteria.andStateEqualTo(loginLog.getState());
        }
        if(loginLog.getType() != null){
            criteria.andTypeEqualTo(loginLog.getType());
        }
        if(!StrUtils.isBlank(loginLog.getAccount())){
            criteria.andAccountEqualTo(loginLog.getAccount());
        }
        if(loginLog.getIdt() != null && loginLog.getLpEndDate() != null){
            criteria.andIdtBetween(loginLog.getIdt(), DateUtils.getEndTime(loginLog.getLpEndDate()));
        }else{
            if(loginLog.getIdt()!= null && loginLog.getLpEndDate() == null){
                criteria.andIdtBetween(loginLog.getIdt(),DateUtils.getEndTime(loginLog.getIdt()));
            }else if(loginLog.getIdt()== null && loginLog.getLpEndDate() != null){
                criteria.andIdtBetween(loginLog.getLpEndDate(),DateUtils.getEndTime(loginLog.getLpEndDate()));
            }else{}
        }

        if(!StrUtils.isBlank(loginLog.getLpsort())){
            ex.setOrderByClause(loginLog.getLpsort());
        }else{
            ex.setOrderByClause("IDT DESC");
        }
        try{
            list = loginLogMapper.selectByExample(ex);
            pager.setPagerInfo(list,loginLogMapper.countByExample(ex));
        }catch(Exception e){
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public boolean insert(LoginLog loginLog) {
        if(StrUtils.isBlank(loginLog.getId())){
            loginLog.setId(StrUtils.randomUUID());
        }
       return  loginLogMapper.insertSelective(loginLog)==Constant.NUMBER_1?true:false;

    }

    @Override
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

    @Override
    public boolean validateExpired(UserInfo user) {
        //是否过期
        Short usrIsautoexpire = user.getIsautoexpire();
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
