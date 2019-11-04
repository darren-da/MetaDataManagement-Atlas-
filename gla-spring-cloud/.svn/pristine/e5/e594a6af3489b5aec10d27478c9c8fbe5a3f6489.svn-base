package com.gla.datacenter.controller;

import com.gla.datacenter.domain.ApiCatalogChange;
import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.service.CatalogManagerService;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zhengshien
 * @Date: 2019/3/4 14:43
 * @Description: 数据资源目录管理
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CatalogManagerController {

    @Autowired
    CatalogManagerService catalogManagerService;

    private Logger logger= LoggerFactory.getLogger(AppServiceController.class);

    /**
     * 功能描述: 新增资源目录变更记录
     * @param:
     * @param apiCatalogChange 实体
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/18 14:09
     */
    @RequestMapping(value = "/apiCatalogChange", method = RequestMethod.POST)
    public String saveApiCatalogChange(@RequestBody ApiCatalogChange apiCatalogChange) {
        logger.debug(TextUtils.format("/***新增资源目录变更记录**/"));
        Boolean flay = catalogManagerService.saveApiCatalogChange(apiCatalogChange);
        if (flay) {
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR, "", "").getJson();

    }

    /**
     * 功能描述: 查询资源目录变更记录
     * @param:
     * @param apiCatalogChange 实体
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/4/1 14:22
     */
    @RequestMapping(value = "/apiCatalogChange", method = RequestMethod.GET)
    public String selectApiCatalogChange(@RequestBody ApiCatalogChange apiCatalogChange) {
        logger.debug(TextUtils.format("/***查询资源目录变更记录**/"));
        List list= catalogManagerService.selectApiCatalogChange(apiCatalogChange);
//        if(true){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,list,"").getJson();
//        }
//        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();

    }

}