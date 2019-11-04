package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.AnalysisClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 数据 分析模块
 * @Author: zzh
 * @Date: 2018/9/28 16:11
 */
@RestController
public class AnalysisControllerFeign {

    private Logger LOG= LoggerFactory.getLogger(AnalysisControllerFeign.class);


    /**
     * 注入 client
     */
    @Autowired
    AnalysisClientService analysisClientService;;
    /**
     * 統計查詢 通用方法
     * @param method 方法的名称
     * @param params 参数
     * @return
     */
    @Access(login = true,privilege = false)
    @RequestMapping(value = "/anaData")
    public String selectOrderInfo(@RequestParam("method") String method, @RequestParam Map<String,Object> params) {
        LOG.debug(TextUtils.format("/***数据 分析模块，統計查詢 通用方法{0}**/", method));

        return analysisClientService.selectAnaDataListMap(method,params);
    }

    /**
     *
     * 功能描述: 查询首页健康度评分
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/6 16:37
     */
    @Access(login = true)
    @RequestMapping(value = "/score")
    public String selectApiScore(){
        LOG.debug(TextUtils.format("首页查询API健康评分"));
        return analysisClientService.selectApiScore();
    }

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api调用次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 11:52
     */
    @Access(login = true)
    @RequestMapping(value = "/user/use")
    public String getConsumerApiUseNumByWeek(){
        LOG.debug(TextUtils.format("个人中心查询API调用次数"));
        return analysisClientService.getConsumerApiUseNumByWeek();
    }

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api申请次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 13:43
     */
    @Access(login = true)
    @RequestMapping(value = "/user/apply")
    public String getConsumerApiApplyNumByWeek(){
        LOG.debug(TextUtils.format("个人中心查询API申请次数"));
        return analysisClientService.getConsumerApiApplyNumByWeek();
    }


    /**
     *
     * 功能描述: 生产者-个人中心业务统计
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 14:22
     */
    @Access(login = true)
    @RequestMapping(value = "/user/business")
    public String getProviderCenterBusinessStatistics(){
        LOG.debug(TextUtils.format("生产者个人中心业务统计"));
        return analysisClientService.getProviderCenterBusinessStatistics();
    }

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
    @Access(login = true)
    @RequestMapping(value = "/count/api/access")
    public String getProviderApiAccessCountByDate(@RequestParam("dateType") String dateType){
        return analysisClientService.getProviderApiAccessCountByDate(dateType);
    }

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
    @Access(login = true)
    @RequestMapping(value = "/charts/api/access")
    public String getProviderApiAccessEchartsByDate(@RequestParam("dateType") String dateType){
        return analysisClientService.getProviderApiAccessEchartsByDate(dateType);
    }

    /**
     *
     * 功能描述: 生产者获取当日访问记录
     *
     * @param: 
     * @param orderInfo
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 13:38
     */
    @RequestMapping(value = "/day/api/access")
    public String getProviderDayAccessData(OrderInfo orderInfo){
        return analysisClientService.getProviderDayAccessData(orderInfo);
    }

    /**
     *
     * 功能描述: 生产者获取历史访问记录
     *
     * @param:
     * @param orderInfo
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 13:38
     */
    @RequestMapping(value = "/history/api/access")
    public String getProviderHistoryAccessData(OrderInfo orderInfo){
        return analysisClientService.getProviderHistoryAccessData(orderInfo);
    }

    /**
     *
     * 功能描述: 欢迎页统计五大基础库的目数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:29
     */
    @RequestMapping(value = "/foundation/catlog")
    @Access(login = false)
    public String getFoundationalLibraryCatalog(){
        return analysisClientService.getFoundationalLibraryCatalog();
    }

    /**
     *
     * 功能描述: 欢迎页统计三大类的项数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:29
     */
    @RequestMapping(value = "/three/foundation/catlog")
    @Access(login = false)
    public String getThreeLibraryCatalog(){
        return analysisClientService.getThreeLibraryCatalog();
    }

    /**
     *
     * 功能描述: 数据管理调用次数和个数统计
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 13:41
     */
    @RequestMapping(value = "/count/data/manager")
    @Access(login = false)
    public String countApiAndApp(){
        return analysisClientService.countApiAndApp();
    }

    /**
     *
     * 功能描述: 欢迎页首页用户统计
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/12 9:48
     */
    @RequestMapping(value = "/count/portal/user")
    @Access(login = false)
    public String countUserByPortal(){
        return analysisClientService.countUserByPortal();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
    }

}
