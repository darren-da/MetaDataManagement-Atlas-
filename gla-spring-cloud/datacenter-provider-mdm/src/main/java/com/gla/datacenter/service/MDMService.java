package com.gla.datacenter.service;

import com.gla.datacenter.domain.DataModelManager;
import com.gla.datacenter.domain.MasterDataManager;
import com.gla.datacenter.domain.ModelField;
import com.gla.datacenter.model.MDMDataModelModels;
import com.gla.datacenter.model.ModelFieldModel;
import com.limp.framework.core.bean.Pager;

import java.util.Map;

public interface MDMService {


    String getDataModelListPager(DataModelManager dataModelManager, Pager pager);

    String editDataModel(DataModelManager dataModelManager);

    String deleteDataModel(String id);

    String addDataModel(MDMDataModelModels mdmDataModelModels);

    String findDataModelField(ModelFieldModel modelFieldModel);

    String deleteDataModelField(ModelField modelField);

    String updateDataModelField(ModelField modelField);

    String addDataModelField(ModelField modelField);

    String getMDMDataListByPage(MasterDataManager masterDataManager);

    String addMDMData(MasterDataManager masterDataManager);

    String deleteMDMDate(String id);

    String getDataModelDetails(String id);

    String getTableNameList(String database);

    String getFieldByTableName(String database, String name);

    String getDataModelDraft();

    String getDataModelCanUseFieldByModelId(String modelId);

    String findMDMDate(String id, Map<String, Object> map);

    String findMDMField(String id);

    String editMDMData(MasterDataManager masterDataManager);

    String getDatabaseByDB();

    String getTableDataByDatabaseNameAndTableName(String database, String table, Map<String, Object> map);
}
