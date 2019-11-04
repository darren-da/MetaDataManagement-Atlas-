package com.gla.datacenter.service;


import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.model.ResourceCatalogRequestModel;
import com.limp.framework.core.bean.Pager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface ResourceCateManagerService {

    /**
     *
     * 功能描述: 获取资源目录分页数据
     *
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 9:34
     */
    String getResourceCatalogPages(RcsResourceCate rcsResourceCate, Pager pager, String code);

    /**
     *
     * 功能描述: 获取消费者资源目录分页
     *
     * @param:
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/25 13:55
     */
    String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate, Pager pager, String code);

    /**
     *
     * 功能描述: 获取资源目录草稿
     *
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 13:50
     */
    String getResourceDraftPages(RcsResourceCate rcsResourceCate, Pager pager, String code);

    /**
     *
     * 功能描述: 查看资源目录-目录信息
     *
     * @param:
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 10:08
     */
    String findCatalogInfor(String id);

    /**
     *
     * 功能描述: 资源目录详情-选择部门查询
     *
     * @param:
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 11:45
     */
    String findDeptResourceInfo(RcsResourceCate rcsResourceCate);

    /**
     *
     * 功能描述: (项、目、细目、全部)条件获取资源目录分页数据
     *
     * @param: 
     * @param rcsResourceCate
     * @param pager
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/2/28 16:35
     */
    String getResourceCataLogByLvPages(RcsResourceCate rcsResourceCate, Pager pager, boolean isDraft);

    /**
     *
     * 功能描述: 资源目录审核通过
     *
     * @param: 
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/1 14:50
     */
    String resourceApproved(String code);

    /**
     *
     * 功能描述: 资源目录审核拒绝
     *
     * @param:
     * @param code
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/1 17:25
     */
    String resourceAuditFailure(String code);

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
    ResponseEntity<byte[]> downloadTemplate(HttpServletRequest request);

    /**
     *
     * 功能描述:导出所选择目录
     *
     * @param: 
     * @param request
     * @param code
     * @return: org.springframework.http.ResponseEntity<byte[]>
     * @author: zhangbo
     * @date: 2019/3/4 18:45
     */
    ResponseEntity<byte[]> downloadResource(HttpServletRequest request, String code);

    /**
     *
     * 功能描述: 根据redis的key获取错误数据源，并且下载Excel
     *
     * @param: 
     * @param request
     * @param key
     * @return: org.springframework.http.ResponseEntity<byte[]>
     * @author: zhangbo
     * @date: 2019/3/13 14:27
     */
    ResponseEntity<byte[]> downloadErrorResource(HttpServletRequest request, String key);

    /**
     *
     * 功能描述: 上传资源目录
     *
     * @param: 
     * @param file
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/5 13:54
     */
    String importResource(MultipartFile file);

    /**
     *
     * 功能描述: 删除资源目录
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/6 10:20
     */
    String deleteResourceCata(boolean flag, String id);

    /**
     *
     * 功能描述: 资源目录上线下线
     *
     * @param:
     * @param id
     * @param statu
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/6 14:07
     */
    String onlineOffline(String id, int statu);

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
    String saveResource(RcsResourceCate rcsResourceCate);

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
    String revokeResource(boolean flag,String id);

    /**
     *
     * 功能描述: 根据所选目录获取所有上级关系
     *
     * @param: 
     * @param id
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/11 9:20
     */
    String getAllElderById(String id);

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
    String updateResourceCate(RcsResourceCate rcsResourceCate);

    /**
     *
     * 功能描述: 资源目录提交审核
     *
     * @param: 
     * @param
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/13 16:17
     */
    String submitAuditResource();

    /**
     *
     * 功能描述: 消费者统计类、项、目、细目各多少个
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/26 9:09
     */
    String countResourceCatalogByConsumer();


    /**
     *
     * 功能描述: 消费者高级条件查询
     *
     * @param:
     * @param resourceCatalogRequestModel
     * @param pager
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/26 9:10
     */
    String searchResourceCatalogConsumerPages(ResourceCatalogRequestModel resourceCatalogRequestModel, Pager pager);

    /**
     *
     * 功能描述: 获取资源目录类数据
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/3/26 9:52
     */
    String getResourceClass(int lv);

}
