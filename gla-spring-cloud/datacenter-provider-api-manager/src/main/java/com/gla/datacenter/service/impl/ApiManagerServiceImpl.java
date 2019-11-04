package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gla.datacenter.config.UrlConfig;
import com.gla.datacenter.core.utils.StrCodeUtils;
import com.gla.datacenter.core.utils.WSDLRequestXmlToString;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.mapper.mysql.*;
import com.gla.datacenter.model.ApiManagerModel;
import com.gla.datacenter.model.ApiParmsModel;
import com.gla.datacenter.model.ApiTestModel;
import com.gla.datacenter.model.DeptModel;
import com.gla.datacenter.service.*;
import com.gla.datacenter.timer.TaskController;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.xidea.el.json.JSONDecoder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.zip.CheckedOutputStream;

/**
 * 功能描述: api管理生产者实现
 *
 * @param:
 * @return:
 * @auther: zhangbo
 * @date: 2018/9/25 12:17
 */
@Service
@Transactional
public class ApiManagerServiceImpl implements ApiManagerService {

    private Logger loger = LoggerFactory.getLogger(ApiManagerServiceImpl.class);

    private final String Application = "发起申请";
    private final String WaitForProviderApproval = "等待生产者批复";

    @Autowired
    private InformationApiMapper informationApiMapper;

    @Autowired
    private ParmsApiMapper parmsApiMapper;

    @Autowired
    private RestClient restClient;

    @Autowired
    private CxfWebServicexClient cxfWebServicexClient;

    @Autowired
    private OrderClientService orderClientService;

    @Autowired
    private AppUserMapMapper appUserMapMapper;

    @Autowired
    TaskController testController;

    @Autowired
    private FilterInformationApiMapper filterInformationApiMapper;

    @Autowired
    private ApiNumLimtMapper apiNumLimtMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private OperationLogClientService operationLogClientService;

    @Autowired
    private RequestContextHolderUtil requestContextHolderUtil;

    @Autowired
    private UrlConfig urlConfig;

    @Autowired
    private MessageMapper messageMapper;

    @Autowired
    private MessageCommentMapper messageCommentMapper;

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private MonitorDataMapper monitorDataMapper;

    @Autowired
    private CatalogManagerService catalogManagerService;

    @Autowired
    private MDMCommondClientService mdmCommondClientService;

    /**
     * 引入CatalogUserMapMapper
     */
    @Autowired
    private CatalogUserMapMapper catalogUserMapMapper;

    @Autowired
    private ResourceCateManagerClientService resourceCateManagerClientService;

    @Autowired
    private ApiManagerService apiManagerService;

    @Autowired
    private AppInfoService appInfoService;

    @Override
    public String getProviderList(InformationApi informationApi, Pager pager) {
        String categoryId = informationApi.getCategoryId();
        InformationApiExample ex = new InformationApiExample();
        ex.setPage(pager);
        ex.setOrderByClause(" IDT DESC");
        InformationApiExample.Criteria criteria = ex.createCriteria();
        if (StringUtils.isBlank(categoryId) || "-1".equals(categoryId)) {
        } else {
            criteria.andCategoryIdEqualTo(categoryId);
        }

        if (StringUtils.isNotBlank(informationApi.getRc2())) {
            criteria.andApiNameDescriptionLike("%" + informationApi.getRc2() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            criteria.andApiCodeLike("%" + informationApi.getApiCode() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            criteria.andApiNameLike("%" + informationApi.getApiName() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            criteria.andDescriptionLike("%" + informationApi.getDescription() + "%");
        }
        if (informationApi.getRequestType() != null) {
            criteria.andRequestTypeEqualTo(informationApi.getRequestType());
        }
        if (StringUtils.isNotBlank(informationApi.getUrl())) {
            criteria.andUrlEqualTo(informationApi.getUrl());
        }
        String[] apiTerm = informationApi.getApiTerm();
        if (apiTerm != null && apiTerm.length > 0) {
            ArrayList<String> strings = new ArrayList<>(Arrays.asList(apiTerm));
            //多条件筛选组合查询(可用、异常、过期)
            criteria.orTermEqualTo(strings);
        } else {
            pager.setPagerInfo(new ArrayList(), 0);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();
        }
        criteria.andProducerIdEqualTo(ApplicationContextHolder.currentUser().getId());
        criteria.andDeleteFlagNotEqualTo(ConstantClazz.DELETE_FLAG_TRUE);
        List<InformationApi> list = new ArrayList<>();
        try {
            list = informationApiMapper.selectByExample(ex);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
        pager.setPagerInfo(list, informationApiMapper.countByExample(ex));

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();
    }

    @Override
    public Pager<InformationApi> getConsumerList(InformationApi informationApi, Pager pager) {

        String url = urlConfig.getUrl();
        Map<String, Object> paramMap = new HashMap<>();
        List<InformationApi> list = new ArrayList<>();
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            paramMap.put("name", informationApi.getApiName());
        }
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            paramMap.put("code", informationApi.getApiCode());
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            paramMap.put("desc", informationApi.getDescription());
        }
        if (StringUtils.isBlank(informationApi.getCategoryId()) || "-1".equals(informationApi.getCategoryId())) {
        } else {
            paramMap.put("categoryId", informationApi.getCategoryId());
        }
        paramMap.put("shareLevel", ConstantClazz.SHARE_LEVEL_NONE);
        paramMap.put("url", url);
        int count = informationApiMapper.getList(paramMap).size();
        if (informationApi.getPage() > 0) {
            paramMap.put("page", (informationApi.getPage() - 1) * (informationApi.getRows() != 0 ? informationApi.getRows() : 10));
        } else {
            paramMap.put("page", 0);
        }
        if (informationApi.getRows() != 0) {
            paramMap.put("rows", informationApi.getRows());
        } else {
            paramMap.put("rows", 10);
        }
        list = informationApiMapper.getList(paramMap);
        //api申请状态展示
        if (list != null && !list.isEmpty()) {
            String userId = ApplicationContextHolder.currentUser().getId();
            for (InformationApi api : list) {
                List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.getApiAuditStatus(api.getId(), userId);
                if (apiNumLimts != null && !apiNumLimts.isEmpty()) {
                    int auditStatus = apiNumLimts.get(0).getAuditStatus();
                    api.setCheckStatus((byte) auditStatus);
                } else {
                    api.setCheckStatus((byte) 2);
                }
            }
        }
        pager.setPagerInfo(list, count);
        return pager;
    }

    @Override
    public String checkJoinApi(InformationApi informationApi) {
        String id = informationApi.getId();
        List<InformationApi> apis = new ArrayList<>();
        if (StringUtils.isNotBlank(id)) {
            String[] str = id.split(",");
            try {
                apis = informationApiMapper.checkJoinApi(str);
            } catch (Exception e) {
                loger.error(e.getMessage());
                return Result.Error().getJson();
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, apis, null).getJson();
    }

    @Override
    public String getConsumerListTwo(InformationApi informationApi, Pager pager) {
        String url = urlConfig.getUrl();
        Map<String, Object> paramMap = new HashMap<>();
        List<InformationApi> list = new ArrayList<>();
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            paramMap.put("name", informationApi.getApiName());
        }
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            paramMap.put("code", informationApi.getApiCode());
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            paramMap.put("desc", informationApi.getDescription());
        }
        //标题或者内容模糊查询
        if (StringUtils.isNotBlank(informationApi.getRc2())) {
            paramMap.put("rc2", informationApi.getRc2());
        }
        paramMap.put("type", informationApi.getType());
        String[] apiTerm = informationApi.getApiTerm();
        //Map<String,String> map = new HashMap<>();
        if (apiTerm != null && apiTerm.length > 0) {
            ArrayList<String> str = new ArrayList<>(Arrays.asList(apiTerm));
            paramMap.put("apiTerm",str);
        }else{
            paramMap.put("apiTerm",null);
            pager.setPagerInfo(list,0);
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,pager,null).getJson();
        }

        if (StringUtils.isBlank(informationApi.getCategoryId()) || "-1".equals(informationApi.getCategoryId())) {
        } else {
            paramMap.put("categoryId", informationApi.getCategoryId() + ",");
        }
        if (informationApi.getShareLevel() != null) {
            paramMap.put("shareLevel", informationApi.getShareType());
        }
        //该属性用于接收消费者数据目录 已加入的apiid，以','分割
        if (StringUtils.isNotBlank(informationApi.getShareCode())) {
            paramMap.put("addId", informationApi.getShareCode().split(","));
        }
        paramMap.put("url", url);
        if (StringUtils.isBlank(informationApi.getCreateId())) {
            paramMap.put("userId", ApplicationContextHolder.currentUser().getId());
        } else {
            paramMap.put("userId", informationApi.getCreateId());
        }
        int count = 0;
        try {
            Pager pagerCopy = null;
            count = informationApiMapper.getConsumerListTwo(paramMap,pagerCopy).size();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
        list = informationApiMapper.getConsumerListTwo(paramMap,pager);
        pager.setPagerInfo(list,count);
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public Pager<InformationApi> getManagerList(InformationApi informationApi, Pager pager) {

        String categoryId = informationApi.getCategoryId();
        InformationApiExample ex = new InformationApiExample();
        ex.setPage(pager);
        ex.setOrderByClause(" IDT DESC");
        InformationApiExample.Criteria criteria = ex.createCriteria();
        if (StringUtils.isBlank(categoryId) || "-1".equals(categoryId)) {
        } else {
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            criteria.andApiCodeLike("%" + informationApi.getApiCode() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            criteria.andApiNameLike("%" + informationApi.getApiName() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            criteria.andDescriptionLike("%" + informationApi.getDescription() + "%");
        }
        criteria.andShareLevelEqualTo(ConstantClazz.SHARE_LEVEL_ALL);
        criteria.andDeleteFlagNotEqualTo(ConstantClazz.DELETE_FLAG_TRUE);
        List<InformationApi> list = informationApiMapper.selectByExample(ex);
        pager.setPagerInfo(list, informationApiMapper.countByExample(ex));
        return pager;
    }

    @Override
    public String getManagerListTwo(InformationApi informationApi, Pager pager) {

        Map<String, Object> paramMap = new HashMap<>();
        List<InformationApi> list = new ArrayList<>();
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            paramMap.put("name", informationApi.getApiName());
        }
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            paramMap.put("code", informationApi.getApiCode());
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            paramMap.put("desc", informationApi.getDescription());
        }
        //标题或者内容模糊查询
        if (StringUtils.isNotBlank(informationApi.getRc2())) {
            paramMap.put("rc2", informationApi.getRc2());
        }

        if (StringUtils.isBlank(informationApi.getProducerOrgId())) {
            //paramMap.put("producerOrgId", ConstantClazz.PRODUCER_ORG_ID);
        } else {
            paramMap.put("producerOrgId", informationApi.getProducerOrgId());
        }
        try {
            int count = informationApiMapper.getManagerListTwo(paramMap).size();
            if (informationApi.getPage() > 0) {
                paramMap.put("page", (informationApi.getPage() - 1) * (informationApi.getRows() != 0 ? informationApi.getRows() : 10));
            } else {
                paramMap.put("page", 0);
            }
            if (informationApi.getRows() != 0) {
                paramMap.put("rows", informationApi.getRows());
            } else {
                paramMap.put("rows", 10);
            }
            list = informationApiMapper.getManagerListTwo(paramMap);
            pager.setPagerInfo(list, count);
        } catch (Exception e) {
            loger.error(e.getMessage());
            Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();
    }

    @Override
    public String countDeptAndApi() {
        List<DeptModel> list = new ArrayList<>();
        //UserInfo userInfo = ApplicationContextHolder.currentUser();
        //判断当前登录用户是否为管理者

        //获取当前的二级目录
        DeptExample ex = new DeptExample();
        DeptExample.Criteria criteria = ex.createCriteria();
        criteria.andLvEqualTo(2);
        criteria.andStateEqualTo(1);
        try {
            List<Dept> depts = deptMapper.selectByExample(ex);
            if (depts != null && !depts.isEmpty()) {
                for (Dept dept : depts) {
                    DeptModel deptModel = new DeptModel();
                    String code = dept.getCode();
                    deptModel.setDept(dept);
                    //根据父code获取所有子机构数量和api数量
                    Integer countChildDept = deptMapper.countChildDeptByCode(code);
                    deptModel.setCountChildDept(countChildDept);
                    Integer countApi = informationApiMapper.countApiByCode(code);
                    deptModel.setCountApi(countApi);
                    list.add(deptModel);
                }
            }
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, null).getJson();
    }

    @Override
    public Pager<InformationApi> getApiTest(InformationApi informationApi, Pager pager) {

        List<InformationApi> list = new ArrayList<>();
        InformationApiExample ex = new InformationApiExample();
        ex.setPage(pager);
        ex.setOrderByClause(" IDT DESC");
        InformationApiExample.Criteria criteria = ex.createCriteria();
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            criteria.andApiCodeLike("%" + informationApi.getApiCode() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            criteria.andApiNameLike("%" + informationApi.getApiName() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            criteria.andDescriptionLike("%" + informationApi.getDescription() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getProducerOrgId())) {
            criteria.andProducerOrgIdEqualTo(informationApi.getProducerOrgId());
        }
        criteria.andProducerIdEqualTo(ApplicationContextHolder.currentUser().getId());
        criteria.andShareLevelNotEqualTo(ConstantClazz.SHARE_LEVEL_NONE);
        criteria.andDeleteFlagNotEqualTo(ConstantClazz.DELETE_FLAG_TRUE);
        list = informationApiMapper.selectByExample(ex);
        pager.setPagerInfo(list, informationApiMapper.countByExample(ex));
        return pager;
    }

    @Override
    public String saveApi(ApiManagerModel apiManagerModel) {
        Result result = Result.getInstance(null, null, null, null);
        UserInfo userInfo = ApplicationContextHolder.currentUser();
        Map<String, Object> map = new HashMap<>();
        String categoryId = apiManagerModel.getCategoryId();
        if(StringUtils.isNotBlank(categoryId)){
            List<String> split = Arrays.asList(categoryId.split(","));
            if(split.contains(userInfo.getUnitcode())){
            }else{
                split = new ArrayList<>(split);
                split.add(userInfo.getUnitcode());
                categoryId = String.join(",",split);
            }
        }else{
            categoryId = userInfo.getUnitcode();
        }
        apiManagerModel.setCategoryId(categoryId);
        if (StringUtils.isNotBlank(apiManagerModel.getId())) {
            InformationApi entity = informationApiMapper.selectByPrimaryKey(apiManagerModel.getId());
            if (apiManagerModel.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
                String url = apiManagerModel.getUrl();
                if (StringUtils.isNotBlank(url)) {
                    if (!url.endsWith("wsdl") && !url.endsWith("WSDL")) {
                        return Result.getException("当前url不合规，请按照wsdl重新输入!").getJson();
                    }
                }
            }
            //编辑
            InformationApi informationApi = new InformationApi();
            BeanUtils.copyProperties(apiManagerModel, informationApi);
            informationApi.setUdt(new Date());
            informationApi.setUpdateId(userInfo.getId());
            try {
                //根据部门code获取部门基本信息
                Dept dept = deptMapper.getDeptInforByCode(userInfo.getUnitcode());
                if (dept != null) {
                    informationApi.setProducerOrgId(dept.getId());
                }
                try {
                    //记录标签变更信息
                    catalogManagerService.recordCateChange(informationApi);
                } catch (Exception e) {
                    e.printStackTrace();
                    loger.error(e.getMessage());
                }

                informationApiMapper.updateByPrimaryKeySelective(informationApi);
                //删除所有参数
                parmsApiMapper.deleteParmsByApiId(apiManagerModel.getId());
                List<ParmsApi> parmsApis = apiManagerModel.getParmsApi();
                if (parmsApis != null && !parmsApis.isEmpty()) {
                    int paramNo = 0;
                    for (ParmsApi parmsApi : parmsApis) {
                        parmsApi.setApiId(apiManagerModel.getId());
                        parmsApi.setIdt(new Date());
                        parmsApi.setCreateId(userInfo.getId());
                        parmsApi.setParmsNo(paramNo);
                        parmsApi.setRealParms(parmsApi.getShamParms());
                        parmsApi.setId(StrUtils.randomUUID());
                        if (informationApi.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
                            String requestXml = WSDLRequestXmlToString.soapRequestXML(apiManagerModel.getUrl(), apiManagerModel.getMethod());
                            parmsApi.setDefaultValue(requestXml);
                        }
                        parmsApiMapper.insertSelective(parmsApi);
                        ++paramNo;
                    }
                }

                Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(informationApi, true);
                Map<String, Object> objectMap = JavaBeanConverMapUtils.bean2Map(entity, false);
                map.put("type", "update");
                map.put("tableName", "InformationApi");
                map.put("mapParams", stringObjectMap);
                map.put("objectMap", objectMap);
                try {
                    operationLogClientService.addOperationLogs(map);
                } catch (Exception e) {
                    loger.error("新增api{}操作日志保存失败!",map);
                    e.printStackTrace();
                }
                result = Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, null, "");
            } catch (Exception e) {
                loger.error(e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result = Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, null, "");
            }
        } else {
            if (apiManagerModel.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
                String url = apiManagerModel.getUrl();
                if (!url.endsWith("wsdl") && !url.endsWith("WSDL")) {
                    return Result.getException("当前url不合规，请按照wsdl重新输入!").getJson();
                }
            }
            List<ParmsApi> parmsApis = apiManagerModel.getParmsApi();
            String id = StrUtils.randomUUID();
            InformationApi informationApi = new InformationApi();
            BeanUtils.copyProperties(apiManagerModel, informationApi);
            informationApi.setId(id);
            informationApi.setCreateId(userInfo.getId());
            informationApi.setProducerId(userInfo.getId());
            informationApi.setIdt(new Date());
            if(StrUtils.isBlank(informationApi.getApiCode())){
                informationApi.setApiCode(StrCodeUtils.createCode("I"));
            }
            String requestXml = "";
            if (informationApi.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
                if (StringUtils.isBlank(informationApi.getMethod())) {
                    //return Result.getException(TextUtils.format("method不能为空!")).getJson();
                } else {
                    try {
                        requestXml = WSDLRequestXmlToString.soapRequestXML(informationApi.getUrl(), informationApi.getMethod());
                    } catch (Exception e) {
                        loger.error(e.getMessage());
                        return Result.Error().getJson();
                    }
                }
            }
            try {
                Dept dept = deptMapper.getDeptInforByCode(userInfo.getUnitcode());
                if (dept != null) {
                    informationApi.setProducerOrgId(dept.getId());
                }
                try {
                    //记录标签变更信息
                    catalogManagerService.recordCateChange(informationApi);
                } catch (Exception e) {
                    e.printStackTrace();
                    loger.error(e.getMessage());
                }
                informationApiMapper.insertSelective(informationApi);
                //新增顺带授权给自己
                ApiNumLimt apiNumLimt = new ApiNumLimt();
                apiNumLimt.setIdt(new Date());
                apiNumLimt.setId(StrUtils.randomUUID());
                apiNumLimt.setAuditStatus(1);
                apiNumLimt.setApiid(id);
                apiNumLimt.setUserid(userInfo.getId());
                apiNumLimt.setAccount(userInfo.getAccount());
                apiNumLimt.setLimtType(1);
                apiNumLimtMapper.insertSelective(apiNumLimt);
                if (parmsApis != null && !parmsApis.isEmpty()) {
                    int paramNo = 0;
                    for (ParmsApi parmsApi : parmsApis) {
                        parmsApi.setApiId(id);
                        parmsApi.setIdt(new Date());
                        parmsApi.setCreateId(userInfo.getId());
                        parmsApi.setParmsNo(paramNo);
                        parmsApi.setRealParms(parmsApi.getShamParms());
                        parmsApi.setId(StrUtils.randomUUID());
                        if (informationApi.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
                            parmsApi.setDefaultValue(requestXml);
                        }
                        parmsApiMapper.insertSelective(parmsApi);
                        ++paramNo;
                    }
                }
                //用户行为审计日志记录
                //InformationApi entity = informationApiMapper.selectByPrimaryKey(apiManagerModel.getId());

            } catch (Exception e) {
                loger.debug(PrintExceptionUtils.getException(e));
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result = Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ADD_ERROR, null, "");
            }
            Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(informationApi, true);
            map.put("type", "add");
            map.put("tableName", "InformationApi");
            map.put("mapParams", stringObjectMap);
            map.put("objectMap", null);
            try {
                operationLogClientService.addOperationLogs(map);
            } catch (Exception e) {
                e.printStackTrace();
            }
            result = Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_SUCCESS, null, "");
        }
        return result.getJson();
    }


    @Override
    public String deleteApi(String id) {

        String result = "";

        if (StringUtils.isBlank(id)) {
            return Result.getException(ExceptionEnum.ParamISNUll).getJson();
        }

        String[] ids = id.split(Constant.DHAO);
        try {
            String userId = "";
            UserInfo userInfo = ApplicationContextHolder.currentUser();
            if (userInfo != null) {
                userId = userInfo.getId();
            }
            try {
                //记录标签变更信息
                for (String apiid : ids) {
                    {
                        InformationApi api = new InformationApi();
                        api.setId(apiid);
                        catalogManagerService.recordCateChange(api);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                loger.error(e.getMessage());
            }
            //删除成功后需要重置主数据的api状态为可发布
            //根据删除的api获取系统级api的code值
            List<String> codeList = null;
            //远程调用重置其状态
            try {
                codeList = informationApiMapper.getSystemApiByIds(ids);
                mdmCommondClientService.resetApiStatusByCodeList(codeList);
            } catch (Exception e) {
                e.printStackTrace();
                loger.error("重置主数据的api[{}]为可发布失败!",codeList);
            }
            informationApiMapper.deleteBatchApi(ids, new Date(), userId);
            result = Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.DEL_SUCCESS, null, "").getJson();
        } catch (Exception e) {
            loger.error(e.getMessage());
            result = Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR, null, "").getJson();
        }
        return result;
    }

    @Override
    public ApiManagerModel getApiById(String id) {
        ApiManagerModel apiManagerModel = new ApiManagerModel();
        if (StringUtils.isBlank(id)) {
            //抛出自定义异常类
        }
        InformationApi informationApi = informationApiMapper.selectByPrimaryKey(id);
        if (informationApi != null) {
            String categoryId = informationApi.getCategoryId();
            if (StringUtils.isNotBlank(categoryId)) {
                String[] code = categoryId.split(Constant.DHAO);
                try {
                    List<RcsResourceCate> resourceList = resourceCateManagerClientService.getResourceCatalogByCodes(code);
                    informationApi.setItem(resourceList);
                } catch (Exception e) {
                    e.printStackTrace();
                    loger.error(e.getMessage());
                }
            }
            BeanUtils.copyProperties(informationApi, apiManagerModel);
            if (informationApi.getShareLevel() != ConstantClazz.SHARE_LEVEL_NONE) {

                //查询参数列表
                if (informationApi.getParmsFlag() == ConstantClazz.DELETE_FLAG_TRUE) {
                    ParmsApiExample ex = new ParmsApiExample();
                    ParmsApiExample.Criteria criteria = ex.createCriteria();
                    criteria.andApiIdEqualTo(id);
                    List<ParmsApi> parmsApis = parmsApiMapper.selectByExample(ex);
                    apiManagerModel.setParmsApi(parmsApis);
                }

            }
        }
        return apiManagerModel;
    }

    @Override
    public String getConsumerApiById(String id) {
        ApiManagerModel apiManagerModel = new ApiManagerModel();
        if (StringUtils.isBlank(id)) {
            return Result.getException(ExceptionEnum.ParamISNUll).getJson();
        }
        String url = "";
        url = urlConfig.getUrl();
        String forwordUrl = urlConfig.getForwardUrl();
        UserInfo userInfo = ApplicationContextHolder.currentUser();
        try {
            apiManagerModel = informationApiMapper.getConsumerApiById(id, url, forwordUrl, userInfo.getRc4());
            if (apiManagerModel != null) {
                String categoryId = apiManagerModel.getCategoryId();
                if (StringUtils.isNotBlank(categoryId)) {
                    String[] code = categoryId.substring(0, categoryId.length() - 1).split(Constant.DHAO);
                    try {
                        List<RcsResourceCate> resourceList = resourceCateManagerClientService.getResourceCatalogByCodes(code);
                        apiManagerModel.setItem(resourceList);
                    } catch (Exception e) {
                        e.printStackTrace();
                        loger.error(e.getMessage());
                    }
                }
                if (apiManagerModel.getShareLevel() != ConstantClazz.SHARE_LEVEL_NONE) {

                    //查询参数列表
                    if (apiManagerModel.getParmsFlag() == ConstantClazz.DELETE_FLAG_TRUE) {
                        ParmsApiExample ex = new ParmsApiExample();
                        ParmsApiExample.Criteria criteria = ex.createCriteria();
                        criteria.andApiIdEqualTo(id);
                        List<ParmsApi> parmsApis = parmsApiMapper.selectByExample(ex);
                        apiManagerModel.setParmsApi(parmsApis);
                    }

                }

                //查询是否授权
                String userId = userInfo.getId();
                List<ApiNumLimt> apiAuditStatus = apiNumLimtMapper.getApiAuditStatus(id, userId);
                if (apiAuditStatus != null && !apiAuditStatus.isEmpty()) {
                    int auditStatus = apiAuditStatus.get(0).getAuditStatus();
                    apiManagerModel.setCheckStatus((byte) auditStatus);
                } else {
                    //根据api主键查询审核流程
                    Message message = messageMapper.getApiAudithistory(id, userId);
                    Map<String, Object> map = new HashMap<>();
                    if (message != null) {
                        Date sendtime = message.getSendtime();
                        map.put("one", sendtime);
                        Date dealtime = message.getDealtime();
                        map.put("two", dealtime);
                        String messageId = message.getId();
                        Map<String, Object> params = new HashMap<>();
                        params.put("apiId", id);
                        params.put("userId", userId);
                        params.put("messageId", messageId);
                        MessageComment messageComment = messageCommentMapper.getApiAudithistory(params);
                        if (messageComment != null) {
                            Date three = messageComment.getDealtime();
                            map.put("three", three);
                            Date devendtime = messageComment.getDevendtime();
                            map.put("four", devendtime);
                        } else {
                            map.put("three", null);
                            map.put("four", null);
                        }
                        apiManagerModel.setTimes(map);
                    }
                }
            }
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, null, null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, apiManagerModel, null).getJson();
    }

    @Override
    public String getApiInfoById(String id) {

        Result result = Result.getInstance(null, null, null, null);
        ApiParmsModel apiParmsModel = new ApiParmsModel();
        if (StringUtils.isBlank(id)) {
            result = Result.getException(ExceptionEnum.ParamISNUll);
            return result.getJson();
        }
        InformationApi informationApi = informationApiMapper.selectByPrimaryKey(id);
        if (informationApi != null) {
            apiParmsModel.setInformationApi(informationApi);
            //获取其是否包含参数
            if (informationApi.getParmsFlag() == ConstantClazz.PARMS_FLAG_TRUE) {
                ParmsApiExample ex = new ParmsApiExample();
                ParmsApiExample.Criteria criteria = ex.createCriteria();
                criteria.andApiIdEqualTo(informationApi.getId());
                List<ParmsApi> parmsList = parmsApiMapper.selectByExample(ex);
                apiParmsModel.setParmsApis(parmsList);
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, apiParmsModel, null).getJson();
    }

    /*@Override
    public String getCategoryTree(CategoryApi categoryApi) {
        List<CategoryApi> list = new ArrayList<>();
        List<CategoryApi> categoryApis = new ArrayList<>();
        String parentId = categoryApi.getParentId();
        //查询全部目录最高级别的目录信息
        try{
            *//*CategoryApi highAllcategoryApi = categoryApiMapper.selectByPrimaryKey("-1");
            list.add(highAllcategoryApi);*//*
            if(StringUtils.isNotBlank(parentId)){
                categoryApis = categoryApiMapper.getCategoryTree(parentId);
            }else{
                //获取当前用户所创建目录的最高节点
                String userId = ApplicationContextHolder.currentUser().getId();
                UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
                String unitcode = userInfo.getUnitcode();
                //根据单位编码获取单位id
                Dept dept = deptMapper.getDeptInforByCode(unitcode);
                String orgId = dept.getId();
                //根据当前用户单位id获取所创建目录的最高节点
                CategoryApi gighCategory = categoryApiMapper.getHighCategory(orgId);
                if(gighCategory != null){
                    //递归查询所有子节点
                    categoryApis = categoryApiMapper.getCategoryTree(gighCategory.getId());
                    CategoryApi categoryApi1 = categoryApiMapper.selectByPrimaryKey(gighCategory.getId());
                    list.add(categoryApi1);
                }
            }
            list.addAll(categoryApis);
        }catch(Exception e){
            Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.GET_ERROR,null,"").getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,"").getJson();

    }

    @Override
    public String getAllCategoryTree(CategoryApi categoryApi){
        List<CategoryApi> list = new ArrayList<>();
        String parentId = categoryApi.getParentId();
        if(StringUtils.isBlank(parentId)){
            parentId = "-1";
        }
        try {
            list = categoryApiMapper.getCategoryTree(parentId);
        } catch (Exception e) {
            Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.GET_ERROR,null,"").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,"").getJson();
    }*/

    /*@Override
    public String deleteCategory(String id) {
        Result result = new Result(null,null,null,null);
        CategoryApiExample ex = new CategoryApiExample();
        CategoryApi categoryApi = categoryApiMapper.selectByPrimaryKey(id);
        categoryApi.setDeleteFlag(ConstantClazz.DELETE_FLAG_TRUE);
        categoryApi.setUdt(new Date());
        String userId = "";
        UserInfo userInfo = ApplicationContextHolder.currentUser();
        if(userInfo != null){
            categoryApi.setUpdateId(userId);
        }
        loger.info("api目录开始删除");
        categoryApiMapper.updateByExampleSelective(categoryApi, ex);
        loger.info("api目录删除结束");
        //判断其父节点的子节点是否>1
        try {
            CategoryApi categoryChild = categoryApiMapper.selectByPrimaryKey(id);
            if(categoryChild != null ){
                List<CategoryApi> categoryChildByParent = categoryApiMapper.getCategoryChildByParent(categoryChild.getParentId());
                if(categoryChildByParent.isEmpty() || categoryChildByParent.size() <= 1){
                    CategoryApiExample exParent = new CategoryApiExample();
                    CategoryApi categoryParent = categoryApiMapper.selectByPrimaryKey(categoryChild.getParentId());
                    categoryParent.setChildFlag((byte) 1);
                    categoryApiMapper.updateByExampleSelective(categoryParent,exParent);
                }
            }
            result = Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.DEL_SUCCESS,null,"");
        } catch (Exception e) {
            result = Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.DEL_ERROR,null,"");
        }
        return result.getJson();
    }*/

    @Override
    public int checkCategory(String id) {

        //查询其是否存在Api
        InformationApiExample ex = new InformationApiExample();
        InformationApiExample.Criteria criteria = ex.createCriteria();
        criteria.andDeleteFlagEqualTo(ConstantClazz.DELETE_FLAG_FALSE);
        criteria.andCategoryIdEqualTo(id);
        List<InformationApi> list = informationApiMapper.selectByExample(ex);
        return list.isEmpty() ? 0 : list.size();
    }

    /*@Override
    public String addCategory(CategoryApi categoryApi) {
        Result result = Result.getInstance(null,null,null,null);
        categoryApi.setIdt(new Date());
        String userId = "";
        UserInfo userInfo = ApplicationContextHolder.currentUser();
        if(userInfo != null ){
            userId = userInfo.getId();
        }
        //获取机构id
        Dept deptInforByCode = deptMapper.getDeptInforByCode(userInfo.getUnitcode());
        categoryApi.setOrgId(deptInforByCode.getId());
        categoryApi.setCreateId(userId);
        categoryApi.setId(StrUtils.randomUUID());
        categoryApi.setDeleteFlag(ConstantClazz.DELETE_FLAG_FALSE);

        try {
            categoryApiMapper.insertSelective(categoryApi);
            //修改父节点child状态为0
            CategoryApi categoryParent = categoryApiMapper.selectByPrimaryKey(categoryApi.getParentId());
            if(categoryParent.getChildFlag() == (byte) 0){
            }else{
                CategoryApiExample ex = new CategoryApiExample();
                categoryParent.setChildFlag((byte) 0);
                categoryApiMapper.updateByExampleSelective(categoryParent,ex);
            }
            result = Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,null,"");
        } catch (Exception e) {
            result = Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.ADD_ERROR,null,"");
        }
        return result.getJson();
    }

    @Override
    public String updateCategory(CategoryApi categoryApi) {
        Result result = Result.getInstance(null,null,null,null);
        if(categoryApi != null){
            CategoryApiExample ex = new CategoryApiExample();
            try {
                String userId = "";
                UserInfo userInfo = ApplicationContextHolder.currentUser();
                if(userInfo != null){
                    userId = userInfo.getId();
                }
                categoryApi.setDeleteFlag(ConstantClazz.DELETE_FLAG_TRUE);
                categoryApi.setUdt(new Date());
                categoryApi.setUpdateId(userId);
                categoryApiMapper.updateByExampleSelective(categoryApi, ex);
                result = Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,null,"");
            } catch (Exception e) {
                result = Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.ADD_ERROR,null,"");
            }
        }
        return result.getJson();
    }*/

    @Override
    public String apiTest(ApiTestModel apiTestModel) {

        String userId = ApplicationContextHolder.currentUser().getId();
        String result = "";
        long startTime = System.currentTimeMillis();
        if (StringUtils.isBlank(apiTestModel.getApiId())) {
            //返回自定义异常
        }
        //获取传递的参数
        Map<String, Object> parms = apiTestModel.getParms();
        List<ParmsApi> shamParms = new ArrayList<>();
        InformationApi informationApi = informationApiMapper.selectByPrimaryKey(apiTestModel.getApiId());
        Map<String, Object> map = new LinkedHashMap<>();

        if(informationApi.getExpireTime() != null){
            if(informationApi.getExpireTime().getTime() < System.currentTimeMillis()){
                return Result.getException("当前api已过期,不能使用!").getJson();
            }
        }

        //判断是否有访问权限
        FilterInformationApi filterInformationApi = filterInformationApiMapper.getFilterByUserIdAndApiId(informationApi.getProducerId(),userId);
        if(filterInformationApi != null){
            if(filterInformationApi.getFilterType() == 1){
                if(filterInformationApi.getListType() == 1){
                    return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PRIV_ERROR,null,null).getJson();
                }
            }
        }

        //获取参数集合
        if (informationApi.getParmsFlag() == ConstantClazz.PARMS_FLAG_TRUE) {
            shamParms = parmsApiMapper.getShamParms(informationApi.getId());
            if (shamParms != null && !shamParms.isEmpty()) {
                for (ParmsApi parmsApi : shamParms) {
                    if (parms.containsKey(parmsApi.getShamParms())) {
                        String params = "";
                        if (parms.get(parmsApi.getShamParms()) != null) {
                            params = parms.get(parmsApi.getShamParms()).toString();
                        }
                        if (parmsApi.getRequired() == 0) {
                            if (StringUtils.isNotBlank(params)) {
                                map.put(parmsApi.getShamParms(), params);
                            } else {
                                return Result.getException("参数:" + parmsApi.getShamParms() + "不可为空，请重新输入！").getJson();
                            }
                        } else {
                            map.put(parmsApi.getShamParms(), params);
                        }
                    } else {
                        return Result.getException("参数:" + parmsApi.getShamParms() + "不可为空，请重新输入！").getJson();
                    }
                }
            }
        }
        JSONObject jsonObject = new JSONObject();
        try {
            if (informationApi.getApiType() == ConstantClazz.API_TYPE_HTTP) {
                if (/*informationApi.getOuterParamType().equals("")||*/true) {
                    result = restClient.httpRequest(map, informationApi);
                    loger.info("请求完就输出结果集:",result);
                } else {
                    result = restClient.httpRequest(map, informationApi);
                }
            } else if (informationApi.getApiType() == ConstantClazz.API_TYPE_WEBSERVICE) {
                //暂时使用的cxf框架调用，可以改成httpclient(待考虑)
                //result = cxfWebServicexClient.sendSoapRequest(map,informationApi,shamParms);
                result = cxfWebServicexClient.sendHttpRequest(map, informationApi);
            } else {
                return Result.getException("暂不支持rpc测试，敬请期待!").getJson();
                //rpc待定
            }
            long endTime = System.currentTimeMillis();
            jsonObject = JSONObject.parseObject(result);

            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setId(StrUtils.randomUUID());
            orderInfo.setServiceId(informationApi.getId());
            orderInfo.setServiceName(informationApi.getApiName());
            orderInfo.setIdt(new Date());
            orderInfo.setOrderNo(StrUtils.getOrderNo());
            orderInfo.setUsrid(userId);
            orderInfo.setIp(IpUtils.getIpAddr(requestContextHolderUtil.getRequest()));

            orderInfo.setUrl(informationApi.getUrl());
            orderInfo.setParms(parms.toString());
            orderInfo.setOrderResult(result);
            if ("200".equals(jsonObject.get("code"))) {
                if (informationApi.getApiStatus() != 0) {
                    informationApi.setApiStatus(ConstantClazz.API_STATUS_NORMAL);
                    informationApiMapper.updateByPrimaryKey(informationApi);
                }
                orderInfo.setRc6("1");
                orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_NORMAL);
                orderInfo.setRc8(Integer.parseInt(String.valueOf(endTime - startTime)));
                Map<String, Object> ext = (Map<String, Object>) jsonObject.get("ext");
                if (ext != null && !ext.isEmpty() && ext.containsKey("flux")) {
                    orderInfo.setRc7(Integer.parseInt(ext.get("flux").toString()));
                }
            } else {
                informationApi.setApiStatus(ConstantClazz.API_STATUS_ABNORMAL);
                informationApiMapper.updateByPrimaryKey(informationApi);
                orderInfo.setStatus(ConstantClazz.ORDER_SERVICE_STATUS_ABNORMAL);
                orderInfo.setRc7(0);
                orderInfo.setRc8(0);
            }
            try {
                orderClientService.sendOrderMQMsg(orderInfo);
                loger.info(informationApi.getId() + "保存订单数据成功！");
            } catch (Exception e) {
                e.printStackTrace();
                loger.info("失败原因:{}", e.getMessage());
                loger.info(informationApi.getId() + "保存订单数据失败！");
            }
        } catch (/**HttpClientErrorException**/Exception e) {
            e.printStackTrace();
            result = Result.getException(ExceptionEnum.SysError500).getJson();
        }
        loger.info("result结果集:" + result);
        return result;
    }

    @Override
    public void apiTestTask(String threshold_value) {

        //保存所有失败的apiId值
        List<String> apiStr = new ArrayList<>();
        //查询所有的部门
        List<String> orgIds = informationApiMapper.getOrgId();
        if (orgIds != null && !orgIds.isEmpty()) {
            for (String orgId : orgIds) {
                //保存请求失败的接口信息
                List<InformationApi> strs = new ArrayList<>();
                //保存失败apiCode值
                List<String> codeStr = new ArrayList<>();
                //根据orgId查询其api列表
                InformationApiExample ex = new InformationApiExample();
                InformationApiExample.Criteria criteria = ex.createCriteria();
                criteria.andDeleteFlagNotEqualTo(ConstantClazz.DELETE_FLAG_TRUE);
                criteria.andProducerOrgIdEqualTo(orgId);
                criteria.andExpireFlagEqualTo((byte) 0);
                List<InformationApi> informationApis = informationApiMapper.selectByExample(ex);
                if (informationApis != null && !informationApis.isEmpty()) {
                    for (InformationApi informationApi : informationApis) {
                        InformationApi parmsList = getParmsList(informationApi);
                        if (parmsList != null) {
                            strs.add(parmsList);
                            codeStr.add(parmsList.getApiCode());
                            apiStr.add(parmsList.getId());
                        }
                    }
                } else {
                    continue;
                }

                BigDecimal now = new BigDecimal(threshold_value);
                if (informationApis != null && informationApis.isEmpty()) {
                    BigDecimal strsB = new BigDecimal(String.valueOf(strs.size()));
                    BigDecimal inforB = new BigDecimal(String.valueOf(informationApis.size()));
                    if (strsB.divide(inforB, 2, BigDecimal.ROUND_HALF_DOWN).compareTo(now) > 0) {
                        //失败较多发送通知，并且把失败接口的code值保存、、、、
                    }
                }
            }

            if (apiStr != null && !apiStr.isEmpty()) {
                //批量修改失败api的状态值
                loger.info("批量修改api运行状态开始");
                informationApiMapper.updateStatusBatch(apiStr, new Date());
                loger.info("自动化测试请求失败API的Id:" + apiStr.toString());
                loger.info("请求失败API的Id:{}" , apiStr.toString());
                loger.info("批量修改api运行结束开始");
            }
        }
    }

    @Override
    public void monitorDB() {
        System.err.println("定时监控开始" + new Date());
        testController.startCron();
    }

    @Override
    public String createApiCode() {

        //暂时先返回随机字符串和随机数拼接
        String rondowNum = String.valueOf((int) (Math.random() * 9000 + 1000));
        StringBuilder sb = new StringBuilder(RandomUtils.generateUpperStr(4)).append(rondowNum);
        return sb.toString();
        /*String orgId = "";
        //获取当前登陆用户所属部门

        //根据当前部门查询当前部门API总条数
        InformationApiExample ex = new InformationApiExample();
        InformationApiExample.Criteria criteria = ex.createCriteria();
        criteria.andProducerOrgIdEqualTo(orgId);
        int num = informationApiMapper.countByExample(ex);
        num += 1001;
        //暂时先返回纯数字
        return String.valueOf(num);*/
    }

    @Override
    public String batchEmpowerUser(ApiNumLimt apiNumLimt) {

        String result = "";
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(apiNumLimt.getApiid())) {
            map.put("code", "403");
            map.put("kip", "当前未选中API");
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_ERROR, null, map).getJson();
        }
        if (StringUtils.isBlank(apiNumLimt.getUserid())) {
            map.put("code", "403");
            map.put("kip", "当前未录入授权人员");
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_ERROR, null, map).getJson();
        }
        String[] apiIds = apiNumLimt.getApiid().split(",");
        String[] userIds = apiNumLimt.getUserid().split(",");

        List<Map<String, Object>> paramList = new ArrayList<>();
        List<String> userIdErrorList = new ArrayList<>();
        for (String userId : userIds) {
            //根据userId校验用户是否有效
            //UserInfo userInfo = userInfoMapper.selectConsumerUserByAccount(accountId);
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
            //查询所有api是否给用户授权
            if (userInfo != null) {
                //根据用户查询当前授权api
                List<String> apiList = apiNumLimtMapper.getApiListByUserId(userInfo.getId());
                ArrayList<String> checkApiList = new ArrayList<>(Arrays.asList(apiIds));
                //待授权api集合
                checkApiList.removeAll(apiList);
                if (checkApiList != null && !checkApiList.isEmpty()) {
                    Map<String, Object> paramMap = new HashMap<>();
                    paramMap.put("userId", userInfo.getId());
                    paramMap.put("apiIdList", checkApiList);
                    paramMap.put("account", userInfo.getAccount());
                    paramList.add(paramMap);
                }
            } else {
                userIdErrorList.add(userInfo.getAccount());
            }
        }

        try {
            if (paramList != null && !paramList.isEmpty()) {

                apiNumLimtMapper.batchEmpowerUser(paramList);
                if (userIdErrorList != null && !userIdErrorList.isEmpty()) {
                    map.put("code", "403");
                    map.put("kip", userIdErrorList.toString() + "用户不存在");
                } else {
                    map.put("code", "200");
                    map.put("kip", "授权成功");
                }
                result = ResultMsg.ADD_SUCCESS;
            } else {
                map.put("code", "201");
                map.put("kip", "所选API已全部为用户授权，不需重新授权!");
            }
        } catch (Exception e) {
            map.put("code", "403");
            map.put("kip", "授权失败");
            loger.error(e.getMessage());
            result = ResultMsg.ADD_ERROR;
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), result, null, map).getJson();
    }

    @Override
    public Map<String, Object> getApiInformationByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map = informationApiMapper.getApiInformationByCode(code);
        return map;
    }

    @Override
    public void monitorExpireApi() {
        loger.info("--定时监控过期api开始");
        informationApiMapper.updateApiExpireStatus();
        loger.info("--定时监控过期api结束");
    }

    @Override
    public String getUserAccountByLike(String account) {
        List<UserInfo> userList = new ArrayList<>();
        try {
            userList = userInfoMapper.getUserAccountByLike(account);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, userList, null).getJson();
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.Error().getJson();
        }
    }

    @Override
    public String empowerUser(ApiNumLimt apiNumLimt) {
        //暂时只考虑用户账号和api
        if (StringUtils.isNotBlank(apiNumLimt.getUserid())) {
            String[] split = apiNumLimt.getUserid().split(",");
            List<String> strError = new ArrayList<>();
            List<String> strY = new ArrayList<>();
            for (String str : split) {
                //校验用户是否有效
                //UserInfo userInfo = userInfoMapper.selectUserByAccount(str);
                //UserInfo userInfo = userInfoMapper.selectConsumerUserByAccount(str);
                UserInfo userInfo = userInfoMapper.selectByPrimaryKey(str);
                if (userInfo != null) {
                    //判断是否已授权
                    int num = apiNumLimtMapper.checkIsFlag(str, apiNumLimt.getApiid());
                    if (num > 0) {
                        //当前用户已授权
                        strY.add(str);
                    } else {
                        ApiNumLimt anl = new ApiNumLimt();
                        anl.setId(StrUtils.randomUUID());
                        anl.setIdt(new Date());
                        anl.setApiid(apiNumLimt.getApiid());
                        anl.setUserid(userInfo.getId());
                        anl.setAccount(str);
                        anl.setLimtType(1);
                        anl.setTotalnum(apiNumLimt.getTotalnum());
                        //anl.setUsednum(0);
                        anl.setLeavelnum(0);
                        apiNumLimtMapper.insertSelective(anl);
                    }
                } else {
                    strError.add(str);
                }

            }
            //查询当前已授权人数
            ApiNumLimtExample example = new ApiNumLimtExample();
            ApiNumLimtExample.Criteria criteria = example.createCriteria();
            criteria.andApiidEqualTo(apiNumLimt.getApiid());
            int num = apiNumLimtMapper.countByExample(example);
            Map<String, Object> map = new HashMap<>();
            if ((strError != null && !strError.isEmpty()) || (strY != null && !strY.isEmpty())) {

                String result = "";
                if (strError != null && !strError.isEmpty()) {
                    result += strError.toString() + "用户不存在;";
                }
                if (strY != null && !strY.isEmpty()) {
                    result += strY.toString() + "用户已授权;";
                }
                map.put("code", "201");
                map.put("kip", result);
                map.put("num", num);
                return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_SUCCESS, null, map).getJson();
            } else {
                map.put("code", "200");
                map.put("kip", "授权成功");
                map.put("num", num);
                return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.ADD_SUCCESS, null, map).getJson();
            }
        }
        return null;
    }

    @Override
    public String empowerList(InformationApi informationApi, Pager pager) {
        String userId = ApplicationContextHolder.currentUser().getId();
        InformationApiExample ex = new InformationApiExample();
        ex.setPage(pager);
        ex.setOrderByClause(" IDT DESC");
        InformationApiExample.Criteria criteria = ex.createCriteria();
        criteria.andDeleteFlagNotEqualTo(ConstantClazz.DELETE_FLAG_TRUE);
        criteria.andExpireFlagNotEqualTo(ConstantClazz.DELETE_FLAG_TRUE);
        if (StringUtils.isNotBlank(informationApi.getApiCode())) {
            criteria.andApiCodeLike("%" + informationApi.getApiCode() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getApiName())) {
            criteria.andApiNameLike("%" + informationApi.getApiName() + "%");
        }
        if (StringUtils.isNotBlank(informationApi.getDescription())) {
            criteria.andDescriptionLike("%" + informationApi.getDescription() + "%");
        }
        criteria.andShareLevelNotEqualTo(ConstantClazz.SHARE_LEVEL_NONE);
        criteria.andProducerIdEqualTo(userId);
        List<InformationApi> list = new ArrayList<>();
        try {
            list = informationApiMapper.selectByExample(ex);
            pager.setPagerInfo(list, informationApiMapper.countByExample(ex));
            if (list != null && !list.isEmpty()) {
                for (InformationApi ia : list) {
                    String apiId = ia.getId();
                    //查询当前api已授权的人员
                    ApiNumLimtExample exa = new ApiNumLimtExample();
                    ApiNumLimtExample.Criteria cexa = exa.createCriteria();
                    cexa.andApiidEqualTo(apiId);
                    int anls = apiNumLimtMapper.countByExample(exa);
                    ia.setPersonNum(anls);
                }
            }
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();
        } catch (Exception e) {
            loger.error(e.getMessage());
            loger.debug("查询授权管理-api列表失败");
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, null, null).getJson();
        }

    }

    @Override
    public String lookEmpower(String id) {

        //根据apiId查询授权人员基本信息
        ApiNumLimtExample ex = new ApiNumLimtExample();
        ApiNumLimtExample.Criteria criteria = ex.createCriteria();
        criteria.andApiidEqualTo(id);
        criteria.andLimtTypeEqualTo(ConstantClazz.LIMT_TYPE_USER);
        try {
            List<UserInfo> userInfos = new ArrayList<>();
            List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.selectByExample(ex);
            if (apiNumLimts != null && !apiNumLimts.isEmpty()) {
                for (ApiNumLimt an : apiNumLimts) {
                    String userId = an.getUserid();
                    if (StringUtils.isNotBlank(userId)) {
                        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
                        if (userInfo != null) {
                            userInfos.add(userInfo);
                        }
                    }
                }
            }
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, userInfos, null).getJson();
        } catch (Exception e) {
            loger.error(e.getMessage());
            loger.debug("查询api授权人员失败!");
            return Result.Error().getJson();
        }
    }

    @Override
    public String delEmpower(ApiNumLimt apiNumLimt) {

        ApiNumLimtExample ex = new ApiNumLimtExample();
        ApiNumLimtExample.Criteria criteria1 = ex.createCriteria();
        criteria1.andApiidEqualTo(apiNumLimt.getApiid());
        criteria1.andUseridEqualTo(apiNumLimt.getUserid());
        List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.selectByExample(ex);
        if (apiNumLimts != null && !apiNumLimts.isEmpty()) {
            apiNumLimt = apiNumLimts.get(0);
        }
        Map<String, Object> map = new HashMap<>();
        //查询当前已授权人数
        ApiNumLimtExample example = new ApiNumLimtExample();
        ApiNumLimtExample.Criteria criteria = example.createCriteria();
        criteria.andApiidEqualTo(apiNumLimt.getApiid());
        int num = apiNumLimtMapper.countByExample(example);
        try {
            apiNumLimtMapper.deleteByPrimaryKey(apiNumLimt.getId());
            map.put("code", "200");
            map.put("kip", "取消成功");
            map.put("num", num - 1);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.DEL_SUCCESS, null, map).getJson();
        } catch (Exception e) {
            loger.error(e.getMessage());
            map.put("code", "403");
            map.put("kip", "取消失败");
            map.put("num", num);
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR, null, map).getJson();
        }
    }

    @Override
    public String delEmpowerByUserId(ApiNumLimt apiNumLimt) {
        String userIds = apiNumLimt.getUserid();
        if (StringUtils.isBlank(userIds)) {
            return Result.getException("未选中用户!").getJson();
        }
        String[] userStr = userIds.split(",");
        String apiIds = apiNumLimt.getApiid();
        if (StringUtils.isBlank(apiIds)) {
            return Result.getException("未选中API!").getJson();
        }
        String[] apiIdStr = apiIds.split(",");
        try {
            apiNumLimtMapper.delEmpowerByUserId(userStr, apiIdStr);
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR, null, null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.DEL_SUCCESS, null, null).getJson();
    }

    @Override
    public String countApiStatusAndNum() {
        Map<String, Integer> map = new HashMap<>();
        String userId = ApplicationContextHolder.currentUser().getId();
        try {
            map = informationApiMapper.countApiStatusAndNum(userId);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, map, null).getJson();
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.getException("查询统计失败!").getJson();
        }
    }

    @Override
    public String countConsumerApi() {
        Map<String, Integer> map = new HashMap<>();
        String userId = ApplicationContextHolder.currentUser().getId();
        try {
            map = informationApiMapper.countConsumerApi(userId);
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.getException("查询统计失败!").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, map, null).getJson();
    }

    @Override
    public String addApply(ApiNumLimt apiNumLimt) {
        UserInfo userInfo = ApplicationContextHolder.currentUser();
        if (StringUtils.isBlank(apiNumLimt.getApiid())) {
            Result.Error().getJson();
        }
        String apiId = apiNumLimt.getApiid();
        String[] split = apiId.split(",");
        try {
            //查询当前的id中已授权或者申请中的
            List<String> isEmpowerList = apiNumLimtMapper.checkIsEmpower(split, userInfo.getId());
            if (split.length > isEmpowerList.size()) {
                ArrayList<String> str = new ArrayList<>(Arrays.asList(split));
                List<String> lowStr = new ArrayList<>(CollectionUtils.subtract(str, isEmpowerList));
                //获取未授权的基本信息(api是否是开放的)
                //List<String> openList = informationApiMapper.checkOpenApi(lowStr);
                List<String> openList = new ArrayList<>();
                List<String> noOpenList = new ArrayList<>();
                //获取api基本信息
                List<InformationApi> apiList = informationApiMapper.getBatchInformationApi(lowStr);
                if (apiList != null && !apiList.isEmpty()) {
                    for (InformationApi apiInfor : apiList) {
                        if (apiInfor.getShareLevel() == ConstantClazz.SHARE_LEVEL_ALL) {
                            openList.add(apiInfor.getId());
                        } else if (apiInfor.getShareLevel() == ConstantClazz.SHARE_LEVEL_APPLY) {
                            noOpenList.add(apiInfor.getId());
                        }
                    }
                    //批量授权
                    try {
                        if (openList != null && !openList.isEmpty()) {
                            apiNumLimtMapper.batchEmpower(openList, userInfo.getId(), userInfo.getAccount());
                        }
                        return Result.getInstance(ResultCode.SUCCESS.toString(), "授权成功!", noOpenList, null).getJson();
                    } catch (Exception e) {
                        loger.error(e.getMessage());
                        return Result.Error().getJson();
                    }
                }
            } else {
                return Result.getInstance("201", "您已授权成功，不需要重复授权!", null, null).getJson();
            }
            /*List<ApiNumLimt> apiAuditStatus = apiNumLimtMapper.getApiAuditStatus(apiNumLimt.getApiid(), userInfo.getId());
            if(apiAuditStatus != null && !apiAuditStatus.isEmpty()){
                return Result.getInstance("201","您已授权成功，不需要重复授权!",null,null).getJson();
            }
            InformationApi informationApi = informationApiMapper.selectByPrimaryKey(apiNumLimt.getApiid());
            if(informationApi != null){
                //全网
                if(informationApi.getShareLevel() == ConstantClazz.SHARE_LEVEL_ALL){
                    apiNumLimt.setAuditStatus(1);
                    apiNumLimt.setAccount(userInfo.getAccount());
                    apiNumLimt.setUserid(userInfo.getId());
                    apiNumLimt.setNumFlag(1);
                    apiNumLimt.setIdt(new Date());
                    apiNumLimt.setId(StrUtils.randomUUID());
                    apiNumLimtMapper.insertSelective(apiNumLimt);
                    return Result.getInstance(ResultCode.SUCCESS.toString(),"加入申请成功",null,null).getJson();
                }else{
                    return Result.getInstance("403","",null,null).getJson();
                }
            }*/
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.getInstance(ResultCode.ERROR.toString(), "加入申请失败", null, null).getJson();
        }
        return null;
    }

    @Override
    public String startMonitor() {

        String userId = ApplicationContextHolder.currentUser().getId();
        //保存新增数据，返回给前端
        List<MonitorData> result = new ArrayList<>();
        //获取当前最近的一次版本号
        //获取监控的数据源数据
        Map<String, Integer> countMap = new HashMap<>();
        try {
            countMap = informationApiMapper.countMonitorData(userId);
            if (countMap != null && !countMap.isEmpty()) {
                Integer vNum = monitorDataMapper.getNewVersionByUserId(userId);
                if (vNum == null) {
                    vNum = 0;
                }
                vNum = vNum + 1;
                for (Map.Entry<String, Integer> map : countMap.entrySet()) {
                    Map<String, Object> mapList = new HashMap<>();
                    MonitorData monitorData = new MonitorData();
                    monitorData.setId(StrUtils.randomUUID());
                    monitorData.setIdt(new Date());
                    monitorData.setUserId(userId);
                    monitorData.setBatch(vNum);
                    Number number = map.getValue();
                    if (map.getKey().equals("reptime")) {
                        mapList.put(map.getKey(), map.getValue());
                        monitorData.setMonitorType(6);
                        monitorData.setRoleType(2);
                        monitorData.setNum(number.intValue());
                    } else {
                        mapList.put(map.getKey(), map.getValue());
                        List<Map<String, Object>> resultList = new ArrayList<>();
                        resultList = informationApiMapper.getTestListByType(map.getKey(), userId);
                        mapList.put(map.getKey() + "List", resultList);
                        if (map.getKey().equals("uses")) {
                            monitorData.setMonitorType(1);
                        } else if (map.getKey().equals("error")) {
                            monitorData.setMonitorType(2);
                        } else if (map.getKey().equals("expire")) {
                            monitorData.setMonitorType(3);
                        } else if (map.getKey().equals("callfail")) {
                            monitorData.setMonitorType(4);
                        } else if (map.getKey().equals("calls")) {
                            monitorData.setMonitorType(5);
                        }
                        monitorData.setNum(number.intValue());
                        monitorData.setRoleType(2);
                        monitorData.setResult(JsonUtils.toDefultJson(resultList));
                    }
                    result.add(monitorData);
                    monitorDataMapper.insertSelective(monitorData);
                }
            }
        } catch (Exception e) {
            loger.error(e.getMessage());
            System.err.println(e.getMessage());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), "检测成功", result, null).getJson();
    }

    @Override
    public String getProviderMonitorData() {
        String userId = ApplicationContextHolder.currentUser().getId();
        List<MonitorData> list = new ArrayList<>();
        try {
            Integer version = monitorDataMapper.getNewVersionByUserId(userId);
            if (version == null) {
                version = 0;
            }
            MonitorDataExample ex = new MonitorDataExample();
            MonitorDataExample.Criteria criteria = ex.createCriteria();
            criteria.andBatchEqualTo(version);
            criteria.andUserIdEqualTo(userId);
            list = monitorDataMapper.selectByExampleWithBLOBs(ex);
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, null).getJson();
    }

    @Override
    public String apiAndAppCounts() {
        //新建工具包
        Map map = new HashMap();
        Map apiMap = null;
        Integer applyingAPI = Constant.NUMBER_0;
        Integer empowerAPI = Constant.NUMBER_0;
        try {
            //调用api统计接口，查询api数量
            String apiList = apiManagerService.countConsumerApi();
            //解析数据
            Map decodeApp = JSONDecoder.decode(apiList);
            apiMap = (Map) decodeApp.get("result");
            //获取申请中和已授权的api个数
            applyingAPI = Integer.valueOf(apiMap.get("applying").toString());
            empowerAPI = Integer.valueOf(apiMap.get("empower").toString());
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, null, null).getJson();
        }
        //存入Map,已授权API
        map.put("empowerAPI", empowerAPI);
        //调用app统计接口，查询app数量
        Integer applyingAPP = Constant.NUMBER_0;
        Integer empowerAPP = Constant.NUMBER_0;
        try {
            String appList = appInfoService.countConsumerApp();
            //解析数据
            Map decodeApi = JSONDecoder.decode(appList);
            Map appMap = (Map) decodeApi.get("result");
            //获取申请中和已授权的app个数
            applyingAPP = Integer.valueOf(appMap.get("applying").toString());
            empowerAPP = Integer.valueOf(appMap.get("empower").toString());
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, null, null).getJson();
        }
        Object list = null;
        try {
            //存入Map,已授权APP
            map.put("empowerAPP", empowerAPP);
            //存入Map,申请中API和APP总数
            map.put("applyingApiAndApp", applyingAPI + applyingAPP);
            //存入Map,总数
            map.put("totalNums", empowerAPI + empowerAPP + applyingAPI + applyingAPP);
            //将map转成json格式
            list = JSONObject.toJSON(map);
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, null, null).getJson();
        }
        //返回数据
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, list, null).getJson();
    }


    @Override
    public Pager applying(String type, String initial, String name, String code, String desc, Pager pager) {
        //在token中获取userid
        String userid = ApplicationContextHolder.currentUser().getId();
        //判断查询的type是api还是app
        try {
            //查询api相关数据
            if ("api".equals(type)) {
                //创建查询条件
                ApiNumLimtExample apiNumLimtExample = new ApiNumLimtExample();
                //设置分页
                apiNumLimtExample.setPage(pager);
                ApiNumLimtExample.Criteria criteria = apiNumLimtExample.createCriteria();
                //添加过滤条件
                //用户ID为当前登录用户
                criteria.andUseridEqualTo(userid);
                //用户与api审核状态为申请中
                criteria.andAuditStatusEqualTo(Constant.NUMBER_3);
                //如果initial不为空，根据initial进行对NAME和CODE的模糊匹配
                if (!StrUtils.isBlank(initial)) {
                    criteria.andInitialLike("%" + initial + "%");
                }
                //如果code不为空，根据code进行模糊匹配
                if (!StrUtils.isBlank(code)) {
                    criteria.andApiCodeLike("%" + code + "%");
                }
                //如果name不为空，根据name进行模糊匹配
                if (!StrUtils.isBlank(name)) {
                    criteria.andApiNameLike("%" + name + "%");
                }
                //如果description不为空，根据desc进行模糊匹配
                if (!StrUtils.isBlank(desc)) {
                    criteria.andApiDescLike("%" + desc + "%");
                }
                //根据查询条件进行查询
                List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.selectApiByNameCodeDesc(apiNumLimtExample);
                //循环查询结果，调用流转进程接口，将流转信息存入RC1中
                for (ApiNumLimt apiNumLimt : apiNumLimts) {
                    //调用查询流转进程的接口，查询数据
                    String s = applyingProcess(apiNumLimt.getUserid(), apiNumLimt.getApiid(),type);
                    //解析数据，获取result
                    Map decode = JSONDecoder.decode(s);
                    String result = String.valueOf(decode.get("result"));
//                    String result = String.valueOf(JSONObject.toJSON(res));
                    //将流转进度存入RC1
                    apiNumLimt.setRc1(result);
                }
                //将查询结果存入pager对象中，返回给前端
                pager.setPagerInfo(apiNumLimts, apiNumLimts.size());
                return pager;

            }
            //查询app相关数据
            if ("app".equals(type)) {
                //创建查询条件
                AppUserMapExample appUserMapExample = new AppUserMapExample();
                //设置分页
                appUserMapExample.setPage(pager);
                AppUserMapExample.Criteria criteria = appUserMapExample.createCriteria();
                //添加过滤条件
                //用户ID为当前登录用户
                criteria.andUseridEqualTo(userid);
                //用户与app审核状态为申请中
                criteria.andApplyStatusEqualTo(Constant.NUMBER_3);
                //如果initial不为空，根据initial进行对NAME和CODE的模糊匹配
                if (!StrUtils.isBlank(initial)) {
                    criteria.andInitialLike("%" + initial + "%");
                }
                //如果code不为空，根据code进行模糊匹配
                if (!StrUtils.isBlank(code)) {
                    criteria.andAppCodeLike("%" + code + "%");
                }
                //如果name不为空，根据name进行模糊匹配
                if (!StrUtils.isBlank(name)) {
                    criteria.andAppNameLike("%" + name + "%");
                }
                //如果description不为空，根据desc进行模糊匹配
                if (!StrUtils.isBlank(desc)) {
                    criteria.andAppDescLike("%" + desc + "%");
                }
                //根据查询条件进行查询
                List<AppUserMap> appUserMaps = appUserMapMapper.selectAppByCodeNameDesc(appUserMapExample);
                //循环查询结果，调用流转进程接口，将流转信息存入RC1中
                for (AppUserMap appUserMap : appUserMaps) {
                    //调用查询流转进程的接口，查询数据
                    String s = applyingProcess(appUserMap.getUserid(), appUserMap.getAppid(),type);
                    //解析数据，获取result
                    Map decode = JSONDecoder.decode(s);
                    String result = (String) decode.get("result");
                    //将流转进度存入RC1
                    appUserMap.setRc1(result);
                }
                //将查询结果存入pager对象中，返回给前端
                pager.setPagerInfo(appUserMaps, appUserMaps.size());
                return pager;
            }
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
        }
        pager.setPagerInfo(null, pager.getRowCount());
        return pager;
    }

    private String applyingProcess(String userid, String code, String type) {
        try {
            //创建查询对象
            MessageCommentExample messageCommentExample = new MessageCommentExample();
            //根据用户ID和apiID或appID查询消息回复表
            messageCommentExample.createCriteria().andSenderidEqualTo(userid).andApiidEqualTo(code);
            List<MessageComment> messageComments = messageCommentMapper.selectByExample(messageCommentExample);
            //创建工具包，用来判断流转是否为发起申请或生产者待批复
            List list = new ArrayList();
            //map工具，用来存放处理时间
            Map<String, String> map = new HashMap();
            //循环结果集
            for (MessageComment messageComment : messageComments) {
                //如果处理状态为0，则说明此api或app的处理状态为管理者待批复
                if (Constant.NUMBER_0 == messageComment.getIsdeal()) {
                    list.add(messageComment);
                    if ("api".equals(type)) {
                        ApiNumLimtExample apiNumLimtExample = new ApiNumLimtExample();
                        apiNumLimtExample.createCriteria().andUseridEqualTo(userid).andApiidEqualTo(code);
                        //根据用户ID和apiid/appid查询
                        List<ApiNumLimt> apiNumLimts = apiNumLimtMapper.selectByExample(apiNumLimtExample);
                        Date idt = apiNumLimts.get(Constant.NUMBER_0).getIdt();
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:ss:mm");
                        String format = sdf.format(idt);
                        map.put("time1", format);
                    }

                    if ("app".equals(type)) {
                        AppUserMapExample appUserMapExample = new AppUserMapExample();
                        appUserMapExample.createCriteria().andUseridEqualTo(userid).andAppidEqualTo(code);
                        //根据用户ID和apiid/appid查询
                        List<AppUserMap> appUserMaps = appUserMapMapper.selectByExample(appUserMapExample);
                        Date idt = appUserMaps.get(Constant.NUMBER_0).getIdt();
                        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:ss:mm");
                        String format = sdf.format(idt);
                        map.put("time1", format);
                    }
                }
            }
            //如果查到结果，则list不为空，则此时是生产者待批复
            if (Constant.NUMBER_0 != list.size()) {
                //过去管理者批复时间
                Date idt = messageComments.get(Constant.NUMBER_0).getIdt();
                //将时间转换格式
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:ss:mm");
                String format = sdf.format(idt);
                //存入map中
                map.put("time2", format);
                return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, JsonUtils.toJson(map), null).getJson();
                //如果没有查到结果，则list为空，则此时是管理者待批复
            } else {
                return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, JsonUtils.toJson(map), null).getJson();
            }
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, null, null).getJson();
        }

    }

    @Override
    public Boolean insertSelective(ApiNumLimt apiNumLimt) {
        try {
            return apiNumLimtMapper.insertSelective(apiNumLimt) == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
            loger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public List<ApiNumLimt> selectByExample(ApiNumLimt apiNumLimt) {
        //初始化Example
        ApiNumLimtExample apiNumLimtExample = new ApiNumLimtExample();

        //创建查询条件
        ApiNumLimtExample.Criteria userCriteria = apiNumLimtExample.createCriteria();

        if (!StrUtils.isBlank(apiNumLimt.getUserid())) {
            userCriteria.andUseridEqualTo(apiNumLimt.getUserid());
        }
        List<ApiNumLimt> apiNumLimts = null;
        try {
            apiNumLimts = apiNumLimtMapper.selectByExample(apiNumLimtExample);
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
        }
        return apiNumLimts;
    }

    @Override
    public List<ApiNumLimt> selectExample(String senderid) {
        ApiNumLimtExample apiNumLimtExample = new ApiNumLimtExample();
        apiNumLimtExample.createCriteria().andUseridEqualTo(senderid);
        List<ApiNumLimt> apiNumLimts = null;
        try {
            apiNumLimts = apiNumLimtMapper.selectByExample(apiNumLimtExample);
        } catch (Exception e) {
            loger.error(e.getMessage());
            e.printStackTrace();
        }
        return apiNumLimts;
    }

    @Override
    public Boolean updateByPrimaryKeySelective(ApiNumLimt apiNumLimt) {
        return apiNumLimtMapper.updateByPrimaryKeySelective(apiNumLimt) == 1 ? true : false;
    }

    /**
     * 功能描述: 解析参数并且调用
     *
     * @param: [informationApi]
     * @return: java.util.List<?>
     * @auther: zhangbo
     * @date: 2018/10/9 10:16
     */
    public InformationApi getParmsList(InformationApi informationApi) {
        InformationApi strs = null;
        Map<String, Object> map = new LinkedHashMap<>();
        //获取参数集合
        if (informationApi.getParmsFlag() == 1) {
            List<ParmsApi> shamParms = parmsApiMapper.getShamParms(informationApi.getId());
            if (shamParms != null && !shamParms.isEmpty()) {
                for (ParmsApi parmsApi : shamParms) {
                    map.put(parmsApi.getRealParms(), parmsApi.getDefaultValue());
                }
            }
        }
        //调用请求接口,返回值写入日志,修改api运行状态
        try {
            if (StringUtils.isBlank(informationApi.getOuterParamType()) || true) {
                restClient.httpRequest(map, informationApi);
            } else {
                restClient.fileHttpRequest(map, informationApi);
            }
        } catch (/**HttpClientErrorException**/Exception e) {
            strs = informationApi;
        }
        return strs;
    }

    @Override
    public String getApiListByResourceCode(Pager pager, String resourceCode) {
        List<InformationApi> list = new ArrayList<>();
        if (StringUtils.isBlank(resourceCode)) {
            return Result.getException("当前未选中目录").getJson();
        }
        try {
            list = informationApiMapper.getApiListByResourceCode(resourceCode, pager);
            pager.setPagerInfo(list, list.size());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, pager, null).getJson();

    }

    @Override
    public String getSubscribeResourcePageByUserId(RcsResourceCate rcsResourceCate) {
        String userId = ApplicationContextHolder.currentUser().getId();
        if (StringUtils.isBlank(userId)) {
            return Result.getException("暂未登陆").getJson();
        }

        //根据用户查询目录订阅的编码集合
        List<String> codeStr = catalogUserMapMapper.getSubscribeResourceCode(userId);
        if (codeStr != null && !codeStr.isEmpty()) {
            try {
                rcsResourceCate.setCodes(codeStr);
                return resourceCateManagerClientService.getResourcePageListByResourceCode(rcsResourceCate);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.getException("请求失败!").getJson();
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, rcsResourceCate.getPager(), null).getJson();
    }

    @Override
    public String getSubscribeResourceByUserId(String userId) {

        if (StringUtils.isBlank(userId)) {
            return Result.getException("用户不能为空").getJson();
        }

        try {
            List<String> codeList = catalogUserMapMapper.getSubscribeResourceCode(userId);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, codeList, null).getJson();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
    }

    @Override
    public String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate, String code){

        try {
            String result = resourceCateManagerClientService.getResourceCatalogConsumerPages(rcsResourceCate, code);
            JSONObject jsonObject = JSONObject.parseObject(result);
            if(jsonObject.get("code").equals("200")){
                //获取结果集
                JSONObject resJson = (JSONObject)jsonObject.get("result");
                if(resJson != null && !resJson.isEmpty()){
                    List<Map<String, Object>> aa = (List<Map<String, Object>>)resJson.get("dataList");
                    if(aa != null && !aa.isEmpty()){
                        //获取当前已订阅资源目录集合
                        String userId = ApplicationContextHolder.currentUser().getId();
                        List<String> codeStr = catalogUserMapMapper.getSubscribeResourceCode(userId);
                        if(codeStr != null && !codeStr.isEmpty()){
                            for(Map<String, Object> rcs : aa){
                                if(codeStr.contains(rcs.get("code"))){
                                    rcs.put("isSub",1);
                                }else{
                                    rcs.put("isSub",0);
                                }
                            }
                        }
                    }
                    resJson.put("dataList",aa);
                    jsonObject.put("result",resJson);
                    return JSONObject.toJSONString(jsonObject);
                }
            }else{
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
            loger.error("远程调用消费者数据目录列表失败!");
            loger.error(e.getMessage());
            return Result.Error().getJson();
        }
        return null;
    }


    @Override
    public boolean save(CatalogUserMap entry) {
        if (StringUtils.isBlank(entry.getUserid()) || StringUtils.isBlank(entry.getCatalogCode())) {
            loger.debug(TextUtils.format("用户{0}订阅目录：{1}", entry.getUserid(), entry.getCatalogCode()));
            return false;
        }
        try {
            //将code切割，分别加入到数据库中
            String[] split = entry.getCatalogCode().split(",");

            //查询该用户订阅过的目录
            CatalogUserMapExample catalogUserMapExample = new CatalogUserMapExample();
            catalogUserMapExample.createCriteria().andUseridEqualTo(entry.getUserid());
            //获取查询结果
            List<CatalogUserMap> catalogUserMaps = catalogUserMapMapper.selectByExample(catalogUserMapExample);
            //循环目录编码（catalogCode）
            for (String s : split) {
                //删除用户已订阅的目录
                for (CatalogUserMap catalogUserMap : catalogUserMaps) {
                    CatalogUserMapExample catalogMapExample = new CatalogUserMapExample();
                    catalogMapExample.createCriteria().andUseridEqualTo(catalogUserMap.getUserid()).andCatalogCodeEqualTo(s);
                    catalogUserMapMapper.deleteByExample(catalogMapExample);
                }
                //将新增订阅的目录写入库中
                CatalogUserMap catalogUserMap = new CatalogUserMap();//新建实体类
                catalogUserMap.setUserid(entry.getUserid());//用户ID
                catalogUserMap.setCatalogCode(s);//目录编码
                catalogUserMap.setIdt(new Date());//创建时间
                catalogUserMap.setStatus(entry.getStatus());//订阅状态
                catalogUserMapMapper.insertSelective(catalogUserMap);//保存
            }
            loger.info("订阅成功！");
            return true;
        } catch (Exception e) {
            loger.error(TextUtils.format("订阅失败"));
            loger.error(e.getMessage());
            return false;
        }
    }

    @Override
    public String getNumByConditions(InformationApi informationApi) {


        if(StringUtils.isBlank(informationApi.getUrl())){
            return Result.getException("当前未传入任何url!").getJson();
        }

        InformationApiExample ex = new InformationApiExample();
        InformationApiExample.Criteria criteria = ex.createCriteria();
        criteria.andUrlEqualTo(informationApi.getUrl());
        criteria.andRequestTypeEqualTo(informationApi.getRequestType());
        criteria.andDeleteFlagEqualTo(ConstantClazz.DELETE_FLAG_FALSE);
        int num = 0;
        try {
            num = informationApiMapper.countByExample(ex);
        }catch (Exception e){
            return Result.getException("查询失败!").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,num,null).getJson();
    }

    @Override
    public String getDeptListByManager() {

        try {
            List<Map<String, Object>> list = deptMapper.getDeptListByManager();
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,null).getJson();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
    }

    @Override
    public String countApiUseByDept(String deptCode) {
        Map<String, Object> map = new HashMap<>();
        map.put("deptCode",deptCode);
        List<InformationApi> list = null;
        int num = 0;
        try {
            //list = informationApiMapper.getManagerListTwo(map);
            list = informationApiMapper.getApiIdByDeptCode(map);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
        if(list != null && !list.isEmpty()){
            List<String> idStr = list.stream().map(InformationApi::getId).collect(Collectors.toList());
            //根据apiId集合查询
            try {
                num = informationApiMapper.countOrderByApiId(idStr);
            } catch (Exception e) {
                e.printStackTrace();
                return Result.Error().getJson();
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,num,null).getJson();
    }

}
