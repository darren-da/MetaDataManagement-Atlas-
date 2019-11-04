package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.UserInfo;
import com.limp.framework.boss.domain.UserInfoExample;
import com.limp.framework.boss.mapper.oracle.UserInfoMapper;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:  实现类的模板
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
//@Service   //!!!不要忘记注解@Service
public class DemoDomainServiceImpl {
    /**
     * 替换步骤
     * 1 LOG_DOMAIN 更改描述信息 如  用户 、角色等实体类名称
     * 2.domainInfoMapper 更改mapper信息 变成实体类操作的mapper   全量替换 ctrl+R
     * 3.@Service   //!!!不要忘记注解@Service
     * 4.Override 添加
     */

    private Logger log= LoggerFactory.getLogger(DemoDomainServiceImpl.class);

    //要输出的日志实体类
    private final String LOG_DOMAIN="用户";

    /**
     * 注入mapper
     */
    @Autowired
    private UserInfoMapper domainInfoMapper;


    /**
     * 新增实体类 【1】
     * @param entry 需要保存的实体类
     * @return
     */

//    @Override
    public boolean save(UserInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        log.debug("新增{};id->{}",LOG_DOMAIN, entry.getId());
        try {
            return domainInfoMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error("{}新增失败",LOG_DOMAIN);
            return false;
        }
    }


    /**
     *
     * 根据ID删除实体类【2】
     * @param id 需要删除的Id
     * @return
     */
//    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("根据{}Id:{0},删除实体类信息",LOG_DOMAIN,id));
        //逻辑删除
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setState(Short.parseShort(Constant.STRING_DEL_STATE) );
        return domainInfoMapper.updateByPrimaryKeySelective(userInfo)== 1?true:false;
    }

    /**
     * 修改实体类信息【3】
     * @param entry 当前实体类信息
     * @return
     */
//    @Override
    public boolean update(UserInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug("修改实体类{}信息",entry.getId());
        return domainInfoMapper.updateByPrimaryKeySelective(entry)==1?true:false;
    }

    /**
     * 查询实体类信息
     * @param id 主键id
     * @return
     */
//    @Override
    public UserInfo get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug("根据{}:Id->{},获取实体类信息",LOG_DOMAIN,id);
        return domainInfoMapper.selectByPrimaryKey(id);
    }






    /**
     *
     *根据条件查询实体类列表
     * @param domainInfo
     * @param pager 分页信息
     * @return
     */
//    @Override
    public Pager<UserInfo> getPageList(UserInfo domainInfo, Pager pager) {

        log.debug("根据条件,查询{}列表【分页方法】",LOG_DOMAIN);
        //初始化Example
        UserInfoExample userExample = new UserInfoExample();
        //设置分页对象
        userExample.setPage(pager);
        //创建查询条件
        UserInfoExample.Criteria userCriteria = userExample.createCriteria();

        //如果用户状态不为空，则更具用户状态查询用户列表
        if (!StrUtils.isBlank(domainInfo.getState())) {
            userCriteria.andStateEqualTo(domainInfo.getState());
        }
        if (!StrUtils.isBlank(domainInfo.getCreatedate())) {
             userCriteria.andCreatedateBetween(domainInfo.getCreatedate(), domainInfo.getLpEndDate() == null ? new Date() : domainInfo.getLpEndDate());
        }

      //扩展：可设置相等、大于、小于、between ，like等匹配条件，此外可以自定义
        if (!StrUtils.isBlank(domainInfo.getRc3())) {
            userCriteria.andRc3EqualTo(domainInfo.getRc3());
        }

        //根据账号：模糊查询
        if (!StrUtils.isBlank(domainInfo.getAccount())) {
            userCriteria.andAccountLike("%" + domainInfo.getAccount() + "%");
        }

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(domainInfo.getLpsort())){
            userExample.setOrderByClause(domainInfo.getLpsort());
        }
        List<UserInfo> users=domainInfoMapper.selectByExample(userExample);

        pager.setPagerInfo(users,domainInfoMapper.countByExample(userExample));

        return pager;

    }

//    @Override
    public List<UserInfo> getList(UserInfo userInfo) {
        return  null;
    }

}
