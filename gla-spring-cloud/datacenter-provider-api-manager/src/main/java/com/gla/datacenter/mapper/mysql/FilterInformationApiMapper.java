package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.FilterInformationApi;
import com.gla.datacenter.domain.FilterInformationApiExample;
import com.gla.datacenter.model.ApiFilterResponseModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FilterInformationApiMapper {
    int countByExample(FilterInformationApiExample example);

    int deleteByExample(FilterInformationApiExample example);

    int deleteByPrimaryKey(String id);

    int insert(FilterInformationApi record);

    int insertSelective(FilterInformationApi record);

    List<FilterInformationApi> selectByExample(FilterInformationApiExample example);

    FilterInformationApi selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FilterInformationApi record, @Param("example") FilterInformationApiExample example);

    int updateByExample(@Param("record") FilterInformationApi record, @Param("example") FilterInformationApiExample example);

    int updateByPrimaryKeySelective(FilterInformationApi record);

    int updateByPrimaryKey(FilterInformationApi record);

    void deleteApiFilter(@Param("ids") List<String> listType);

    Map<String,Integer> getFilterCount(String userId);

    List<ApiFilterResponseModel> getFilterPageList(Map<String, Object> paramMap);

    List<String> checkListType(@Param("ids")String[] ids, @Param("listType") int listType);

    FilterInformationApi getFilterByUserIdAndApiId(@Param("userId") String userId, @Param("filterId") String filterId);
}