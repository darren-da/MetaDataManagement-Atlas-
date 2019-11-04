package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.FilterInformationApi;
import com.gla.datacenter.service.ApiFilterClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.constant.OPERATION;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/24 11:38
 * @Description: api过滤(黑白名单、ip限制)控制器
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
@Api(value = "api限制控制器",description = "api限制控制器")
public class ApiFilterControllerFeign {


    @Autowired
    private ApiFilterClientService apiFilterClientService;

    /**
     *
     * 功能描述: 查询api过滤信息(分页查询)
     *
     * @param: [filterInformationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:54
     */
    @Access(login = true)
    @GetMapping(value = "/filter/list")
    public String getFilterPageList(FilterInformationApi filterInformationApi){
        return apiFilterClientService.getFilterPageList(filterInformationApi);
    }

    /**
     *
     * 功能描述: 分别获取生产者黑白名单总数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2019/1/2 11:00
     */
    @Access(login = true)
    @GetMapping(value = "/filter/count")
    public String getFilterCount(){
        return apiFilterClientService.getFilterCount();
    }

    /**
     *
     * 功能描述: 新增api过滤信息
     *
     * @param: [filterInformationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:53
     */
    @Access(login = true,operationLog = OPERATION.INSERT,operationIntro = "新增黑白名单")
    @PostMapping(value = "/filter/add")
    public String addApiFilter(@RequestBody FilterInformationApi filterInformationApi){
        return apiFilterClientService.addApiFilter(filterInformationApi);
    }

    /**
     *
     * 功能描述: 删除api过滤信息(支持批量)
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:53
     */
    @Access(login = true,operationLog = OPERATION.DELETE,operationIntro = "移除黑白名单")
    @DeleteMapping(value = "/filter/delete/{id}/{listType}")
    public String deleteApiFilter(@PathVariable("id") String id,@PathVariable("listType") int listType){
        return apiFilterClientService.deleteApiFilter(id,listType);
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
