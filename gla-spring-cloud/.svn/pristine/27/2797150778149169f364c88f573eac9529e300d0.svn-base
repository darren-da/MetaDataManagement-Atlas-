package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gla.datacenter.config.MailConfig;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.mapper.mysql.*;
import com.gla.datacenter.service.*;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.xidea.el.json.JSONDecoder;

import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {

    private Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    /**
     * 引入邮件发送配置模板
     */
    @Autowired
    private MailConfig mailConfig;

    /**
     * 消息Mapper
     */
    @Autowired
    MessageMapper messageMapper;

    /**
     * 消息详情Mapper
     */
    @Autowired
    MessageCommentMapper messageCommentMapper;

    /**
     * 模板Mapper
     */
    @Autowired
    private ModelContentMapper modelContentMapper;

    /**
     * 调用API管理服务
     */
    @Autowired
    private ApiManagerClientService apiManagerClientService;

    /**
     * 调用用户管理服务
     */
    @Autowired
    private UserInfoClientService userInfoClientService;

    /**
     * 调用用户管理服务
     */
    @Autowired
    private ResourceCateManagerClientService resourceCateManagerClientService;

    /**
     * 调用APP管理服务
     */
    @Autowired
    private AppClientService appClientService;

    /**
     * 功能描述:
     * 新增消息
     *
     * @param message 消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:45
     */
    @Override
    public boolean saveMessage(Message message) {
        if (StrUtils.isBlank(message)) {
            log.info("/***参数异常：参数为空！**/");
            return false;
        }
        log.debug(TextUtils.format("新增消息"));
        try {
            message.setId(StrUtils.randomUUID());
            message.setSendtime(new Date());
            message.setIsread(Constant.NUMBER_0);//消息是否已读默认为“未读”
            message.setIsdeal(String.valueOf(Constant.NUMBER_0));//消息是否处理默认为“未处理”
            message.setStatus(String.valueOf(Constant.NUMBER_1));//消息状态默认为“正常”
            message.setLevel(Constant.NUMBER_0);//消息优先级默认为“无”
            log.info("/***新增消息**/");
            return messageMapper.insertSelective(message) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述: 新增API与用户关系数据
     *
     * @param apiNumLimt API与用户关系表实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:47
     */
    private boolean saveApiNumList(ApiNumLimt apiNumLimt) {
        //参数校验
        if (StrUtils.isBlank(apiNumLimt)) {
            log.info("/***参数异常：参数为空！**/");
            return false;
        }
        //新增关系
        log.debug(TextUtils.format("/***新增API与用户关系数据**/"));
        try {
            apiNumLimt.setId(StrUtils.randomUUID());
            apiNumLimt.setIdt(new Date());
            apiNumLimt.setLimtType(Constant.NUMBER_1);
            return apiManagerClientService.insertSelective(apiNumLimt);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述: 新增APP与用户关系
     *
     * @param appUserMap APP与用户关系实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2019/2/21 10:46
     */
    private boolean saveAppUserMap(AppUserMap appUserMap) {
        //参数校验
        if (StrUtils.isBlank(appUserMap)) {
            log.info("/***参数异常：参数为空！**/");
            return false;
        }
        //新增关系
        log.debug(TextUtils.format("/***新增APP与用户关系数据**/"));
        try {
            appUserMap.setUserid(appUserMap.getUserid());
            appUserMap.setAppid(appUserMap.getAppid());
            appUserMap.setIdt(new Date());
            appUserMap.setApplyStatus(Constant.NUMBER_3);
//            return appUserMapMapper.insertSelective(appUserMap) == 1 ? true : false;
            return appClientService.saveAppUserMap(appUserMap);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述: 新增回复消息
     *
     * @param messageComment 回复消息实体
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @Override
    public Boolean saveMessageComment(MessageComment messageComment) {
        if (StrUtils.isBlank(messageComment)) {
            log.info("/***参数异常：参数为空！**/");
            return false;
        }
        log.debug(TextUtils.format("/***新增消息回复**/"));
        try {
            messageComment.setId(StrUtils.randomUUID());
            messageComment.setIdt(new Date());
            messageComment.setIsread(Constant.NUMBER_1);//消息是否已读默认为“未读”
            messageComment.setIsdeal(Constant.NUMBER_0);//消息是否处理默认为“未处理”
            messageComment.setStatus(String.valueOf(Constant.NUMBER_1));//消息状态默认为“正常”
            messageComment.setLevel(Constant.NUMBER_0);//消息优先级默认为“无”
            return messageCommentMapper.insertSelective(messageComment) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 功能描述: 申请多条API（购物车）
     *
     * @param message 消息实体
     * @param id      apiid（多个用逗号隔开）
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:59
     */
    @Override
    public String saveMessageCart(Message message, String id) {
        if (StrUtils.isBlank(id)) {
            log.info("/***参数异常：id为空！**/");
            return Result.getException("参数异常：id为空！").getJson();
        }
        try {
            //创建工具类
            Map apieDtailMap = new HashMap<String, Object>();
            //根据逗号切割id列表，获取id数组后遍历
            String[] ids = id.split(Constant.DHAO);
            for (String apiId : ids) {
                //调用API服务根据id获取每一条API的详细信息
                String api = apiManagerClientService.getApiById(apiId);
                //解析获取到的结果集，取result
                Map decode = JSONDecoder.decode(api);
                Map apiManagerModel = (Map) decode.get("result");
                //创建map工具
                Map apiManagerModelStore = new HashMap<String, Object>();
                //将API相关属性放入APPRULE中
                apiManagerModelStore.put("id", apiManagerModel.get("id"));
                apiManagerModelStore.put("apiName", apiManagerModel.get("apiName"));
                apiManagerModelStore.put("apiCode", apiManagerModel.get("apiCode"));
                apiManagerModelStore.put("description", apiManagerModel.get("description"));
                apiManagerModelStore.put("url", apiManagerModel.get("url"));
                apiManagerModelStore.put("shareLevel", apiManagerModel.get("shareLevel"));
                apiManagerModelStore.put("categoryId", apiManagerModel.get("categoryId"));
                apiManagerModelStore.put("apiType", apiManagerModel.get("apiType"));
                apiManagerModelStore.put("producerId", apiManagerModel.get("producerId"));
                //调用用户管理微服务，根据消费者id查询消费者信息
                String userInfo = userInfoClientService.selectUserInfo(message.getSenderid());
                Map decode1 = JSONDecoder.decode(userInfo);
                Map user = (Map) decode1.get("result");
                //将消费者与api关系存入ApiNumLimt表中
                ApiNumLimt apiNumLimt = new ApiNumLimt();
                //获取用户申请的apiid
                String apiid = apiManagerModel.get("id").toString();
                //根据用户id查询apiNumLimt列表
                apiNumLimt.setUserid(user.get("id").toString());
                List<ApiNumLimt> apiNumLimtList = getApiNumLimtList(apiNumLimt);
                //循环列表，并判断该用户是否已添加过该api，如果已添加过，返回错误信息
                List<String> str = new ArrayList<>();
                for (ApiNumLimt numLimt : apiNumLimtList) {
                    if (numLimt.getApiid().equals(apiid)) {
                        apiNumLimt = numLimt;
                        if (numLimt.getAuditStatus() == 4) {
                            str.add(numLimt.getApiid());
                            //如果该API是曾被拒绝的，则可再次申请，否则提示不可重复操作。
                            //apiNumLimt.setAuditStatus(3);
                            //updateApiNumList(apiNumLimt);
                        } else {
                            log.info("/***操作异常：api已添加，请不要重复添加!**/");
                            return Result.getInstance("403", "api已添加，请不要重复添加!", null, null).getJson();
                        }
                        //return false;
                    }
                }
                //如果该API是曾被拒绝的，则可再次申请
                if (str.contains(apiid)) {
                    apiNumLimt.setAuditStatus(3);
                    apiNumLimt.setUdt(new Date());
                    updateApiNumList(apiNumLimt);
                    //否则新增
                } else {
                    //存入apiid
                    apiNumLimt.setApiid(apiManagerModel.get("id").toString());
                    //存入用户id
                    apiNumLimt.setUserid(user.get("id").toString());
                    //存入用户账号
                    apiNumLimt.setAccount(user.get("account").toString());
                    //存入api状态为3
                    apiNumLimt.setAuditStatus(Constant.NUMBER_3);
                    //存入是否有次数限制为无
                    apiNumLimt.setNumFlag(Constant.NUMBER_1);
                    saveApiNumList(apiNumLimt);
                }
                //管理者处理意见
                apiManagerModelStore.put("MDeal", 0);
                //生产者处理意见
                apiManagerModelStore.put("PDeal", 0);
                apieDtailMap.put(apiId, apiManagerModelStore);
            }
            //创建模板查询对象
            ModelContentExample modelContentExample = new ModelContentExample();
            //查询管理者消息批复规则
            modelContentExample.createCriteria().andCodeEqualTo("MODEL_REPLYRULE_MANAGER");
            List<ModelContent> modelContents = modelContentMapper.selectByExample(modelContentExample);
            ModelContent modelContent = modelContents.get(0);
            //设置消息申请规则
            message.setApprule(JsonUtils.toJson(apieDtailMap));
            //设置消息类型为2（申请类型消息）
            message.setMessagetype(String.valueOf(Constant.NUMBER_2));
            //设置批复规则
            message.setReplyrule(modelContent.getContent());
            //新增申请消息
            if (saveMessage(message)) {
                return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, null, null).getJson();
            } else {
                return Result.Error().getJson();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
    }


    /**
     * 功能描述: 申请多条APP
     *
     * @param message
     * @param id
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/20 16:15
     */
    @Override
    public String saveAppCart(Message message, String id) {
        if (StrUtils.isBlank(id)) {
            log.info("/***参数异常：id为空！**/");
            return Result.getException("参数异常：id为空！").getJson();
        }
        try {
            //创建工具类
            Map appDtailMap = new HashMap<String, Object>();
            //根据逗号切割id列表，获取id数组后遍历
            String[] ids = id.split(Constant.DHAO);
            List<String> str = new ArrayList<>();
            for (String appId : ids) {
                //调用APP服务根据id获取每一条API的详细信息
                String app = appClientService.selectAppService(appId);
                //解析获取到的结果集，取result
                Map decode = JSONDecoder.decode(app);
                Map appManagerModel = (Map) decode.get("result");
                //创建map工具
                Map appManagerModelStore = new HashMap<String, Object>();
                //将APP相关属性放入APPRULE中
                appManagerModelStore.put("id", appManagerModel.get("id"));
                appManagerModelStore.put("appName", appManagerModel.get("appName"));
                appManagerModelStore.put("appCode", appManagerModel.get("appCode"));
                appManagerModelStore.put("description", appManagerModel.get("description"));
                appManagerModelStore.put("createUserId", appManagerModel.get("createUserId"));
                appManagerModelStore.put("shareType", appManagerModel.get("shareType"));
                appManagerModelStore.put("idt", appManagerModel.get("idt"));
                //调用用户管理微服务，根据消费者id查询消费者信息
                String userInfo = userInfoClientService.selectUserInfo(message.getSenderid());
                Map decode1 = JSONDecoder.decode(userInfo);
                Map user = (Map) decode1.get("result");
                String userid = (String) user.get("id");
                //将消费者ID存入数组中
                String[] userList = userid.split(Constant.DHAO);
                //查询APP和用户的绑定关系，是否已经申请过
//                List<AppUserMap> applyUsers = appUserMapMapper.getApplyUsers(ids, userList);
                List<AppUserMap> applyUsers = appClientService.getApplyUsers(id, userid);
                for (AppUserMap applyUser : applyUsers) {
                    Integer applyStatus = applyUser.getApplyStatus();
                    if (applyUser.getAppid().equals(appId)) {
                        //若已申请过，正在申请中或者已授权，则提示用户不要重复添加
                        if (applyStatus == Constant.NUMBER_1 || applyStatus == Constant.NUMBER_3) {
                            log.info("/***操作异常：app已添加，请不要重复添加!**/");
                            return Result.getInstance("403", "app已添加，请不要重复添加!", null, null).getJson();
                        }
                        //若有记录且审核状态为审核失败，则删除这一条记录，后面重新添加。
                        if (applyStatus == Constant.NUMBER_4) {
                            str.add(applyUser.getAppid());
//                            appUserMapMapper.delAuditFailureByStatus(applyUser.getAppid(), applyUser.getUserid());
                            appClientService.delAuditFailureByStatus(applyUser.getAppid(), applyUser.getUserid());
                        }
                    }
                }
                //若不存在绑定关系，则添加绑定关系
                AppUserMap appUserMap = new AppUserMap();
                appUserMap.setAppid(appId);
                appUserMap.setUserid(userid);
                saveAppUserMap(appUserMap);


                //管理者处理意见
                appManagerModelStore.put("MDeal", 0);
                //生产者处理意见
                appManagerModelStore.put("PDeal", 0);
                appDtailMap.put(appId, appManagerModelStore);

            }

            //设置消息申请规则
            message.setApprule(JsonUtils.toJson(appDtailMap));
            //设置消息类型为3（app申请类型消息）
            message.setMessagetype(String.valueOf(Constant.NUMBER_3));
            //设置批复规则
//        message.setReplyrule(modelContent.getContent());
            //新增申请消息
            if (saveMessage(message)) {
                return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, null, null).getJson();
            } else {
                return Result.Error().getJson();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
    }

    private List<ApiNumLimt> getApiNumLimtList(ApiNumLimt apiNumLimt) {
        //根据条件查询符合条件的用户列表
        List<ApiNumLimt> apiNumLimts = null;
        try {
            apiNumLimts = apiManagerClientService.selectByExample(apiNumLimt);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return apiNumLimts;
    }

    /**
     * 功能描述: 消息流转
     *
     * @param id 消息id
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @Override
    public String messagePosition(String id) {
        Message message = getMessageById(id);
        Map<String, Object> timeMap = new HashMap<>();
        //获取消息创建时间
        timeMap.put("time1", message.getSendtime());
        timeMap.put("status1", message.getIsdeal());
        //获取管理者处理时间
        if (!StrUtils.isBlank(message.getDealtime())) {
            timeMap.put("time2", message.getDealtime());
        }
        MessageComment messageComment = new MessageComment();
        //根据消费者发起消息的id查找每条API对应的回复消息
        messageComment.setFid(id);
        //查询所有API所属生产者消息列表
        List<MessageComment> messageCommentList = getMessageCommentList(messageComment);
        //工具
        List list = new ArrayList();
        //工具
        List positionList = new ArrayList();
        if (!StrUtils.isBlank(messageCommentList)) {
            for (MessageComment comment : messageCommentList) {
                if (!String.valueOf(Constant.NUMBER_0).equals(comment.getReceiverid())) {
                    Map map = new HashMap();
                    //time3：生产者批复时间 time4：完成时间
                    if (!StrUtils.isBlank(comment.getApiid())) {
                        //获取APIID
                        map.put("APIID", comment.getApiid());
                        //获取生产者处理状态
                        if (!StrUtils.isBlank(comment.getIsdeal())) {
                            map.put("status2", comment.getIsdeal());
                        }
                        if (!StrUtils.isBlank(comment.getDealtime())) {
                            map.put("time3", comment.getDealtime());
                        }
                        if (!StrUtils.isBlank(comment.getContent())) {
                            map.put("content", comment.getContent());
                        }
                        if (!StrUtils.isBlank(comment.getRc2())) {
                            map.put("reason", comment.getRc2());
                        } else {
                            map.put("reason", "");
                        }
                        if (!StrUtils.isBlank(comment.getDevbegintime())) {
                            map.put("devbegintime", comment.getDevbegintime());
                        } else {
                            map.put("devbegintime", "");
                        }
                        if (!StrUtils.isBlank(comment.getDevendtime())) {
                            map.put("devendtime", comment.getDevendtime());
                        } else {
                            map.put("devendtime", "");
                        }
                        positionList.add(map);
                    }
                }
            }
        }
        timeMap.put("apis", positionList);
        list.add(timeMap);
        log.info("/***查看消息流转id:{0}**/", id);
        return JsonUtils.getJson(list);
    }

    /**
     * 功能描述: 生产者完成API开发
     *
     * @param apiid     apiid
     * @param commentId 消息id
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @Override
    public boolean APIComplete(String apiid, String commentId) {
        if (StrUtils.isBlank(commentId)) {
            log.info("/***参数异常：消息id为空！**/");
            return false;
        }
        try {
            //创建工具类
            Map apieDtailMap = new HashMap<String, Object>();
            ///根据逗号切割id列表，获取id数组后遍历
            String[] ids = apiid.split(Constant.DHAO);
            for (String apiId : ids) {
                //调用API服务根据id获取每一条API的详细信息
                String api = apiManagerClientService.getApiById(apiId);
                //解析获取到的结果集，取result
                Map decode = JSONDecoder.decode(api);
                Map apiManagerModel = (Map) decode.get("result");
                //创建map工具
                Map apiManagerModelStore = new HashMap<String, Object>();
                //将API相关属性放入APPRULE中
                apiManagerModelStore.put("id", apiManagerModel.get("id"));
                apiManagerModelStore.put("apiName", apiManagerModel.get("apiName"));
                apiManagerModelStore.put("apiCode", apiManagerModel.get("apiCode"));
                apiManagerModelStore.put("producerId", apiManagerModel.get("producerId"));
                apiManagerModelStore.put("PDeal", 0);
                apieDtailMap.put(apiId, apiManagerModelStore);
            }
            //根据commentid获取comment对象
            MessageComment comment = getMessageCommentById(commentId);
            //获取comment的fid
            String messageid = comment.getFid();
            //根据fid获取message对象
            Message message = getMessageById(messageid);
            //填充消息申请规则，用以对已完成API的消息回显（消费者和管理者可以看到）
            message.setIsdeal(String.valueOf(Constant.NUMBER_4));
            //将消息状态标记为完成
            message.setApprule(JsonUtils.toJson(apieDtailMap));
            //更新消息内容
            update(message);
            //更新API完成时间
            comment.setDevendtime(new Date());
            //将完成的API详情添加到comment的Rc1字段中，用以给生产者做回显
            comment.setRc1(JsonUtils.toJson(apieDtailMap));
            //将isDeal修改为已完成状态
            comment.setIsdeal(Constant.NUMBER_4);
            //更新comment详情
            updateComment(comment);
            log.info("/***生产者完成API开发，消息批复为“完成”**/");
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }


    /**
     * 功能描述: 修改回复消息状态（星标等）
     *
     * @param entry 回复消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @Override
    public boolean update(Message entry) {
        if (StrUtils.isBlank(entry.getId())) {
            log.info("/***参数错误：参数id为空**/");
            return false;
        }
        log.debug(TextUtils.format("/***根据消息Id{0},更新实体类信息**/", entry.getId()));
        return messageMapper.updateByPrimaryKeySelective(entry) == 1 ? true : false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     * 功能描述: 修改回复消息状态（星标等）
     *
     * @param entry 回复消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @Override
    public boolean updateComment(MessageComment entry) {
        if (StrUtils.isBlank(entry.getId())) {
            log.info("/***参数异常:参数id为空！**/");
            return false;
        }
        MessageCommentExample commentExample = new MessageCommentExample();
        commentExample.createCriteria().andIdEqualTo(entry.getId());
        log.debug(TextUtils.format("/***根据消息Id{0},更新实体类信息**/", entry.getId()));
        return messageCommentMapper.updateByExampleSelective(entry, commentExample) == 1 ? true : false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     * 功能描述: 修改用户与API关系表
     *
     * @param entry 关系实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 15:52
     */
    private boolean updateApiNumList(ApiNumLimt entry) {
        if (StrUtils.isBlank(entry.getId())) {
            log.info("/***参数异常:参数id为空！**/");
            return false;
        }
        log.debug(TextUtils.format("/***根据消息Id{0},更新实体类信息**/", entry.getId()));
        return apiManagerClientService.updateByPrimaryKeySelective(entry);  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     * 功能描述: 大数据中心批复申请消息
     *
     * @param id      消息id
     * @param btn     批复意见
     * @param content 批复内容
     * @param level   优先级
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:48
     */
    @Override
    public boolean updateMessage(String id, String btn, String content, Integer level) {
        if (StrUtils.isBlank(id)) {
            log.info("/***参数异常:消息id为空！**/");
            return false;
        }
        //根据id获取此时message的内容
        Message message = getMessageById(id);
        //如果是待审核消息，需要大数据中心做出批复，如果是普通消息或系统消息，则无需修改
        if (String.valueOf(Constant.NUMBER_2).equals(message.getMessagetype())) {
            if (!StrUtils.isBlank(message.getApprule())) {
                MessageExample messageExample = new MessageExample();
                messageExample.createCriteria().andIdEqualTo(id);
                //如果btn等于1，即批复为同意，将消息下发至各个对应生产者
                if (String.valueOf(Constant.NUMBER_1).equals(btn)) {
                    //解析消息中的申请消息appRule，获取其中的生产者信息
                    Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());

                    try {
                        for (String s : decode.keySet()) {
                            Map<String, Object> decode1 = (Map<String, Object>) decode.get(s);
                            //获取每一个API的id
                            Object id1 = decode.get(decode1.get("id"));
                            //将消息发送至对应生产者
                            MessageComment messageComment = sendMessageComment(String.valueOf(message.getSenderid()), String.valueOf(decode1.get("producerId")), String.valueOf(id1), message.getId(), String.valueOf(decode1.get("id")), String.valueOf(decode1.get("apiName")), level);
                            messageCommentMapper.insertSelective(messageComment);
                        }
                        //触发此方法时直接将消息修改为同意状态
                        message.setIsdeal(String.valueOf(Constant.NUMBER_1));
                        message.setIsread(Constant.NUMBER_0);
                        message.setDealtime(new Date());
                        message.setRc2(content);
                        message.setLevel(level);
                        messageMapper.updateByExample(message, messageExample);
                        log.info("/***大数据中心批复意见为“同意”**/");
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                }
                //如果btn等于2，即批复为拒绝，重新发一条消息给消费者
                if (String.valueOf(Constant.NUMBER_2).equals(btn)) {
                    //修改用户授权API的使用权限
                    try {
                        //根据用户id查询授权中的信息
                        List<ApiNumLimt> apiNumLimts = apiManagerClientService.selectExample(message.getSenderid());
                        if (apiNumLimts != null && !apiNumLimts.isEmpty()) {
                            Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());
                            for (Map.Entry<String, Object> entry : decode.entrySet()) {
                                //获取每一个API的id
                                String apiId = entry.getKey().toString();
                                for (ApiNumLimt apiNumLimt : apiNumLimts) {
                                    if (apiId.equals(apiNumLimt.getApiid())) {
                                        ApiNumLimt apiNumLimt1 = new ApiNumLimt();
                                        apiNumLimt1.setId(apiNumLimt.getId());
                                        apiNumLimt1.setAuditStatus(Constant.NUMBER_4);
                                        updateApiNumList(apiNumLimt1);
                                    }
                                }
                            }
                        }
                        log.info(TextUtils.format("用户{0}申请的API被管理者拒绝"), message.getSenderid());
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        e.printStackTrace();
                    }


                    try {
                        //触发此方法时直接将消息修改为拒绝状态
                        message.setIsdeal(String.valueOf(Constant.NUMBER_2));
                        message.setIsread(Constant.NUMBER_0);
                        message.setDealtime(new Date());
                        message.setRc2(content);
                        messageMapper.updateByExample(message, messageExample);
                        log.info("/***大数据中心批复意见为“拒绝”**/");
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                }
                log.debug(TextUtils.format("大数据中心根据消息id,更新消息状态和批复", id));
            } else {
                MessageExample messageExample = new MessageExample();
                messageExample.createCriteria().andIdEqualTo(id);
                //如果btn等于1，即批复为同意，将消息下发至各个对应生产者
                if (String.valueOf(Constant.NUMBER_1).equals(btn)) {
                    try {
                        //如果同意使用，则将消息转发给生产者
                        MessageComment messageComment = sendMessageComment(message.getSenderid(), message.getReceiverid(),
                                message.getContent(), message.getId(), "null", message.getTitle(), level);
                        messageCommentMapper.insertSelective(messageComment);
                        //触发此方法时直接将消息修改为同意状态
                        message.setIsdeal(String.valueOf(Constant.NUMBER_1));
                        message.setIsread(Constant.NUMBER_0);
                        message.setRc2(content);
                        message.setDealtime(new Date());
                        message.setLevel(level);
                        messageMapper.updateByExample(message, messageExample);
                        log.info("/***大数据中心批复意见为“同意”**/");
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                }
                //如果btn等于2，即批复为拒绝，将消息回复给消费者
                if (String.valueOf(Constant.NUMBER_2).equals(btn)) {
                    try {
                        message.setIsdeal(String.valueOf(Constant.NUMBER_2));
                        message.setIsread(Constant.NUMBER_0);
                        message.setRc2(content);
                        message.setDealtime(new Date());
                        messageMapper.updateByExample(message, messageExample);
                        log.info("/***大数据中心批复意见为“拒绝”**/");
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                }
                log.debug(TextUtils.format("大数据中心根据消息id,批复写信内容", id));
            }
        }else if("4".equals(message.getMessagetype())){
            //资源目录申请消息
            MessageExample messageExample = new MessageExample();
            messageExample.createCriteria().andIdEqualTo(id);
            message.setDealtime(new Date());
            message.setIsdeal("1".equals(btn) ? "4" : "2");
            String apprule = message.getApprule();
            String code = "";
            try {
                if(StringUtils.isNotBlank(apprule)){
                    JSONObject jsonObject = (JSONObject) JSONObject.parse(apprule);
                    for(Map.Entry<String, Object> entry : jsonObject.entrySet()){
                        code = entry.getKey();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                log.error("apprule的json转换异常!");
            }
            try {
                messageMapper.updateByExample(message, messageExample);
                if(StringUtils.isNotBlank(code)){
                    if("1".equals(btn)){
                        resourceCateManagerClientService.resourceApproved(String.valueOf(code));
                    }else{
                        resourceCateManagerClientService.resourceAuditFailure(String.valueOf(code));
                    }

                }
                sendMessage(content, message.getSenderid(), message.getReceiverid(), message.getTitle() + ("1".equals(btn) ? "通过" : "拒绝"));
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 功能描述: 管理者处理APP申请消息
     *
     * @param id
     * @param optinion
     * @param content
     * @param level
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/2/20 16:16
     */
    @Override
    public Boolean dealMessageApp(String id, String optinion, String content, Integer level) {
        if (StrUtils.isBlank(id)) {
            log.info("/***参数异常:消息id为空！**/");
            return false;
        }
        //根据id获取此时message的内容
        Message message = getMessageById(id);
        //如果是APP申请消息，需要管理者做出批复
        if (String.valueOf(Constant.NUMBER_3).equals(message.getMessagetype())) {
            MessageExample messageExample = new MessageExample();
            messageExample.createCriteria().andIdEqualTo(id);
            //如果btn等于1，即批复为同意，将消息下发至各个对应生产者
            if (String.valueOf(Constant.NUMBER_1).equals(optinion)) {
                //解析消息中的申请消息appRule，获取其中的生产者信息
                Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());

                try {
                    for (String s : decode.keySet()) {
                        Map<String, Object> decode1 = (Map<String, Object>) decode.get(s);
                        //获取每一个APP的id
                        Object id1 = decode.get(decode1.get("id"));
                        //将消息发送至对应生产者
                        MessageComment messageComment = sendMessageComment(String.valueOf(message.getSenderid()), String.valueOf(decode1.get("createUserId")), String.valueOf(id1), message.getId(), String.valueOf(decode1.get("id")), String.valueOf(decode1.get("appName")), level);
                        messageCommentMapper.insertSelective(messageComment);
                    }
                    //触发此方法时直接将消息修改为同意状态
                    message.setIsdeal(String.valueOf(Constant.NUMBER_1));
                    message.setIsread(Constant.NUMBER_0);
                    message.setDealtime(new Date());
                    message.setRc2(content);
                    message.setLevel(level);
                    messageMapper.updateByExample(message, messageExample);
                    log.info("/***大数据中心批复意见为“同意”**/");
                    return true;
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return false;
                }

            }
            //如果btn等于2，即批复为拒绝，重新发一条消息给消费者
            if (String.valueOf(Constant.NUMBER_2).equals(optinion)) {

                //修改用户授权API的使用权限
                try {
                    //根据用户id查询授权中的信息
                    updateAppUserMap(message, Constant.NUMBER_4);
                    log.info(TextUtils.format("用户{0}申请的APP被管理者拒绝"), message.getSenderid());
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }


                try {
                    //触发此方法时直接将消息修改为拒绝状态
                    message.setIsdeal(String.valueOf(Constant.NUMBER_2));
                    message.setIsread(Constant.NUMBER_0);
                    message.setDealtime(new Date());
                    message.setRc2(content);
                    messageMapper.updateByExample(message, messageExample);
                    log.info("/***管理者批复意见为“拒绝”**/");
                    return true;
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return false;
                }
            }
            log.debug(TextUtils.format("管理者根据消息id,更新消息状态和批复", id));
        }
        return null;
    }

    @Override
    public Boolean dealMessageResDirectory(String id, String optinion, String content, Integer level) {

        if (StrUtils.isBlank(id)) {
            log.info("/***参数异常:消息id为空！**/");
            return false;
        }
        //根据id获取此时message的内容
        Message message = getMessageById(id);
        if (!StrUtils.isBlank(message.getApprule())) {
            MessageExample messageExample = new MessageExample();
            messageExample.createCriteria().andIdEqualTo(id);
            //如果optinion等于1，即批复为同意，更新资源目录，并给申请者发送通知消息
            if (String.valueOf(Constant.NUMBER_1).equals(optinion)) {
                //解析消息中的申请消息appRule，获取其中的生产者信息
                Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());

                try {
                    for (String s : decode.keySet()) {
                        Map<String, Object> decode1 = (Map<String, Object>) decode.get(s);
                        //获取每一个所需审核资源目录的code
                        Object code = decode1.get("code");
                        try {
                            //审核通过，更新资源目录
                            resourceCateManagerClientService.resourceApproved(String.valueOf(code));
                        } catch (Exception e) {
                            e.printStackTrace();
                            log.error(e.getMessage());
                        }
                    }
                    //触发此方法时直接将消息修改为同意状态
                    message.setIsdeal(String.valueOf(Constant.NUMBER_1));
                    message.setDealtime(new Date());
                    //记录管理者批复意见
                    message.setRc2(content);
                    message.setLevel(level);
                    messageMapper.updateByExample(message, messageExample);
                    sendMessage(content, message.getSenderid(), message.getReceiverid(), message.getTitle());
                    log.info("/***管理者批复意见为“同意”**/");
                    return true;
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return false;
                }
            }
            //如果optinion等于2，即批复为拒绝，并给申请者发送通知消息
            if (String.valueOf(Constant.NUMBER_2).equals(optinion)) {
                //解析消息中的申请消息appRule，获取其中的生产者信息
                Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());
                for (String s : decode.keySet()) {
                    Map<String, Object> decode1 = (Map<String, Object>) decode.get(s);
                    //获取每一个所需审核资源目录的code
                    Object code = decode1.get("code");
                    try {
                        //审核通过，更新资源目录
                        resourceCateManagerClientService.resourceAuditFailure(String.valueOf(code));
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error(e.getMessage());
                    }
                }
                try {
                    //触发此方法时直接将消息修改为拒绝状态
                    message.setIsdeal(String.valueOf(Constant.NUMBER_2));
                    message.setDealtime(new Date());
                    //记录管理者批复意见
                    message.setRc2(content);
                    message.setLevel(level);
                    messageMapper.updateByExample(message, messageExample);
                    sendMessage(content, message.getSenderid(), message.getReceiverid(), message.getTitle());
                    log.info("/***管理者批复意见为“拒绝”**/");
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }
            }
        }
        return true;
    }

    /**
     * Message消息发送工具
     *
     * @param content    内容
     * @param receiverid 收件人
     * @param senderid   发件人
     * @param title      标题
     */
    @Override
    public String sendMessage(String content, String receiverid, String senderid, String title) {
        Message messageToConsumer = new Message();
        messageToConsumer.setMessagetype(String.valueOf(Constant.NUMBER_1));
        messageToConsumer.setSenderid(senderid);
        messageToConsumer.setReceiverid(receiverid);
        messageToConsumer.setTitle(title);
        messageToConsumer.setContent(content);
        saveMessage(messageToConsumer);
        return messageToConsumer.getId();
    }

    @Override
    public boolean markRead(String ids) {
        String[] split = ids.split(",");
        try {
            for (String id : split) {
                Message message = new Message();
                MessageComment messageComment = new MessageComment();
                message.setId(id);
                messageComment.setId(id);
                message.setIsread(Constant.NUMBER_1);
                messageComment.setIsread(Constant.NUMBER_1);
                update(message);
                updateComment(messageComment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String selectModelContent(String code) {
        ModelContentExample modelContentExample = new ModelContentExample();
        modelContentExample.createCriteria().andCodeEqualTo(code);
        //根据模板code查询模板内容
        List<ModelContent> modelContents = modelContentMapper.selectByExample(modelContentExample);
        ModelContent modelContent = modelContents.get(0);
        //获取模板内容
        return modelContent.getContent();
    }




    /**
     * MessageComment消息发送工具
     *
     * @param senderid   发件人
     * @param receiverid 收件人
     * @param content    回复内容
     * @param fId        父id
     * @param level      优先级
     * @return
     */
    private MessageComment sendMessageComment(String senderid, String receiverid, String content, String fId,
                                              String apiId, String title, Integer level) {
        MessageComment messageComment = new MessageComment();
        messageComment.setId(StrUtils.randomUUID());//设置消息id
        messageComment.setIdt(new Date());
        messageComment.setSenderid(senderid);//消息发送者
        messageComment.setReceiverid(receiverid); //消息接收者
        messageComment.setContent(String.valueOf(content));//添加回复内容
        messageComment.setIsread(Constant.NUMBER_0);//消息是否已读默认为“未读”
        messageComment.setIsdeal(Constant.NUMBER_0);//消息是否处理默认为“未处理”
        messageComment.setStatus(String.valueOf(Constant.NUMBER_1));//消息状态默认为“正常”
        messageComment.setFid(fId);
        messageComment.setApiid(apiId);
        messageComment.setTitle(title);
        messageComment.setLevel(level);//设置消息优先级
        //获取生产者批复模板
        ModelContentExample modelContentExample = new ModelContentExample();
        modelContentExample.createCriteria().andCodeEqualTo("MODEL_REPLYRULE_PRODUCER");
        List<ModelContent> modelContents = modelContentMapper.selectByExample(modelContentExample);
        ModelContent modelContent = modelContents.get(0);
        //设置生产者批复模板
        messageComment.setReplyrule(modelContent.getContent());
        return messageComment;
    }

    /**
     * Json数据解析工具
     *
     * @param str  需要解析的内容
     * @param btn  需要解析的btn值对应的数据
     * @param name 需要获取的name对应的字符串
     * @return
     */
    private String getName(String str, String btn, String name) {
        //解析消息批复规则，解析为JSON格式
        Map map = JsonUtils.convertJsonStrToMap(str);
        //获取btn对应的value数据
        Object btnData = map.get(btn);
        //再次解析value数据，获取name对应的值
        Map dataMap = JsonUtils.convertJsonStrToMap(String.valueOf(btnData));
        return String.valueOf(dataMap.get(name));
    }

    /**
     * 功能描述: 生产者批复API或APP申请消息
     *
     * @param id      id
     * @param btn     批复意见
     * @param content 批复内容
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:49
     */
    @Override
    public Boolean updateMessageComment(String id, String btn, String content) {
        Message message = null;
        try {
            if (StrUtils.isBlank(id)) {
                log.info("/***参数异常：消息id为空**/");
                return false;
            }
            //如果消息内容为空，填入字符串"null"
            if (StrUtils.isBlank(content)) {
                content = "null";
            }
            //根据id获取消息回复信息
            MessageComment messageComment = getMessageCommentById(id);
            //根据消息回复的Fid获取生产者所发送的消息信息
            message = getMessageById(messageComment.getFid());
            MessageCommentExample messageCommentExample = new MessageCommentExample();
            messageCommentExample.createCriteria().andIdEqualTo(id);
            //如果btn的值为1，则批复为同意，直接下发权限
            if (String.valueOf(Constant.NUMBER_1).equals(btn)) {
                //打印日志
                log.debug(TextUtils.format("生产者根据消息id{0},消息批复为同意并下发权限", id));
                try {
                    if (!StrUtils.isBlank(message.getApprule())) {
                        Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());
                        for (String s : decode.keySet()) {
                            if (s.equals(messageComment.getApiid())) {
                                MessageExample messageExample = new MessageExample();
                                messageExample.createCriteria().andIdEqualTo(message.getId());
                                Map value = (Map) decode.get(s);
                                //修改此条api生产者处理状态为2（同意 ）
                                value.put("PDeal", "2");

                                decode.put(messageComment.getApiid(), value);
                                message.setApprule(JsonUtils.toJson(decode));
                                message.setIsread(Constant.NUMBER_0);
                                messageMapper.updateByExample(message, messageExample);
                            }
                        }
                    }
                    //给用户授权API的使用权限
                    if (String.valueOf(Constant.NUMBER_2).equals(message.getMessagetype())) {
                        try {
                            updateApiNumLimt(message, messageComment, Constant.NUMBER_1);

                            log.info(TextUtils.format("用户{0}申请的API已授权"), message.getSenderid());
                        } catch (Exception e) {
                            log.error(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                    //给用户授权APP的使用权限
                    if (String.valueOf(Constant.NUMBER_3).equals(message.getMessagetype())) {
                        try {
                            updateAppUserMapComment(messageComment, Constant.NUMBER_1);
                            log.info(TextUtils.format("用户{0}申请的APP已授权"), message.getSenderid());
                        } catch (Exception e) {
                            log.error(e.getMessage());
                            e.printStackTrace();
                        }
                    }

                    //触发此方法时将处理状态修改为4（已完成）
                    messageComment.setContent(content);
                    messageComment.setIsdeal(Constant.NUMBER_4);
                    messageComment.setDealtime(new Date());
                    messageCommentMapper.updateByExample(messageComment, messageCommentExample);
                    log.info("/***生产者批复意见为“同意”**/");
                    return true;
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return false;
                }
            }

            //如果btn的值为2，则批复为同意，但api还在开发中，上线后可使用
            if (String.valueOf(Constant.NUMBER_2).equals(btn)) {
                log.debug(TextUtils.format("生产者根据消息id{0},消息批复为“开发中”", id));
                try {

                    //触发此方法时将message表中isDeal该为3（开发中）
                    MessageExample messageExample = new MessageExample();
                    messageExample.createCriteria().andIdEqualTo(message.getId());
                    message.setIsdeal(String.valueOf(Constant.NUMBER_3));
                    message.setIsread(Constant.NUMBER_0);
                    messageMapper.updateByExample(message, messageExample);

                    messageComment.setContent(content);
                    //将messageComment表中的isDeal改为3,（开发中）
                    messageComment.setIsdeal(Constant.NUMBER_3);
                    //设置处理时间
                    messageComment.setDealtime(new Date());
                    //设置开发开始时间
                    messageComment.setDevbegintime(new Date());
                    messageCommentMapper.updateByExample(messageComment, messageCommentExample);
                    return true;
                } catch (Exception e) {
                    log.error(e.getMessage());
                    return false;
                }
            }

            //如果btn等于3，即批复为拒绝
            if (String.valueOf(Constant.NUMBER_3).equals(btn)) {
                //判断apiid是否为空，如果为空则是批复“写信”，不为空批复的是申请类消息
                String apiid = messageComment.getApiid();
                if ("null".equals(apiid)) {
                    log.debug(TextUtils.format("生产者根据消息id{0},消息批复为拒绝", id));
                    try {

                        //触发此方法时将message表中isDeal该为2（拒绝）
                        MessageExample messageExample = new MessageExample();
                        messageExample.createCriteria().andIdEqualTo(message.getId());
                        message.setIsdeal(String.valueOf(Constant.NUMBER_2));
                        message.setIsread(Constant.NUMBER_0);
                        messageMapper.updateByExample(message, messageExample);

                        messageComment.setContent(content);
                        //触发此方法时将处理状态修改为2（拒绝）
                        messageComment.setIsdeal(Constant.NUMBER_2);
                        //设置处理时间
                        messageComment.setDealtime(new Date());
                        messageCommentMapper.updateByExample(messageComment, messageCommentExample);
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                    //拒绝已有api的使用权限
                } else {
                    log.debug(TextUtils.format("生产者根据消息id{0},消息批复为拒绝", id));
                    try {

                        //根据生产者批复意见修改message表中的PDeal
                        if (!StrUtils.isBlank(message.getApprule())) {
                            Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());
                            for (String s : decode.keySet()) {
                                if (s.equals(messageComment.getApiid())) {
                                    MessageExample messageExample = new MessageExample();
                                    messageExample.createCriteria().andIdEqualTo(message.getId());
                                    Map value = (Map) decode.get(s);
                                    //修改此条api生产者处理状态为1（拒绝）
                                    value.put("PDeal", "1");
                                    //修改APPRule字段
                                    decode.put(messageComment.getApiid(), value);
                                    message.setApprule(JsonUtils.toJson(decode));
                                    message.setIsread(Constant.NUMBER_0);
                                    messageMapper.updateByExample(message, messageExample);
                                }
                            }
                        }

                        //修改用户申请API的使用权限为拒绝
                        if (String.valueOf(Constant.NUMBER_2).equals(message.getMessagetype())) {
                            try {
                                updateApiNumLimt(message, messageComment, Constant.NUMBER_4);
                                log.info(TextUtils.format("用户{0}申请的API已拒绝"), message.getSenderid());
                            } catch (Exception e) {
                                log.error(e.getMessage());
                                e.printStackTrace();
                            }
                        }
                        //修改用户申请APP的使用权限为拒绝
                        if (String.valueOf(Constant.NUMBER_3).equals(message.getMessagetype())) {
                            try {
                                updateAppUserMapComment(messageComment, Constant.NUMBER_4);
                                log.info(TextUtils.format("用户{0}申请的APP已拒绝"), message.getSenderid());
                            } catch (Exception e) {
                                log.error(e.getMessage());
                                e.printStackTrace();
                            }
                        }

                        //拒绝原因
                        messageComment.setRc2(content);
                        //触发此方法时将处理状态修改为2（拒绝）
                        messageComment.setIsdeal(Constant.NUMBER_2);
                        messageComment.setDealtime(new Date());
                        messageCommentMapper.updateByExample(messageComment, messageCommentExample);
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                }
            }

            if (String.valueOf(Constant.NUMBER_4).equals(btn)) {

                String apiid = messageComment.getApiid();
                if ("null".equals(apiid)) {
                    log.debug(TextUtils.format("生产者根据消息id{0},消息批复为拒绝", id));
                    try {

                        //触发此方法时将message表中isDeal该为4（完成）
                        MessageExample messageExample = new MessageExample();
                        messageExample.createCriteria().andIdEqualTo(message.getId());
                        message.setIsdeal(String.valueOf(Constant.NUMBER_4));
                        message.setIsread(Constant.NUMBER_0);
                        messageMapper.updateByExample(message, messageExample);

                        messageComment.setContent(content);
                        //触发此方法时将处理状态修改为4（已完成）
                        messageComment.setIsdeal(Constant.NUMBER_4);
                        //设置处理时间
                        messageComment.setDealtime(new Date());
                        messageCommentMapper.updateByExample(messageComment, messageCommentExample);
                        return true;
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        } finally {
            log.info("/***消费者和管理者看到的消息状态根据生产者批复所有消息的状态修改，默认优先级：0未处理，1拒绝，2同意**/");
            //如果APIRule不为空，则根据所有PDeal的值修改message表中的isdeal字段
            if (!StrUtils.isBlank(message.getApprule())) {
                //创建工具，存放解析后的APPRule值
                List<Map<String, Object>> list = new ArrayList();
                //解析APPRule
                Map decode = (Map) JSONDecoder.decode(message.getApprule());
                //循环解析后的map
                Iterator iter = decode.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    //将所有APPRule解析为map后的value值存入list中
                    list.add((Map<String, Object>) entry.getValue());
                }
                //创建工具，存放所有PDeal的value值
                List pDealList = new ArrayList();
                for (Map<String, Object> map : list) {
                    //将所有APPRule的value值存入pDealList中
                    String pdeal = map.get("PDeal").toString();
                    pDealList.add(pdeal);
                }
                //将pDealList中的所有pdeal排序（从小到大）
                Collections.sort(pDealList);
                //创建修改条件
                MessageExample messageExample = new MessageExample();
                messageExample.createCriteria().andIdEqualTo(message.getId());
                //如果第一个PDeal是0，则消息改为未处理（message的isdeal为0）状态
                if (String.valueOf(Constant.NUMBER_0).equals(pDealList.get(0))) {
                    message.setIsdeal(String.valueOf(Constant.NUMBER_0));
                }
                //如果第一个PDeal是1，则消息改为已拒绝（message的isdeal为2）状态
                if (String.valueOf(Constant.NUMBER_1).equals(pDealList.get(0))) {
                    message.setIsdeal(String.valueOf(Constant.NUMBER_2));
                }
                //如果第一个PDeal是2，则消息改为同意（message的isdeal为1）状态
                if (String.valueOf(Constant.NUMBER_2).equals(pDealList.get(0))) {
                    message.setIsdeal(String.valueOf(Constant.NUMBER_4));
                }
                messageMapper.updateByExample(message, messageExample);
            }
        }
        return true;
    }

    private void updateApiNumLimt(Message message, MessageComment messageComment, Integer status) {
        //根据用户id查询用户
        List<ApiNumLimt> apiNumLimts = apiManagerClientService.selectExample(message.getSenderid());
        for (ApiNumLimt apiNumLimt : apiNumLimts) {
            //如果用户id和Apiid都相符，则进行授权
            if (messageComment.getApiid().equals(apiNumLimt.getApiid())) {
                ApiNumLimt apiNumLimt1 = new ApiNumLimt();
                apiNumLimt1.setId(apiNumLimt.getId());
                apiNumLimt1.setAuditStatus(status);
                updateApiNumList(apiNumLimt1);
            }
        }
    }

    private void updateAppUserMap(Message message, Integer status) {
        //根据用户id查询授权中的信息
        List<AppUserMap> appUserMaps = appClientService.selectBySenderid(message.getSenderid());
        if (appUserMaps != null && !appUserMaps.isEmpty()) {
            Map<String, Object> decode = (Map<String, Object>) JSONDecoder.decode(message.getApprule());
            for (Map.Entry<String, Object> entry : decode.entrySet()) {
                //获取每一个APP的id
                String appId = entry.getKey().toString();
                for (AppUserMap appUserMap : appUserMaps) {
                    //如果消费者申请的app与查询到的appID一致，则将用户与app关系修改为“拒绝”
                    if (appId.equals(appUserMap.getAppid())) {
                        appClientService.updateSelective(status, message.getSenderid(), appUserMap.getAppid());
                    }
                }
            }
        }
    }

    private void updateAppUserMapComment(MessageComment messageComment, Integer status) {
        //根据用户id查询授权中的信息
        //查询用户与APP关系结果集
        List<AppUserMap> appUserMaps = appClientService.selectBySenderid(messageComment.getSenderid());
        if (appUserMaps != null && !appUserMaps.isEmpty()) {
            //获取APP的id
            String appId = messageComment.getApiid();
            //遍历用户与APP关系结果集
            for (AppUserMap appUserMap : appUserMaps) {
                //如果消费者申请的app与查询到的appID一致，则将用户与app关系修改为“拒绝”
                if (appId.equals(appUserMap.getAppid())) {
                    appClientService.updateSelective(status, messageComment.getSenderid(), appUserMap.getAppid());
                }
            }
        }
    }


    /**
     * 功能描述: 根据主键删除消息（可多选）
     *
     * @param id 主键（多个用逗号隔开）
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:50
     */
    @Override
    public boolean delMessage(String id) {
        log.debug(TextUtils.format("/***根据消息id{0},逻辑删除消息**/", id));
        //逻辑删除
        Message message = new Message();
        message.setId(id);
        message.setStatus(Constant.STRING_DEL_STATE);
        MessageExample MessageExample = new MessageExample();
        MessageExample.createCriteria().andIdEqualTo(id);
        return messageMapper.updateByExampleSelective(message, MessageExample) == 1 ? true : false;
    }

    /**
     * 功能描述: 根据主键删除回复消息（可多选）
     *
     * @param id 主键（多个用逗号隔开）
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:51
     */
    @Override
    public boolean delMessageComment(String id) {
        log.debug(TextUtils.format("/***根据消息回复id{0},逻辑删除消息回复**/", id));
        //逻辑删除
        MessageComment messageComment = new MessageComment();
        messageComment.setId(id);
        messageComment.setStatus(Constant.STRING_DEL_STATE);
        MessageCommentExample messageCommentExample = new MessageCommentExample();
        messageCommentExample.createCriteria().andIdEqualTo(id);
        return messageCommentMapper.updateByExampleSelective(messageComment, messageCommentExample) == 1 ? true : false;
    }

    /**
     * 功能描述: 根据id获取消息内容
     *
     * @param id id
     * @param:
     * @return: com.gla.datacenter.domain.Message
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @Override
    public Message getMessageById(String id) {

        if (StrUtils.isBlank(id)) {
            return null;
        }
        try {
            log.debug(TextUtils.format("根据消息id{0},获取消息", id));
            MessageExample messageExample = new MessageExample();
            messageExample.createCriteria().andIdEqualTo(id);
            List<Message> list = messageMapper.selectByExampleWithBLOBs(messageExample);
            //将查询到的消息修改为已读状态
            list.get(0).setIsread(Constant.NUMBER_1);
            messageMapper.updateByExample(list.get(0), messageExample);
            //查询到这条消息时，将状态标记为已读
            return list.size() > 0 ? list.get(0) : null;
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 功能描述: 根据id获取消息回复
     *
     * @param id id
     * @param:
     * @return: com.gla.datacenter.domain.MessageComment
     * @auther: zhengshien
     * @date: 2018/11/16 13:56
     */
    @Override
    public MessageComment getMessageCommentById(String id) {
        if (StrUtils.isBlank(id)) {
            log.info("/***参数异常：消息id为空**/");
            return null;
        }
        log.debug(TextUtils.format("/***根据消息回复的id{0},获取消息**/", id));
        MessageCommentExample messageCommentExample = new MessageCommentExample();
        messageCommentExample.createCriteria().andIdEqualTo(id);
        List<MessageComment> list = messageCommentMapper.selectByExampleWithBLOBs(messageCommentExample);
        if (!(list.size() == 0)) {
            //查询到这条消息时，将状态标记为已读
            //将查询到的消息修改为已读状态
            list.get(0).setIsread(Constant.NUMBER_1);
            messageCommentMapper.updateByExample(list.get(0), messageCommentExample);
            return list.size() > 0 ? list.get(0) : null;
        } else {
            log.info("/***此消息暂无回复，id{0}**/", id);
            return null;
        }
    }


    /**
     * 功能描述: 查询消息列表（不分页）
     *
     * @param message 消息实体（携带查询条件）
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @Override
    public List<Message> getMessageList(Message message) {
        //初始化Example
        MessageExample messageExample = new MessageExample();

        //创建查询条件
        MessageExample.Criteria criteria = messageExample.createCriteria();

        //根据消息状态查询所有消息
        if (!StrUtils.isBlank(message.getStatus())) {
            criteria.andStatusEqualTo(message.getStatus());
        }
        //根据消息类型查询所有消息
        if (!StrUtils.isBlank(message.getMessagetype())) {
            criteria.andMessagetypeEqualTo(message.getMessagetype());
        }
        //根据是否已读查询所有消息
        if (!StrUtils.isBlank(message.getIsread())) {
            criteria.andIsreadEqualTo(message.getIsread());
        }

        //根据是否已处理查询所有消息
        if (!StrUtils.isBlank(message.getIsdeal())) {
            criteria.andIsdealEqualTo(message.getIsdeal());
        }
        //根据优先级查询所有消息
        if (!StrUtils.isBlank(message.getLevel())) {
            criteria.andLevelEqualTo(Integer.parseInt(message.getIsdeal()));
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(message.getSenderid())) {
            criteria.andSenderidEqualTo(message.getSenderid());
        }
        //根据标题模糊查询所有消息
        if (!StrUtils.isBlank(message.getTitle())) {
            criteria.andTitleLike("%" + message.getTitle() + "%");
        }
        //按时间倒序排列
        if (!StrUtils.isBlank(message.getLpsort())) {
            messageExample.setOrderByClause(message.getLpsort());
        } else {
            messageExample.setOrderByClause("SENDTIME DESC ");
        }

        return messageMapper.selectByExampleWithBLOBs(messageExample);
    }

    /**
     * 功能描述: 查询消息回复列表（不分页）
     *
     * @param messageComment 回复消息实体（携带查询条件）
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @Override
    public List<MessageComment> getMessageCommentList(MessageComment messageComment) {
        //初始化Example
        MessageCommentExample messageCommentExample = new MessageCommentExample();

        //创建查询条件
        MessageCommentExample.Criteria criteria = messageCommentExample.createCriteria();

        //根据消息回复状态查询所有消息
        if (!StrUtils.isBlank(messageComment.getStatus())) {
            criteria.andStatusEqualTo(messageComment.getStatus());
        }

        //根据Fid查询所有消息
        if (!StrUtils.isBlank(messageComment.getFid())) {
            criteria.andFidEqualTo(messageComment.getFid());
        }

        //根据是否已读查询所有消息
        if (!StrUtils.isBlank(messageComment.getIsread())) {
            criteria.andIsreadEqualTo(messageComment.getIsread());
        }

        //根据是否已处理查询所有消息
        if (!StrUtils.isBlank(messageComment.getIsdeal())) {
            criteria.andIsdealEqualTo(messageComment.getIsdeal());
        }
        //根据优先级查询所有消息
        if (!StrUtils.isBlank(messageComment.getLevel())) {
            criteria.andLevelEqualTo(messageComment.getIsdeal());
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(messageComment.getSenderid())) {
            criteria.andSenderidEqualTo(messageComment.getSenderid());
        }

        //按时间倒序排列
        if (!StrUtils.isBlank(messageComment.getLpsort())) {
            messageCommentExample.setOrderByClause(messageComment.getLpsort());
        } else {
            messageCommentExample.setOrderByClause("IDT DESC ");
        }
        log.info("/** 查询消息回复列表（不分页）**/");
        return messageCommentMapper.selectByExampleWithBLOBs(messageCommentExample);
    }

    /**
     * 功能描述: 查询消息列表（分页）
     *
     * @param message  消息实体（携带查询条件）
     * @param dealList 消息处理状态
     * @param pager    分页参数
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @Override
    public Pager<Message> getMessagePageList(Message message, String[] dealList, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询消息列表【分页方法】"));
        if (dealList.length == Constant.NUMBER_0) {
            return new Pager<>();
        }
        //初始化Example
        MessageExample messageExample = new MessageExample();
        //设置分页对象
        messageExample.setPage(pager);
        //创建查询条件
        MessageExample.Criteria criteria = messageExample.createCriteria();

        //如果消息状态不为空，则根据消息状态查询消息列表
        if (!StrUtils.isBlank(message.getStatus())) {
            criteria.andStatusEqualTo(message.getStatus());
        } else {
            criteria.andStatusEqualTo(Constant.STRING_1);
        }
        //根据消息类型查询
        if (!StrUtils.isBlank(message.getMessagetype())) {
            String messagetype = message.getMessagetype();
            List<String> list = new ArrayList<>();
            String[] split = messagetype.split(",");
            for (String s : split) {
                list.add(s);
            }
            criteria.andMessagetypeIn(list);
        }
        //根据是否已读查询
        if (!StrUtils.isBlank(message.getIsread())) {
            criteria.andIsreadEqualTo(message.getIsread());
        }

        //根据receiverId查询
        /*if (!StrUtils.isBlank(message.getReceiverid())) {
            criteria.andReceiveridEqualTo(message.getReceiverid());
        }*/
        if(!StrUtils.isBlank(message.getReceiverid())){
            criteria.andReceiveridorSenderidEqualTo(message.getReceiverid());
        }

        //根据处理状态查询
        List<String> list = new ArrayList();
        for (String s : dealList) {
            list.add(s);
        }
        if (!StrUtils.isBlank(dealList)) {
            criteria.andIsdealIn(list);
        } else {
            criteria.andIsdealEqualTo(message.getIsdeal());
        }

        //根据优先级查询
        if (!StrUtils.isBlank(message.getLevel())) {
            criteria.andLevelEqualTo(Integer.parseInt(message.getIsdeal()));
        }
        //根据消息发送者查询
        if (!StrUtils.isBlank(message.getSenderid())) {
            criteria.andSenderidEqualTo(message.getSenderid());
        }
        //根据标题关键字模糊查询标题和内容
        if (!StrUtils.isBlank(message.getTitle())) {
            criteria.andTitleOrContentLike("%" + message.getTitle() + "%");
        }

        //按时间倒序排列
        if (!StrUtils.isBlank(message.getLpsort())) {
            messageExample.setOrderByClause(message.getLpsort());
        } else {
            messageExample.setOrderByClause("ISREAD ASC,SENDTIME DESC");
        }

        List<Message> messageList = messageMapper.selectByExampleWithBLOBsAddSenderName(messageExample);

        pager.setPagerInfo(messageList, messageMapper.countByExample(messageExample));

        return pager;

    }


    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Message表）
     *
     * @param: userid 用户ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @Override
    public Map getMessageDealCount(String userid) {
        try {
            log.info("根据消息处理意见查询每一种状态的消息的个数");
            return messageMapper.selectMessageDealCount(userid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数(Comment表)
     *
     * @param: userid 用户ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @Override
    public Map getCommentDealCount(String userid) {
        try {
            log.info("根据消息处理意见查询每一种状态的消息的个数");
            return messageMapper.selectCommentDealCount(userid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Map getManagerDealCount(String receiverid) {
        Map map = new LinkedHashMap();
        //查询已有API各个状态的个数
        Map map1 = messageMapper.selectManagerDealCount1(receiverid);
        /*Long totalNums1 = (Long) map1.get("TotalNums");
        Long num0Map1 = (Long) map1.get("num0");
        Long num1Map1 = (Long) map1.get("num1");
        Long num2Map1 = (Long) map1.get("num2");
        Long num3Map1 = (Long) map1.get("num3");
        Long num4Map1 = (Long) map1.get("num4");
        //查询写信API的各个状态的个数
        Map map2 = messageMapper.selectManagerDealCount2();
        Long totalNums2 = (Long) map2.get("TotalNums");
        Long num0Map2 = (Long) map2.get("num0");
        Long num1Map2 = (Long) map2.get("num1");
        Long num2Map2 = (Long) map2.get("num2");
        Long num3Map2 = (Long) map2.get("num3");
        Long num4Map2 = (Long) map2.get("num4");
        //存入集合中
        map.put("TotalNums", totalNums1 + totalNums2);
        map.put("num0", num0Map1 + num0Map2);
        map.put("num1", num1Map1 + num1Map2);
        map.put("num2", num2Map1 + num2Map2);
        map.put("num3", num3Map1 + num3Map2);
        map.put("num4", num4Map1 + num4Map2);*/

        return map1;
    }

    /**
     * 功能描述: 查询所有通知类型的消息个数
     *
     * @param userid 用户ID
     * @param:
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/17 15:55
     */
    @Override
    public int getNumOfInform(String userid) {
        try {
            log.info("查询所有通知类型的消息个数");
            return messageMapper.selectNumOfInform(userid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 功能描述: 查询消息回复列表（分页）
     *
     * @param messageComment 回复消息实体（携带查询条件）
     * @param dealList       消息处理状态
     * @param pager          分页参数
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @Override
    public Pager<MessageComment> getMessageCommentPageList(MessageComment messageComment, String[] dealList, Pager pager) {
        log.debug(TextUtils.format("根据条件,查询消息回复列表【分页方法】"));
        if (dealList.length == Constant.NUMBER_0) {
            return new Pager<>();
        }
        //初始化Example
        MessageCommentExample messageCommentExample = new MessageCommentExample();

        //设置分页对象
        messageCommentExample.setPage(pager);
        //创建查询条件
        MessageCommentExample.Criteria criteria = messageCommentExample.createCriteria();

        //如果消息回复状态正常，则根据消息状态查询消息回复列表
        if (!StrUtils.isBlank(messageComment.getStatus())) {
            criteria.andStatusEqualTo(messageComment.getStatus());
        } else {
            criteria.andStatusEqualTo(Constant.STRING_1);
        }
        //根据是否已读查询
        if (!StrUtils.isBlank(messageComment.getIsread())) {
            criteria.andIsreadEqualTo(messageComment.getIsread());
        }

        //根据receiverId查询
        if (!StrUtils.isBlank(messageComment.getReceiverid())) {
            criteria.andReceiveridEqualTo(messageComment.getReceiverid());
        }

        //根据处理状态查询
        List<Integer> list = new ArrayList();
        for (String s : dealList) {
            list.add(Integer.parseInt(s));
        }
        if (!StrUtils.isBlank(dealList)) {
            criteria.andIsdealIn(list);
        } else {
            criteria.andIsdealEqualTo(messageComment.getIsdeal());
        }

        //根据优先级查询
        if (!StrUtils.isBlank(messageComment.getLevel())) {
            criteria.andLevelEqualTo(messageComment.getLevel());
        }
        //根据标题关键字模糊查询标题和内容
        if (!StrUtils.isBlank(messageComment.getTitle())) {
            criteria.andTitleOrContentLike("%" + messageComment.getTitle() + "%");
        }

        //按时间倒序排列
        if (!StrUtils.isBlank(messageComment.getLpsort())) {
            messageCommentExample.setOrderByClause(messageComment.getLpsort());
        } else {
            messageCommentExample.setOrderByClause("ISREAD ASC,IDT DESC ");
        }


        List<MessageComment> messageCommentList = messageCommentMapper.selectByExampleWithBLOBsAddSenderName(messageCommentExample);

        pager.setPagerInfo(messageCommentList, messageCommentMapper.countByExample(messageCommentExample));

        return pager;

    }

    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    private JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(mailConfig.getHost());
        sender.setPort(mailConfig.getPort());
        sender.setUsername(mailConfig.getUsername());
        sender.setPassword(mailConfig.getPassword());
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", String.valueOf(mailConfig.getProperties().get("timeout")));
        p.setProperty("mail.smtp.auth", "false");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * 功能描述: 发送邮件至用户邮箱
     *
     * @param userEmail 用户邮箱
     * @param type      邮件类型
     * @param param     邮件内容
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:59
     */
    @Override
    public boolean sendEmail(String userEmail, String type, String param) {
        //创建模板查询对象
        ModelContentExample modelContentExample = new ModelContentExample();
        modelContentExample.createCriteria().andCodeEqualTo(type);
        List<ModelContent> list = modelContentMapper.selectByExample(modelContentExample);
        //获取模板
        ModelContent modelContent = list.get(0);
        try {
            JavaMailSenderImpl mailSender = createMailSender();
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            // 设置utf-8或GBK编码，否则邮件会有乱码
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom(mailConfig.getUsername(), String.valueOf(mailConfig.getProperties().get("company")));
            messageHelper.setTo(userEmail);
            messageHelper.setSubject(modelContent.getTitle());
            String[] params = param.split(",");
            Map<String, String> mapParam = new HashMap<String, String>();
            for (int i = 0; i < params.length; i++) {
                mapParam.put(i + "", params[i]);
            }
            messageHelper.setText(TextUtils.formatCode(modelContent.getContent(), mapParam), true);
            mailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }


    @Override
    public boolean save(Message entry) {
        return false;
    }

    @Override
    public Message get(String id) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Message> getList(Message entry) {
        return null;
    }

    @Override
    public Pager<Message> getPageList(Message entry, Pager pager) {
        return null;
    }
}
