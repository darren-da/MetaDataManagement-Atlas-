package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.ApiNumLimt;
import com.gla.datacenter.domain.ApiNumLimtExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Mapper
public interface ApiNumLimtMapper {
    int countByExample(ApiNumLimtExample example);

    int deleteByExample(ApiNumLimtExample example);

    int deleteByPrimaryKey(String id);

    int insert(ApiNumLimt record);

    int insertSelective(ApiNumLimt record);

    List<ApiNumLimt> selectByExample(ApiNumLimtExample example);
    /**
     * 功能描述: 根据name或code或description模糊查询
     * @param:
     * @param example
     * @return: java.util.List<com.gla.datacenter.domain.ApiNumLimt>
     * @auther: zhengshien
     * @date: 2019/4/2 16:17
     */
    List<ApiNumLimt> selectApiByNameCodeDesc(ApiNumLimtExample example);

    ApiNumLimt selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ApiNumLimt record, @Param("example") ApiNumLimtExample example);

    int updateByExample(@Param("record") ApiNumLimt record, @Param("example") ApiNumLimtExample example);

    int updateByPrimaryKeySelective(ApiNumLimt record);

    int updateByPrimaryKey(ApiNumLimt record);

    int checkIsFlag(@Param("str") String str,@Param("apiid") String apiid);

    List<ApiNumLimt> getApiAuditStatus(@Param("apiId") String apiId, @Param("userId") String userId);

    List<String> getApiListByUserId(String userId);

    void batchEmpowerUser(@Param("paramList") List<Map<String, Object>> paramList);

    List<String> checkIsEmpower(@Param("apiId") String[] apiId, @Param("userId") String userId);

    void batchEmpower(@Param("openList") List<String> openList, @Param("userId") String userId, @Param("account") String account);

    void delEmpowerByUserId(@Param("userStr") String[] userStr, @Param("apiId") String[] apiIdStr);
}