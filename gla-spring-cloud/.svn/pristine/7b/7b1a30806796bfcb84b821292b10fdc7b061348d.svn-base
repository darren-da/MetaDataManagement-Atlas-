package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.MessageComment;
import com.gla.datacenter.service.MessageClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单信息
 */
@RestController
@Api(value = "消息中心", description = "消息中心")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageControllerFeign {
    private Logger LOG = LoggerFactory.getLogger(MessageControllerFeign.class);

    /**
     * 消息客户端Service
     */
    @Autowired
    private MessageClientService messageClientService;

    /**
     * 功能描述: 新增消息
     * @param:
     * @param message 消息实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:45
     */
    @ApiOperation(value = "新建消息", notes = "新建消息")
    @ApiImplicitParam(name = "message", value = "消息详细实体Message ", required = true, dataType = "Message")
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @Access(login = true)
    public String saveMessage(@RequestBody Message message) {
        LOG.debug(TextUtils.format("/***新增消息**/"));
        return this.messageClientService.saveMessage(message);
    }

    /**
     * 功能描述: 新增回复消息
     * @param:
     * @param messageComment 回复消息实体
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @ApiOperation(value = "新增回复消息", notes = "新增回复消息")
    @ApiImplicitParam(name = "messageComment", value = "消息详细实体MessageComment", required = true, dataType = "MessageComment")
    @RequestMapping(value = "/messageComment", method = RequestMethod.POST)
    @Access(login = true)
    public String saveMessageComment(@RequestBody MessageComment messageComment) {
        LOG.debug(TextUtils.format("/***新增消息回复**/"));
        return this.messageClientService.saveMessageComment(messageComment);
    }

    /**
     * 功能描述: 申请多条API（购物车）
     * @param:
     * @param message 消息实体
     * @param id apiid（多个用逗号隔开）
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:59
     */
    @RequestMapping(value = "/messageCart/{id}")
    @Access(login = true,operationLog = OPERATION.INSERT,operationIntro = "申请API")
    public String saveMessageCart(@RequestBody Message message, @PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***新增申请消息**/"));
        return messageClientService.saveMessageCart(message,id);
    }

    /**
     * 功能描述: 申请多条APP
     * @param:
     * @param message 消息实体
     * @param appid appid(多个有逗号隔开)
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/20 15:23
     */
    @RequestMapping(value = "/message/save/app/{id}",method = RequestMethod.POST)
    public String saveAppCart(@RequestBody Message message, @PathVariable("id") String appid) {
        LOG.debug(TextUtils.format("/***新增app申请消息**/"));
        return messageClientService.saveAppCart(message, appid);
    }

    /**
     * 功能描述: 修改消息状态（星标等）
     * @param:
     * @param message 回复消息实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @ApiOperation(value = "消息更新", notes = "消息更新")
    @ApiImplicitParam(name = "message", value = "消息详细实体Message ", required = true, dataType = "Message")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @Access(login = true)
    public String update(@RequestBody Message message) {
        LOG.debug(TextUtils.format("/***更新用户信息**/"));
        return this.messageClientService.update(message);
    }

    /**
     * 功能描述: 修改回复消息状态（星标等）
     * @param:
     * @param messageComment 回复消息实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @RequestMapping(value = "/updateComment",method= RequestMethod.PUT)
    @Access(login = true)
    public String updateComment(@RequestBody MessageComment messageComment) {
        LOG.debug(TextUtils.format("/***更新用户信息**/"));
        return this.messageClientService.updateComment(messageComment);
    }

    /**
     * 功能描述: 大数据中心批复申请消息
     * @param:
     * @param id      id
     * @param btn     批复意见
     * @param content 批复内容
     * @param level   优先级
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:48
     */
    @ApiOperation(value = "大数据中心批复消息", notes = "大数据中心批复消息")
    @ApiImplicitParam(name = "id，btn，content", value = "消息id，回复意见，回复内容 ", required = true, dataType = "String，String，String")
    @RequestMapping(value = "/updateMessage", method = RequestMethod.GET)
    @Access(login = true)
    public String updateMessage(@RequestParam(name = "id", required = true) String id,
                                @RequestParam(name = "btn", required = true) String btn,
                                @RequestParam(name = "content", required = false) String content,
                                @RequestParam(name = "level",required = false) Integer level) {
        LOG.debug(TextUtils.format("/***批复消息**/"));
        return this.messageClientService.updateMessage(id, btn, content,level);
    }

    /**
     * 功能描述: 管理者处理APP申请消息
     * @param:
     * @param id 消息ID
     * @param optinion 处理意见
     * @param content 拒绝理由
     * @param level 优先级
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/25 9:09
     */
    @RequestMapping(value = "/message/deal/app")
    public String dealMessageApp(@RequestParam(name = "id", required = true) String id,
                                 @RequestParam(name = "optinion", required = true) String optinion,
                                 @RequestParam(name = "content", required = false) String content,
                                 @RequestParam(name = "level", required = false) Integer level) {
        LOG.debug(TextUtils.format("/***批复消息**/"));
        return this.messageClientService.dealMessageApp(id, optinion, content, level);
    }

    /**
     * 功能描述: 生产者批复申请消息
     * @param:
     * @param id id
     * @param btn 批复意见
     * @param content 批复内容
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:49
     */
    @ApiOperation(value = "生产者批复消息", notes = "生产者批复消息")
    @ApiImplicitParam(name = "id，btn，content", value = "消息id，回复意见，回复内容 ", required = true, dataType = "String，String，String")
    @RequestMapping(value = "/updateMessageComment", method = RequestMethod.GET)
    @Access(login = true,operationLog = OPERATION.SELECT,operationIntro = "生产者批复申请")
    public String updateMessageComment(@RequestParam(name = "id", required = true) String id,
                                       @RequestParam(name = "btn", required = true) String btn,
                                       @RequestParam(name = "content", required = false) String content) {

        LOG.debug(TextUtils.format("/***更新消息回复**/"));
        return this.messageClientService.updateMessageComment(id, btn, content);
    }

    /**
     * 功能描述: 生产者完成API开发
     * @param:
     * @param apiid apiid
     * @param commentid 消息id
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @RequestMapping(value = "/APIComplete",method = RequestMethod.GET)
    @Access(login = true)
    public String APIComplete(@RequestParam("apiid") String apiid,@RequestParam("commentid") String commentid ) {
        LOG.debug(TextUtils.format("/***API完成，将API消息回显**/"));
        return this.messageClientService.APIComplete(apiid, commentid);

    }

    /**
     * 功能描述: 消息流转
     * @param:
     * @param id 消息id
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @RequestMapping(value = "/messagePosition/{id}",method= RequestMethod.GET)
    @Access(login = true)
    public String messagePosition(@PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***根据消息id{0}，获取消息流转位置**/", id));
       return  messageClientService.messagePosition(id);

    }

    /**
     * 功能描述: 根据主键删除消息（可多选）
     * @param:
     * @param id 主键（多个用逗号隔开）
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:50
     */
    @ApiOperation(value = "删除消息", notes = "根据id删除消息")
    @ApiImplicitParam(name = "id", value = "消息id ", required = true, dataType = "String")
    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    @Access(login = true)
    public String delMessage(@PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***根据消息id{0}，删除消息记录**/", id));
        return this.messageClientService.delMessage(id);
    }

    /**
     * 功能描述: 根据主键删除回复消息（可多选）
     * @param:
     * @param id 主键（多个用逗号隔开）
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:51
     */
    @ApiOperation(value = "删除消息回复", notes = "根据id删除消息回复")
    @ApiImplicitParam(name = "id", value = "回复消息id ", required = true, dataType = "String")
    @RequestMapping(value = "/messageComment/{id}", method = RequestMethod.DELETE)
    @Access(login = true)
    public String delMessageComment(@PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***根据消息回复id{0}，删除消息记录**/", id));
        return this.messageClientService.delMessageComment(id);
    }

    /**
     * 功能描述: 根据id获取消息内容
     * @param:
     * @param id id
     * @return: com.gla.datacenter.domain.Message
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @ApiOperation(value = "查询消息", notes = "根据id精确查询消息")
    @ApiImplicitParam(name = "id", value = "消息id ", required = true, dataType = "String")
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    @Access(login = true)
    public String getMessageById(@PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***根据消息id{0}，获取消息**/", id));
        return this.messageClientService.getMessageById(id);
    }

    /**
     * 功能描述: 根据id获取消息回复
     * @param:
     * @param id id
     * @return: com.gla.datacenter.domain.MessageComment
     * @auther: zhengshien
     * @date: 2018/11/16 13:56
     */
    @ApiOperation(value = "查询回复消息", notes = "根据id精确查询回复消息")
    @ApiImplicitParam(name = "id", value = "回复消息id ", required = true, dataType = "String")
    @RequestMapping(value = "/messageComment/{id}", method = RequestMethod.GET)
    @Access(login = true)
    public String getMessageCommentById(@PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***根据消息回复id{0}，获取消息回复**/", id));
        return this.messageClientService.getMessageCommentById(id);
    }

    /**
     * 功能描述: 查询消息列表（不分页）
     * @param:
     * @param message 消息实体（携带查询条件）
     * @return: java.util.List<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @ApiOperation(value = "查询所有消息", notes = "根据条件查询所有消息")
    @ApiImplicitParam(name = "message", value = "查询条件 ", required = true, dataType = "Message")
    @RequestMapping(value = "/messageList", method = RequestMethod.GET)
    @Access(login = true)
    public String selectMessageList(Message message) {
        LOG.debug(TextUtils.format("/***查询所有消息,返回消息列表**/"));
        return this.messageClientService.selectMessageList(message);
    }

    /**
     * 功能描述: 查询消息回复列表（不分页）
     * @param:
     * @param messageComment 回复消息实体（携带查询条件）
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @ApiOperation(value = "查询所有回复消息", notes = "根据条件查询所有回复消息")
    @ApiImplicitParam(name = "messageCommentList", value = "查询条件 ", required = true, dataType = "MessageComment")
    @RequestMapping(value = "/messageCommentList", method = RequestMethod.GET)
    @Access(login = true)
    public String selectMessageCommentList(MessageComment messageComment) {
        LOG.debug(TextUtils.format("/***查询所有消息,返回消息列表**/"));
        return this.messageClientService.selectMessageCommentList(messageComment);
    }

    /**
     * 功能描述: 查询消息列表（分页）
     * @param:
     * @param message   消息实体（携带查询条件）
     * @param dealList  消息处理状态
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @ApiOperation(value = "查询所有消息（分页）", notes = "根据条件查询所有消息并进行分页展示")
    @ApiImplicitParam(name = "message", value = "查询条件 ", required = true, dataType = "Message")
    @RequestMapping(value = "/messagePageList")
    @Access(login = true)
    public String getMessagePageList(Message message,@RequestParam( name = "dealList",required = false) String[] dealList) {
        LOG.debug(TextUtils.format("/***查询消息,返回消息列表**/"));
        return this.messageClientService.getMessagePageList(message,dealList);
    }

    /**
     * 功能描述: 查询消息回复列表（分页）
     * @param:
     * @param messageComment 回复消息实体（携带查询条件）
     * @param dealList       消息处理状态
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @ApiOperation(value = "查询所有回复消息（分页）", notes = "根据条件查询所有消息回复并进行分页")
    @ApiImplicitParam(name = "messageCommentList", value = "查询条件 ", required = true, dataType = "MessageComment")
    @RequestMapping(value = "/messageCommentPageList", method = RequestMethod.GET)
    @Access(login = true)
    public String getMessageCommentPageList(MessageComment messageComment,String[] dealList) {
        LOG.debug(TextUtils.format("/***查询消息,返回消息列表**/"));
        return this.messageClientService.getMessageCommentPageList(messageComment,dealList);
    }

    /**
     * 功能描述: 消息批量标记为已读
     * @param:
     * @param ids ID集合
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/21 10:17
     */
    @RequestMapping(value = "/markRead/{ids}",method = RequestMethod.PUT)
    public String markRead(@PathVariable("ids") String ids){
        return this.messageClientService.markRead(ids);
    }

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Message表）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @RequestMapping(value = "/getMessageDealCount")
    @Access(login = true)
    public String getMessageDealCount(@RequestParam("userid") String userid) {
        LOG.debug(TextUtils.format("/***根据消息处理意见查询每一种状态的消息的个数（Message表）**/"));
        return this.messageClientService.getMessageDealCount(userid);
    }

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Comment表）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @RequestMapping(value = "/getCommentDealCount")
    @Access(login = true)
    public String selectCommentDealCount(@RequestParam("userid") String userid){
        LOG.debug(TextUtils.format("/***根据消息处理意见查询每一种状态的消息的个数（Comment表）**/"));
        return this.messageClientService.getCommentDealCount(userid);
    }

    /**
     * 功能描述: 管理者查看各个处理意见的消息数量
     * @param:
     * @param receiverid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/25 9:50
     */
    @RequestMapping(value = "/getManagerDealCount")
    @Access(login = true)
    public String getManagerDealCount(@RequestParam("receiverid") String receiverid) {
        LOG.debug(TextUtils.format("/***管理者{0}查看各个处理意见的消息数量（Comment表）**/",receiverid));
        return messageClientService.getManagerDealCount(receiverid);
    }

    /**
     * 功能描述: 查询所有通知类型的消息个数
     * @param:
     * @param userid 用户ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/17 15:58
     */
    @RequestMapping(value = "/getNumOfInform")
    @Access(login = true)
    public String getNumOfInform(@RequestParam("userid") String userid) {
        LOG.debug(TextUtils.format("/***查询所有通知类型的消息个数**/"));
        return messageClientService.getNumOfInform(userid);
    }

    /**
     * 功能描述: 发送邮件至用户邮箱
     * @param:
     * @param userEmail 用户邮箱
     * @param type 邮件类型
     * @param param 邮件内容
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:59
     */
    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    @Access(login = true)
    public String sendEmail(@RequestParam(name = "userEmail",required = false) String userEmail,
                            @RequestParam(name = "type") String type,
                            @RequestParam(name = "param",required = false)String param) throws Exception {
        LOG.debug(TextUtils.format("/***发送验证码至用户邮箱：{0}**/"),userEmail);
        return this.messageClientService.sendEmail(userEmail,type,param);
    }

}
