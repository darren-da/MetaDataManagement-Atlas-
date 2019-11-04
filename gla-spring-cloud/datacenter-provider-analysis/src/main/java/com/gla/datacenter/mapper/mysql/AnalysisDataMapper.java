package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.AnalysisData;
import com.gla.datacenter.domain.AnalysisDataExample;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gla.datacenter.domain.OrderInfo;
import com.limp.framework.core.bean.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

@Mapper
public interface AnalysisDataMapper {
    int countByExample(AnalysisDataExample example);

    int deleteByExample(AnalysisDataExample example);

    int insert(AnalysisData record);

    int insertSelective(AnalysisData record);

    List<AnalysisData> selectByExample(AnalysisDataExample example);

    int updateByExampleSelective(@Param("record") AnalysisData record, @Param("example") AnalysisDataExample example);

    int updateByExample(@Param("record") AnalysisData record, @Param("example") AnalysisDataExample example);

    int countByUserId(@Param("userid") String userid);

    List<Map<String,String>> getUserRoleIDS(@Param("userid") String userid);

    String getIdByKeyword(@Param("keyword") String keyword);

    List getApiList(@Param("userid") String userid);

    int getApiInvokings(@Param("apiid") String apiid,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    int getFailTimes(@Param("apiid") String apiid,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    int getApiAbnormals(@Param("userid") String userid,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    int getWaitTimes(@Param("apiid") String apiid,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    int getFlows(@Param("apiid") String apiid,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    List<AnalysisData> getData(@Param("userid") String userid);

    int getApiCountsRank(@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("userid") String userid);

    int getApiInvokingsRank(@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("userid") String userid,@Param("i") String i);

    int getApiQualityRank(@Param("beginTime") String beginTime,@Param("endTime") String endTime,@Param("userid") String userid);

    List<Map<String,String>> getApiCountsEachMonth(@Param("userid") String userid);

    int getFlowsSum(@Param("userid") String userid);

    int getDeals(@Param("userid") String userid);

    Integer getNumberOfUsersRank(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("userid") String userid);

    int getNumberOfUsers(@Param("userid") String userid);

    int getAllUsers(@Param("keyword") String keyword);

    int getApiInvokingsSum(@Param("userid") String userid);

    int getProviders(@Param("keywordProvider") String keywordProvider);

    int getConsumers(@Param("keywordConsumer") String keywordConsumer);

    int getTotalNumberOfApis();

    int getTotalNumberOfApplications();

    Integer getTotalFlow();

    int getApproves();

    int getRejects();

    Integer getNumberOfNormalApis();

    int getAbnumberOfNormalApis();

    int getNumberOfExpiredApis();

    List<Map<String,String>> rankOfConsumer();

    List<Map<String,String>> rankOfProvider();

    List<Map<String,String>> rankOfApiCounts();

    List<Map<String,String>> logOfBehavior(@Param("managerAccount") String managerAccount);

    int concurrencyRate(@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    /**
     *
     * 功能描述: 生产-个人中心业务统计
     *
     * @param:
     * @param userId
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/12/21 15:57
     */
    List<Map<String,Integer>> getProviderCenterBusinessStatistics(@Param("userId") String userId);

    List<Map<String,String>> loginLog(@Param("account") String account);

    List<Map<String,String>> monitorOfProvider(@Param("mapParam") Map<String,Object> mapParam,@Param("page") Pager page);

    List<Map<String,String>> getDAU(@Param("managerAccount") String managerAccount,@Param("month") String month);

    List<Map<String,String>> getMAU(@Param("managerAccount") String managerAccount);

    List<Map<String,String>> getInvokingsAndFlows();

    List<Map<String,String>> logDynamics(@Param("managerAccount") String managerAccount);

//    List<Map<String,String>> systemSecurityBehavior(@Param("mapParam") Map<String,Object> mapParam);

//    List<Map<String,String>> systemSecurityBehavior(@Param("mapParam") Map<String,Object> mapParam);

    Map<String,Integer> getProviderApiAccessCountByDate(Map<String, Object> paramMap);

    List<Map<String,Integer>> getProviderApiAccessEchartsByDate(Map<String, Object> paramMap);

    List<OrderInfo> getProviderDayAccessData(Map<String, Object> paramMap);

    int getProviderHistoryAccessCount(Map<String, Object> paramMap);

    List<OrderInfo> getProviderHistoryAccessData(Map<String, Object> paramMap);

    List<Map<String,String>> getApiStatus(String userid);

    List<Map<String,String>> getApiInvoking(@Param("userid") String userid);

    int getTodayFlowsByUserid(@Param("userid") String userid,@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    int getTotalFlowsByUserid(String userid);

    int getResponseTime(String userid);

    List<Map<String,String>> getInvokingAndFlowByWeek(String userid);

    List<Map<String,String>> getApiQualityRanking(@Param("beginTime") String beginTime,@Param("endTime") String endTime);

    Map<String,Object> getApiAndAppCountAndCalls();
}