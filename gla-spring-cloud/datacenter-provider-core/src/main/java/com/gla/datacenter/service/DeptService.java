package com.gla.datacenter.service;

import com.gla.datacenter.domain.Dept;
import com.limp.framework.core.abs.AbstractService;

import java.util.List;
import java.util.Map;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/24 11:51
 */
public interface DeptService extends AbstractService<Dept> {
    Boolean updateDeptState(String id, String state);

    int insertDeptByList(List<Map<String, Object>> deptList);
}
