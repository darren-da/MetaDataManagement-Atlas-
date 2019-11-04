package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.DBSource;
import com.gla.datacenter.domain.DBSourceExample;
import com.gla.datacenter.mapper.mysql.DBSourceMapper;
import com.gla.datacenter.service.DBSourceService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:  MetaDataTreeService实现层
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 15:47
 */
@Service
public class DBSourceServiceImpl implements DBSourceService {

    private Logger logger= LoggerFactory.getLogger(DBSourceServiceImpl.class);

    @Autowired
    DBSourceMapper dbSourceMapper;


    @Override
    public boolean save(DBSource entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        if (StrUtils.isBlank(entry.getIdt())) {
            entry.setIdt(new Date());
        }
        entry.setState(Constant.NUMBER_1);
        logger.debug(TextUtils.format("新增数据源{0}", entry.getId()));
        try {
            return dbSourceMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DBSource get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        logger.debug(TextUtils.format("根据Id{0},获取实体类信息",id));
        return dbSourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(DBSource entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        if (StrUtils.isBlank(entry.getIdt())) {
            entry.setIdt(new Date());
        }

        entry.setUdt(new Date());
        logger.debug(TextUtils.format("根据Id{0},更新实体类信息",entry.getId()));
        return dbSourceMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete(String id) {
        logger.debug(TextUtils.format("根据Id{0},删除实体信息", id));
        //逻辑删除
        DBSource dbSource=new DBSource();
        dbSource.setState(Constant.STATE_DELETE);
        dbSource.setId(id);
        //更新时间
        dbSource.setUdt(new Date());
        return  dbSourceMapper.updateByPrimaryKeySelective(dbSource)== 1?true:false;
    }

    @Override
    public List<DBSource> getList(DBSource entry) {
        //初始化Example
        DBSourceExample dbSourceExample = new DBSourceExample();

        //创建查询条件
        DBSourceExample.Criteria criteria = dbSourceExample.createCriteria();

        //如果菜单状态不为空，则根据菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        }else{
            criteria.andStateEqualTo(Constant.NUMBER_1);
        }
        //父级别菜单id
        if (!StrUtils.isBlank(entry.getId())) {
            criteria.andIdEqualTo(entry.getId());
        }

        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%"+entry.getName()+"%");
        }

        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(entry.getLpsort())){
            dbSourceExample.setOrderByClause(entry.getLpsort());
        }else{
            dbSourceExample.setOrderByClause("IDT DESC");
        }

        return  dbSourceMapper.selectByExample(dbSourceExample);
    }

    @Override
    public Pager<DBSource> getPageList(DBSource entry, Pager pager) {
        logger.debug(TextUtils.format("根据条件,查询列表【分页方法】"));
        //初始化Example
        DBSourceExample dbSourceExample = new DBSourceExample();
        //设置分页对象
        dbSourceExample.setPage(pager);

        //创建查询条件
        DBSourceExample.Criteria criteria = dbSourceExample.createCriteria();

        //如果菜单状态不为空，则根据菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        }else{
            criteria.andStateEqualTo(Constant.NUMBER_1);
        }
        //父级别菜单id
        if (!StrUtils.isBlank(entry.getId())) {
            criteria.andIdEqualTo(entry.getId());
        }
         if (!StrUtils.isBlank(entry.getDbCode())) {
            criteria.andDbCodeEqualTo(entry.getDbCode());
        }

        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%"+entry.getName()+"%");
        }

        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(entry.getLpsort())){
            dbSourceExample.setOrderByClause(entry.getLpsort());
        }else{
            dbSourceExample.setOrderByClause("IDT DESC");
        }


        List<DBSource> dbSources=dbSourceMapper.selectByExample(dbSourceExample);

        pager.setPagerInfo(dbSources,dbSourceMapper.countByExample(dbSourceExample));

        return pager;
    }


}
