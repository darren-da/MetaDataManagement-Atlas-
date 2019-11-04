package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.DicCode;
import com.limp.framework.boss.domain.PageLog;
import com.limp.framework.boss.mapper.oracle.PageLogMapper;
import com.limp.framework.boss.service.CacheService;
import com.limp.framework.boss.service.CommonService;
import com.limp.framework.boss.service.SysService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @Author: zzh
 * @Modified By:
 * @Date: 2018/10/17 16:54
 */
@Service
public class CommonServiceImpl implements CommonService {

    private static Logger log= Logger.getLogger(CommonServiceImpl.class);

    @Resource
    private PageLogMapper pageLogMapper;

    @Resource
    private CacheService cacheService;
    /**
     *字典码表
     */
    @Autowired
    private SysService dictCodesService;

    @Override
    public void insertPageLog(PageLog pageLog) {
        try{
            if (StrUtils.isBlank(pageLog.getId())) {
                pageLog.setId(StrUtils.randomUUID());
            }
            if (StrUtils.isBlank(pageLog.getState())) {
                pageLog.setState(Constant.STATE_EFFECTIVE);
            }
            if (StrUtils.isBlank(pageLog.getIdt())) {
                pageLog.setIdt(new Date());
            }
            pageLogMapper.insert(pageLog);
        }catch (Exception e){
            log.debug("/****日志记录异常************/");
            e.printStackTrace();
        }

    }


    @Override
    public String transCodeZN(String jsonStr) {
        //lp_code_  }或者]结尾【定义需要替换CODE的正则匹配规则】
        final  String pattern= Constant.CODE_TRANS_PRE+"(.*?)[,|\\}|\\]]";

        //key 的集合 （唯一；去重）
        List listUnKsy=new ArrayList();

        //需要转化的码表 key 和value对应集合
        List<Map<String,String>> listMapMath=new ArrayList<Map<String,String>>();

        //匹配List得到的Group分组
        List<String> groups= StrUtils.getRegGroupList(jsonStr, pattern);
        Long start=System.currentTimeMillis();
        log.debug(TextUtils.format("-----获取key-value值-----"));
        for(String group:groups){
            String []groupArr=group.split(":");
            if(groupArr.length>1){
                String codeMath=groupArr[1].replaceAll("\'|\"", "");
                //如果该value值已经获取相应的码值，则不再进行查询
                if(!StrUtils.isBlank(codeMath)&&!listUnKsy.contains(codeMath)){
                    listUnKsy.add(codeMath);
                    Map<String,String> code=new HashMap<String,String>();
                    String value=getCacheCodeValue(codeMath);//commonService.getCacheCodeValue(codeMath);
                    //只有value不为空，才进行转化
                    if(!StrUtils.isBlank(value)){
                        code.put("key",codeMath);
                        code.put("value", StrUtils.isBlank(value) ? codeMath : value);
                        code.put("pre",groupArr[1].indexOf("\"")>-1?"\"":"\'" );
                        listMapMath.add(code);
                    }

                }
            }
        }
        Long end=System.currentTimeMillis();
        log.debug(TextUtils.format("----->获取key-value值需要时间{0}[key-value]-----",(end-start)));

        for(Map<String,String> mapF:listMapMath){
            final String reg="(:'"+mapF.get("key")+"'|:\""+mapF.get("key")+"\"|:"+mapF.get("key")+")";
//            final String reg="(:'|:\"|:)"+mapF.get("key")+"(['|\"]{0,1})";
//             String key=mapF.get("key");
//           String reg=":"+key+"|:'"+key+"'|:\""+key+"\"";
            final String replaceVal=":"+mapF.get("pre")+mapF.get("value")+mapF.get("pre");
            try {
                jsonStr=jsonStr.replaceAll(reg,replaceVal);
            }catch (Exception e){
                log.error("-->正则转化异常");
                e.printStackTrace();
            }
        }
        jsonStr=jsonStr.replaceAll(Constant.CODE_TRANS_PRE,"");
        return jsonStr;
    }

    @Override
    public String getCacheCodeValue(String key) {
        log.debug(TextUtils.format("-->getCacheCodeValue方法调用;Key值:{0}",key));
        String val= cacheService.get(key);
        if(StrUtils.isBlank(val)){
            log.debug(TextUtils.format("-->无此key({0})值得缓存,开始添加到缓存池<--",key));
            DicCode dicCodes=new DicCode();
            dicCodes.setDictKey(key);
            Pager<DicCode> list=dictCodesService.getDicPageList(dicCodes,new Pager(1,1));
            for(DicCode codes:list
                    .getDataList()){
                cacheService.set(codes.getDictKey(),codes.getDictdataName());
                log.debug(TextUtils.format("添加缓存数据 set key:{0} value:{1}",
                        codes.getDictKey(), codes.getDictdataName()));

            }
            val=cacheService.get(key);
            log.debug("reload cache key----> "+val);
        }
        return val;
    }
}
