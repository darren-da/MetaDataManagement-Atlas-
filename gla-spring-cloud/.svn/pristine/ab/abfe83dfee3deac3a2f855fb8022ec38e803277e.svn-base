package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.*;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.mapper.mysql.DataModelManagerMapper;
import com.gla.datacenter.mapper.mysql.MasterDataManagerMapper;
import com.gla.datacenter.mapper.mysql.ModelFieldMapper;
import com.gla.datacenter.model.MDMDataModelModels;
import com.gla.datacenter.model.ModelFieldModel;
import com.gla.datacenter.service.MDMService;
import com.gla.datacenter.utils.RandomStringUtil;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ConstantClazz;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.ThreadPoolUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @Author: zhangbo
 * @Date: 2019/6/21 10:28
 * @Description:
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class MDMServiceImpl implements MDMService{

    private Logger logger = LoggerFactory.getLogger(MDMServiceImpl.class);

    @Autowired
    private DataModelManagerMapper dataModelManagerMapper;

    @Autowired
    private ModelFieldMapper modelFieldMapper;

    @Autowired
    private MasterDataManagerMapper masterDataManagerMapper;

    @Override
    public String getDataModelListPager(DataModelManager dataModelManager, Pager pager) {

        DataModelManagerExample ex = new DataModelManagerExample();
        //ex.setPage(pager);
        ex.setOrderByClause(" IDT DESC");
        DataModelManagerExample.Criteria criteria = ex.createCriteria();
        if(!StrUtils.isBlank(dataModelManager.getModelName())){
            criteria.andModelNameLike("%" + dataModelManager.getModelName() + "%");
        }
        if(!StrUtils.isBlank(dataModelManager.getModelCode())){
            criteria.andModelCodeEqualTo(dataModelManager.getModelCode());
        }
        if(!StrUtils.isBlank(dataModelManager.getModelDescribe())){
            criteria.andModelDescribeLike("%" + dataModelManager.getModelDescribe() + "%");
        }
        if(!StrUtils.isBlank(dataModelManager.getAlltill())){
            criteria.andAlltill(dataModelManager.getAlltill());
        }
        if(!StrUtils.isBlank(dataModelManager.getLpsort())){
            ex.setOrderByClause(dataModelManager.getLpsort() + " DESC");
        }else{
            ex.setOrderByClause("IDT DESC");
        }
        if(StrUtils.isBlank(dataModelManager.getPublicFlag())){
            criteria.andPublicFlagEqualTo(1);
        }else{
            criteria.andPublicFlagEqualTo(dataModelManager.getPublicFlag());
        }

        criteria.andStatusEqualTo(ConstantClazz.MDM_DATA_MODEL_STATUS_DELETE_FLAG_FLASE);
        List<DataModelManager> list = null;
        try {
            list = dataModelManagerMapper.selectByExample(ex);
            if(list != null && !list.isEmpty()){
                for(DataModelManager d : list){
                    String[] tableNameByModelId = modelFieldMapper.getTableNameByModelId(d.getId());
                    d.setTableNames(tableNameByModelId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询数据模型列表失败!");
            return Result.Error().getJson();
        }
        //pager.setPagerInfo(list,dataModelManagerMapper.countByExample(ex));
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,list,null).getJson();
    }

    @Override
    public String editDataModel(DataModelManager dataModelManager) {

        if(StrUtils.isBlank(dataModelManager.getId())){
            return Result.getException("当前未选中记录!").getJson();
        }
        try {
            dataModelManagerMapper.updateByPrimaryKeySelective(dataModelManager);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.UPDATE_ERROR,null,null).getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
    }

    @Override
    public String deleteDataModel(String id) {

        if(StrUtils.isBlank(id)){
            return Result.getException("当前未选中记录!").getJson();
        }
        DataModelManager dataModelManager = new DataModelManager();
        try {
            dataModelManager = dataModelManagerMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("根据数据模型{}查询数据失败",id);
            return Result.Error().getJson();
        }
        if(null != dataModelManager.getPublicFlag() && dataModelManager.getPublicFlag() == 2){
            return Result.getException("不能删除数据模板!").getJson();
        }
        dataModelManager.setStatus(ConstantClazz.MDM_DATA_MODEL_STATUS_DELETE_FLAG_TRUE);
        dataModelManager.setUdt(new Date());
        try {
            dataModelManagerMapper.updateByPrimaryKeySelective(dataModelManager);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.DEL_ERROR,null,null).getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.DEL_SUCCESS,null,null).getJson();
    }

    @Override
    public String addDataModel(MDMDataModelModels mdmDataModelModels) {

        DataModelManager dataModelManager = mdmDataModelModels.getDataModelManager();
        if(StrUtils.isBlank(dataModelManager)){
            return Result.getException("添加数据有误!").getJson();
        }
        List<ModelField> modelFields = mdmDataModelModels.getModelFields();
        if(modelFields.isEmpty()){
            return Result.getException("添加数据有误!").getJson();
        }
        String userId = ApplicationContextHolder.currentUser().getId();
        String idParam = dataModelManager.getId();
        Integer publicFlag = dataModelManager.getPublicFlag();
        if(!StrUtils.isBlank(idParam)){
            dataModelManager.setUdt(new Date());
            dataModelManager.setUpdateId(userId);
            try {
                dataModelManager.setPublicFlag(1);
                dataModelManagerMapper.updateByPrimaryKeySelective(dataModelManager);
                try {

                    modelFieldMapper.deleteFieldByModelId(dataModelManager.getId());
                } catch (Exception e) {
                    e.printStackTrace();
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    logger.info("根据模型id:{}删除字段失败!",dataModelManager.getId());
                    return Result.Error().getJson();
                }
                if(modelFields != null && !modelFields.isEmpty()){
                    try {
                        if(StrUtils.isBlank(dataModelManager.getModelCode())){
                            dataModelManager.setModelCode(StrUtils.isBlank(dataModelManager.getTableNames()) ? "_" + RandomStringUtil.getRandomCode(3,2) : (dataModelManager.getTableNames()[0] + "_" + RandomStringUtil.getRandomCode(3,2)));
                        }
                        modelFieldMapper.insertFieldByList(modelFields,dataModelManager.getId());
                    } catch (Exception e) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        e.printStackTrace();
                        logger.info("批量插入字段失败!");
                        return Result.Error().getJson();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                logger.error("保存数据模型id为:{}失败!",dataModelManager.getId());
                return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.ADD_ERROR,null,null).getJson();
            }

        }else{
            String id = StrUtils.randomUUID();
            dataModelManager.setIdt(new Date());
            dataModelManager.setId(id);
            dataModelManager.setCreateId(userId);
            dataModelManager.setPublicFlag(1);
            try {
                if(StrUtils.isBlank(dataModelManager.getModelCode())){
                    dataModelManager.setModelCode(StrUtils.isBlank(dataModelManager.getTableNames()) ? "_" + RandomStringUtil.getRandomCode(3,2) : (dataModelManager.getTableNames()[0] + "_" + RandomStringUtil.getRandomCode(3,2)));
                }
                dataModelManagerMapper.insertSelective(dataModelManager);
                //新增模型字段
                if(modelFields != null && !modelFields.isEmpty()){
                    try {
                        modelFieldMapper.insertFieldByList(modelFields,id);
                    } catch (Exception e) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        e.printStackTrace();
                        logger.info("批量插入字段失败!");
                        return Result.Error().getJson();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                logger.info("新增数据模型{}失败",dataModelManager.toString());
                return Result.Error().getJson();
            }
        }
        if(publicFlag == 3){
            //需要生成草稿
            String copyId = StrUtils.randomUUID();
            dataModelManager.setId(copyId);
            dataModelManager.setPublicFlag(publicFlag);
            dataModelManager.setIdt(new Date());
            dataModelManager.setCreateId(userId);
            dataModelManager.setUdt(null);
            dataModelManager.setUpdateId(null);
            try {
                dataModelManagerMapper.insertSelective(dataModelManager);
                //新增草稿字段
                modelFieldMapper.insertFieldByList(modelFields,dataModelManager.getId());
            } catch (Exception e) {
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                logger.error("模型草稿新增失败!");
                return Result.Error().getJson();
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,null,null).getJson();
    }

    @Override
    public String findDataModelField(ModelFieldModel modelField) {


        if(StrUtils.isBlank(modelField.getModelId())){
            return Result.getException("当前未选中记录!").getJson();
        }

        ModelFieldExample ex = new ModelFieldExample();
        ModelFieldExample.Criteria criteria = ex.createCriteria();
        if(!StrUtils.isBlank(modelField.getName())){
            criteria.andNameLike("%" + modelField.getName() + "%");
        }
        if(!StrUtils.isBlank(modelField.getCode())){
            criteria.andCodeEqualTo(modelField.getCode());
        }
        if(!StrUtils.isBlank(modelField.getFieldDescribe())){
            criteria.andFieldDescribeLike("%" + modelField.getFieldDescribe() + "%");
        }
        if(!StrUtils.isBlank(modelField.getNcdTerm())){
            criteria.andNcdEqualTo(modelField.getNcdTerm());
        }
        if(!StrUtils.isBlank(modelField.getNcTerm())){
            criteria.andNcEqualTo(modelField.getNcTerm());
        }
        criteria.andModelIdEqualTo(modelField.getModelId());
        criteria.andStatusEqualTo(ConstantClazz.MDM_DATA_MODEL_STATUS_DELETE_FLAG_FLASE);
        List<ModelField> modelFields = null;
        try {
            modelFields = modelFieldMapper.selectByExample(ex);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("根据模型id:{}查询所含字段失败!",modelField.getModelId());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,modelFields,null).getJson();
    }

    @Override
    public String deleteDataModelField(ModelField modelField) {

        String id = modelField.getId();
        if(StrUtils.isBlank(modelField.getId())){
            return Result.getException("当前未选中记录!").getJson();
        }
        List<String> collect = null;
        try {
            collect = Arrays.stream(StringUtils.split(id, ",")).map(s1 -> s1.trim()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("批量删除的字段id:{}转换为集合失败!",id);
            return Result.Error().getJson();
        }
        //查询当前包含的字段是否大于删除的字段(不能删除全部字段)
        String fieldId = collect.get(0);
        //根据字段查询模型有多少个字段
        int count = 0;
        try {
            count = modelFieldMapper.countFieldByFieldId(fieldId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据字段id:{}查询模型字段个数失败!",fieldId);
        }
        if(collect.size() >= count){
            return Result.getException("不能删除全部字段!").getJson();
        }
        try {
            modelFieldMapper.deleteFieldByIds(collect);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("模型字段id:{}批量删除失败",id);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.DEL_SUCCESS,null,null).getJson();
    }

    @Override
    public String updateDataModelField(ModelField modelField) {

        if(StrUtils.isBlank(modelField.getId())){
            return Result.getException("当前未选中记录!").getJson();
        }
        try {
            modelFieldMapper.updateByPrimaryKeySelective(modelField);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("更改模型字段id:{}失败",modelField.getId());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
    }

    @Override
    public String addDataModelField(ModelField modelField) {

        if(StrUtils.isBlank(modelField)){
            return Result.getException("参数有误!").getJson();
        }

        if(StrUtils.isBlank(modelField.getModelId())){
            return Result.getException("当前未选中记录!").getJson();
        }
        String id = StrUtils.randomUUID();
        modelField.setId(id);
        modelField.setStatus(ConstantClazz.MDM_DATA_MODEL_STATUS_DELETE_FLAG_FLASE);
        try {
            modelFieldMapper.insertSelective(modelField);
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("模板ID:{}新增参数失败",modelField.getModelId());
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,id,null).getJson();
    }

    @Override
    public String getMDMDataListByPage(MasterDataManager masterDataManager) {
        long start = System.currentTimeMillis();
        Pager pager = masterDataManager.getPager();
        MasterDataManagerExample ex = new MasterDataManagerExample();
        ex.setPage(pager);
        ex.setOrderByClause(" IDT DESC ");
        MasterDataManagerExample.Criteria criteria = ex.createCriteria();
        if(!StrUtils.isBlank(masterDataManager.getName())){
            criteria.andNameLike("%" + masterDataManager.getName() + "%");
        }
        if(!StrUtils.isBlank(masterDataManager.getCode())){
            criteria.andCodeEqualTo(masterDataManager.getCode());
        }
        if(!StrUtils.isBlank(masterDataManager.getMasterDescribe())){
            criteria.andMasterDescribeLike("%" + masterDataManager.getMasterDescribe() + "%");
        }
        if(!StrUtils.isBlank(masterDataManager.getModelId())){
            criteria.andModelIdEqualTo(masterDataManager.getModelId());
        }
        if(!StrUtils.isBlank(masterDataManager.getRc1())){
            criteria.andRc1EqualTo(masterDataManager.getRc1());
        }
        if(!StrUtils.isBlank(masterDataManager.getTermAll())){
            criteria.andTermAll(masterDataManager.getTermAll());
        }
        criteria.andStatusEqualTo(1);
        List<MasterDataManager> list = null;
        try {
            list = masterDataManagerMapper.selectByExampleWithBLOBs(ex);
            if(list != null && !list.isEmpty()){
                List<CompletableFuture<Map<String, Integer>>> futureList = new ArrayList<>();
                Map<String, Integer> resultMap = new HashMap<>();
                for (MasterDataManager m : list){

                    //if(dataModelManager != null){
                        //String modelCode = dataModelManager.getModelCode();
                        //查询当前表的数据条数
                        int i = 0;
                        CompletableFuture<Map<String, Integer>> mapCompletableFuture = CompletableFuture.supplyAsync(() -> {
                            String modelId = m.getModelId();
                            DataModelManager dataModelManager = dataModelManagerMapper.selectByPrimaryKey(modelId);
                            if(dataModelManager != null){
                                return dataModelManager.getModelCode();
                            }
                            return null;
                        }, ThreadPoolUtils.getInstance().createExecutor()).thenApply(code -> {
                            Map<String, Integer> map = new HashMap<>();
                            if(StrUtils.isBlank(code)){
                            }else{
                                int ii = 0;
                                ii = dataModelManagerMapper.selectNumByTableName(code);
                                map.put(m.getId(), ii);
                            }
                            return map;
                        });
                        futureList.add(mapCompletableFuture);

                        /*try {
                            i = dataModelManagerMapper.selectNumByTableName(modelCode);
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.info("根据表名:{}查询数据条数失败!",modelCode);
                            //return Result.Error().getJson();
                        }
                        m.setDataNum(i);*/
                    //}
                }
                CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(futureList.toArray((new CompletableFuture[futureList.size()])));
                CompletableFuture<Map<String, Integer>> mapCompletableFuture = voidCompletableFuture.thenApply(v -> {
                    return futureList.stream().map(a -> a.join()).map(Map::entrySet).flatMap(Set::stream).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (m, a) -> a));
                });
                try {
                    resultMap = mapCompletableFuture.get();
                    Map<String, Integer> resultMapCopy = resultMap;
                    list.stream().forEach(v -> v.setDataNum(resultMapCopy.containsKey(v.getId()) ? resultMapCopy.get(v.getId()) : 0));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            pager.setPagerInfo(list,masterDataManagerMapper.countByExample(ex));
            long end = System.currentTimeMillis();
            System.err.println("查询耗时:" + (end - start));
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("查询主数据管理列表失败!");
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String addMDMData(MasterDataManager masterDataManager) {
        if(StrUtils.isBlank(masterDataManager.getModelId())){
            return Result.getException("模板不能为空!").getJson();
        }

        if(StrUtils.isBlank(masterDataManager.getMasterSql())){
            return Result.getException("采集语句不能为空!").getJson();
        }

        String modelId = masterDataManager.getModelId();
        DataModelManager dataModelManager = null;
        String database = null;
        try {
            //根据modelId查询库名

            List<ModelField> fieldListByModelId = modelFieldMapper.getFieldListByModelId(modelId);
            if(fieldListByModelId != null && !fieldListByModelId.isEmpty()){
                database = fieldListByModelId.get(0).getDatabaseName();
            }
            dataModelManager = dataModelManagerMapper.selectByPrimaryKey(modelId);
            masterDataManager.setMasterDescribe(dataModelManager.getModelDescribe());
            masterDataManager.setName(dataModelManager.getModelName());
            masterDataManager.setRc1(dataModelManager.getModelTypeId());
            masterDataManager.setIdt(new Date());
            String id = StrUtils.randomUUID();
            try {
                masterDataManager.setId(id);
                masterDataManagerMapper.insertSelective(masterDataManager);
                //调用创建表方法
                createTable(modelId, database,dataModelManager.getModelCode(), masterDataManager.getMasterSql());
                /*String databaseName = database;
                DataModelManager dataModelManager1 = dataModelManager;
                CompletableFuture.supplyAsync(() -> {
                    createTable(modelId, databaseName,dataModelManager1.getModelCode(), masterDataManager.getMasterSql());
                    return null;
                });*/
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("根据模型id:{}创建主数据失败!",modelId);
                //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                masterDataManagerMapper.deleteByPrimaryKey(id);
                return Result.Error().getJson();
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据模型id:{}获取模型信息失败!",modelId);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,null,null).getJson();
    }

    @Override
    public String editMDMData(MasterDataManager masterDataManager){
        if(StrUtils.isBlank(masterDataManager.getId())){
            return Result.getException("当前未选中记录!").getJson();
        }
        String userId = ApplicationContextHolder.currentUser().getId();
        masterDataManager.setUdt(new Date());
        masterDataManager.setUpdateId(userId);
        try {
            masterDataManagerMapper.updateByPrimaryKeySelective(masterDataManager);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("修改主数据失败!");
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
    }

    @Override
    public String getDatabaseByDB() {

        String prefix = "big";
        List<String> list = null;
        try {
            list = masterDataManagerMapper.getDatabaseByDB(prefix);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询数据源失败!");
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,null).getJson();
    }

    @Override
    public String getTableDataByDatabaseNameAndTableName(String database, String table, Map<String, Object> map) {

        if(StrUtils.isBlank(database) || StrUtils.isBlank(table)){
            return Result.getException("未选中记录!").getJson();
        }
        //查询该表的所有字段
        List<Map<String, Object>> fieldList = new ArrayList<>();
        Map<String, Object> resultMap = new HashMap<>();
        fieldList = dataModelManagerMapper.getFieldByTableName(database,table);
        Map<Object, Object> fieldMap = new LinkedHashMap<>();
        if(fieldList != null && !fieldList.isEmpty()){
            for(Map<String, Object> m : fieldList){
                fieldMap.put(m.get("name"),m.get("fieldDescribe"));
            }
        }
        Integer rows = 10;
        Integer page = 1;
        if(!map.isEmpty()){
            rows = (Integer)map.get("rows");
            page = (Integer)map.get("page");
                /*判断参数是否在里面*/
            //TODO
            for (Map.Entry<String, Object> m : map.entrySet()) {
                System.out.println("key:" + m.getKey() + " value:" + m.getValue());
            }
        }
        Pager pager = new Pager(page,rows);
        List<Map<String, Object>> list = null;
        String tableCopy = database + "." + table;
        try {
            Iterator<String> iter = map.keySet().iterator();
            while(iter.hasNext()){
                String key = iter.next();
                if("rows".equals(key) || "page".equals(key)){
                    iter.remove();
                }
            }
            list = masterDataManagerMapper.findMDMDate(tableCopy,map,pager);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据表明:{}查询数据失败!",table);
            return Result.Error().getJson();
        }
        try {
            Pager pagers = null;
            int count = masterDataManagerMapper.countMDMData(tableCopy,map);
            //count = masterDataManagerMapper.findMDMDate(tableCopy,map,pagers).size();
            pager.setPagerInfo(list,count);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据表明:{}查询数据失败!",table);
            return Result.Error().getJson();
        }
        resultMap.put("title",fieldMap);
        resultMap.put("list",pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultMap,null).getJson();
    }


    public int createTable(String modelId, String database, String modelCode, String sql){
        if(StrUtils.isBlank(modelId) ||StrUtils.isBlank(modelCode) || StrUtils.isBlank(sql)){
            throw new RuntimeException();
        }

        //根据模型ID查询字段列表

        ModelFieldExample ex = new ModelFieldExample();
        ModelFieldExample.Criteria criteria = ex.createCriteria();
        criteria.andModelIdEqualTo(modelId);
        criteria.andStatusEqualTo(ConstantClazz.MDM_DATA_MODEL_STATUS_DELETE_FLAG_FLASE);
        List<ModelField> modelFields = null;
        try {
            modelFields = modelFieldMapper.selectByExample(ex);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据模型id:{}查询字段列表失败!",modelId);
            throw new RuntimeException();
        }
        //判断sql是否违规
        if(modelFields.isEmpty()){

        }
        List<String> nameList = modelFields.stream().map(m -> m.getName()).collect(Collectors.toList());
        List<String> tableNames = modelFields.stream().map(m -> m.getTableName()).collect(Collectors.toList());
        SQLException e1 = new SQLException();
        if(StrUtils.isCommandIllSql(sql)){
            throw new BadSqlGrammarException("","", e1);
        }
        sql = sql.toLowerCase();
        String sqlBak = sql.substring(sql.indexOf("select")+"select".length(), sql.indexOf("from"));
        if(!StrUtils.isBlank(sqlBak)){
            String[] split = sqlBak.split(",");
            for(String str : split){
                if(!nameList.contains(str.trim().toLowerCase()) && !nameList.contains(str.trim().toUpperCase())){
                    throw new BadSqlGrammarException("","", e1);
                }
            }
        }

        //根据字段创建表结构关系

        /*for(ModelField m : modelFields){
            if(StrUtils.isBlank(m.getLength())){
                m.setType(m.getType());
            }else{
                m.setType(m.getType() + "(" + StrUtils.isBlank(m.getLength()) + ")" );
            }
        }*/
        try {
            dataModelManagerMapper.createTable(modelFields,modelCode);
            //查询sql执行的结果
            if(tableNames != null && !tableNames.isEmpty()){
                String table = null;
                table = tableNames.get(0);
                table = database + "." + table;
                masterDataManagerMapper.insertDataByTableName(modelFields,modelCode,table);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("模型code:{}创建表失败!",modelCode);
            //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new ArrayIndexOutOfBoundsException();
        }
        return 0;

    }

    @Override
    public String deleteMDMDate(String id) {

        if(StrUtils.isBlank(id)){
            return Result.getException("当前未选中记录!").getJson();
        }
        List<String> idList = new ArrayList<>();
        try {
            idList = Arrays.stream(StringUtils.split(id, ",")).map(s1 -> s1.trim()).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("批量删除的字段id:{}转换为集合失败!",id);
            return Result.Error().getJson();
        }
        //根据主数据id查询模板code(表名)集合
        List<String> tableNameList = new ArrayList<>();
        try {
            List<String> modeIdList = new ArrayList<>();
            //根据主数据id集合查询模型id集合
            modeIdList = dataModelManagerMapper.getModeIdByMasterIdList(idList);
            tableNameList = dataModelManagerMapper.getModelCodeListByMasterIdList(modeIdList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据主数据id集合查询模板失败!",id);
            return Result.Error().getJson();
        }
        //删除主数据
        try {
            masterDataManagerMapper.deleteMasterDataByIdList(idList);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据主数据id集合:{}删除主数据失败!",id);
            return Result.Error().getJson();
        }
        //批量删除表
        try {
            masterDataManagerMapper.deleteTable(tableNameList);
        } catch (BadSqlGrammarException e1){
            e1.printStackTrace();
            logger.error("当前表名:{}不存在",tableNameList);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            logger.error("根据主数据id集合:{}删除表失败!",id);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.DEL_SUCCESS,null,null).getJson();
    }

    @Override
    public String getDataModelDetails(String id) {

        if(StrUtils.isBlank(id)){
            return Result.getException("当前未选中记录!").getJson();
        }
        DataModelManager dataModelManager = null;
        try {
            dataModelManager = dataModelManagerMapper.selectByPrimaryKey(id);
            //根据modelid查询表名
            String[] tableNames = modelFieldMapper.getTableNameByModelId(id);
            dataModelManager.setTableNames(tableNames);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据模型ID:{}查询详情失败!",id);
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,dataModelManager,null).getJson();
    }

    @Override
    public String getTableNameList(String database) {

        String prefix = ConstantClazz.TABLE_PREFIX;
        if(StrUtils.isBlank(database)){
            return Result.getException("当前未选中记录!").getJson();
        }
        List<String> list = null;
        try {
            list = dataModelManagerMapper.getTableNameList(prefix,database);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("查询表名称失败!");
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,null).getJson();
    }

    @Override
    public String getFieldByTableName(String database, String name) {

        if(StrUtils.isBlank(name)){
            return Result.getException("当前未选中记录!").getJson();
        }

        if(StrUtils.isBlank(database)){
            return Result.getException("当前未选中记录!").getJson();
        }
        List<Map<String, Object>> list = null;
        try {
            list = dataModelManagerMapper.getFieldByTableName(database, name);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据数据库名称:{}和表名称:{}查询字段失败!",database,name);
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,list,null).getJson();
    }

    @Override
    public String getDataModelDraft() {

        MDMDataModelModels mdmDataModelModels = null;
        String userId = ApplicationContextHolder.currentUser().getId();
        DataModelManagerExample ex = new DataModelManagerExample();
        DataModelManagerExample.Criteria criteria = ex.createCriteria();
        criteria.andCreateIdEqualTo(userId);
        criteria.andPublicFlagEqualTo(3);
        criteria.andStatusEqualTo(1);
        try {
            List<DataModelManager> dataModelManagers = dataModelManagerMapper.selectByExample(ex);
            if(dataModelManagers != null && !dataModelManagers.isEmpty()){
                DataModelManager dataModelManager = dataModelManagers.get(0);
                String modelId = dataModelManager.getId();
                //根据模型id查询字段
                try {
                    List<ModelField> fields = modelFieldMapper.getFieldListByModelId(modelId);
                    mdmDataModelModels = new MDMDataModelModels();
                    mdmDataModelModels.setDataModelManager(dataModelManager);
                    mdmDataModelModels.setModelFields(fields);
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error("草稿查询根据模型ID:{}查询字段失败!",modelId);
                    return Result.Error().getJson();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户:{}查询数据模型给草稿失败!",userId);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,mdmDataModelModels,null).getJson();
    }

    @Override
    public String getDataModelCanUseFieldByModelId(String modelId) {

        if(StrUtils.isBlank(modelId)){
            return Result.getException("当前未选中记录!").getJson();
        }

        //查询当前模型已用字段和表名
        List<ModelField> fieldListByModelId = null;
        try {
            fieldListByModelId = modelFieldMapper.getFieldListByModelId(modelId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据模型ID:{}查询已使用的字段失败!",modelId);
            return Result.getException("查询失败!").getJson();
        }
        List<Map<String, Object>> list = null;
        if(fieldListByModelId != null && !fieldListByModelId.isEmpty()){
            //已用字段集合
            List<String> nameList = fieldListByModelId.stream().map(a -> a.getName()).collect(Collectors.toList());
            String tableName = fieldListByModelId.get(0).getTableName();
            String databaseName = null;
            databaseName = fieldListByModelId.get(0).getDatabaseName();
            //根据tableName查询总共字段(去除已使用字段)
            try {

                list = dataModelManagerMapper.getFieldByTableNameAndUse(databaseName,tableName,nameList);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("根据modelId:{}查询未使用的表字段失败!",modelId);
                return Result.getException("查询失败!").getJson();
            }

        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,null).getJson();
    }

    @Override
    public String findMDMDate(String id, Map<String, Object> map) {

        if(StrUtils.isBlank(id)){
            return Result.getException("当前未选中记录!").getJson();
        }

        //根据模型id查询模型code
        DataModelManager dataModelManager = dataModelManagerMapper.selectByPrimaryKey(id);
        String modelCode = dataModelManager.getModelCode();
        Map<String, Object> resultMap = new HashMap<>();
        List<Map<String, Object>> list = new ArrayList<>();
        String database = null;
        //根据模型ID查询数据库和表
        /*List<ModelField> fieldListByModelId = modelFieldMapper.getFieldListByModelId(id);
        if(fieldListByModelId != null && !fieldListByModelId.isEmpty()){
            ModelField modelField = fieldListByModelId.get(0);
            //database = modelField.getDatabaseName();
        }*/
        try {
            //查询该表的所有字段
            List<Map<String, Object>> fieldList = new ArrayList<>();
            fieldList = dataModelManagerMapper.getFieldByTableName(database,modelCode);
            Map<Object, Object> fieldMap = new LinkedHashMap<>();
            if(fieldList != null && !fieldList.isEmpty()){
                for(Map<String, Object> m : fieldList){
                    fieldMap.put(m.get("name"),m.get("fieldDescribe"));
                }
            }
            Integer rows = 10;
            Integer page = 1;
            if(!map.isEmpty()){
                rows = (Integer)map.get("rows");
                page = (Integer)map.get("page");
                /*判断参数是否在里面*/
                //TODO
                /*for (Map.Entry<String, Object> m : map.entrySet()) {
                    System.out.println("key:" + m.getKey() + " value:" + m.getValue());
                }*/
            }
            Pager pager = new Pager(page,rows);
            try {
                Iterator<String> iter = map.keySet().iterator();
                while(iter.hasNext()){
                    String key = iter.next();
                    if("rows".equals(key) || "page".equals(key)){
                        iter.remove();
                    }
                }
                list = masterDataManagerMapper.findMDMDate(modelCode,map,pager);

            } catch (Exception e) {
                e.printStackTrace();
                logger.error("根据表明:{}查询数据失败!",modelCode);
                return Result.Error().getJson();
            }
            try {
                //Pager pagers = null;
                int count = masterDataManagerMapper.countMDMData(modelCode,map);
                //int count = masterDataManagerMapper.findMDMDate(modelCode,map,pagers).size();
                pager.setPagerInfo(list,count);
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("根据表明:{}查询数据失败!",modelCode);
                return Result.Error().getJson();
            }
            resultMap.put("title",fieldMap);
            resultMap.put("list",pager);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据表明:{}查询数据失败!",modelCode);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultMap,null).getJson();
    }

    @Override
    public String findMDMField(String id) {

        if(StrUtils.isBlank(id)){
            return Result.getException("当前未选中记录!").getJson();
        }
        //根据模型id查询模型code
        DataModelManager dataModelManager = dataModelManagerMapper.selectByPrimaryKey(id);
        String modelCode = dataModelManager.getModelCode();
        List<Map<String, Object>> list = null;
        try {
            list = dataModelManagerMapper.getFieldByTableName("mdm_db",modelCode);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("根据表名:{}查询字段失败!",modelCode);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,null).getJson();
    }
}
