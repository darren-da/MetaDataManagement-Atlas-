package com.limp.framework.boss.service;

import com.limp.framework.boss.domain.*;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;

import java.util.List;

/**
 * 用户service
 *
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
public interface SysService extends AbstractService<DicCode> {

    /**
     * 保存地区信息
     *
     * @param entry
     * @return
     */
    boolean saveArea(AreaCode entry);

    /**
     * 保存码表信息
     *
     * @param entry
     * @return
     */
    boolean saveDic(DicCode entry);

    /**
     * 从新增标签
     * @param entry
     * @return
     */
    boolean saveTag(TagsLib entry);

    /**
     * 根据code查询地区
     *
     * @param code
     * @return
     */
    AreaCode getArea(String code);


    /**
     * 根据key获取 tagsLib
     * @param key
     * @return
     */
    TagsLib getTagLib(String key);

    /**
     * 根据DictData_Value查询地区
     *
     * @param dictValue
     * @return
     */
    DicCode getDic(String dictValue);

    /**
     * 更新地区信息
     *
     * @param entry
     * @return
     */
    boolean updateArea(AreaCode entry);

    /**
     * 更新标签
     * @param tagsLib
     * @return
     */
    boolean updateTagLib(TagsLib tagsLib);

    /**
     * 更新码表信息
     *
     * @param entry
     * @return
     */
    boolean updateDic(DicCode entry);

    /**
     * 根据code删除地区
     *
     * @param code
     * @return
     */
    boolean deleteArea(String code);


    /**
     * 删除标签（key）
     * @param key
     * @return
     */
    boolean deleteTagLib(String key);

    /**
     * 根据DictData_Value删除码表
     *
     * @param idcValue
     * @return
     */
    boolean deleteDic(String idcValue);

    /**
     * 根据条件查询地区
     *
     * @param areaCode
     * @return
     */
    List<AreaCode> getAreaList(AreaCode areaCode);

    /**
     * 根据条件查询标签
     * @param tagLib
     * @return
     */
    List<TagsLib> getTagsLibList(TagsLib tagLib);

    /**
     * 根据条件查询码表
     *
     * @param dicCode
     * @return
     */
    List<DicCode> getDicList(DicCode dicCode);

    /**
     * 根据条件查询地区并进行分页
     *
     * @param areaCode
     * @param pager
     * @return
     */
    Pager<AreaCode> getAreaPageList(AreaCode areaCode, Pager pager);


    /**
     * 获取标签分页
     * @param tagsLib
     * @param pager
     * @return
     */
    Pager<TagsLib> getTagsLibPageList(TagsLib tagsLib, Pager pager);



    /**
     * 根据条件查询码表并进行分页
     *
     * @param dicCode
     * @param pager
     * @return
     */
    Pager<DicCode> getDicPageList(DicCode dicCode, Pager pager);

}