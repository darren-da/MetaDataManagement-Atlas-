package com.gla.datacenter.service;

import com.gla.datacenter.domain.AnalysisData;
import com.gla.datacenter.domain.PageLog;
import com.limp.framework.core.bean.Pager;

import java.util.List;
import java.util.Map;

public interface AnalysisTimerService {
    /**
     * 功能描述: 定时维护AnalysisData表
     *
     * @param:
     * @return: void
     * @auther: zhengshien
     * @date: 2018/12/12 10:01
     */
    void updateAnalysisData();

    /**
     * 通知用户API是否运行正常
     */
    void noteUserApiStatus();

    /**
     * 功能描述: 根据用户id获取该用户的数据
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:36
     */
    AnalysisData getData(String userid);

    /**
     * 功能描述: 根据用户id获取该用户的各项指标排名
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:37
     */
    Map<String, Integer> getRank(String userid);

    /**
     * 功能描述: 根据用户ID获取该用户每个月API的被访问个数
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:37
     */
    List getApiCountsEachMonth(String userid);

    Map<String,Integer> dataSurvey();

    Map<String,String> rankingList();

    List logOfBehavior(String managerAccount);

//    float CPUUtilizationRate();

//    Map<String, Float> concurrencyRate();

    Map<String, Float> systemRate();

    Map<String,String> loginLog(String account);

    Pager<List<Map<String,Object>>> monitorOfProvider(Integer currIndex, Integer pageSize);

    List<Map<String,String>> DAUAndMAU(String managerAccount, String button,String month);

    List<Map<String,String>> invokingsAndFlows();

    List<Map<String,String>> logDynamics(String managerAccount);

    Pager<PageLog> systemSecurityBehavior(PageLog pageLog,Pager pager);

    List<Map<String,String>> apiStatus(String userid);

    List<Map<String,String>> apiInvokings(String userid);

    Map<String,Object> apiFlow(String userid, String beginTime, String endTime);

    int responseTime(String userid);

    List<Map<String,String>> invokingAndFlowByWeek(String userid);

    List<Map<String,String>> apiQualityRanking();

}
