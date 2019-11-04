package com.gla.datacenter.service;

import com.gla.datacenter.domain.AppApiMap;
import com.gla.datacenter.domain.AppService;
import com.gla.datacenter.domain.AppUserMap;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.model.AppRequestModel;
import com.gla.datacenter.model.AppServiceModel;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

import java.util.List;
import java.util.Map;

/**
 * @Description: AppInfoService
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/23 11:49
 */
public interface AppInfoService extends AbstractService<AppService> {

    /**
     * 分为消费者和生产的appid
     * 新增app和appids映射（前端传递给用户该api的权限；todo 如果该api在该appid中是没有权限的处理，在controller处理）
     * @param appId
     * @param apiIds appid 多个用逗号分隔
     * @return
     */
    boolean addAppApiMap(String appId,String  apiIds);

    /**
     *
     * 功能描述: 生产者创建app应用
     *
     * @param: 
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 10:07
     */
    String addAppByProvider(AppService appService);

    /**
     *
     * 功能描述: 消费者创建app应用
     *
     * @param:
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 11:45
     */
    String addAppByConsumer(AppService appService);

    /**
     * 删除appid和api的映射关系
     * @param appId
     * @param apiIds
     * @return
     */
    boolean delAppApiMap(String appId,String apiIds);

    /**
     * 新增用户新增app
     * @param userId 用户Id分为消费者（服务编排，api集中授权申请） 和生产者(服务集中授权) ：
     * @param appid appid
     * @return
     */
    boolean addAppUserMap(String userId,String appid);

    /**
     * 删除用户和app信息（物理删除）
     * @param userId
     * @param appid
     * @return
     */
    boolean delAppUserMap(String userId,String appid);

    /**
     * 获取用户app集合
     * @param userId 用户 userid
     * @param roleType 角色类型   1 生产者 2 消费者 3 管理者
     * @return
     */
    List<Map<String,Object>> userAppList(String userId,String roleType);

    /**
     * 根据appid获取app的api列表
     * @param appId   全部
     * @return
     */
//    List<Map<String,Object>> appApiList(String appId);
    List<AppApiMap> appApiList(String appId);

    /**
     * 根据appkey获取app基本信息
     * @param appKey
     * @return
     */
    AppService selectAppInfoByAppKey(String  appKey);

    /**
     * 根据Appkey 获取apiList
     * @param appKey
     * @return
     */
//    List<Map<String,Object>> selectApiListByAppKey(String appKey);
    List<AppApiMap> selectApiListByAppKey(String appKey);

    /**
     * 删除app
     * @param id
     * @return
     */
    String delAppInfo(String id);

    /**
     *
     * 功能描述: 更新app信息(包含api信息)
     *
     * @param: 
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 15:58
     */
    String updateApp(AppService appService);

    /**
     *
     * 功能描述: app批量授权用户
     *
     * @param: 
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 17:41
     */
    String batchEmpowerUser(AppUserMap appUserMap);

    /**
     *
     * 功能描述: 查询用于列表
     *
     * @param:
     * @param appRequestModel
     * @param pager
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.model.AppServiceModel>
     * @author: zhangbo
     * @date: 2019/1/25 17:28
     */
    Pager<AppServiceModel> getAppPageList(AppRequestModel appRequestModel,Pager pager);

    /**
     *
     * 功能描述: 获取app授权详情
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/25 17:28
     */
    String getAppApplyByAppId(String id);

    /**
     *
     * 功能描述: 删除app授权批量
     *
     * @param: 
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/28 11:34
     */
    String deleteEmpower(AppUserMap appUserMap);

    /**
     *
     * 功能描述: 消费者查询app应用列表
     *
     * @param: 
     * @param appRequestModel
     * @param pager
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/29 14:44
     */
    String getAppListByConsumer(AppRequestModel appRequestModel, Pager pager);

    /**
     *
     * 功能描述: app新增或者编辑中名称或者描述模糊搜索已授权api
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/30 11:33
     */
    String searchApplyApiByConsumer(InformationApi informationApi);

    /**
     *
     * 功能描述: 获取消费者app总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 10:58
     */
    String countConsumerApp();

    /**
     *
     * 功能描述: 获取生产者app总数、全网app、需申请app、不共享个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 11:27
     */
    String countProviderApp();

    /**
     *
     * 功能描述: 获取app包含api详情
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 10:56
     */
    String getAppDetailByAppId(String id);

    /**
     *
     * 功能描述: app加入申请(若是开放的，直接授权)
     *
     * @param:
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 17:14
     */
    String addApply(AppUserMap appUserMap);

    /**
     *
     * 功能描述: 校验当前已加入的app是否存在，并返回存在的值
     *
     * @param:
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/19 15:07
     */
    String checkJoinApp(AppService appService);

    /**
     * 功能描述: 新增用户与app关系（messageServiceImpl远程调用专用）
     * @param:
     * @param appUserMap
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/3/28 9:35
     */
    Boolean saveAppUserMap(AppUserMap appUserMap);

    /**
     * 功能描述: 查询用户与app申请关系（messageServiceImpl远程调用专用）
     * @param:
     * @param appIdStr
     * @param applyUser
     * @return: java.util.List
     * @auther: zhengshien
     * @date: 2019/3/28 10:19
     */
    List<AppUserMap> getApplyUsers(String appIdStr, String applyUser);

    /**
     * 功能描述: 根据审批结果删减审核失败的记录（messageServiceImpl远程调用专用）
     * @param:
     * @param appid
     * @param userid
     * @return: java.lang.Integer
     * @auther: zhengshien
     * @date: 2019/3/28 10:54
     */
    Integer delAuditFailureByStatus(String appid, String userid);

    List<AppUserMap> selectBySenderid(String senderid);

    Integer updateSelective(Integer status, String senderid, String apiid);

    AppService getAppByCode(String code);
}
