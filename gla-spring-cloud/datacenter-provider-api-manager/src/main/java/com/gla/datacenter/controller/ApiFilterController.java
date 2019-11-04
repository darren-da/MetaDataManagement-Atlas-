package com.gla.datacenter.controller;

import com.gla.datacenter.domain.FilterInformationApi;
import com.gla.datacenter.service.ApiFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangbo
 * @Date: 2019/1/2 11:02
 * @Description:
 */
@CrossOrigin
@RestController
public class ApiFilterController {

    @Autowired
    private ApiFilterService apiFilterService;

    /**
     *
     * 功能描述: 分别获取生产者黑白名单总数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2019/1/2 11:06
     */
    @RequestMapping(value = "/filter/count")
    public String getFilterCount(){
        return apiFilterService.getFilterCount();
    }

    /**
     *
     * 功能描述: 获取api过滤列表(分页)
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/2 11:36
     */
    @RequestMapping(value = "/filter/list")
    public String getFilterPageList(@RequestBody FilterInformationApi filterInformationApi){
        return apiFilterService.getFilterPageList(filterInformationApi,filterInformationApi.getPager());
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
    @RequestMapping(value = "/filter/add")
    public String addApiFilter(@RequestBody FilterInformationApi filterInformationApi){
        return apiFilterService.addApiFilter(filterInformationApi,filterInformationApi.getPager());
    }

    /**
     *
     * 功能描述: 删除API过滤信息(支持批量)
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:52
     */
    @RequestMapping(value = "/filter/delete/{id}/{listType}")
    public String deleteApiFilter(@PathVariable("id") String id,@PathVariable("listType") int listType){
        return apiFilterService.deleteApiFilter(id,listType);
    }
}
