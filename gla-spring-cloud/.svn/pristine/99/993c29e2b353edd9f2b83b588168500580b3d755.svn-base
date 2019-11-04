package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.*;
import com.gla.datacenter.mapper.mysql.AnalysisDataMapper;
import com.gla.datacenter.mapper.mysql.PageLogMapper;
import com.gla.datacenter.service.AnalysisService;
import com.gla.datacenter.service.AnalysisTimerService;
import com.gla.datacenter.service.MessageClientService;
import com.gla.datacenter.service.UserInfoClientService;
import com.gla.datacenter.utils.LinuxSystemTool;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xidea.el.json.JSONDecoder;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: zhengshien
 * @Date: 2018/12/6 14:14
 * @Description:
 */
@Service
public class AnalysisTimerServiceImpl implements AnalysisTimerService {

    private Logger log = LoggerFactory.getLogger(AnalysisTimerServiceImpl.class);

    /**
     * 功能描述: 调用服务
     *
     * @auther: zhengshien
     * @date: 2018/12/13 14:01
     */
    @Autowired
    private UserInfoClientService userInfoClientService;

    /**
     * 消息模块
     */
    @Autowired
    private MessageClientService messageClientService;

    /**
     * 功能描述: 引入Mapper
     *
     * @auther: zhengshien
     * @date: 2018/12/13 14:01
     */
    @Autowired
    private AnalysisDataMapper analysisDataMapper;
    @Autowired
    private PageLogMapper pageLogMapper;

    @Autowired
    AnalysisService analysisService;

    /**
     * 常量
     */
    private static final String KEYWORD_PROVIDER = "ROLE_DATACENTER_PROVIDER";
    private static final String KEYWORD_CONSUMER = "ROLE_DATACENTER_CONSUMER";
    private static final String DAU = "DAU";
    private static final String MAU = "MAU";

    /**
     * 循环周期
     */
    private static final int CYCLE_PERIOD = 24 * 60 * 60 * 1000;
    private static final int LAST_TIME_CYCLE_PERIOD = 2 * 24 * 60 * 60 * 1000;

    /**
     * 分数计算用到的常数
     */
    private static final int NUMBER_OneHundred = 100;
    private static final int NUMBER_TwoHundred = 200;
    private static final Double NUMBER_ZeroPointFive = 0.50;
    private static final Double NUMBER_ZeroPointFourEight = 0.48;
    private static final Double NUMBER_ZeroPointZeroTwo = 0.02;
    private static final int FIVE_SECONDS = 5 * 1000;
    private static final int FIVE_THOUSAND = 5000;

    @Override
    public void updateAnalysisData() {
        try {
            //查询生产者对应的角色ID
            String keyword = analysisDataMapper.getIdByKeyword(KEYWORD_PROVIDER);
            //创建查询条件
            UserInfo userInfo = new UserInfo();
            userInfo.setState(Constant.NUMBER_1);
            //查询出用户状态正常的用户
            String users = userInfoClientService.getUsers(userInfo);
            //解析查询结果，取出需要的结果集（result）
            Map decode = JSONDecoder.decode(users);
            List result = (List) decode.get("result");
            //循环结果集
            for (int i = 0; i < result.size(); i++) {
                Map<String, String> map = (Map<String, String>) result.get(i);
                //获取每一个用户的 ID
                String userid = map.get("id");
                //根据用户ID查询用户与角色关系列表
                List<Map<String, String>> userRoleIDS = analysisDataMapper.getUserRoleIDS(userid);
                //循环用户ID对应的角色ID
                for (Map<String, String> userRoleID : userRoleIDS) {
                    String urm_roleid = userRoleID.get("URM_ROLEID");
                    //如果该用户的角色ID与生产者相符，则将该数据存入表中
                    if (keyword.equals(urm_roleid)) {
                        int apiInvokings = getApiInvokings(userid);
                        int apiCounts = analysisDataMapper.countByUserId(userid);
                        int failTimes = getFailTimes(userid);
                        int process = analysisDataMapper.getDeals(userid);
                        int apiAbnormals = getApiAbnormals(userid);
                        int waitTimes = getWaitTimes(userid);
                        int score = getScore(apiInvokings, apiCounts, failTimes, apiAbnormals, waitTimes);
                        int flows = getFlows(userid);
                        int numberOfUsers = getNumberOfUsers(userid);
                        String batch = getBatch();
                        //创建AnalysisData对象
                        AnalysisData analysisData = new AnalysisData();
                        //生成ID
                        analysisData.setId(StrUtils.randomUUID());
                        //存入角色类型
                        analysisData.setRoletype(StrUtils.toString(Constant.NUMBER_1));
                        //存入用户ID
                        analysisData.setUserid(userid);
                        //存入API总个数
                        analysisData.setApicounts(apiCounts);
                        //存入API总调用次数
                        analysisData.setApiinvokings(apiInvokings);
                        //存入API调用失败总次数
                        analysisData.setFailtimes(failTimes);
                        //存入API异常个数
                        analysisData.setApiabnormals(apiAbnormals);
                        //存入生产者处理需求
                        analysisData.setRc5(process);
                        //计算每次成功调用的平均时间
                        if ((apiInvokings - failTimes) > Constant.NUMBER_0) {
                            int waitTimeAvg = waitTimes / (apiInvokings - failTimes);
                            //将结果保存在表里
                            analysisData.setWaittime(waitTimeAvg);
                        } else {
                            analysisData.setWaittime(Constant.NUMBER_0);
                        }
                        //保存流量
                        analysisData.setRc3(flows);
                        //保存分数
                        analysisData.setScore(score);
                        //保存用户数量
                        analysisData.setRc4(numberOfUsers);
                        //保存批次
                        analysisData.setBatch(batch);
                        //保存创建时间
                        analysisData.setIdt(new Date());
                        //存入表中
                        analysisDataMapper.insertSelective(analysisData);
                    }
                }
            }
            log.info("定时任务书执行成功，数据已成功维护到库");
        } catch (Exception e) {
            log.error("定时任务书执行失败！原因：" + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void noteUserApiStatus() {

            // 获取用户API正常和不正常数量
            List<Map<String,Object>>  userApiList= analysisService.selectListMapByMethod("getUserApiNum",new HashMap<>());

            Map<String,Integer> userAPIMap=new HashMap<>();
            for(Map map:userApiList){
                //定义 用户_正确 为key  【0为正常】
                String key=map.get("USERID")+"_"+map.get("STATUS");
                //组装数据，便于取
                userAPIMap.put(key,Integer.parseInt(map.get("NUM")+""));
            }
            //发送数据
            for (Map map:userApiList){
                String userID=map.get("USERID").toString();
                //如果userAPIMap  失败的key为空，则无失败数目 则不通知
                if(!userAPIMap.containsKey(userID+"_1")){
                    continue;
                }
                //如果率
                if(!StrUtils.isBlank(userAPIMap.containsKey(userID+"_0"))){
                    //正确率高于50%，则不通知
                   Integer trueFlay= userAPIMap.get(userID+"_0")/userAPIMap.get(userID+"_1");
                   if(trueFlay>=1){
                       continue;
                   }
                }
                Message message=new Message();
                //接收者用户id
                message.setReceiverid(userID);
                //消息标题
                message.setTitle("API预警");
                //消息内容
                message.setContent("您好，您添加的API已超过50%运行不正常,请及时校验!");
                //发送者用户id 系统消息为0 ？todo
                message.setSenderid(Constant.STRING_0);
                try{
                    messageClientService.saveMessage(message);

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            System.out.println(11);

        System.out.println(11);
    }

    /**
     * 功能描述: 根据用户ID查询用户最新数据
     *
     * @param userid
     * @param:
     * @return: com.gla.datacenter.domain.AnalysisData
     * @auther: zhengshien
     * @date: 2018/12/12 13:49
     */
    @Override
    public AnalysisData getData(String userid) {
        if (StrUtils.isBlank(userid)) {
            return null;
        }

        try {
            List<AnalysisData> data = analysisDataMapper.getData(userid);
            log.info(TextUtils.format("根据用户ID{0}，获取用户数据", userid));
            if(data != null && !data.isEmpty()){
                return data.get(Constant.NUMBER_0);
            }
            return null;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述: 根据用户ID查询用户各项标准的排名
     *
     * @param userid 用户ID
     * @param:
     * @return: java.util.Map
     * @auther: zhengshien
     * @date: 2018/12/12 13:50
     */
    @Override
    public synchronized Map<String, Integer> getRank(String userid) {
        Map<String, Integer> mapRank = new HashMap();

        Date date = new Date();
        //创建查询起始日期
        Date date1 = new Date(date.getTime() - CYCLE_PERIOD);//昨天
        Date date2 = new Date(date.getTime() - LAST_TIME_CYCLE_PERIOD);//前天
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String lastTime = sdf.format(date2);
        //起始时间
        String beginTime = sdf.format(date1);
        //结束时间
        String endTime = sdf.format(date);

        try {
            //获取API个数当前排名
            int currentRank = Constant.NUMBER_0;
            try {
                currentRank = analysisDataMapper.getApiCountsRank(beginTime, endTime, userid);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            //获取API个数上次排名
            int beforeRank = Constant.NUMBER_0;
            try {
                beforeRank = analysisDataMapper.getApiCountsRank(lastTime, beginTime, userid);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            //将用户当前排名的名次存入Map集合中
            mapRank.put("countsRankCurrent", currentRank);
            log.info(TextUtils.format("用户当前拥有API个数排名的名次：{0}", currentRank));
            //计算API个数排名上升名次
            int upRank = beforeRank - currentRank;
            if (currentRank==Constant.NUMBER_0){
                mapRank.put("countsRankUp", Constant.NUMBER_0);
            }else {
                //将API个数排名上升的名次存入Map集合
                if (beforeRank != Constant.NUMBER_0) {
                    mapRank.put("countsRankUp", upRank);
                } else {
                    mapRank.put("countsRankUp", Constant.NUMBER_0);
                }
            }
            log.info(TextUtils.format("用户当前用户拥有API个数排名上升名次：{0}", upRank));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //由于SQL自定义变量@index变动问题，故在此初始化一个常量
        String i = "0";
        try {
            //获取API调用次数当前排名
            int currentRank = Constant.NUMBER_0;
            try {
                currentRank = analysisDataMapper.getApiInvokingsRank(beginTime, endTime, userid, i);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            //获取API调用次数上次排名
            int beforeRank = Constant.NUMBER_0;
            try {
                beforeRank = analysisDataMapper.getApiInvokingsRank(lastTime, beginTime, userid, i);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            //将用户API调用次数当前排名的名次存入Map集合中
            mapRank.put("invokingsRankCurrent", currentRank);
            log.info(TextUtils.format("用户当前API调用次数排名的名次：{0}", currentRank));
            //计算API调用次数排名上升名次
            int upRank = beforeRank - currentRank;
            if (currentRank==Constant.NUMBER_0){
                mapRank.put("invokingsRankUp", Constant.NUMBER_0);
            }else {
                //将API调用次数排名上升的名次存入Map集合
                if (beforeRank != Constant.NUMBER_0) {
                    mapRank.put("invokingsRankUp", upRank);
                } else {
                    mapRank.put("invokingsRankUp", Constant.NUMBER_0);
                }
            }
            log.info(TextUtils.format("用户当前API调用次数排名上升名次：{0}", upRank));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        try {
            //获取API质量当前排名
            int currentRank = Constant.NUMBER_0;
            try {
                currentRank = analysisDataMapper.getApiQualityRank(beginTime, endTime, userid);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            //获取API质量上次排名
            int beforeRank = Constant.NUMBER_0;
            try {
                beforeRank = analysisDataMapper.getApiQualityRank(beginTime, endTime, userid);
            } catch (Exception e) {
                log.error(e.getMessage());
                e.printStackTrace();
            }
            //将用户API质量当前排名的名次存入Map集合中
            mapRank.put("qualityRankCurrent", currentRank);
            log.info(TextUtils.format("用户当前API质量排名的名次:{0}", currentRank));
            //计算API质量排名上升名次
            int upRank = beforeRank - currentRank;
            if (currentRank == Constant.NUMBER_0) {
                mapRank.put("qualityRankUp", Constant.NUMBER_0);
            } else {
                //将API质量排名上升的名次存入Map集合
                if (beforeRank != Constant.NUMBER_0) {
                    mapRank.put("qualityRankUp", upRank);
                } else {
                    mapRank.put("qualityRankUp", Constant.NUMBER_0);
                }
            }
            log.info(TextUtils.format("用户当前API质量排名上升名次：{0}", upRank));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        try {
            //根据用户ID查询流量
            int flowsSum = 0;
            try {
                flowsSum = analysisDataMapper.getFlowsSum(userid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将用户流量信息存入Map集合
            mapRank.put("flowsSum", flowsSum);
            log.info(TextUtils.format("API调用产生的流量和:{0}", flowsSum));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        try {
            //根据用户ID查询处理API需求的个数
            int deals = 0;
            try {
                deals = analysisDataMapper.getDeals(userid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将API需求个数存入Map集合
            mapRank.put("deals", deals);
            log.info(TextUtils.format("处理需求个数：{0}", deals));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        try {
            //根据用户ID查询该生产者拥有的用户个数
            Integer numberOfUsersRank = 0;
            try {
                numberOfUsersRank = analysisDataMapper.getNumberOfUsersRank(beginTime, endTime, userid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将拥有用户个数当前排名存入Map集合中
            mapRank.put("numberOfUsersRankCurrent", numberOfUsersRank != null ? numberOfUsersRank : 0);
            log.info(TextUtils.format("numberOfUsersRankCurrent(拥有用户个数当前排名):{0}", numberOfUsersRank));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        try {
            //查询所有生产者用户个数
            int allUsers = 0;
            try {
                allUsers = analysisDataMapper.getAllUsers(KEYWORD_PROVIDER);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将生产者用户个数存入Map集合
            mapRank.put("allUsers", allUsers);
            log.info(TextUtils.format("allUsers(平台用户个数)：{0}", allUsers));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        try {
            //查询所有API调用总次数
            int apiInvokingsSum = 0;
            try {
                apiInvokingsSum = analysisDataMapper.getApiInvokingsSum(userid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //将API调用总次数存入Map
            mapRank.put("apiInvokingsSum", apiInvokingsSum);
            log.info(TextUtils.format("apiInvokingsSum(api被调用总次数):{0}", apiInvokingsSum));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        log.info(TextUtils.format("根据用户:ID{0},查询用户各项标准的排名", userid));
        //返回结果集
        return mapRank;
    }

    /**
     * 功能描述: 根据用户ID查询该用户每个月API被访问的个数
     *
     * @param userid 用户ID
     * @param:
     * @return: java.util.List
     * @auther: zhengshien
     * @date: 2018/12/13 14:40
     */
    @Override
    public List getApiCountsEachMonth(String userid) {
        //根据用户ID查询该用户每个月API被访问的个数
        List<Map<String, String>> apiCountsEachMonth = analysisDataMapper.getApiCountsEachMonth(userid);
        log.info(TextUtils.format("根据用户:ID{0},查询该用户每个月API被访问的个数:{1}", userid, apiCountsEachMonth));
        return apiCountsEachMonth;
    }

    @Override
    public Map<String, Integer> dataSurvey() {
        Map map = new HashMap();
        //查询平台用户总数量
        int providers = analysisDataMapper.getProviders(KEYWORD_PROVIDER);
        map.put("Providers", providers);
        //查询企业用户总数量
        int consumers = analysisDataMapper.getConsumers(KEYWORD_CONSUMER);
        map.put("Consumers", consumers);
        //查询API总个数
        int totalNumberOfApis = analysisDataMapper.getTotalNumberOfApis();
        map.put("totalNumberOfApis", totalNumberOfApis);
        //查询API申请总次数
        int totalNumberOfApplications = analysisDataMapper.getTotalNumberOfApplications();
        map.put("totalNumberOfApplications", totalNumberOfApplications);
        //查询总流量
        Integer totalFlow = analysisDataMapper.getTotalFlow();
        map.put("totalFlow", totalFlow != null ? totalFlow : 0);
        //查询同意总次数
        int approves = analysisDataMapper.getApproves();
        map.put("approves", approves);
        //查询拒绝总次数
        int rejects = analysisDataMapper.getRejects();
        map.put("rejects", rejects);
        //查询可用API的个数
        Integer numberOfNormalApis = analysisDataMapper.getNumberOfNormalApis();
        map.put("numberOfNormalApis", numberOfNormalApis);
        //查询异常API的个数
        int abnumberOfNormalApis = analysisDataMapper.getAbnumberOfNormalApis();
        map.put("abnumberOfNormalApis", abnumberOfNormalApis);
        //查询过期API的个数
        int numberOfExpiredApis = analysisDataMapper.getNumberOfExpiredApis();
        map.put("numberOfExpiredApis", numberOfExpiredApis);
        return map;
    }

    @Override
    public Map<String, String> rankingList() {
        Map map = new HashMap();
        //查询调用API次数排行榜（消费者调用API次数排行榜）
        List<Map<String, String>> rankOfConsumer = analysisDataMapper.rankOfConsumer();
        map.put("rankOfConsumer", rankOfConsumer);
        //查询被调用API次数排行榜（生产者API被调用次数排行榜）
        List<Map<String, String>> rankOfProvider = analysisDataMapper.rankOfProvider();
        map.put("rankOfProvider", rankOfProvider);

        List<Map<String, String>> rankOfApiCounts = analysisDataMapper.rankOfApiCounts();
        map.put("rankOfApiCounts", rankOfApiCounts);
        System.out.println(rankOfConsumer);
        System.out.println(rankOfProvider);
        System.out.println(rankOfApiCounts);
        return map;
    }

    @Override
    public List logOfBehavior(String managerAccount) {
        try {
            log.info("管理者查看用户审计日志");
            return analysisDataMapper.logOfBehavior(managerAccount);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map<String, Float> systemRate() {
        Map<String, Float> map = new HashMap<>();
        Date date = new Date();
        //创建查询起始日期
        Date date1 = new Date(date.getTime() - FIVE_SECONDS);//5秒前
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //起始时间
        String beginTime = sdf.format(date1);
        //结束时间
        String endTime = sdf.format(date);
        int rate = analysisDataMapper.concurrencyRate(beginTime, endTime);
        float concurrencyRate = (rate / FIVE_THOUSAND);
        map.put("concurrencyRate", concurrencyRate);

        float cpuInfo = Constant.NUMBER_0;
        try {
//            log.info("管理者查看系统负载");
            cpuInfo = LinuxSystemTool.getCpuInfo();
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        map.put("cpuInfo", cpuInfo);

        return map;
    }

    /**
     * 功能描述: 管理者上次登陆IP和时间
     *
     * @param account
     * @param:
     * @return: java.util.Map<java.lang.String,java.lang.String>
     * @auther: zhengshien
     * @date: 2018/12/25 11:16
     */
    @Override
    public Map<String, String> loginLog(String account) {
        try {
            List<Map<String, String>> list = analysisDataMapper.loginLog(account);
            Map<String, String> map = list.get(0);
            log.info("管理者上次登陆IP和时间:{}", map);
            return map;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Pager<List<Map<String, Object>>> monitorOfProvider(Integer currIndex, Integer pageSize) {
        Date date = new Date();
        //创建查询起始日期
        Date date1 = new Date(date.getTime() - CYCLE_PERIOD);//昨天
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //起始时间
        String beginTime = sdf.format(date1);
        //结束时间
        String endTime = sdf.format(date);

        //封装参数
        Map mapParam = new HashMap();

        mapParam.put("beginTime", beginTime);
        mapParam.put("endTime", endTime);
        //查询
        Pager pager = null;
        List<Map<String, String>> list = new ArrayList<>();
        int count = 0;
        try {
            count = analysisDataMapper.monitorOfProvider(mapParam, pager).size();
        } catch (Exception e) {
            e.printStackTrace();
            pager.setPagerInfo(list, count);
        }
        pager = new Pager();
        pager.setPage(currIndex);
        pager.setRows(pageSize);
        list = analysisDataMapper.monitorOfProvider(mapParam, pager);
        pager.setPagerInfo(list, count);
        log.info("管理者监控中心查看企业用户实时数据");
        return pager;
    }

    @Override
    public List<Map<String, String>> DAUAndMAU(String managerAccount, String button, String month) {
        //查看日活跃用户数
        log.info("查看日活或月活");
        if (button.equals(DAU)) {
            List<Map<String, String>> dau = analysisDataMapper.getDAU(managerAccount, month);
            log.info(TextUtils.format("日活跃数量为：{0}", dau));
            return dau;
        }
        //查看月活跃用户数量
        if (button.equals(MAU)) {
            List<Map<String, String>> mau = analysisDataMapper.getMAU(managerAccount);
            log.info(TextUtils.format("月活跃数量为：{0}", mau));
            return mau;
        }
        //参数有误
        return null;
    }

    @Override
    public List<Map<String, String>> invokingsAndFlows() {
        //按月查看调用次数和流量
        List<Map<String, String>> invokingsAndFlows = null;
        try {
            invokingsAndFlows = analysisDataMapper.getInvokingsAndFlows();
            log.info(TextUtils.format("按月查看调用次数和流量{0}", invokingsAndFlows));
            return invokingsAndFlows;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<Map<String, String>> logDynamics(String managerAccount) {
        List<Map<String, String>> list = null;
        try {
            list = analysisDataMapper.logDynamics(managerAccount);
            log.info("查询行为审计日志");
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Pager<PageLog> systemSecurityBehavior(PageLog pageLog, Pager pager) {

        if (StrUtils.isBlank(pageLog.getOptParams())) {
            return new Pager<>();
        }
        //设置初始化条件
        PageLogExample pageLogExample = new PageLogExample();
        //设置分页
        pageLogExample.setPage(pager);

        PageLogExample.Criteria criteria = pageLogExample.createCriteria();
        //不查询管理者
        if (!StrUtils.isBlank(pageLog.getUserid())) {
            criteria.andUseridNotEqualTo(pageLog.getUserid());
        }
        //按操作行为查询
        if (!StrUtils.isBlank(pageLog.getOptDetail())) {
            String[] optss = pageLog.getOptDetail().split(",");
            List list = new ArrayList();
            for (String opt : optss) {
                list.add(opt);
            }
            criteria.andOptDetailIn(list);
        }
        //按角色查询
        String[] split = pageLog.getOptParams().split(",");
        if (split.length == Constant.NUMBER_1) {
            criteria.andOptParamsLike("%" + pageLog.getOptParams() + "%");
        }

        //按时间倒序排列
        if (!StrUtils.isBlank(pageLog.getLpsort())) {
            pageLogExample.setOrderByClause(pageLog.getLpsort());
        } else {
            pageLogExample.setOrderByClause("IDT DESC");
        }

        //查询结果集
        List<PageLog> pageLogs = pageLogMapper.selectByExample(pageLogExample);
        for (PageLog pageLog1 : pageLogs) {
            if (pageLog1.getOptDetail().equals("新增黑白名单") || pageLog1.getOptDetail().equals("移除黑白名单")) {
                Map decode = JSONDecoder.decode(pageLog1.getOptParams());
                //如果“filterType”不为空时，则为新增操作
                if (decode.get("filterType") != null || decode.get("filterType") != "") {
                    String listType = (String) decode.get("listType");
                    if (listType.equals(Constant.NUMBER_1)) {
                        pageLog1.setOptDetail("新增黑名单");
                        pageLogs.set(pageLogs.indexOf(pageLog1), pageLog1);
                        System.out.println(pageLogs);
                    }

                    if (listType.equals(Constant.NUMBER_2)) {
                        pageLog1.setOptDetail("新增白名单");
                        pageLogs.set(pageLogs.indexOf(pageLog1), pageLog1);
                    }
                    //如果“filterType”为空时，则为移除操作
                } else {
                    String listType = (String) decode.get("listType");
                    if (listType.equals(Constant.NUMBER_1)) {
                        pageLog1.setOptDetail("移除黑名单");
                        pageLogs.set(pageLogs.indexOf(pageLog1), pageLog1);
                    }

                    if (listType.equals(Constant.NUMBER_2)) {
                        pageLog1.setOptDetail("移除白名单");
                        pageLogs.set(pageLogs.indexOf(pageLog1), pageLog1);
                    }
                }
            }
        }
        //封装结果集
        pager.setPagerInfo(pageLogs, pageLogMapper.countByExample(pageLogExample));
        //返回结果集
        return pager;
    }

    @Override
    public List<Map<String, String>> apiStatus(String userid) {
        try {
            //查询API状态（可用，异常，过期）
            List<Map<String, String>> apiStatus = analysisDataMapper.getApiStatus(userid);
            return apiStatus;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Map<String, String>> apiInvokings(String userid) {
        try {
            //查询API使用情况（总调用次数，成功次数，失败次数）
            List<Map<String, String>> list = analysisDataMapper.getApiInvoking(userid);
            log.info("查询API使用情况");
            return list;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Map<String, Object> apiFlow(String userid, String beginTime, String endTime) {
        Map<String, Object> map = new HashMap();
        //查询当天流量
        try {
            int todayFlowsByUserid = analysisDataMapper.getTodayFlowsByUserid(userid, beginTime, endTime);
            map.put("todayFlowsByUserid", todayFlowsByUserid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            map.put("todayFlowsByUserid", Constant.NUMBER_0);
        }

        //查询总流量
        try {
            int totalFlowsByUserid = analysisDataMapper.getTotalFlowsByUserid(userid);
            map.put("totalFlowsByUserid", totalFlowsByUserid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            map.put("totalFlowsByUserid", Constant.NUMBER_0);
        }
        log.info(TextUtils.format("根据ID查询当天流量和总流量"));
        return map;
    }

    @Override
    public int responseTime(String userid) {
        //查询成功调用API消耗总时间
        int responseTime = Constant.NUMBER_0;
        try {
            responseTime = analysisDataMapper.getResponseTime(userid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //查询成功调用API总次数
        List<Map<String, String>> list = null;
        try {
            list = analysisDataMapper.getApiInvoking(userid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //初始化调用次数
        int count = Constant.NUMBER_0;
        //循环list，取出其中成功次数的值
        for (Map<String, String> map : list) {
            Object object = map.get("success");
            //赋值给调用次数
            count = Integer.parseInt(String.valueOf(object));
        }
        //初始化调用消耗总时间
        int time = Constant.NUMBER_0;
        //在调用次数和消耗时间都不为的情况下，计算平均响应时间
        if (count != Constant.NUMBER_0 && responseTime != Constant.NUMBER_0) {
            time = responseTime / count;
        }
        //返回平均响应时间
        return time;
    }

    @Override
    public List<Map<String, String>> invokingAndFlowByWeek(String userid) {
        try {
            List<Map<String, String>> invokingAndFlowByWeek = analysisDataMapper.getInvokingAndFlowByWeek(userid);
            System.out.println(invokingAndFlowByWeek);
            return invokingAndFlowByWeek;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public List<Map<String, String>> apiQualityRanking() {

        Date date = new Date();
        //创建查询起始日期
        Date date1 = new Date(date.getTime() - CYCLE_PERIOD);//昨天
        //日期格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //起始时间
        String beginTime = sdf.format(date1);
        //结束时间
        String endTime = sdf.format(date);

        try {
            //查询API质量排名
            return analysisDataMapper.getApiQualityRanking(beginTime, endTime);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * 功能描述: 根据用户id查询该用户一天内所有API的总调用次数
     *
     * @param userid 用户id
     * @param:
     * @return: int 调用次数总和
     * @auther: zhengshien
     * @date: 2018/12/10 10:42
     */
    private int getApiInvokings(String userid) {
        //初始化调用次数
        int apiInvokings = Constant.NUMBER_0;
        try {
            //根据用户ID查询该用户拥有的所有API
            List<Map<String, String>> apiList = analysisDataMapper.getApiList(userid);
            //循环列表，对每一条API做处理
            for (Map<String, String> api : apiList) {
                //获取APIID
                String apiid = api.get("id");
                //创建查询截止日期
                Date date = new Date();
                //创建查询起始日期
                Date date1 = new Date(date.getTime() - CYCLE_PERIOD);
                //日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //起始时间
                String beginTime = sdf.format(date1);
                //结束时间
                String endTime = sdf.format(date);
                //根据输入的参数查询每一个API的调用次数
                int apiInvoking = analysisDataMapper.getApiInvokings(apiid, beginTime, endTime);
                //            int apiInvoking = analysisDataMapper.getApiInvokings(apiid, "2018-12-04 14:17:06", "2018-12-14 14:17:06");
                //累加该用户每条API的调用次数，计算该用户的所有API调用次数和
                apiInvokings += apiInvoking;
            }
            log.info(TextUtils.format("根据用户:id{0},查询该用户一天内所有API的总调用次数:{1}", userid, apiInvokings));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //返回调用次数总和
        return apiInvokings;
    }

    /**
     * 功能描述: 根据用户id查询该用户一天内所有API的总调用次数
     *
     * @param userid
     * @param:
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/10 11:36
     */
    private int getFailTimes(String userid) {
        //初始化调用失败次数
        int failTimes = Constant.NUMBER_0;
        try {
            //根据用户ID查询该用户拥有的所有API
            List<Map<String, String>> apiList = analysisDataMapper.getApiList(userid);
            //循环列表，对每一条API做处理
            for (Map<String, String> api : apiList) {
                //获取APIID
                String apiid = api.get("id");
                //创建查询截止日期
                Date date = new Date();
                //创建查询起始日期
                Date date1 = new Date(date.getTime() - CYCLE_PERIOD);
                //日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //起始时间
                String beginTime = sdf.format(date1);
                //结束时间
                String endTime = sdf.format(date);
                //根据输入的参数查询每一个API的调用失败次数
                int failTime = analysisDataMapper.getFailTimes(apiid, beginTime, endTime);
                //            int failTime = analysisDataMapper.getFailTimes(apiid, "2018-12-04 14:17:06", "2018-12-14 14:17:06");
                //累加该用户每条API的调用失败次数，计算该用户的所有API调用失败次数和
                failTimes += failTime;
            }
            log.info(TextUtils.format("根据用户id:{0}，查询该用户一天内所有API的总调用次数:{1}", userid, failTimes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回调用失败次数总和
        return failTimes;
    }

    /**
     * 功能描述: 根据用户ID统计一天内所有API异常个数
     *
     * @param userid
     * @param:
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/10 14:58
     */
    private int getApiAbnormals(String userid) {
        try {
            //创建查询截止日期
            Date date = new Date();
            //创建查询起始日期
            Date date1 = new Date(date.getTime() - CYCLE_PERIOD);
            //日期格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //起始时间
            String beginTime = sdf.format(date1);
            //结束时间
            String endTime = sdf.format(date);
            //根据输入的参数查询API异常总个数
            int apiAbnormals = analysisDataMapper.getApiAbnormals(userid, beginTime, endTime);
//        int apiAbnormals = analysisDataMapper.getApiAbnormals(userid, "2018-12-04 14:17:06", "2018-12-14 14:17:06");
            //返回API异常总个数
            log.info(TextUtils.format("根据用户ID统计一天内所有API异常个数:{0}", apiAbnormals));
            return apiAbnormals;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return Constant.NUMBER_0;
        }
    }

    /**
     * 功能描述:  根据用户ID获取该用户所有成功调用API所用的总时间(毫秒值)
     *
     * @param userid
     * @param:
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/10 16:47
     */
    private int getWaitTimes(String userid) {
        int waitTimes = 0;
        try {
            //初始化API调用时间
            waitTimes = Constant.NUMBER_0;
            //根据用户ID查询该用户拥有的所有API
            List<Map<String, String>> apiList = analysisDataMapper.getApiList(userid);
            for (Map<String, String> api : apiList) {
                //获取APIID
                String apiid = api.get("id");
                //创建查询截止日期
                Date date = new Date();
                //创建查询起始日期
                Date date1 = new Date(date.getTime() - CYCLE_PERIOD);
                //日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //起始时间
                String beginTime = sdf.format(date1);
                //结束时间
                String endTime = sdf.format(date);
                //根据输入的参数查询每一个API调用所用时间
                int waitTime = analysisDataMapper.getWaitTimes(apiid, beginTime, endTime);
                //            int waitTime = analysisDataMapper.getWaitTimes(apiid, "2018-12-04 14:17:06", "2018-12-14 14:17:06");
                //累加该用户每条API的调用时间毫秒值，计算该用户的所有API调用毫秒值的和
                waitTimes += waitTime;
            }
            log.info(TextUtils.format("根据用户ID:{0}，获取该用户所有成功调用API所用的总时间：{1},单位：毫秒", userid, waitTimes));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //返回调用所用时间总和
        return waitTimes;
    }

    /**
     * 功能描述: 根据用户ID查询流量总和
     *
     * @param userid
     * @param:
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/12 17:54
     */
    private int getFlows(String userid) {
        //初始化流量值
        int flows = Constant.NUMBER_0;
        try {
            //根据用户ID查询该用户拥有的所有API
            List<Map<String, String>> apiList = analysisDataMapper.getApiList(userid);
            //循环列表，对每一条API做处理
            for (Map<String, String> api : apiList) {
                //获取APIID
                String apiid = api.get("id");
                //创建查询截止日期
                Date date = new Date();
                //创建查询起始日期
                Date date1 = new Date(date.getTime() - CYCLE_PERIOD);
                //日期格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //起始时间
                String beginTime = sdf.format(date1);
                //结束时间
                String endTime = sdf.format(date);
                //根据输入的参数查询每一个API的流量
                int flow = analysisDataMapper.getFlows(apiid, beginTime, endTime);
                //            int flow = analysisDataMapper.getFlows(apiid, "2018-12-04 14:17:06", "2018-12-14 14:17:06");
                //累加该用户每条API的调用流量，计算该用户的所有API流量和
                flows += flow;
            }
            log.info(TextUtils.format("根据用户ID:{0},查询流量总和为：{1}，单位：bit", userid, flows));
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        //返回调用产生的流量总和
        return flows;
    }

    /**
     * 功能描述: 根据用户提供的数据计算分数
     *
     * @param apiInvokings api总调用次数
     * @param apiCounts    api总个数
     * @param failTimes    调用失败个数
     * @param apiAbnormals api异常个数
     * @param waitTimes    相应总时间
     * @param:
     * @return: int 分数
     * @auther: zhengshien
     * @date: 2018/12/10 17:56
     */
    private int getScore(int apiInvokings, int apiCounts, int failTimes, int apiAbnormals, int waitTimes) {

        //如果API总个数为0，则返回0分
        if (apiCounts == Constant.NUMBER_0) {
            log.info("API总个数为0，无法计算分数");
            return 100;
        }

        //如果调用总次数为0，则返回0分
        if (apiInvokings == Constant.NUMBER_0) {
            log.info("调用总次数为0，无法计算分数");
            return 80;
        }

        //如果调用总次数减失败次数（成功次数）大于等于0，则进行计算，否则返回0分
        if ((apiInvokings - failTimes) > Constant.NUMBER_0) {
            int waitTimeAvg = waitTimes / (apiInvokings - failTimes);
            double score = (Constant.NUMBER_1 - (failTimes / apiInvokings) * NUMBER_ZeroPointFive - (apiAbnormals / apiCounts) * NUMBER_ZeroPointFourEight - (waitTimeAvg / NUMBER_TwoHundred) * NUMBER_ZeroPointZeroTwo) * NUMBER_OneHundred;
            log.info("计算分数，得分为：{0}", score);
            return (int) Math.ceil(score);
        } else {
            log.info("调用总次数减失败次数（成功次数）小于或等于0，无法计算分数，默认得分：0分");
            return 80;
        }
    }

    /**
     * 功能描述: 生成批次
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/13 10:38
     */
    private String getBatch() {
        try {
            Date date = new Date();
            //格式化批次日期格式，精确到小时
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            String format = sdf.format(date);
            log.info("生成批次");
            return format;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述: 根据用户ID查询个该用户拥有的用户数量
     *
     * @param userid
     * @param:
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/13 14:48
     */
    private int getNumberOfUsers(String userid) {
        int numberOfUsers = analysisDataMapper.getNumberOfUsers(userid);
        log.info(TextUtils.format("根据用户ID{0}查询个该用户拥有的用户数量:{1}", userid, numberOfUsers));
        return numberOfUsers;
    }

    public static void main(String[] args) {

    }
}
