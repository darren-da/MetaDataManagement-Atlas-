
package com.gla.datacenter.controller;

import com.gla.datacenter.domain.OrderDetail;
import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.service.OrderInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class OrderController {

    private Logger loger= LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderInfoService orderInfoService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    /**
     * 获取orderInfo信息根据orderInfoid
     * @param model
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/order/{id}",method= RequestMethod.GET)
    public String selectOrderInfo(Model model, @PathVariable("id") String id) {
//        UserInfo user=ApplicationContextHolder.currentUser();
//        Integer.parseInt(id);
        loger.debug(TextUtils.format("/***根据id{0}，获取orderInfo基本信息**/", id));

        OrderInfo orderInfo = orderInfoService.get(id);
        loger.info("获取的结果集{}",orderInfo);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,orderInfo,"").getJson();
    }
    /**
     * 获取orderDetail详情基本信息
     * @param orderNo 订单号
     * @return 订单详情
     */
    @RequestMapping(value = "/orderDetail/{id}",method= RequestMethod.GET)
    public String selectOrderDetailByOrderNo(@PathVariable("orderNo") String orderNo) {
        loger.debug(TextUtils.format("/***根据order_no-->{0}，获取orderDetail基本信息**/", orderNo));
        OrderDetail orderDetail= orderInfoService.getOrderDetailByNo(orderNo);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,orderDetail,"").getJson();
    }
    /**
     * 查询用于列表
     * @param orderInfo
     * @return
     */

    @RequestMapping(value = "/orders")
    public String selectOrderInfoList(@RequestBody(required = false) OrderInfo orderInfo) {
        loger.info(TextUtils.format("/***查询orderInfo,返回orderInfo列表**/"));
        if (StrUtils.isBlank(orderInfo)) {
            return Result.getException(ExceptionEnum.ParamFormatError).getJson();
        }
        Pager<OrderInfo> orderInfoPager= orderInfoService.getPageList(orderInfo, orderInfo.getPager());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,orderInfoPager,"").getJson();
    }

    /**
     * 发送订单数据到MQ
     * @param orderInfo 订单基本信息
     * @return
     */
    @RequestMapping(value = "/sendOrderMQMsg")
    public String sendOrderMQMsg(@RequestBody(required = false) OrderInfo orderInfo) {
        loger.info(TextUtils.format("/***发送消息到消息队列**/"));
        Boolean flay= orderInfoService.sendOrderMQMsg(orderInfo);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }



    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"), true));
    }

    /**
     * session 统一管理
     * @param session
     * @return
     */
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
