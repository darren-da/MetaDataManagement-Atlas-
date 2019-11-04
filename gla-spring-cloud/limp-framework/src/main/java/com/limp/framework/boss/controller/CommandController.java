package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.Command;
import com.limp.framework.boss.domain.PageLog;
import com.limp.framework.boss.service.CommandService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.OPERATION;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 命令相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/8/18
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 * 支持跨域访问
 */
@RestController
@RequestMapping("/system")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CommandController extends BaseController {

    private Logger loger= LoggerFactory.getLogger(CommandController.class);

    @Autowired
    CommandService commandService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 新增命令信息
     * @param command
     * @return
     */
//    @ApiOperation(value="创建命令", notes="根据Command对象创建命令")
//    @ApiImplicitParam(name = "command", value = "命令详细实体command", required = true, dataType = "Command")
//    @RequiresPermissions("command:add")
    @RequestMapping(value = "/command",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增命令信息")
    public String saveCommand(Command command) {
        loger.debug("/***新增命令信息**/");
        Boolean flay= commandService.save(command);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除命令
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
//    @ApiOperation(value="删除命令", notes="根据url的id来指定删除命令")
//    @ApiImplicitParam(name = "id", value = "命令ID", required = true, dataType = "String", paramType = "path")
//    @RequiresPermissions("command:del")
    @RequestMapping(value = "/command/{id}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除命令信息")
    public String delCommand( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据命令id{0}，删除命令记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!commandService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 更新命令信息
     * @param command command
     * @return
     */
//    @ApiOperation(value="更新命令信息", notes="根据url的id来指定更新命令信息")
//    @RequiresPermissions("command:update")
    @RequestMapping(value = "/command",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新命令信息")
    public String updateCommand(Command command) {
        loger.debug(TextUtils.format("/***更新命令信息**/"));
        Boolean flay= commandService.update(command);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 获取命令信息根据命令id
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/command/{id}",method= RequestMethod.GET)
    public String selectCommand(@PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据命令id{0}，获取命令基本信息**/", id));
        Command command= commandService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,command,"").getJson();
    }
    /**
     * 查询用于列表
     * @param command
     * @return
     */

    @RequestMapping(value = "/commands",method= RequestMethod.GET)
    public String selectCommandList(Command command) {
        loger.debug(TextUtils.format("/***查询命令,返回命令列表**/"));
        Pager<Command> pageLogPager= commandService.getPageList(command,command.getPager());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pageLogPager,"").getJson();
    }

    /**
     * 查询命令;无参数的情况
     * @param code
     * @return
     */
    @Access(login = true,privilege = true,operationIntro = "查询系统命令",operationLog = OPERATION.SELECT)
    @RequestMapping(value ="/run/{code}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String run(@PathVariable("code") String code) {
        if(StrUtils.isBlank(code)){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"code参数不为空","").getJson();
        }
        List<Map<String,Object>> runCommand= commandService.runCommand(code,null);
        return  new Result(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,runCommand,"").getJson();
    }

    /**
     * 预览sql：
     * @param param ｛sql:"sql语句",其它参数｝
     * @return
     */
    @RequestMapping(value ="/api-test",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String api(@RequestParam Map<String,String> param) {
        if(StrUtils.isBlank(param.get("sql"))){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"Sql参数不为空","").getJson();
        }
        List<Map<String,Object>> runCommand= commandService.runTestSQL(param.get("sql"),param);

        return  new Result(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,runCommand,"").getJson();
    }

    /**
     * 查询命令：带模版的情况
     * @param code
     * @param param
     * @return
     */
    @RequestMapping(value ="/api/{code}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String api(@PathVariable("code") String code,@RequestParam Map<String,String> param) {
        if(StrUtils.isBlank(code)){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"code参数不为空","").getJson();
        }
        List<Map<String,Object>> runCommand= commandService.runCommand(code,param);
        return  new Result(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,runCommand,"").getJson();
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
