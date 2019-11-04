package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.OrderClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单信息
 */
@RestController
@CrossOrigin
public class OrderControllerFeign
{
    private Logger LOG= LoggerFactory.getLogger(OrderControllerFeign.class);

	/**
	 * 订单客户端Service
	 */
	@Autowired
	private OrderClientService orderClientService;

	/**
	 * 根据订单id查询订单基本信息
	 * @param id 订单ID
	 * @return 订单基本信息
	 */
	@Access(login = true,privilege = false)
	@RequestMapping(value = "/order/{id}",method = RequestMethod.GET)
	public String get(@PathVariable("id") String id)
	{

        LOG.debug(TextUtils.format("/****根据订单ID{0}查询订单信息****/",id));
		return this.orderClientService.get(id);
	}

	/**
	 *
	 * 根据订单号获取订单详情
	 * @param orderNo 订单号
	 * @return 订单详情实体类
	 */
	@RequestMapping(value = "/orderDetail/{orderNo}",method = RequestMethod.GET)
	public String getOrderDetailByOrderNo(@PathVariable("orderNo") String orderNo)
	{
		LOG.debug(TextUtils.format("/****根据订单ID{0}查询订单详情信息****/",orderNo));
		return this.orderClientService.getOrderDetailByOrderNo(orderNo);
	}

	/**
	 * 获取订单列表
	 * @param orderInfo 订单实体类（查询参数）
	 * @return 订单列表
	 */
	@RequestMapping(value = "/orders")
	public String getOrderInfoList(OrderInfo orderInfo)
	{
		LOG.debug(TextUtils.format("/****根据orderInfo{0}查询订单列表****/", JsonUtils.toJson(orderInfo)));
		return this.orderClientService.getOrderInfoList(orderInfo);
	}

	/**
	 * 发送订单消息到MQ
	 * @param orderInfo 订单信息
	 * @return
	 */
	@RequestMapping(value = "/sendOrderMQMsg")
	public String sendOrderMQMsg(OrderInfo orderInfo)
	{
		LOG.debug(TextUtils.format("/****发送订单到MQ****/", JsonUtils.toJson(orderInfo)));
		return this.orderClientService.sendOrderMQMsg(orderInfo);
	}

}
