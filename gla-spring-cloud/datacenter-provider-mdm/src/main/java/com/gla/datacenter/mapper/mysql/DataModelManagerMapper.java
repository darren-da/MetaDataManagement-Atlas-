package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.DataModelManager;
import com.gla.datacenter.domain.DataModelManagerExample;
import com.gla.datacenter.domain.ModelField;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataModelManagerMapper {
    int countByExample(DataModelManagerExample example);

    int deleteByExample(DataModelManagerExample example);

    int deleteByPrimaryKey(String id);

    int insert(DataModelManager record);

    int insertSelective(DataModelManager record);

    List<DataModelManager> selectByExample(DataModelManagerExample example);

    DataModelManager selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DataModelManager record, @Param("example") DataModelManagerExample example);

    int updateByExample(@Param("record") DataModelManager record, @Param("example") DataModelManagerExample example);

    int updateByPrimaryKeySelective(DataModelManager record);

    int updateByPrimaryKey(DataModelManager record);

    void createTable(@Param("modelFields") List<ModelField> modelFields, @Param("tableName") String tableName);

    int selectNumByTableName(@Param("tableName") String tableName);

    List<String> getModelCodeListByMasterIdList(@Param("list") List<String> list);

    List<String> getTableNameList(@Param("prefix") String prefix, @Param("database") String database);

    List<Map<String,Object>> getFieldByTableName(@Param("databse") String database,@Param("name") String name);

    List<Map<String,Object>> getFieldByTableNameAndUse(@Param("database") String database,@Param("name") String name, @Param("list") List<String> list);

    List<String> getModeIdByMasterIdList(@Param("list") List<String> list);
}