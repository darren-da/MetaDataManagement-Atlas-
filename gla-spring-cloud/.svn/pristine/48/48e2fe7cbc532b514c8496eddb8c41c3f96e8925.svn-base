package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.ApiNumLimt;
import com.gla.datacenter.domain.ApiNumLimtExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApiNumLimtMapper {
    int countByExample(ApiNumLimtExample example);

    int deleteByExample(ApiNumLimtExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApiNumLimt record);

    int insertSelective(ApiNumLimt record);

    List<ApiNumLimt> selectByExample(ApiNumLimtExample example);

    ApiNumLimt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApiNumLimt record, @Param("example") ApiNumLimtExample example);

    int updateByExample(@Param("record") ApiNumLimt record, @Param("example") ApiNumLimtExample example);

    int updateByPrimaryKeySelective(ApiNumLimt record);

    int updateByPrimaryKey(ApiNumLimt record);

    int checkIsFlag(@Param("str") String str, @Param("apiid") String apiid);

    List<ApiNumLimt> getApiAuditStatus(@Param("apiId") String apiId, @Param("userId") String userId);
}