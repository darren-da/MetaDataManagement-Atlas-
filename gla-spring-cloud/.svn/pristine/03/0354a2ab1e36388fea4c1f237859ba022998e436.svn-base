package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.OrderDetail;
import com.limp.framework.boss.domain.OrderDetailExample;
import com.limp.framework.boss.domain.OrderInfo;
import com.limp.framework.boss.domain.OrderInfoExample;
import com.limp.framework.boss.mapper.oracle.OrderDetailMapper;
import com.limp.framework.boss.mapper.oracle.OrderInfoMapper;
import com.limp.framework.boss.service.OrderInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    private Logger log= LoggerFactory.getLogger(OrderInfoServiceImpl.class);

    /**
     * 注入mapper
     */
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public boolean save(OrderInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增order服务{0}", entry.getId()));
        try {
            return  orderInfoMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public OrderInfo get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据order服务Id{0},获取实体类信息",id));
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(OrderInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug(TextUtils.format("根据order服务Id{0},更新实体类信息",entry.getId()));
        return orderInfoMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("根据order服务Id{0},删除实体类信息", id));
        //逻辑删除
        return  orderInfoMapper.deleteByPrimaryKey(id)== 1?true:false;
    }

    @Override
    public List<OrderInfo> getList(OrderInfo orderInfo) {
        //初始化Example
        OrderInfoExample servicesExample = new OrderInfoExample();

        //创建查询条件
        OrderInfoExample.Criteria criteria = servicesExample.createCriteria();


        //根据订单号
        if (!StrUtils.isBlank(orderInfo.getOrderNo())) {
            criteria.andOrderNoEqualTo(orderInfo.getOrderNo());
        }

        //服务名称
        if (!StrUtils.isBlank(orderInfo.getServiceName())) {
            criteria.andServiceIdEqualTo(orderInfo.getServiceName());
        }

        return  orderInfoMapper.selectByExample(servicesExample);
    }

    @Override
    public Pager<OrderInfo> getPageList(OrderInfo orderInfo, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询services服务列表【分页方法】"));
        //初始化Example
        OrderInfoExample serviceExample = new OrderInfoExample();
        //设置分页对象
        serviceExample.setPage(pager);
        //创建查询条件
        OrderInfoExample.Criteria criteria = serviceExample.createCriteria();


        //根据订单号
        if (!StrUtils.isBlank(orderInfo.getOrderNo())) {
            criteria.andOrderNoEqualTo(orderInfo.getOrderNo());
        }
        //根据订单号ID
        if (!StrUtils.isBlank(orderInfo.getId())) {
            criteria.andIdEqualTo(orderInfo.getId());
        }

        //服务名称
        if (!StrUtils.isBlank(orderInfo.getServiceName())) {
            criteria.andServiceNameEqualTo(orderInfo.getServiceName());
        }

        //如果services服务类型不为空，则根据services服务类型查询services服务列表

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(orderInfo.getLpsort())){
            serviceExample.setOrderByClause(orderInfo.getLpsort());
        }
        List<OrderInfo> servicesList=orderInfoMapper.selectByExample(serviceExample);

        pager.setPagerInfo(servicesList,orderInfoMapper.countByExample(serviceExample));

        return pager;

    }

    @Override
    public Pager<OrderDetail> getPageOrderDetailList(OrderDetail orderDetail, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询servicesParams服务列表【分页方法】"));
        //初始化Example
        OrderDetailExample orderDetailExample = new OrderDetailExample();
        //设置分页对象
        orderDetailExample.setPage(pager);
        //创建查询条件
        OrderDetailExample.Criteria criteria = orderDetailExample.createCriteria();

        //根据服务名称
        if (!StrUtils.isBlank(orderDetail.getOrderNo())) {
            criteria.andOrderNoEqualTo(orderDetail.getOrderNo());
        }

        if(!StrUtils.isBlank(orderDetail.getLpsort())){
            orderDetailExample.setOrderByClause(orderDetail.getLpsort());
        }else{
            orderDetailExample.setOrderByClause("IDT DESC");
        }

        List<OrderDetail> servicesList=orderDetailMapper.selectByExampleWithBLOBs(orderDetailExample);

        pager.setPagerInfo(servicesList,orderDetailMapper.countByExample(orderDetailExample));

        return pager;

    }


}
