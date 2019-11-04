package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.OperationLog;
import com.limp.framework.boss.domain.OperationSetting;
import com.limp.framework.boss.service.OperationLogService;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 登录日志
 * @author:zhangbo
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class OperationLogController extends BaseController {

    private Logger loger= LoggerFactory.getLogger(OperationLogController.class);

    @Autowired
    private OperationLogService operationLogService;

    /**
     *
     * 功能描述: 获取行为审计日志列表(分页查询)
     *
     * @param: [operationLog]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/19 11:06
     */
    
    @RequestMapping(value = "/operation/log/list",method = RequestMethod.GET)
    public String getOperationList(OperationLog operationLog){
        loger.debug(TextUtils.format("/***查询行为审计日志,返回行为审计日志列表(分页)**/"));
        return operationLogService.getOperationList(operationLog,operationLog.getPager());
    }

    /**
     *
     * 功能描述: 根据id查询行为审计日志
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/23 18:12
     */
    
    @RequestMapping(value = "/operation/log/look/{id}", method = RequestMethod.GET)
    public String getOperationById(@PathVariable("id") String id){
        loger.debug(TextUtils.format("/***根据id查询行为审计日志**/"));
        if(StrUtils.isBlank(id)){
            return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.PARAMS_ERROR,null,null).getJson();
        }
        return operationLogService.getOperationById(id);
    }


    /**
     *
     * 功能描述: 获取行为审计日志设置列表(分页查询)
     *
     * @param: [operationSetting]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/19 14:40
     */
    
    @RequestMapping(value = "/operation/setting/list",method = RequestMethod.GET)
    public String getOperationSettingList(OperationSetting operationSetting){
        loger.debug(TextUtils.format("/***查询行为审计日志设置,返回行为审计日志设置列表(分页)**/"));
        return operationLogService.getOperationSettingList(operationSetting,operationSetting.getPager());
    }

    /**
     *
     * 功能描述: 新增(更新)行为审计日志配置
     *
     * @param: [operationSetting]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/19 16:06
     */
    
    @RequestMapping(value = "/operation/setting/save", method = RequestMethod.POST)
    public String saveOperationSetting(OperationSetting operationSetting){
        loger.debug(TextUtils.format("/***新增行为审计日志配置**/"));
        return operationLogService.saveOperationSetting(operationSetting);
    }

    /**
     *
     * 功能描述: 删除行为审计日志(支持批量删除)
     *
     * @param: [ids]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/19 16:11
     */
    @RequestMapping(value = "/operation/setting/delete/{ids}", method = RequestMethod.DELETE)
    public String deleteOperationSetting(@PathVariable("ids") String ids){
        loger.debug(TextUtils.format("/***删除行为审计日志配置(支持批量删除)**/"));
        return operationLogService.deleteOperationSetting(ids);
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
