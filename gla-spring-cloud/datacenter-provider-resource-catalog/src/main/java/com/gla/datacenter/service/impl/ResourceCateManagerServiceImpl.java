package com.gla.datacenter.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gla.datacenter.domain.Message;
import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.domain.RcsResourceCateExample;
import com.gla.datacenter.domain.UserInfo;
import com.gla.datacenter.intercepter.ApplicationContextHolder;
import com.gla.datacenter.mapper.mysql.RcsResourceCateMapper;
import com.gla.datacenter.model.ResourceApplyDeptResponseModel;
import com.gla.datacenter.model.ResourceCatalogRequestModel;
import com.gla.datacenter.service.MessageClientService;
import com.gla.datacenter.service.PlugCacheClientService;
import com.gla.datacenter.service.ResourceCateManagerService;
import com.gla.datacenter.service.UserInfoClientService;
import com.gla.datacenter.utils.ExeclUtil;
import com.gla.datacenter.utils.ReadExcel;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.core.constant.ResultMsg;
import com.limp.framework.utils.DateUtils;
import com.limp.framework.utils.RandomUtils;
import com.limp.framework.utils.StrUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: zhangbo
 * @Date: 2019/2/28 09:31
 * @Description:
 */
@Service
public class ResourceCateManagerServiceImpl implements ResourceCateManagerService {

    private Logger log = LoggerFactory.getLogger(ResourceCateManagerServiceImpl.class);

    @Autowired
    private RcsResourceCateMapper rcsResourceCateMapper;

    @Autowired
    private PlugCacheClientService plugCacheClientService;

    @Autowired
    private UserInfoClientService userInfoService;

    @Autowired
    private MessageClientService messageClientService;

    @Override
    public String getResourceCatalogPages(RcsResourceCate rcsResourceCate, Pager pager, String code) {

        String userId = ApplicationContextHolder.currentUser().getId();
        RcsResourceCateExample ex = new RcsResourceCateExample();
        ex.setPage(pager);
        if(StringUtils.isNotBlank(code)){
            //查询当前code分页是在第几页
            String pcode = StringUtils.isNotBlank(rcsResourceCate.getPcode()) ? "0" : rcsResourceCate.getPcode();
            int rows = pager.getRows();
            int page = rcsResourceCateMapper.getResourcePageByCode(userId ,code, pcode,rows,"online");
            pager.setPage(page);
            ex.setPage(pager);
        }
        ex.setOrderByClause(" IDT DESC");
        RcsResourceCateExample.Criteria criteria = ex.createCriteria();
        if(StringUtils.isNotBlank(rcsResourceCate.getPcode())){
            criteria.andPcodeEqualTo(rcsResourceCate.getPcode());
        }else{
            criteria.andPcodeEqualTo("0");
        }
        if(StringUtils.isNotBlank(rcsResourceCate.getName())){
            criteria.andNameLike("%" + rcsResourceCate.getName() +"%");
        }
        if(StringUtils.isNotBlank(rcsResourceCate.getKeyWord())){
            criteria.andCodeOrNameLike("%" + rcsResourceCate.getKeyWord() + "%");
        }
        if(rcsResourceCate.getLv() != null){
            criteria.andLvEqualTo(rcsResourceCate.getLv());
        }
        //criteria.andCreateIdEqualTo(userId);
        criteria.andStateEqualTo(1);
        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        try {
            rcsResourceCates = rcsResourceCateMapper.selectByExample(ex);
            if(rcsResourceCates != null && !rcsResourceCates.isEmpty()){
                //查看是否以被当前用户订阅

            }
        } catch (Exception e) {
            log.debug("用户{}获取资源目录分页数据查询失败!",userId);
            return Result.Error().getJson();
        }
        pager.setPagerInfo(rcsResourceCates,rcsResourceCates.size());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate, Pager pager, String code){

        String deptCode = ApplicationContextHolder.currentUser().getUnitcode();
        if(StringUtils.isNotBlank(code)){
            //查询当前code分页是在第几页
            String pcode = StringUtils.isNotBlank(rcsResourceCate.getPcode()) ? "0" : rcsResourceCate.getPcode();
            int rows = pager.getRows();
            int page = rcsResourceCateMapper.getResourcePageByCode(deptCode ,code, pcode,rows,"consumer");
            pager.setPage(page);
        }
        Map<String, Object> paramMap = new HashMap<>();
        if(StringUtils.isNotBlank(rcsResourceCate.getPcode())){
            paramMap.put("pCode",rcsResourceCate.getPcode());
        }else{
            paramMap.put("pCode","0");
        }
        paramMap.put("deptCode",deptCode);
        paramMap.put("keyword", rcsResourceCate.getKeyWord());

        int count = 0;
        try {
            Pager pagerCopy = null;
            count = rcsResourceCateMapper.getResourceCatalogConsumerPages(paramMap,pagerCopy).size();
        } catch (Exception e) {
            log.debug("消费者部门{}获取资源目录分页数据查询失败!",deptCode);
            return Result.Error().getJson();
        }
        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        try {
            rcsResourceCates = rcsResourceCateMapper.getResourceCatalogConsumerPages(paramMap,pager);
        } catch (Exception e) {
            log.debug("消费者部门{}获取资源目录分页数据查询失败!",deptCode);
            return Result.Error().getJson();
        }
        pager.setPagerInfo(rcsResourceCates,count);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String getResourceDraftPages(RcsResourceCate rcsResourceCate, Pager pager, String code) {

        Map<String, Object> paramMap = new HashMap<>();
        String userId = ApplicationContextHolder.currentUser().getId();

        if(StringUtils.isNotBlank(code)){
            //查询当前code分页是在第几页
            String pcode = StringUtils.isNotBlank(rcsResourceCate.getPcode()) ? "0" : rcsResourceCate.getPcode();
            int rows = pager.getRows();
            int page = rcsResourceCateMapper.getResourcePageByCode(userId ,code, pcode,rows,"draft");
            pager.setPage(page);
        }

        if(StringUtils.isNotBlank(rcsResourceCate.getPcode())){
            paramMap.put("pCode",rcsResourceCate.getPcode());
        }else{
            paramMap.put("pCode",0);
        }
        if(StringUtils.isNotBlank(rcsResourceCate.getKeyWord())){
            paramMap.put("codeOrName",rcsResourceCate.getKeyWord());
        }
        if(rcsResourceCate.getLv() != null){
            paramMap.put("lv",rcsResourceCate.getLv());
        }
        paramMap.put("userId", userId);

        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        try {
            rcsResourceCates = rcsResourceCateMapper.getResourceDraftPages(paramMap,pager);
        } catch (Exception e) {
            log.debug("获取资源目录分页数据查询失败!");
            return Result.Error().getJson();
        }
        pager.setPagerInfo(rcsResourceCates,rcsResourceCates.size());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String findCatalogInfor(String id) {
        ResourceApplyDeptResponseModel result = new ResourceApplyDeptResponseModel();
        RcsResourceCate rcsResourceCate = new RcsResourceCate();
        try {
            rcsResourceCate = rcsResourceCateMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            return Result.Error().getJson();
        }
        if(rcsResourceCate != null){
            if(rcsResourceCate.getShareType() == 2){
                //查询已授权的部门
                if(StringUtils.isNotBlank(rcsResourceCate.getShareMode())){
                    String[] deptIds = rcsResourceCate.getShareMode().split(Constant.DHAO);
                    //根据数组depts获取部门信息
                    List<Map<String, Object>> rcsResourceCates = rcsResourceCateMapper.getResourceDeptByDeptCode(deptIds);
                    result.setDeptList(rcsResourceCates);
                }
            }
        }
        List<RcsResourceCate> grandsonResourceByCodeAndLv = null;
        try {
            grandsonResourceByCodeAndLv = rcsResourceCateMapper.getGrandsonResourceByCodeAndLv(rcsResourceCate.getCode(), null);
        } catch (Exception e) {

        }
        if(grandsonResourceByCodeAndLv != null && !grandsonResourceByCodeAndLv.isEmpty()){
            result.setChild(true);
        }else{
            result.setChild(false);
        }
        result.setRcsResourceCate(rcsResourceCate);
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,result,null).getJson();
    }

    @Override
    public String findDeptResourceInfo(RcsResourceCate rcsResourceCate) {

        RcsResourceCateExample ex = new RcsResourceCateExample();
        RcsResourceCateExample.Criteria criteria = ex.createCriteria();
        criteria.andCodeLike("3%");
        if(StringUtils.isNotBlank(rcsResourceCate.getKeyWord())){
            criteria.andCodeOrNameLike("%" + rcsResourceCate.getKeyWord() + "%");
        }
        criteria.andStateEqualTo(1);
        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        try {
            rcsResourceCates = rcsResourceCateMapper.selectByExample(ex);
        } catch (Exception e) {
            log.debug("获取资源目录分页数据查询失败!");
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,rcsResourceCates,null).getJson();
    }

    @Override
    public String getResourceCataLogByLvPages(RcsResourceCate rcsResourceCate, Pager pager, boolean isDraft) {
        String userId = ApplicationContextHolder.currentUser().getId();

        Map<String, Object> paramMap = new HashMap<>();
        if(rcsResourceCate.getLv() != null){
            paramMap.put("lv",rcsResourceCate.getLv());
        }
        if(StringUtils.isNotBlank(rcsResourceCate.getName())){
            paramMap.put("name",rcsResourceCate.getName());
        }
        paramMap.put("userId",userId);
        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        try {
            rcsResourceCates = rcsResourceCateMapper.getResourceCataLogByLvPages(paramMap,pager,isDraft);
        } catch (Exception e) {
            log.debug("按条件(项、目、细目)获取资源目录分页数据查询失败!");
            return Result.Error().getJson();
        }
        List<RcsResourceCate> list = new ArrayList<>();
        Pager pagers = null;
        list = rcsResourceCateMapper.getResourceCataLogByLvPages(paramMap,pagers,isDraft);
        pager.setPagerInfo(rcsResourceCates,list.size());
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String resourceApproved(String code) {

        if(StringUtils.isBlank(code)){
            log.info("资源目录审核通过code不可为空");
            throw new RuntimeException("资源目录审核通过code不可为空");
        }
        String[] codeStr = code.split(Constant.DHAO);
        //存储新增的code值
        List<String> addCode = new ArrayList<>();
        List<String> deleteCode = new ArrayList<>();
        //查询该code数组中状态为审核中的记录
        List<RcsResourceCate> rcsResourceCates = rcsResourceCateMapper.getResourceApprovedByCode(codeStr);
        if(rcsResourceCates != null && !rcsResourceCates.isEmpty()){
            List<RcsResourceCate> addList = new ArrayList<>();
            for (RcsResourceCate rcs : rcsResourceCates){
                Integer draftType = rcs.getDraftType();
                if(draftType == 1){
                    //新增操作的审核通过后处理
                    addCode.add(rcs.getCode());
                }else{
                    if(draftType == 2){
                        rcs.setState(1);
                    }else if(draftType == 3){
                        rcs.setState(1);
                    }else if(draftType == 4){
                        rcs.setState(2);
                    }else if(draftType == 5){
                        rcs.setState(-1);
                    }
                    rcs.setDraftType(null);
                    deleteCode.add(rcs.getCode());
                    addList.add(rcs);
                }
            }

            //所有后续操作
            try{
                if(addCode != null && !addCode.isEmpty()){
                    //修改此code中的数据为上线、并且把DRAFT_TYPE置位null
                    rcsResourceCateMapper.updateApprovedStatu(addCode,"add");
                }
                if(deleteCode != null && !deleteCode.isEmpty()){
                    //修改审核通过后的初始数据状态为-1
                    rcsResourceCateMapper.updateApprovedStatu(deleteCode,"delete");
                }
                if(addList != null && !addList.isEmpty()){
                    for(RcsResourceCate rcs : addList){
                        rcsResourceCateMapper.updateByPrimaryKey(rcs);
                    }
                }
            }catch(Exception e){
                log.info("资源目录审核通过请求失败!");
                throw new RuntimeException("资源目录审核通过请求失败!");
            }
        }
        return null;
    }

    @Override
    public String resourceAuditFailure(String code) {

        if(StringUtils.isBlank(code)){
            log.info("资源目录审核通过code不可为空");
            throw new RuntimeException("资源目录审核通过code不可为空");
        }

        String[] codeStr = code.split(Constant.DHAO);
        List<String> codes = new ArrayList<>(Arrays.asList(codeStr));

        try {
            rcsResourceCateMapper.updateApprovedStatu(codes,"update");
        } catch (Exception e) {
            log.info("资源目录审核拒绝请求失败!");
            throw new RuntimeException("资源目录审核拒绝请求失败!");
        }
        return null;
    }

    @Override
    public ResponseEntity<byte[]> downloadTemplate(HttpServletRequest request){

        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in=null;
        try {
            in = getClass().getClassLoader().getResourceAsStream("template" + File.separator + "template.xls");

            byte[] bytes = new byte[in.available()];

            String fileName = "资源目录模板.xls";

            //处理IE下载文件的中文名称乱码的问题
            String header = request.getHeader("User-Agent").toUpperCase();
            //if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
                fileName = URLEncoder.encode(fileName, "utf-8");
                fileName = fileName.replace("+", "%20");
            //} else {
                //new String(file.getName().getBytes("UTF-8"),"iso-8859-1");
                //fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
            //}

            in.read(bytes);

            headers.add("Content-Disposition", "attachment;filename= "+fileName);

            entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(in!=null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return entity;
    }

    @Override
    public ResponseEntity<byte[]> downloadResource(HttpServletRequest request, String code) {


        if(StringUtils.isBlank(code)){
            throw new RuntimeException("当前未选择目录");
        }
        ResponseEntity<byte[]> result = null;
        //String[] ids = id.split(Constant.DHAO);

        //根据主键批量获取待导出资源目录

        List<RcsResourceCate> list = rcsResourceCateMapper.getResourceAllById(code);
        if(list != null && !list.isEmpty()){
            result = export(list);
        }

        return result;
    }

    @Override
    public ResponseEntity<byte[]> downloadErrorResource(HttpServletRequest request, String key) {


        if(StringUtils.isBlank(key)){
            throw new RuntimeException("参数错误!");
        }
        ResponseEntity<byte[]> result = null;

        //根据redis中key获取数据源
        Object resultStr = null;
        try {
            resultStr = plugCacheClientService.getCache(key);
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("redis查询异常文档数据失败!");
        }
        //Object obj = JSONObject.parse(resultStr);
        List<RcsResourceCate> list = JSONObject.parseArray(resultStr.toString(),RcsResourceCate.class);
        // = (List<RcsResourceCate>) resultStr;
        if(list != null && !list.isEmpty()){
            try{
                result = export(list);
            }catch (Exception e){
                e.getMessage();
            }
        }
        return result;
    }

    public ResponseEntity<byte[]> export(List<RcsResourceCate> list){

        String[] headArray = { "目录资源名称", "父目录资源代码", "共享类型", "开放属性", "共享部门编码", "摘要","更新周期"};
        List<Object[]> oList = new ArrayList<Object[]>();
        ResponseEntity<byte[]> result = null;
        for(RcsResourceCate map : list) {
            Integer shareTypeValue = map.getShareType();
            Integer openTypeValue = map.getOpenType();
            Integer updateCycle = map.getUpdateCycle();
            if(shareTypeValue == null) {
                map.setShareIntro("-");
            }else{
                if(shareTypeValue == 1) {
                    map.setShareIntro("无条件共享");
                }else if(shareTypeValue == 2){
                    map.setShareIntro("有条件共享");
                }else if(shareTypeValue == 3){
                    map.setShareIntro("不予共享");
                }
            }

            if(openTypeValue == null) {
                map.setProviderName("-");
            }else{
                if(openTypeValue == 1){
                    map.setProviderName("允许开放");
                }else if(openTypeValue == 2){
                    map.setProviderName("不可开放");
                }else{
                    map.setProviderName("-");
                }
            }

            if(updateCycle == null){
                map.setProviderCode("-");
            }else{
                if(updateCycle == 1){
                    map.setProviderCode("实时");
                }else if(updateCycle == 2){
                    map.setProviderCode("每日");
                }else if(updateCycle == 3){
                    map.setProviderCode("每周");
                }else if(updateCycle == 4){
                    map.setProviderCode("每月");
                }else if(updateCycle == 5){
                    map.setProviderCode("每季");
                }else if(updateCycle == 6){
                    map.setProviderCode("每年");
                }else{
                    map.setProviderCode("-");
                }
            }
            String[] obj = {map.getName(),map.getPcode(),map.getShareIntro(),map.getProviderName(),map.getShareMode(),map.getIntro(),map.getProviderCode(),String.valueOf(map.getType())};
            oList.add(obj);
        }

        try {
            result = ExeclUtil.ExportExcel(headArray, oList, "资源目录列表.xls",null,null,true);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException("资源目录导出失败！");
        }

        return result;
    }

    @Override
    public String importResource(MultipartFile file){

        if(file == null || file.isEmpty()){
            return Result.getException("当前文件不存在").getJson();
        }
        //获取文件后缀名称
        String filePath = file.getOriginalFilename();
        String userId = ApplicationContextHolder.currentUser().getId();
        String depeCode = ApplicationContextHolder.currentUser().getUnitcode();
        filePath = filePath.substring(filePath.lastIndexOf(".") + 1);
        if(!(filePath.equals("xls") || filePath.equals("xlsx"))){
            return Result.getException("文件暂不支持").getJson();
        }
        List<RcsResourceCate> errorList = new ArrayList<>();
        List<RcsResourceCate> uesList = new ArrayList<>();
        try {
            List<List<Object>> readExcel = ReadExcel.readExcel(file, filePath);
            List<List<RcsResourceCate>> resources = arrayToObj(readExcel);
            if(resources != null && !resources.isEmpty()){
                //查询当前所有的上线code

                for(List<RcsResourceCate> result : resources){
                    List<RcsResourceCate> insertList = new ArrayList<>();
                    List<RcsResourceCate> noUseList = new ArrayList<>();
                    for(RcsResourceCate rcs : result){
                        if(rcs.getType() == null){
                            insertList.add(rcs);
                        }else{
                            noUseList.add(rcs);
                        }
                    }
                    errorList.addAll(noUseList);
                    try{
                        rcsResourceCateMapper.insertBatch(insertList,userId,depeCode);
                        uesList.addAll(insertList);
                    }catch(Exception e){
                        for(RcsResourceCate r : insertList){
                            r.setId(StrUtils.randomUUID());
                            r.setCreateId(userId);
                            r.setIdt(new Date());
                            try{
                                rcsResourceCateMapper.insertSelective(r);
                                uesList.add(r);
                            }catch(Exception e1){
                                r.setType(2);
                                errorList.add(r);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getException("导入失败").getJson();
        }

        Map<String, Object> resulyNum = new HashMap<>();
        resulyNum.put("error",errorList.size());
        resulyNum.put("normal",uesList.size());
        if(errorList.size() > 0){
            String rId = StrUtils.randomUUID();
            uesList.addAll(errorList);
            plugCacheClientService.setCache(rId, JSONArray.toJSONString(uesList),3000L);
            resulyNum.put("rId",rId);
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resulyNum,null).getJson();
    }

    @Override
    public String deleteResourceCata(boolean flag, String id) {

        RcsResourceCate rcsResourceCate = rcsResourceCateMapper.selectByPrimaryKey(id);
        try{
            if(flag){

                //递归查询待删除的所有子节点目录
                //List<RcsResourceCate> grandsonResources = rcsResourceCateMapper.getGrandsonResourceByCodeAndLv(rcsResourceCate.getCode(), null);
                /*if(grandsonResources != null && !grandsonResources.isEmpty()){
                    return Result.getException("当前目录包含孙目录，不能删除!").getJson();
                }*/
                //获取当前选中节点草稿箱中的节点目录
                List<RcsResourceCate> rcsResourceCates = rcsResourceCateMapper.getResourceDraftAllByPCode(rcsResourceCate.getCode());
                if(rcsResourceCates != null && !rcsResourceCates.isEmpty()){
                    String userId = ApplicationContextHolder.currentUser().getId();
                    List<String> codeList = new ArrayList<>();
                    List<String> draftList = new ArrayList<>();
                    List<RcsResourceCate> otherList = new ArrayList<>();
                    for (RcsResourceCate r : rcsResourceCates){
                        //草稿直接逻辑删除
                        if(r.getState() == 3){
                            draftList.add(r.getId());
                            codeList.add(r.getCode());
                        }else if(r.getState() == 1){
                            otherList.add(r);
                        }
                    }
                    if(draftList != null && !draftList.isEmpty()){
                        //批量逻辑删除草稿
                        String[] draftArray = draftList.toArray(new String[draftList.size()]);
                        rcsResourceCateMapper.updateResourceStateById(draftArray,userId,-1);
                        //根据草稿code获取是否有上线的资源目录
                        List<RcsResourceCate> useResource = rcsResourceCateMapper.getResourceUseingByCodes(codeList);
                        otherList.addAll(useResource);
                    }
                    if(otherList != null && !otherList.isEmpty()){

                        //新增删除草稿
                        List<RcsResourceCate> otherListCopy = new ArrayList<>(new HashSet(otherList));
                        for(RcsResourceCate rr : otherListCopy){
                            rr.setId(StrUtils.randomUUID());
                            rr.setUdt(DateUtils.getTimestamp());
                            rr.setUpdateId(userId);
                            rr.setState(3);
                            rr.setDraftType(5);
                            rcsResourceCateMapper.insertSelective(rr);
                        }
                    }
                }
            }else{
                //删除所选中的目录
                if(rcsResourceCate.getState() == 3){
                    String userId = ApplicationContextHolder.currentUser().getId();
                    String[] str = new String[]{rcsResourceCate.getId()};
                    rcsResourceCateMapper.updateResourceStateById(str,userId,-1);
                    //查询是否存在线上的资源目录
                    RcsResourceCate resourceUseingByCode = rcsResourceCateMapper.getResourceUseingByCode(rcsResourceCate.getCode());
                    if(resourceUseingByCode != null){
                        resourceUseingByCode.setId(StrUtils.randomUUID());
                        resourceUseingByCode.setUdt(DateUtils.getTimestamp());
                        resourceUseingByCode.setUpdateId(userId);
                        resourceUseingByCode.setState(3);
                        resourceUseingByCode.setDraftType(5);
                        rcsResourceCateMapper.insertSelective(resourceUseingByCode);
                    }
                }else if(rcsResourceCate.getState() == 1){
                    String userId = ApplicationContextHolder.currentUser().getId();
                    rcsResourceCate.setId(StrUtils.randomUUID());
                    rcsResourceCate.setUdt(DateUtils.getTimestamp());
                    rcsResourceCate.setUpdateId(userId);
                    rcsResourceCate.setState(3);
                    rcsResourceCate.setDraftType(5);
                    rcsResourceCateMapper.insertSelective(rcsResourceCate);
                }
            }
        }catch(Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
            log.error("id为{}删除资源目录失败!",id);
            return Result.getException("删除失败").getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.DEL_SUCCESS,null,null).getJson();
    }

    @Override
    public String onlineOffline(String id, int statu) {

        //修改当前id的资源目录为草稿
        RcsResourceCate rcsResourceCate = rcsResourceCateMapper.selectByPrimaryKey(id);
        rcsResourceCate.setState(3);
        rcsResourceCateMapper.updateByPrimaryKeySelective(rcsResourceCate);

        return null;
    }

    @Override
    public String saveResource(RcsResourceCate rcsResourceCate) {

        String id = StrUtils.randomUUID();
        String userId = ApplicationContextHolder.currentUser().getId();
        String deptCode = ApplicationContextHolder.currentUser().getUnitcode();
        String deptName = ApplicationContextHolder.currentUser().getDeptName();
        rcsResourceCate.setId(id);
        String code = "";
        try{
            code = createResourceCodeByPcode(rcsResourceCate.getPcode());
        }catch(IllegalArgumentException e){
            return Result.getException("参数有误!").getJson();
        }catch (ArithmeticException e1){
            return Result.getException("所选类的资源分类代码已饱和!").getJson();
        }

        rcsResourceCate.setCode(code);
        rcsResourceCate.setProviderCode(deptCode);
        rcsResourceCate.setProviderName(deptName);
        rcsResourceCate.setCreateId(userId);
        rcsResourceCate.setState(3);
        rcsResourceCate.setDraftType(1);
        rcsResourceCate.setPublishId(userId);
        rcsResourceCate.setIdt(new Date());
        try {
            //根据父code获取父pcodes
            RcsResourceCate r = rcsResourceCateMapper.getResourceUseingByCode(rcsResourceCate.getPcode());
            if(r != null){
                rcsResourceCate.setPcodes((StringUtils.isEmpty(r.getPcodes()) ? r.getCode() : (r.getPcodes() + r.getCode())) + ",");
            }
            rcsResourceCateMapper.insertSelective(rcsResourceCate);
        } catch (Exception e) {
            log.info("用户{}新增资源目录失败",userId);
            return Result.Error().getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,null,null).getJson();
    }

    public String createResourceCodeByPcode(String pcode){
        RcsResourceCate resourceUseingByCode = null;
        String code = "";
        try {
            resourceUseingByCode = rcsResourceCateMapper.getResourceUseingByCode(pcode);
            if(resourceUseingByCode == null){
                throw new Exception();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException ();
        }
        //String pCode = StringUtils.isBlank(resourceUseingByCode.getPcodes()) ? resourceUseingByCode.getCode() : resourceUseingByCode.getPcodes();
        //获取子集级别
        Integer lv = resourceUseingByCode.getLv() + 1;
        //获取当前code下的子集code长度
        int maxNum = lv + 1;
        //获取当前父级下的最大子集
        int length = RandomUtils.gaosiFunc(maxNum);
        String maxCode = rcsResourceCateMapper.getResourceMaxCodeByPcode(pcode,length);
        if(StringUtils.isBlank(maxCode)){
            code = pcode + String.format("%0" + maxNum + "d",1);
        }else{
            //获取子类目录最大值的后几位
            String substring = maxCode.substring(maxCode.indexOf(pcode) + pcode.length());
            int num = Integer.valueOf(substring)+1;
            if(String.valueOf(num).length() <= maxNum){
                code = pcode + String.format("%0" + maxNum + "d",num);
            }
        }
        /*if(code.length() > maxNum){
            throw new ArithmeticException("");
        }*/
        return code;
    }

    @Override
    public String revokeResource(boolean flag, String id) {

        String userId = ApplicationContextHolder.currentUser().getId();
        RcsResourceCate rcsResourceCate = null;
        try {
            rcsResourceCate = rcsResourceCateMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.info("用户{}撤销操作失败!",userId);
            return Result.Error().getJson();
        }
        if(rcsResourceCate == null){
            return Result.getException("选中的目录已不存在!").getJson();
        }
        if(flag){
            //向下全部撤销
            //根据选中code向下查询所有修改、删除、下线操作的并且未提交审核的资源目录集合
            List<String> ids = rcsResourceCateMapper.getResourceAlowByCode(rcsResourceCate.getCode());
            if(ids != null && !ids.isEmpty()){
                try {
                    rcsResourceCateMapper.updateResourceAlow(ids,userId);
                } catch (Exception e) {
                    log.info("用户{}撤销操作失败!",userId);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
                    return Result.Error().getJson();
                }
            }
        }else{
            //只撤销选中的资源目录
            if(rcsResourceCate != null){
                Integer state = rcsResourceCate.getState();
                if(state != 3){
                    return Result.getException("当前目录未做任何操作，不能撤销!").getJson();
                }
                rcsResourceCate.setState(-1);
                rcsResourceCate.setUpdateId(userId);
                rcsResourceCate.setUdt(DateUtils.getTimestamp());
                try {
                    rcsResourceCateMapper.updateByPrimaryKeySelective(rcsResourceCate);
                } catch (Exception e) {
                    log.info("用户{}撤销操作失败!",userId);
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly(); //手动开启事务回滚
                    return Result.Error().getJson();
                }
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,null,null).getJson();
    }

    @Override
    public String getAllElderById(String id) {

        if(StringUtils.isBlank(id)){
            return Result.getException("当前未选中目录!").getJson();
        }

        RcsResourceCate rcsResourceCate = new RcsResourceCate();
        try {
            rcsResourceCate = rcsResourceCateMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            log.error("根据{}查询资源目录失败",id);
            return Result.getException("参数有误!").getJson();
        }
        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        if(rcsResourceCate != null){
            String pCodes = rcsResourceCate.getPcodes();
            if(StringUtils.isNotBlank(pCodes)){
                pCodes = pCodes.substring(0,pCodes.length()-1);
                String[] pcode = pCodes.split(Constant.DHAO);
                //根据pCode获取所有父节点
                try {
                    rcsResourceCates = rcsResourceCateMapper.getResourceAllByCode(pcode);
                } catch (Exception e) {
                    return Result.getException("查询失败!").getJson();
                }
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,rcsResourceCates,null).getJson();
    }

    @Override
    public String updateResourceCate(RcsResourceCate rcsResourceCate) {
        if(rcsResourceCate == null){
            return Result.getException("数据有误!").getJson();
        }
        String userId = ApplicationContextHolder.currentUser().getId();
        //首先查询当前code是否存在上线中的数据
        RcsResourceCate resourceUseingByCode = null;
        try {
            resourceUseingByCode = rcsResourceCateMapper.getResourceUseingByCode(rcsResourceCate.getCode());
        } catch (Exception e) {
            log.error("用户{}查询当前code为{}的数据失败",userId,rcsResourceCate.getCode());
            return Result.getException("操作失败!").getJson();
        }
        if(resourceUseingByCode != null){
            RcsResourceCate resourceDraftOrAuditByCode = null;
            //查询是否存在草稿或者审核中的数据
            resourceDraftOrAuditByCode = rcsResourceCateMapper.getDraftOrAuditByCode(rcsResourceCate.getCode());
            if(resourceDraftOrAuditByCode != null){
            }else{
                rcsResourceCate.setId(StrUtils.randomUUID());
                rcsResourceCate.setUdt(DateUtils.getTimestamp());
                rcsResourceCate.setUpdateId(userId);
                rcsResourceCate.setState(3);
                rcsResourceCate.setDraftType(2);
                try {
                    rcsResourceCateMapper.insertSelective(rcsResourceCate);
                    return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
                } catch (Exception e) {
                    return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.UPDATE_ERROR,null,null).getJson();
                }
            }
        }
        try {
            rcsResourceCate.setUdt(DateUtils.getTimestamp());
            rcsResourceCate.setUpdateId(userId);
            rcsResourceCateMapper.updateByPrimaryKeySelective(rcsResourceCate);
        } catch (Exception e) {
            return Result.getInstance(ResultCode.ERROR.toString(),ResultMsg.UPDATE_ERROR,null,null).getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.UPDATE_SUCCESS,null,null).getJson();
    }

    @Override
    public String submitAuditResource() {

        UserInfo userInfo = ApplicationContextHolder.currentUser();
        String userId = userInfo.getId();
        String account = userInfo.getAccount();
        //查询当前待审核目录
        List<RcsResourceCate> list = null;
        try {
            list = rcsResourceCateMapper.getResourceByStatu(3,userId);
        } catch (Exception e) {
            log.error("用户{}对目录提交审核未查询到数据",userId);
            return Result.getException("提交审核失败").getJson();
        }

        if(list.isEmpty()){
            return Result.getException("当前没有待审核目录").getJson();
        }
        List<String> strs = new ArrayList<>();
        if(list != null && !list.isEmpty()){
            Map<String, Object> map = new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String dateTime = sdf.format(new Date());
            List<String> pCodeList = list.stream().map(v -> v.getPcode()).collect(Collectors.toList());
            // 根据pCode获取当前父目录名称
            List<Map<String, String>> pCodeNameList = rcsResourceCateMapper.getResourceNameByCodeList(pCodeList);
            Map<String, String> pCodeName = pCodeNameList.stream().filter(a -> !StrUtils.isBlank(a.get("code"))).collect(Collectors.toMap(e -> e.get("code"), e -> e.get("name"), (e1, e2) -> e2));
            for(RcsResourceCate r : list){
                strs.add(r.getId());
                String operate =  "";
                //String resourceLvName = "";
                String pLvName = lvIntCaseString(r.getLv() - 1);
                String lvName = lvIntCaseString(r.getLv());
                //Map<String, Object> valueMap = new HashMap<>();
                switch (r.getDraftType()){
                    case 1:
                        operate = "新增";
                        break;
                    case 2:
                        operate = "编辑";
                        break;
                    case 3:
                        operate = "上线";
                        break;
                    case 4:
                        operate = "下线";
                        break;
                    case 5:
                        operate = "删除";
                        break;
                }
                /*valueMap.put("operate",r.getDraftType() == null ? null : r.getDraftType());
                valueMap.put("name",r.getName() == null ? null : r.getName());
                valueMap.put("code",r.getCode() == null ? null : r.getCode());
                valueMap.put("pcode",r.getPcode() == null ? null : r.getPcode());
                valueMap.put("providerCode",r.getProviderCode() == null ? null : r.getProviderCode());
                valueMap.put("shareType",r.getShareType() == null ? null : r.getShareType());
                valueMap.put("openType",r.getOpenType() == null ? null : r.getOpenType());
                valueMap.put("lv",r.getLv() == null ? null : r.getLv());
                valueMap.put("updateCycle",r.getUpdateCycle() == null ? null : r.getUpdateCycle());*/
                Message message = new Message();
                message.setTitle("资源目录变更审核");
                message.setContent(operate + r.getName() + ",请求通过!");
                //message.setApprule(JSONObject.toJSONString(valueMap));
                String appendStr = StrUtils.isBlank(pLvName) ? "" : (pLvName + pCodeName.get(r.getCode()) + "下");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(r.getCode(),account + " " + dateTime + "  " + appendStr + operate + "了" + lvName);
                message.setApprule(jsonObject.toJSONString());
                message.setMessagetype("4");
                //管理员设定的为0
                //message.setReceiverid(adminInfo != null ? adminInfo.getId() : "0");
                message.setReceiverid("0");
                message.setSenderid(userId);
                try {
                    messageClientService.saveMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.getException("提交审核失败").getJson();
                }
                //map.put(r.getCode(),valueMap);
            }

            //初始化消息对象
            /*//获取当前管理者账号
            UserInfo adminInfo = null;
            try {
                adminInfo = userInfoService.getAdminInfo();
            } catch (Exception e) {
                log.error("获取管理员用户信息失败!");
            }*/
            //修改提交审核的资源目录未待审核状态
            try {
                String[] ids = new String[list.size()];
                ids = strs.toArray(ids);
                rcsResourceCateMapper.updateResourceStateById(ids,userId,4);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("修改草稿资源目录为待审核失败!");
            }
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,null,null).getJson();
    }

    public String lvIntCaseString(int lv){
        String resourceLvName = "";
        switch (lv){
            case 0:
                resourceLvName = "类";
                break;
            case 1:
                resourceLvName = "项";
                break;
            case 2:
                resourceLvName = "目";
                break;
            case 3:
                resourceLvName = "细目";
        }
        return resourceLvName;
    }

    @Override
    public String countResourceCatalogByConsumer() {

        String deptCode = ApplicationContextHolder.currentUser().getUnitcode();

        Map<String, Object> resultMap = new HashMap<>();
        try {
            resultMap = rcsResourceCateMapper.countResourceCatalogByConsumer(deptCode);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.getException("查询失败!").getJson();
        }
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,resultMap,null).getJson();
    }

    @Override
    public String searchResourceCatalogConsumerPages(ResourceCatalogRequestModel resourceCatalogRequestModel, Pager pager) {

        Map<String, Object> paramMap = new HashMap<>();
        if(StringUtils.isNotBlank(resourceCatalogRequestModel.getKeyWord())){
            paramMap.put("keyword", resourceCatalogRequestModel.getKeyWord());
        }
        String deptCode = ApplicationContextHolder.currentUser().getUnitcode();
        String[] catagory = resourceCatalogRequestModel.getCatagory();
        String[] item = resourceCatalogRequestModel.getItem();
        Date[] time = resourceCatalogRequestModel.getTime();
        if(catagory != null && catagory.length > 0){
            paramMap.put("catagory",catagory);
        }
        if(item != null && item.length > 0){
            List<String> itemArray = new ArrayList<>(Arrays.asList(item));
            paramMap.put("item",itemArray);
        }
        if(time != null && time.length > 0){
            paramMap.put("startTime",time[0]);
            paramMap.put("endTime",time[1]);
        }
        Integer openType = resourceCatalogRequestModel.getOpenType();
        if(openType != null){
            paramMap.put("openType",openType);
        }
        paramMap.put("deptCode",deptCode);
        String providerCode = resourceCatalogRequestModel.getProviderCode();
        if(StringUtils.isNotBlank(providerCode)){
            paramMap.put("provider",providerCode);
        }
        int count = 0;
        try {
            Pager pagerCopy = null;
            count = rcsResourceCateMapper.searchResourceCatalogConsumerPages(paramMap,pagerCopy).size();
        } catch (Exception e) {
            log.error(e.getMessage());
            log.debug("消费者部门{}获取资源目录分页数据查询失败!",deptCode);
            return Result.Error().getJson();
        }
        List<RcsResourceCate> rcsResourceCates = new ArrayList<>();
        try {
            rcsResourceCates = rcsResourceCateMapper.searchResourceCatalogConsumerPages(paramMap,pager);
        } catch (Exception e) {
            log.debug("消费者部门{}获取资源目录分页数据查询失败!",deptCode);
            log.error(e.getMessage());
            return Result.Error().getJson();
        }
        pager.setPagerInfo(rcsResourceCates,count);
        return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String getResourceClass(int lv) {
        List<RcsResourceCate> list = new ArrayList<>();
        try {
            list = rcsResourceCateMapper.getResourceCatagoryByLv(lv);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.Error().getJson();
        }

        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,list,null).getJson();
    }

    private List<List<RcsResourceCate>> arrayToObj(List<List<Object>> readExcel) {

        Set<List<RcsResourceCate>> resourcesList = new HashSet<>();
        List<RcsResourceCate> resources = new ArrayList<>();
        //保存最新的code
        Map<String, String> map = new HashMap<>();
        List<String> nowStr = rcsResourceCateMapper.getResourceStringArrayByState(1,null);
        for (int i = 1; i < readExcel.size(); i++) {
            if(resources.size() >= 50){
                resourcesList.add(resources);
                resources = new ArrayList<>();
            }
            // 将集合中的数据转换成对象
            List<Object> list = readExcel.get(i);
            RcsResourceCate rcs = new RcsResourceCate();
            if(list.get(0) == null || list.get(0) == ""){
                rcs.setName(null);
            }else{
                rcs.setName(list.get(0).toString());
            }
            if(list.get(1) == null || list.get(1) == ""){
                rcs.setPcode(null);
            }else{
                rcs.setPcode(list.get(1).toString());
            }

            if(list.get(2) == null || list.get(2) == ""){
                rcs.setShareType(null);
            }else{
                if (list.get(2).toString().trim().equals("无条件共享".trim())) {
                    rcs.setShareType(1);
                }else if(list.get(2).toString().trim().equals("有条件共享".trim())) {
                    rcs.setShareType(2);
                }else if(list.get(2).toString().trim().equals("不予共享".trim())) {
                    rcs.setShareType(3);
                }else {
                    rcs.setShareType(null);
                }
            }

            if(list.get(3) == null || list.get(3) == ""){
                rcs.setOpenType(null);
            }else{
                if(list.get(3).toString().trim().equals("允许开放")){
                    rcs.setOpenType(1);
                }else if(list.get(3).toString().trim().equals("不可开放")){
                    rcs.setOpenType(2);
                }else{
                    rcs.setOpenType(null);
                }
            }
            if(list.get(4) == null || list.get(4) == ""){
                rcs.setShareMode(null);
            }else{
                rcs.setShareMode(list.get(4).toString());
            }

            if(list.get(5) == null || list.get(5) == ""){
                rcs.setIntro(null);
            }else{
                rcs.setIntro(list.get(5).toString());
            }

            if(list.get(6) == null || list.get(6) == ""){
                rcs.setUpdateCycle(null);
            }else{
                if(list.get(6).toString().trim().equals("实时")){
                    rcs.setUpdateCycle(1);
                }else if(list.get(6).toString().trim().equals("每日")){
                    rcs.setUpdateCycle(2);
                }else if(list.get(6).toString().trim().equals("每周")){
                    rcs.setUpdateCycle(3);
                }else if(list.get(6).toString().trim().equals("每月")){
                    rcs.setUpdateCycle(4);
                }else if(list.get(6).toString().trim().equals("每季")){
                    rcs.setUpdateCycle(5);
                }else if(list.get(6).toString().trim().equals("每年")){
                    rcs.setUpdateCycle(6);
                }
            }
            //rcs.setPublishDate(new Date());
            rcs.setDraftType(1);
            rcs.setState(3);

            //1：初始化code和lv等信息 2：记录失败和成功数据条数
            if(StringUtils.isBlank(rcs.getPcode()) || !nowStr.contains(rcs.getPcode())){
                rcs.setType(2);
                resources.add(rcs);
                continue;
            }
            RcsResourceCate resourceUseingByCode = null;
            try {
                resourceUseingByCode = rcsResourceCateMapper.getResourceUseingByCode(rcs.getPcode());
            } catch (Exception e) {
                e.printStackTrace();
            }

            if(resourceUseingByCode != null){
                rcs.setLv(resourceUseingByCode.getLv() + 1);
                rcs.setPcodes((StringUtils.isBlank(resourceUseingByCode.getPcodes()) ? resourceUseingByCode.getCode() : (resourceUseingByCode.getPcodes() + resourceUseingByCode.getCode())) + ",");
                if(rcs.getPcode() == null || rcs.getShareType() == null || rcs.getOpenType() == null){
                    rcs.setType(2);
                }
                try {
                    String code = "";
                    //获取所选父目录的code
                    String fatherCode = resourceUseingByCode.getCode();
                    if(map.containsKey(fatherCode)){
                        String maxCode = map.get(fatherCode);
                        String lastCode = maxCode.substring(maxCode.indexOf(fatherCode)+1,maxCode.length());
                        int lastNum = Integer.valueOf(lastCode) + 1;
                        code = fatherCode + String.format("%0" + lastCode.length() + "d",lastNum);
                        /*if(String.valueOf(lastNum).toString().length() > lastCode.length()){
                            //长度超限,标记为错误数据
                            rcs.setType(2);
                        }*/
                    }else{
                        code = createResourceCodeByPcode(rcs.getPcode());
                    }
                    map.put(resourceUseingByCode.getCode(),code);
                    rcs.setCode(code);
                } catch (Exception e) {
                    rcs.setType(2);
                }

            }
            resources.add(rcs);
        }
        resourcesList.add(resources);
        List<List<RcsResourceCate>> resultList = new ArrayList<>();
        resultList.addAll(resourcesList);
        return resultList;
    }

}
