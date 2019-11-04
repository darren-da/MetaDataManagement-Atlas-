package com.gla.datacenter.controller;

import com.gla.datacenter.domain.MetaDataTree;
import com.gla.datacenter.domain.RelationDataflow;
import com.gla.datacenter.service.MetaDataTreeService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 元数据管理Tree
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/26 15:47
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MetaDataTreeController {
    private Logger logger= LoggerFactory.getLogger(MetaDataTreeController.class);

    @Autowired
    MetaDataTreeService metaDataTreeService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    /**
     * 新增信息
     * @param metaDataTree
     * @return
     */
    @RequestMapping(value = "/metaDataTree",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增信息")
    public String saveMeta(@RequestBody MetaDataTree metaDataTree) {
        logger.debug("/***新增信息**/");
        Boolean flay= metaDataTreeService.save(metaDataTree);
        //如果新增数据库dbresource不为空则新增元数据和数据的关系

        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 新增元模版信息
     * @param metaDataTree
     * @return
     */
    @RequestMapping(value = "/metaDataTreeYmb",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增元模版信息")
    public String saveMetaYmb(@RequestBody MetaDataTree metaDataTree) {
        logger.debug("/***新增元模版信息**/");
        System.out.println(metaDataTree);
        Boolean flay= metaDataTreeService.saveMetaDataTreeYmb(metaDataTree);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 修改元模版信息
     * @param metaDataTree
     * @return
     */
    @RequestMapping(value = "/metaDataTreeYmb",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "修改元模版信息")
    public String updateMetaYmb(@RequestBody MetaDataTree metaDataTree) {
        logger.debug("/***修改元模版信息**/");
        System.out.println(metaDataTree);
        Boolean flay= metaDataTreeService.updateMetaDataTreeYmb(metaDataTree);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/metaDataTree/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除信息")
    public String delMenu( @PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据id{0}，删除记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!metaDataTreeService.delete(did)){
                flay=false;
            }
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除元模板
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/metaDataTree/template/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除信息")
    public String delTemplate( @PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据id{0}，删除记录**/", id));

        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        boolean flay;
        if (!StrUtils.isBlank(id)) {
            flay = metaDataTreeService.delTemplate(id);
        }else {
            flay =false;
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除元数据关系
     * @param relationDataflow sourceId  源目标ID targetIds 关联的IDs
     * @return
     */
    @RequestMapping(value = "/delMetaRelation")
    @Access(login = true,operationIntro = "删除信息")
    public String delMetaRelation(@RequestBody RelationDataflow relationDataflow) {

        logger.debug(TextUtils.format("/***根据id{0}，删除记录**/", relationDataflow.getSourceId()));
        //不可为空
        if(StrUtils.isBlank(relationDataflow.getSourceId())||StrUtils.isBlank(relationDataflow.getTargetIds())){
            return Result.Error().getJson();
        }
        String []ids=relationDataflow.getTargetIds().split(Constant.DHAO);
        if(ids.length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!metaDataTreeService.delMetaRelation(relationDataflow.getSourceId(),did)){
                flay=false;
            }
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 更新信息（更新版本）
     * @param  metaDataTree
     * @return
     */
    @RequestMapping(value = "/metaDataTree",method= RequestMethod.PUT)
    @Access(privilege =false,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新metadata信息")
    public String updateMetaDataTree(@RequestBody MetaDataTree metaDataTree) {
        logger.debug(TextUtils.format("/***更新信息**/"));
        Boolean flay= metaDataTreeService.update(metaDataTree);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 更新信息（还原至此版本）
     * @param  metaDataTree
     * @return
     */
    @RequestMapping(value = "/metaDataTree/version",method= RequestMethod.PUT)
    @Access(privilege =false,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新metadata信息")
    public String updateVersion(@RequestBody MetaDataTree metaDataTree) {
        logger.debug(TextUtils.format("/***更新信息**/"));
        Boolean flay= metaDataTreeService.updateVersion(metaDataTree);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 获取信息根据id
     * @param model
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/metaDataTree/{id}",method= RequestMethod.GET)
    public String selectMetaDataTree(Model model, @PathVariable("id") String id) {
//        Integer.parseInt(id);
        logger.debug(TextUtils.format("/***根据id{0}，获取基本信息**/", id));
        MetaDataTree metaDataTree= metaDataTreeService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTree,"").getJson();
    }
    /**
     * 查询用于列表
     * @param metaDataTree
     * @return
     */

    @RequestMapping(value = "/metaDataTree",method= RequestMethod.GET)
        public String selectMenuList(MetaDataTree metaDataTree,Pager pager) {
        logger.debug(TextUtils.format("/***查询metadata列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<MetaDataTree> metaDataTreePager
                = metaDataTreeService.getPageList(metaDataTree, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTreePager,"").getJson();
    }

    /**
     * 功能描述: 统计分析一（左侧数据量统计栏）
     * @param:
     * @param metaDataTree 通过connModelCode传递多个参数，用逗号隔开，参数为对应数据栏的编码，
     *                     如：数据库--M_REL_DB，元数据总个数无需传参，默认返回
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/5/14 10:41
     */
    @RequestMapping(value = "/analysis/statistics/one",method= RequestMethod.GET)
        public String analysisStatistics(MetaDataTree metaDataTree) {
        logger.debug(TextUtils.format("/***查询metadata列表**/"));
        String result = metaDataTreeService.analysisStatisticsOne(metaDataTree);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,result,"").getJson();
    }

    /**
     * 功能描述: 查询版本管理列表
     * @param:
     * @param metaDataTree
     * @param pager
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/5/9 11:30
     */
    @RequestMapping(value = "/metaDataTree/version",method= RequestMethod.GET)
    public String selectVersionList(MetaDataTree metaDataTree,Pager pager) {
        logger.debug(TextUtils.format("/***查询版本列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<MetaDataTree> metaDataTreePager
                = metaDataTreeService.getPageListVersion(metaDataTree, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTreePager,"").getJson();
    }

    /**
     * 异步获取左侧元数据数｜供左侧数使用
     * @param metaDataTree
     * @param pager
     * @return
     */
    @RequestMapping(value = "/metaDataTreeAsyn",method= RequestMethod.GET)
    public String selectMetaTreeAsyn(MetaDataTree metaDataTree,Pager pager) {
        logger.debug("/**异步查询metaDataTree列表**/");
        //需要含有父类ID|
        if(StrUtils.isBlank(metaDataTree.getPid())){
            return  Result.Error().getJson();
        }
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<MetaDataTree> metaDataTreePager
                = metaDataTreeService.getPageListAsyn(metaDataTree, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTreePager,"").getJson();
    }

    /**
     * 新增关系
     * @param relationDataflow sourceId 源 targetIds 目标ID
     * @return
     */
    @RequestMapping(value = "/metaRelation",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增信息")
    public String saveMeta(@RequestBody RelationDataflow relationDataflow) {
        if(StrUtils.isBlank(relationDataflow.getSourceId())||StrUtils.isBlank(relationDataflow.getTargetIds())){
            return Result.Error().getJson();
        }
        logger.debug("/***新增信息**/");
        Boolean flay= metaDataTreeService.addMetaRelaction(relationDataflow.getSourceId(),relationDataflow.getTargetIds());
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 获取资源目录关系
     * @param relationDataflow
     * @param pager
     * @return
     */
    @RequestMapping(value = "/metaRelations",method= RequestMethod.GET)
    public String selectMenuList(RelationDataflow relationDataflow, Pager pager) {
        logger.debug(TextUtils.format("/***查询RelationDataflow列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<RelationDataflow> relationDataflowPager
                = metaDataTreeService.getPageRelationMetaList(relationDataflow, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,relationDataflowPager,"").getJson();
    }

    /**
     * 血统关系：某个节点的上级
     * @param id
     * @return
     */
    @RequestMapping(value = "/metaRelationBlood",method= RequestMethod.GET)
    public String selectrelation(String  id) {
        logger.debug(TextUtils.format("/***查询血统关系列表**/"));
        List<MetaDataTree> metaDataTrees
                = metaDataTreeService.getLoopPMeta(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTrees,"").getJson();
    }

    /**
     * 智能匹配表下所有字段关系【solr库】
     * @param id
     * @return
     */
    @RequestMapping(value = "/metaChildMatch",method= RequestMethod.GET)
    public String metaChildMatch(String  id) {
        logger.debug(TextUtils.format("/***查询血统关系列表**/"));
        List<Map<String,String>> metaDataTrees
                = metaDataTreeService.metaChildMatch(id);
        if(metaDataTrees==null||metaDataTrees.size()==0){
            return Result.getInstance(ResultCode.ERROR.toString(), "无子集/子集已关联","","").getJson();

        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTrees,"").getJson();
    }

    @RequestMapping(value = "/metaChildMatchList",method= RequestMethod.GET)
    public String metaChildMatchList(String  id) {
        logger.debug(TextUtils.format("/***查询血统关系列表**/"));
        List<Map<String,String>> metaDataTrees
                = metaDataTreeService.metaChildMatch(id);
        if(metaDataTrees==null||metaDataTrees.size()==0){
            return Result.getInstance(ResultCode.ERROR.toString(), "无子集/子集已关联","","").getJson();

        }
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTrees,"").getJson();
    }

    /**
     * 传入关键词，推荐20条相关元数据
     * @param keyWord
     * @return
     */
    @RequestMapping(value = "/metaCommend",method= RequestMethod.GET)
    public String metaCommend(String  keyWord) {
        logger.debug(TextUtils.format("/***推荐信息**/"));
        List<Map<String,String>> metaDataTrees
                = metaDataTreeService.metaCommend(keyWord);

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,metaDataTrees,"").getJson();
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
    }

}
