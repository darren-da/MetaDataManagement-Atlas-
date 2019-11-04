package com.gla.datacenter.mapper.mysql;


import com.gla.datacenter.domain.OperationSetting;
import com.gla.datacenter.domain.OperationSettingExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OperationSettingMapper {
    int countByExample(OperationSettingExample example);

    int deleteByExample(OperationSettingExample example);

    int insert(OperationSetting record);

    int insertSelective(OperationSetting record);

    List<OperationSetting> selectByExample(OperationSettingExample example);

    int updateByExampleSelective(@Param("record") OperationSetting record, @Param("example") OperationSettingExample example);

    int updateByExample(@Param("record") OperationSetting record, @Param("example") OperationSettingExample example);

    void deleteOperationSetting(@Param("ids") String[] ids, @Param("date") Date date);
}