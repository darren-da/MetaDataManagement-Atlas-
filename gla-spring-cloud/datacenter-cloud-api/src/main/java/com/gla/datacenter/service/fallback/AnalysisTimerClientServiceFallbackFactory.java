package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.PageLog;
import com.gla.datacenter.service.AnalysisTimerClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: zhengshien
 * @Date: 2018/12/12 18:13
 * @Description: 熔断
 */
@Component
public class AnalysisTimerClientServiceFallbackFactory implements FallbackFactory<AnalysisTimerClientService> {
    @Override
    public AnalysisTimerClientService create(Throwable throwable) {

        return new AnalysisTimerClientService() {


            @Override
            public String getData(String userid) {
                return null;
            }

            @Override
            public String getRank(String userid) {
                return null;
            }

            @Override
            public String getApiCountsEachMonth(String userid) {
                return null;
            }

            @Override
            public String dataSurvey() {
                return null;
            }

            @Override
            public String rankingList() {
                return null;
            }

            @Override
            public String logOfBehavior( String managerAccount) {
                return null;
            }

            @Override
            public String systemRate() {
                return null;
            }

            @Override
            public String loginLog(String account) {
                return null;
            }

            @Override
            public String monitorOfProvider(Integer currIndex, Integer pageSize) {
                return null;
            }

            @Override
            public String DAUAndMAU(String managerAccount, String button,String month) {
                return null;
            }

            @Override
            public String invokingsAndFlows() {
                return null;
            }

            @Override
            public String logDynamics(String managerAccount) {
                return null;
            }

            @Override
            public String systemSecurityBehavior(PageLog pageLog) {
                return null;
            }

            @Override
            public String apiStatus(String userid) {
                return null;
            }

            @Override
            public String apiInvokings(String userid) {
                return null;
            }

            @Override
            public String apiFlow(String userid, String beginTime, String endTime) {
                return null;
            }

            @Override
            public String responseTime(String userid) {
                return null;
            }

            @Override
            public String invokingAndFlowByWeek(String userid) {
                return null;
            }

            @Override
            public String apiQualityRanking() {
                return null;
            }


        };
    }
}