package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.OrderDetail;
import com.gla.datacenter.domain.OrderDetailExample;
import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.domain.OrderInfoExample;
import com.gla.datacenter.mapper.mysql.OrderDetailMapper;
import com.gla.datacenter.mapper.mysql.OrderInfoMapper;
import com.gla.datacenter.service.OrderInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    private Logger log= LoggerFactory.getLogger(OrderInfoServiceImpl.class);

  /*  @Autowired
    RabbitTemplate rabbitTemplate;*/

    @Autowired
    private RedisTemplate  StrRedisTemplate;

  /*  @Autowired
    private MessageClientService messageClientService;*/


    /**
     * mapper 注入
     */
    @Autowired
    private OrderInfoMapper  orderInfoMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;



    @Override
    public boolean save(OrderInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增订单信息id:{0},订单号:{0}", entry.getId(),entry.getOrderNo()));
        try {
            return  orderInfoMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error("新增订单异常--->"+e.getMessage());
            return false;
        }
    }

    /**
     * 将方法的结果进行缓存；以后相同的结果，从缓存中获取
     * @param id 主键id
     * @return
     */
    @Override
//    @Cacheable(value = "order")
    public OrderInfo get(String id) {
        if(StrUtils.isBlank(id)){
            return  null;
        }
        log.debug(TextUtils.format("根据订单Id{0},获取实体类信息",id));
//        String message=messageClientService.getMessageById(id);
//        log.debug(message);
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean update(OrderInfo entry) {
        if(StrUtils.isBlank(entry.getId())){
            return  false;
        }
        log.debug(TextUtils.format("根据Id{0},更新实体类信息",entry.getId()));
        return orderInfoMapper.updateByPrimaryKeySelective(entry)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("根据Id{0},删除实体类信息", id));
        //逻辑删除
        OrderInfo entry=new OrderInfo();
        entry.setId(id);
        entry.setStatus(Constant.STRING_DEL_STATE);
        return  orderInfoMapper.updateByPrimaryKeySelective(entry)== 1?true:false;

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

    @Override
    public OrderDetail getOrderDetailByNo(String orderNo) {
        if(StrUtils.isBlank(orderNo)){
            log.debug("订单号不可为空！");
            return null;
        }
        OrderDetailExample  orderDetailExample=new OrderDetailExample();
        orderDetailExample.createCriteria().andOrderNoEqualTo(orderNo);
        List<OrderDetail>  orderDetailList= orderDetailMapper.selectByExample(orderDetailExample);
        return orderDetailList.size()>0?orderDetailList.get(0):null;
    }


    @Override
    public  boolean  saveOrderAndDetailMQ(OrderInfo orderInfo){
        if(StrUtils.isBlank(orderInfo.getId())){
            orderInfo.setId(StrUtils.randomUUID());
        }
        //如果没有 订单号则初始订单号
        if(StrUtils.isBlank(orderInfo.getOrderNo())){
            orderInfo.setOrderNo(StrUtils.getOrderNo());
        }
        //状态初始化正常
        if(StrUtils.isBlank(orderInfo.getStatus())){
            orderInfo.setStatus(Constant.STRING_1);
        }
        //統計流量信息
        if(StrUtils.isBlank(orderInfo.getRc7())&&!StrUtils.isBlank(orderInfo.getOrderResult())){
            orderInfo.setRc7(orderInfo.getOrderResult().getBytes().length);
        }
        orderInfo.setUdt(new Date());
        orderInfoMapper.insertSelective(orderInfo);
       /******************开始初始化订单详情信息****************************/
        OrderDetail  orderDetail=new OrderDetail();
        //id
        orderDetail.setId(StrUtils.randomUUID());
        orderDetail.setIdt(new Date());
        orderDetail.setOrderNo(orderInfo.getOrderNo());
        orderDetail.setOrderResult(orderInfo.getOrderResult());
        //返回结果

        orderDetailMapper.insertSelective(orderDetail);
        // 线程池  批量插入数据库
        return true;

    }

    @Override
    public boolean sendOrderMQMsg(OrderInfo orderInfo) {
        try{

            StrRedisTemplate.convertAndSend("order", orderInfo);
//            log.debug("发送订单数据到MQ");
//            rabbitTemplate.convertAndSend("datacenter.direct","api.order",orderInfo);
        }catch (Exception e){
            return  false;
        }
        return  true;
    }

}
