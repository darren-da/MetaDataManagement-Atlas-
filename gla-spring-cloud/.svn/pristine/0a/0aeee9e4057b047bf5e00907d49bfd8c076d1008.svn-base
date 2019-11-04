package com.gla.datacenter.mapper.mysql;

import com.gla.datacenter.domain.AppUserMap;
import com.gla.datacenter.domain.AppUserMapExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface AppUserMapMapper {
    int countByExample(AppUserMapExample example);

    int deleteByExample(AppUserMapExample example);

    int insert(AppUserMap record);

    int insertSelective(AppUserMap record);

    List<AppUserMap> selectByExample(AppUserMapExample example);
    /**
     * 功能描述: 根据name或code或description条件查询
     * @param:
     * @param example
     * @return: java.util.List<com.gla.datacenter.domain.AppUserMap>
     * @auther: zhengshien
     * @date: 2019/4/3 10:20
     */
    List<AppUserMap> selectAppByCodeNameDesc(AppUserMapExample example);

    int updateByExampleSelective(@Param("record") AppUserMap record, @Param("example") AppUserMapExample example);

    int updateByExample(@Param("record") AppUserMap record, @Param("example") AppUserMapExample example);

    List<String> checkAppApply(@Param("ids") String[] ids);

    int batchApplyUser(@Param("applyList") List<Map<String, Object>> applyList, @Param("time") Date time);

    List<AppUserMap> getApplyUsers(@Param("appIdStr") String[] appIdStr, @Param("applyUser") String[] applyUser);

    List<AppUserMap> getApplyInforByAppId(String id);

    int delEmpowerByUserId(@Param("userStr") String[] userStr,@Param("appIdStr") String[] appIdStr);

    List<String> checkIsEmpower(@Param("appId") String[] appId,@Param("userId") String userId);

    void batchEmpower(@Param("openList") List<String> openList, @Param("userId") String userId);

    AppUserMap getAppApplyStatus(@Param("id") String id, @Param("userId") String userId);

    int delAuditFailureByStatus(@Param("appid") String appid, @Param("userid") String userid);
}