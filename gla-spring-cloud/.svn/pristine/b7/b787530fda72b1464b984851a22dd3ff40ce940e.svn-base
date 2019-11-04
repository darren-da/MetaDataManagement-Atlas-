package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.AppService;
import com.gla.datacenter.domain.AppUserMap;
import com.gla.datacenter.model.AppRequestModel;
import com.gla.datacenter.service.AppClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: zzh
 * @Date: 2018/11/23 11:38
 * @Description: app管理
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(value = "app管理", description = "app管理")
public class AppControllerFeign {

    @Autowired
    private AppClientService appClientService;

    private Logger logger = LoggerFactory.getLogger(AppControllerFeign.class);


    /**
     * 生产者查询用于列表
     *
     * @return
     */
    @RequestMapping(value = "/app/provider/list", method = RequestMethod.GET)
    @Access(login = true)
    public String selectAppServiceList(AppRequestModel appRequestModel) {
        logger.debug(TextUtils.format("/***查询app,返回app列表**/"));
        return appClientService.selectAppServiceList(appRequestModel);
    }

    /**
     *
     * 功能描述: 消费者app列表查询
     *
     * @param: 
     * @param appRequestModel
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/29 14:39
     */
    @RequestMapping(value = "/app/consumer/list")
    @Access(login = true)
    public String getAppListByConsumer(AppRequestModel appRequestModel){
        return appClientService.getAppListByConsumer(appRequestModel);
    }

    /**
     *
     * 功能描述: 获取消费者app总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 9:56
     */
    @Access(login = true)
    @GetMapping(value = "/app/consumer/count")
    public String countConsumerApp(){
        return appClientService.countConsumerApp();
    }

    /**
     *
     * 功能描述: 获取生产者app总数、全网app、需申请app、不共享个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 11:01
     */
    @Access(login = true)
    @GetMapping(value = "/app/provider/count")
    public String countProviderApp(){
        return appClientService.countProviderApp();
    }

    /**
     *
     * 功能描述: 生产者创建app应用
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 10:00
     */
    @Access(login = true, operationLog = OPERATION.INSERT, operationIntro = "新增应用")
    @PostMapping(value = "/app/provider/add")
    public String addAppByProvider(@RequestBody AppService appService){
        return appClientService.addAppByProvider(appService);
    }

    /**
     *
     * 功能描述: 消费者创建app应用
     *
     * @param:
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 11:43
     */
    @Access(login = true, operationLog = OPERATION.INSERT, operationIntro = "新增应用")
    @PostMapping(value = "/app/consumer/add")
    public String addAppByConsumer(@RequestBody AppService appService){
        return appClientService.addAppByConsumer(appService);
    }

    /**
     * 删除app
     * 为了管理员易于操作支持批量操作
     *
     * @param id
     * @return
     */
    @Access(login = true)
    @RequestMapping(value = "/app/{id}", method = RequestMethod.DELETE)
    public String delAppInfo(@PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据id{0}，删除记录**/", id));
        return appClientService.delAppInfo(id);
    }

    /**
     *
     * 功能描述: app批量授权用户
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 17:37
     */
    @Access(login = true)
    @PostMapping(value = "/app/empower/sets")
    public String batchEmpowerUser(@RequestBody AppUserMap appUserMap){
        return appClientService.batchEmpowerUser(appUserMap);
    }

    /**
     *
     * 功能描述: 获取app授权详情
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/25 17:26
     */
    @Access(login = true)
    @GetMapping(value = "/app/apply/{id}")
    public String getAppApplyByAppId(@PathVariable("id") String id){
        return appClientService.getAppApplyByAppId(id);
    }

    /**
     *
     * 功能描述: 获取app包含api详情
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 11:49
     */
    @GetMapping(value = "/app/detail/{id}")
    public String getAppDetailByAppId(@PathVariable("id") String id){
        return appClientService.getAppDetailByAppId(id);
    }

    /**
     *
     * 功能描述: app加入申请(若是开放的，直接授权)
     *
     * @param: 
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 17:08
     */
    @Access(login = true)
    @PostMapping(value = "/app/consumer/apply")
    public String addApply(@RequestBody AppUserMap appUserMap){
        return appClientService.addApply(appUserMap);
    }

    /**
     *
     * 功能描述: 校验当前已加入的app是否存在，并返回存在的值
     *
     * @param: 
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/19 15:05
     */
    @Access(login = true)
    @RequestMapping(value = "/app/check/join")
    public String checkJoinApp(AppService appService){
        return appClientService.checkJoinApp(appService);
    }

    /**
     * 更新app应用信息
     *
     * @param appService appService
     * @return
     */
    @Access(login = true)
    @RequestMapping(value = "/app", method = RequestMethod.PUT)
    public String updateApp(@RequestBody AppService appService) {
        logger.debug(TextUtils.format("/***更新信息**/"));
        return appClientService.updateApp(appService);
    }

    /**
     * 新增AppService
     *
     * @param AppService
     * @return
     */
    @Access(login = true)
    @RequestMapping(value = "/app", method = RequestMethod.POST)
    public String saveAppService(@RequestBody AppService AppService) {
        logger.debug("/***新增实体类信息**/");
        return appClientService.saveAppService(AppService);
    }

    /**
     * 获取app应用信息根据appId
     *
     * @param id 查询的id
     * @return
     */
    @Access(login = true)
    @RequestMapping(value = "/app/{id}", method = RequestMethod.GET)
    public String selectAppService(@PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据用户id{0}，获取app基本信息**/", id));
        return appClientService.selectAppService(id);
    }

    /**
     *
     * 功能描述: 删除app授权(批量)
     *
     * @param: 
     * @param appUserMap
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/28 11:33
     */
    @Access(login = true)
    @DeleteMapping(value = "/app/empower/del")
    public String deleteEmpower(@RequestBody AppUserMap appUserMap){
        return appClientService.deleteEmpower(appUserMap);
    }

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
    @Access(login = true)
    @RequestMapping(value = "/addAppApiMap", method = RequestMethod.POST)
    public String addAppApiMap(@RequestParam(name = "appId") String appId, @RequestParam(name = "apiIds") String apiIds) {
        logger.debug(TextUtils.format("/***根据appid{0}和apiids{1}，新增APP与API列表对应关系**/", appId, apiIds));
        return appClientService.addAppApiMap(appId, apiIds);
    }

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
    @Access(login = true)
    @RequestMapping(value = "/delAppApiMap", method = RequestMethod.DELETE)
    public String delAppApiMap(@RequestParam(name = "appId") String appId, @RequestParam(name = "apiIds") String apiIds) {
        logger.debug(TextUtils.format("/***根据appid{0}和apiids{1}，删除APP与API列表对应关系**/", appId, apiIds));
        return appClientService.delAppApiMap(appId, apiIds);
    }

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
    @Access(login = true)
    @RequestMapping(value = "/addAppUserMap", method = RequestMethod.POST)
    public String addAppUserMap(@RequestParam(name = "userId") String userId, @RequestParam(name = "appid") String appid) {
        logger.debug(TextUtils.format("/***根据userId{0}和appid{1}，新增用户与APP的对应关系**/", userId, appid));
        return appClientService.addAppUserMap(userId, appid);
    }

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
    @Access(login = true)
    @RequestMapping(value = "/delAppUserMap", method = RequestMethod.DELETE)
    public String delAppUserMap(@RequestParam(name = "userId") String userId, @RequestParam(name = "appid") String appid) {
        logger.debug(TextUtils.format("/***根据userId{0}和appid{1}，删除用户与APP的对应关系**/", userId, appid));
        return appClientService.delAppUserMap(userId, appid);
    }

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
    @Access(login = true)
    @RequestMapping(value = "/userAppList", method = RequestMethod.GET)
    public String userAppList(@RequestParam(name = "userId") String userId, @RequestParam(name = "roleType") String roleType) {
        logger.debug(TextUtils.format("/***根据用户角色{0}，查询该用户{1}的可操作APP**/", userId, roleType));
        return appClientService.userAppList(userId, roleType);
    }

    /**
     * 功能描述: 根据appid获取APP下所有api
     *
     * @param appId appid
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:22
     */
    @Access(login = true)
    @RequestMapping(value = "/appApiList", method = RequestMethod.GET)
    public String appApiList(@RequestParam(name = "appId") String appId) {
        logger.debug(TextUtils.format("/***根据appid{0}获取app的api列表**/", appId));
        return appClientService.appApiList(appId);
    }

    /**
     * 功能描述: 根据appkey获取APP基本信息
     *
     * @param appKey appkey
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:24
     */
    @Access(login = true)
    @RequestMapping(value = "/getAppByAppKey", method = RequestMethod.GET)
    public String selectAppInfoByAppKey(@RequestParam(name = "appKey") String appKey) {
        logger.debug(TextUtils.format("/***根据appkey{0}获取app基本信息**/", appKey));
        return appClientService.selectAppInfoByAppKey(appKey);
    }

    /**
     * 功能描述: 根据appkey获取APIList
     *
     * @param appKey appkey
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:26
     */
    @Access(login = true)
    @RequestMapping(value = "/getApiListByAppKey", method = RequestMethod.GET)
    public String selectApiListByAppKey(@RequestParam(name = "appKey") String appKey) {
        logger.debug(TextUtils.format("/***根据appkey{0}获取apiList**/", appKey));
        return appClientService.selectApiListByAppKey(appKey);
    }
}
