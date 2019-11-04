package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.FilterInformationApi;
import com.gla.datacenter.service.ApiFilterClientService;
import feign.hystrix.FallbackFactory;

/**
 * @Auther: zhangbo
 * @Date: 2018/10/24 11:44
 * @Description:
 */
public class ApiFilterClientServiceFallbackFactory implements FallbackFactory<ApiFilterClientService> {


    @Override
    public ApiFilterClientService create(Throwable throwable) {
        return new ApiFilterClientService(){

            @Override
            public String getFilterPageList(FilterInformationApi filterInformationApi) {
                return null;
            }

            @Override
            public String getFilterCount() {
                return null;
            }

            @Override
            public String addApiFilter(FilterInformationApi filterInformationApi) {
                return null;
            }

            @Override
            public String deleteApiFilter(String id,int listType) {
                return null;
            }
        };
    }
}
