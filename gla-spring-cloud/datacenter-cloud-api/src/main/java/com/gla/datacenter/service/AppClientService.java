package com.gla.datacenter.service;


import com.gla.datacenter.domain.AppService;
import com.gla.datacenter.domain.AppUserMap;
import com.gla.datacenter.model.AppRequestModel;
import com.gla.datacenter.service.fallback.AppClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "DATACENTER-GATEWAY",path = "/api6",fallbackFactory = AppClientServiceFallbackFactory.class)
//@RequestMapping("/api")
public interface AppClientService {

    /**
     * 新增app信息
     *
     * @param appService
     * @return
     */
    @RequestMapping(value = "/app")
    String saveAppService(@RequestBody AppService appService);


    /**
     * 删除App信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/{id}", method = RequestMethod.DELETE)
    String delAppInfo(@PathVariable("id") String id);

    /**
     * 修改app信息
     *
     * @param appService
     * @return
     */
    @RequestMapping(value = "/app", method = RequestMethod.PUT)
    String updateApp(@RequestBody AppService appService);

    /**
     * 根据id查询app信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/{id}", method = RequestMethod.GET)
    String selectAppService(@PathVariable("id") String id);


    /**
     * 根据 app实体类查询app列表
     *
     * @param appRequestModel
     * @return
     */
    @RequestMapping(value = "/app/provider/list")
    String selectAppServiceList(@RequestBody AppRequestModel appRequestModel);

    /**
     * 功能描述: 新增APP与api(多个)关系
     *
     * @param appId  APPID
     * @param apiIds apiid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 14:50
     */
    @RequestMapping(value = "/addAppApiMap")
    String addAppApiMap(@RequestParam(name = "appId") String appId,
                               @RequestParam(name = "apiIds") String apiIds);

    /**
     * 功能描述: 删除APP与api(多个)关系
     *
     * @param appId  APPID
     * @param apiIds apiid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 14:54
     */
    @RequestMapping(value = "/delAppApiMap", method = RequestMethod.DELETE)
    String delAppApiMap(@RequestParam(name = "appId") String appId,
                               @RequestParam(name = "apiIds") String apiIds);

    /**
     * 功能描述: 新增用户与APP的对应关系
     *
     * @param userId 用户id
     * @param appid  apiid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 14:57
     */
    @RequestMapping(value = "/addAppUserMap", method = RequestMethod.POST)
    String addAppUserMap(@RequestParam(name = "userId") String userId,
                                @RequestParam(name = "appid") String appid);

    /**
     * 功能描述: 删除用户与APP的对应关系
     *
     * @param userId 用户id
     * @param appid  apiid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:02
     */
    @RequestMapping(value = "/delAppUserMap", method = RequestMethod.DELETE)
    String delAppUserMap(@RequestParam(name = "userId") String userId,
                                @RequestParam(name = "appid") String appid);


    /**
     * 功能描述: 根据用户角色，查询该用户的可操作APP
     *
     * @param userId
     * @param roleType
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:10
     */
    @RequestMapping(value = "/userAppList", method = RequestMethod.GET)
    String userAppList(@RequestParam(name = "userId") String userId,
                              @RequestParam(name = "roleType") String roleType);

    /**
     * 功能描述: 根据appid获取APP下所有api
     *
     * @param appId appid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:22
     */
    @RequestMapping(value = "/appApiList", method = RequestMethod.GET)
    String appApiList(@RequestParam(name = "appId") String appId);

    /**
     * 功能描述: 根据appkey获取APP基本信息
     *
     * @param appKey appkey
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:24
     */
    @RequestMapping(value = "/getAppByAppKey", method = RequestMethod.GET)
    String selectAppInfoByAppKey(@RequestParam(name = "appKey") String appKey);

    /**
     * 功能描述: 根据appkey获取APIList
     *
     * @param appKey appkey
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:26
     */
    @RequestMapping(value = "/getApiListByAppKey", method = RequestMethod.GET)
    String selectApiListByAppKey(@RequestParam(name = "appKey") String appKey);

    /**
     *
     * 功能描述: 生产者创建app应用
     *
     * @param: 
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 10:04
     */
    @RequestMapping(value = "/app/provider/add")
    String addAppByProvider(@RequestBody AppService appService);

    /**
     *
     * 功能描述: 消费者创建app应用
     *
     * @param: 
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 11:44
     */
    @RequestMapping(value = "/app/consumer/add")
    String addAppByConsumer(@RequestBody AppService appService);

    /**
     *
     * 功能描述: app批量授权用户
     *
     * @param: 
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 17:39
     */
    @RequestMapping(value = "/app/empower/sets")
    String batchEmpowerUser(@RequestBody AppUserMap appUserMap);

    /**
     *
     * 功能描述: 获取app授权详情
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/25 17:27
     */
    @RequestMapping("/app/apply/{id}")
    String getAppApplyByAppId(@PathVariable("id") String id);

    /**
     *
     * 功能描述: 删除授权(批量)
     *
     * @param:
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/28 11:34
     */
    @RequestMapping(value = "/app/empower/del")
    String deleteEmpower(@RequestBody AppUserMap appUserMap);

    /**
     *
     * 功能描述: 消费者app列表查询
     *
     * @param: 
     * @param appRequestModel
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/29 14:40
     */
    @RequestMapping(value = "/app/consumer/list")
    String getAppListByConsumer(@RequestBody AppRequestModel appRequestModel);

    /**
     *
     * 功能描述: 获取消费者app总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 10:57
     */
    @RequestMapping(value = "/app/consumer/count")
    String countConsumerApp();

    /**
     *
     * 功能描述: 获取生产者app总数、全网app、需申请app、不共享个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 11:26
     */
    @RequestMapping(value = "/app/provider/count")
    String countProviderApp();

    /**
     *
     * 功能描述: 获取app详情(包含的api)
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 17:09
     */
    @RequestMapping(value = "/app/detail/{id}")
    String getAppDetailByAppId(@PathVariable("id") String id);

    /**
     *
     * 功能描述: app加入申请(若是开放的，直接授权)
     *
     * @param: 
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 17:10
     */
    @RequestMapping(value = "/app/consumer/apply")
    String addApply(@RequestBody AppUserMap appUserMap);

    /**
     *
     * 功能描述: 校验当前已加入的app是否存在，并返回存在的值
     *
     * @param: 
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/19 15:06
     */
    @RequestMapping(value = "/app/check/join")
    String checkJoinApp(@RequestBody AppService appService);

    /**
     * 功能描述: 新增用户与app关系（messageServiceImpl远程调用专用）
     * @param:
     * @param appUserMap
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/3/28 9:35
     */
    @RequestMapping(value = "/saveAppUserMap",method= RequestMethod.POST)
    public Boolean saveAppUserMap(@RequestBody AppUserMap appUserMap);

    /**
     * 功能描述: 查询用户与app申请关系（messageServiceImpl远程调用专用）
     * @param:
     * @param appIdStr
     * @param applyUser
     * @return: java.util.List
     * @auther: zhengshien
     * @date: 2019/3/28 10:19
     */
    @RequestMapping(value = "/ApplyUsers",method= RequestMethod.GET)
    public List<AppUserMap> getApplyUsers(@RequestParam("appIdStr") String appIdStr, @RequestParam("applyUser") String applyUser);


    /**
     * 功能描述: 根据审批结果删减审核失败的记录（messageServiceImpl远程调用专用）
     * @param:
     * @param appid
     * @param userid
     * @return: java.lang.Integer
     * @auther: zhengshien
     * @date: 2019/3/28 10:54
     */
    @RequestMapping(value = "/delAuditFailureByStatus",method= RequestMethod.GET)
    public Integer delAuditFailureByStatus(@RequestParam("appid") String appid, @RequestParam("userid") String userid);

    /**
     * 功能描述: 根据条件查询用户与app的关系（messageServiceImpl远程调用专用）
     * @param:
     * @param senderid
     * @return: java.lang.Integer
     * @auther: zhengshien
     * @date: 2019/3/28 11:43
     */
    @RequestMapping(value = "/selectBySenderid",method= RequestMethod.GET)
    public List<AppUserMap> selectBySenderid(@RequestParam("senderid") String senderid);

    @RequestMapping(value = "/updateSelective",method= RequestMethod.GET)
    public Integer updateSelective(@RequestParam("status") Integer status,
                                   @RequestParam("senderid") String senderid,
                                   @RequestParam("apiid") String apiid);

    @RequestMapping(value = "/app/getAppByCode")
    public AppService getAppByCode(@RequestParam("code") String code);
}
