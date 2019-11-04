package com.gla.datacenter.service;

import com.gla.datacenter.domain.DBSource;
import com.gla.datacenter.domain.MetaDataTree;
import com.gla.datacenter.domain.RelationDataflow;
import com.limp.framework.core.abs.AbstractModel;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

import java.beans.Transient;
import java.util.List;
import java.util.Map;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 15:46
 */
public interface MetaDataTreeService extends AbstractService<MetaDataTree> {
    /**
     * 添加元数据关系
     *
     * @param sourceId  元数据Id
     * @param targetIds 目标Id集合，逗号分割
     * @return
     */
    boolean addMetaRelaction(String sourceId, String targetIds);

    /**
     * 新增关系
     * @param relationDataflow
     * @return
     */
    public boolean addMetaDBRelaction(RelationDataflow relationDataflow) ;

    /**
     * 获取delction
     *
     * @param entry
     * @param pager
     * @return
     */

    public Pager<RelationDataflow> getPageRelationMetaList(RelationDataflow entry, Pager pager);

    /**
     * 删除元数据
     *
     * @param sourceId
     * @param targetId
     * @return
     */

    public boolean delMetaRelation(String sourceId, String targetId);

    /**
     * 获取RelationMetaList
     * @param entry
     * @return
     */
    public List<RelationDataflow> getRelationMetaList(RelationDataflow entry);

    /**
     * 异步获取左侧菜单
     * @param entry
     * @param pager
     * @return
     */
    public Pager<MetaDataTree> getPageListAsyn(MetaDataTree entry, Pager pager) ;

    /**
     * 功能描述: 批量删除元模板
     * @param:
     * @param id 元模板ID（逗号分隔）
     * @return: boolean
     * @auther: zhengshien
     * @date: 2019/5/6 13:54
     */
    boolean delTemplate(String id);
    /**
     * 新增元模版数据｜仅供元模版管理使用
     * @param metaDataTree
     * @return
     */
    public boolean saveMetaDataTreeYmb(MetaDataTree metaDataTree);


    boolean updateVersion(MetaDataTree metaDataTree);

    boolean updateMetaDataTreeYmb(MetaDataTree metaDataTree);

    Pager<MetaDataTree> getPageListVersion(MetaDataTree metaDataTree, Pager pager);

    String analysisStatisticsOne(MetaDataTree metaDataTree);

    /**
     * 根据条件返回总数
     * @param metaDataTree
     * @return
     */
    Integer selectMetaNumByType(MetaDataTree metaDataTree);

    /**
     * 统计业务数量情况
     * @return
     */
    List<Map<String,String>> selectMetaOutLineApp();

    /**
     * 获取父类集合
     * @param metaId
     * @return
     */
    public  List<MetaDataTree>  getLoopPMeta(String metaId);

    /**
     * 查询匹配所有子集字段
     * @param metaId
     * @return
     */
    @Transient
    public  List<Map<String,String>>  metaChildMatch(String metaId);

    public  List<Map<String,String>>  metaChildMatchList(String metaId);


    public  List<Map<String,String>>  metaCommend(String keyWord);


    }
