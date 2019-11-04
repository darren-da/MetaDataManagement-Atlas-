package com.gla.datacenter.controller;

import com.gla.datacenter.domain.AppApiMap;
import com.gla.datacenter.domain.AppService;
import com.gla.datacenter.domain.AppUserMap;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.model.AppRequestModel;
import com.gla.datacenter.model.AppServiceModel;
import com.gla.datacenter.service.AppInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description: APP服务相关controller
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/23 14:08
 */
@RestController
@CrossOrigin
public class AppServiceController {

    Logger logger= LoggerFactory.getLogger(AppServiceController.class);

    @Autowired
    AppInfoService appInfoService;

    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    /**
     * 新增AppService
     * @param appService
     * @return
     */
    @RequestMapping(value = "/app")
    public String saveAppService(@RequestBody AppService appService) {
        logger.debug("/***新增实体类信息**/");
        if(appInfoService.save(appService)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 删除app
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/app/{id}",method= RequestMethod.DELETE)
    public String delAppInfo(@PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据id{0}，删除记录**/", id));
        return appInfoService.delAppInfo(id);
    }
    /**
     * 更新app应用信息
     * @param appService appService
     * @return
     */
    @RequestMapping(value = "/app",method= RequestMethod.PUT)
    public String updateApp(@RequestBody AppService appService) {
        logger.debug(TextUtils.format("/***更新app应用信息**/"));
        return appInfoService.updateApp(appService);
    }


    /**
     * 获取用户信息根据用户id
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/app/{id}",method= RequestMethod.GET)
    public String selectAppService(@PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据用户id{0}，获取app基本信息**/", id));
        AppService appService= appInfoService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,appService,"").getJson();
    }

    /**
     * 查询生产者app列表
     * @return
     */
    @RequestMapping(value = "/app/provider/list",method= RequestMethod.POST)
    public String selectAppServiceList(@RequestBody AppRequestModel appRequestModel) {
        logger.debug(TextUtils.format("/***查询app,返回app列表**/"));
        Pager<AppServiceModel> appServicePager= appInfoService.getAppPageList(appRequestModel, appRequestModel.getPager(DEFAULT_ROW));
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,appServicePager,"").getJson();
    }

    /**
     *
     * 功能描述: 消费者查询app列表(分页查询)
     *
     * @param: 
     * @param appRequestModel
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/29 14:43
     */
    @RequestMapping(value = "/app/consumer/list")
    public String getAppListByConsumer(@RequestBody AppRequestModel appRequestModel){
        return appInfoService.getAppListByConsumer(appRequestModel,appRequestModel.getPager());
    }

    /**
     *
     * 功能描述: 获取消费者app总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 10:58
     */
    @RequestMapping(value = "/app/consumer/count")
    public String countConsumerApp(){
        return appInfoService.countConsumerApp();
    }

    /**
     *
     * 功能描述: 获取生产者app总数、全网app、需申请app、不共享个数
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/15 11:27
     */
    @RequestMapping(value = "/app/provider/count")
    public String countProviderApp(){
        return appInfoService.countProviderApp();
    }

    /**
     *
     * 功能描述: app新增或者编辑中名称或者描述模糊搜索已授权api
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/30 11:29
     */
    @RequestMapping(value = "/app/apply/search")
    public String searchApplyApiByConsumer(@RequestBody InformationApi informationApi){
        return appInfoService.searchApplyApiByConsumer(informationApi);
    }

    /**
     * 功能描述: 新增APP与api(多个)关系
     * @param:
     * @param appId APPID
     * @param apiIds apiid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 14:50
     */
    @RequestMapping(value = "/addAppApiMap")
    public String addAppApiMap(@RequestParam(name = "appId") String appId,@RequestParam(name = "apiIds") String apiIds) {
        logger.debug(TextUtils.format("/***根据appid{0}和apiids{1}，新增APP与API列表对应关系**/", appId,apiIds));
        Boolean flay= appInfoService.addAppApiMap(appId,apiIds);
        if (flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     *
     * 功能描述: 生产者创建app应用
     *
     * @param:
     * @param appService
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/24 10:06
     */
    @RequestMapping(value = "/app/provider/add")
    public String addAppByProvider(@RequestBody AppService appService){
        return appInfoService.addAppByProvider(appService);
    }

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
    @RequestMapping(value = "/app/consumer/add")
    public String addAppByConsumer(@RequestBody AppService appService){
        return appInfoService.addAppByConsumer(appService);
    }

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
    @RequestMapping(value = "/app/empower/sets")
    public String batchEmpowerUser(@RequestBody AppUserMap appUserMap){
        return appInfoService.batchEmpowerUser(appUserMap);
    }

    /**
     *
     * 功能描述: 获取app授权详情
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/25 17:25
     */
    @RequestMapping(value = "/app/apply/{id}")
    public String getAppApplyByAppId(@PathVariable("id") String id){
        return appInfoService.getAppApplyByAppId(id);
    }

    /**
     *
     * 功能描述: 获取app包含api详情
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/18 10:55
     */
    @RequestMapping(value = "/app/detail/{id}")
    public String getAppDetailByAppId(@PathVariable("id") String id){
        return appInfoService.getAppDetailByAppId(id);
    }

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
    @RequestMapping(value = "/app/consumer/apply")
    public String addApply(@RequestBody AppUserMap appUserMap){
        return appInfoService.addApply(appUserMap);
    }


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
    @RequestMapping(value = "/app/check/join")
    public String checkJoinApp(@RequestBody AppService appService){
        return appInfoService.checkJoinApp(appService);
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
    @RequestMapping(value = "/app/empower/del")
    public String deleteEmpower(@RequestBody AppUserMap appUserMap){
        return appInfoService.deleteEmpower(appUserMap);
    }

    /**
     * 功能描述: 删除APP与api(多个)关系
     * @param:
     * @param appId APPID
     * @param apiIds apiid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 14:54
     */
    @RequestMapping(value = "/delAppApiMap",method= RequestMethod.DELETE)
    public String delAppApiMap(@RequestParam(name = "appId") String appId,@RequestParam(name = "apiIds")  String apiIds) {
        logger.debug(TextUtils.format("/***根据appid{0}和apiids{1}，删除APP与API列表对应关系**/", appId,apiIds));
        Boolean flay= appInfoService.delAppApiMap(appId,apiIds);
        if (flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 功能描述: app应用授权给用户
     * @param:
     * @param userId 用户id
     * @param appid apiid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 14:57
     */
    @RequestMapping(value = "/addAppUserMap",method= RequestMethod.POST)
    public String addAppUserMap(@RequestParam(name = "userId") String userId,@RequestParam(name = "appid") String appid) {
        logger.debug(TextUtils.format("/***根据userId{0}和appid{1}，app应用授权给用户**/", userId,appid));
        Boolean flay= appInfoService.addAppUserMap(userId,appid);
        if (flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 功能描述: 删除用户与APP的对应关系
     * @param:
     * @param userId 用户id
     * @param appid apiid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:02
     */
    @RequestMapping(value = "/delAppUserMap",method= RequestMethod.DELETE)
    public String delAppUserMap(@RequestParam(name = "userId") String userId,@RequestParam(name = "appid") String appid) {
        logger.debug(TextUtils.format("/***根据userId{0}和appid{1}，删除用户与APP的对应关系**/", userId,appid));
        Boolean flay= appInfoService.delAppUserMap(userId,appid);
        if (flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 功能描述: 根据用户角色，查询该用户的可操作APP
     * @param:
     * @param userId
     * @param roleType
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:10
     */
    @RequestMapping(value = "/userAppList",method= RequestMethod.GET)
    public String userAppList(@RequestParam(name = "userId") String userId,@RequestParam(name = "roleType") String roleType) {
        logger.debug(TextUtils.format("/***根据用户角色{0}，查询该用户{1}的可操作APP**/",userId,roleType));
        List<Map<String, Object>> list = appInfoService.userAppList(userId, roleType);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,list,"").getJson();
    }

    /**
     * 功能描述: 根据appid获取APP下所有api
     * @param:
     * @param appId appid
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:22
     */
    @RequestMapping(value = "/appApiList",method= RequestMethod.GET)
    public String appApiList(@RequestParam(name = "appId") String appId) {
        logger.debug(TextUtils.format("/***根据appid{0}获取app的api列表**/",appId));
        List<AppApiMap> list = appInfoService.appApiList(appId);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,list,"").getJson();
    }

    /**
     * 功能描述: 根据appkey获取APP基本信息
     * @param:
     * @param appKey appkey
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:24
     */
    @RequestMapping(value = "/getAppByAppKey",method= RequestMethod.GET)
    public String selectAppInfoByAppKey(@RequestParam(name = "appKey") String appKey) {
        logger.debug(TextUtils.format("/***根据appkey{0}获取app基本信息**/",appKey));
        AppService appService = appInfoService.selectAppInfoByAppKey(appKey);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,appService,"").getJson();
    }

    /**
     * 功能描述: 根据appkey获取APIList
     * @param:
     * @param appKey appkey
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2018/11/27 15:26
     */
    @RequestMapping(value = "/getApiListByAppKey",method= RequestMethod.GET)
    public String selectApiListByAppKey(@RequestParam(name = "appKey") String appKey) {
        logger.debug(TextUtils.format("/***根据appkey{0}获取apiList**/",appKey));
        List<AppApiMap> appApiMaps = appInfoService.selectApiListByAppKey(appKey);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,appApiMaps,"").getJson();
    }

    /**
     * 功能描述: 新增用户与app关系（messageServiceImpl远程调用专用）
     * @param:
     * @param appUserMap
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/3/28 9:35
     */
    @RequestMapping(value = "/saveAppUserMap",method= RequestMethod.POST)
    public Boolean saveAppUserMap(@RequestBody AppUserMap appUserMap) {
        logger.debug(TextUtils.format("新增用户与app关系映射",appUserMap));
        return appInfoService.saveAppUserMap(appUserMap);
    }

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
    public List<AppUserMap> getApplyUsers(@RequestParam("appIdStr") String appIdStr, @RequestParam("applyUser") String applyUser) {
        logger.debug(TextUtils.format("查询用户与app申请关系（messageServiceImpl远程调用专用）"));
        return appInfoService.getApplyUsers(appIdStr,applyUser);
    }

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
    public Integer delAuditFailureByStatus(@RequestParam("appid") String appid, @RequestParam("userid") String userid) {
        logger.debug(TextUtils.format("根据审批结果删减审核失败的记录（messageServiceImpl远程调用专用）"));
        return appInfoService.delAuditFailureByStatus(appid,userid);
    }

    /**
     * 功能描述: 根据条件查询用户与app的关系（messageServiceImpl远程调用专用）
     * @param:
     * @param senderid
     * @return: java.lang.Integer
     * @auther: zhengshien
     * @date: 2019/3/28 11:43
     */
    @RequestMapping(value = "/selectBySenderid",method= RequestMethod.GET)
    public List<AppUserMap> selectBySenderid(@RequestParam("senderid") String senderid) {
        logger.debug(TextUtils.format("根据条件查询用户与app的关系（messageServiceImpl远程调用专用）"));
        return appInfoService.selectBySenderid(senderid);
    }


    /**
     * 功能描述: 修改APP与用户关系(messageServiceImpl远程调用专用)
     * @param:
     * @param status
     * @param senderid
     * @param apiid
     * @return: java.lang.Integer
     * @auther: zhengshien
     * @date: 2019/3/28 14:37
     */
    @RequestMapping(value = "/updateSelective",method= RequestMethod.GET)
    public Integer updateSelective(@RequestParam("status") Integer status,
                                            @RequestParam("senderid") String senderid,
                                            @RequestParam("apiid") String apiid) {
        logger.debug(TextUtils.format("更新用户与app关系（messageServiceImpl远程调用专用）"));
        return appInfoService.updateSelective(status,senderid,apiid);
    }

    /**
     *
     * 功能描述: 根据appCode获取app详情
     *
     * @param: 
     * @param code
     * @return: com.gla.datacenter.domain.AppService
     * @author: zhangbo
     * @date: 2019/4/10 17:16
     */
    @RequestMapping(value = "/app/getAppByCode")
    public AppService getAppByCode(@RequestParam("code") String code){
        return appInfoService.getAppByCode(code);
    }
}