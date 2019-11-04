package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.PageLog;
import com.limp.framework.boss.domain.PageLogExample;
import com.limp.framework.boss.mapper.oracle.PageLogMapper;
import com.limp.framework.boss.service.PageLogService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description:  pageLog接口实现层
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/16 14:43
 */
@Service
public class PageLogServiceImpl implements PageLogService {

    private Logger log= LoggerFactory.getLogger(PageLogServiceImpl.class);

    /**
     * 访问日志Mapper
     */
    @Autowired
    private PageLogMapper pageLogMapper;

    @Override
    public boolean save(PageLog entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        if(StrUtils.isBlank(entry.getIdt())){
            entry.setIdt(new Date());
        }
        return pageLogMapper.insertSelective(entry)==1?true:false;
    }

    @Override
    public PageLog get(String id) {
        return null;
    }

    @Override
    public boolean update(PageLog entry) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<PageLog> getList(PageLog entry) {
        return null;
    }

    @Override
    public Pager<PageLog> getPageList(PageLog entry, Pager pager) {
        return null;
    }

    @Override
    public Pager<PageLog> getPageLogPageList(PageLog pageLog, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询码表列表【分页方法】"));
        PageLogExample pageLogExample = new PageLogExample();
        //设置分页对象
        pageLogExample.setPage(pager);
        //创建查询条件
        PageLogExample.Criteria pageLogExampleCriteria = pageLogExample.createCriteria();

        //如果用户账号不为空，则根据账号查询日志列表
        if (!StrUtils.isBlank(pageLog.getUserid())) {
            pageLogExampleCriteria.andUseridEqualTo(pageLog.getUserid());
        }

        //根据操作菜单id查询日志列表
        if (!StrUtils.isBlank(pageLog.getOptParams())) {
            pageLogExampleCriteria.andOptParamsLike("%"+pageLog.getOptParams()+"%");
        }



        //根据创建时间查询日志列表
        if (!StrUtils.isBlank(pageLog.getIdt())) {
            pageLogExampleCriteria.andIdtBetween(pageLog.getIdt(), pageLog.getLpEndDate() == null ? new Date() : pageLog.getLpEndDate());
        }
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(pageLog.getLpsort())){
            pageLogExample.setOrderByClause(pageLog.getLpsort());
        }else{
            pageLogExample.setOrderByClause("IDT DESC");
        }

        List<PageLog> pageLogs=pageLogMapper.selectByExample(pageLogExample);

        pager.setPagerInfo(pageLogs,pageLogMapper.countByExample(pageLogExample));

        return pager;

    }
}
