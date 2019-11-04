package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.service.UserInfoClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description: 熔断
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/9/28 16:18
 */
@Component
public class UserInfoClientServiceFallbackFactory implements FallbackFactory<UserInfoClientService> {
    @Override
    public UserInfoClientService create(Throwable throwable) {

        return new UserInfoClientService() {


            @Override
            public String saveUserInfo(UserInfo userInfo) {
                return null;
            }

            @Override
            public String delUserInfo(String id) {
                return null;
            }

            @Override
            public String updateUserInfo(UserInfo userInfo) {
                return null;
            }

            @Override
            public String updatePassword(UserInfo userInfo) {
                return null;
            }

            @Override
            public String updateUserInfoState(UserInfo userInfo) {
                return null;
            }

            @Override
            public String selectUserInfo(String id) {
                return null;
            }

            @Override
            public String getUsers(UserInfo userInfo) {
                return null;
            }

            @Override
            public String selectProvider(String keyword) {
                return null;
            }

            @Override
            public String selectUserInfoList(UserInfo userInfo) {
                return null;
            }

            @Override
            public String getCode(String account, String userEmail) {
                return null;
            }

            @Override
            public String findPassword(String account, String userEmail, String code) {
                return null;
            }

            @Override
            public String modifyDefaultPWD(String account, String oldPassword, String newPassword) {
                return null;
            }

            @Override
            public String resetPassword(String userid) {
                return null;
            }

            @Override
            public String getUserRoleIDS(String userid) {
                return null;
            }

            @Override
            public String getConsumerApikey() {
                return null;
            }

            @Override
            public String countRoleUserNum() {
                return null;
            }

            @Override
            public UserInfo getAdminInfo() {
                return null;
            }

            @Override
            public String getPageUserList(UserInfo userInfo) {
                return null;
            }

            @Override
            public List<UserInfo> getUserByPortal() {
                return null;
            }

        };
    }
}
