package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.ModelContent;
import com.limp.framework.boss.domain.ModelContentExample;
import com.limp.framework.boss.mapper.oracle.ModelContentMapper;
import com.limp.framework.boss.service.ModelContentService;
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
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 13:42 2018/8/18
 * @modified By:
 */
@Service
public class ModelContentServiceImpl implements ModelContentService {

    private Logger log= LoggerFactory.getLogger(ModelContentServiceImpl.class);

    /**
     * 注入mapper
     */
    @Autowired
    private ModelContentMapper modelContentMapper;


    @Override
    public boolean save(ModelContent entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增邮件模板{0}", entry.getId()));
        entry.setIdt(new Date());
        try {
            return modelContentMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ModelContent get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据命令Id{0},获取实体类信息", id));
        return modelContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(ModelContent entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        entry.setUdt(new Date());
        log.debug(TextUtils.format("根据Id{0},更新实体类信息",entry.getId()));
        return modelContentMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("根据Id{0},删除实体邮件模板信息", id));

        //逻辑删除
        ModelContent entry=new ModelContent();
        entry.setId(id);
        entry.setStatus(Integer.parseInt(Constant.STRING_DEL_STATE));
        //更新时间
        entry.setUdt(new Date());
        return  modelContentMapper.updateByPrimaryKeySelective(entry)== 1?true:false;
    }

    @Override
    public List<ModelContent> getList(ModelContent entry) {
        //初始化Example
        ModelContentExample entryExample = new ModelContentExample();

        //创建查询条件
        ModelContentExample.Criteria criteria = entryExample.createCriteria();

        //如果邮件模板状态不为空，则根据邮件模板状态查询邮件模板列表
        if (!StrUtils.isBlank(entry.getStatus())) {
            criteria.andStatusEqualTo(entry.getStatus());
        }

        //根据code精确查询
        if (!StrUtils.isBlank(entry.getCode())) {
            criteria.andCodeEqualTo(entry.getCode());
        }

        //根据标题模糊查询
        if (!StrUtils.isBlank(entry.getTitle())) {
            criteria.andTitleLike("%"+entry.getTitle()+"%");
        }

        return  modelContentMapper.selectByExample(entryExample);
    }

    @Override
    public Pager<ModelContent> getPageList(ModelContent entity, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询邮件模板列表【分页方法】"));
        //初始化Example
        ModelContentExample entityExample = new ModelContentExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        ModelContentExample.Criteria criteria = entityExample.createCriteria();

        //如果邮件模板状态不为空，则根据邮件模板状态查询邮件模板列表
        if (!StrUtils.isBlank(entity.getStatus())) {
            criteria.andStatusEqualTo(entity.getStatus());
        }

        //根据code精确查询
        if (!StrUtils.isBlank(entity.getCode())) {
            criteria.andCodeEqualTo(entity.getCode());
        }

        //根据标题模糊查询
        if (!StrUtils.isBlank(entity.getTitle())) {
            criteria.andTitleLike("%"+entity.getTitle()+"%");
        }
        List<ModelContent> modelContents=modelContentMapper.selectByExample(entityExample);

        pager.setPagerInfo(modelContents,modelContentMapper.countByExample(entityExample));

        return pager;

    }
}
