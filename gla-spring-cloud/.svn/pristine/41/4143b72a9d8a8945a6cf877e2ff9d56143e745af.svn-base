
package com.limp.framework.boss.controller;

import com.limp.framework.boss.domain.Blog;
import com.limp.framework.boss.service.BlogService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.StrUtils;
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
 * demo相关操作
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@RestController
@RequestMapping("/system")
public class BlogController extends BaseController {
    private Logger loger= LoggerFactory.getLogger(BlogController.class);

    @Autowired
    BlogService BlogService;

    /**
     * 设置默认页面显示的条数
     */
    public static  final Integer DEFAULT_ROW=10;


    /**
     * 新增实体类信息
     * @param domain
     * @return
     */
    @RequestMapping(value = "/blog",method= RequestMethod.POST)
    @Access(privilege =false,login = false,operationLog = OPERATION.INSERT,operationIntro = "新增单位信息")

    public String saveBlog(Blog domain) {
        loger.debug("/***新增实体类信息**/");
        if(BlogService.save(domain)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }

    /**
     * 根据id删除实体类
     * 为了管理员易于操作支持批量操作
     * @param id
     * @return
     */
    @RequestMapping(value = "/blog/{id}",method= RequestMethod.DELETE)
    public String delBlog(@PathVariable("id") String id) {
        loger.debug("/***根据用户id:{}，删除实体类记录**/", id);
        String []ids=id.split(Constant.DHAO);
        if(id.split(Constant.DHAO).length>DEFAULT_ROW){
            return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.DEL_ERROR_IDS_TOO_MANY,"","").getJson();
        }
        Boolean flay=true;
        for(String did:ids){
            if(!BlogService.delete(did)){
                flay=false;
            };
        }
        if(flay){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.ERROR,"","").getJson();
    }
    /**
     * 更新实体类信息
     * @param domain
     * @return
     */
    @RequestMapping(value = "/blog",method= RequestMethod.PUT)
    public String updateBlog(Blog domain) {
        loger.debug("/***更新实体类信息**/");
        if(BlogService.update(domain)){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.UPDATE_SUCCESS,"","").getJson();
        }
        return Result.getInstance(ResultCode.ERROR.toString(), ResultMsg.UPDATE_ERROR,"","").getJson();
    }


    /**
     * 根据id获取实体类信息
     * @param model
     * @param id 查询的id
     * @return
     */
    @RequestMapping(value = "/blog/{id}",method= RequestMethod.GET)
    public String selectBlog(Model model, @PathVariable("id") String id) {
        loger.debug("/***根据用户id{}，获取实体类基本信息**/", id);
        Blog Blog= BlogService.get(id);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,Blog,"").getJson();
    }

    /**
     * 查询实体类列表,分页方法
     * @param Blog
     * @return
     */

    @RequestMapping(value = "/blogs",method= RequestMethod.GET)
    public String selectBlogList(Blog Blog,Pager pager) {
        loger.debug("/***分页查询方法,返回实体类列表**/");
        pager = new Pager(pager.getPage(), StrUtils.isBlank(pager.getRows())||Constant.NUMBER_0==pager.getRows()?DEFAULT_ROW:pager.getRows());
        Pager<Blog> BlogPager= BlogService.getPageList(Blog, pager);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,BlogPager,"").getJson();
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
