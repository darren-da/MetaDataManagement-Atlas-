package com.gla.datacenter.service;

import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.ParmsApi;
import com.gla.datacenter.model.ParamModel;
import com.limp.framework.core.bean.Result;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface SoapWebserviceClient {

    String cxfMethod(Map<String, Object> maps, InformationApi informationApi, List<ParmsApi> shamParms);

    String cxfMethodV0(List<ParamModel> paramResult, InformationApi informationApi, List<ParmsApi> shamParms) throws IOException;

    String sendHttpRequest(Map<String, Object> maps, InformationApi informationApi) throws IOException;
}
