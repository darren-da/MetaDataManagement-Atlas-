package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.InformationApiExample;
import com.gla.datacenter.model.ApiManagerModel;
import com.limp.framework.core.bean.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface InformationApiMapper {
    int countByExample(InformationApiExample example);

    int deleteByExample(InformationApiExample example);

    int deleteByPrimaryKey(String id);

    int insert(InformationApi record);

    int insertSelective(InformationApi record);

    List<InformationApi> selectByExample(InformationApiExample example);

    InformationApi selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") InformationApi record, @Param("example") InformationApiExample example);

    int updateByExample(@Param("record") InformationApi record, @Param("example") InformationApiExample example);

    int updateByPrimaryKeySelective(InformationApi record);

    int updateByPrimaryKey(InformationApi record);

    @Select("SELECT PRODUCER_ORG_ID FROM DC_INFORMATION_API WHERE DELETE_FLAG = 0 AND EXPIRE_FLAG = 0 GROUP BY PRODUCER_ORG_ID")
    List<String> getOrgId();

    void updateStatusBatch(@Param("apiStr") List<String> apiStr,@Param("updateTime") Date updateTime);

    void deleteBatchApi(@Param("ids") String[] ids,@Param("date") Date date,@Param("userId") String userId);

    List<InformationApi>  getList(Map<String, Object> paramMap);

    List<InformationApi> getConsumerListTwo(@Param("paramMap") Map<String, Object> paramMap,@Param("page") Pager pager);

    List<InformationApi> getManagerListTwo(Map<String, Object> paramMap);

    ApiManagerModel getConsumerApiById(@Param("id") String id,@Param("url") String url,@Param("forwardUrl") String forwardUrl,@Param("apikey") String apikey);

    Map<String,Integer> countApiStatusAndNum(String userId);

    Map<String,Integer> countConsumerApi(String userId);

    Map<String,Object> getApiInformationByCode(String code);

    void updateApiExpireStatus();

    Map<String,Object> countDeptAndApi();

    Integer countApiByCode(String code);

    List<String> checkOpenApi(List<String> lowStr);

    List<InformationApi> getBatchInformationApi(List<String> lowStr);

    List<Map<String,Object>> getTestListByType(@Param("key") String key,@Param("userId") String userId);

    Map<String,Integer> countMonitorData(@Param("userId") String userId);

    List<InformationApi> checkJoinApi(@Param("apis") String[] apis);

    List<Map<String,Object>> getApiInformationByApis(List<String> apiList);

    List<InformationApi> getAppDetailByAppId(String id);

    List<InformationApi> getApiListByResourceCode(@Param("code") String resourceCode, @Param("page") Pager pager);

    int countOrderByApiId(List<String> idStr);

    List<InformationApi> getApiIdByDeptCode(Map<String, Object> map);

    List<String> getSystemApiByIds(@Param("ids") String[] ids);
}