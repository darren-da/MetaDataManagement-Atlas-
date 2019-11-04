package com.gla.datacenter.controller;

import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.model.ResourceCatalogRequestModel;
import com.gla.datacenter.service.ResourceCateManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 资源目录系统 管理类（增删改改查 授权类等，此处不包括对外DSB提供的接口）
 * @Author: zzh
 * @Modified By:
 * @Date: 2019/2/20 10:42
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ResourceCateManagerController {

    private Logger log = LoggerFactory.getLogger(ResourceCateManagerController.class);

    @Autowired
    private ResourceCateManagerService resourceCateManagerService;

    /**
     *
     * 功能描述: 获取生产者资源目录分页数据
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 9:33
     */
    @RequestMapping(value = "/resource/provider/catalog")
    public String getResourceCatalogPages(@RequestBody RcsResourceCate rcsResourceCate, @RequestParam("code") String code){

        return resourceCateManagerService.getResourceCatalogPages(rcsResourceCate, rcsResourceCate.getPager(), code);
    }

    /**
     *
     * 功能描述: 获取消费者资源目录分页数据
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/25 13:54
     */
    @RequestMapping(value = "/resource/consumer/catalog")
    public String getResourceCatalogConsumerPages(@RequestBody RcsResourceCate rcsResourceCate, @RequestParam("code") String code){
        return resourceCateManagerService.getResourceCatalogConsumerPages(rcsResourceCate,rcsResourceCate.getPager(),code);
    }

    /**
     *
     * 功能描述: 消费者高级条件查询
     *
     * @param: 
     * @param resourceCatalogRequestModel
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/26 9:08
     */
    @RequestMapping(value = "/resource/consumer/search")
    public String searchResourceCatalogConsumerPages(@RequestBody ResourceCatalogRequestModel resourceCatalogRequestModel){
        return resourceCateManagerService.searchResourceCatalogConsumerPages(resourceCatalogRequestModel,resourceCatalogRequestModel.getPager());
    }

    /**
     *
     * 功能描述: 获取资源目录类数据
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/26 9:51
     */
    @RequestMapping(value = "/resource/class")
    public String getResourceClass(@RequestParam("lv") int lv){
        return resourceCateManagerService.getResourceClass(lv);
    }

    /**
     *
     * 功能描述: 消费者统计类、项、目、细目各多少个
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/25 13:59
     */
    @RequestMapping(value = "/resource/consumer/count")
    public String countResourceCatalogByConsumer(){
        return resourceCateManagerService.countResourceCatalogByConsumer();
    }

    /**
     *
     * 功能描述: (项、目、细目、全部)条件获取资源目录分页数据
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 16:34
     */
    @RequestMapping(value = "/resource/catalog/lv")
    public String getResourceCataLogByLvPages(@RequestBody RcsResourceCate rcsResourceCate, @RequestParam("isDraft") boolean isDraft){
        return resourceCateManagerService.getResourceCataLogByLvPages(rcsResourceCate,rcsResourceCate.getPager(),isDraft);
    }

    /**
     *
     * 功能描述: 资源目录提交审核
     *
     * @param: 
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/13 16:17
     */
    @PostMapping(value = "/resource/audit")
    public String submitAuditResource(){
        return resourceCateManagerService.submitAuditResource();
    }

    /**
     *
     * 功能描述: 获取资源目录草稿分页列表
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 13:50
     */
    @RequestMapping(value = "/resource/provider/draft")
    public String getResourceDraftPages(@RequestBody RcsResourceCate rcsResourceCate, @RequestParam("code") String code){
        return resourceCateManagerService.getResourceDraftPages(rcsResourceCate, rcsResourceCate.getPager(),code);
    }

    /**
     *
     * 功能描述: 查看资源目录-目录信息
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 10:07
     */
    @RequestMapping(value = "/resource/find/{id}")
    public String findCatalogInfor(@PathVariable("id") String id){
        return resourceCateManagerService.findCatalogInfor(id);
    }

    /**
     *
     * 功能描述: 资源目录-选择部门查询
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 11:43
     */
    @RequestMapping(value = "/resource/dept")
    public String findDeptResourceInfo(@RequestBody RcsResourceCate rcsResourceCate){
        return resourceCateManagerService.findDeptResourceInfo(rcsResourceCate);
    }

    /**
     *
     * 功能描述: 保存资源目录
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/8 10:44
     */
    @PostMapping(value = "/resource/save")
    public String saveResource(@RequestBody RcsResourceCate rcsResourceCate){
        return resourceCateManagerService.saveResource(rcsResourceCate);
    }

    /**
     *
     * 功能描述: 更新资源目录保存为草稿
     *
     * @param:
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/11 13:47
     */
    @RequestMapping(value = "/resource/update")
    public String updateResourceCate(@RequestBody RcsResourceCate rcsResourceCate){
        return resourceCateManagerService.updateResourceCate(rcsResourceCate);
    }

    /**
     *
     * 功能描述: 对资源目录修改的操作进行撤销
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/8 12:54
     */
    @RequestMapping(value = "/resource/revoke/{flag}/{id}")
    public String revokeResource(@PathVariable("flag") boolean flag,@PathVariable("id") String id){
        return resourceCateManagerService.revokeResource(flag,id);
    }

    /**
     *
     * 功能描述: 根据所选目录获取所有上级关系
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/11 9:19
     */
    @RequestMapping(value = "/resource/elder/{id}")
    public String getAllElderById(@PathVariable("id") String id){
        return resourceCateManagerService.getAllElderById(id);
    }

    /**
     *
     * 功能描述: 删除资源目录
     *
     * @param: 
     * @param id
     * @param flag 是否递归删除下级资源目录  true:是  false:否
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/6 10:19
     */
    @RequestMapping(value = "/resource/delete/{flag}/{id}")
    public String deleteResourceCata(@PathVariable("flag") boolean flag, @PathVariable("id") String id){
        return resourceCateManagerService.deleteResourceCata(flag,id);
    }

    /**
     *
     * 功能描述: 资源目录上线下线
     *
     * @param: 
     * @param id
     * @param statu
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/6 14:06
     */
    @RequestMapping(value = "/resource/line/{id}/{statu}")
    public String onlineOffline(@PathVariable("id") String id,@PathVariable("statu") int statu){
        return resourceCateManagerService.onlineOffline(id,statu);
    }

    /**
     *
     * 功能描述: 资源目录审核通过
     *
     * @param: 
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/1 14:49
     */
    @RequestMapping(value = "/resource/approved/{code}")
    public String resourceApproved(@PathVariable("code") String code){
        return resourceCateManagerService.resourceApproved(code);
    }

    /**
     *
     * 功能描述: 资源目录审核拒绝
     *
     * @param:
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/1 17:24
     */
    @RequestMapping(value = "/resource/failure/{code}")
    public String resourceAuditFailure(@PathVariable("code") String code){
        return resourceCateManagerService.resourceAuditFailure(code);
    }

    /**
     *
     * 功能描述: 导出资源目录模板
     *
     * @param: 
     * @param request
     * @return: void
     * @author: zhangbo
     * @date: 2019/3/4 14:40
     */
    @RequestMapping(value = "/resource/template/export")
    public ResponseEntity<byte[]> downloadTemplate(HttpServletRequest request){
        return resourceCateManagerService.downloadTemplate(request);
    }

    /**
     *
     * 功能描述: 导出所选资源目录
     *
     * @param: 
     * @param request
     * @return: org.springframework.http.ResponseEntity<byte[]>
     * @author: zhangbo
     * @date: 2019/3/4 18:44
     */
    @RequestMapping(value = "/resource/export")
    public ResponseEntity<byte[]> downloadResource(HttpServletRequest request, @RequestParam("code") String code){
        return resourceCateManagerService.downloadResource(request,code);
    }

    /**
     *
     * 功能描述: 根据redis的key获取错误数据源，并且下载Excel
     *
     * @param: 
     * @param request
     * @param key
     * @return: org.springframework.http.ResponseEntity<byte[]>
     * @author: zhangbo
     * @date: 2019/3/13 14:26
     */
    @RequestMapping(value = "/resource/export/error")
    public ResponseEntity<byte[]> downloadErrorResource(HttpServletRequest request, @RequestParam("key") String key){
        return resourceCateManagerService.downloadErrorResource(request,key);
    }

    /**
     *
     * 功能描述: 上传资源目录
     *
     * @param: 
     * @param request
     * @param file
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/5 13:53
     */
    @RequestMapping(value = "/resource/import")
    public String importResource(HttpServletRequest request, MultipartFile file){
        return resourceCateManagerService.importResource(file);
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
