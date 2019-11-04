package com.limp.framework.core.abs;

import com.limp.framework.core.bean.Pager;

import java.util.List;

/**
 * @author shinians
 */
public interface AbstractService<T extends AbstractModel> {

    /**
     * 保存实体类：用于新怎一条实体类记录
     * @param entry 需要保存的实体类
     * @return true or false
     */
    public abstract boolean save(T entry);

    /**
     * 获取实体类：根据id主键获取实体类信息
     * @param id 主键id
     * @return entry
     */
    public abstract T get(String id);

    /**
     * 更新实体类信息：用于更新记录
     * @param entry 当前实体类信息
     * @return true or false
     */
    public abstract boolean update(T entry);

    /**
     * 根据id删除实体类信息
     * @param id 需要删除的Id
     * @return true or false
     */
    public abstract boolean delete(String id);

    /**
     * 根据传入entry参数查询说是有符合条件的实体类列表
     * @param entry 查询条件：精确查询|不带模糊查询条件
     * @return list集合
     */
    public abstract List<T> getList(T entry);

    /**
     * 获取分页实体类信息
     * @param entry 实体类 |支持模糊查询方法 如account（默认是模糊查询）
     * @param pager 分页信息
     * @return 分页后的实体类
     */
    public Pager<T> getPageList(T entry, Pager pager) ;





}
