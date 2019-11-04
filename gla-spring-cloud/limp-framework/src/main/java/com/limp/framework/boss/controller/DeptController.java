package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.Dept;
import com.limp.framework.boss.service.DeptService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/15 10:50
 * @Description:
 */
@RestController
@RequestMapping(value = "/system")
public class DeptController {

    private Logger loger = LoggerFactory.getLogger(DeptController.class);

    /**
     * 设置默认页面显示的条数
     */
    public static final Integer DEFAULT_ROW = 10;

    @Autowired
    private DeptService deptService;

    @ApiOperation(value="创建单位", notes="根据Dept对象创建单位")
    @ApiImplicitParam(name = "dept", value = "单位详细实体Dept", required = true, dataType = "Dept")
    @RequestMapping(value = "/dept",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增单位信息")
    public String saveDeptInfo(Dept dept) {
        loger.debug(TextUtils.format("/***新增单位信息**/"));
        Boolean flay = deptService.saveDept(dept);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    @ApiOperation(value="删除单位", notes="根据code来指定删除单位")
    @ApiImplicitParam(name = "dept", value = "code", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/dept/{code}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除单位信息")
    public String delDeptCode( @PathVariable("code") String code) {
        loger.debug(TextUtils.format("/***根据单位code{0}，删除单位记录**/", code));
        String[] ids = code.split(Constant.DHAO);
        if(code.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }

        String result = deptService.deleteDept(ids);
        return result;
    }

    @ApiOperation(value="更新信息", notes="根据url的code来指定更新单位信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "单位code", required = true, dataType = "String",paramType = "path"),
            @ApiImplicitParam(name = "dept", value = "单位实体dept", required = true, dataType = "Dept")
    })
    @RequestMapping(value = "/dept",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新单位信息")
    public String updateDeptCode(Dept dept) {
        loger.debug(TextUtils.format("/***更新单位信息**/"));
        Boolean flay= deptService.updateDept(dept);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    @ApiOperation(value="更新单位状态", notes="根据url的code来指定更新单位状态")
    @RequestMapping(value = "/dept/{code}/state/{state}",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新单位状态")
    public String updateDeptCodeState(@PathVariable("code") String code,@PathVariable("state") String state) {
        Dept dept = new Dept();
        dept.setCode(code);
        dept.setState(Integer.parseInt(state));
        loger.debug(TextUtils.format("/***更新单位状态**/"));
        Boolean flay= deptService.updateDept(dept);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 获取单位信息根据单位code查询单位信息
     * @param model
     * @param code 查询的code
     * @return
     */
    @ApiOperation(value="获取单位详细信息", notes="根据url的code来获取单位详细信息")
    @ApiImplicitParam(name = "code", value = "单位code", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/dept/{code}",method= RequestMethod.GET)
    public String selectDeptInfo(Model model, @PathVariable("code") String code) {
        loger.debug(TextUtils.format("/***根据单位code{0}，获取单位基本信息**/", code));
        Dept dept = deptService.getDept(code);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,dept,"").getJson();
    }

    @ApiOperation(value="获取单位列表", notes="获取单位列表")
    @RequestMapping(value = "/deptsList",method= RequestMethod.GET)
    public String selectDeptList(Dept dept) {
        loger.debug(TextUtils.format("/***查询单位,返回单位列表**/"));
        List<Dept> depts = deptService.getDeptList(dept);
        if(!StrUtils.isBlank(depts)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,depts,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    @ApiOperation(value="获取单位列表", notes="获取单位列表")
    @RequestMapping(value = "/depts",method= RequestMethod.GET)
    public String selectDeptCodePageList(Dept dept,Pager pager) {
        loger.debug(TextUtils.format("/***查询单位,返回单位列表【分页】**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<Dept> deptCodePager = deptService.getDeptPageList(dept, pager);
        if(true){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,deptCodePager,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /**
         * 第一种方式：使用WebDataBinder注册一个自定义的编辑器，编辑器是日期类型
         * 使用自定义的日期编辑器，日期格式：yyyy-MM-dd,第二个参数为是否为空  true代表可以为空
         *  yyyy-MM-dd hh:mm:ss
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                new SimpleDateFormat("yyyy-MM-dd"), true));
    }
}
