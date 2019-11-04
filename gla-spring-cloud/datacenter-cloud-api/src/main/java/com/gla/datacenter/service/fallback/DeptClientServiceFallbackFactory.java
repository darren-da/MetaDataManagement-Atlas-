package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.Dept;
import com.gla.datacenter.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Description: 熔断
 * @Author: zse
 * @Modified By:
 * @Date: 2018/10/26 16:18
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {

        return new DeptClientService() {


            @Override
            public String saveDept(Dept dept) {
                return null;
            }

            @Override
            public String delDept(String id) {
                return null;
            }

            @Override
            public String updateDept(Dept dept) {
                return null;
            }

            @Override
            public String updateDeptState(String id, String state) {
                return null;
            }

            @Override
            public String selectDept(String id) {
                return null;
            }

            @Override
            public String selectDeptList(Dept dept) {
                return null;
            }

            @Override
            public int insertDeptByList(List<Map<String, Object>> mapList) {
                return 0;
            }
        };
    }
}
