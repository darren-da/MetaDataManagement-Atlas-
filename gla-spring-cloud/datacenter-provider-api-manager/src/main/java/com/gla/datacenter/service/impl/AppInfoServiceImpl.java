package com.gla.datacenter.service.impl;

import com.gla.datacenter.core.constant.ConstantGla;
import com.gla.datacenter.core.utils.StrCodeUtils;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.mapper.mysql.*;
import com.gla.datacenter.model.AppRequestModel;
import com.gla.datacenter.model.AppResponseModel;
import com.gla.datacenter.model.AppServiceModel;
import com.gla.datacenter.service.AppInfoService;
import com.limp.framework.auth.AuthUtils;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description: AppInfoServiceImpl
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/11/23 11:51
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class AppInfoServiceImpl implements AppInfoService {

    private Logger log = LoggerFactory.getLogger(AppInfoServiceImpl.class);

    @Autowired
    private AppServiceMapper appServiceMapper;

    @Autowired
    private AppApiMapMapper appApiMapMapper;

    @Autowired
    private AppUserMapMapper appUserMapMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private InformationApiMapper informationApiMapper;


    @Override
    public boolean save(AppService entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增App{0}", entry.getId()));
        try {
            entry.setIdt(new Date());
            return appServiceMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(TextUtils.format("app新增失败"));
            return false;
        }
    }

    @Override
    public AppService get(String id) {
        if (StrUtils.isBlank(id)) {
            return null;
        }
        log.debug(TextUtils.format("根据Id{0},获取实体类信息", id));
        return appServiceMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(AppService entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setUdt(new Date());
            return false;
        }
        return appServiceMapper.updateByPrimaryKeySelective(entry) == 1 ? true : false;
    }


    @Override
    public String delAppInfo(String ids) {

        if (StringUtils.isBlank(ids)) {
            return Result.getException("未选中app").getJson();
        }
        String[] str = ids.split(Constant.DHAO);

        try {
            //查询当前是否存在授权的app
            List<String> applyApps = new ArrayList<>();
            applyApps = appUserMapMapper.checkAppApply(str);
            if (applyApps != null && !applyApps.isEmpty()) {
                return Result.getException("当前app已授权给用户,不能删除!").getJson();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }

        try {
            //删除api关联信息
            appApiMapMapper.deleteAppApiMap(str);
            //删除app
            appServiceMapper.deleteAppService(str);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.DEL_SUCCESS, null, null).getJson();
    }

    @Override
    public String updateApp(AppService appService) {
        String rc1 = appService.getRc1();
        String[] apiIds = null;
        if (StringUtils.isNotBlank(rc1)) {
            apiIds = rc1.split(Constant.DHAO);
        }
        appService.setRc1(null);
        //更新app
        try {
            appServiceMapper.updateByPrimaryKeySelective(appService);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
        String[] strs = {appService.getId()};
        if (apiIds != null && apiIds.length > 0) {
            try {
                //删除app和api关联表
                appApiMapMapper.deleteAppApiMap(strs);
                //新增app和api关联表
                appApiMapMapper.batchInsert(appService.getId(), apiIds);
            } catch (Exception e) {
                log.error(e.getMessage());
                return Result.Error().getJson();
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, null, null).getJson();
    }

    @Override
    public String batchEmpowerUser(AppUserMap appUserMap) {
        String userIds = appUserMap.getUserid();
        String appIds = appUserMap.getAppid();
        if (StringUtils.isBlank(userIds)) {
            return Result.getException("未选中待授权用户!").getJson();
        }
        if (StringUtils.isBlank(appIds)) {
            return Result.getException("未选中app!").getJson();
        }
        //获取
        String[] applyUser = userIds.split(Constant.DHAO);
        String[] appIdStr = appIds.split(Constant.DHAO);

        try {
            //查询app和用户是否存在绑定关系

            List<AppUserMap> AppUserMaps = appUserMapMapper.getApplyUsers(appIdStr, applyUser);
            if (AppUserMaps != null && !AppUserMaps.isEmpty()) {
                return Result.getException("存在授权中或已授权的用户!").getJson();
            }
            List<Map<String, Object>> applyList = new ArrayList<>();
            for (String user : applyUser) {
                Map<String, Object> map = new HashMap<>();
                map.put("user", user);
                map.put("appId", new ArrayList<>(Arrays.asList(appIdStr)));
                applyList.add(map);
            }
            appUserMapMapper.batchApplyUser(applyList, new Date());
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getException("授权失败!").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), "授权成功", null, null).getJson();
    }

    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("/***根据Id{0},删除实体类信息**/", id));
        //逻辑删除
        AppService appService = new AppService();
        appService.setId(id);
        appService.setUdt(new Date());
        appService.setStatus(Constant.STATE_DELETE);
        return appServiceMapper.updateByPrimaryKeySelective(appService) == 1 ? true : false;
    }

    @Override
    public List<AppService> getList(AppService entry) {
        return null;
    }

    @Override
    public Pager<AppService> getPageList(AppService entry, Pager pager) {
        return null;
    }

    @Override
    public Pager<AppServiceModel> getAppPageList(AppRequestModel entry, Pager pager) {

        List<AppServiceModel> list = new ArrayList<>();
        String userId = ApplicationContextHolder.currentUser().getId();
        List<AppService> appServiceList = new ArrayList<>();
        if (entry.getAppTerm() == null || entry.getAppTerm().length < 1) {
            pager.setPagerInfo(list, 0);
            return pager;
        }
        log.debug(TextUtils.format("/***根据条件,查询列表【分页方法】**/"));
        //初始化Example
        AppServiceExample appServiceExample = new AppServiceExample();
        //设置分页对象
        appServiceExample.setPage(pager);
        //创建查询条件
        AppServiceExample.Criteria appServiceExampleCriteria = appServiceExample.createCriteria();
        appServiceExampleCriteria.andStatusEqualTo(Constant.NUMBER_1);
        appServiceExampleCriteria.andCreateUserIdEqualTo(userId);
        //根据账号：模糊查询
        if (!StrUtils.isBlank(entry.getAppName())) {
            appServiceExampleCriteria.andAppNameLike("%" + entry.getAppName() + "%");
        }
        if (!StrUtils.isBlank(entry.getDescription())) {
            appServiceExampleCriteria.andDescriptionLike("%" + entry.getDescription() + "%");
        }
        if (!StrUtils.isBlank(entry.getAppCode())) {
            appServiceExampleCriteria.andAppCodeEqualTo(entry.getAppCode());
        }
        if (!StrUtils.isBlank(entry.getRc2())) {
            appServiceExampleCriteria.andAppNameDescriptionLike("%" + entry.getRc2() + "%");
        }
        String[] appTerm = entry.getAppTerm();
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(appTerm));
        //多条件筛选组合查询(可用、异常、过期)
        appServiceExampleCriteria.orTermEqualTo(strings);
        if (!StrUtils.isBlank(entry.getLpsort())) {
            appServiceExample.setOrderByClause(entry.getLpsort());
        } else {
            appServiceExample.setOrderByClause(" IDT DESC");
        }
        appServiceList = appServiceMapper.selectByExample(appServiceExample);
        if (appServiceList != null && !appServiceList.isEmpty()) {
            for (AppService ap : appServiceList) {
                AppServiceModel appServiceModel = new AppServiceModel();
                BeanUtils.copyProperties(ap, appServiceModel);
                //根据appid查询api集合
                List<String> apiList = appApiMapMapper.getApiListByAppId(ap.getId());
                if (apiList != null && !apiList.isEmpty()) {
                    List<Map<String, Object>> apiInfor = informationApiMapper.getApiInformationByApis(apiList);
                    appServiceModel.setApiList(apiInfor);
                }
                list.add(appServiceModel);
            }
        }

        pager.setPagerInfo(list, appServiceMapper.countByExample(appServiceExample));

        return pager;
    }

    @Override
    public String getAppListByConsumer(AppRequestModel appRequestModel, Pager pager) {

        Map<String, Object> paramMap = new HashMap<>();
        List<AppResponseModel> list = new ArrayList<>();

        if (StringUtils.isNotBlank(appRequestModel.getAppName())) {
            paramMap.put("name", appRequestModel.getAppName());
        }
        if (StringUtils.isNotBlank(appRequestModel.getAppCode())) {
            paramMap.put("code", appRequestModel.getAppCode());
        }
        if (StringUtils.isNotBlank(appRequestModel.getDescription())) {
            paramMap.put("desc", appRequestModel.getDescription());
        }
        //标题或者内容模糊查询
        if (StringUtils.isNotBlank(appRequestModel.getRc2())) {
            paramMap.put("rc2", appRequestModel.getRc2());
        }
        paramMap.put("type", appRequestModel.getType());
        String[] appTerm = appRequestModel.getAppTerm();
        if (appTerm != null && appTerm.length > 0) {
            ArrayList<String> str = new ArrayList<>(Arrays.asList(appTerm));
            paramMap.put("appTerm", str);
        } else {
            pager.setPagerInfo(list, 0);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();
        }

        //该属性用于接收消费者应用目录 已加入的appId，以','分割
        if (StringUtils.isNotBlank(appRequestModel.getAppJoin())) {
            paramMap.put("appJoin", appRequestModel.getAppJoin().split(","));
        }
        if (StringUtils.isBlank(appRequestModel.getUserId())) {
            String userId = ApplicationContextHolder.currentUser().getId();
            paramMap.put("userId", userId);
        } else {
            paramMap.put("userId", appRequestModel.getUserId());
        }
        int count = 0;
        try {
            Pager pagerCopy = null;
            count = appServiceMapper.getAppListByConsumer(paramMap, pagerCopy).size();
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
        list = appServiceMapper.getAppListByConsumer(paramMap, pager);
        pager.setPagerInfo(list, count);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();
    }

    @Override
    public String searchApplyApiByConsumer(InformationApi informationApi) {

        String rc2 = informationApi.getRc2();
        if (StringUtils.isBlank(rc2)) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, new ArrayList<>(), null).getJson();
        }

        return null;
    }

    @Override
    public String countConsumerApp() {

        String userId = ApplicationContextHolder.currentUser().getId();
        Map<String, Integer> countMap = new HashMap<>();
        try {
            //获取消费者app总数和未申请、申请中、已加入、开放、已授权app个数
            countMap = appServiceMapper.countConsumerApp(userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getException("查询失败!").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, countMap, null).getJson();
    }

    @Override
    public String countProviderApp() {

        String userId = ApplicationContextHolder.currentUser().getId();

        //获取生产者app总数和全网、需申请、不共享个数
        Map<String, Integer> countMap = new HashMap<>();

        try {
            countMap = appServiceMapper.countProviderApp(userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getException("查询失败!").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, countMap, null).getJson();
    }

    @Override
    public String getAppApplyByAppId(String id) {

        //根据appId查询授权人员基本信息
        List<UserInfo> userInfos = new ArrayList<>();
        try {
            List<AppUserMap> appUserMapList = appUserMapMapper.getApplyInforByAppId(id);
            if (appUserMapList != null && !appUserMapList.isEmpty()) {
                for (AppUserMap um : appUserMapList) {
                    String userId = um.getUserid();
                    if (StringUtils.isNotBlank(userId)) {
                        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
                        if (userInfo != null) {
                            userInfos.add(userInfo);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, userInfos, null).getJson();
    }

    @Override
    public String getAppDetailByAppId(String id) {

        List<InformationApi> list = new ArrayList<>();
        try {
            list = informationApiMapper.getAppDetailByAppId(id);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.info("根据appId:{}查询app详情失败",id);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, null).getJson();
    }

    @Override
    public String addApply(AppUserMap appUserMap) {

        UserInfo userInfo = ApplicationContextHolder.currentUser();
        if (StringUtils.isBlank(appUserMap.getAppid())) {
            Result.Error().getJson();
        }
        String appId = appUserMap.getAppid();
        String[] split = appId.split(Constant.DHAO);
        try {
            //查询当前的appId中已授权或者申请中的
            List<String> isApplyList = appUserMapMapper.checkIsEmpower(split, userInfo.getId());
            if (split.length > isApplyList.size()) {
                ArrayList<String> str = new ArrayList<>(Arrays.asList(split));
                List<String> lowStr = new ArrayList<>(CollectionUtils.subtract(str, isApplyList));
                //获取未授权的基本信息(app是否是开放的)
                List<String> openList = new ArrayList<>();
                List<String> noOpenList = new ArrayList<>();
                //获取app基本信息
                List<AppService> appList = appServiceMapper.getBatchInformationApi(lowStr);
                if (appList != null && !appList.isEmpty()) {
                    for (AppService appInfor : appList) {
                        if (appInfor.getShareType() == ConstantClazz.SHARE_LEVEL_ALL) {
                            openList.add(appInfor.getId());
                        } else if (appInfor.getShareType() == ConstantClazz.SHARE_LEVEL_APPLY) {
                            noOpenList.add(appInfor.getId());
                        }
                    }
                    //批量授权
                    try {
                        if (openList != null && !openList.isEmpty()) {
                            appUserMapMapper.batchEmpower(openList, userInfo.getId());
                        }
                        return Result.getInstance(ResultCode.SUCCESS.toString(), "授权成功!", noOpenList, null).getJson();
                    } catch (Exception e) {
                        log.error(e.getMessage());
                        return Result.Error().getJson();
                    }
                }
            } else {
                return Result.getInstance("201", "您已授权成功，不需要重复授权!", null, null).getJson();
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(),"加入申请失败",null,null).getJson();
        }
        return null;
    }

    @Override
    public String checkJoinApp(AppService appService) {
        String id = appService.getId();
        List<AppService> apps = new ArrayList<>();
        if (StringUtils.isNotBlank(id)) {
            String[] str = id.split(Constant.DHAO);
            try {
                apps = appServiceMapper.checkJoinApp(str);
            } catch (Exception e) {
                log.error(e.getMessage());
                return Result.Error().getJson();
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, apps, null).getJson();
    }

    @Override
    public Boolean saveAppUserMap(AppUserMap appUserMap) {
        try {
            return appUserMapMapper.insertSelective(appUserMap) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<AppUserMap> getApplyUsers(String appIdStr, String applyUser) {
        try {
            String[] idList = appIdStr.split(Constant.DHAO);
            String[] userList = applyUser.split(Constant.DHAO);
            return appUserMapMapper.getApplyUsers(idList, userList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer delAuditFailureByStatus(String appid, String userid) {
        try {
            return appUserMapMapper.delAuditFailureByStatus(appid, userid);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AppUserMap> selectBySenderid(String senderid) {
        AppUserMapExample appUserMapExample = new AppUserMapExample();
        appUserMapExample.createCriteria().andUseridEqualTo(senderid);
        return appUserMapMapper.selectByExample(appUserMapExample);
    }

    @Override
    public Integer updateSelective(Integer status, String senderid, String apiid) {
        AppUserMap appUserMap1 = new AppUserMap();
        appUserMap1.setApplyStatus(status);
        AppUserMapExample example = new AppUserMapExample();
        example.createCriteria().andUseridEqualTo(senderid).andAppidEqualTo(apiid);
        return appUserMapMapper.updateByExampleSelective(appUserMap1, example);
    }

    @Override
    public AppService getAppByCode(String code) {

        if(StringUtils.isBlank(code)){
            return null;
        }
        try {
            AppService as = appServiceMapper.getAppByCode(code);
            return as;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String deleteEmpower(AppUserMap appUserMap) {

        String userIds = appUserMap.getUserid();
        if (StringUtils.isBlank(userIds)) {
            return Result.getException("未选中用户!").getJson();
        }
        String[] userStr = userIds.split(Constant.DHAO);
        String appIds = appUserMap.getAppid();
        if (StringUtils.isBlank(appIds)) {
            return Result.getException("未选中app!").getJson();
        }
        String[] appIdStr = appIds.split(Constant.DHAO);
        try {
            appUserMapMapper.delEmpowerByUserId(userStr, appIdStr);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR, null, null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.DEL_SUCCESS, null, null).getJson();
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
    @Override
    public boolean addAppApiMap(String appId, String apiIds) {
        //参数非空校验
        if (StrUtils.isBlank(apiIds) || StrUtils.isBlank(appId)) {
            log.info("参数异常：参数appId或apiIds为空！");
            return false;
        }
        if (apiIds.indexOf(Constant.DHAO) > -1) {
            for (String apiId : apiIds.split(Constant.DHAO)) {
                //过滤已存在的api
                AppApiMapExample appApiMapExample = new AppApiMapExample();
                appApiMapExample.createCriteria().andAppidEqualTo(appId).andApiidEqualTo(apiId);
                List<AppApiMap> appApiMaps = appApiMapMapper.selectByExample(appApiMapExample);
                //如果该api不存在，则添加至表中
                if (appApiMaps.size() == Constant.NUMBER_0) {
                    try {
                        AppApiMap appApiMap = new AppApiMap();
                        appApiMap.setAppid(appId);
                        appApiMap.setApiid(apiId);
                        appApiMapMapper.insertSelective(appApiMap);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        return false;
                    }
                }
            }
        } else {
            AppApiMap appApiMap = new AppApiMap();
            appApiMap.setAppid(appId);
            appApiMap.setApiid(apiIds);
            appApiMapMapper.insertSelective(appApiMap);
        }

        return true;
    }

    @Override
    public String addAppByProvider(AppService appService) {

        if (StringUtils.isBlank(appService.getRc1())) {
            return Result.getException("未选中api").getJson();
        }
        String userId = ApplicationContextHolder.currentUser().getId();
        String id = StrUtils.randomUUID();
        String apiIds = appService.getRc1();
        appService.setId(id);
        appService.setAppCode(StrCodeUtils.createCode("P"));
        appService.setIdt(new Date());
        appService.setRc1(null);
        appService.setCreateUserId(userId);
        //appService.setShareType(Constant.NUMBER_0);
        appService.setStatus(Constant.NUMBER_1);
        appService.setAppType(Constant.NUMBER_1);
        try {
            appServiceMapper.insertSelective(appService);
            String[] split = apiIds.split(Constant.DHAO);
            appApiMapMapper.batchInsert(id, split);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ADD_ERROR, null, null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_SUCCESS, null, null).getJson();
    }

    @Override
    public String addAppByConsumer(AppService appService) {

        if (StringUtils.isBlank(appService.getRc1())) {
            return Result.getException("未选中api").getJson();
        }
        String userId = ApplicationContextHolder.currentUser().getId();
        String id = StrUtils.randomUUID();
        String apiIds = appService.getRc1();
        appService.setId(id);
        appService.setAppCode(StrCodeUtils.createCode("P"));
        appService.setIdt(new Date());
        appService.setRc1(null);
        appService.setCreateUserId(userId);
        appService.setShareType(null);
        appService.setStatus(Constant.NUMBER_1);
        appService.setAppType(Constant.NUMBER_2);
        try {
            appServiceMapper.insertSelective(appService);
            String[] split = apiIds.split(Constant.DHAO);
            appApiMapMapper.batchInsert(id, split);
            //直接给当前消费者授权
            appUserMapMapper.batchEmpower(new ArrayList<>(Arrays.asList(id)), userId);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ADD_ERROR,null,null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_SUCCESS, null, null).getJson();
    }

    @Override
    public boolean delAppApiMap(String appId, String apiIds) {
        if (StrUtils.isBlank(apiIds) || StrUtils.isBlank(appId)) {
            log.info("参数异常：参数为空！");
            return false;
        }
        //解析apiIds，循环删除
        if (apiIds.indexOf(Constant.DHAO) > -1) {
            for (String apiId : apiIds.split(Constant.DHAO)) {
                AppApiMapExample example = new AppApiMapExample();
                example.createCriteria().andAppidEqualTo(appId).andApiidEqualTo(apiId);
                try {
                    appApiMapMapper.deleteByExample(example);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                    return false;
                }
            }
        } else {
            AppApiMapExample example = new AppApiMapExample();
            example.createCriteria().andAppidEqualTo(appId).andApiidEqualTo(apiIds);
            appApiMapMapper.deleteByExample(example);
        }
        return true;
    }

    @Override
    public boolean addAppUserMap(String userId, String appid) {
        if (StrUtils.isBlank(userId) || StrUtils.isBlank(appid)) {
            log.info("参数异常：参数为空！");
            return false;
        }
        //过滤已添加过的用户和app关系
        AppUserMapExample appUserMapExample = new AppUserMapExample();
        appUserMapExample.createCriteria().andUseridEqualTo(userId).andAppidEqualTo(appid);
        //根据输入的条件查询
        List<AppUserMap> appUserMaps = appUserMapMapper.selectByExample(appUserMapExample);
        //若该用户与app关系未存在，可添加
        if (appUserMaps.size() == 0) {
            AppUserMap appUserMap = new AppUserMap();
            appUserMap.setUserid(userId);
            appUserMap.setAppid(appid);
            //appkey生成规则为userid+appid后，再加密
            appUserMap.setAppKey(ConstantGla.APPKEY_PRE + AuthUtils.encodeMD5(userId + appid, ""));
            return appUserMapMapper.insertSelective(appUserMap) == 1 ? true : false;
        } else {
            log.info("操作异常：该用户{0}与APP{1}已存在，请勿重复添加", userId, appid);
            return false;
        }

    }

    @Override
    public boolean delAppUserMap(String userId, String appid) {
        if (StrUtils.isBlank(userId) || StrUtils.isBlank(appid)) {
            return false;
        }
        AppUserMapExample appUserMapExample = new AppUserMapExample();
        appUserMapExample.createCriteria().andAppidEqualTo(appid).andUseridEqualTo(userId);

        return appUserMapMapper.deleteByExample(appUserMapExample) == 1 ? true : false;
    }

    @Override
    public List<Map<String, Object>> userAppList(String userId, String roleType) {
        if (StrUtils.isBlank(userId) || StrUtils.isBlank(roleType)) {
            return null;
        }
        List list = new ArrayList();
        //根据用户id查询此用户下的所有APP
        AppUserMapExample appUserMapExample = new AppUserMapExample();
        appUserMapExample.createCriteria().andUseridEqualTo(userId);
        List<AppUserMap> appUserMaps = appUserMapMapper.selectByExample(appUserMapExample);
        //循环APP列表
        for (AppUserMap appUserMap : appUserMaps) {
            AppService appService = get(appUserMap.getAppid());
            Map AppMap = new HashMap();
            //找出用户id和APPType=roleType的列表
            if (appService.getAppType() == Integer.valueOf(roleType)) {
                AppServiceExample appServiceExample = new AppServiceExample();
                appServiceExample.createCriteria().andCreateUserIdEqualTo(appService.getCreateUserId())
                        .andAppTypeEqualTo(Integer.valueOf(roleType));
                List<AppService> appServices = appServiceMapper.selectByExample(appServiceExample);

                AppMap.put(userId, appServices);
                list.add(AppMap);
            }
        }
        return list;
    }

    @Override
    //勿删！ 备用数据格式 对接时确定
//    public List<Map<String, Object>> appApiList(String appId) {
    public List<AppApiMap> appApiList(String appId) {
        AppApiMapExample appApiMapExample = new AppApiMapExample();
        appApiMapExample.createCriteria().andAppidEqualTo(appId);
//        List<AppApiMap> appApiMaps = appApiMapMapper.selectByExample(appApiMapExample);
        return appApiMapMapper.selectByExample(appApiMapExample);
    }

    @Override
    public AppService selectAppInfoByAppKey(String appKey) {
        try {
            log.info("根据appkey查询APP详细信息", appKey);
            return appServiceMapper.selectAppInfoByAppKey(appKey);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            return null;
        }
    }

    @Override
//    public List<Map<String, Object>> selectApiListByAppKey(String appKey) {
    public List<AppApiMap> selectApiListByAppKey(String appKey) {
        log.info("根据appKey{0}查询APP对应的ApiList", appKey);
        AppUserMapExample appUserMapExample = new AppUserMapExample();
        appUserMapExample.createCriteria().andAppKeyEqualTo(appKey);
        List<AppUserMap> appUserMaps = appUserMapMapper.selectByExample(appUserMapExample);
        AppUserMap appUserMap1 = appUserMaps.get(0);

        AppApiMapExample appApiMapExample = new AppApiMapExample();
        appApiMapExample.createCriteria().andAppidEqualTo(appUserMap1.getAppid());
//            List<AppApiMap> appApiMaps = appApiMapMapper.selectByExample(appApiMapExample);
        return appApiMapMapper.selectByExample(appApiMapExample);
    }
}