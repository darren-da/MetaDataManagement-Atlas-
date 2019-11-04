package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gla.datacenter.core.constant.ConstantGla;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.mapper.mysql.*;
import com.gla.datacenter.model.AppCenterRequestModel;
import com.gla.datacenter.model.ParamModel;
import com.gla.datacenter.service.ApiCenterService;
import com.gla.datacenter.service.AppClientService;
import com.gla.datacenter.service.OrderClientService;
import com.gla.datacenter.service.RestRequestService;
import com.gla.datacenter.utils.CompletableFutureUtils;
import com.gla.datacenter.utils.RxJavaUtils;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.IpUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import com.limp.framework.utils.ThreadPoolUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther: zhangbo
 * @Date: 2018/9/26 10:30
 * @Description:
 */
@Service
public class ApiCenterServiceImpl implements ApiCenterService {

    private Logger loger = LoggerFactory.getLogger(ApiCenterServiceImpl.class);

    @Autowired
    private InformationApiMapper informationApiMapper;

    @Autowired
    private ParmsApiMapper parmsApiMapper;

    @Autowired
    private RestRequestService restRequestService;

    @Autowired
    private SoapWebserviceClientImpl soapWebserviceClientImpl;

    @Autowired
    private OrderClientService orderClientService;

    @Autowired
    private AppClientService appClientService;

    @Autowired
    private RequestContextHolderUtil requestContextHolderUtil;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private FilterInformationApiMapper filterInformationApiMapper;

    @Autowired
    private ApiNumLimtMapper apiNumLimtMapper;

    @Autowired
    private RestTemplate restTemplateCenter;

    @Override
    public String requestApi(Map<String, Object> params,String code,String apiKey) {

        if(StringUtils.isBlank(code)){
            //异常通知
            return Result.getException(ExceptionEnum.ParamNumIllegal).getJson();
        }
        //根据授权码判断其是否有访问权限
        //String apiKey = params.get(ConstantClazz.PARAM_API_KEY).toString();
        if(StringUtils.isBlank(apiKey)){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.API_KEY_ERROR,null,null).getJson();
        }

        /**
         * 功能描述: 根据授权码获取当前用户及其访问权限(未考虑当前账户是否到期)
         * @auther: zhangbo
         * @date: 2018/11/15 13:44
         */
        String userId = "";
        if(!apiKey.startsWith(ConstantGla.APIKEY_PRE)){
            return Result.getInstance(ResultCode.ERROR_USER_502.toString(),ResultMsg.API_KEY_ERROR,null,null).getJson();
        }
        UserInfo userInfo = userInfoMapper.getUserInfoByApiKey(apiKey);
        if(userInfo == null){
            return Result.getInstance(ResultCode.ERROR_USER_502.toString(),ResultMsg.API_KEY_ERROR,null,null).getJson();
        }
        userId = userInfo.getId();
        InformationApi informationApi = new InformationApi();
        List<InformationApi> informationApis = informationApiMapper.selectApiInformationByCode(code);
        if(informationApis != null && !informationApis.isEmpty()){
            informationApi = informationApis.get(0);
            //当前用户是否已被放置到黑白名单
            FilterInformationApi filterInformationApi = filterInformationApiMapper.getFilterByUserIdAndApiId(informationApi.getProducerId(),userId);
            if(filterInformationApi != null){
                if(filterInformationApi.getFilterType() == 1){
                    if(filterInformationApi.getListType() == 1){
                        return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                    }
                }
            }else{
                //判断当前api是否是全网共享
                if(informationApi.getShareLevel() == ConstantClazz.SHARE_LEVEL_ALL){

                }else if(informationApi.getShareLevel() == ConstantClazz.SHARE_LEVEL_NONE){
                    return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                }else{
                    //根据apiId和用户id判断当前授权状态
                    List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.getApiAuditStatus(informationApi.getId(),userInfo.getId());
                    if(apiNumLimts != null && !apiNumLimts.isEmpty()){
                    }else{
                        return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                    }
                }
            }
        }else{
            return Result.getException(ExceptionEnum.SysError404).getJson();
        }

        //是否过期
        if(informationApi.getExpireFlag() == (byte) 1){
            //异常通知
            return Result.getException(ExceptionEnum.ApiExpireException).getJson();
        }
        //是否已删除
        if(informationApi.getDeleteFlag() == ConstantClazz.DELETE_FLAG_TRUE){
            //异常通知
            return Result.getException(ExceptionEnum.SysError404).getJson();
        }
        String result = resolveParms(params, informationApi,userId);
        return result;
    }


    @Override
    public String requestApp(List<Map<String, Object>> params, String code){

        long startTime = System.currentTimeMillis();

        //根据appcode获取当前app基本信息
        AppService appByCode = appClientService.getAppByCode(code);
        if(appByCode == null){
            return Result.getException("当前路径有误!").getJson();
        }
        //根据appCode获取是否有访问权限
        //根据appCode获取所有的apiCode
        List<String> apiCodeList = informationApiMapper.getApiCodeByAppCode(code);
        List<AppCenterRequestModel> requestList = new ArrayList<>();
        List<InformationApi> apiList = new ArrayList<>();
        //保存接收的apiCode
        List<String> strCode = new ArrayList<>();
        //apiCode和参数绑定
        Map<String,String> codeParam = new HashMap<>();
        if(params != null && !params.isEmpty()){
            for(Map<String, Object> param : params){
                if(param.containsKey("code")){
                    if(param.get("code") != null){
                        String apiCode = param.get("code").toString();
                        if(apiCodeList.contains(apiCode)){
                            strCode.add(apiCode);
                            codeParam.put(apiCode,param.get("param") == null ? null : JSONObject.toJSON(param.get("param")).toString());
                        }
                    }
                }
            }
        }
        //apiCodeList和strCode取交集(只请求appCode中包含的api，若用户未传相应参数则不请求)
        //apiCodeList.retainAll(strCode);

        //根据code集合获取api的url、请求类型、接口类型(不过滤api状态或者是否已删除)
        apiList = informationApiMapper.getApiInforByApiCode(strCode,false,false);
        if(apiList != null && !apiList.isEmpty()){
            for(InformationApi informationApi : apiList){
                AppCenterRequestModel appCenterRequestModel = new AppCenterRequestModel();
                appCenterRequestModel.setApiCode(informationApi.getApiCode());
                appCenterRequestModel.setApiType(informationApi.getApiType().toString());
                appCenterRequestModel.setRequestType(ConstantClazz.requestType.get(informationApi.getRequestType()));
                appCenterRequestModel.setApiUrl(informationApi.getUrl());
                appCenterRequestModel.setParams(codeParam.get(informationApi.getApiCode()));
                requestList.add(appCenterRequestModel);
            }
        }
        long endTime = System.currentTimeMillis();
        System.err.println("处理参数这部分耗时:" + (endTime - startTime) + "ms");
        String result = request(requestList,appByCode,params);
        System.out.println("result的值:" + result);
        return result;
    }

    public String request(List<AppCenterRequestModel> requestList, AppService appByCode,List<Map<String, Object>> params){
        List<Map<String, Object>> resultList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        int status = 0;
        System.err.println("当前主线程名称:" + name);
        if(requestList != null && !requestList.isEmpty()){
            List<CompletableFuture<Map<String, Object>>> listFuture = new ArrayList<>();
            for(AppCenterRequestModel request : requestList){
                CompletableFuture<Map<String, Object>> future = CompletableFuture.supplyAsync(() -> {
                    Map<String, Object> map = new HashMap<>();
                    map = CompletableFutureUtils.reloadHttp(restTemplateCenter,request.getApiCode(),
                            request.getApiUrl(),request.getRequestType(),request.getApiType(),request.getParams());
                    return map;
                }, ThreadPoolUtils.getInstance().createExecutor());
                listFuture.add(future);
            }

            CompletableFuture<Void> allFutures = CompletableFuture.allOf(listFuture.toArray(new CompletableFuture[listFuture.size()]));
            //汇总返回结果
            //CompletableFuture<List<Map<String, Object>>> finalResultss = allFutures.
            long endTime1 = System.currentTimeMillis();
            System.err.println("结果未汇聚前请求耗时:" + (endTime1-startTime));

            CompletableFuture<List<Map<String, Object>>> finalResults = allFutures.thenApply(v -> {
                return listFuture.stream().map(accountFindingFuture -> accountFindingFuture.join())
                        .collect(Collectors.toList());
            });
            try {
                resultList = finalResults.get();
            } catch (InterruptedException e) {
                status = 1;
                e.printStackTrace();
            } catch (ExecutionException e) {
                status = 1;
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.err.println("整个请求访问耗时:" + (endTime - startTime));
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(StrUtils.randomUUID());
        orderInfo.setServiceId(appByCode.getId());
        orderInfo.setServiceName(appByCode.getAppName());
        orderInfo.setIdt(new Date());
        orderInfo.setRc6("2");
        orderInfo.setOrderNo(StrUtils.getOrderNo());
        //orderInfo.setUsrid(userId);
        orderInfo.setIp(IpUtils.getIpAddr(requestContextHolderUtil.getRequest()));
        //loger.info("---------------访问接口的url为:" + informationApi.getUrl());
        if(status == 0){
            orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_NORMAL);
            orderInfo.setRc8(Integer.parseInt(String.valueOf(endTime-startTime)));
            orderInfo.setRc7(Integer.valueOf(resultList.toString().getBytes().length));
        }else{
            orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_ABNORMAL);
            orderInfo.setRc7(0);
            orderInfo.setRc8(0);
        }
        orderInfo.setParms(params.toString());
        orderInfo.setOrderResult(Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultList,null).getJson());
        try{
            orderClientService.sendOrderMQMsg(orderInfo);
        }catch(Exception e){
            loger.debug(appByCode.getId() + "保存订单数据失败！");
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultList,null).getJson();
    }


    public String request1(List<AppCenterRequestModel> requestList){
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<Observable<Map<String, Object>>> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        System.err.println("当前主线程名称:" + name);
        if(requestList != null && !requestList.isEmpty()){
            for(AppCenterRequestModel request : requestList){

                Observable<Map<String, Object>> reloadMap = RxJavaUtils.reloadRxJava(restTemplateCenter,request.getApiCode(),
                        request.getApiUrl(),request.getRequestType(),request.getApiType(),request.getParams());
                list.add(reloadMap);

            }
        }
        Observable.merge(list).subscribe(new Consumer<Map<String, Object>>() {
            @Override
            public void accept(Map<String, Object> objectMap) throws Exception {
                String name = Thread.currentThread().getName();
                System.err.println("线程:" + name + ";" + System.currentTimeMillis() + objectMap.toString());
                resultList.add(objectMap);
            }
        });
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.err.println("执行耗时:" + (endTime - startTime) + "ms");
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultList,null).getJson();
    }

    /*public String request(List<AppCenterRequestModel> requestList){
        //使用的同一个线程，待优化,计划升级到RxJava2以上
        List<Map<String, Object>> resultList = new ArrayList<>();
        List<rx.Observable<Map<String, Object>>> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        String name = Thread.currentThread().getName();
        System.err.println("当前主线程名称:" + name);
        if(requestList != null && !requestList.isEmpty()){
            for(AppCenterRequestModel request : requestList){

                rx.Observable<Map<String, Object>> reloadMap = RxJavaUtils.reloadRxJava(restTemplateCenter,request.getApiCode(),
                        request.getApiUrl(),request.getRequestType(),request.getApiType(),request.getParams());
                list.add(reloadMap);

            }
        }
        //mergeDelayError

        rx.Observable.merge(list).subscribe(new rx.Observer<Map<String, Object>>(){
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(Map<String, Object> objectMap) {
                String name = Thread.currentThread().getName();
                System.err.println("线程:" + name + ";" + System.currentTimeMillis() + objectMap.toString());
                //System.err.println("合并线程名称:" + name);
                resultList.add(objectMap);
            }
        });
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            loger.error(e.getMessage());
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.err.println("执行耗时:" + (endTime - startTime) + "ms");
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultList,null).getJson();
    }*/

    @Override
    public String requestMethod(Map<String, Object> params, String code) {
        if(StringUtils.isBlank(code)){
            return Result.getException(ExceptionEnum.ParamNumIllegal).getJson();
        }

        String apiKey = params.get(ConstantClazz.PARAM_API_KEY).toString();
        if(StringUtils.isBlank(apiKey)){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.API_KEY_ERROR,null,null).getJson();
        }

        String userId = "";
        UserInfo userInfo = userInfoMapper.getUserInfoByApiKey(apiKey);
        if(userInfo == null){
            return Result.getInstance(ResultCode.ERROR_USER_502.toString(),ResultMsg.API_KEY_ERROR,null,null).getJson();
        }

        userId = userInfo.getId();
        InformationApi informationApi = new InformationApi();
        List<InformationApi> informationApis = informationApiMapper.selectApiInformationByCode(code);
        if(informationApis != null && !informationApis.isEmpty()){
            informationApi = informationApis.get(0);
            //当前用户是否已被放置到黑白名单
            FilterInformationApi filterInformationApi = filterInformationApiMapper.getFilterByUserIdAndApiId(informationApi.getProducerId(),userInfo.getId());
            if(filterInformationApi != null){
                if(filterInformationApi.getFilterType() == 1){
                    if(filterInformationApi.getListType() == 1){
                        return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                    }
                }
            }else{
                //判断当前api是否是全网共享
                if(informationApi.getShareLevel() == ConstantClazz.SHARE_LEVEL_ALL){

                }else if(informationApi.getShareLevel() == ConstantClazz.SHARE_LEVEL_NONE){
                    return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                }else{
                    //根据apiId和用户id判断当前授权状态
                    List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.getApiAuditStatus(informationApi.getId(),userInfo.getId());
                    if(apiNumLimts != null && !apiNumLimts.isEmpty()){
                    }else{
                        return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                    }
                }
            }
        }else{
            return Result.getException(ExceptionEnum.SysError404).getJson();
        }

        //是否过期
        if(informationApi.getExpireFlag() == (byte) 1){
            //异常通知
            return Result.getException(ExceptionEnum.ApiExpireException).getJson();
        }
        //是否已删除
        if(informationApi.getDeleteFlag() == ConstantClazz.DELETE_FLAG_TRUE){
            //异常通知
            return Result.getException(ExceptionEnum.SysError404).getJson();
        }

        String result = resolveParams(params, informationApi,userId);
        return result;
    }


    /**
     *
     * 功能描述: 解析请求参数，并且适配真实参数
     *
     * @param: []
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/9/27 13:22
     */

    public String resolveParms(Map<String, Object> params,InformationApi informationApi,String userId){

        //保存解析后的参数和参数值
        Map<String, Object> maps = new HashMap<>();

        Map<String, Object> keyMap = new HashMap<>();
        keyMap = removeApiId(params);
        String result = "";
        List<ParmsApi> shamParms = new ArrayList<>();
        if(informationApi.getParmsFlag() == ConstantClazz.PARMS_FLAG_TRUE){

            //获取api参数列表
            shamParms = parmsApiMapper.getShamParms(informationApi.getId());
            if(shamParms != null && !shamParms.isEmpty()){

                if(shamParms.size()  != keyMap.size()){
                    //异常通知
                    result = Result.getException(ExceptionEnum.ParamNumIllegal).getJson();
                    return result;
                }
                //获取参数集合
                List<String> strRequiredList = parmsApiMapper.getRequiredParmsList(informationApi.getId());
                //根据参数匹配(暂时固定死值)
                for (Map.Entry<String, Object> map : keyMap.entrySet()) {
                    if(!shamParms.toString().contains("shamParms='" + map.getKey() + "'")){
                        //异常通知
                        result = Result.getException(ExceptionEnum.ParamNameIllegal).getJson();
                        return result;
                    }
                    if(strRequiredList.contains(map.getKey())){
                        if(StringUtils.isBlank(String.valueOf(map.getValue()))){
                            //异常通知
                            result = Result.getException(ExceptionEnum.ParamISNUll).getJson();
                            return result;
                        }
                    }
                    //先双层for循环处理（待优化）
                    for(ParmsApi parmsApi : shamParms){
                        if(map.getKey().equals(parmsApi.getShamParms())){
                            maps.put(parmsApi.getRealParms(),map.getValue());
                            break;
                        }
                    }
                }

            }else{
                //异常通知
                result = Result.getException(ExceptionEnum.ParamISNUll).getJson();
                return result;
            }
        }
        //参数属性名一致未做筛选（依赖于顺序筛选或者值类型筛选）
        int flux = 0;
        long startTime = System.currentTimeMillis();
        JSONObject jsonObject = new JSONObject();
        if(informationApi.getApiType() == ConstantClazz.API_TYPE_HTTP) {
            result = restRequestService.restMethod(maps, informationApi);

        }else if(informationApi.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
            try {
                result = soapWebserviceClientImpl.sendHttpRequest(maps,informationApi);
            } catch (IOException e) {
            }
        }else if(informationApi.getApiType() == ConstantClazz.API_TYPE_RPC){
            result = null;
        }
        long endTime = System.currentTimeMillis();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(StrUtils.randomUUID());
        orderInfo.setServiceId(informationApi.getId());
        orderInfo.setServiceName(informationApi.getApiName());
        orderInfo.setIdt(new Date());
        orderInfo.setRc6("1");
        orderInfo.setOrderNo(StrUtils.getOrderNo());
        orderInfo.setUsrid(userId);
        orderInfo.setIp(IpUtils.getIpAddr(requestContextHolderUtil.getRequest()));
        loger.info("---------------访问接口的url为:" + informationApi.getUrl());
        orderInfo.setUrl(informationApi.getUrl());
        /*orderInfo.setRc2();单位名称暂时不录入*/
        jsonObject = JSONObject.parseObject(result);
        if("200".equals(jsonObject.get("code"))){
            Map<String, Object> ext = (Map<String, Object>)jsonObject.get("ext");
            if(ext != null && !ext.isEmpty()&&ext.containsKey("flux")){
                flux = Integer.parseInt(ext.get("flux").toString());
                result = jsonObject.get("result").toString();
            }
            orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_NORMAL);
            orderInfo.setRc8(Integer.parseInt(String.valueOf(endTime-startTime)));
            orderInfo.setRc7(flux);
        }else{
            orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_ABNORMAL);
            orderInfo.setRc7(0);
            orderInfo.setRc8(0);
        }
        orderInfo.setParms(keyMap.toString());
        orderInfo.setOrderResult(result);
        try{
            orderClientService.sendOrderMQMsg(orderInfo);
        }catch(Exception e){
            e.printStackTrace();
            loger.debug(informationApi.getId() + "保存订单数据失败！");
        }
        return result;
    }


    public String resolveParams(Map<String, Object> params,InformationApi informationApi, String userId){

        String result = "";
        List<ParamModel> paramResult = new ArrayList<>();
        Map<String, Object> keyMap = new HashMap<>();
        //removeapikey
        keyMap = removeApiId(params);
        List<ParmsApi> shamParms = new ArrayList<>();
        if(informationApi.getParmsFlag() == ConstantClazz.PARMS_FLAG_TRUE){
            shamParms = parmsApiMapper.getShamParms(informationApi.getId());
            if(shamParms != null && !shamParms.isEmpty()){
                if(shamParms.size() != keyMap.size()){
                    //异常通知
                    result = Result.getException(ExceptionEnum.ParamNumIllegal).getJson();
                    return result;
                }
                //获取封装参数集合
                List<String> strRequiredList = parmsApiMapper.getRequiredParmsList(informationApi.getId());
                if(strRequiredList != null && !strRequiredList.isEmpty()){
                    for (Map.Entry<String, Object> map : keyMap.entrySet()) {
                        if(!shamParms.toString().contains("shamParms='" + map.getKey() + "'")){
                            //异常通知
                            result = Result.getException(ExceptionEnum.ParamNameIllegal).getJson();
                            return result;
                        }
                        if(strRequiredList.contains(map.getKey())){
                            if(StringUtils.isBlank(String.valueOf(map.getValue()))){
                                //异常通知
                                result = Result.getException(ExceptionEnum.ParamISNUll).getJson();
                                return result;
                            }
                        }
                        //先双层for循环处理（待优化）
                        for(ParmsApi parmsApi : shamParms){
                            if(map.getKey().equals(parmsApi.getShamParms())){
                                ParamModel paramModel = new ParamModel();
                                paramModel.setParamKey(parmsApi.getRealParms());
                                paramModel.setParamValue(map.getValue());
                                paramModel.setParamType(parmsApi.getType());
                                paramResult.add(paramModel);
                            }
                        }
                    }
                }
            }else{
                loger.info(TextUtils.format("apiId为{}查询参数异常"),informationApi.getId());
                //return null;
            }
        }
        int flux = 0;
        String code = "";
        long startTime = System.currentTimeMillis();
        if(informationApi.getApiType() == ConstantClazz.API_TYPE_HTTP) {
            Result resultMap = restRequestService.restMethodV0(paramResult, informationApi);
            Map<String, Object> extMap = (Map<String, Object>)resultMap.getResultMap().get("ext");
            flux = Integer.parseInt(extMap.get("flux").toString());
            code = extMap.get("code").toString();
            result = resultMap.getJson();
        }else if(informationApi.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
            try{
                result = soapWebserviceClientImpl.cxfMethodV0(paramResult,informationApi,shamParms);
            }catch(IOException e){
            }
        }else if(informationApi.getApiType() == ConstantClazz.API_TYPE_RPC){
            result = null;
        }
        long endTime = System.currentTimeMillis();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(StrUtils.randomUUID());
        orderInfo.setServiceId(informationApi.getId());
        orderInfo.setServiceName(informationApi.getApiName());
        orderInfo.setIdt(new Date());
        orderInfo.setOrderNo(StrUtils.getOrderNo());
        orderInfo.setUsrid(userId);
        orderInfo.setIp(IpUtils.getIpAddr(requestContextHolderUtil.getRequest()));
        /*orderInfo.setRc2();单位名称暂时不录入*/
        if(code.equals("200")){
            orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_NORMAL);
        }else{
            orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_ABNORMAL);
        }
        orderInfo.setRc7(flux);
        orderInfo.setParms(keyMap.toString());
        orderInfo.setRc8(Integer.parseInt(String.valueOf(endTime-startTime)));
        try {
            orderClientService.sendOrderMQMsg(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
            loger.debug(informationApi.getId() + "保存订单数据失败！");
        }
        return result;
    }

    /**
     *
     * 功能描述: 迭代删除apiKey
     *
     * @param: [map]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/9/28 9:46
     */
    public Map<String, Object> removeApiId(Map<String, Object> map){

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            if(iterator.next().equals(ConstantClazz.PARAM_API_KEY)){
                iterator.remove();
            }
        }
        return map;
    }
}
