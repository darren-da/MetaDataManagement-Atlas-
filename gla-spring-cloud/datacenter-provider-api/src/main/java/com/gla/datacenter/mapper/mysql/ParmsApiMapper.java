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

    List<ParmsApi> getShamParms(String apiId);

    /**
     *
     * 功能描述:获取参数名称
     *
     * @param: 
     * @param apiId
     * @return: java.util.List<java.lang.String>
     * @auther: zhangbo
     * @date: 2018/11/20 9:35
     */
    
    List<String> getRequiredParmsList(String apiId);
}