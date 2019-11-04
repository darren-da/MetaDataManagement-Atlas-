package com.gla.datacenter.controller;

import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.service.ResourceCateApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 资源目录系统(注册到DSB项目中的相关接口)
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/20 10:44
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ResourceCateApiController {

    private Logger log = LoggerFactory.getLogger(ResourceCateApiController.class);

    @Autowired
    private ResourceCateApiService resourceCateApiService;

    @RequestMapping(value = "test",produces="text/plain")
    public String say(){
        return "ok";
    }

    /**
     *
     * 功能描述: 根据code获取上线的资源目录
     *
     * @param: 
     * @param code
     * @return: java.util.List<com.gla.datacenter.domain.RcsResourceCate>
     * @author: zhangbo
     * @date: 2019/3/26 15:49
     */
    @RequestMapping(value = "/remote/resource/code")
    public List<RcsResourceCate> getResourceCatalogByCodes(@RequestParam("code") String[] code){
        return resourceCateApiService.getResourceCatalogByCodes(code);
    }

    /**
     *
     * 功能描述: 根据code集合获取列表数据(分页)
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/1 15:41
     */
    @RequestMapping(value = "/remote/resource/page/code")
    public String getResourcePageListByResourceCode(@RequestBody RcsResourceCate rcsResourceCate){
        return resourceCateApiService.getResourcePageListByResourceCode(rcsResourceCate,rcsResourceCate.getPager());
    }

    /**
     *
     * 功能描述: 欢迎页统计五大基础库的目数据量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 10:11
     */
    @RequestMapping(value = "/remote/resource/foundational")
    public String getFoundationalLibraryCatalog(){
        return resourceCateApiService.getFoundationalLibraryCatalog();
    }

    /**
     *
     * 功能描述: 欢迎页统计三大类的项数量
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/11 11:23
     */
    @RequestMapping(value = "/remote/resource/three/foundational")
    public String getThreeLibraryCatalog(){
        return resourceCateApiService.getThreeLibraryCatalog();
    }

    /**
     *
     * 功能描述: 欢迎页统计目录个数
     *
     * @param:
     * @return: java.lang.Integer
     * @author: zhangbo
     * @date: 2019/4/11 14:16
     */
    @RequestMapping(value = "/remote/resource/count")
    public Integer getResourceCOunt(){
        return resourceCateApiService.getResourceCOunt();
    }


    @RequestMapping(value = "/remote/resource/pcodes")
    public Map<String, Object> getResourcePcodesByCode(@RequestParam("codes") String[] codes){
        return resourceCateApiService.getResourcePcodesByCode(codes);
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
