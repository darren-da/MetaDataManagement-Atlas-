package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.Dept;
import com.gla.datacenter.service.DeptClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单信息
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class DeptControllerFeign {
    private Logger LOG = LoggerFactory.getLogger(DeptControllerFeign.class);

    /**
     * 部门管理客户端Service
     */
    @Autowired
    private DeptClientService deptClientService;

    /**
     * 新增部门
     * @param dept 部门相关信息
     * @return 新增成功或失败
     */
    @RequestMapping(value = "/dept", method = RequestMethod.POST)
    @Access(login = true)
    public String saveDept(@RequestBody Dept dept) {
        LOG.debug(TextUtils.format("/***新增部门**/"));
        return this.deptClientService.saveDept(dept);
    }

    /**
     * 删除部门（批量）
     * @param id
     * @return
     */
    @RequestMapping(value = "/dept/{id}", method = RequestMethod.DELETE)
    @Access(login = true)
    public String delDept( @PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***删除部门**/"));
        return this.deptClientService.delDept(id);
    }

    /**
     * 更新部门信息
     * @param dept
     * @return
     */
    @RequestMapping(value = "/dept", method = RequestMethod.PUT)
    @Access(login = true)
    public String updateDept(@RequestBody Dept dept) {
        LOG.debug(TextUtils.format("/***更新部门信息**/"));
        return this.deptClientService.updateDept(dept);
    }

    /**
     * 更新部门状态(启用、禁用部门)
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value = "/dept/{id}/state/{state}", method = RequestMethod.PUT)
    @Access(login = true)
    public String updateDeptState(@PathVariable("id") String id,@PathVariable("state") String state) {
        LOG.debug(TextUtils.format("/***更新部门状态(启用、禁用部门)**/"));
        return this.deptClientService.updateDeptState(id,state);
    }

    /**
     * 获取部门信息根据部门id
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    @Access(login = true)
    public String selectDept(@PathVariable("id") String id) {
        LOG.debug(TextUtils.format("/***获取部门信息根据部门id**/", id));
        return this.deptClientService.selectDept(id);
    }

    /**
     * 查询部门列表
     * @param dept
     * @return
     */
    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @Access(login = true)
    public String selectDeptList(Dept dept) {
        LOG.debug(TextUtils.format("/***根据消息回复id{0}，删除消息记录**/"));
        return this.deptClientService.selectDeptList(dept);
    }

}
