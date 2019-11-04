package com.gla.datacenter.service.impl;

import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.mapper.mysql.RcsResourceCateMapper;
import com.gla.datacenter.service.ResourceCateApiService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.bean.ResultCode;
import com.limp.framework.core.constant.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: zhangbo
 * @Date: 2019/3/26 15:51
 * @Description:
 */
@Service
public class ResourceCateApiServiceImpl implements ResourceCateApiService {

    @Autowired
    private RcsResourceCateMapper rcsResourceCateMapper;

    @Override
    public List<RcsResourceCate> getResourceCatalogByCodes(String[] code) {

        List<RcsResourceCate> list = new ArrayList<>();
        if(code != null && code.length > 0){
            List<String> codeArray = new ArrayList<>(Arrays.asList(code));
            list = rcsResourceCateMapper.getResourceUseingByCodes(codeArray);
        }
        return list;
    }

    @Override
    public String getResourcePageListByResourceCode(RcsResourceCate rcsResourceCate, Pager pager) {

        List<String> codes = rcsResourceCate.getCodes();
        if(codes == null || codes.isEmpty()){
            return Result.getInstance(ResultCode.SUCCESS.toString(), ResultMsg.SUCCESS,pager,null).getJson();
        }
        List<RcsResourceCate> list = new ArrayList<>();
        int count = 0;
        try {
            Pager pagerCopy = null;
            count = rcsResourceCateMapper.getResourcePageListByResourceCode(rcsResourceCate,pagerCopy,codes).size();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.getException("请求失败!").getJson();
        }
        list = rcsResourceCateMapper.getResourcePageListByResourceCode(rcsResourceCate,pager,codes);
        pager.setPagerInfo(list,count);
        return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,pager,null).getJson();
    }

    @Override
    public String getFoundationalLibraryCatalog() {

        try {
            /*查询所有的基础库*/
            List<Map<String, Object>> strList = rcsResourceCateMapper.getFoundationalLibraryCode("1");
            if(strList != null && !strList.isEmpty()){
                for(Map<String, Object> map : strList){
                    String code = map.get("code").toString();
                    Integer count = rcsResourceCateMapper.getFoundationalLibraryCatalog(code);
                    map.put("count",count);
                }
            }
            //List<Map<String, Object>> list = rcsResourceCateMapper.getFoundationalLibraryCatalog();
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,strList,null).getJson();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
    }

    @Override
    public String getThreeLibraryCatalog(){
        try {
            /*查询三大类*/
            List<Map<String, Object>> strList = rcsResourceCateMapper.getFoundationalLibraryCode("0");
            if(strList != null && !strList.isEmpty()){
                for(Map<String, Object> map : strList){
                    String code = map.get("code").toString();
                    Integer count = rcsResourceCateMapper.getFoundationalLibraryCatalog(code);
                    map.put("count",count);
                }
            }
            //List<Map<String, Object>> list = rcsResourceCateMapper.getFoundationalLibraryCatalog();
            return Result.getInstance(ResultCode.SUCCESS.toString(),ResultMsg.SUCCESS,strList,null).getJson();
        } catch (Exception e) {
            e.printStackTrace();
            return Result.Error().getJson();
        }
    }

    @Override
    public Integer getResourceCOunt() {

        Integer num = 0;
        try {
            num = rcsResourceCateMapper.getFoundationalLibraryCatalog(null);
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String, Object> getResourcePcodesByCode(String[] list) {


        if(list == null && list.length <= 0){
            return null;
        }

        try {
            Map<String, Object> map = new HashMap<>();

            List<RcsResourceCate> pcodeList = rcsResourceCateMapper.getResourceBLOBsByCodes(new ArrayList<>(Arrays.asList(list)));
            if(pcodeList.isEmpty()){
                return map;
            }
            for(RcsResourceCate rcs : pcodeList){
                map.put(rcs.getCode(),rcs.getPcodes());
                map.put(rcs.getCode() + "image",rcs.getBaseImage());
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
