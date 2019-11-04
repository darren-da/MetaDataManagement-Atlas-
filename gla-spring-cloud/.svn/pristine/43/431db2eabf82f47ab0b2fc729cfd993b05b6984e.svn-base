package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.PageLog;
import com.limp.framework.boss.service.PageLogService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 操作（page页面级别） 日志
 * @author:XXXX
 * @description:
 * @date:Created in 14:21 2018/10/16
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class PageLogController extends BaseController {

    private Logger logger= LoggerFactory.getLogger(PageLogController.class);

    @Autowired
    PageLogService pageLogService;



    /**
     * 根据条件查询日志列表
     * @param pageLog
     * @return
     */
    @ApiOperation(value="获取日志列表", notes="获取日志列表")
    @RequestMapping(value = "/pageLogs",method= RequestMethod.GET)
    public String selectPageLogPageList(PageLog pageLog) {
        logger.debug(TextUtils.format("/***查询日志,返回日志列表【分页】**/"));
        Pager<PageLog> pageLogPager= pageLogService.getPageLogPageList(pageLog,pageLog.getPager());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pageLogPager,"").getJson();
    }
    /**
     * 新增page日志
     * @param pageLog
     * @return
     */
    @RequestMapping(value = "/pageLogs",method = RequestMethod.POST)
    public String insertLoginLog(@RequestBody PageLog pageLog){
        logger.debug(TextUtils.format("/***新增page日志**/"));
        if(pageLogService.save(pageLog)){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         *  yyyy-MM-dd hh:mm:ss
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }


}
