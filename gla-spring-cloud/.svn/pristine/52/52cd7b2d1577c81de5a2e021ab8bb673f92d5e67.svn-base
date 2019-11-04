package com.gla.datacenter.service;

import com.gla.datacenter.domain.FilterInformationApi;
import com.limp.framework.core.bean.Pager;

/**
 *
 * 功能描述: api拦截接口
 *
 * @param: 
 * @param 
 * @return: 
 * @author: zhangbo
 * @date: 2019/1/2 11:07
 */
public interface ApiFilterService {

    /**
     *
     * 功能描述: 分别获取生产者黑白名单总数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2019/1/2 11:07
     */
    String getFilterCount();

    /**
     *
     * 功能描述: 获取api过滤列表(分页)
     *
     * @param:
     * @param filterInformationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/2 11:37
     */
    String getFilterPageList(FilterInformationApi filterInformationApi,Pager pager);

    /**
     *
     * 功能描述: 新增api过滤信息
     *
     * @param: [filterInformationApi, pager]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:10
     */
    String addApiFilter(FilterInformationApi filterInformationApi, Pager pager);

    /**
     *
     * 功能描述: 删除API过滤信息(支持批量)
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:34
     */
    String deleteApiFilter(String id,int listType);
}
