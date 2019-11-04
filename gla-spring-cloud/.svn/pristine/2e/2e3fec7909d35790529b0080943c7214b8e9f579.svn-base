package com.gla.datacenter.service;


import com.gla.datacenter.domain.FilterInformationApi;
import com.gla.datacenter.service.fallback.ApiFilterClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "DATACENTER-GATEWAY",path = "/api6",fallbackFactory=ApiFilterClientServiceFallbackFactory.class)
//@RequestMapping("/api6")
public interface ApiFilterClientService {


    /**
     *
     * 功能描述: 查询api过滤信息(分页查询)
     *
     * @param: [filterInformationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:54
     */
    @RequestMapping(value = "/filter/list")
    String getFilterPageList(@RequestBody FilterInformationApi filterInformationApi);

    /**
     *
     * 功能描述: 分别获取生产者黑白名单总数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2019/1/2 11:01
     */
    @RequestMapping(value = "/filter/count")
    String getFilterCount();

    /**
     *
     * 功能描述: 新增api过滤信息
     *
     * @param: [filterInformationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:54
     */
    @RequestMapping(value = "/filter/add")
    String addApiFilter(@RequestBody FilterInformationApi filterInformationApi);

    /**
     *
     * 功能描述: 删除api过滤信息(支持批量)
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/24 14:54
     */
    @RequestMapping(value = "/filter/delete/{id}/{listType}")
    String deleteApiFilter(@PathVariable("id") String id,@PathVariable("listType") int listType);
}
