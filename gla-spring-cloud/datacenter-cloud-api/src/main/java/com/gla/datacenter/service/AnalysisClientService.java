package com.gla.datacenter.service;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.fallback.AnalysisClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description: 数据 分析客户端
 * @Author: zzh
 * @Date: 2018/9/28 16:14
 */
@FeignClient( value = "DATACENTER-GATEWAY",path = "/api2",fallbackFactory=AnalysisClientServiceFallbackFactory.class)
//@RequestMapping("/api2")
public interface AnalysisClientService {
    /**
     * 統計查詢 通用方法
     * @param method 方法的名称
     * @param params 参数
     * @return
     */
    @RequestMapping(value = "/anaData")
    public String selectAnaDataListMap(@RequestParam("method") String method, @RequestParam Map<String,Object> params);

    /**
     *
     * 功能描述: 查询首页API健康度评分
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/6 16:38
     */
    @RequestMapping(value = "/score")
    String selectApiScore();

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api调用次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 11:51
     */
    @RequestMapping(value = "/user/center/use")
    String getConsumerApiUseNumByWeek();

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api申请次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 13:43
     */
    @RequestMapping(value = "/user/center/apply")
    String getConsumerApiApplyNumByWeek();

    /**
     *
     * 功能描述: 生产者-个人中心业务统计
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 14:24
     */
    @RequestMapping(value = "/user/business")
    String getProviderCenterBusinessStatistics();

    /**
     *
     * 功能描述: 生产者按维度日、周、月获取api被访问次数总数
     *
     * @param: 
     * @param dateType
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:42
     */
    @RequestMapping(value = "/count/api/access")
    String getProviderApiAccessCountByDate(@RequestParam("dateType") String dateType);

    /**
     *
     * 功能描述: 生产者按维度日、周、月获取api被访问次数折线图
     *
     * @param:
     * @param dateType
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:43
     */
    @RequestMapping(value = "/charts/api/access")
    String getProviderApiAccessEchartsByDate(@RequestParam("dateType") String dateType);

    /**
     *
     * 功能描述: 生产者获取当日访问记录
     *
     * @param:
     * @param orderInfo
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 13:39
     */
    @RequestMapping(value = "/day/api/access")
    String getProviderDayAccessData(@RequestBody OrderInfo orderInfo);

    /**
     *
     * 功能描述: 生产者获取历史访问记录
     *
     * @param:
     * @param orderInfo
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 13:39
     */
    @RequestMapping(value = "/history/api/access")
    String getProviderHistoryAccessData(@RequestBody OrderInfo orderInfo);

    /**
     *
     * 功能描述: 欢迎页统计五大基础库的目数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:21
     */
    @RequestMapping(value = "/foundation/catlog")
    String getFoundationalLibraryCatalog();

    /**
     *
     * 功能描述: 欢迎页统计三大类的项数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:22
     */
    @RequestMapping(value = "/three/foundation/catlog")
    String getThreeLibraryCatalog();

    /**
     *
     * 功能描述: 数据管理调用次数和个数统计
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 13:40
     */
    @RequestMapping(value = "/count/data/manager")
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
    @RequestMapping(value = "/count/portal/user")
    String countUserByPortal();
}
