package com.limp.framework.core.abs;

//import com.fasterxml.jackson.annotation.JsonFormat;

import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;

import java.util.Date;

/**
 * 此类提供：实体类中共有属性进行定义
 * 如排序字段:lpsort
 */
public abstract class AbstractModel {
    /**
     * 定义排序字段：注意此处定义，其他类无需额外定义，否则报错
     */

    private String lpsort;

    /**
     * 查询使用：用时查询开始 和结束时间组合使用
     * example：查询创建时间在2018-01-01到2018-03-01的时间段的数据
     * 此时：前端传过来的数据库为：createdate和lpEndDate
     */
    private Date lpEndDate;

    /*****************************************/
    Pager  pager;

    /**
     * 获取分页对象
     * @param rows
     * @return
     */
    public Pager getPager(Integer  rows) {
        return new Pager(page, StrUtils.isBlank(rows)|| Constant.NUMBER_0==rows?10:rows);
    }

    /**
     * 获取分页面对象
     * @return
     */
    public Pager getPager() {
        return new Pager(page, StrUtils.isBlank(rows)|| Constant.NUMBER_0==rows?10:rows);
    }

    /**
     *  当前页数
     */
    private int page = 1;

    /**
     * 每页展示的行数
     */
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Date getLpEndDate() {
        return lpEndDate;
    }

    public void setLpEndDate(Date lpEndDate) {
        this.lpEndDate = lpEndDate;
    }

    public String getLpsort() {
        return lpsort;
    }

    public void setLpsort(String lpsort) {
        this.lpsort = lpsort;
    }
}
