package com.gla.datacenter.controller;

import com.gla.datacenter.domain.AnalysisData;
import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.service.AnalysisService;
import com.gla.datacenter.service.AnalysisTimerService;
import com.gla.datacenter.service.PlugCacheClientService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhengshien
 * @Date: 2018/12/6 10:32
 * @Description:
 */
@RestController

public class AnalysisTimerController {

    private Logger log = LoggerFactory.getLogger(AnalysisTimerController.class);

    /**
     * 定时任务表达式(每天凌晨一点)
     */
    private static final String Timing_Task = " 0 0 1 * * ? ";
    /**
     * 存入Redis的key值
     */
    private static final String TIMING_TODAY = "TIMING_TODAY";
    private static final String EXPIRE_TIME = "3600000";
    private static final String Timing_Task_Test = " 0 */1 * * * ? ";

    /**
     * 引入调用Service
     */
    @Autowired
    private AnalysisTimerService analysisTimerService;

    @Autowired
    AnalysisService analysisService;

    @Autowired
    private PlugCacheClientService plugCacheClientService;

    /**
     * 功能描述: 定时维护AnalysisData表
     * @param:
     * @return: void
     * @auther: zhengshien
     * @date: 2018/12/12 10:01
     */
    @RequestMapping("/aaa")
    @Scheduled(cron= Timing_Task)
    public void apiCounts(){
        //获取锁并加给key赋值，如果当天已经执行过定时任务，则不再执行
        String lock = plugCacheClientService.getLock(TIMING_TODAY, StrUtils.randomUUID(), EXPIRE_TIME);
        if ("true".equals(lock)) {
            analysisTimerService.updateAnalysisData();
        }
    }

    /**
     * 定时任务跑数据：api异常数量超过一半的则通知生产者
     */
    @RequestMapping("/notesAPI")
    @Scheduled(cron= "0 59 23 * * ?")
    public void notesAPI(){
        log.debug("");
        //获取锁并加给key赋值，如果当天已经执行过定时任务，则不再执行
        String lock =plugCacheClientService.getLock("RUN_TODAY_API_STATUS", StrUtils.randomUUID(), EXPIRE_TIME);
        if ("true".equals(lock)) {
            //获取用户
           analysisTimerService.noteUserApiStatus();
        }
    }

    /**
     * 功能描述: 根据用户id获取该用户的数据
     * @param:
     * @param userid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:36
     */
    @RequestMapping(value = "/getData/{id}")
    public String getData(@PathVariable("id") String userid) {
        log.debug(TextUtils.format("/***根据用户id{0}，获取该用户的数据**/", userid));
        AnalysisData data = analysisTimerService.getData(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, data, "").getJson();
    }

//    @Scheduled(cron= Timing_Task_Test)
//    @RequestMapping(value = "/bbb",method = RequestMethod.GET)
    public void testTime() throws ParseException {
//        Date date=new Date();
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH");
//        String format = sdf.format(date);
//        Date parse = sdf.parse(format);
//        System.out.println("格式化后的："+parse);
//        System.out.println("精确到日："+format);

            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);//获取年份
            int month=cal.get(Calendar.MONTH)+1;//获取月份
            int day=cal.get(Calendar.DATE);//获取日
            int hour=cal.get(Calendar.HOUR_OF_DAY);//小时
            int minute=cal.get(Calendar.MINUTE);//分
            int second=cal.get(Calendar.SECOND);//秒
            int WeekOfYear = cal.get(Calendar.DAY_OF_WEEK)-1;//一周的第几天
            System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日      "+hour+"时"+minute+"分"+second+"秒       星期"+WeekOfYear);
    }

    /**
     * 功能描述: 根据用户id获取该用户的各项指标排名
     * @param:
     * @param userid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:37
     */
    @RequestMapping(value = "/getRank/{id}")
    public String getRank(@PathVariable("id") String userid) {
        log.debug(TextUtils.format("/***根据用户id{0}，获取该用户的各项指标排名**/", userid));
        Map rank = analysisTimerService.getRank(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, rank, "").getJson();
    }

    /**
     * 功能描述: 根据用户ID获取该用户每个月API的被i 访问个数
     *
     * @param userid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 15:37
     */
    @RequestMapping(value = "/getApiCountsEachMonth/{id}")
    public String getApiCountsEachMonth(@PathVariable("id") String userid) {
        log.debug(TextUtils.format("/***根据用户id{0}，获取该用户每个月API的被访问个数**/", userid));
        List apiCountsEachMonth = analysisTimerService.getApiCountsEachMonth(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, apiCountsEachMonth, "").getJson();
    }

    /**
     * 功能描述: 管理者查看数据概况
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/18 15:44
     */
    @RequestMapping(value = "/dataSurvey")
    public String dataSurvey() {
        log.debug(TextUtils.format("/***管理者查看数据概况**/"));
        Map dataSurvey = analysisTimerService.dataSurvey();
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, dataSurvey, "").getJson();
    }

    /**
     * 功能描述: 管理者查看排名榜
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/19 17:22
     */
    @RequestMapping(value = "/rankingList")
    public String rankingList() {
        log.debug(TextUtils.format("/***管理者查看排名榜**/"));
        Map<String, String> map = analysisTimerService.rankingList();
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, map, "").getJson();
    }

    /**
     * 功能描述: 管理者查看行为审计日志动态
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/20 15:40
     */
    @RequestMapping(value = "/logOfBehavior")
    public String logOfBehavior(@RequestParam("managerAccount") String managerAccount) {
        log.debug(TextUtils.format("/***管理者查看行为审计日志动态**/"));
        List list = analysisTimerService.logOfBehavior(managerAccount);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

    /**
     * 功能描述: 管理者查看系统负载
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/21 16:53
     */
    @RequestMapping(value = "/systemRate")
    public String systemRate() {
//        log.debug(TextUtils.format("/***管理者查看系统负载**/"));
        Map<String,Float> rateMap = analysisTimerService.systemRate();
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, rateMap, "").getJson();
    }

    /**
     * 功能描述: 管理者查看上次登陆IP和时间
     * @param:
     * @param account
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @auther: zhengshien
     * @date: 2018/12/25 11:16
     */
    @RequestMapping(value = "/loginLog")
    public String loginLog(String account) {
        log.debug(TextUtils.format("/***管理者查看上次登陆IP和时间**/"));
        Map<String,String> loginLog = analysisTimerService.loginLog(account);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, loginLog, "").getJson();
    }

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
    public String monitorOfProvider(@RequestParam("currIndex") Integer currIndex,@RequestParam("pageSize") Integer pageSize) {
        log.debug(TextUtils.format("/***管理者监控中心查看企业用户实时数据**/"));
        Pager<List<Map<String,Object>>> list = analysisTimerService.monitorOfProvider(currIndex, pageSize);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

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
                            @RequestParam("month") String month) {
        log.debug(TextUtils.format("/***日活跃数量和月活跃数量**/"));
        List<Map<String, String>> list = analysisTimerService.DAUAndMAU(managerAccount,button,month);
        if (StrUtils.isBlank(list)){
            return Result.getInstance(ResultCode.ERROR.toString(),"请检查参数传递是否正确", list, "").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

    /**
     * 功能描述: 调用次数和流量监控，按月统计
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/28 16:21
     */
    @RequestMapping(value = "/invokingsAndFlows")
    public String invokingsAndFlows() {
        log.debug(TextUtils.format("/***调用次数和流量监控，按月统计**/"));
        List<Map<String, String>> list = analysisTimerService.invokingsAndFlows();
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

    /**
     * 功能描述: 管理者查看行为审计日志动态
     * @param:
     * @param managerAccount 管理者账号
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/3 11:10
     */
    @RequestMapping(value = "/logDynamics")
    public String logDynamics(@RequestParam("managerAccount") String managerAccount) {
        log.debug(TextUtils.format("/***行为审计日志动态**/"));
        List<Map<String, String>> list = analysisTimerService.logDynamics(managerAccount);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

    /**
     * 功能描述: 系统安全行为和API操作行为按条件分页查询
     * @param:
     * @param pageLog 实体参数（条件）
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/4 14:40
     */
    @RequestMapping(value = "/systemSecurityBehavior")
    public String systemSecurityBehavior(@RequestBody PageLog pageLog) {
        log.debug(TextUtils.format("/***系统安全行为和API操作行为按条件分页查询**/"));
        Pager<PageLog> pageLogPager = analysisTimerService.systemSecurityBehavior(pageLog,pageLog.getPager());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pageLogPager, "").getJson();
    }

    /**
     * 功能描述: 生产者监控中心查看API状态
     * @param:
     * @param userid 生产者ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 11:08
     */
    @RequestMapping(value = "/apiStatus")
    public String apiStatus(@RequestParam("userid")  String userid) {
        log.debug(TextUtils.format("/***生产者{0}监控中心查看API状态**/"),userid);
        List<Map<String, String>> list = analysisTimerService.apiStatus(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

    /**
     * 功能描述: 生产者监控中心查看API调用情况
     * @param:
     * @param userid 生产者ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/8 14:09
     */
    @RequestMapping(value = "/apiInvoking")
    public String apiInvokings(@RequestParam("userid")  String userid) {
        log.debug(TextUtils.format("/***生产者{0}监控中心查看API调用情况**/"),userid);
        List<Map<String, String>> list = analysisTimerService.apiInvokings(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

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
                          @RequestParam("endTime")  String endTime) {
        log.debug(TextUtils.format("/***生产者{0}查询API流量情况**/"),userid);
        Map<String, Object> map = analysisTimerService.apiFlow(userid,beginTime,endTime);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, map, "").getJson();
    }

    /**
     * 功能描述: 响应时间
     * @param:
     * @param userid 生产者ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/9 14:52
     */
    @RequestMapping(value = "/responseTime")
    public String responseTime(@RequestParam("userid")  String userid) {
        log.debug(TextUtils.format("/***生产者{0}查看响应时间**/"),userid);
        int time = analysisTimerService.responseTime(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, time, "").getJson();
    }

    /**
     * 功能描述: 生产者查看一周内API被调用次数和流量统计
     * @param:
     * @param userid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/10 9:44
     */
    @RequestMapping(value = "/invokingAndFlowByWeek")
    public String invokingAndFlowByWeek(@RequestParam("userid")  String userid) {
        log.debug(TextUtils.format("/***生产者{0}查看一周内API被调用次数和流量统计**/"),userid);
        List<Map<String, String>> list = analysisTimerService.invokingAndFlowByWeek(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }

    /**
     * 功能描述: 生产者个人中心查看API调用质量总排名（昨日）
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/1/11 14:39
     */
    @RequestMapping(value = "/apiQualityRanking")
    public String apiQualityRanking() {
        log.debug(TextUtils.format("/***生产者个人中心查看API调用质量总排名**/"));
        List<Map<String, String>> list = analysisTimerService.apiQualityRanking();
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, "").getJson();
    }
}