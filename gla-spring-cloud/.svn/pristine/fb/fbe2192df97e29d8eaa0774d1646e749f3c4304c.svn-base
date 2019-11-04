package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.*;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

import java.util.List;

/**
 *
 * 功能描述: 元数据管理-单位管理实现
 *
 * @param:
 * @return: 
 * @auther: zhangbo
 * @date: 2018/10/15 12:00
 */

public interface DeptService {

    /**
     * 保存单位信息
     *
     * @param entry
     * @return
     */
    boolean saveDept(Dept entry);

    /**
     * 根据code查询单位
     *
     * @param code
     * @return
     */
    Dept getDept(String code);

    /**
     * 更新单位信息
     *
     * @param entry
     * @return
     */
    boolean updateDept(Dept entry);

    /**
     * 根据code删除单位
     *
     * @param codes
     * @return
     */
    String deleteDept(String[] codes);

    /**
     * 根据条件查询单位
     *
     * @param dept
     * @return
     */
    List<Dept> getDeptList(Dept dept);

    /**
     * 根据条件查询单位并进行分页
     *
     * @param dept
     * @param pager
     * @return
     */
    Pager<Dept> getDeptPageList(Dept dept, Pager pager);


}