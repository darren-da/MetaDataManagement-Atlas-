package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.InformationApiExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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

    List<InformationApi> selectApiInformationByCode(String code);

    List<InformationApi> getApiInforByApiCode(@Param("strCode") List<String> strCode,@Param("deleteFlag") boolean deleteFlag, @Param("apiStatus") boolean apiStatus);

    List<String> getApiCodeByAppCode(@Param("code") String code);
}