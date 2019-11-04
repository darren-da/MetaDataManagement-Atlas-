package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.FilterInformationApi;
import com.gla.datacenter.domain.FilterInformationApiExample;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.mapper.mysql.FilterInformationApiMapper;
import com.gla.datacenter.model.ApiFilterResponseModel;
import com.gla.datacenter.service.ApiFilterService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: zhangbo
 * @Date: 2019/1/2 11:14
 * @Description:
 */
@Service
public class ApiFilterServiceImpl implements ApiFilterService {

    private Logger loger = LoggerFactory.getLogger(ApiFilterServiceImpl.class);

    @Autowired
    private FilterInformationApiMapper filterInformationApiMapper;

    @Override
    public String getFilterCount() {

        String userId = ApplicationContextHolder.currentUser().getId();

        Map<String, Integer> map = new HashMap<>();
        try {
            map = filterInformationApiMapper.getFilterCount(userId);
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,map,null).getJson();
    }

    @Override
    public String getFilterPageList(FilterInformationApi filterInformationApi,Pager pager) {

        //定义接收参数
        Map<String, Object> paramMap = new HashMap<>();
        List<ApiFilterResponseModel> list = new ArrayList<>();
        String userId = ApplicationContextHolder.currentUser().getId();
        List<String> personType = filterInformationApi.getPersonType();
        if(personType == null || personType.size() == 0){
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,null,null).getJson();
        }
        paramMap.put("personType",personType);
        if(StringUtils.isNotBlank(filterInformationApi.getRc2())){
            paramMap.put("rc2",filterInformationApi.getRc2());
        }
        if(StringUtils.isNotBlank(filterInformationApi.getAccountVisit())){
            paramMap.put("account",filterInformationApi.getAccountVisit());
        }
        if(StringUtils.isNotBlank(filterInformationApi.getDeptnameVisit())){
            paramMap.put("orgName",filterInformationApi.getDeptnameVisit());
        }
        if(filterInformationApi.getIdt() != null){
            paramMap.put("idt",filterInformationApi.getIdt());
        }
        paramMap.put("userId",userId);
        int count = 0;
        try {
            count = filterInformationApiMapper.getFilterPageList(paramMap).size();
        } catch (Exception e) {
            loger.error(e.getMessage());
            return Result.Error().getJson();
        }
        if (filterInformationApi.getPage() > 0) {
            paramMap.put("page",(filterInformationApi.getPage() -1) * (filterInformationApi.getRows() != 0 ? filterInformationApi.getRows() : 10));
        }else{
            paramMap.put("page",0);
        }
        if(filterInformationApi.getRows() != 0){
            paramMap.put("rows",filterInformationApi.getRows());
        }else{
            paramMap.put("rows",10);
        }

        if(count > 0){
            list = filterInformationApiMapper.getFilterPageList(paramMap);
        }
        pager.setPagerInfo(list,count);
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String addApiFilter(FilterInformationApi filterInformationApi, Pager pager) {

        String userId = ApplicationContextHolder.currentUser().getId();
        if(StringUtils.isNotBlank(filterInformationApi.getId())){
            //编辑
            try{
                filterInformationApi.setUserId(userId);
                filterInformationApiMapper.updateByPrimaryKey(filterInformationApi);
                return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
            }catch(Exception e){
                loger.error(e.getMessage());
                loger.debug(TextUtils.format("api过滤{0}更新失败",filterInformationApi.getId()));
                return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_ERROR,null,null).getJson();
            }
        }else{
            //新增
            filterInformationApi.setId(StrUtils.randomUUID());
            filterInformationApi.setIdt(new Date());
            filterInformationApi.setUserId(userId);
            try{
                //判断当前用户是否存在黑白名单
                FilterInformationApiExample ex = new FilterInformationApiExample();
                FilterInformationApiExample.Criteria criteria = ex.createCriteria();
                criteria.andUserIdEqualTo(userId);
                criteria.andFilterVisitEqualTo(filterInformationApi.getFilterVisit());
                criteria.andFilterTypeEqualTo(1);
                criteria.andDeleteFlagEqualTo(ConstantClazz.DELETE_FLAG_FALSE);
                List<FilterInformationApi> filterInformationApis = filterInformationApiMapper.selectByExample(ex);
                if(filterInformationApis != null && !filterInformationApis.isEmpty()){
                    return Result.getInstance(Result.Error().toString(),"当前用户已被加入黑白名单，不可重复添加",null,null).getJson();
                }
                filterInformationApiMapper.insertSelective(filterInformationApi);
                ApiFilterResponseModel afrm = new ApiFilterResponseModel();
                Map<String, Object> paramMap = new HashMap<>();
                List<String> str = Arrays.asList("black","white");
                paramMap.put("id",filterInformationApi.getId());
                paramMap.put("personType",str);
                paramMap.put("userId",userId);
                List<ApiFilterResponseModel> list = filterInformationApiMapper.getFilterPageList(paramMap);
                if(list != null && !list.isEmpty()){
                    afrm = list.get(0);
                }
                return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,afrm,null).getJson();
            }catch (Exception e){
                loger.error(e.getMessage());
                loger.debug(TextUtils.format("api过滤新增失败"));
                return Result.getInstance(ResultCode.ERROR.toString(),"操作失败",null,null).getJson();
            }
        }
    }

    @Override
    public String deleteApiFilter(String id,int listType) {

        if(StringUtils.isBlank(id)){
            return Result.getException(ExceptionEnum.ParamNameIllegal).getJson();
        }
        String[] ids = id.split(",");

        //查询该所选id是否符合listType
        List<String> listStr = filterInformationApiMapper.checkListType(ids,listType);
        //没有传递修改人和修改时间
        try{
            filterInformationApiMapper.deleteApiFilter(listStr);
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,listStr,"").getJson();
        }catch (Exception e){
            loger.error(e.getMessage());
            loger.debug(TextUtils.format("删除api过滤信息失败"));
            return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.UPDATE_ERROR,"","").getJson();
        }
    }
}
