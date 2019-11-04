package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.*;
import com.gla.datacenter.mapper.mysql.ApiCatalogChangeMapper;
import com.gla.datacenter.mapper.mysql.CatalogUserMapMapper;
import com.gla.datacenter.mapper.mysql.UserCatalogChangeMapMapper;
import com.gla.datacenter.service.ApiManagerClientService;
import com.gla.datacenter.service.MessageClientService;
import com.gla.datacenter.service.MessageTimerService;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

/**
 * @Author: zhengshien
 * @Date: 2019/3/17 16:12
 * @Description:
 */
@Service
public class MessageTimerServiceImpl implements MessageTimerService {

    private Logger log = LoggerFactory.getLogger(MessageTimerServiceImpl.class);

    private static final int ONEWEEKAGO = 7 * 24 * 60 * 60 * 1000;

    private static final String TITLE = "资源目录变更消息通知【订阅】";
    private static final String MODEL_CATALOG_MESSAGE = "MODEL_CATALOG_MESSAGE";

    /**
     * 引入ApiCatalogChangeMapper
     */
    @Autowired
    private ApiCatalogChangeMapper apiCatalogChangeMapper;

    /**
     * 引入CatalogUserMapMapper
     */
    @Autowired
    private CatalogUserMapMapper catalogUserMapMapper;

    /**
     * 引入UserCatalogChangeMapMapper
     */
    @Autowired
    private UserCatalogChangeMapMapper userCatalogChangeMapMapper;

    /**
     * 引入MessageMapper
     */
    @Autowired
//    private MessageService messageService;
    private MessageClientService messageClientService;

    /**
     * 引入ModelContentMapper
     */
//    @Autowired
//    private ModelContentMapper modelContentMapper;

    /**
     * 引入
     */
    @Autowired
    private ApiManagerClientService apiManagerClientService;

    @Override
    public void messageTimer() {

        //1、查询cata_change表，查出更新的目录
        //查询一周内的所有更新内容
        Date date = new Date();//当前时间
        Date oneweekago = new Date(date.getTime() - ONEWEEKAGO);//一周前
        //创建查询条件
        ApiCatalogChangeExample apiCatalogChangeExample = new ApiCatalogChangeExample();
        //查询一周内所有变更的资源目录数据
        apiCatalogChangeExample.createCriteria().andIdtBetween(oneweekago, date);
        List<ApiCatalogChange> apiCatalogChanges = null;
        try {
            apiCatalogChanges = apiCatalogChangeMapper.selectByExample(apiCatalogChangeExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }


        //2、根据目录编码在catalog_user_map表中查出相关用户的userid
        //2.1查询所有被订阅的目录集合
        CatalogUserMapExample catalogUserMapExample = new CatalogUserMapExample();
        List<CatalogUserMap> catalogUserMaps = null;
        try {
            catalogUserMaps = catalogUserMapMapper.selectByExample(catalogUserMapExample);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }

        //新建集合，收集被订阅目录的目录编码
        List subscribeList = new ArrayList();
        for (ApiCatalogChange apiCatalogChange : apiCatalogChanges) {
            //将被订阅的目录编码添加到集合中，作为条件供后面的查询使用
            if (!subscribeList.contains(apiCatalogChange.getCataCode())) {
                subscribeList.add(apiCatalogChange.getCataCode());
            }
        }

        //2.2新建集合，收集用户订阅的目录中，发生改变的目录集合
        List changeList = new ArrayList();
        for (CatalogUserMap catalogUserMap : catalogUserMaps) {
            //将用户订阅的目录编码作为查询条件到发生改变的目录编码集合中查询
//            Pattern pattern = Pattern.compile(catalogUserMap.getCatalogCode(), Pattern.CASE_INSENSITIVE);
            for (int i = 0; i < subscribeList.size(); i++) {
                //如果用户订阅的目录中包含发生改变的目录
                if (catalogUserMap.getCatalogCode().equals(subscribeList.get(i).toString())) {
                    if (!changeList.contains(catalogUserMap.getCatalogCode())) {
                        //则将发生改变的目录编码存入集合中
                        changeList.add(catalogUserMap.getCatalogCode());
                    }
                }
                //匹配查询结果
//                Matcher matcher=pattern.matcher(subscribeList.get(i).toString());
//                if (matcher.find()){
//                    if (!changeList.contains(catalogUserMap.getCatalogCode())) {
//                        //将发生改变的目录编码存入集合中
//                        changeList.add(catalogUserMap.getCatalogCode());
//                    }
//                }
            }
        }

        //2.3根据发生改变的目录编码查询哪些用户订阅了这些目录，并给用户发送消息

        //新建集合收集订阅目录发生改变的用户集合
        List userList = new ArrayList();
        for (Object userCatalogMap : changeList) {
            String s = userCatalogMap.toString();
            CatalogUserMapExample catalogUserMapExample1 = new CatalogUserMapExample();
            catalogUserMapExample1.createCriteria().andCatalogCodeEqualTo(s);
            List<CatalogUserMap> catalogUserMaps1 = catalogUserMapMapper.selectByExample(catalogUserMapExample1);
            for (CatalogUserMap catalogUserMap : catalogUserMaps1) {
                if (!userList.contains(catalogUserMap.getUserid())) {
                    userList.add(catalogUserMap.getUserid());
                }
            }
        }

        //3、分别给每个用户发送message
        for (Object userid : userList) {
            //Map工具，用于存放更新目录的相关内容，相当于消息的content
            MultiValueMap<String, Object> maps = new LinkedMultiValueMap<>();
            CatalogUserMapExample catalogUserMapExample1 = new CatalogUserMapExample();
            //根据用户ID和订阅状态查询目录
            catalogUserMapExample1.createCriteria().andUseridEqualTo(userid.toString()).andStatusEqualTo(Constant.NUMBER_1);
            //订阅的所有目录
            List<CatalogUserMap> subCataList = catalogUserMapMapper.selectByExample(catalogUserMapExample1);
            for (CatalogUserMap catalogUserMap : subCataList) {
                ApiCatalogChangeExample apiCatalogChangeExample1 = new ApiCatalogChangeExample();
                apiCatalogChangeExample1.createCriteria().andCataCodeEqualTo(catalogUserMap.getCatalogCode());
                //该用户所订阅的目录改变的内容
                List<ApiCatalogChange> apiCatalogChanges1 = apiCatalogChangeMapper.selectByExample(apiCatalogChangeExample1);
                //循环list集合，将变更目录名称和变更内容填入map中，以备之后使用
                for (ApiCatalogChange apiCatalogChange : apiCatalogChanges1) {
                    maps.add(apiCatalogChange.getCataName(), apiCatalogChange);
                }
            }

            try {
                //新建工具包，将变更的内容分成{name:...,apis:...}的数据格式
                List<Map> list=new ArrayList();
                for (Map.Entry entry : maps.entrySet()) {
                    Map contentMap = new HashMap();
                    //将目录名称放入map中
                    contentMap.put("name", entry.getKey());
                    //将该目录下所有变更的api放入map中
                    contentMap.put("apis", entry.getValue());
                    //将目录编码放入map中
                    //因为apis中的所有api的目录编码相同，所以获取apis中的任意一个api
                    List<ApiCatalogChange> value = (List) entry.getValue();
                    //获取list中第一个api，获取该api对象的cataCode，放入map中
                    contentMap.put("cataCode", value.get(Constant.NUMBER_0).getCataCode());
                    list.add(contentMap);
                }
//                尊敬的{0}您好，您所订阅目录下的API已作出如下变更：
                StringBuilder sb=new StringBuilder();
                String s = messageClientService.selectModelContent(MODEL_CATALOG_MESSAGE);
                sb.append(s);
                for (int i = 0; i < list.size(); i++) {
                    String name = (String) list.get(i).get("name");
                    sb.append(name).append(Constant.DHAO);
                }

                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1); //调用 字符串的deleteCharAt() 方法,删除最后一个多余的逗号
                }
                System.out.println("sb============"+sb);


                //将数据格式转换成json
                String RC3 = JsonUtils.toJson(list);

                //给用户发送消息
                String messageid = sendMessage(sb.toString(), String.valueOf(userid), String.valueOf(Constant.NUMBER_0), TITLE,RC3);
                //4、写入user_catalog_change_map，若发送成功，则记录发送状态为1
                saveUserCataChangeMap(userid.toString(), messageid, Constant.NUMBER_1);
                log.info(TextUtils.format("将消息通知给用户{0}", userid));
            } catch (Exception e) {
                //若发送失败，则记录发送状态为0
                saveUserCataChangeMap(userid.toString(), "", Constant.NUMBER_0);
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }


    private  String sendMessage(String content,String reveiver,String sender,String title,String rc3){
        Message message=new Message();
        message.setContent(content);
        message.setReceiverid(reveiver);
        message.setSenderid(sender);
        message.setTitle(title);
        message.setRc3(rc3);
        message.setMessagetype(String.valueOf(Constant.NUMBER_1));
        String s = messageClientService.saveMessage(message);
        return message.getId();
    }

    public static void main(String[] args) {
        MultiValueMap<String, String> stringMultiValueMap = new LinkedMultiValueMap<>();

        stringMultiValueMap.add("早班 9:00-11:00", "周一");
        stringMultiValueMap.add("早班 9:00-11:00", "周二");
        stringMultiValueMap.add("中班 13:00-16:00", "周三");
        stringMultiValueMap.add("早班 9:00-11:00", "周四");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周五");
        stringMultiValueMap.add("测试1天2次 09:00 - 12:00", "周六");
        stringMultiValueMap.add("中班 13:00-16:00", "周日");
        //打印所有值
        Set<String> keySet = stringMultiValueMap.keySet();
//        for (String key : keySet) {
//            List<String> values = stringMultiValueMap.get(key);
//            System.out.println(StringUtils.join(values.toArray()," ")+":"+key);
//
//        }

        for (Map.Entry entry : stringMultiValueMap.entrySet()) {
            entry.getKey();
            entry.getValue();
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }

//        System.out.println("map:"+stringMultiValueMap);
//        System.out.println(stringMultiValueMap.get("早班 9:00-11:00"));
    }

    private void saveUserCataChangeMap(String userid, String messageid, Integer status) {
        UserCatalogChangeMap uccm = new UserCatalogChangeMap();
        uccm.setId(StrUtils.randomUUID());
        uccm.setIdt(new Date());
        uccm.setUserid(userid);
        uccm.setCataChangeId(messageid);
        uccm.setStatus(status);
        userCatalogChangeMapMapper.insertSelective(uccm);
    }

}