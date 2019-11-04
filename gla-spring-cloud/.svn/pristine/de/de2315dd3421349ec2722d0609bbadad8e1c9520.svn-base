package com.gla.datacenter.service;

import com.gla.datacenter.domain.Dept;
import com.gla.datacenter.service.fallback.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author:shinians email:shiniandate@163.com
 * @date:Created in 19:43 2018/9/23
 * @modified By:
 * @Description:
   根据已经有的MessageClientService接口新建一个实现了FallbackFactory接口的类MessageClientServiceFallbackFactory
 */
@FeignClient(value = "DATACENTER-GATEWAY",path = "/api4",fallbackFactory=DeptClientServiceFallbackFactory.class)
//@RequestMapping("/api4")
public interface DeptClientService {

    /**
     * 新增部门
     * @param dept 部门相关信息
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/dept",method= RequestMethod.POST)
    public String saveDept(@RequestBody Dept dept);

    /**
     * 删除部门（批量）
     * @param id
     * @return
     */
    @RequestMapping(value = "/dept/{id}",method= RequestMethod.DELETE)
    public String delDept(@PathVariable("id") String id);

    /**
     * 更新部门信息
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept",method= RequestMethod.PUT)
    public String updateDept(@RequestBody Dept dept);

    /**
     * 更新部门状态(启用、禁用部门)
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value = "/dept/{id}/state/{state}",method= RequestMethod.PUT)
    public String updateDeptState(@PathVariable("id") String id, @PathVariable("state") String state);

    /**
     * 获取部门信息根据部门id
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/dept/{id}",method= RequestMethod.GET)
    public String selectDept(@PathVariable("id") String id);

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    @RequestMapping(value = "/depts")
    public String selectDeptList(@RequestBody Dept dept);

    /**
     *
     * 功能描述: 远程更新部门表数据
     *
     * @param: 
     * @param mapList
     * @return: int
     * @author: zhangbo
     * @date: 2019/8/6 14:13
     */
    @RequestMapping(value = "/remote/dept/update")
    int insertDeptByList(@RequestBody List<Map<String, Object>> mapList);
}
