
package com.limp.framework.boss.service.impl;

import com.alibaba.fastjson.serializer.ValueFilter;
import com.limp.framework.boss.domain.Dept;
import com.limp.framework.boss.domain.DeptExample;
import com.limp.framework.boss.mapper.oracle.DeptMapper;
import com.limp.framework.boss.service.DeptService;
import com.limp.framework.boss.service.OperationLogService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.JavaBeanConverMapUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;


/**
 *
 * 功能描述: 元数据管理-单位管理实现
 *
 * @param:
 * @return:
 * @auther: zhangbo
 * @date: 2018/10/15 11:43
 */

@Service
@Transactional
public class DeptServiceImpl implements DeptService {

    private Logger log = LoggerFactory.getLogger(DeptServiceImpl.class);

/**
     * 注入mapper
     */

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private OperationLogService operationLogService;

    @Override
    public boolean saveDept(Dept entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        String parentId = entry.getParentId();
        DeptExample ex = new DeptExample();
        DeptExample.Criteria criteria = ex.createCriteria();
        criteria.andCodeEqualTo(parentId);
        criteria.andStateEqualTo(1);
        List<Dept> depts = deptMapper.selectByExample(ex);
        if(depts != null && !depts.isEmpty()){
            entry.setLv(depts.get(0).getLv() + 1);
        }
        log.debug(TextUtils.format("新增单位{0}", entry.getId()));
        try {
            boolean flag = deptMapper.insertSelective(entry) == 1 ? true : false;
            if(flag){
                operationLogService.insertOperationLog(entry,null,"Dept","add");
            }
            return flag;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.debug(TextUtils.format("新增单位失败"));
            return false;
        }
    }

    @Override
    public Dept getDept(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据单位Id{0},获取实体类信息",id));
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateDept(Dept entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        Dept dept = deptMapper.selectByPrimaryKey(entry.getId());
        log.debug(TextUtils.format("根据Id{0},更新实体类信息",entry.getId()));
        boolean flag = deptMapper.updateByPrimaryKeySelective(entry)==1?true:false;

        //获取操作的当前对象监控信息
        if(flag){
            try {
                Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(entry,true);
                stringObjectMap = operationLogService.converMap(stringObjectMap, "DeptUpdate");
                Map<String, Object> deptMap = JavaBeanConverMapUtils.bean2Map(dept,false);
                try {
                    operationLogService.getRunable(stringObjectMap,deptMap,"Dept","update");
                }catch (Exception e){
                    log.debug(TextUtils.format( "方法{0}调用插入日志失败","updateDept"));
                    return false;
                }
            }catch (Exception e){
                log.debug(TextUtils.format( "{Dept}转换map失败","Dept"));
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return flag;

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

    @Override
    public String deleteDept(String[] ids) {
        String result = "";
        if(ids.length > 0){
            for(String id : ids){
                log.debug(TextUtils.format("根据Id{0},删除实体单位信息", id));
                Dept dept = deptMapper.selectByPrimaryKey(id);
                //如果含有下一级菜单则不允许删除【需要先删除下一级菜单】
                Dept deptSearch = new Dept();
                deptSearch.setParentId(dept.getCode());
                if(getDeptList(deptSearch).size()>0){
                    String name = dept.getName();
                    result = TextUtils.format("单位名称{0},需要先删除下属单位", name);
                    //break;
                    return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR,result,"").getJson();
                };
                //逻辑删除
                Dept entry = new Dept();
                entry = deptMapper.selectByPrimaryKey(id);
                entry.setState(-1);
                try {
                    deptMapper.updateByPrimaryKeySelective(entry);
                    Map<String, Object> stringObjectMap = JavaBeanConverMapUtils.bean2Map(entry, false);
                    stringObjectMap = operationLogService.converMap(stringObjectMap, "DeptDelete");
                    operationLogService.getRunable(stringObjectMap,null,"Dept","delete");
                    result = Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
                }catch (Exception e){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    result = Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR,"","").getJson();
                }
            }
        }
        return result;
    }

    @Override
    public List<Dept> getDeptList(Dept entry) {
        //初始化Example
        DeptExample entryExample = new DeptExample();

        //创建查询条件
        DeptExample.Criteria criteria = entryExample.createCriteria();

        //如果菜单状态不为空，则根据菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        }
        //父级别菜单id
        if (!StrUtils.isBlank(entry.getParentId())) {
            criteria.andParentIdEqualTo(entry.getParentId());
        }
        criteria.andStateEqualTo(1);
        return  deptMapper.selectByExample(entryExample);
    }

    @Override
    public Pager<Dept> getDeptPageList(Dept entity, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询单位列表【分页方法】"));
        //初始化Example
        DeptExample entityExample = new DeptExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        DeptExample.Criteria criteria = entityExample.createCriteria();

        //父类id一下的菜单
        if (!StrUtils.isBlank(entity.getParentId())) {
            criteria.andParentIdEqualTo(entity.getParentId());
        }
        if(!StrUtils.isBlank(entity.getCode())){
            criteria.andCodeEqualTo(entity.getCode());
        }
        if(!StrUtils.isBlank(entity.getName())){
            criteria.andNameLike("%" + entity.getName() + "%");
        }
        criteria.andStateEqualTo(1);
        criteria.andCodeNotEqualTo("0");
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(entity.getLpsort())){
            entityExample.setOrderByClause(entity.getLpsort());
        }else{
            entityExample.setOrderByClause("CODE ASC");
        }

        List<Dept> depts = deptMapper.selectByExample(entityExample);
        pager.setPagerInfo(depts,deptMapper.countByExample(entityExample));

        return pager;

    }



}

