package com.limp.framework.core.abs;


import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractCRUDAction<T extends AbstractModel> extends AbstractAction{

    private AbstractService abstractService;

    private AbstractModel abstractModel;

    private List<AbstractModel> models;

    protected Class<?> clazz = null;

    protected AbstractCRUDAction() {
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.clazz = (Class<?>) parameterizedType.getActualTypeArguments()[0];
    }
   protected void bindRequireProperty(AbstractService abstractService, AbstractModel abstractModel) {
        this.abstractService = abstractService;
        this.abstractModel = abstractModel;
    }

    protected abstract void prepare();

}
