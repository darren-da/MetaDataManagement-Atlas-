package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.MetaDataTree;
import com.gla.datacenter.domain.MetaDataTreeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MetaDataTreeMapper {
    int countByExample(MetaDataTreeExample example);

    int deleteByExample(MetaDataTreeExample example);

    int deleteByPrimaryKey(String id);

    int insert(MetaDataTree record);

    int insertSelective(MetaDataTree record);

    List<MetaDataTree> selectByExample(MetaDataTreeExample example);

    /**
     *
     * @param pids
     * @return
     */
    List<Map<String,Object>> selectIfHasChild(List pids);

    MetaDataTree selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MetaDataTree record, @Param("example") MetaDataTreeExample example);

    int updateByExample(@Param("record") MetaDataTree record, @Param("example") MetaDataTreeExample example);

    int updateByPrimaryKeySelective(MetaDataTree record);

    int updateByPrimaryKey(MetaDataTree record);
}