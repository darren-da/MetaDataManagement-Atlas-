package com.gla.datacenter.model;

import com.gla.datacenter.domain.DataModelManager;
import com.gla.datacenter.domain.ModelField;

import java.util.List;

/**
 * @Author: zhangbo
 * @Date: 2019/6/21 14:07
 * @Description:
 */
public class MDMDataModelModels {

    private DataModelManager dataModelManager;

    private List<ModelField> modelFields;

    public DataModelManager getDataModelManager() {
        return dataModelManager;
    }

    public void setDataModelManager(DataModelManager dataModelManager) {
        this.dataModelManager = dataModelManager;
    }

    public List<ModelField> getModelFields() {
        return modelFields;
    }

    public void setModelFields(List<ModelField> modelFields) {
        this.modelFields = modelFields;
    }
}
