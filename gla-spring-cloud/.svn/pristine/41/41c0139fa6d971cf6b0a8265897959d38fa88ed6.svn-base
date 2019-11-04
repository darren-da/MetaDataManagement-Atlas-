package com.gla.datacenter.controller;

import com.gla.datacenter.domain.DBSource;
import com.gla.datacenter.domain.MetaDataTree;
import com.gla.datacenter.domain.RelationDataflow;
import com.gla.datacenter.service.DBSourceService;
import com.gla.datacenter.service.ETLService;
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

/**
 * @Description: etl 控制层
 * @Author: zzh
 * @Modified By:
 */
@RestController
@RequestMapping("/etl")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ETLController {
    private Logger logger = LoggerFactory.getLogger(ETLController.class);

    @Autowired
    DBSourceService dbSourceService;

    @Autowired
    MetaDataTreeService metaDataTreeService;

    @Autowired
    ETLService etlService;

    /**
     * 设置默认页面显示的条数
     */
    public static final Integer DEFAULT_ROW = 10;


    @RequestMapping(value = "/loadTable", method = RequestMethod.POST)
    @Access(privilege = false, login = true, operationLog = OPERATION.INSERT, operationIntro = "新增信息")
    public String saveMeta(String nodeId) {
        etlService.loadDBTable(nodeId);
        return Result.Success().getJson();
    }

    /**
     * 功能描述: 测试连接
     *
     * @param dbSource 配置信息
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/5/6 15:32
     */
    @RequestMapping(value = "/testConn", method = RequestMethod.GET)
    @Access(privilege = false, login = true, operationLog = OPERATION.INSERT, operationIntro = "测试连接")
    public String testConn(DBSource dbSource) {
        boolean flay = etlService.testConn(dbSource);
        if (flay) {
            return Result.Success().getJson();
        } else {
            return Result.Error().getJson();
        }
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
