package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.AppService;
import com.gla.datacenter.domain.AppServiceExample;
import com.gla.datacenter.model.AppResponseModel;
import com.limp.framework.core.bean.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppServiceMapper {
    int countByExample(AppServiceExample example);

    int deleteByExample(AppServiceExample example);

    int deleteByPrimaryKey(String id);

    int insert(AppService record);

    int insertSelective(AppService record);

    List<AppService> selectByExample(AppServiceExample example);

    AppService selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AppService record, @Param("example") AppServiceExample example);

    int updateByExample(@Param("record") AppService record, @Param("example") AppServiceExample example);

    int updateByPrimaryKeySelective(AppService record);

    int updateByPrimaryKey(AppService record);

    AppService selectAppInfoByAppKey(@Param("appKey") String appKey);

    int deleteAppService(@Param("ids") String[] ids);

    List<AppResponseModel> getAppListByConsumer(@Param("paramMap") Map<String, Object> paramMap, @Param("page") Pager pager);

    Map<String,Integer> countProviderApp(String userId);

    Map<String,Integer> countConsumerApp(String userId);

    List<AppService> getBatchInformationApi(List<String> lowStr);

    List<String> checkJoinApp(@Param("apps") String[] apps);
}