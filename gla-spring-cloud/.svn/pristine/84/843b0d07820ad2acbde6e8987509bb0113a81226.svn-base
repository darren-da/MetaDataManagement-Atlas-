package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.DataModelManager;
import com.gla.datacenter.domain.MasterDataManager;
import com.gla.datacenter.domain.ModelField;
import com.gla.datacenter.model.MDMDataModelModels;
import com.gla.datacenter.model.ModelFieldModel;
import com.gla.datacenter.service.MDMClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: zhangbo
 * @Date: 2019/6/18 14:58
 * @Description:
 */
@Component
public class MDMClientServiceFallbackFactory implements FallbackFactory<MDMClientService> {
    @Override
    public MDMClientService create(Throwable throwable) {
        return new MDMClientService() {
            @Override
            public String getTest() {
                return null;
            }

            @Override
            public String getDataModelListPager(DataModelManager dataModelManager) {
                return null;
            }

            @Override
            public String editDataModel(DataModelManager dataModelManager) {
                return null;
            }

            @Override
            public String deleteDataModel(String id) {
                return null;
            }

            @Override
            public String addDataModel(MDMDataModelModels mdmDataModelModels) {
                return null;
            }

            @Override
            public String findDataModelField(ModelFieldModel modelFieldModel) {
                return null;
            }

            @Override
            public String deleteDataModelField(ModelField modelField) {
                return null;
            }

            @Override
            public String updateDataModelField(ModelField modelField) {
                return null;
            }

            @Override
            public String addDataModelField(ModelField modelField) {
                return null;
            }

            @Override
            public String getMDMDataListByPage(MasterDataManager masterDataManager) {
                return null;
            }

            @Override
            public String addMDMData(MasterDataManager masterDataManager) {
                return null;
            }

            @Override
            public String deleteMDMDate(String id) {
                return null;
            }

            @Override
            public String getDataModelDetails(String id) {
                return null;
            }

            @Override
            public String getTableNameList(String database) {
                return null;
            }

            @Override
            public String getFieldByTableName(String database, String name) {
                return null;
            }

            @Override
            public String getDataModelDraft() {
                return null;
            }

            @Override
            public String getDataModelCanUseFieldByModelId(String modelId) {
                return null;
            }

            @Override
            public String findMDMDate(String id, Map<String, Object> map) {
                return null;
            }

            @Override
            public String findMDMField(String id) {
                return null;
            }

            @Override
            public String editMDMData(MasterDataManager masterDataManager) {
                return null;
            }

            @Override
            public String getDatabaseByDB() {
                return null;
            }

            @Override
            public String getTableDataByDatabaseNameAndTableName(String database, String table, Map<String, Object> map) {
                return null;
            }


        };
    }
}
