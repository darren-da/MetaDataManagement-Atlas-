package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.TimerCenter;
import com.gla.datacenter.domain.TimerCenterExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TimerCenterMapper {
    int countByExample(TimerCenterExample example);

    int deleteByExample(TimerCenterExample example);

    int insert(TimerCenter record);

    int insertSelective(TimerCenter record);

    List<TimerCenter> selectByExample(TimerCenterExample example);

    int updateByExampleSelective(@Param("record") TimerCenter record, @Param("example") TimerCenterExample example);

    int updateByExample(@Param("record") TimerCenter record, @Param("example") TimerCenterExample example);

    @Update("update DC_TIMER_CENTER set IS_FLAG = #{flag} limit 1")
    void updateIsFlag(byte flag);
}