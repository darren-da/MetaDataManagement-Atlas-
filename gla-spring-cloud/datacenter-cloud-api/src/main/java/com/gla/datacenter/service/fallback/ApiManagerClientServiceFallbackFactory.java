package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.ApiNumLimt;
import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.model.ApiManagerModel;
import com.gla.datacenter.model.ApiTestModel;
import com.gla.datacenter.service.ApiManagerClientService;
import com.limp.framework.core.bean.Pager;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component // 不要忘记添加，不要忘记添加
public class ApiManagerClientServiceFallbackFactory implements FallbackFactory<ApiManagerClientService>
{

	@Override
	public ApiManagerClientService create(Throwable throwable) {
		return new ApiManagerClientService() {

			@Override
			public String getProviderList(InformationApi informationApi) {
				return null;
			}

			@Override
			public String getConsumerList(InformationApi informationApi) {
				return null;
			}

			@Override
			public String getConsumerListTwo(InformationApi informationApi) {
				return null;
			}

			@Override
			public String getManagerList(InformationApi informationApi) {
				return null;
			}

			@Override
			public String getManagerListTwo(InformationApi informationApi) {
				return null;
			}

			@Override
			public String countDeptAndApi() {
				return null;
			}

			@Override
			public String getApiTest(InformationApi informationApi) {
				return null;
			}

			@Override
			public String empowerUser(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public String empowerList(InformationApi informationApi) {
				return null;
			}

			@Override
			public String lookEmpower(String id) {
				return null;
			}

			@Override
			public String delEmpower(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public String delEmpowerByUserId(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public String getConsumerApiById(String id) {
				return null;
			}

			@Override
			public String countApiStatusAndNum() {
				return null;
			}

			@Override
			public String countConsumerApi() {
				return null;
			}

			@Override
			public String batchEmpowerUser(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public Map<String, Object> getApiInformationByCode(String code) {
				return null;
			}

			@Override
			public String getUserAccountByLike(String account) {
				return null;
			}

			@Override
			public String addApply(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public String startMonitor() {
				return null;
			}

			@Override
			public String getProviderMonitorData() {
				return null;
			}

			@Override
			public String checkJoinApi(InformationApi informationApi) {
				return null;
			}

			@Override
			public String saveCatalogUserMap(CatalogUserMap catalogUserMap) {
				return null;
			}

			@Override
			public String selectApiCatalogChange(ApiCatalogChange apiCatalogChange) {
				return null;
			}

			@Override
			public String apiAndAppCounts() {
				return null;
			}

			@Override
			public String applying(String type, String initial,String name, String code, String desc, Pager pager) {
				return null;
			}

			@Override
			public Boolean insertSelective(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public List<ApiNumLimt> selectByExample(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public List<ApiNumLimt> selectExample(String senderid) {
				return null;
			}

			@Override
			public Boolean updateByPrimaryKeySelective(ApiNumLimt apiNumLimt) {
				return null;
			}

			@Override
			public String getApiListByResourceCode(InformationApi informationApi,String resourceCode) {
				return null;
			}

			@Override
			public String getSubscribeResourcePageByUserId(RcsResourceCate rcsResourceCate) {
				return null;
			}

			@Override
			public List<String> getSubscribeResourceByUserId(String userId) {
				return null;
			}

            @Override
            public String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate, String code) {
                return null;
            }

			@Override
			public String getNumByConditions(InformationApi informationApi) {
				return null;
			}

			@Override
			public String getDeptListByManager() {
				return null;
			}

			@Override
			public String countApiUseByDept(String deptCode) {
				return null;
			}

			@Override
			public String saveApi(ApiManagerModel apiManagerModel) {
				return null;
			}

			@Override
			public String deleteApi(String id) {
				return null;
			}

			@Override
			public String getApiById(String id) {
				return null;
			}

			@Override
			public String deleteCategory(String id) {
				return null;
			}

            @Override
            public int checkCategory(String id) {
                return 1;
            }

			@Override
			public String apiTest(ApiTestModel apiTestModel) {
				return null;
			}

			@Override
			public String createApiCode() {
				return null;
			}

		};
	}
}
