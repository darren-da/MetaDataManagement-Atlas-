package com.gla.datacenter.service.impl;


import com.gla.datacenter.domain.Dept;
import com.gla.datacenter.domain.DeptExample;
import com.gla.datacenter.mapper.mysql.DeptMapper;
import com.gla.datacenter.service.DeptService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description: 部门相关服务
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/24 11:51
 */
@Service
public class DeptServiceImpl  implements DeptService {
    
    private Logger log = LoggerFactory.getLogger(DeptServiceImpl.class);

    /**
     * 引入Mapper
     */
    @Autowired
    DeptMapper deptMapper;
    
    
    @Override
    public boolean save(Dept entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增部门{0}", entry.getId()));
        try {
            return  deptMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Dept get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据部门Id{0},获取实体类信息",id));
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(Dept entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug(TextUtils.format("根据部门Id{0},更新实体类信息",entry.getId()));
        return deptMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public Boolean updateDeptState(String id,String state) {
        if(StrUtils.isBlank(id)){
            return  false;
        }
        Dept dept = get(id);
        dept.setState(Integer.parseInt(state));
        log.debug(TextUtils.format("根据部门Id{0},修改部门状态（启用、禁用）",id));
        return deptMapper.updateByPrimaryKeySelective(dept)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public int insertDeptByList(List<Map<String, Object>> deptList) {

        //删除dept表数据
        DeptExample ex = new DeptExample();
        DeptExample.Criteria criteria = ex.createCriteria();
        criteria.andCodeNotEqualTo(Constant.STRING_0);
        int num = 0;
        try {
            deptMapper.deleteByExample(ex);
            num = deptMapper.insertDeptByList(deptList);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("远程删除dept/新增dept数据失败!");
            return 0;
        }
        return num;
    }

    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("根据部门Id{0},删除实体类信息", id));
        //逻辑删除
        Dept dept=new Dept();
        dept.setId(id);
        dept.setState(Integer.parseInt(Constant.STRING_DEL_STATE) );
        return  deptMapper.updateByPrimaryKeySelective(dept)== 1?true:false;
    }

    @Override
    public List<Dept> getList(Dept dept) {
        //初始化Example
        DeptExample userExample = new DeptExample();

        //创建查询条件
        DeptExample.Criteria userCriteria = userExample.createCriteria();

        //如果部门状态不为空，则更具部门状态查询部门列表
        if (!StrUtils.isBlank(dept.getState())) {
            userCriteria.andStateEqualTo(dept.getState());
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(dept.getId())) {
            userCriteria.andIdEqualTo(dept.getId());
        }
        //根据父id查询
        if (!StrUtils.isBlank(dept.getParentId())) {
            userCriteria.andParentIdEqualTo(dept.getParentId());
        }
        //根据编码精确查询
        if (!StrUtils.isBlank(dept.getCode())) {
            userCriteria.andCodeEqualTo(dept.getCode());
        }
        //根据名称模糊查询
        if (!StrUtils.isBlank(dept.getName())) {
            userCriteria.andNameLike("%"+dept.getName()+"%");
        }
        return  deptMapper.selectByExample(userExample);
    }

    @Override
    public Pager<Dept> getPageList(Dept dept, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询部门列表【分页方法】"));
        //初始化Example
        DeptExample userExample = new DeptExample();
        //设置分页对象
        userExample.setPage(pager);
        //创建查询条件
        DeptExample.Criteria userCriteria = userExample.createCriteria();

        //如果部门状态不为空，则更具部门状态查询部门列表
        if (!StrUtils.isBlank(dept.getState())) {
            userCriteria.andStateEqualTo(dept.getState());
        }
        //根据账号精确查询
        if (!StrUtils.isBlank(dept.getId())) {
            userCriteria.andIdEqualTo(dept.getId());
        }
        //根据父id查询
        if (!StrUtils.isBlank(dept.getParentId())) {
            userCriteria.andParentIdEqualTo(dept.getParentId());
        }
        //根据编码精确查询
        if (!StrUtils.isBlank(dept.getCode())) {
            userCriteria.andCodeEqualTo(dept.getCode());
        }
        //根据名称模糊查询
        if (!StrUtils.isBlank(dept.getName())) {
            userCriteria.andNameLike("%"+dept.getName()+"%");
        }
        List<Dept> users=deptMapper.selectByExample(userExample);

        pager.setPagerInfo(users,deptMapper.countByExample(userExample));

        return pager;

    }

}
