package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.MessageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MessageMapper {

    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    Message selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);

    /**
     * 功能描述:  根据查询消息列表，返回值携带发件人名称
     * @param:
     * @param messageExample  查询条件
     * @return: java.util.List<com.gla.datacenter.domain.Message>
     * @auther: zhengshien
     * @date: 2018/11/15 18:46
     */
    List<Message> selectByExampleWithBLOBsAddSenderName(MessageExample messageExample);

    Map selectMessageDealCount(@Param("userid") String userid);

    Map selectCommentDealCount(@Param("userid") String userid);

    int selectNumOfInform(@Param("userid") String userid);

    /**
     * 功能描述: 管理者查看已有API各个状态的个数
     * @param:
     * @param receiverid
     * @return: java.util.Map
     * @auther: zhengshien
     * @date: 2018/12/24 17:28
     */
    Map selectManagerDealCount1(@Param("receiverid")String receiverid);

    /**
     * 功能描述: 管理者查看写信API的各个状态的个数
     * @param:
     * @return: java.util.Map
     * @auther: zhengshien
     * @date: 2018/12/24 17:28
     */
    Map selectManagerDealCount2();

}