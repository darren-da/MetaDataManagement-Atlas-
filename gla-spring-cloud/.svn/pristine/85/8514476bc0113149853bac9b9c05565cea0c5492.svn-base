package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.*;
import com.gla.datacenter.mapper.mysql.DBSourceMapper;
import com.gla.datacenter.mapper.mysql.MetaDataTreeMapper;
import com.gla.datacenter.mapper.mysql.RelationDataflowMapper;
import com.gla.datacenter.service.MetaDataTreeService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.HttpRequest;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: MetaDataTreeService实现层
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 15:47
 */
@Service
public class MetaDataTreeServiceImpl implements MetaDataTreeService {

    //推荐接口
//    private  String solrTJUrl="http://127.0.0.1:9991/search";
    private  String solrTJUrl="http://192.168.26.113:9991/search";
//    http://192.168.26.113:9991/search

    private Logger logger = LoggerFactory.getLogger(MetaDataTreeServiceImpl.class);

    @Autowired
    MetaDataTreeMapper metaDataTreeMapper;

    @Autowired
    RelationDataflowMapper relationDataflowMapper;

    @Override
    public boolean save(MetaDataTree entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        entry.setState(Constant.NUMBER_1);
        if (StrUtils.isBlank(entry.getIdt())) {
            entry.setIdt(new Date());
        }
        if(StrUtils.isBlank(entry.getPid())){
            logger.error("pid 不可为空");
            return  false;
        }
        logger.debug(TextUtils.format("新增元数据树{0}", entry.getId()));
        try {

           Boolean flay= metaDataTreeMapper.insertSelective(entry) == 1 ? true : false;
           //新增元数据 和数据库 绑定关系 ConnDBSourceId判定
            if(flay&&!StrUtils.isBlank(entry.getConnDBSourceId())){
                RelationDataflow relationDataflow=new RelationDataflow();
                relationDataflow.setTargetId(entry.getConnDBSourceId());
                relationDataflow.setSourceId(entry.getId());
                relationDataflow.setFlowType(Constant.NUMBER_3);
                addMetaDBRelaction(relationDataflow);
            }

            return flay;
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * todo 事物控制
     *
     * @param entry
     * @return
     */

    @Override
    public boolean saveMetaDataTreeYmb(MetaDataTree entry) {

        if (StrUtils.isBlank(entry.getPid())) {
            logger.error("pid不可为空");
            return false;
        }
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        entry.setState(Constant.NUMBER_1);
        if (StrUtils.isBlank(entry.getIdt())) {
            entry.setIdt(new Date());
        }
        logger.debug(TextUtils.format("新增元数据树{0}", entry.getId()));
        try {
            metaDataTreeMapper.insertSelective(entry);
            //新增元模版｜子集
            for (MetaDataTree meta : entry.childs) {
                if (StrUtils.isBlank(meta.getId())) {
                    meta.setId(StrUtils.randomUUID());
                    meta.setPid(entry.getId());
                    meta.setIdt(new Date());
                    meta.setState(Constant.NUMBER_1);
                    save(meta);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public MetaDataTree get(String id) {
        if (StrUtils.isBlank(id)) {
            return null;
        }
        logger.debug(TextUtils.format("根据Id{0},获取实体类信息", id));
        MetaDataTree metaDataTree = metaDataTreeMapper.selectByPrimaryKey(id);
        if (metaDataTree == null) {
            return null;
        }
        //查询子集合
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //设置分页对象
        entityExample.setPage(new Pager(1, 100));
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();
        criteria.andPidEqualTo(id).andStateEqualTo(Constant.NUMBER_1);
        List<MetaDataTree> childs = metaDataTreeMapper.selectByExample(entityExample);
        metaDataTree.setChilds(childs);
        return metaDataTree;
    }

    /**
     * 获取Meta实体类
     * @param id metaId
     * @return
     */
    public MetaDataTree getMeta(String id) {
        if (StrUtils.isBlank(id)) {
            return null;
        }
        logger.debug(TextUtils.format("根据Id{0},获取实体类信息", id));
        MetaDataTree metaDataTree = metaDataTreeMapper.selectByPrimaryKey(id);
        return metaDataTree;
    }

    @Override
    public boolean update(MetaDataTree entry) {
//        String userId = ApplicationContextHolder.currentUser().getId();
        if (StrUtils.isBlank(entry.getId())) {
            return false;
        }
        logger.debug(TextUtils.format("根据Id{0},更新实体类信息", entry.getId()));
        //根据此条数据ID查询上一版本数据
        MetaDataTree metaDataTree = metaDataTreeMapper.selectByPrimaryKey(entry.getId());
        //生成新的ID
        metaDataTree.setId(entry.getId() + "_" + StrUtils.randomUUID());
        //插入创建时间
        metaDataTree.setIdt(new Date());
        //定义状态为2（历史版本）
        metaDataTree.setState(Constant.NUMBER_2);

        MetaDataTreeExample metaDataTreeExample=new MetaDataTreeExample();
        metaDataTreeExample.createCriteria().andIdLike(entry.getId()+"%");
        List<MetaDataTree> metaDataTrees = metaDataTreeMapper.selectByExample(metaDataTreeExample);
        List list=new ArrayList();
        for (MetaDataTree dataTree : metaDataTrees) {
            if (!StrUtils.isBlank(dataTree.getRc2())){
                list.add(dataTree.getRc2());
            }
        }
        if (list.size()==Constant.NUMBER_0){
            metaDataTree.setRc2("V1."+Constant.NUMBER_0);
        }else {
            Comparable max = Collections.max(list);
            String s = String.valueOf(max);
            String[] split = s.split("\\.");
            int i = Integer.parseInt(split[1]) + Constant.NUMBER_1;
            metaDataTree.setRc2("V1."+i);
        }
        //将新数据存入表中
        metaDataTreeMapper.insertSelective(metaDataTree);
        entry.setUdt(new Date());

        //更改元数据绑定关系
        if(!StrUtils.isBlank(entry.getConnDBSourceId())){
            updateMetadateTree(entry.getId(),entry.getConnDBSourceId());
        }
        return metaDataTreeMapper.updateByPrimaryKeySelective(entry) == 1 ? true : false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     *修改 元数据和数据库 绑定关系
     * @param sourceId 元数据id
     * @param targetId  dbId
     * @return
     */
    boolean updateMetadateTree(String sourceId,String targetId){
        //删除|新增

        //删除之前绑定关系
        RelationDataflowExample relationDataflowExample = new RelationDataflowExample();
        relationDataflowExample.createCriteria().andSourceIdEqualTo(sourceId).andFlowTypeEqualTo(Constant.NUMBER_3);
        relationDataflowMapper.deleteByExample(relationDataflowExample);

        //新增绑定关系
        RelationDataflow relationDataflow = new RelationDataflow();
        relationDataflow.setSourceId(sourceId);
        relationDataflow.setTargetId(targetId);
        relationDataflow.setState(Constant.NUMBER_3);
        relationDataflowMapper.insertSelective(relationDataflow);
        return  false;
    }
    @Override
    public boolean updateVersion(MetaDataTree metaDataTree) {
        String[] split = metaDataTree.getId().split("_");
        String id = split[0];
        try {
            //将原纪录变更为历史版本，并添加随机ID
            MetaDataTree metaDataTree1 = metaDataTreeMapper.selectByPrimaryKey(id);
            metaDataTree1.setId(id + "_" + StrUtils.randomUUID());
            metaDataTree1.setState(Constant.NUMBER_2);
            MetaDataTreeExample metaDataTreeExample = new MetaDataTreeExample();
            metaDataTreeExample.createCriteria().andIdEqualTo(id);
            metaDataTreeMapper.updateByExampleSelective(metaDataTree1, metaDataTreeExample);
            //将当前版本变为最新版本
            MetaDataTree metaDataTree2 = metaDataTreeMapper.selectByPrimaryKey(metaDataTree.getId());
            metaDataTree2.setId(id);
            metaDataTree2.setState(Constant.NUMBER_1);
            MetaDataTreeExample metaDataTreeExample1 = new MetaDataTreeExample();
            metaDataTreeExample1.createCriteria().andIdEqualTo(metaDataTree.getId());
            metaDataTreeMapper.updateByExampleSelective(metaDataTree2, metaDataTreeExample1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateMetaDataTreeYmb(MetaDataTree metaDataTree) {

        if (StrUtils.isBlank(metaDataTree.getPid())) {
            logger.error("pid不可为空");
            return false;
        }
        if (StrUtils.isBlank(metaDataTree.getId())) {
            logger.error("id不可为空");
            return false;
        }
        metaDataTree.setUdt(new Date());
        logger.debug(TextUtils.format("编辑元数据树{0}", metaDataTree.getId()));
        try {
            metaDataTreeMapper.updateByPrimaryKeySelective(metaDataTree);
            MetaDataTreeExample metaDataTreeExample = new MetaDataTreeExample();
            metaDataTreeExample.createCriteria().andPidEqualTo(metaDataTree.getId());
            List<MetaDataTree> metaDataTrees = metaDataTreeMapper.selectByExample(metaDataTreeExample);
            List list1 = new ArrayList();
            for (MetaDataTree dataTree : metaDataTrees) {
                list1.add(dataTree.getId());
            }
            List list = new ArrayList();
            for (MetaDataTree meta : metaDataTree.childs) {
                if (!StrUtils.isBlank(meta.getId())) {
                    list.add(meta.getId());
                } else {
                    meta.setId(StrUtils.randomUUID());
                    meta.setPid(metaDataTree.getId());
                    meta.setIdt(new Date());
                    meta.setState(Constant.NUMBER_1);
                    save(meta);
                }
            }

            List diffrent = getDiffrent(list1, list);
            for (Object o : diffrent) {
                String s = String.valueOf(o);
                metaDataTreeMapper.deleteByPrimaryKey(s);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Pager<MetaDataTree> getPageListVersion(MetaDataTree entry, Pager pager) {
        logger.debug(TextUtils.format("根据条件,查询列表【分页方法】"));
        //初始化Example
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();
        //维护关系｜特殊梳理，判断keywords是否为空
        if (!StrUtils.isBlank(entry.getKeyWords())) {

            if (StrUtils.isBlank(entry.getConnModelCode())) {
                entityExample.or().andNameLike("%" + entry.getKeyWords() + "%").andStateEqualTo(Constant.NUMBER_1);
                entityExample.or().andCodeEqualTo(entry.getKeyWords()).andStateEqualTo(Constant.NUMBER_1);
            } else {
                entityExample.or().andNameLike("%" + entry.getKeyWords() + "%").andStateEqualTo(Constant.NUMBER_1).andConnModelCodeEqualTo(entry.getConnModelCode());
                entityExample.or().andCodeEqualTo(entry.getKeyWords()).andStateEqualTo(Constant.NUMBER_1).andConnModelCodeEqualTo(entry.getConnModelCode());
            }
        } else {
            //根据元模型类型筛选
            if (!StrUtils.isBlank(entry.getConnModelCode())) {
                criteria.andConnModelCodeEqualTo(entry.getConnModelCode());
            }
        }

        //如果菜单状态不为空，则更具菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        } else {
            //如果keywords不为空无需设置状态｜or 条件已经设置

            if (StrUtils.isBlank(entry.getKeyWords())) {
                criteria.andStateEqualTo(Constant.NUMBER_1);
            }
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPid())) {
            criteria.andPidEqualTo(entry.getPid());
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPcode())) {
            criteria.andPcodeEqualTo(entry.getPcode());
        }
        if (!StrUtils.isBlank(entry.getCode())) {
            criteria.andCodeEqualTo(entry.getCode());
        }
        if (!StrUtils.isBlank(entry.getType())) {
            criteria.andTypeEqualTo(entry.getType());
        }
        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%" + entry.getName() + "%");
        }
        if (!StrUtils.isBlank(entry.getId())) {
            criteria.andIdLike(entry.getId() + "%");
        }

        if (!StrUtils.isBlank(entry.getIdt())) {
            criteria.andIdtBetween(entry.getIdt(),entry.getLpEndDate());
        }
        if (!StrUtils.isBlank(entry.getRc2())) {
            criteria.andRc2Like("%"+entry.getRc2()+"%");
        }


        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if (!StrUtils.isBlank(entry.getLpsort())) {
            entityExample.setOrderByClause(entry.getLpsort());
        } else {
            entityExample.setOrderByClause("ORDER_NUM ASC ,IDT ASC");
        }

        //只有关键字有值的时候才查询父类的pid|以后改成搜索引擎或者换其它方案，临时解决方案

        List<MetaDataTree> metaDataTrees = metaDataTreeMapper.selectByExample(entityExample);

        pager.setPagerInfo(metaDataTrees, metaDataTreeMapper.countByExample(entityExample));
        return pager;
    }

    @Override
    public String analysisStatisticsOne(MetaDataTree metaDataTree) {
        String[] split = metaDataTree.getConnModelCode().split(",");
        Map map=new HashMap();
        MetaDataTreeExample metaDataTreeExample=new MetaDataTreeExample();
        map.put("total",metaDataTreeMapper.countByExample(metaDataTreeExample));
        for (String s : split) {
                metaDataTreeExample.createCriteria().andConnModelCodeEqualTo(s);
                int i = metaDataTreeMapper.countByExample(metaDataTreeExample);
                map.put(s,i);
        }
        return JsonUtils.toJson(map);
    }

    @Override
    public Integer selectMetaNumByType(MetaDataTree metaDataTree) {
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();
        criteria.andStateEqualTo(Constant.NUMBER_1);

        if(!StrUtils.isBlank(metaDataTree.getConnModelCode())) {
            criteria.andConnModelCodeEqualTo(metaDataTree.getConnModelCode());
        }
        if(!StrUtils.isBlank(metaDataTree.getType())){
            criteria.andTypeEqualTo(metaDataTree.getType());
        }

        Integer  num = metaDataTreeMapper.countByExample(entityExample);
        return num;
    }

    @Override
    public List<Map<String, String>> selectMetaOutLineApp() {
        MetaDataTree metaDataTreeApp=new MetaDataTree();
        metaDataTreeApp.setConnModelCode("M_APP_SYS");
        metaDataTreeApp.setState(Constant.NUMBER_1);
        List<MetaDataTree> appList=getList(metaDataTreeApp);
        List<Map<String,String>> listMap=new ArrayList<>();
        for(MetaDataTree appMetaData:appList){
            Map<String,String> appMap=new HashMap<String,String>();
            //应用名称
            appMap.put("appName",appMetaData.getName());


           RelationDataflow relationDataflow=new RelationDataflow();
           relationDataflow.setSourceId(appMetaData.getId());
            Pager<RelationDataflow> relationDataflowPager
                    = getPageRelationMetaList(relationDataflow, new Pager(1, 20));
            //应用关联的DB数量|todo 排除其他的关联如表等 ||需要修改solr，前端调试返回假数据
            appMap.put("dbNum",relationDataflowPager.getDataList().size()+"");
            Random  random=new Random();
            appMap.put("viewNum",random.nextInt(100)+"");
            appMap.put("tableNum",40+"");
            listMap.add(appMap);
        }
        return listMap;
    }

    /**
     * 功能描述: 获取两个不同list中的元素（工具）
     * @param:
     * @param list1
     * @param list2
     * @return: java.util.List<java.lang.String>
     * @auther: zhengshien
     * @date: 2019/5/8 12:41
     */
    private static List<String> getDiffrent(List<String> list1, List<String> list2) {
        long st = System.nanoTime();
        Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if (list2.size() > list1.size()) {
            maxList = list2;
            minList = list1;
        }
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            Integer cc = map.get(string);
            if (cc != null) {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }

    @Override
    public boolean delete(String id) {
        logger.debug(TextUtils.format("根据Id{0},删除实体信息", id));

        //如果含有下一级菜单则不允许删除【需要先删除下一级菜单】
        MetaDataTree menuDataTree = new MetaDataTree();
        menuDataTree.setState(Constant.NUMBER_1);
        menuDataTree.setPid(id);
        if (getList(menuDataTree).size() > 0) {
            logger.error(TextUtils.format("该菜单Id{0},需要先子菜单,方可删除", id));
            return false;
        }
        //逻辑删除
        MetaDataTree entry = new MetaDataTree();
        entry.setId(id);
        entry.setState(Constant.STATE_DELETE);

        //更新时间
        entry.setUdt(new Date());
        return metaDataTreeMapper.updateByPrimaryKeySelective(entry) == 1 ? true : false;
    }

    @Override
    public List<MetaDataTree> getList(MetaDataTree entry) {
        //初始化Example
        MetaDataTreeExample entryExample = new MetaDataTreeExample();

        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entryExample.createCriteria();

        //如果菜单状态不为空，则根据菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        } else {
            criteria.andStateEqualTo(Constant.NUMBER_1);
        }
        //父级别菜单id
        if (!StrUtils.isBlank(entry.getPid())) {
            criteria.andPidEqualTo(entry.getPid());
        }

        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%" + entry.getName() + "%");
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPcode())) {
            criteria.andPcodeEqualTo(entry.getPcode());
        }
        if (!StrUtils.isBlank(entry.getCode())) {
            criteria.andCodeEqualTo(entry.getCode());
        }
        if (!StrUtils.isBlank(entry.getConnModelCode())) {
            criteria.andConnModelCodeEqualTo(entry.getConnModelCode());
        }
       /* if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%"+entry.getName()+"%");
        }*/
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if (!StrUtils.isBlank(entry.getLpsort())) {
            entryExample.setOrderByClause(entry.getLpsort());
        } else {
            entryExample.setOrderByClause("ORDER_NUM ASC ,IDT ASC");
        }

        return metaDataTreeMapper.selectByExample(entryExample);
    }

    @Override
    public Pager<MetaDataTree> getPageList(MetaDataTree entry, Pager pager) {
        logger.debug(TextUtils.format("根据条件,查询列表【分页方法】"));
        //初始化Example
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();
        //维护关系｜特殊梳理，判断keywords是否为空
        if (!StrUtils.isBlank(entry.getKeyWords())) {

            if (StrUtils.isBlank(entry.getConnModelCode())) {
                entityExample.or().andNameLike("%" + entry.getKeyWords() + "%").andStateEqualTo(Constant.NUMBER_1);
                entityExample.or().andCodeEqualTo(entry.getKeyWords()).andStateEqualTo(Constant.NUMBER_1);
            } else {
                entityExample.or().andNameLike("%" + entry.getKeyWords() + "%").andStateEqualTo(Constant.NUMBER_1).andConnModelCodeEqualTo(entry.getConnModelCode());
                entityExample.or().andCodeEqualTo(entry.getKeyWords()).andStateEqualTo(Constant.NUMBER_1).andConnModelCodeEqualTo(entry.getConnModelCode());
            }
        } else {
            //根据元模型类型筛选
            if (!StrUtils.isBlank(entry.getConnModelCode())) {
                criteria.andConnModelCodeEqualTo(entry.getConnModelCode());
            }
        }

        //如果菜单状态不为空，则更具菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        } else {
            //如果keywords不为空无需设置状态｜or 条件已经设置

            if (StrUtils.isBlank(entry.getKeyWords())) {
                criteria.andStateEqualTo(Constant.NUMBER_1);
            }
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPid())) {
            criteria.andPidEqualTo(entry.getPid());
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPcode())) {
            criteria.andPcodeEqualTo(entry.getPcode());
        }
        if (!StrUtils.isBlank(entry.getCode())) {
            criteria.andCodeEqualTo(entry.getCode());
        }
        if (!StrUtils.isBlank(entry.getType())) {
            criteria.andTypeEqualTo(entry.getType());
        }
        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%" + entry.getName() + "%");
        }
        if (!StrUtils.isBlank(entry.getId())) {
            criteria.andIdLike(entry.getId() + "%");
        }

        if (!StrUtils.isBlank(entry.getIdt())) {
            criteria.andIdtBetween(entry.getIdt(),entry.getLpEndDate());
        }
        if (!StrUtils.isBlank(entry.getRc2())) {
            criteria.andRc2Like("%"+entry.getRc2()+"%");
        }


        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if (!StrUtils.isBlank(entry.getLpsort())) {
            entityExample.setOrderByClause(entry.getLpsort());
        } else {
            entityExample.setOrderByClause("ORDER_NUM ASC ,IDT ASC");
        }

        //只有关键字有值的时候才查询父类的pid|以后改成搜索引擎或者换其它方案，临时解决方案

        List<MetaDataTree> metaDataTrees = metaDataTreeMapper.selectByExample(entityExample);
        List<MetaDataTree> metaDataTreesNew = new ArrayList<>();
        if (metaDataTrees.size() < 20) {
            for (MetaDataTree metaDataTree : metaDataTrees) {
                try {
                    MetaDataTree bak = getMetaDataParent(metaDataTree.getPid());
                    metaDataTree.setpNames(bak.getpNames());
                    metaDataTree.setpIds(bak.getpIds());
                } catch (Exception e) {
                    metaDataTreesNew.add(metaDataTree);
                    e.printStackTrace();
                }
            }

            pager.setPagerInfo(metaDataTreesNew, metaDataTreeMapper.countByExample(entityExample));
        }


        pager.setPagerInfo(metaDataTrees, metaDataTreeMapper.countByExample(entityExample));
        return pager;
    }

    /**
     * @param pid
     * @return
     */
    public MetaDataTree getMetaDataParent(String pid) {

        if (Constant.STRING_0.equalsIgnoreCase(pid)) {
            return new MetaDataTree();
        }
        String pIds = "";
        String pNames = "";
        MetaDataTree metaDataTree = get(pid);
        if (!StrUtils.isBlank(metaDataTree) && !Constant.STRING_0.equalsIgnoreCase(metaDataTree.getPid())) {
            pIds = metaDataTree.getId() + "," + pIds;
            pNames = metaDataTree.getName() + "/" + pNames;

            MetaDataTree metaDataTree1 = get(metaDataTree.getPid());
            //第二次循环
            if (!StrUtils.isBlank(metaDataTree1) && !Constant.STRING_0.equalsIgnoreCase(metaDataTree1.getPid())) {
                pIds = metaDataTree1.getId() + "," + pIds;
                pNames = metaDataTree1.getName() + "/" + pNames;
                MetaDataTree metaDataTree2 = get(metaDataTree1.getPid());
                //第san次循环
                if (!StrUtils.isBlank(metaDataTree2) && !Constant.STRING_0.equalsIgnoreCase(metaDataTree2.getPid())) {
                    pIds = metaDataTree2.getId() + "," + pIds;
                    pNames = metaDataTree2.getName() + "/" + pNames;
                    MetaDataTree metaDataTree3 = get(metaDataTree2.getPid());

                    //第四次
                    if (!StrUtils.isBlank(metaDataTree3) && !Constant.STRING_0.equalsIgnoreCase(metaDataTree3.getPid())) {
                        pIds = metaDataTree3.getId() + "," + pIds;
                        pNames = metaDataTree3.getName() + "/" + pNames;
                        MetaDataTree metaDataTree4 = get(metaDataTree3.getPid());

                        /*******************begin*******************/
                        //第五次
                        if (!StrUtils.isBlank(metaDataTree4) && !Constant.STRING_0.equalsIgnoreCase(metaDataTree4.getPid())) {
                            pIds = metaDataTree4.getId() + "," + pIds;
                            pNames = metaDataTree4.getName() + "/" + pNames;
                            MetaDataTree metaDataTree5 = get(metaDataTree3.getPid());

                        } else {
                            pIds = metaDataTree4.getId() + "," + pIds;
                            pNames = metaDataTree4.getName() + "/" + pNames;
                        }
                        /********************end******************/

                    } else {
                        pIds = metaDataTree3.getId() + "," + pIds;
                        pNames = metaDataTree3.getName() + "/" + pNames;
                    }
                } else {
                    pIds = metaDataTree2.getId() + "," + pIds;
                    pNames = metaDataTree2.getName() + "/" + pNames;
                }

            } else {
                pIds = metaDataTree1.getId() + "," + pIds;
                pNames = metaDataTree1.getName() + "/" + pNames;
            }
        } else {
            pIds = metaDataTree.getId() + "," + pIds;
            pNames = metaDataTree.getName() + "/" + pNames;
        }
        //循环四次｜非递归，防止次数
        metaDataTree.setpIds(pIds);
        metaDataTree.setpNames(pNames);

        return metaDataTree;
    }

    public  List<MetaDataTree>  getLoopPMeta(String metaId){
        //应以数组
        List<MetaDataTree> listMeta=new ArrayList<>();
        String serachId=metaId;
        for(int i=0;i<7;i++){
            MetaDataTree metaDataTree=getMeta(serachId);
            if(!StrUtils.isBlank(metaDataTree)){
                serachId=metaDataTree.getPid();
                listMeta.add(metaDataTree);
            }else {
                break;
            }
        }
                return  listMeta;
    }

    @Override
    public List<Map<String,String>> metaChildMatch(String metaId) {
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //设置分页对象
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();
        criteria.andPidEqualTo(metaId).andStateEqualTo(Constant.NUMBER_1);

        //表只能匹配一次数
        List<MetaDataTree> metaDataTreeChild = metaDataTreeMapper.selectByExample(entityExample);

       if(metaDataTreeChild.size()==0){
           //无子集返回空
           return  null;
       }


        //验证是否已经关联过
        List<String> sourceids=new ArrayList<>();
        for(MetaDataTree  metaDataTreeConn:metaDataTreeChild){
            sourceids.add(metaDataTreeConn.getId());
        }
        RelationDataflowExample relationDataflowExample = new RelationDataflowExample();

        RelationDataflowExample.Criteria criteria1 = relationDataflowExample.createCriteria();

        criteria1.andSourceIdIn(sourceids);

        List<RelationDataflow> relationDataflows = relationDataflowMapper.selectByExample(relationDataflowExample);
        //【只可子集未有任何关联时才能关联】如果有关联关系，则禁止重新匹配，防止覆盖之前操作
        if(relationDataflows.size()>0){
            return  null;
        }

        //定义匹配后的结果
        List<Map<String,String>> matchResult=new ArrayList<>();
        //新增匹配关系
        for(MetaDataTree  metaDataTree:metaDataTreeChild){
            //关联的应该是词库中的内容|添加类型限制条件
           String matchStr=HttpRequest.sendPost(solrTJUrl,"name="+metaDataTree.getName()+"&type=4&searchType=1");
//           String matchStr=HttpRequest.sendGet("http://192.168.26.113:9991/search","name="+metaDataTree.getName()+"&type=4&searchType=1");
           if(!StrUtils.isBlank(matchStr)){
              Map map= JsonUtils.convertJsonStrToMap(matchStr);
              //添加关系并且组装返回前端的字段
               System.out.println(map);

               //初始化结果单个字段返回
               Map<String,String> matchMap=new HashMap<>();
               //元数据名称
               matchMap.put("name",map.get("name").toString());
               //元数据code
               matchMap.put("code",map.get("code").toString());
               //字段名称
               matchMap.put("fieldName",metaDataTree.getName());
               matchMap.put("id",metaDataTree.getId());
               matchMap.put("targetId",map.get("id").toString());
               matchResult.add(matchMap);

               logger.debug("/***新增关系信息**/");
               RelationDataflow relationDataflow=new RelationDataflow();
               relationDataflow.setSourceId(metaDataTree.getId());
               relationDataflow.setTargetId(map.get("id").toString());
               //已经有子集匹配，则不再新增关系
                boolean flay=addMetaRelaction(relationDataflow.getSourceId(),relationDataflow.getTargetId());

                if(flay){
                    logger.info("新增关系成功{},{}",relationDataflow.getSourceId(),relationDataflow.getTargetId());
                }else{
                    logger.info("新增关系失败{},{}",relationDataflow.getSourceId(),relationDataflow.getTargetId());

                }

           }
        }
        return matchResult;
    }
    @Override
    public List<Map<String,String>> metaChildMatchList(String metaId) {
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();
        criteria.andPidEqualTo(metaId).andStateEqualTo(Constant.NUMBER_1);

        //查询该元数据所有的子集
        List<MetaDataTree> metaDataTreeChild = metaDataTreeMapper.selectByExample(entityExample);

      //验证是否已经关联过
        List<String> sourceids=new ArrayList<>();
        for(MetaDataTree  metaDataTreeConn:metaDataTreeChild){
            sourceids.add(metaDataTreeConn.getId());
        }
        RelationDataflowExample relationDataflowExample = new RelationDataflowExample();

        RelationDataflowExample.Criteria criteria1 = relationDataflowExample.createCriteria();

        criteria1.andSourceIdIn(sourceids);

        List<RelationDataflow> relationDataflows = relationDataflowMapper.selectByExample(relationDataflowExample);
        //【只可子集未有任何关联时才能关联】如果有关联关系，则禁止重新匹配，防止覆盖之前操作
        if(relationDataflows.size()>0){
            return  null;
        }

        //定义匹配后的结果
        List<Map<String,String>> matchResult=new ArrayList<>();
        //新增匹配关系
        for(MetaDataTree  metaDataTree:metaDataTreeChild){
            //关联的应该是词库中的内容|添加类型限制条件
           String matchStr=HttpRequest.sendPost(solrTJUrl,"name="+metaDataTree.getName()+"&type=4&searchType=1");
//           String matchStr=HttpRequest.sendGet("http://192.168.26.113:9991/search","name="+metaDataTree.getName()+"&type=4&searchType=1");
           if(!StrUtils.isBlank(matchStr)){
              Map map= JsonUtils.convertJsonStrToMap(matchStr);
              //添加关系并且组装返回前端的字段
               System.out.println(map);

               //初始化结果单个字段返回
               Map<String,String> matchMap=new HashMap<>();
               //元数据名称
               matchMap.put("name",map.get("name").toString());
               //元数据code
               matchMap.put("code",map.get("code").toString());
               //字段名称
               matchMap.put("fieldName",metaDataTree.getName());
               matchMap.put("id",metaDataTree.getId());
               matchMap.put("targetId",map.get("id").toString());
               matchResult.add(matchMap);

               logger.debug("/***新增关系信息**/");
               RelationDataflow relationDataflow=new RelationDataflow();
               relationDataflow.setSourceId(metaDataTree.getId());
               relationDataflow.setTargetId(map.get("id").toString());
               //已经有子集匹配，则不再新增关系
                boolean flay=addMetaRelaction(relationDataflow.getSourceId(),relationDataflow.getTargetId());

                if(flay){
                    logger.info("新增关系成功{},{}",relationDataflow.getSourceId(),relationDataflow.getTargetId());
                }else{
                    logger.info("新增关系失败{},{}",relationDataflow.getSourceId(),relationDataflow.getTargetId());

                }

           }
        }
        return matchResult;
    }

    @Override
    public List<Map<String, String>> metaCommend(String keyWord) {
//        MetaDataTree  metaDataTree=getMeta(metaId);
        //定义匹配后的结果
        List<Map<String,String>> matchResult=new ArrayList<>();

        String matchStr=HttpRequest.sendPost(solrTJUrl,"name="+keyWord+"&type=4");

        if(!StrUtils.isBlank(matchStr)) {
            Map mapData = JsonUtils.convertJsonStrToMap(matchStr);
            //添加关系并且组装返回前端的字段

            //如果状态不为200，则返回null
            if(!"200".equalsIgnoreCase(mapData.get("code")+"")){
                return null;
            }
            List<Map> mapList=(List<Map>)mapData.get("result");
            for(Map map:mapList){
                System.out.println(map);
                //初始化结果单个字段返回
             Map<String, String> matchMap = new HashMap<>();
            //元数据名称
            matchMap.put("name", map.get("name").toString());
            //元数据code
            matchMap.put("code", map.get("code").toString());
            //字段名称
            matchMap.put("targetId", map.get("id").toString());
            matchResult.add(matchMap);

            }
        }
        return matchResult;
    }

    public Pager<MetaDataTree> getPageListAsyn(MetaDataTree entry, Pager pager) {
        logger.debug(TextUtils.format("根据条件,查询列表【分页方法】"));
        //初始化Example
        MetaDataTreeExample entityExample = new MetaDataTreeExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        MetaDataTreeExample.Criteria criteria = entityExample.createCriteria();

        //如果菜单状态不为空，则根据菜单状态查询菜单列表
        if (!StrUtils.isBlank(entry.getState())) {

            criteria.andStateEqualTo(entry.getState());
        } else {
//            criteria.andStateEqualTo(Constant.NUMBER_1);
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPid())) {
            criteria.andPidEqualTo(entry.getPid());
        }
        //父类id一下的菜单
        if (!StrUtils.isBlank(entry.getPcode())) {
            criteria.andPcodeEqualTo(entry.getPcode());
        }
        if (!StrUtils.isBlank(entry.getCode())) {
            criteria.andCodeEqualTo(entry.getCode());
        }
        if (!StrUtils.isBlank(entry.getType())) {
            criteria.andTypeEqualTo(entry.getType());
        }
        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike("%" + entry.getName() + "%");
        }

        // 【注意：某个实体类可增加lpSort字段，可与前台字段排序结合】
        if (!StrUtils.isBlank(entry.getLpsort())) {
            entityExample.setOrderByClause(entry.getLpsort());
        } else {
            entityExample.setOrderByClause("ORDER_NUM ASC ,IDT ASC");
        }
        List<MetaDataTree> metaDataTrees = metaDataTreeMapper.selectByExample(entityExample);
        //如果为空则，返回null
        if(metaDataTrees.size()==0){
            return  null;
        }

        //todo 初始化是否含有下级
        List<String> pids = new ArrayList<>();
        for (MetaDataTree metaDataTree : metaDataTrees) {
            pids.add(metaDataTree.getId());
        }
        List<Map<String, Object>> maps = metaDataTreeMapper.selectIfHasChild(pids);
        //重新组装:map<pid,num>
        Map<String, Object> pidsMap = new HashMap<>();
        for (Map map : maps) {
            pidsMap.put(map.get("pid") + "", map.get("num"));
        }

        List<MetaDataTree> newMetaDataTrees = new ArrayList<>();
        for (MetaDataTree metaDataTree : metaDataTrees) {
            metaDataTree.setHasChild(pidsMap.containsKey(metaDataTree.getId()) ? "1" : "0");

            /**
             * 初始化| 所有的上级层级节点  之后改成solr，减少数据库操作
             */
            MetaDataTree bak = getMetaDataParent(metaDataTree.getPid());

            //如果是数据库，则需要初始化connDBSourceId
            if("M_REL_DB".equals(metaDataTree.getConnModelCode())){
                RelationDataflow relationDataflow=new RelationDataflow();
                relationDataflow.setSourceId(metaDataTree.getId());
                relationDataflow.setFlowType(Constant.NUMBER_3);
                List<RelationDataflow> dataflows=getRelationMetaList(relationDataflow);
                if(dataflows.size()>0){
                    metaDataTree.setConnDBSourceId(dataflows.get(0).getTargetId());
                }
            }

            metaDataTree.setpNames(bak.getpNames());
            metaDataTree.setpIds(bak.getpIds());

            newMetaDataTrees.add(metaDataTree);
        }
        pager.setPagerInfo(newMetaDataTrees, metaDataTreeMapper.countByExample(entityExample));

        return pager;
    }

    @Override
    public boolean delTemplate(String id) {
        String[] ids = id.split(Constant.DHAO);
        //判断该元模板数组中是否有元模板含有元数据关系
        for (String did : ids) {
            RelationDataflowExample relationDataflowExample = new RelationDataflowExample();
            relationDataflowExample.createCriteria().andSourceIdEqualTo(did);
            List<RelationDataflow> relationDataflows = relationDataflowMapper.selectByExample(relationDataflowExample);
            //如果有元模板含有元数据关系，则驳回全部删除申请
            if (Constant.NUMBER_0 != relationDataflows.size()) {
                return false;
            }
        }
        //如果没有，则删除全部元模板
        for (String s : ids) {
            MetaDataTreeExample metaDataTreeExample = new MetaDataTreeExample();
            metaDataTreeExample.createCriteria().andIdEqualTo(s);
            return metaDataTreeMapper.deleteByExample(metaDataTreeExample) == 1 ? true : false;
        }
        return true;
    }

    public Pager<RelationDataflow> getPageRelationMetaList(RelationDataflow entry, Pager pager) {
        logger.debug(TextUtils.format("根据条件,查询RelationDataflow列表【分页方法】"));
        //初始化Example
        RelationDataflowExample entityExample = new RelationDataflowExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        RelationDataflowExample.Criteria criteria = entityExample.createCriteria();

        if (!StrUtils.isBlank(entry.getKeyWords())) {
            entityExample.or().andNameLike("%" + entry.getKeyWords() + "%").
                    andSourceIdEqualTo(entry.getSourceId());

            entityExample.or().andCodeEqualTo(entry.getKeyWords()).
                    andSourceIdEqualTo(entry.getSourceId());
        } else {

            if (!StrUtils.isBlank(entry.getSourceId())) {
                criteria.andSourceIdEqualTo(entry.getSourceId());
            }
            //getTargetId
            if (!StrUtils.isBlank(entry.getTargetId())) {
                criteria.andTargetIdEqualTo(entry.getTargetId());
            }

        }
        List<RelationDataflow> menus = relationDataflowMapper.selectByExample(entityExample);

        pager.setPagerInfo(menus, relationDataflowMapper.countByExample(entityExample));

        return pager;
    }


    /**
     * 根据条件  获取RelationDataflow集合
     *
     * @param entry
     * @return
     */
    public List<RelationDataflow> getRelationMetaList(RelationDataflow entry) {
        logger.debug(TextUtils.format("根据条件,查询RelationDataflow列表"));
        //初始化Example
        RelationDataflowExample entityExample = new RelationDataflowExample();
        //创建查询条件
        RelationDataflowExample.Criteria criteria = entityExample.createCriteria();

        if (!StrUtils.isBlank(entry.getSourceId())) {
            criteria.andSourceIdEqualTo(entry.getSourceId());
        }
        //getTargetId
        if (!StrUtils.isBlank(entry.getTargetId())) {
            criteria.andTargetIdEqualTo(entry.getTargetId());
        }
        //根据类型查询
        if (!StrUtils.isBlank(entry.getFlowType())) {
            criteria.andFlowTypeEqualTo(entry.getFlowType());
        }
        List<RelationDataflow> relationDataflows = relationDataflowMapper.selectByExample(entityExample);

        return relationDataflows;
    }

    @Override
    public boolean addMetaRelaction(String sourceId, String targetIds) {
        //获取已经存在 ids
        List<String> targetIdList = new ArrayList<>();
        RelationDataflowExample relationDataflowExample = new RelationDataflowExample();
        relationDataflowExample.createCriteria().andSourceIdEqualTo(sourceId);
        List<RelationDataflow> targetList = relationDataflowMapper.selectByExample(relationDataflowExample);
        for (int n = 0; n < targetList.size(); n++) {
            targetIdList.add(targetList.get(n).getTargetId());
        }
        logger.info("targetIdList:{}", targetIdList.toString());


        String[] targetIdAdd = targetIds.split(",");

        for (int m = 0; m < targetIdAdd.length; m++) {
            String tid = targetIdAdd[m];
            if (StrUtils.isBlank(tid) || targetIdList.contains(tid)) {
                continue;
            }
            RelationDataflow relationDataflow = new RelationDataflow();
            relationDataflow.setSourceId(sourceId);
            relationDataflow.setTargetId(tid);
            relationDataflow.setState(Constant.NUMBER_1);
            relationDataflowMapper.insertSelective(relationDataflow);
        }

        return true;
    }

    /**
     * 新增元数据关系
     * @param sourceId
     * @param targetId
     * @return
     */
    @Override
    public boolean addMetaDBRelaction(RelationDataflow relationDataflow) {
        //获取已经存在 relationDataflow
        RelationDataflowExample relationDataflowExample = new RelationDataflowExample();
        relationDataflowExample.createCriteria().andSourceIdEqualTo(relationDataflow.getSourceId()).
                andTargetIdEqualTo(relationDataflow.getTargetId());
        List<RelationDataflow> targetList = relationDataflowMapper.selectByExample(relationDataflowExample);
        if(targetList.size()>0){
            logger.error("已经存在关联关系，不可新增");
            return false;
        }
        relationDataflowMapper.insertSelective(relationDataflow);
        return true;
    }

    public boolean delMetaRelation(String sourceId, String targetId) {
        RelationDataflowExample relationDataflowExample = new RelationDataflowExample();
        relationDataflowExample.createCriteria().andSourceIdEqualTo(sourceId).andTargetIdEqualTo(targetId);
        return relationDataflowMapper.deleteByExample(relationDataflowExample) == 1 ? true : false;
    }


}
