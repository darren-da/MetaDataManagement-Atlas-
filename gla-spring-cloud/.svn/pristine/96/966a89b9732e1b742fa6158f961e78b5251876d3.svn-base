
package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.OrderDetail;
import com.limp.framework.boss.domain.OrderInfo;
import com.limp.framework.boss.service.OrderInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 角色相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/")
public class OrderController extends BaseController {

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
    @ApiOperation(value="获取orderInfo详细信息", notes="根据url的id来获取orderInfo详细信息")
    @ApiImplicitParam(name = "id", value = "orderInfoID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/orderInfo/{id}",method= RequestMethod.GET)
    public String selectOrderInfo(Model model, @PathVariable("id") String id) {
        Integer.parseInt(id);
        loger.debug(TextUtils.format("/***根据orderInfoid{0}，获取orderInfo基本信息**/", id));
        OrderInfo orderInfo= orderInfoService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,orderInfo,"").getJson();
    }
    /**
     * 查询用于列表
     * @param orderInfo
     * @return
     */

    @ApiOperation(value="获取orderInfo列表", notes="获取orderInfo列表")
    @RequestMapping(value = "/orders",method= RequestMethod.GET)
    public String selectOrderInfoList(OrderInfo orderInfo,Pager pager) {
        loger.debug(TextUtils.format("/***查询orderInfo,返回orderInfo列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<OrderInfo> orderInfoPager= orderInfoService.getPageList(orderInfo, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,orderInfoPager,"").getJson();
    }
    /**
     * 查询用于列表
     * @param orderInfoParams
     * @return
     */

    @ApiOperation(value="获取orderInfoParams列表", notes="获取orderInfoParams列表")
    @RequestMapping(value = "/orderDetails",method= RequestMethod.GET)
    public String selectOrderDetailList(OrderDetail orderInfoParams,Pager pager) {
        loger.debug(TextUtils.format("/***查询orderDetail,返回orderInfo列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<OrderDetail> orderDetailPager= orderInfoService.getPageOrderDetailList(orderInfoParams, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,orderDetailPager,"").getJson();
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


}
