package com.gla.datacenter.controller;

import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.MessageComment;
import com.gla.datacenter.service.MessageService;
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
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class MessageController{
    private Logger log = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    MessageService messageService;
    /**
     * 设置默认页面显示的条数
     */
    public static final Integer DEFAULT_ROW = 10;


    /**
     * 功能描述: 新增消息
     *
     * @param message 消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:45
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String saveMessage(@RequestBody Message message) {
        log.debug(TextUtils.format("/***新增消息**/"));
        Boolean flay = messageService.saveMessage(message);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
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
    @RequestMapping(value = "/messageComment", method = RequestMethod.POST)
    public String saveMessageComment(@RequestBody MessageComment messageComment) {
        log.debug(TextUtils.format("/***新增消息回复**/"));
        Boolean flay = messageService.saveMessageComment(messageComment);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 申请多条API（购物车）
     *
     * @param message 消息实体
     * @param appid      apiid（多个用逗号隔开）
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:59
     */
    @RequestMapping(value = "/messageCart/{id}")
    public String saveMessageCart(@RequestBody Message message, @PathVariable("id") String appid) {
        log.debug(TextUtils.format("/***新增api申请消息**/"));
        return messageService.saveMessageCart(message, appid);
    }

    /**
     * 功能描述: 申请多条APP
     * @param:
     * @param message 消息实体
     * @param appid appid（多个用逗号隔开）
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/20 15:23
     */
    @RequestMapping(value = "/message/save/app/{appid}")
    public String saveAppCart(@RequestBody Message message, @PathVariable("appid") String appid) {
        log.debug(TextUtils.format("/***新增app申请消息**/"));
        return messageService.saveAppCart(message,appid);
    }



    /**
     * 功能描述: 修改回复消息状态（星标等）
     *
     * @param message 回复消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody Message message) {
        log.debug(TextUtils.format("/***更新用户信息**/"));
        Boolean flay = messageService.update(message);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 修改回复消息状态（星标等）
     *
     * @param messageComment 回复消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @RequestMapping(value = "/updateComment", method = RequestMethod.PUT)
    public String updateComment(@RequestBody MessageComment messageComment) {
        log.debug(TextUtils.format("/***更新用户信息**/"));
        Boolean flay = messageService.updateComment(messageComment);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 大数据中心批复申请消息
     *
     * @param id      id
     * @param btn     批复意见
     * @param content 批复内容
     * @param level   优先级
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:48
     */
    @RequestMapping(value = "/updateMessage")
    public String updateMessage(@RequestParam(name = "id", required = true) String id,
                                @RequestParam(name = "btn", required = true) String btn,
                                @RequestParam(name = "content", required = false) String content,
                                @RequestParam(name = "level", required = false) Integer level) {
        log.debug(TextUtils.format("/***批复api申请消息**/"));
        Boolean flay = messageService.updateMessage(id, btn, content, level);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
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
        log.debug(TextUtils.format("/***批复app申请消息**/"));
        Boolean flay = messageService.dealMessageApp(id, optinion, content, level);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 管理者处理资源目录审核消息
     * @param:
     * @param id
     * @param optinion
     * @param content
     * @param level
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/28 14:55
     */
    @RequestMapping(value = "/message/deal/resDirectory")
    public String dealMessageResDirectory(@RequestParam(name = "id", required = true) String id,
                                 @RequestParam(name = "optinion", required = true) String optinion,
                                 @RequestParam(name = "content", required = false) String content,
                                 @RequestParam(name = "level", required = false) Integer level) {
        log.debug(TextUtils.format("/***批复资源目录审核消息**/"));
        Boolean flay = messageService.dealMessageResDirectory(id, optinion, content, level);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 功能描述: 生产者批复申请消息
     *
     * @param id      id
     * @param btn     批复意见
     * @param content 批复内容
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:49
     */
    @RequestMapping(value = "/updateMessageComment")
    public String updateMessageComment(@RequestParam(name = "id", required = true) String id,
                                       @RequestParam(name = "btn", required = true) String btn,
                                       @RequestParam(name = "content", required = false) String content) {
        log.debug(TextUtils.format("/***更新消息回复**/"));
        Boolean flay = messageService.updateMessageComment(id, btn, content);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
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
    @RequestMapping(value = "/message/{id}", method = RequestMethod.DELETE)
    public String delMessage(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据消息id{0}，删除消息记录**/", id));
        String[] ids = id.split(Constant.DHAO);
        if (id.split(Constant.DHAO).length > DEFAULT_ROW) {
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY, "", "").getJson();
        }
        Boolean flay = true;
        for (String did : ids) {
            if (!messageService.delMessage(did)) {
                flay = false;
            }
        }
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
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
    @RequestMapping(value = "/messageComment/{id}", method = RequestMethod.DELETE)
    public String delMessageComment(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据消息回复id{0}，删除消息记录**/", id));
        String[] ids = id.split(Constant.DHAO);
        if (id.split(Constant.DHAO).length > DEFAULT_ROW) {
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY, "", "").getJson();
        }
        Boolean flay = true;
        for (String did : ids) {
            if (!messageService.delMessageComment(did)) {
                flay = false;
            }
        }
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
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
    @RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
    public String getMessageById(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据消息id{0}，获取消息**/", id));
        Message message = messageService.getMessageById(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, message, "").getJson();
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
    @RequestMapping(value = "/messageComment/{id}", method = RequestMethod.GET)
    public String getMessageCommentById(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据消息回复id{0}，获取消息回复**/", id));
        MessageComment messageComment = messageService.getMessageCommentById(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, messageComment, "").getJson();
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
    @RequestMapping(value = "/messagePosition/{id}")
    public String messagePosition(@PathVariable("id") String id) {
        log.debug(TextUtils.format("/***根据消息id{0}，获取消息流转位置**/", id));
        String message = messageService.messagePosition(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, message, "").getJson();
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
    @RequestMapping(value = "/messageList")
    public String selectMessageList(@RequestBody Message message) {
        log.debug(TextUtils.format("/***查询所有消息,返回消息列表**/"));
        List<Message> messageList = messageService.getMessageList(message);
        if (!StrUtils.isBlank(messageList)) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, messageList, "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
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
    @RequestMapping(value = "/messageCommentList")
    public String selectMessageCommentList(@RequestBody MessageComment messageComment) {
        log.debug(TextUtils.format("/***查询所有消息,返回消息列表**/"));
        List<MessageComment> messageCommentList = messageService.getMessageCommentList(messageComment);
        if (!StrUtils.isBlank(messageCommentList)) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, messageCommentList, "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }


    /**
     * 功能描述: 查询消息列表（分页）
     *
     * @param message 消息实体（携带查询条件）
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @RequestMapping(value = "/messagePageList")
    public String getMessagePageList(@RequestBody Message message ,@RequestParam(name = "dealList",required = false) String[] dealList) {
        log.debug(TextUtils.format("/***查询消息,返回消息列表**/"));
        Pager<Message> messagePager = messageService.getMessagePageList(message,dealList,message.getPager());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, messagePager, "").getJson();
    }

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Message表）
     *
     * @param: userid用户ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @RequestMapping(value = "/getMessageDealCount")
    public String getMessageDealCount(@RequestParam("userid") String userid) {
        Map dealCount = messageService.getMessageDealCount(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, dealCount, "").getJson();
    }

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Comment表）
     *
     * @param: userid用户ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @RequestMapping(value = "/getCommentDealCount")
    public String getCommentDealCount(@RequestParam("userid") String userid) {
        Map dealCount = messageService.getCommentDealCount(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, dealCount, "").getJson();
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
    public String getManagerDealCount(@RequestParam("receiverid") String receiverid) {
        Map dealCount = messageService.getManagerDealCount(receiverid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, dealCount, "").getJson();
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
    public String getNumOfInform(@RequestParam("userid") String userid) {
        int numOfInform = messageService.getNumOfInform(userid);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, numOfInform, "").getJson();
    }

    /**
     * 功能描述: 查询消息回复列表（分页）
     *
     * @param messageComment 回复消息实体（携带查询条件）
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @RequestMapping(value = "/messageCommentPageList")
    public String getMessageCommentPageList(@RequestBody MessageComment messageComment,@RequestParam(name = "dealList",required = false) String[] dealList) {
        log.debug(TextUtils.format("/***查询消息,返回消息列表**/"));
        Pager<MessageComment> messageCommentPager = messageService.getMessageCommentPageList(messageComment,dealList,messageComment.getPager());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, messageCommentPager, "").getJson();
    }

    /**
     * 功能描述: 消息批量标记为已读
     * @param:
     * @param ids ID集合
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/21 10:17
     */
    @RequestMapping(value = "/markRead/{ids}")
    public String markRead(@PathVariable("ids")String ids){
        boolean flag = messageService.markRead(ids);
        if (flag){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }else {
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
        }
    }

    /**
     * 功能描述: 生产者完成API开发
     *
     * @param apiid     apiid
     * @param commentid 消息id
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @RequestMapping(value = "/APIComplete")
    public String APIComplete(@RequestParam("apiid") String apiid, @RequestParam("commentid") String commentid) {
        log.debug(TextUtils.format("/***API完成，将API消息回显**/"));
        Boolean flay = messageService.APIComplete(apiid, commentid);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
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
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String sendEmail(@RequestParam(name = "userEmail", required = false) String userEmail,
                            @RequestParam(name = "type") String type,
                            @RequestParam(name = "param", required = false) String param) throws Exception {
        log.debug(TextUtils.format("/***发送验证码至用户邮箱：{0}**/"), userEmail);
        Boolean flay = messageService.sendEmail(userEmail, type, param);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();
    }


    /**
     * 功能描述: 模板查询（远程调用专用）
     * @param:
     * @param code 模板编码
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/4/1 15:51
     */
    @RequestMapping(value = "/selectModelContent")
    public String selectModelContent(@RequestParam("code") String code) {
        log.debug(TextUtils.format("/***根据编码{0}查询模板**/"),code);
       return messageService.selectModelContent(code);
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
