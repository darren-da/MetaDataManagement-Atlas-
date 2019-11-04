package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.Services;
import com.limp.framework.boss.domain.ServicesParams;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

/**
 * 用户service
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
public interface ServicesInfoService extends AbstractService<Services> {

    /**
     * 获取参数列表
     * @param servicesParams
     * @param pager
     * @return
     */
    public Pager<ServicesParams> getPageServiceParamsList(ServicesParams servicesParams, Pager pager) ;


}