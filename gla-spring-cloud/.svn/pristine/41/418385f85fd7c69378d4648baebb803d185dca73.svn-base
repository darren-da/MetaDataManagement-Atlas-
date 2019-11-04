package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.Services;
import com.limp.framework.boss.domain.ServicesExample;
import com.limp.framework.boss.domain.ServicesParams;
import com.limp.framework.boss.domain.ServicesParamsExample;
import com.limp.framework.boss.mapper.oracle.ServicesMapper;
import com.limp.framework.boss.mapper.oracle.ServicesParamsMapper;
import com.limp.framework.boss.service.ServicesInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
@Service
public class ServicesInfoServiceImpl implements ServicesInfoService {

    private Logger log= LoggerFactory.getLogger(ServicesInfoServiceImpl.class);

    /**
     * 注入mapper
     */
    @Autowired
    private ServicesMapper servicesMapper;

    @Autowired
    private ServicesParamsMapper servicesParamsMapper;

    @Override
    public boolean save(Services entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增services服务{0}", entry.getId()));
        try {
            return  servicesMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Services get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据services服务Id{0},获取实体类信息",id));
        return servicesMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Services entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug(TextUtils.format("根据services服务Id{0},更新实体类信息",entry.getId()));
        return servicesMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete( String id) {
        log.debug(TextUtils.format("根据services服务Id{0},删除实体类信息", id));
        //逻辑删除
        return  servicesMapper.deleteByPrimaryKey(id)== 1?true:false;
    }

    @Override
    public List<Services> getList(Services services) {
        //初始化Example
        ServicesExample servicesExample = new ServicesExample();

        //创建查询条件
        ServicesExample.Criteria criteria = servicesExample.createCriteria();


        //根据服务名称
        if (!StrUtils.isBlank(services.getServiceName())) {
            criteria.andServiceNameLike("%" + services.getServiceName()+"%");
        }

        //服务
        if (!StrUtils.isBlank(services.getServiceMethod())) {
            criteria.andServiceMethodEqualTo(services.getServiceMethod());
        }

        return  servicesMapper.selectByExample(servicesExample);
    }

    @Override
    public Pager<Services> getPageList(Services services, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询services服务列表【分页方法】"));
        //初始化Example
        ServicesExample serviceExample = new ServicesExample();
        //设置分页对象
        serviceExample.setPage(pager);
        //创建查询条件
        ServicesExample.Criteria criteria = serviceExample.createCriteria();

        //根据服务名称
        if (!StrUtils.isBlank(services.getServiceName())) {
            criteria.andServiceNameLike("%" + services.getServiceName() + "%");
        }

        //服务
        if (!StrUtils.isBlank(services.getServiceMethod())) {
            criteria.andServiceMethodEqualTo(services.getServiceMethod());
        }

        //如果services服务类型不为空，则根据services服务类型查询services服务列表

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(services.getLpsort())){
            serviceExample.setOrderByClause(services.getLpsort());
        }
        List<Services> servicesList=servicesMapper.selectByExample(serviceExample);

        pager.setPagerInfo(servicesList,servicesMapper.countByExample(serviceExample));

        return pager;

    }

    @Override
    public Pager<ServicesParams> getPageServiceParamsList(ServicesParams servicesParams, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询servicesParams服务列表【分页方法】"));
        //初始化Example
        ServicesParamsExample servicesParamsExample = new ServicesParamsExample();
        //设置分页对象
        servicesParamsExample.setPage(pager);
        //创建查询条件
        ServicesParamsExample.Criteria criteria = servicesParamsExample.createCriteria();

        //根据服务名称
        if (!StrUtils.isBlank(servicesParams.getServiceid())) {
            criteria.andServiceidEqualTo(servicesParams.getServiceid());
        }



        //如果services服务类型不为空，则根据services服务类型查询services服务列表

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(servicesParams.getLpsort())){
            servicesParamsExample.setOrderByClause(servicesParams.getLpsort());
        }else{
            servicesParamsExample.setOrderByClause("PARAM_SORT ASC");
        }

        List<ServicesParams> servicesList=servicesParamsMapper.selectByExample(servicesParamsExample);

        pager.setPagerInfo(servicesList,servicesParamsMapper.countByExample(servicesParamsExample));

        return pager;

    }
}
