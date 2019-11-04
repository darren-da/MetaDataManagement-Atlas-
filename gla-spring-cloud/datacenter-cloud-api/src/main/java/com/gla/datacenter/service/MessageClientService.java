
package com.gla.datacenter.service;

import com.gla.datacenter.domain.ApiCatalogChange;
import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.MessageComment;
import com.gla.datacenter.service.fallback.MessageClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author:shinians email:shiniandate@163.com
 * @date:Created in 19:43 2018/9/23
 * @modified By:
 * @Description:
   根据已经有的MessageClientService接口新建一个实现了FallbackFactory接口的类MessageClientServiceFallbackFactory
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api3",fallbackFactory=MessageClientServiceFallbackFactory.class)
//@RequestMapping("/api3")
public interface MessageClientService {

    /**
     * 功能描述: 新增消息
     * @param:
     * @param message 消息实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:45
     */
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String saveMessage(@RequestBody Message message);

    /**
     * 功能描述: 新增回复消息
     * @param:
     * @param messageComment 回复消息实体
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @RequestMapping(value = "/messageComment", method = RequestMethod.POST)
    public String saveMessageComment(@RequestBody MessageComment messageComment);

    /**
     * 功能描述: 修改回复消息状态（星标等）
     * @param:
     * @param message 回复消息实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @RequestMapping(value = "/update",method= RequestMethod.PUT)
    public String update(@RequestBody Message message);

    /**
     * 功能描述: 修改回复消息状态（星标等）
     * @param:
     * @param messageComment 回复消息实体
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:46
     */
    @RequestMapping(value = "/updateComment",method= RequestMethod.PUT)
    public String updateComment(@RequestBody MessageComment messageComment);

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
    public String saveMessageCart(@RequestBody Message message, @PathVariable("id") String id);

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
    @RequestMapping(value = "/updateMessage")
    public String updateMessage(@RequestParam(name = "id",required = true) String id,
                                @RequestParam(name = "btn",required = true) String btn,
                                @RequestParam(name = "content",required = false) String content,
                                @RequestParam(name = "level",required = false) Integer level);

    /**
     * 功能描述: 生产者完成API开发
     * @param:
     * @param apiid apiid
     * @param commentid 消息id
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @RequestMapping(value = "/APIComplete")
    public String APIComplete(@RequestParam("apiid") String apiid,@RequestParam("commentid") String commentid );

    /**
     * 功能描述: 消息流转
     * @param:
     * @param id 消息id
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/16 14:01
     */
    @RequestMapping(value = "/messagePosition/{id}")
    public String messagePosition(@PathVariable("id") String id) ;

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
    @RequestMapping(value = "/updateMessageComment")
    public String updateMessageComment(@RequestParam(name = "id",required = true) String id,
                                       @RequestParam(name = "btn",required = true) String btn,
                                       @RequestParam(name = "content",required = false) String content);


    /**
     * 功能描述: 根据主键删除消息（可多选）
     * @param:
     * @param id 主键（多个用逗号隔开）
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:50
     */
    @RequestMapping(value = "/message/{id}",method= RequestMethod.DELETE)
    public String delMessage( @PathVariable("id") String id);

    /**
     * 功能描述: 根据主键删除回复消息（可多选）
     * @param:
     * @param id 主键（多个用逗号隔开）
     * @return: boolean
     * @auther: zhengshien
     * @date: 2018/11/16 13:51
     */
    @RequestMapping(value = "/messageComment/{id}",method= RequestMethod.DELETE)
    public String delMessageComment( @PathVariable("id") String id);

    /**
     * 功能描述: 根据id获取消息内容
     * @param:
     * @param id id
     * @return: com.gla.datacenter.domain.Message
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @RequestMapping(value = "/message/{id}",method= RequestMethod.GET)
    public String getMessageById(@PathVariable("id") String id);

    /**
     * 功能描述: 根据id获取消息回复
     * @param:
     * @param id id
     * @return: com.gla.datacenter.domain.MessageComment
     * @auther: zhengshien
     * @date: 2018/11/16 13:56
     */
    @RequestMapping(value = "/messageComment/{id}",method= RequestMethod.GET)
    public String getMessageCommentById(@PathVariable("id") String id);

    /**
     * 功能描述: 查询消息列表（不分页）
     * @param:
     * @param message 消息实体（携带查询条件）
     * @return: java.util.List<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @RequestMapping(value = "/messageList")
    public String selectMessageList(@RequestBody Message message);

    /**
     * 功能描述: 查询消息回复列表（不分页）
     * @param:
     * @param messageComment 回复消息实体（携带查询条件）
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @RequestMapping(value = "/messageCommentList")
    public String selectMessageCommentList(@RequestBody MessageComment messageComment);

    /**
     * 功能描述: 查询消息列表（分页）
     * @param:
     * @param message 消息实体（携带查询条件）
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/16 13:52
     */
    @RequestMapping(value = "/messagePageList")
    public String getMessagePageList(@RequestBody Message message ,@RequestParam(name = "dealList"/*,required = false*/) String[] dealList);
    /**
     * 功能描述: 查询消息回复列表（分页）
     * @param:
     * @param messageComment 回复消息实体（携带查询条件）
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.MessageComment>
     * @auther: zhengshien
     * @date: 2018/11/16 13:54
     */
    @RequestMapping(value = "/messageCommentPageList")
    public String getMessageCommentPageList(@RequestBody MessageComment messageComment,@RequestParam(name = "dealList",required = false) String[] dealList);

    @RequestMapping(value = "/sendEmail",method = RequestMethod.POST)
    public String sendEmail(@RequestParam(name = "userEmail",required = false) String userEmail,
                            @RequestParam(name = "type") String type,
                            @RequestParam(name = "param",required = false)String param) throws Exception;

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Message表）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @RequestMapping(value = "/getMessageDealCount")
    public String getMessageDealCount(@RequestParam("userid") String userid);

    /**
     * 功能描述: 根据消息处理意见查询每一种状态的消息的个数（Comment表）
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/3 17:46
     */
    @RequestMapping(value = "/getCommentDealCount")
    public String getCommentDealCount(@RequestParam("userid") String userid);

    /**
     * 功能描述: 管理者查看各个处理意见的消息数量
     * @param:
     * @param receiverid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/25 9:50
     */
    @RequestMapping(value = "/getManagerDealCount")
    public String getManagerDealCount(@RequestParam("receiverid") String receiverid);

    /**
     * 功能描述: 查询所有通知类型的消息个数
     * @param:
     * @param userid 用户ID
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/12/17 15:58
     */
    @RequestMapping(value = "/getNumOfInform")
    public String getNumOfInform(@RequestParam("userid") String userid);

    /**
     * 功能描述: 申请多条APP
     * @param:
     * @param message 消息实体
     * @param appid appid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/2/20 15:23
     */
    @RequestMapping(value = "/message/save/app/{appid}")
    public String saveAppCart(@RequestBody Message message, @PathVariable("appid") String appid);

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
                                 @RequestParam(name = "level", required = false) Integer level);

    /**
     * 功能描述: 新增API与资源目录变更记录
     * @param:
     * @param apiCatalogChange 实体
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/18 14:09
     */
    @RequestMapping(value = "/apiCatalogChange")
    public String saveApiCatalogChange(@RequestBody ApiCatalogChange apiCatalogChange);

    /**
     * 功能描述: 消息批量标记为已读
     * @param:
     * @param ids ID集合
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/21 10:17
     */
    @RequestMapping(value = "/markRead/{ids}")
    public String markRead(@PathVariable("ids")String ids);

    /**
     * 功能描述: 模板查询（远程调用专用）
     * @param:
     * @param code 模板编码
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/4/1 15:51
     */
    @RequestMapping(value = "/selectModelContent")
    public String selectModelContent(@RequestParam("code") String code);




    }
