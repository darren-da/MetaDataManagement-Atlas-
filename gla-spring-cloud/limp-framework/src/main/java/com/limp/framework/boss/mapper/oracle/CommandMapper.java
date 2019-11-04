package com.limp.framework.boss.mapper.oracle;

import com.limp.framework.boss.domain.Command;
import com.limp.framework.boss.domain.CommandExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommandMapper {
    int countByExample(CommandExample example);

    int deleteByExample(CommandExample example);

    int deleteByPrimaryKey(String id);

    int insert(Command record);

    int insertSelective(Command record);

    List<Command> selectByExample(CommandExample example);

    Command selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Command record, @Param("example") CommandExample example);

    int updateByExample(@Param("record") Command record, @Param("example") CommandExample example);

    int updateByPrimaryKeySelective(Command record);

    int updateByPrimaryKey(Command record);

    List<Map<String,Object>> selectDynamicCommandSql(@Param("sql") String sql);
}