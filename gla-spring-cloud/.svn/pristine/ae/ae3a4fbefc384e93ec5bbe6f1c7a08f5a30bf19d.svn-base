package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.model.ResourceCatalogRequestModel;
import com.gla.datacenter.service.ResourceCateManagerClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/2/28 17:10
 * @Description:
 */
public class ResourceCateManagerClientServiceFallbackFactory implements FallbackFactory<ResourceCateManagerClientService> {
    @Override
    public ResourceCateManagerClientService create(Throwable throwable) {
        return new ResourceCateManagerClientService() {
            @Override
            public String getResourceCatalogPages(RcsResourceCate rcsResourceCate, String code) {
                return null;
            }

            @Override
            public String getResourceCataLogByLvPages(RcsResourceCate rcsResourceCate, boolean isDraft) {
                return null;
            }

            @Override
            public String getResourceDraftPages(RcsResourceCate rcsResourceCate, String code) {
                return null;
            }

            @Override
            public String findCatalogInfor(String id) {
                return null;
            }

            @Override
            public String findDeptResourceInfo(RcsResourceCate rcsResourceCate) {
                return null;
            }

            @Override
            public String resourceApproved(String code) {
                return null;
            }

            @Override
            public String resourceAuditFailure(String code) {
                return null;
            }

            @Override
            public ResponseEntity<byte[]> downloadTemplate() {
                return null;
            }

            @Override
            public ResponseEntity<byte[]> downloadResource(String code) {
                return null;
            }

            @Override
            public ResponseEntity<byte[]> downloadErrorResource(String key) {
                return null;
            }

            @Override
            public String importResource(MultipartFile file) {
                return null;
            }

            @Override
            public String deleteResourceCata(boolean flag, String id) {
                return null;
            }

            @Override
            public String onlineOffline(String id, int statu) {
                return null;
            }

            @Override
            public String saveResource(RcsResourceCate rcsResourceCate) {
                return null;
            }

            @Override
            public String revokeResource(boolean flag,String id) {
                return null;
            }

            @Override
            public String getAllElderById(String id) {
                return null;
            }

            @Override
            public String updateResourceCate(RcsResourceCate rcsResourceCate) {
                return null;
            }

            @Override
            public String submitAuditResource() {
                return null;
            }

            @Override
            public String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate,String code) {
                return null;
            }

            @Override
            public String searchResourceCatalogConsumerPages(ResourceCatalogRequestModel resourceCatalogRequestModel) {
                return null;
            }

            @Override
            public String countResourceCatalogByConsumer() {
                return null;
            }

            @Override
            public String getResourceClass(int lv) {
                return null;
            }

            @Override
            public List<RcsResourceCate> getResourceCatalogByCodes(String[] code) {
                return null;
            }

            @Override
            public String getResourcePageListByResourceCode(RcsResourceCate rcsResourceCate) {
                return null;
            }

            @Override
            public String getFoundationalLibraryCatalog() {
                return null;
            }

            @Override
            public String getThreeLibraryCatalog() {
                return null;
            }

            @Override
            public Integer getResourceCount() {
                return null;
            }

            @Override
            public Map<String, Object> getResourcePcodesByCode(String[] collect) {
                return null;
            }


        };
    }
}
