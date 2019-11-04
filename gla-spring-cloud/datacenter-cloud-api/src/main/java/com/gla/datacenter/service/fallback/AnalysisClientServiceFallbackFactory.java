package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.OrderInfo;
import com.gla.datacenter.service.AnalysisClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: 熔断
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/9/28 16:18
 */
@Component
public class AnalysisClientServiceFallbackFactory implements FallbackFactory<AnalysisClientService> {
    @Override
    public AnalysisClientService create(Throwable throwable) {

        return  new AnalysisClientService() {

            @Override
            public String selectAnaDataListMap(String method, Map<String, Object> params) {
                    return "抱歉！数据分析模块已经暂时服务，将于2019年1月1日重新开启.";
            }

            @Override
            public String selectApiScore() {
                return null;
            }

            @Override
            public String getConsumerApiUseNumByWeek() {
                return null;
            }

            @Override
            public String getConsumerApiApplyNumByWeek() {
                return null;
            }

            @Override
            public String getProviderCenterBusinessStatistics() {
                return null;
            }

            @Override
            public String getProviderApiAccessCountByDate(String dateType) {
                return null;
            }

            @Override
            public String getProviderApiAccessEchartsByDate(String dateType) {
                return null;
            }

            @Override
            public String getProviderDayAccessData(OrderInfo orderInfo) {
                return null;
            }

            @Override
            public String getProviderHistoryAccessData(OrderInfo orderInfo) {
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
            public String countApiAndApp() {
                return null;
            }

            @Override
            public String countUserByPortal() {
                return null;
            }
        };

    }
}
