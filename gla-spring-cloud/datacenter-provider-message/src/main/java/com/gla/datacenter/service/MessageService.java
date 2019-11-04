package com.gla.datacenter.service;

import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.MessageComment;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

import java.util.List;
import java.util.Map;

public interface MessageService extends AbstractService<Message> {

    /**
     * 功能描述: 新增消息
     *
     * @param message 消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:45
     */
    boolean saveMessage(Message message);

    /**
     * 功能描述: 新增回复消息
     *
     * @param messageComment 回复消息实体
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    Boolean saveMessageComment(MessageComment messageComment);

    /**
     * 功能描述: 修改回复消息状态（星标等）
     *
     * @param entry 回复消息实体
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    boolean updateComment(MessageComment entry);

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
    boolean updateMessage(String id, String btn, String content, Integer level);

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
    Boolean updateMessageComment(String id, String btn, String content);

    /**
     * 功能描述: 根据主键删除消息（可多选）
     *
     * @param did 主键（多个用逗号隔开）
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:50
     */
    boolean delMessage(String did);

    /**
     * 功能描述: 根据主键删除回复消息（可多选）
     *
     * @param did 主键（多个用逗号隔开）
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:51
     */
    boolean delMessageComment(String did);

    /**
     * 功能描述: 根据id获取消息内容
     *
     * @param id id
     * @param:
     * @return: com.gla.datacenter.domain.Message
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    Message getMessageById(String id);

    /**
     * 功能描述: 查询消息列表（分页）
     *
     * @param message 消息实体（携带查询条件）
     * @param pager   分页参数
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    Pager<Message> getMessagePageList(Message message, String[] dealList, Pager pager);

    /**
     * 功能描述: 查询消息列表（不分页）
     *
     * @param message 消息实体（携带查询条件）
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    List<Message> getMessageList(Message message);

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Message表）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    Map getMessageDealCount(String userid);

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Comment表）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    Map getCommentDealCount(String userid);

    /**
     * 功能描述:
     * @param:
     * @param userid
     * @return: java.util.Map
     * @auther: zhengshien
     * @date: 2018/12/24 17:24
     */
    Map getManagerDealCount(String userid);

    /**
     * 功能描述: 查询通知消息数量
     * @param:
     * @param userid
     * @return: int
     * @auther: zhengshien
     * @date: 2018/12/24 17:23
     */
    int getNumOfInform(String userid);

    /**
     * 功能描述: 查询消息回复列表（分页）
     *
     * @param messageComment 回复消息实体（携带查询条件）
     * @param pager          分页参数
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    Pager<MessageComment> getMessageCommentPageList(MessageComment messageComment, String[] dealList, Pager pager);

    /**
     * 功能描述: 查询消息回复列表（不分页）
     *
     * @param messageComment 回复消息实体（携带查询条件）
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    List<MessageComment> getMessageCommentList(MessageComment messageComment);

    /**
     * 功能描述: 根据id获取消息回复
     *
     * @param id id
     * @param:
     * @return: com.gla.datacenter.domain.MessageComment
     * @auther: zhengshien
     * @date: 2018/11/16 13:56
     */
    MessageComment getMessageCommentById(String id);

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
    boolean sendEmail(String userEmail, String type, String param) throws Exception;

    /**
     * 功能描述: 申请多条API（购物车）
     *
     * @param message 消息实体
     * @param apiid   apiid（多个用逗号隔开）
     * @param:
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:59
     */
    String saveMessageCart(Message message, String apiid);

    /**
     * 功能描述: 消息流转
     *
     * @param id 消息id
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    String messagePosition(String id);

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
    boolean APIComplete(String apiid, String commentId);

    /**
     * 功能描述: 申请多条APP
     * @param:
     * @param message 消息实体
     * @param appid appid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/20 16:13
     */
    String saveAppCart(Message message, String appid);

    /**
     * 功能描述: 管理者处理APP申请消息
     * @param:
     * @param appid
     * @param optinion 管理者处理意见
     * @param content 意见文字描述
     * @param level 优先级
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/2/20 16:14
     */
    Boolean dealMessageApp(String appid, String optinion, String content, Integer level);

    /**
     * 功能描述: 管理者处理资源目录审核消息
     * @param:
     * @param id
     * @param optinion
     * @param content
     * @param level
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/2/28 14:54
     */
    Boolean dealMessageResDirectory(String id, String optinion, String content, Integer level);

    /**
     * 功能描述: 消息发送工具
     * @param:
     * @param content 消息内容
     * @param receiverid 收件人
     * @param senderid 发件人
     * @param title 标题
     * @return: void
     * @auther: zhengshien
     * @date: 2019/3/19 16:34
     */
    public String sendMessage(String content, String receiverid, String senderid, String title);

    /**
     * 功能描述: 将批量消息标记为已读
     * @param:
     * @return: boolean
     * @auther: zhengshien
     * @date: 2019/3/21 10:04
     */
    boolean markRead(String ids);

    String selectModelContent(String code);
}
