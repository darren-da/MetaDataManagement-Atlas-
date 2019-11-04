package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.gla.datacenter.domain.OperationLog;
import com.gla.datacenter.domain.OperationSetting;
import com.gla.datacenter.domain.OperationSettingExample;
import com.gla.datacenter.mapper.mysql.OperationLogMapper;
import com.gla.datacenter.mapper.mysql.OperationSettingMapper;
import com.gla.datacenter.service.OperationLogService;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/30 14:53
 * @Description:
 */
@Service
public class OperationLogServiceImpl implements OperationLogService{

    @Autowired
    private OperationSettingMapper operationSettingMapper;

    @Autowired
    private OperationLogMapper operationLogMapper;

    @Override
    public String addOperationLogs(Map<String, Object> mapParams, Map<String, Object> objectMap, String type, String tableName) {

        ThreadPoolUtils.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                String result = "";
                try{
                    result = addOperationLog(mapParams,objectMap,type,tableName);
                    System.err.println(result);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        return null;
    }


    public String addOperationLog(Map<String, Object> mapParams, Map<String, Object> objectMap, String type, String tableName){
        String businessName = "";
        List<Map<String, Object>> maps = new ArrayList<>();
        if(mapParams != null && !mapParams.isEmpty()){

            mapParams = converMap(mapParams,tableName+ StrUtils.toUpperCaseFirstOne(type));
            //根据pojoName获取监控字段
            String deptUpdate = getOperation(tableName+ StrUtils.toUpperCaseFirstOne(type));
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
            System.err.println("---------------------------------");
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
        return null;
    }

    /**
     *
     * 功能描述: 根据pojoName获取监控字段
     *
     * @param: [pojoName]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/1 18:36
     */
    
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
            }else{
                return null;
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
}
