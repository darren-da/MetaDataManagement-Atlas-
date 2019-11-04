package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.AppService;
import com.gla.datacenter.domain.AppUserMap;
import com.gla.datacenter.model.AppRequestModel;
import com.gla.datacenter.service.AppClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppClientServiceFallbackFactory implements FallbackFactory<AppClientService>
{

	@Override
	public AppClientService create(Throwable throwable) {
		return new AppClientService() {

			@Override
			public String saveAppService(AppService appService) {
				return null;
			}

			@Override
			public String delAppInfo(String id) {
				return null;
			}

			@Override
			public String updateApp(AppService appService) {
				return null;
			}

			@Override
			public String selectAppService(String id) {
				return null;
			}

			@Override
			public String selectAppServiceList(AppRequestModel appRequestModel) {
				return null;
			}

			@Override
			public String addAppApiMap(String appId, String apiIds) {
				return null;
			}

			@Override
			public String delAppApiMap(String appId, String apiIds) {
				return null;
			}

			@Override
			public String addAppUserMap(String userId, String appid) {
				return null;
			}

			@Override
			public String delAppUserMap(String userId, String appid) {
				return null;
			}

			@Override
			public String userAppList(String userId, String roleType) {
				return null;
			}

			@Override
			public String appApiList(String appId) {
				return null;
			}

			@Override
			public String selectAppInfoByAppKey(String appKey) {
				return null;
			}

			@Override
			public String selectApiListByAppKey(String appKey) {
				return null;
			}

			@Override
			public String addAppByProvider(AppService appService) {
				return null;
			}

			@Override
			public String addAppByConsumer(AppService appService) {
				return null;
			}

			@Override
			public String batchEmpowerUser(AppUserMap appUserMap) {
				return null;
			}

			@Override
			public String getAppApplyByAppId(String id) {
				return null;
			}

			@Override
			public String deleteEmpower(AppUserMap appUserMap) {
				return null;
			}

			@Override
			public String getAppListByConsumer(AppRequestModel appRequestModel) {
				return null;
			}

			@Override
			public String countConsumerApp() {
				return null;
			}

			@Override
			public String countProviderApp() {
				return null;
			}

			@Override
			public String getAppDetailByAppId(String id) {
				return null;
			}

			@Override
			public String addApply(AppUserMap appUserMap) {
				return null;
			}

			@Override
			public String checkJoinApp(AppService appService) {
				return null;
			}

			@Override
			public Boolean saveAppUserMap(AppUserMap appUserMap) {
				return null;
			}

			@Override
			public List<AppUserMap> getApplyUsers(String appIdStr, String applyUser) {
				return null;
			}

			@Override
			public Integer delAuditFailureByStatus(String appid, String userid) {
				return null;
			}

			@Override
			public List<AppUserMap> selectBySenderid(String senderid) {
				return null;
			}

			@Override
			public Integer updateSelective(Integer status, String senderid, String apiid) {
				return null;
			}

			@Override
			public AppService getAppByCode(String code) {
				return null;
			}

		};
	}
}
