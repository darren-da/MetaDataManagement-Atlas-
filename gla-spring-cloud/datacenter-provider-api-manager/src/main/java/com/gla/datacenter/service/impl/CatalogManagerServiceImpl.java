package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.ApiCatalogChange;
import com.gla.datacenter.domain.ApiCatalogChangeExample;
import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.CatalogUserMapExample;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.mapper.mysql.ApiCatalogChangeMapper;
import com.gla.datacenter.mapper.mysql.CatalogUserMapMapper;
import com.gla.datacenter.mapper.mysql.InformationApiMapper;
import com.gla.datacenter.service.CatalogManagerService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Author: zhengshien
 * @Date: 2019/3/4 14:49
 * @Description:
 */
@Service
public class CatalogManagerServiceImpl implements CatalogManagerService {
    private Logger log = LoggerFactory.getLogger(CatalogManagerServiceImpl.class);

    private static final int ONEWEEKAGO = 7 * 24 * 60 * 60 * 1000;


    /**
     * 引入ApiCatalogChangeMapper
     */
    @Autowired
    private ApiCatalogChangeMapper apiCatalogChangeMapper;

    @Autowired
    InformationApiMapper informationApiMapper;


    @Override
    public Boolean saveApiCatalogChange(ApiCatalogChange apiCatalogChange) {
        if (StrUtils.isBlank(apiCatalogChange)) {
            log.info("/***参数异常：参数为空！**/");
            throw new RuntimeException("参数异常：参数为空！");
        }
        log.debug(TextUtils.format("新增变更记录"));
        try {
            apiCatalogChange.setId(StrUtils.randomUUID());
            apiCatalogChange.setIdt(new Date());
            log.info("/***新增变更记录**/");
            return apiCatalogChangeMapper.insertSelective(apiCatalogChange) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<ApiCatalogChange> selectApiCatalogChange(ApiCatalogChange apiCatalogChange) {
        //初始化Example
        ApiCatalogChangeExample apiCatalogChangeExample = new ApiCatalogChangeExample();

        //创建查询条件
        ApiCatalogChangeExample.Criteria criteria = apiCatalogChangeExample.createCriteria();

        //如果部门状态不为空，则更具部门状态查询部门列表
        if (!StrUtils.isBlank(apiCatalogChange.getIdt())) {
            Date date = new Date();//当前时间
            Date oneweekago = new Date(date.getTime() - ONEWEEKAGO);//一周前
            criteria.andIdtBetween(oneweekago,date);
        }

        return apiCatalogChangeMapper.selectByExample(apiCatalogChangeExample);
    }

    boolean insertRecordCateChange(InformationApi  api,String tagCode,String operation){
        //初始化资源变动目录
        ApiCatalogChange  apiCatalogChange=new ApiCatalogChange();
        apiCatalogChange.setId(StrUtils.randomUUID());
        apiCatalogChange.setIdt(new Date());
        apiCatalogChange.setApiCode(api.getApiCode());
        apiCatalogChange.setApiName(api.getApiName());
        //创建者ID
        apiCatalogChange.setOperAccount(api.getCreateId());
        apiCatalogChange.setApiCataCode(tagCode);
        //新增操作
        apiCatalogChange.setOperation(operation);
        log.debug("/***新增API资源目录新增记录**/"+ JsonUtils.toJson(apiCatalogChange));
        apiCatalogChangeMapper.insertSelective(apiCatalogChange);
        return  true;
    }
    @Override
    public Boolean recordCateChange(InformationApi  api) {

             //判断apicode是否为空 ：空则为【新增】操作
            if(!StrUtils.isBlank(api.getApiCode())){
                //不为空则新增变更通知信息表
                if(!StrUtils.isBlank(api.getCategoryId())){
                    String [] tags=api.getCategoryId().split(Constant.DHAO);
                    for( String  tagCode:tags){
                        //为空则跳过此条资源编码
                        if(StrUtils.isBlank(tagCode)){
                            continue;
                        }
                        insertRecordCateChange(api,tagCode,Constant.STRING_1);
                    }
                }
            }
            //改和删除操作
            else{
                //：增加
                if(api.getApiStatus()==null){
                    //修改前
                    //获取之前的api
                    InformationApi  foreApi=informationApiMapper.selectByPrimaryKey(api.getId());
                    String  modifCataCode=foreApi.getCategoryId();

                    //新增资源目录 ：增
                    List<String> addCataList= StrUtils.compSourceListDiff(Arrays.asList(api.getCategoryId().split(Constant.DHAO))
                            , Arrays.asList(modifCataCode.split(Constant.DHAO)));
                    for(String tag:addCataList){
                        if(StrUtils.isBlank(tag)){
                            continue;
                        }
                        insertRecordCateChange(api,tag,Constant.STRING_1);
                    }
                    //删除
                    List<String> delCataList= StrUtils.compSourceListDiff( Arrays.asList(modifCataCode.split(Constant.DHAO))
                            ,Arrays.asList(api.getCategoryId().split(Constant.DHAO)));
                    for(String tag:delCataList){
                        if(StrUtils.isBlank(tag)){
                            continue;
                        }
                        insertRecordCateChange(api,tag,Constant.STRING_2);
                    }

                }else
                    //修改的状态
                    {

                        if(!StrUtils.isBlank(api.getCategoryId())){
                            String [] tags=api.getCategoryId().split(Constant.DHAO);
                            for( String  tagCode:tags){
                                //为空则跳过此条资源编码
                                if(StrUtils.isBlank(tagCode)){
                                    continue;
                                }
                                InformationApi  foreApi=informationApiMapper.selectByPrimaryKey(api.getId());
                                api.setApiCode(foreApi.getApiCode());
                                insertRecordCateChange(api,tagCode,Constant.STRING_2);
                            }
                        }
                }

            }

            return true;
    }

    @Override
    public boolean save(CatalogUserMap entry) {
        return false;
    }

    @Override
    public CatalogUserMap get(String id) {
        return null;
    }

    @Override
    public boolean update(CatalogUserMap entry) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<CatalogUserMap> getList(CatalogUserMap entry) {
        return null;
    }

    @Override
    public Pager<CatalogUserMap> getPageList(CatalogUserMap entry, Pager pager) {
        return null;
    }
}