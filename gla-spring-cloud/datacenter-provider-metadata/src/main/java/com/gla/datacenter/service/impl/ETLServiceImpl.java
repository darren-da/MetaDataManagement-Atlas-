package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.DBSource;
import com.gla.datacenter.domain.MetaDataTree;
import com.gla.datacenter.domain.RelationDataflow;
import com.gla.datacenter.mapper.mysql.DBSourceMapper;
import com.gla.datacenter.service.DBSourceService;
import com.gla.datacenter.service.ETLService;
import com.gla.datacenter.service.MetaDataTreeService;
import com.gla.datacenter.util.JdbcTemplateDynamic;
import com.limp.framework.boss.service.CommandService;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Description:  MetaDataTreeService实现层
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 15:47
 */
@Service
public class ETLServiceImpl implements ETLService {

    private Logger logger= LoggerFactory.getLogger(ETLServiceImpl.class);

    @Autowired
    DBSourceMapper dbSourceMapper;

    @Autowired
    DBSourceService dbSourceService;

    @Autowired
    MetaDataTreeService metaDataTreeService;

    @Autowired
    ETLService  etlService;

    @Autowired
    CommandService commandService;


    @Override
    public boolean loadDBTable(String  nodeId) {

        logger.debug("/***加载数据库表**/");

        /****************通过nodeId动态构建 数据库链接 id***********************/

        RelationDataflow relationDataflow=new RelationDataflow();
        relationDataflow.setSourceId(nodeId);

        //数据库类型关联关系
        relationDataflow.setFlowType(Constant.NUMBER_3);

        List<RelationDataflow> relationDataflowList=metaDataTreeService.getRelationMetaList(relationDataflow);
        DBSource dbSource=null;
        if(relationDataflowList.size()>0){
            dbSource=dbSourceService.get(relationDataflowList.get(0).getTargetId());
        }
        //获取 运行的sql ｜表
        Map<String,String> mapAllTb=new HashMap<>();
        mapAllTb.put("tableSchema",dbSource.getDbCode());
        String runCommand= commandService.getFormatSqlByCode("MD_MYSQL_SELECT_ALL_TABLES",mapAllTb);

        JdbcTemplateDynamic jdbcTemplateDynamic=new JdbcTemplateDynamic(dbSource);
        JdbcTemplate jdbcTemplate =jdbcTemplateDynamic.getJdbcTemplate();

        //调用方法获得list集合
        List<Map<String, Object>> commandTableResultList = jdbcTemplate.queryForList(runCommand);

        /*********************构建表层次****************************/
        //查找表模型
        //M_REL_TABLE_LV
        MetaDataTree  metaDataTree=new MetaDataTree();
        metaDataTree.setCode("M_REL_TABLE_LV");
        metaDataTree.setState(Constant.NUMBER_1);
       List<MetaDataTree> metaDataTrees=metaDataTreeService.getList(metaDataTree);
        if(metaDataTrees.size()==0){
            //不含此模型
            return false;
        }
        //根据表模型构建 表层级
        MetaDataTree  tableMetaTree=loadTableTree(metaDataTrees.get(0),nodeId);
        metaDataTreeService.save(tableMetaTree);

        /*********************构建表实例********************/
        metaDataTree.setCode("M_REL_TABLE");
        List<MetaDataTree> tableModelTb=metaDataTreeService.getList(metaDataTree);
        if(tableModelTb.size()==0){
            //不含此表模型-实例
            return false;
        }

        for(Map map:commandTableResultList){
            //构建表实例
            MetaDataTree metaDataTreeTB=loadTableTreeTb(tableModelTb.get(0),tableMetaTree.getId(),map);
            //保存表
            metaDataTreeService.save(metaDataTreeTB);

            Map<String,String> mapTb=new HashMap<>();
            mapTb.put("tableName",metaDataTreeTB.getCode());
            mapTb.put("tableSchema",dbSource.getDbCode());
            String fieldSql= commandService.getFormatSqlByCode("MD_MYSQL_SELECT_ALL_COLUMN",mapTb);
            List<Map<String, Object>> commandFieldResultList = jdbcTemplate.queryForList(fieldSql);

            /****************初始化某个字段*****************/
            metaDataTree.setCode("M_REL_FIELD");
            List<MetaDataTree> tableModelField=metaDataTreeService.getList(metaDataTree);
            if(tableModelField.size()==0){
                //不含此表模型-实例
                return false;
            }
            for(Map mapField:commandFieldResultList){
                //初始化字段
                MetaDataTree metaDataTreeField= loadTableTreeField(tableModelField.get(0),metaDataTreeTB.getId(),mapField);
                metaDataTreeService.save(metaDataTreeField);
            }
        }
        return true;
    }

    @Override
    public boolean testConn(DBSource dbSource) {
        String url = dbSource.getUrl();
        boolean mysql = url.contains("mysql");
        boolean oracle = url.contains("oracle");
        if (mysql){
            dbSource.setDriverClassName("com.mysql.jdbc.Driver");
        }

        if (oracle){
            dbSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        }

        JdbcTemplateDynamic jdbcTemplateDynamic=new JdbcTemplateDynamic(dbSource);
        JdbcTemplate jdbcTemplate =jdbcTemplateDynamic.getJdbcTemplate();
        try {
            jdbcTemplate.queryForList("SELECT COUNT(*) TABLES, table_schema FROM information_schema.TABLES   WHERE table_schema = 'metadata_db' GROUP BY table_schema;");
            return true;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据 表模型构建 表层级
     * @param tableMetaTreeModel 元模型
     * @param pNodeId  父节点
     * @return
     */
    public  MetaDataTree loadTableTree(MetaDataTree  tableMetaTreeModel,String pNodeId){
        MetaDataTree  tableMetaTree=new MetaDataTree();
        //状态
        tableMetaTree.setState(Constant.NUMBER_1);
        //设置ID,方便下一级别使用
        tableMetaTree.setId(StrUtils.randomUUID());
        //编码，表层次
        tableMetaTree.setCode("TB_"+StrUtils.getOrderNo());
        //父类ID
        tableMetaTree.setPid(pNodeId);
        //图标
        tableMetaTree.setIcon(tableMetaTreeModel.getIcon());
        //表关联模型code
        tableMetaTree.setConnModelCode(tableMetaTreeModel.getCode());

        tableMetaTree.setIntro("表目录");
        tableMetaTree.setName("表");
        return  tableMetaTree;
    }

    /**
     * 初始化表实例
     * @param tableMetaTreeModel
     * @param pNodeId
     * @param map
     * @return
     */
    public  MetaDataTree loadTableTreeTb(MetaDataTree  tableMetaTreeModel,String pNodeId,Map map){
        MetaDataTree  tableMetaTreeTb=new MetaDataTree();
        //状态
        tableMetaTreeTb.setState(Constant.NUMBER_1);
        //设置ID,方便下一级别使用
        tableMetaTreeTb.setId(StrUtils.randomUUID());
        //编码，表层次
        tableMetaTreeTb.setCode(map.get("tableName")+"");
        //父类ID
        tableMetaTreeTb.setPid(pNodeId);
        //图标
        tableMetaTreeTb.setIcon(tableMetaTreeModel.getIcon());
        //表关联模型code
        tableMetaTreeTb.setConnModelCode(tableMetaTreeModel.getCode());

        tableMetaTreeTb.setIntro(map.get("intro")+"");
        String name=StrUtils.isBlank(map.get("comment"))?map.get("tableName")+"":map.get("comment")+"";
        tableMetaTreeTb.setName(name.length()>60?name.substring(0,60)+"...":name);
        return  tableMetaTreeTb;
    }

    /**
     * 初始化字段字段
     * @param tableMetaFieldModel  字段模型
     * @param pNodeId 字段的父类ID
     * @param map 数据库查询字段
     * @return
     */
    public  MetaDataTree loadTableTreeField(MetaDataTree  tableMetaFieldModel,String pNodeId,Map map){
        MetaDataTree  tableMetaTreeField=new MetaDataTree();
        //状态
        tableMetaTreeField.setState(Constant.NUMBER_1);
        //设置ID,方便下一级别使用
        tableMetaTreeField.setId(StrUtils.randomUUID());
        //编码，表层次
        tableMetaTreeField.setCode(map.get("colCode")+"");
        //父类ID
        tableMetaTreeField.setPid(pNodeId);
        //图标
        tableMetaTreeField.setIcon(tableMetaFieldModel.getIcon());
        //表关联模型code
        tableMetaTreeField.setConnModelCode(tableMetaFieldModel.getCode());

        tableMetaTreeField.setIntro(map.get("colName")+"");
        //varchar
        tableMetaTreeField.setTypeName(map.get("colType")+"");
        String name=StrUtils.isBlank(map.get("colName"))?map.get("colCode")+"":map.get("colName")+"";
        tableMetaTreeField.setName(name.length()>60?name.substring(0,60)+"...":name);
        return  tableMetaTreeField;
    }
}
