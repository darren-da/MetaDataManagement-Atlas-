package com.gla.datacenter.service;

import com.gla.datacenter.domain.OrderInfo;
import com.limp.framework.core.bean.Pager;

import java.util.List;
import java.util.Map;

public interface AnalysisService {

    /**
     * 統計查詢 通用方法
     * @param method 方法的名称
     * @param params 参数
     * @return
     */
    List<Map<String,Object>> selectListMapByMethod(String method,Map<String,Object> params);

    /**
     *
     * 功能描述: 查询首页API健康度评分
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/6 16:39
     */

    String selectApiScore();

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api调用次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 11:08
     */
    String getConsumerApiUseNumByWeek();

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api申请次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 13:44
     */
    String getConsumerApiApplyNumByWeek();

    /**
     *
     * 功能描述: 生产-个人中心业务统计
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 14:26
     */
    String getProviderCenterBusinessStatistics();

    /**
     *
     * 功能描述: 生产者按维度日、周、月获取api被访问次数总数
     *
     * @param:
     * @param dateType
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:46
     */
    String getProviderApiAccessCountByDate(String dateType);

    /**
     *
     * 功能描述: 生产者按维度日、周、月获取api被访问次数折线图
     *
     * @param:
     * @param dateType
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:46
     */
    String getProviderApiAccessEchartsByDate(String dateType);

    /**
     *
     * 功能描述: 生产者获取当日访问记录
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 11:36
     */
    String getProviderDayAccessData(OrderInfo orderInfo, Pager pager);

    /**
     *
     * 功能描述: 生产者获取历史访问记录
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 11:36
     */
    String getProviderHistoryAccessData(OrderInfo orderInfo, Pager pager);

    /**
     *
     * 功能描述: 欢迎页统计五大基础库的目数据量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 10:08
     */
    String getFoundationalLibraryCatalog();

    /**
     *
     * 功能描述: 欢迎页统计三大类的项数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:17
     */
    String getThreeLibraryCatalog();

    /**
     *
     * 功能描述: 数据管理调用次数和个数统计
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 13:42
     */
    String countApiAndApp();

    /**
     *
     * 功能描述: 欢迎页首页用户统计
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/12 9:49
     */
    String countUserByPortal();
}
