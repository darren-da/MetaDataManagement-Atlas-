package com.gla.datacenter.mapper.mysql;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AnalysisMapper {
    /**
     * 统一调用方法
     * @param method
     * @param params
     * @return
     */
    List<Map<String,Object>> selectListMapByMethod(@Param("method") String method, @Param("params") Map<String,Object> params);


    /**
     *
     * 功能描述: 查询首页API健康度评分
     *
     * @param: 
     * @param userId
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/12/6 16:45
     */
    Map<String,Object> selectApiScore(String userId);

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api调用次数
     *
     * @param: 
     * @param userId
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Integer>>
     * @auther: zhangbo
     * @date: 2018/12/21 11:38
     */
    List<Map<String,Integer>> getConsumerApiUseNumByWeek(String userId);

    /**
     *
     * 功能描述: 消费者-个人中心按周统计api申请次数
     *
     * @param:
     * @param userId
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Integer>>
     * @auther: zhangbo
     * @date: 2018/12/21 13:45
     */
    List<Map<String,Integer>> getConsumerApiApplyNumByWeek(String userId);

}