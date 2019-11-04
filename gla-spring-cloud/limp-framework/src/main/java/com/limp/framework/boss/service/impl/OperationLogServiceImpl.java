package com.limp.framework.boss.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.limp.framework.boss.domain.OperationLog;
import com.limp.framework.boss.domain.OperationLogExample;
import com.limp.framework.boss.domain.OperationSetting;
import com.limp.framework.boss.domain.OperationSettingExample;
import com.limp.framework.boss.mapper.oracle.OperationLogMapper;
import com.limp.framework.boss.mapper.oracle.OperationSettingMapper;
import com.limp.framework.boss.service.OperationLogService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.DateUtils;
import com.limp.framework.utils.JavaBeanConverMapUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/19 10:54
 * @Description:
 */
@Service
public class OperationLogServiceImpl implements OperationLogService{

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Autowired
    private OperationSettingMapper operationSettingMapper;

    @Autowired
    private OperationLogService operationLogService;

    @Override
    public String getOperationList(OperationLog operationLog, Pager pager) {

        List<OperationLog> list = new ArrayList<>();
        OperationLogExample ex = new OperationLogExample();
        ex.setPage(pager);
        OperationLogExample.Criteria criteria = ex.createCriteria();

        if(operationLog.getOptType() != null){
            criteria.andOptTypeEqualTo(operationLog.getOptType());
        }

        if(operationLog.getOptTime() != null){
            criteria.andOptTimeBetween(operationLog.getOptTime(), DateUtils.getEndTime(operationLog.getOptTime()));
        }

        if(!StrUtils.isBlank(operationLog.getLpsort())){
            ex.setOrderByClause(operationLog.getLpsort());
        }else{
            ex.setOrderByClause("OPT_TIME DESC");
        }
        try{
            list = operationLogMapper.selectByExample(ex);
            pager.setPagerInfo(list,operationLogMapper.countByExample(ex));
        }catch(Exception e){
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String getOperationById(String id) {
        try{
            OperationLog operationLog = operationLogMapper.selectByPrimaryKey(id);
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,operationLog,null).getJson();
        }catch(Exception e){
            return Result.Error().getJson();
        }
    }

    @Override
    public void getRunable(Map<String, Object> mapParams, Map<String, Object> objectMap,String tableName, String type){

        //ThreadPoolUtils.ThreadPool instance = ThreadPoolUtils.getInstance();
        ThreadPoolUtils.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                try{
                    operation(mapParams,objectMap,tableName,type);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     *
     * 功能描述: 解析修改、新增、删除关联的监控字段
     *
     * @param: [stringObjectMap, type]
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/10/24 21:29
     */

    @Override
    public Map<String, Object> converMap(Map<String, Object> stringObjectMap,String type){
        OperationSetting operationSetting = new OperationSetting();
        String deptUpdate = getOperation(type);
        JSONArray objects = JSONArray.parseArray(deptUpdate);

        if(!StrUtils.isBlank(deptUpdate)){
            Iterator<Map.Entry<String, Object>> it = stringObjectMap.entrySet().iterator();

            while (it.hasNext()){
                Map.Entry<String, Object> its = it.next();
                for(int i=0;i<objects.size();i++){
                    Map<String, Object> beanMap = JSONObject.parseObject(objects.getString(i));
                    if(i+1 == objects.size()){
                        if(beanMap.get("name").toString().equals(its.getKey())){
                            break;
                        }else{
                            it.remove();
                        }
                    }else{
                        if(beanMap.get("name").toString().equals(its.getKey())){
                            break;
                        }
                    }
                }
            }
        }
        return stringObjectMap;
    }

    @Override
    public void insertOperationLog(Object beanAfter, Object beanBefor,String tableName, String type) {
        Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(beanAfter, false);
        Map<String, Object> objectMap = null;
        stringObjectMap = this.converMap(stringObjectMap, tableName + StrUtils.toUpperCaseFirstOne(type));
        if("add".equals(type) || "delete".equals(type)){
        }else{
            objectMap = new HashMap<>();
            objectMap = JavaBeanConverMapUtils.bean2Map(beanBefor,false);
        }
        operationLogService.getRunable(stringObjectMap,objectMap,tableName,type);
    }

    public void operation(Map<String, Object> mapParams, Map<String, Object> objectMap,String tableName, String type) {

        String businessName = "";
        List<Map<String, Object>> maps = new ArrayList<>();
        if(mapParams != null && !mapParams.isEmpty()){
            String deptUpdate = operationLogService.getOperation(tableName+StrUtils.toUpperCaseFirstOne(type));
            JSONArray object = JSONArray.parseArray(deptUpdate);
            if(type.equalsIgnoreCase("update")){
                //查询监控字段
                for(Map.Entry<String, Object> entry : mapParams.entrySet()){
                    if(objectMap.containsKey(entry.getKey())){
                        if(!entry.getValue().equals(objectMap.get(entry.getKey()))){
                            String desc = "";
                            if(object != null && !object.isEmpty()){
                                for(int i=0;i<object.size();i++){
                                    String str = object.getString(i);
                                    Map<String, Object> beanMap = JSONObject.parseObject(str);
                                    if(beanMap.get("name").equals(entry.getKey())){
                                        desc = beanMap.get("desc").toString();
                                    }
                                }
                            }
                            System.err.println("不相等的key:" + entry.getKey());
                            System.err.println("不相等的value:" + entry.getValue());
                            Map<String, Object> afterMap = new HashMap<>();
                            //修改保存数据
                            afterMap.put("beforeValue",objectMap.get(entry.getKey()));
                            afterMap.put("afterValue",entry.getValue());
                            afterMap.put("name",entry.getKey());
                            afterMap.put("desc",desc);
                            afterMap.put("createId",null);
                            maps.add(afterMap);
                        }else{
                            continue;
                        }
                        businessName = tableName + "更新";
                    }else{
                        //指定对象不包含该键值(抛什么待定)
                        break;
                    }
                }
            }else if(type.equalsIgnoreCase("add")){
                maps = dev(mapParams,object,type);
                businessName = tableName + "新增";
            }else if(type.equalsIgnoreCase("delete")){
                maps = dev(mapParams,object,type);
                businessName = tableName + "删除";
            }
        }else{
            //修改的参数为空，异常是否抛出待定
        }
        //保存数据库操作
        if(maps != null && !maps.isEmpty()){

            OperationLog operationLog = new OperationLog();
            operationLog.setId(StrUtils.randomUUID());
            operationLog.setPojoKey(tableName);
            operationLog.setOptTime(new Date());
            if("update".equalsIgnoreCase(type)){
                operationLog.setOptType(3);
            }else if("add".equalsIgnoreCase(type)){
                operationLog.setOptType(1);
            }else if("delete".equalsIgnoreCase(type)){
                operationLog.setOptType(2);
            }
            operationLog.setContent(JSONObject.toJSONString(maps,filter));
            operationLog.setBusinessName(businessName);
            operationLog.setState(1);
            operationLogMapper.insertSelective(operationLog);
        }
    }

    private ValueFilter filter = new ValueFilter() {
        @Override
        public Object process(Object obj, String s, Object v) {
            if(v==null){
                return "";
            }
            return v;
        }
    };

    public List<Map<String, Object>> dev(Map<String, Object> mapParams,JSONArray object,String type){
        List<Map<String, Object>> maps = new ArrayList<>();
        for(Map.Entry<String, Object> entry : mapParams.entrySet()){
            String desc = "";
            if(object != null && !object.isEmpty()){
                for(int i=0;i<object.size();i++){
                    String str = object.getString(i);
                    Map<String, Object> beanMap = JSONObject.parseObject(str);
                    if(beanMap.get("name").equals(entry.getKey())){
                        desc = beanMap.get("desc").toString();
                    }
                }
            }
            System.err.println("不相等的key:" + entry.getKey());
            System.err.println("不相等的value:" + entry.getValue());
            Map<String, Object> afterMap = new HashMap<>();
            //修改保存数据
            /*if(type.equalsIgnoreCase("update")){
                afterMap
            }*/
            afterMap.put("afterValue",entry.getValue());
            afterMap.put("name",entry.getKey());
            afterMap.put("desc",desc);
            afterMap.put("createId",null);
            maps.add(afterMap);
        }
        return maps;
    }

    @Override
    public String getOperation(String pojoName){
        String str = "";
        List<OperationSetting> list = new ArrayList<>();
        OperationSetting operationSetting = new OperationSetting();
        OperationSettingExample ex = new OperationSettingExample();
        OperationSettingExample.Criteria criteria = ex.createCriteria();
        criteria.andPojoKeyEqualTo(pojoName);
        criteria.andStateEqualTo(1);
        try{
            list = operationSettingMapper.selectByExample(ex);
            if(list != null && !list.isEmpty()){
                operationSetting = list.get(0);
                str = operationSetting.getFieldTemplate();
            }
        }catch (Exception e){
            return null;
        }
        return str;
    }

    @Override
    public String getOperationSettingList(OperationSetting operationSetting, Pager pager) {
        List<OperationSetting> list = new ArrayList<>();
        OperationSettingExample ex = new OperationSettingExample();
        ex.setPage(pager);
        OperationSettingExample.Criteria criteria = ex.createCriteria();

        if(operationSetting.getBussinessName() != null){
            criteria.andBussinessNameLike("%" + operationSetting.getBussinessName() + "%" );
        }

        if(operationSetting.getLogType() != null){
            criteria.andLogTypeEqualTo(operationSetting.getLogType());
        }
        criteria.andStateNotEqualTo(-1);
        if(!StrUtils.isBlank(operationSetting.getLpsort())){
            ex.setOrderByClause(operationSetting.getLpsort());
        }else{
            ex.setOrderByClause("IDT DESC");
        }
        try{
            list = operationSettingMapper.selectByExample(ex);
            pager.setPagerInfo(list,operationSettingMapper.countByExample(ex));
        }catch(Exception e){
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String saveOperationSetting(OperationSetting operationSetting) {
        if(operationSetting != null){
            if(!StrUtils.isBlank(operationSetting.getId())){
                //编辑
                try{
                    OperationSettingExample ex = new OperationSettingExample();
                    OperationSettingExample.Criteria criteria = ex.createCriteria();
                    criteria.andIdEqualTo(operationSetting.getId());
                    operationSetting.setUpdateAccount("111111");
                    operationSetting.setUdt(new Date());
                    operationSettingMapper.updateByExampleSelective(operationSetting,ex);
                }catch (Exception e){
                    return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.UPDATE_ERROR,null,null).getJson();
                }
                return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
            }else{
                //新增
                String id = StrUtils.randomUUID();
                operationSetting.setId(id);
                operationSetting.setIdt(new Date());
                //设置创建人
                operationSetting.setCreateAccount("11111");
                try{
                    operationSettingMapper.insertSelective(operationSetting);
                }catch (Exception e){
                    return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.ADD_ERROR,null,null).getJson();
                }
                return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.ADD_SUCCESS,null,null).getJson();
            }
        }
        return null;
    }

    @Override
    public String deleteOperationSetting(String ids) {

        if(!StrUtils.isBlank(ids)){
            String[] split = ids.split(Constant.DHAO);
            try{
                operationSettingMapper.deleteOperationSetting(split,new Date());
                return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.DEL_SUCCESS,null,null).getJson();
            }catch(Exception e){
                return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.DEL_ERROR,null,null).getJson();
            }
        }
        return null;
    }


}
