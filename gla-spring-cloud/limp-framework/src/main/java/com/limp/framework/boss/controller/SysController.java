package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.AreaCode;
import com.limp.framework.boss.domain.DicCode;
import com.limp.framework.boss.domain.TagsLib;
import com.limp.framework.boss.service.SysService;
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
 * 地区和码表相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/sys")
public class SysController extends BaseController {
    private Logger loger= LoggerFactory.getLogger(SysController.class);

    @Autowired
    SysService sysService;
    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;

    /**
     * 新增地区信息
     * @param area
     * @return
     */
    @RequestMapping(value = "/area",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增地区信息")
    public String saveAreaInfo(AreaCode area) {
        loger.debug(TextUtils.format("/***新增地区信息**/"));
        Boolean flay= sysService.saveArea(area);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }
    /**
     * 新增tag信息
     * @param taglib
     * @return
     */
    @RequestMapping(value = "/taglib",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增taglib信息")
    public String saveTaglib(TagsLib taglib) {
        Boolean flay= sysService.saveTag(taglib);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 新增码表信息
     * @param dic
     * @return
     */
    @RequestMapping(value = "/code",method= RequestMethod.POST)
    @Access(privilege =true,login = true,operationLog = OPERATION.INSERT,operationIntro = "新增码表信息")
    public String saveDicInfo(DicCode dic) {
        loger.debug(TextUtils.format("/***新增码表信息**/"));
        Boolean flay= sysService.saveDic(dic);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 删除地区
     * 为了管理员易于操作支持批量操作
     * @param code
     * @return
     */
    @RequestMapping(value = "/area/{code}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除地区")
    public String delAreaCode( @PathVariable("code") String code) {
        loger.debug(TextUtils.format("/***根据地区code{0}，删除地区记录**/", code));
        String []ids=code.split(Constant.DHAO);
        if(code.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!sysService.deleteArea(did)){
                flay=false;
            }
        }
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 删除码表
     * 为了管理员易于操作支持批量操作
     * @param dicCode
     * @return
     */
    @RequestMapping(value = "/code/{dicCode}",method= RequestMethod.DELETE)
    @Access(privilege =true,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除码表")
    public String delDicCode( @PathVariable("dicCode") String dicCode) {
        loger.debug(TextUtils.format("/***根据码表dictDataValue{0}，删除码表记录**/", dicCode));
        String []ids=dicCode.split(Constant.DHAO);
        if(dicCode.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!sysService.deleteDic(did)){
                flay=false;
            }
        }
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 删除标签
     * @param key
     * @return
     */
    @RequestMapping(value = "/taglib/{key}",method= RequestMethod.DELETE)
    @Access(privilege =false,login = true,operationLog = OPERATION.DELETE,operationIntro = "删除标签")
    public String delTagLib( @PathVariable("key") String key) {
        String []ids=key.split(Constant.DHAO);
        if(key.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!sysService.deleteTagLib(did)){
                flay=false;
            }
        }
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 更新地区信息
     * @param area
     * @return
     */
    @RequestMapping(value = "/area",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新地区信息")
    public String updateAreaCode(AreaCode area) {
        loger.debug(TextUtils.format("/***更新地区信息**/"));
        Boolean flay= sysService.updateArea(area);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }
    /**
     * 更新tag信息
     * @param tagsLib
     * @return
     */
    @RequestMapping(value = "/updateTag",method= RequestMethod.PUT)
    @Access(privilege =false,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新标签")
    public String updateTagLib(TagsLib tagsLib) {
        loger.debug(TextUtils.format("/***更新标签信息**/"));
        Boolean flay= sysService.updateTagLib(tagsLib);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 更新码表信息
     * @param dicCode
     * @return
     */
    @RequestMapping(value = "/code",method= RequestMethod.PUT)
    @Access(privilege =true,login = true,operationLog = OPERATION.UPDATE,operationIntro = "更新码表信息")
    public String updateDicCode(DicCode dicCode) {
        loger.debug(TextUtils.format("/***更新码表信息**/"));
        Boolean flay= sysService.updateDic(dicCode);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 更新地区状态
     * @param code
     * @param state
     * @return
     */
    @ApiOperation(value="更新地区状态", notes="根据url的code来指定更新地区状态")
    @RequestMapping(value = "/area/{code}/state/{state}",method= RequestMethod.PUT)
    public String updateAreaCodeState(@PathVariable("code") String code,@PathVariable("state") String state) {
        AreaCode areaCode=new AreaCode();
        areaCode.setCode(code);
        areaCode.setState(Integer.parseInt(state));
        loger.debug(TextUtils.format("/***更新地区状态**/"));
        Boolean flay= sysService.updateArea(areaCode);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 更新码表状态
     * @param code
     * @param state
     * @return
     */
    @ApiOperation(value="更新码表状态", notes="根据url的dictDataValue来指定更新地区状态")
    @RequestMapping(value = "/code/{dicValue}/state/{state}",method= RequestMethod.PUT)
    public String updateDicCodeStatue(@PathVariable("dicValue") String code,@PathVariable("state") String state) {
        DicCode dicCode=new DicCode();
        dicCode.setDictdataValue(code);
        dicCode.setDictStatue(state);
        loger.debug(TextUtils.format("/***更新码表状态**/"));
        Boolean flay= sysService.updateDic(dicCode);
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }

    /**
     * 获取地区信息根据地区code查询地区信息
     * @param model
     * @param code 查询的code
     * @return
     */
    @ApiOperation(value="获取地区详细信息", notes="根据url的code来获取地区详细信息")
    @ApiImplicitParam(name = "code", value = "地区code", required = true, dataType = "String", paramType = "path")
    @RequestMapping(value = "/area/{code}",method= RequestMethod.GET)
    public String selectAreaInfo(Model model, @PathVariable("code") String code) {
        loger.debug(TextUtils.format("/***根据地区code{0}，获取地区基本信息**/", code));
        AreaCode areaCode = sysService.getArea(code);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,areaCode,"").getJson();
    }

    /**
     * 获取码表信息根据码表dicDataValue查询码表信息
     * @param model
     * @param dicValue 查询的dicValue
     * @return
     */
    @RequestMapping(value = "/code/{dicValue}",method= RequestMethod.GET)
    public String selectDicInfo(Model model, @PathVariable("dicValue") String dicValue) {
        loger.debug(TextUtils.format("/***根据码表dicDataValue{0}，获取地区基本信息**/", dicValue));
        DicCode dicCode = sysService.getDic(dicValue);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,dicCode,"").getJson();
    }

    /**
     * 根据条件查询地区列表
     * @param areaCode
     * @return
     */
    @ApiOperation(value="获取地区列表", notes="获取地区列表")
    @RequestMapping(value = "/areasList",method= RequestMethod.GET)
    public String selectAreaCodeList(AreaCode areaCode) {
        loger.debug(TextUtils.format("/***查询地区,返回地区列表**/"));
        List<AreaCode> areaCodes = sysService.getAreaList(areaCode);
        if(!StrUtils.isBlank(areaCodes)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,areaCodes,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }
    /**
     * 根据条件查询标签列表
     * @param tagsLib
     * @return
     */
    @RequestMapping(value = "/tagsLibList",method= RequestMethod.GET)
    public String selectTagList(TagsLib tagsLib) {
        List<TagsLib> tagsLibs = sysService.getTagsLibList(tagsLib);
        if(!StrUtils.isBlank(tagsLibs)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,tagsLibs,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 根据条件查询码表列表
     * @param dicCode
     * @return
     */
    @RequestMapping(value = "/codeList",method= RequestMethod.GET)
    public String selectDicCodeList(DicCode dicCode) {
        loger.debug(TextUtils.format("/***查询码表,返回码表列表**/"));
        List<DicCode> dicCodes = sysService.getDicList(dicCode);
        if(!StrUtils.isBlank(dicCodes)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,dicCodes,"").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 根据条件查询地区列表并进行分页
     * @param areaCode
     * @return
     */
    @RequestMapping(value = "/areas",method= RequestMethod.GET)
    public String selectAreaCodePageList(AreaCode areaCode,Pager pager) {
        loger.debug(TextUtils.format("/***查询地区,返回地区列表【分页】**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<AreaCode> areaCodePager= sysService.getAreaPageList(areaCode, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,areaCodePager,"").getJson();
    }
    /**
     * 根据条件查询标签列表并进行分页
     * @param tagsLib
     * @return
     */
    @RequestMapping(value = "/tagsLibPage",method= RequestMethod.GET)
    public String selectTagLibPageList(TagsLib tagsLib,Pager pager) {
        loger.debug(TextUtils.format("/***查询标签,返回标签列表【分页】**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<TagsLib> areaCodePager= sysService.getTagsLibPageList(tagsLib, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,areaCodePager,"").getJson();
    }

    /**
     * 根据条件查询码表列表并进行分页
     * @param dicCode
     * @return
     */
    @RequestMapping(value = "/codes",method= RequestMethod.GET)
    public String selectDicCodePageList(DicCode dicCode,Pager pager) {
        loger.debug(TextUtils.format("/***查询码表,返回码表列表【分页】**/"));
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<DicCode> dicCodePager= sysService.getDicPageList(dicCode, pager);
         return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,dicCodePager,"").getJson();
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
