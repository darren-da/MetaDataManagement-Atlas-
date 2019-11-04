package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.ModelContent;
import com.limp.framework.boss.service.ModelContentService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/system")
public class ModelContentController extends BaseController {
    private Logger loger= LoggerFactory.getLogger(ModelContentController.class);

    @Autowired
    ModelContentService modelContentService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 新增邮件模板信息
     * @param modelContent
     * @return
     */
//    @ApiOperation(value="创建邮件模板", notes="根据ModelContent对象创建邮件模板")
//    @ApiImplicitParam(name = "modelContent", value = "邮件模板详细实体modelContent", required = true, dataType = "ModelContent")
//    @RequiresPermissions("modelContent:add")
    @RequestMapping(value = "/modelContent",method= RequestMethod.POST)
//    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增邮件模板信息")
    public String saveModelContent(ModelContent modelContent) {
        loger.debug("/***新增邮件模板信息**/");
        Boolean flay= modelContentService.save(modelContent);
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }

    /**
     * 删除邮件模板
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
//    @ApiOperation(value="删除邮件模板", notes="根据url的id来指定删除邮件模板")
//    @ApiImplicitParam(name = "id", value = "邮件模板ID", required = true, dataType = "String", paramType = "path")
//    @RequiresPermissions("modelContent:del")
    @RequestMapping(value = "/modelContent/{id}",method= RequestMethod.DELETE)
//    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除邮件模板信息")
    public String delModelContent( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据邮件模板id{0}，删除邮件模板记录**/", id));
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!modelContentService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.Success().getJson();
        }
        return Result.Error().getJson();
    }
    /**
     * 更新邮件模板信息
     * @param modelContent modelContent
     * @return
     */
//    @ApiOperation(value="更新邮件模板信息", notes="根据url的id来指定更新邮件模板信息")
//    @RequiresPermissions("modelContent:update")
    @RequestMapping(value = "/modelContent",method= RequestMethod.PUT)
//    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新邮件模板信息")
    public String updateModelContent(ModelContent modelContent) {
        loger.debug(TextUtils.format("/***更新邮件模板信息**/"));
        Boolean flay= modelContentService.update(modelContent);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS, "", "").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR, "", "").getJson();
    }

    /**
     * 获取邮件模板信息根据邮件模板id
     * @param id 查询的id
     * @return
     */
//    @ApiOperation(value="获取邮件模板详细信息", notes="根据url的id来获取邮件模板详细信息")
//    @ApiImplicitParam(name = "id", value = "邮件模板ID", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/modelContent/{id}",method= RequestMethod.GET)
    public String selectModelContent( @PathVariable("id") String id) {
        loger.debug(TextUtils.format("/***根据邮件模板id{0}，获取邮件模板基本信息**/", id));
        ModelContent modelContent= modelContentService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,modelContent,"").getJson();
    }
    /**
     * 查询用于列表
     * @param modelContent
     * @return
     */

//    @ApiOperation(value="获取邮件模板列表", notes="获取邮件模板列表")
    @RequestMapping(value = "/modelContents",method= RequestMethod.GET)
    public String selectModelContentList(ModelContent modelContent,Pager pager) {
        loger.debug(TextUtils.format("/***查询邮件模板,返回邮件模板列表**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<ModelContent> modelContentPager
                = modelContentService.getPageList(modelContent, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,modelContentPager,"").getJson();
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
