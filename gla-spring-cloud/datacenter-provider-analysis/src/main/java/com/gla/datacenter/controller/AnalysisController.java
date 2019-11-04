package com.gla.datacenter.controller;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.AnalysisService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnalysisController {

    private Logger log= LoggerFactory.getLogger(AnalysisController.class);

    @Autowired
    AnalysisService analysisService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 統計查詢 通用方法
     * @param method 方法的名称
     * @param params 参数
     * @return
     */
    @RequestMapping(value = "/anaDatas")
    public String selectAnaDataListMap(@RequestParam("method") String method, @RequestParam Map<String,Object> params) {
        log.debug(TextUtils.format("/***数据 分析模块，統計查詢 通用方法{0}**/", method));
        List<Map<String,Object>> listMap= analysisService.selectListMapByMethod(method,params);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,listMap,"").getJson();
    }
    @RequestMapping(value = "/anaData")
    public String selectAnaDataListMap1(@RequestParam("method") String method, @RequestParam Map<String,Object> params) {
        log.debug(TextUtils.format("/***数据 分析模块，統計查詢 通用方法{0}**/", method));
        //方法判断，身份判断暂时先不写
        List<Map<String,Object>> listMaps = analysisService.selectListMapByMethod(method,params);
        Map<String, Object> listMap = new HashMap<>();
        if(listMaps.size() == 1){
            listMap = listMaps.get(0);
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,listMap,null).getJson();
    }

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api调用次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 11:07
     */
    @RequestMapping(value = "/user/center/use")
    public String getConsumerApiUseNumByWeek(){
        return analysisService.getConsumerApiUseNumByWeek();
    }

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api申请次数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 13:44
     */
    @RequestMapping(value = "/user/center/apply")
    public String getConsumerApiApplyNumByWeek(){
        return analysisService.getConsumerApiApplyNumByWeek();
    }

    /**
     *
     * 功能描述: 生产者-个人中心业务统计
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/21 14:25
     */
    @RequestMapping(value = "/user/business")
    public String getProviderCenterBusinessStatistics(){
        return analysisService.getProviderCenterBusinessStatistics();
    }

    /**
     *
     * 功能描述: 查询首页健康度评分
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:44
     */
    @RequestMapping(value = "/score")
    public String selectApiScore(){
        return analysisService.selectApiScore();
    }

    /**
     *
     * 功能描述: 生产者按维度日、周、月获取api被访问次数总数
     *
     * @param:
     * @param dateType
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:45
     */
    @RequestMapping(value = "/count/api/access")
    public String getProviderApiAccessCountByDate(@RequestParam("dateType") String dateType){
        return analysisService.getProviderApiAccessCountByDate(dateType);
    }

    /**
     *
     * 功能描述: 生产者按维度日、周、月获取api被访问次数折线图
     *
     * @param:
     * @param dateType
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/3 10:45
     */
    @RequestMapping(value = "/charts/api/access")
    public String getProviderApiAccessEchartsByDate(@RequestParam("dateType") String dateType){
        return analysisService.getProviderApiAccessEchartsByDate(dateType);
    }

    /**
     *
     * 功能描述: 生产者获取当日访问记录
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 11:36
     */
    @RequestMapping(value = "/day/api/access")
    public String getProviderDayAccessData(@RequestBody OrderInfo orderInfo){
        return analysisService.getProviderDayAccessData(orderInfo,orderInfo.getPager());
    }

    /**
     *
     * 功能描述: 生产者获取历史访问记录
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/4 11:36
     */
    @RequestMapping(value = "/history/api/access")
    public String getProviderHistoryAccessData(@RequestBody OrderInfo orderInfo){
        return analysisService.getProviderHistoryAccessData(orderInfo,orderInfo.getPager());
    }

    /**
     *
     * 功能描述: 欢迎页统计五大基础库的目数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 10:07
     */
    @RequestMapping(value = "/foundation/catlog")
    public String getFoundationalLibraryCatalog(){
        return analysisService.getFoundationalLibraryCatalog();
    }

    /**
     *
     * 功能描述: 欢迎页统计三大类的项数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:17
     */
    @RequestMapping(value = "/three/foundation/catlog")
    public String getThreeLibraryCatalog(){
        return analysisService.getThreeLibraryCatalog();
    }

    /**
     *
     * 功能描述: 数据管理调用次数和个数统计
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 13:42
     */
    @RequestMapping(value = "/count/data/manager")
    public String countApiAndApp(){
        return analysisService.countApiAndApp();
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
    public String countUserByPortal(){
        return analysisService.countUserByPortal();
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
