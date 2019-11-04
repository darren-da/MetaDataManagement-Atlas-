package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.Services;
import com.limp.framework.boss.domain.ServicesParams;
import com.limp.framework.boss.service.ServicesInfoService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ExceptionEnum;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.HttpRequest;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
public class ServicesController extends BaseController {

    private Logger loger= LoggerFactory.getLogger(ServicesController.class);

    @Autowired
    ServicesInfoService  servicesInfoService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 新增角色信息
     * @param services
     * @return
     */
    @ApiOperation(value="创建services", notes="根据Services对象创建services")
    @ApiImplicitParam(name = "services", value = "services详细实体services", required = true, dataType = "Services")
    @RequestMapping(value = "/services",method= RequestMethod.POST)
    public String saveServices(Services services) {
        loger.debug("/***新增services信息**/");
        Boolean flay= servicesInfoService.save(services);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除services
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @ApiOperation(value="删除services", notes="根据url的id来指定删除services")
    @ApiImplicitParam(name = "id", value = "servicesID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/services/{id}",method= RequestMethod.DELETE)
    public String delServices( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据servicesid{0}，删除services记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!servicesInfoService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 更新services信息
     * @param services services
     * @return
     */
    @ApiOperation(value="更新信息", notes="根据url的id来指定更新services信息")
    @ApiImplicitParams({
           @ApiImplicitParam(name = "id", value = "servicesID", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "services", value = "services实体services", required = true, dataType = "User")
    })
    @RequestMapping(value = "/services",method= RequestMethod.PUT)
    public String updateServices(Services services) {
        loger.debug(TextUtils.format("/***更新services信息**/"));
        Boolean flay= servicesInfoService.update(services);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 获取services信息根据servicesid
     * @param model
     * @param id 查询的id
     * @return
     */
    @ApiOperation(value="获取services详细信息", notes="根据url的id来获取services详细信息")
    @ApiImplicitParam(name = "id", value = "servicesID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/services/{id}",method= RequestMethod.GET)
    public String selectServices(Model model, @PathVariable("id") String id) {
        Integer.parseInt(id);
        loger.debug(TextUtils.format("/***根据servicesid{0}，获取services基本信息**/", id));
        Services services= servicesInfoService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,services,"").getJson();
    }
    /**
     * 查询用于列表
     * @param services
     * @return
     */

    @RequestMapping(value = "/services",method= RequestMethod.GET)
    public String selectServicesList(Services services,Pager pager) {
        loger.debug(TextUtils.format("/***查询services,返回services列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<Services> servicesPager= servicesInfoService.getPageList(services, pager);
        if(true){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,servicesPager,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }
    /**
     * 查询用于列表
     * @param servicesParams
     * @return
     */

    @ApiOperation(value="获取servicesParams列表", notes="获取servicesParams列表")
    @RequestMapping(value = "/servicesParams",method= RequestMethod.GET)
    public String selectServicesParamsList(ServicesParams servicesParams,Pager pager) {
        loger.debug(TextUtils.format("/***查询services,返回services列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<ServicesParams> servicesparamsPager= servicesInfoService.getPageServiceParamsList(servicesParams, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,servicesparamsPager,"").getJson();
    }
    @ApiOperation(value="获取servicesPort数据", notes="通过http访问接口数据")
    @RequestMapping(value = "/servicesPort",method= RequestMethod.GET)
    public String selectServicesPortData(@RequestParam Map<String,Object> paramsMap) {
        loger.debug(TextUtils.format("/***获取servicesPort数据**/"));

        //校验参数合法性
        if(!paramsMap.containsKey("service")&&!paramsMap.containsKey("uid")&&!paramsMap.containsKey("url")){
            return Result.getException(ExceptionEnum.ParamIllegal).getJson();
        }
        String url=paramsMap.get("url").toString();
        String uid=paramsMap.get("uid").toString();
        String service=paramsMap.get("service").toString();
        /*for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {

        }*/
        paramsMap.remove("_");
        paramsMap.remove("type");
        paramsMap.remove("uid");
        paramsMap.remove("url");
        paramsMap.remove("service");

        //发送信息{service:'casLogin',uid:'0',params:{account:'admin',pwd:'123456',code:''}}
        final String sendMsg = "{service:'" + service + "',uid:'" + uid + "',params:" + JsonUtils.toJson(paramsMap) + "}";
        String data = URLEncoder.encode(sendMsg);
        loger.debug(data);
        //返回数据
        String result = HttpRequest.sendPost(url, "uid=" + uid + "&data=" + data);

        //--------2接收处理数据------------
        try {
            String dataStr = URLDecoder.decode(result, "UTF-8");
            loger.debug("----------返回数据-------------------");
            System.out.println(dataStr);
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,JsonUtils.convertJsonStrToMap(dataStr),"").getJson();
        } catch (Exception e) {
            e.printStackTrace();
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


}
