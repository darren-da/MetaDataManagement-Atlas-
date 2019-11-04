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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 元数据管理分析
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/5/15 15:47
 */
@RestController
@RequestMapping("/ana")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AnalysisController {
    private Logger logger= LoggerFactory.getLogger(AnalysisController.class);

    @Autowired
    MetaDataTreeService metaDataTreeService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;



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
     * @return
     */

    @RequestMapping(value = "/outlineNum",method= RequestMethod.GET)
        public String outlineNum( ) {
        logger.debug(TextUtils.format("/***outlineNum**/"));

        //元数据总个数
        MetaDataTree metaDataTree=new MetaDataTree();
        Integer metaNum = metaDataTreeService.selectMetaNumByType(metaDataTree);

        //元模型个数
        MetaDataTree metaModel=new MetaDataTree();
        metaModel.setType(10);
        Integer modelNum = metaDataTreeService.selectMetaNumByType(metaModel);

        //数据库个数
        MetaDataTree metadb=new MetaDataTree();
        metadb.setConnModelCode("M_REL_DB");
        Integer dbNum = metaDataTreeService.selectMetaNumByType(metadb);

        //数据库个数
        MetaDataTree metaApp=new MetaDataTree();
        metaApp.setConnModelCode("M_APP_SYS");
        Integer appNum = metaDataTreeService.selectMetaNumByType(metaApp);

        //表个数
        MetaDataTree metaTable=new MetaDataTree();
        metaTable.setConnModelCode("M_REL_TABLE");
        Integer tableNum = metaDataTreeService.selectMetaNumByType(metaTable);

        //视图个数
        MetaDataTree metaView=new MetaDataTree();
        metaView.setConnModelCode("M_REL_VIEW");
        Integer viewNum = metaDataTreeService.selectMetaNumByType(metaView);

        //字段个数
        MetaDataTree metaField=new MetaDataTree();
        metaField.setConnModelCode("M_REL_FIELD");
        Integer fieldNum = metaDataTreeService.selectMetaNumByType(metaField);

        Map mapNum=new HashMap<String,Integer>();
        mapNum.put("metaNum",metaNum);
        mapNum.put("modelNum",modelNum);
        mapNum.put("dbNum",dbNum);
        mapNum.put("viewNum",viewNum);
        mapNum.put("tableNum",tableNum);
        mapNum.put("appNum",appNum);
        mapNum.put("fieldNum",fieldNum);

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,mapNum,"").getJson();
    }

    /**
     * 业务系统数据统计
     * @return
     */

    @RequestMapping(value = "/outlineApp",method= RequestMethod.GET)
    public String outlineApp( ) {

        List<Map<String,String>> listMap= metaDataTreeService.selectMetaOutLineApp();

        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,listMap,"").getJson();


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
