package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.ParmsApi;
import com.gla.datacenter.domain.ParmsApiExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParmsApiMapper {
    int countByExample(ParmsApiExample example);

    int deleteByExample(ParmsApiExample example);

    int deleteByPrimaryKey(String id);

    int insert(ParmsApi record);

    int insertSelective(ParmsApi record);

    List<ParmsApi> selectByExample(ParmsApiExample example);

    ParmsApi selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ParmsApi record, @Param("example") ParmsApiExample example);

    int updateByExample(@Param("record") ParmsApi record, @Param("example") ParmsApiExample example);

    int updateByPrimaryKeySelective(ParmsApi record);

    int updateByPrimaryKey(ParmsApi record);

    /**
     *
     * 功能描述: 获取参数
     *
     * @param: [apiId]
     * @return: java.util.List<com.gla.datacenter.domain.ParmsApi>
     * @auther: zhangbo
     * @date: 2018/10/8 13:53
     */
    
    List<ParmsApi> getShamParms(String apiId);

    List<String> getRequiredParmsList(String apiId);

    /**
     *
     * 功能描述: 根据apiId删除参数
     *
     * @param: 
     * @param id
     * @return: void
     * @auther: zhangbo
     * @date: 2018/12/14 9:32
     */
    void deleteParmsByApiId(String id);
}