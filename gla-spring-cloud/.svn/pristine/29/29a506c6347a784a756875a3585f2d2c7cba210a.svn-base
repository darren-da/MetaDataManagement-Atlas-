package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.service.AnalysisTimerClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.utils.TextUtils;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhengshien
 * @Date: 2018/12/12 18:11
 * @Description:
 */
@RestController
public class AnalysisTimerControllerFegin {
    private Logger LOG = LoggerFactory.getLogger(AnalysisTimerControllerFegin.class);

    /**
     * 引入调用的服务
     */
    @Autowired
    private AnalysisTimerClientService analysisTimerClientService;

    /**
     * 功能描述: 根据用户id，获取该用户的分析数据
     *
     * @param userid 用户ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/12 19:09
     */
    @RequestMapping(value = "/getData/{id}", method = RequestMethod.GET)
    @Access(login = true)
    public String getData(@PathVariable("id") String userid) {
        LOG.debug(TextUtils.format("/***根据用户id{0}，获取该用户的分析数据**/", userid));
        return analysisTimerClientService.getData(userid);
    }

    /**
     * 功能描述: 根据用户id，获取该用户的各项指标排名
     *
     * @param userid 用户ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/12 19:10
     */
    @RequestMapping(value = "/getRank/{id}", method = RequestMethod.GET)
    @Access(login = true)
    public String getRank(@PathVariable("id") String userid) {
        LOG.debug(TextUtils.format("/***根据用户id{0}，获取该用户的各项指标排名**/", userid));
        return analysisTimerClientService.getRank(userid);
    }

    /**
     * 功能描述: 根据用户id，获取该用户每个月API的被访问个数
     *
     * @param userid 用户ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/12 19:10
     */
    @RequestMapping(value = "/getApiCountsEachMonth/{id}", method = RequestMethod.GET)
    @Access(login = true)
    public String getApiCountsEachMonth(@PathVariable("id") String userid) {
        LOG.debug(TextUtils.format("/***根据用户id{0}，获取该用户每个月API的被访问个数**/", userid));
        return analysisTimerClientService.getApiCountsEachMonth(userid);
    }

    /**
     * 功能描述: 管理者查看数据概况
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/18 15:44
     */
    @RequestMapping(value = "/dataSurvey", method = RequestMethod.GET)
    @Access(login = true)
    public String dataSurvey() {
        LOG.debug(TextUtils.format("/***管理者查看数据概况**/"));
        return analysisTimerClientService.dataSurvey();
    }

    /**
     * 功能描述: 管理者查看排名榜
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/19 17:22
     */
    @RequestMapping(value = "/rankingList", method = RequestMethod.GET)
    @Access(login = true)
    public String rankingList() {
        LOG.debug(TextUtils.format("/***管理者查看排名榜**/"));
        return analysisTimerClientService.rankingList();
    }

    /**
     * 功能描述: 管理者查看行为审计日志动态
     *
     * @param managerAccount 管理者ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/27 15:19
     */
    @RequestMapping(value = "/logOfBehavior", method = RequestMethod.GET)
    @Access(login = true)
    public String logOfBehavior(@RequestParam("managerAccount") String managerAccount) {
        LOG.debug(TextUtils.format("/***管理者查看行为审计日志动态**/"));
        return analysisTimerClientService.logOfBehavior(managerAccount);
    }

    /**
     * 功能描述: 管理者查看系统负载
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/21 16:53
     */
    @RequestMapping(value = "/systemRate", method = RequestMethod.GET)
    @Access(login = true)
    public String concurrencyRate() {
//        LOG.debug(TextUtils.format("/***管理者查看系统负载**/"));
        return analysisTimerClientService.systemRate();
    }

    /**
     * 功能描述: 管理者查看上次登陆IP和时间
     *
     * @param account
     * @param:
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @auther: zhengshien
     * @date: 2018/12/25 11:16
     */
    @RequestMapping(value = "/loginLog", method = RequestMethod.GET)
    @Access(login = true)
    public String loginLog(@RequestParam("account") String account) {
        LOG.debug(TextUtils.format("/***管理者查看上次登陆IP和时间**/"));
        return analysisTimerClientService.loginLog(account);
    }

    /**
     * 功能描述: 管理者监控中心查看企业用户实时数据
     *
     * @param currIndex 分页起始页
     * @param pageSize  分页PageSize
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/26 16:00
     */
    @RequestMapping(value = "/monitorOfProvider", method = RequestMethod.GET)
    @Access(login = true)
    public String monitorOfProvider(@RequestParam("currIndex") Integer currIndex, @RequestParam("pageSize") Integer pageSize) {
        LOG.debug(TextUtils.format("/***管理者监控中心查看企业用户实时数据**/"));
        return analysisTimerClientService.monitorOfProvider(currIndex, pageSize);
    }

    /**
     * 功能描述: 监控中心查看用户日活跃数量或月活跃数量
     *
     * @param managerAccount 管理者账号（不参与查询）
     * @param button         按钮（DAU或MAU，根据希望查看的结果选择）
     * @param month          月份（格式：YYYY-MM-dd）
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/28 15:43
     */
    @RequestMapping(value = "/DAUAndMAU", method = RequestMethod.GET)
    @Access(login = true)
    public String DAUAndMAU(@RequestParam("managerAccount") String managerAccount,
                            @RequestParam("button") String button,
                            @RequestParam("month") String month) {
        LOG.debug(TextUtils.format("/***日活跃数量和月活跃数量**/"));
        return analysisTimerClientService.DAUAndMAU(managerAccount, button, month);
    }

    /**
     * 功能描述: 调用次数和流量监控，按月统计
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/28 16:21
     */
    @RequestMapping(value = "/invokingsAndFlows", method = RequestMethod.GET)
    @Access(login = true)
    public String invokingsAndFlows() {
        LOG.debug(TextUtils.format("/***调用次数和流量监控，按月统计**/"));
        return analysisTimerClientService.invokingsAndFlows();
    }

    /**
     * 功能描述: 管理者查看行为审计日志动态
     *
     * @param managerAccount 管理者账号
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/3 11:10
     */
    @RequestMapping(value = "/logDynamics", method = RequestMethod.GET)
    @Access(login = true)
    public String logDynamics(@RequestParam("managerAccount") String managerAccount) {
        LOG.debug(TextUtils.format("/***行为审计日志动态**/"));
        return analysisTimerClientService.logDynamics(managerAccount);
    }

    /**
     * 功能描述: 系统安全行为和API操作行为按条件分页查询
     *
     * @param pageLog 实体参数（条件）
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/4 14:40
     */
    @RequestMapping(value = "/systemSecurityBehavior", method = RequestMethod.POST)
    @Access(login = true)
    public String systemSecurityBehavior(@RequestBody PageLog pageLog) {
        LOG.debug(TextUtils.format("/***系统安全行为和API操作行为按条件分页查询**/"));
        return analysisTimerClientService.systemSecurityBehavior(pageLog);
    }

    /**
     * 功能描述: 生产者监控中心查看API状态
     *
     * @param userid 生产者ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 11:08
     */
    @RequestMapping(value = "/apiStatus", method = RequestMethod.GET)
    @Access(login = true)
    public String apiStatus(@RequestParam("userid") String userid) {
        LOG.debug(TextUtils.format("/***生产者{0}监控中心查看API状态**/"), userid);
        return analysisTimerClientService.apiStatus(userid);
    }

    /**
     * 功能描述: 生产者监控中心查看API调用情况
     *
     * @param userid 生产者ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 14:09
     */
    @RequestMapping(value = "/apiInvoking", method = RequestMethod.GET)
    @Access(login = true)
    public String apiInvokings(@RequestParam("userid") String userid) {
        LOG.debug(TextUtils.format("/***生产者{0}监控中心查看API调用情况**/"), userid);
        return analysisTimerClientService.apiInvokings(userid);
    }

    /**
     * 功能描述: 生产者查询API流量情况
     *
     * @param userid    生产者ID
     * @param beginTime 当天0点时间 （YYYY-MM-dd 00:00:00）
     * @param endTime   当前时间 （YYYY-MM-dd HH:mm:ss）
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 16:00
     */
    @RequestMapping(value = "/apiFlow", method = RequestMethod.GET)
    @Access(login = true)
    public String apiFlow(@RequestParam("userid") String userid,
                          @RequestParam("beginTime") String beginTime,
                          @RequestParam("endTime") String endTime) {
        LOG.debug(TextUtils.format("/***生产者{0}查询API流量情况**/"), userid);
        return analysisTimerClientService.apiFlow(userid, beginTime, endTime);
    }

    /**
     * 功能描述: 响应时间
     *
     * @param userid 生产者ID
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/9 14:52
     */
    @RequestMapping(value = "/responseTime", method = RequestMethod.GET)
    @Access(login = true)
    public String responseTime(@RequestParam("userid") String userid) {
        LOG.debug(TextUtils.format("/***生产者{0}查看响应时间**/"), userid);
        return analysisTimerClientService.responseTime(userid);
    }

    /**
     * 功能描述: 生产者查看一周内API被调用次数和流量统计
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/10 9:44
     */
    @RequestMapping(value = "/invokingAndFlowByWeek", method = RequestMethod.GET)
    @Access(login = true)
    public String invokingAndFlowByWeek(@RequestParam("userid") String userid) {
        LOG.debug(TextUtils.format("/***生产者{0}查看一周内API被调用次数和流量统计**/"), userid);
        return analysisTimerClientService.invokingAndFlowByWeek(userid);
    }

    /**
     * 功能描述: 生产者个人中心查看API调用质量总排名（昨日）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/11 14:39
     */
    @RequestMapping(value = "/apiQualityRanking",method = RequestMethod.GET)
    @Access(login = true)
    public String apiQualityRanking() {
        LOG.debug(TextUtils.format("/***生产者{0}个人中心查看API调用质量总排名**/"));
        return analysisTimerClientService.apiQualityRanking();
    }
}