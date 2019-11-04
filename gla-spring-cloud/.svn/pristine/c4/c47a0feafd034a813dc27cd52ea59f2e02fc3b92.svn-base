package com.gla.datacenter.controller;

import com.gla.datacenter.domain.DBSource;
import com.gla.datacenter.service.DBSourceService;
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

/**
 * @Description: db
 * @Author: zzh
 * @Modified By:
 */
@RestController
@RequestMapping("/db")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DBSourceController {
    private Logger logger= LoggerFactory.getLogger(DBSourceController.class);

    @Autowired
    DBSourceService dbSourceService;

    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    /**
     * 新增信息
     * @param dbSource
     * @return
     */
    @RequestMapping(value = "/dbsource",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增信息")
    public String saveMeta(@RequestBody DBSource dbSource) {
        logger.debug("/***新增信息**/");
        Boolean flay= dbSourceService.save(dbSource);
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
    @RequestMapping(value = "/dbsource/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除信息")
    public String delMenu( @PathVariable("id") String id) {
        logger.debug(TextUtils.format("/***根据id{0}，删除记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!dbSourceService.delete(did)){
                flay=false;
            }
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 更新信息
     * @param  dbSource
     * @return
     */
    @RequestMapping(value = "/dbsource",method= RequestMethod.PUT)
    @Access(privilege =false,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新dbsource信息")
    public String updateDBSource(@RequestBody DBSource dbSource) {
        logger.debug(TextUtils.format("/***更新dbsource信息**/"));
        Boolean flay= dbSourceService.update(dbSource);
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
    public String selectDBSource(Model model, @PathVariable("id") String id) {
        Integer.parseInt(id);
        logger.debug(TextUtils.format("/***根据id{0}，获取基本信息**/", id));
        DBSource dbSource= dbSourceService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,dbSource,"").getJson();
    }

    /**
     * 查询用于列表
     * @param dbSource
     * @return
     */
    @RequestMapping(value = "/dbsource",method= RequestMethod.GET)
    public String selectDBSourceList(DBSource dbSource, Pager pager) {
        logger.debug(TextUtils.format("/***查询DBSource列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<DBSource> dbSourcePager
                = dbSourceService.getPageList(dbSource, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,dbSourcePager,"").getJson();
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
