package com.gla.datacenter.service.fallback;

import com.gla.datacenter.domain.ApiCatalogChange;
import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.MessageComment;
import com.gla.datacenter.service.MessageClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 熔断
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/9/28 16:18
 */
@Component
public class MessageClientServiceFallbackFactory implements FallbackFactory<MessageClientService> {
    @Override
    public MessageClientService create(Throwable throwable) {

        return new MessageClientService() {
            @Override
            public String saveMessage(Message message) {
                return null;
            }

            @Override
            public String saveMessageComment(MessageComment messageComment) {
                return null;
            }

            @Override
            public String update(Message message) {
                return null;
            }

            @Override
            public String updateComment(MessageComment messageComment) {
                return null;
            }

            @Override
            public String saveMessageCart(Message message, String id) {
                return null;
            }

            @Override
            public String updateMessage(String id, String btn, String content, Integer level) {
                return null;
            }

            @Override
            public String APIComplete(String apiid, String commentid) {
                return null;
            }

            @Override
            public String messagePosition(String id) {
                return null;
            }

            @Override
            public String updateMessageComment(String id, String btn, String content) {
                return null;
            }

            @Override
            public String delMessage(String id) {
                return null;
            }

            @Override
            public String delMessageComment(String id) {
                return null;
            }

            @Override
            public String getMessageById(String id) {
                return null;
            }

            @Override
            public String getMessageCommentById(String id) {
                return null;
            }

            @Override
            public String selectMessageList(Message message) {
                return null;
            }

            @Override
            public String selectMessageCommentList(MessageComment messageComment) {
                return null;
            }

            @Override
            public String getMessagePageList(Message message,String[] dealList) {
                return null;
            }

            @Override
            public String getMessageCommentPageList(MessageComment messageComment,String[] dealList) {
                return null;
            }

            @Override
            public String sendEmail(String userEmail, String type, String param) throws Exception {
                return null;
            }

            @Override
            public String getMessageDealCount(String userid) {
                return null;
            }

            @Override
            public String getCommentDealCount(String userid) {
                return null;
            }

            @Override
            public String getManagerDealCount(String receiverid) {
                return null;
            }

            @Override
            public String getNumOfInform(String userid) {
                return null;
            }

            @Override
            public String saveAppCart(Message message, String appid) {
                return null;
            }

            @Override
            public String dealMessageApp(String id, String optinion, String content, Integer level) {
                return null;
            }

            @Override
            public String saveApiCatalogChange(ApiCatalogChange apiCatalogChange) {
                return null;
            }

            @Override
            public String markRead(String ids) {
                return null;
            }

            @Override
            public String selectModelContent(String code) {
                return null;
            }

        };
    }
}
