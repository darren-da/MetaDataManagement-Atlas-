package com.gla.datacenter.service;

import com.gla.datacenter.domain.OrderDetail;
import com.gla.datacenter.domain.OrderInfo;
import com.limp.framework.core.abs.AbstractService;
import com.limp.framework.core.bean.Pager;

public interface OrderInfoService extends AbstractService<OrderInfo> {
    /**
     * 订单详情列表
     * @param orderDetail
     * @param pager
     * @return
     */
    public Pager<OrderDetail> getPageOrderDetailList(OrderDetail orderDetail, Pager pager) ;

    /**
     * 更具订单号获取订单详情
     * @param orderNo 订单号
     * @return 订单详情实体类
     */
    public OrderDetail getOrderDetailByNo(String orderNo);



    /**
     * 将订单信息保存到数据库中
     * @param orderInfo
     * @return
     */
    public  boolean  saveOrderAndDetailMQ(OrderInfo orderInfo);

    /**
     * 将订单信息发送到MQ
     * @param orderInfo 订单详情
     * @return 是否成功
     */
    public  boolean  sendOrderMQMsg(OrderInfo orderInfo);




    }
