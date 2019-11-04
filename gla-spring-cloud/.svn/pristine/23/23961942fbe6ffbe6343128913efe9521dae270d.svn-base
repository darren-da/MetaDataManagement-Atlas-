package com.gla.datacenter.service;

import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.service.fallback.AnalysisTimerClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient( value = "DATACENTER-GATEWAY",path = "/api2",fallbackFactory=AnalysisTimerClientServiceFallbackFactory.class)
//@RequestMapping("/api2")
public interface AnalysisTimerClientService {
    /**
     * 功能描述: 根据用户id获取该用户的数据
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:36
     */
    @RequestMapping(value = "/getData/{id}")
    public String getData(@PathVariable("id") String userid);

    /**
     * 功能描述: 根据用户id获取该用户的各项指标排名
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:37
     */
    @RequestMapping(value = "/getRank/{id}")
    public String getRank(@PathVariable("id") String userid);

    /**
     * 功能描述: 根据用户ID获取该用户每个月API的被访问个数
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:37
     */
    @RequestMapping(value = "/getApiCountsEachMonth/{id}")
    public String getApiCountsEachMonth(@PathVariable("id") String userid);

    /**
     * 功能描述: 管理者查看数据概况
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/18 15:44
     */
    @RequestMapping(value = "/dataSurvey")
    public String dataSurvey();


    /**
     * 功能描述: 管理者查看排名榜
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/19 17:22
     */
    @RequestMapping(value = "/rankingList")
    public String rankingList();

    /**
     * 功能描述: 管理者查看行为审计日志动态
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/20 15:40
     */
    @RequestMapping(value = "/logOfBehavior")
    public String logOfBehavior(@RequestParam("managerAccount") String managerAccount);

    /**
     * 功能描述: 管理者查看系统负载
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/21 16:53
     */
    @RequestMapping(value = "/systemRate")
    public String systemRate() ;

    /**
     * 功能描述: 管理者上次登陆IP和时间
     * @param:
     * @param account
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @auther: zhengshien
     * @date: 2018/12/25 11:16
     */
    @RequestMapping(value = "/loginLog")
    public String loginLog(@RequestParam("account") String account);

    /**
     * 功能描述: 管理者监控中心查看企业用户实时数据
     * @param:
     * @param currIndex 分页起始页
     * @param pageSize 分页PageSize
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/26 16:00
     */
    @RequestMapping(value = "/monitorOfProvider")
    public String monitorOfProvider(@RequestParam("currIndex") Integer currIndex,@RequestParam("pageSize") Integer pageSize);

    /**
     * 功能描述: 监控中心查看用户日活跃数量或月活跃数量
     * @param:
     * @param managerAccount 管理者账号（不参与查询）
     * @param button 按钮（DAU或MAU，根据希望查看的结果选择）
     * @param month 月份（格式：YYYY-MM-dd）
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/28 15:43
     */
    @RequestMapping(value = "/DAUAndMAU")
    public String DAUAndMAU(@RequestParam("managerAccount") String managerAccount,
                            @RequestParam("button") String button,
                            @RequestParam("month") String month);

    /**
     * 功能描述: 调用次数和流量监控，按月统计
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/28 16:21
     */
    @RequestMapping(value = "/invokingsAndFlows")
    public String invokingsAndFlows();

    /**
     * 功能描述: 管理者查看行为审计日志动态
     * @param:
     * @param managerAccount 管理者账号
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/3 11:10
     */
    @RequestMapping(value = "/logDynamics")
    public String logDynamics(@RequestParam("managerAccount") String managerAccount);

    /**
     * 功能描述: 系统安全行为和API操作行为按条件分页查询
     * @param:
     * @param pageLog 实体参数（条件）
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/4 14:40
     */
    @RequestMapping(value = "/systemSecurityBehavior")
    public String systemSecurityBehavior(@RequestBody PageLog pageLog);

    /**
     * 功能描述: 生产者监控中心查看API状态
     * @param:
     * @param userid 生产者ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 11:08
     */
    @RequestMapping(value = "/apiStatus")
    public String apiStatus(@RequestParam("userid")  String userid);

    /**
     * 功能描述: 生产者监控中心查看API调用情况
     * @param:
     * @param userid 生产者ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 14:09
     */
    @RequestMapping(value = "/apiInvoking")
    public String apiInvokings(@RequestParam("userid")  String userid);

    /**
     * 功能描述: 生产者查询API流量情况
     * @param:
     * @param userid 生产者ID
     * @param beginTime 当天0点时间 （YYYY-MM-dd 00:00:00）
     * @param endTime 当前时间 （YYYY-MM-dd HH:mm:ss）
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 16:00
     */
    @RequestMapping(value = "/apiFlow")
    public String apiFlow(@RequestParam("userid")  String userid,
                          @RequestParam("beginTime")  String beginTime,
                          @RequestParam("endTime")  String endTime);

    /**
     * 功能描述: 响应时间
     * @param:
     * @param userid 生产者ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/9 14:52
     */
    @RequestMapping(value = "/responseTime")
    public String responseTime(@RequestParam("userid")  String userid);

    /**
     * 功能描述: 生产者查看一周内API被调用次数和流量统计
     * @param:
     * @param userid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/10 9:44
     */
    @RequestMapping(value = "/invokingAndFlowByWeek")
    public String invokingAndFlowByWeek(@RequestParam("userid")  String userid);

    /**
     * 功能描述: 生产者个人中心查看API调用质量总排名（昨日）
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/11 14:39
     */
    @RequestMapping(value = "/apiQualityRanking")
    public String apiQualityRanking();
}
