package com.limp.framework.core.bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zzh
 * Date: 16-2-5
 * Time: 上午12:25
 * To change this template use File | Settings | File Templates.
 */
public class Pager<T> {

    /**
     *  当前页数
     */
    private int page = 1;

    /**
     * 每页展示的行数
     */
    private int rows;
    /**
     *总记录数
     */
    private int rowCount;
    /**
     * 总页数
     */
    private int pageCount;

    private List<T> dataList;

    public Pager() {
        super();
    }

    public Pager(int page, int rows) {
        super();
        this.page = page;
        this.rows = rows;
    }

    public int getStart() {
        return (this.page - 1) * this.rows;
    }

    public int getEnd() {
        return this.page * this.rows;
    }

    public int getLimit() {
        return this.rows;
    }

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

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public void setPagerInfo(List<T> dataList, int rowCount) {
        this.dataList = dataList;
        this.rowCount = rowCount;
        if (rowCount % this.rows == 0) {
            this.pageCount = rowCount / this.rows;
        } else {
            this.pageCount = rowCount / this.rows + 1;
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

}
