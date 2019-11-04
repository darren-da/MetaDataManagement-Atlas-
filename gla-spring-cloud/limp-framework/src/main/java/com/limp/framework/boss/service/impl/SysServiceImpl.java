package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.*;
import com.limp.framework.boss.mapper.oracle.AreaCodeMapper;
import com.limp.framework.boss.mapper.oracle.DicCodeMapper;
import com.limp.framework.boss.mapper.oracle.TagsLibMapper;
import com.limp.framework.boss.service.SysService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:zhengshien email:zhengshien@gla.net.cn
 * @description:
 * @date:Created in 16:18 2018/7/1
 * @modified By:
 */
@Service
public class SysServiceImpl implements SysService {

    private Logger log= LoggerFactory.getLogger(SysServiceImpl.class);
    
    /**
     * 地区mapper
     */
    @Autowired
    private AreaCodeMapper areaCodeMapper;

    /**
     * 码表mapper
     */
    @Autowired
    private DicCodeMapper dicCodeMapper;

    @Autowired
    private TagsLibMapper tagsLibMapper;

    /**
     * 新增地区
     * @param area
     * @return
     */
    @Override
    public boolean saveArea(AreaCode  area) {
        if (StrUtils.isBlank(area)) {
            return false;
        }
        log.debug(TextUtils.format("新增地区"));
        try {
            area.setState(Constant.NUMBER_1);
            area.setType(Constant.NUMBER_1);
            area.setRc3(Constant.NUMBER_0);
            return  areaCodeMapper.insertSelective(area) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 新增码表
     * @param dic
     * @return
     */
    @Override
    public boolean saveDic(DicCode  dic) {
        if (StrUtils.isBlank(dic)) {
            return false;
        }
        log.debug("新增码表");
        try {
            dic.setDictStatue(Constant.STRING_1);
            return  dicCodeMapper.insertSelective(dic) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveTag(TagsLib entry) {
        if (StrUtils.isBlank(entry)) {
            return false;
        }
        log.debug("新增标签");
        try {
            entry.setState(Constant.NUMBER_1);
            return  tagsLibMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据code查询地区
     * @param code
     * @return
     */
    @Override
    public AreaCode getArea(String code) {
        if(StrUtils.isBlank(code)){
            return  null;
        }
        log.debug(TextUtils.format("根据地区code{0},获取实体类信息",code));
        AreaCodeExample areaCodeExample = new AreaCodeExample();
        areaCodeExample.createCriteria().andCodeEqualTo(code);
        List<AreaCode>  list=areaCodeMapper.selectByExample(areaCodeExample);
        return list.size()>0?list.get(0):null;
    }

    @Override
    public TagsLib getTagLib(String key) {
        if(StrUtils.isBlank(key)){
            return  null;
        }
        log.debug("key{},获取实体类信息",key);
        TagsLibExample tagsLibExample = new TagsLibExample();
        tagsLibExample.createCriteria().andKeyEqualTo(key);
        List<TagsLib>  list=tagsLibMapper.selectByExample(tagsLibExample);
        return list.size()>0?list.get(0):null;
    }

    /**
     * 根据dictDataValue查询地区
     * @param dicValue
     * @return
     */
    @Override
    public DicCode getDic(String dicValue) {
        if(StrUtils.isBlank(dicValue)){
            return  null;
        }
        log.debug(TextUtils.format("根据码表dictData_Value{0},获取实体类信息",dicValue));
        DicCodeExample dicCodeExample = new DicCodeExample();
        dicCodeExample.createCriteria().andDictdataValueEqualTo(dicValue);
        List<DicCode> list = dicCodeMapper.selectByExample(dicCodeExample);
        return list.size()>0?list.get(0):null;
    }

    /**
     * 更新地区
     * @param entry
     * @return
     */
    @Override
    public boolean updateArea(AreaCode entry) {
        if(StrUtils.isBlank(entry.getCode())){
            return  false;
        }
        AreaCodeExample areaCodeExample = new AreaCodeExample();
        areaCodeExample.createCriteria().andCodeEqualTo(entry.getCode());

        log.debug(TextUtils.format("根据地区code{0},更新实体类信息",entry.getCode()));
        return areaCodeMapper.updateByExample(entry,areaCodeExample)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    @Override
    public boolean updateTagLib(TagsLib tagsLib) {
        if(StrUtils.isBlank(tagsLib.getKey())){
            return  false;
        }
        log.debug(TextUtils.format("根据标签key{0},更新实体类信息",tagsLib.getKey()));
        return tagsLibMapper.updateByPrimaryKeySelective(tagsLib)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     * 更新码表
     * @param entry
     * @return
     */
    @Override
    public boolean updateDic(DicCode entry) {
        if(StrUtils.isBlank(entry.getDictdataValue())){
            return  false;
        }
        DicCodeExample dicCodeExample = new DicCodeExample();
        dicCodeExample.createCriteria().andDictdataValueEqualTo(entry.getDictdataValue());

        log.debug(TextUtils.format("根据码表dicDataValue{0},更新实体类信息",entry.getDictdataValue()));
        return dicCodeMapper.updateByExample(entry,dicCodeExample)==1?true:false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     * 根据code删除地区信息
     * @param code
     * @return
     */
    @Override
    public boolean deleteArea(String code){
        log.debug(TextUtils.format("根据地区code{0},逻辑删除地区信息", code));
        //逻辑删除
        AreaCode areaCode=new AreaCode();
        areaCode.setCode(code);
        areaCode.setState(Integer.parseInt(Constant.STRING_DEL_STATE) );
        AreaCodeExample areaCodeExample = new AreaCodeExample();
        areaCodeExample.createCriteria().andCodeEqualTo(code);
        return  areaCodeMapper.updateByExampleSelective(areaCode,areaCodeExample)== 1?true:false;
    }

    @Override
    public boolean deleteTagLib(String key) {
        log.debug(TextUtils.format("根据标签key{0},逻辑删除标签信息", key));
        //逻辑删除
        TagsLib tagsLib=new TagsLib();
        tagsLib.setKey(key);
        tagsLib.setState(Integer.parseInt(Constant.STRING_DEL_STATE) );
        return  tagsLibMapper.updateByPrimaryKeySelective(tagsLib)== 1?true:false;
    }

    /**
     * 根据dictDataValue删除码表信息
     * @param dicValue
     * @return
     */
    @Override
    public boolean deleteDic(String dicValue){
        log.debug(TextUtils.format("根据dictDataValue{0},逻辑删除地区信息", dicValue));
        //逻辑删除
        DicCode dicCode=new DicCode();
        dicCode.setDictdataValue(dicValue);
        dicCode.setDictStatue(Constant.STRING_DEL_STATE);
        DicCodeExample dicCodeExample = new DicCodeExample();
        dicCodeExample.createCriteria().andDictdataValueEqualTo(dicValue);
        return  dicCodeMapper.updateByExampleSelective(dicCode,dicCodeExample)== 1?true:false;
    }

    /**
     * 查询所有地区数据
     * @param areaCode 地区信息
     * @return
     */
    @Override
    public List<AreaCode> getAreaList(AreaCode areaCode) {
        AreaCodeExample areaCodeExample = new AreaCodeExample();
        //创建查询条件
        AreaCodeExample.Criteria areaCriteria = areaCodeExample.createCriteria();

        //如果地区状态不为空，则根据用户状态查询地区列表
        if (!StrUtils.isBlank(areaCode.getState())) {
            areaCriteria.andStateEqualTo(areaCode.getState());
        }
        //根据code精确查询
        if (!StrUtils.isBlank(areaCode.getCode())) {
            areaCriteria.andCodeEqualTo(areaCode.getCode());
        }

        return  areaCodeMapper.selectByExample(areaCodeExample);
    }

    @Override
    public List<TagsLib> getTagsLibList(TagsLib tagLib) {
        TagsLibExample tagsLibExample = new TagsLibExample();
        //创建查询条件
        TagsLibExample.Criteria criteria = tagsLibExample.createCriteria();

        //如果地区状态不为空，则根据用户状态查询地区列表
        if (!StrUtils.isBlank(tagLib.getState())) {
            criteria.andStateEqualTo(tagLib.getState());
        }
        //根据code精确查询
        if (!StrUtils.isBlank(tagLib.getKey())) {
            criteria.andKeyEqualTo(tagLib.getKey());
        }
        if (!StrUtils.isBlank(tagLib.getHref())) {
            criteria.andHrefEqualTo(tagLib.getHref());
        }
        if (!StrUtils.isBlank(tagLib.getName())) {
            criteria.andNameEqualTo(tagLib.getName());
        }
        if (!StrUtils.isBlank(tagLib.getState())) {
            criteria.andStateEqualTo(tagLib.getState());
        }else{
            criteria.andStateEqualTo(Constant.NUMBER_1);
        }
        tagsLibExample.setOrderByClause("LTL_ORDER_NO ASC");

        return  tagsLibMapper.selectByExample(tagsLibExample);
    }

    /**
     * 查询所有码表数据
     * @param dicCode 码表信息
     * @return
     */
    @Override
    public List<DicCode> getDicList(DicCode dicCode) {
        DicCodeExample dicCodeExample = new DicCodeExample();
        //创建查询条件
        DicCodeExample.Criteria dicCriteria = dicCodeExample.createCriteria();

        //如果地区状态不为空，则根据用户状态查询地区列表
        if (!StrUtils.isBlank(dicCode.getDictStatue())) {
            dicCriteria.andDictStatueEqualTo(dicCode.getDictdataValue());
        }
        //根据dicDataValue精确查询
        if (!StrUtils.isBlank(dicCode.getDictdataValue())) {
            dicCriteria.andDictdataValueEqualTo(dicCode.getDictdataValue());
        }

        return  dicCodeMapper.selectByExample(dicCodeExample);
    }

    /**
     * 查询所有地区数据并进行分页
     * @param areaCode 地区信息
     * @param pager 分页信息
     * @return
     */
    @Override
    public Pager<AreaCode> getAreaPageList(AreaCode areaCode, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询地区列表【分页方法】"));
        AreaCodeExample areaCodeExample = new AreaCodeExample();
        //设置分页对象
        areaCodeExample.setPage(pager);
        //创建查询条件
        AreaCodeExample.Criteria codeExampleCriteria = areaCodeExample.createCriteria();

        //如果菜单状态不为空，则更具菜单状态查询菜单列表
        if (!StrUtils.isBlank(areaCode.getState())) {
            codeExampleCriteria.andStateEqualTo(areaCode.getState());
        }else{
            codeExampleCriteria.andStateEqualTo(Integer.parseInt(Constant.STRING_1));
        }

        //则根据地区code查询地区列表
        if (!StrUtils.isBlank(areaCode.getCode())) {
            codeExampleCriteria.andCodeEqualTo(areaCode.getCode());
        }

        //父类code下的地区列表
        if (!StrUtils.isBlank(areaCode.getPcode())) {
            codeExampleCriteria.andPcodeEqualTo(areaCode.getPcode());
        }

        //根据地区名：模糊查询
        if (!StrUtils.isBlank(areaCode.getName())) {
            codeExampleCriteria.andNameLike("%" + areaCode.getName() + "%");
        }

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(areaCode.getLpsort())){
            areaCodeExample.setOrderByClause(areaCode.getLpsort());
        }
        List<AreaCode> areas=areaCodeMapper.selectByExample(areaCodeExample);

        pager.setPagerInfo(areas,areaCodeMapper.countByExample(areaCodeExample));

        return pager;

    }

    @Override
    public Pager<TagsLib> getTagsLibPageList(TagsLib tagsLib, Pager pager) {

        TagsLibExample tagsLibExample = new TagsLibExample();
        //设置分页对象
        tagsLibExample.setPage(pager);
        //创建查询条件
        TagsLibExample.Criteria tagsLibExampleCriteria = tagsLibExample.createCriteria();

        //如果菜单状态不为空，则更具菜单状态查询菜单列表
        if (!StrUtils.isBlank(tagsLib.getState())) {
            tagsLibExampleCriteria.andStateEqualTo(tagsLib.getState());
        }else{
            tagsLibExampleCriteria.andStateEqualTo(Integer.parseInt(Constant.STRING_1));
        }

        if (!StrUtils.isBlank(tagsLib.getKey())) {
            tagsLibExampleCriteria.andKeyEqualTo(tagsLib.getKey());
        }
        if (!StrUtils.isBlank(tagsLib.getHref())) {
            tagsLibExampleCriteria.andHrefEqualTo(tagsLib.getHref());
        }
        if (!StrUtils.isBlank(tagsLib.getPkey())) {
            tagsLibExampleCriteria.andPkeyEqualTo(tagsLib.getPkey());
        }

        //根据地区名：模糊查询
        if (!StrUtils.isBlank(tagsLib.getName())) {
            tagsLibExampleCriteria.andNameLike("%" + tagsLib.getName() + "%");
        }

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(tagsLib.getLpsort())){
            tagsLibExample.setOrderByClause(tagsLib.getLpsort());
        }else{
            tagsLibExample.setOrderByClause("LTL_ORDER_NO ASC");
        }
        List<TagsLib> areas=tagsLibMapper.selectByExample(tagsLibExample);

        pager.setPagerInfo(areas,tagsLibMapper.countByExample(tagsLibExample));

        return pager;
    }

    /**
     * 查询所有码表数据并进行分页
     * @param dicCode 码表信息
     * @param pager 分页信息
     * @return
     */
    @Override
    public Pager<DicCode> getDicPageList(DicCode dicCode, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询码表列表【分页方法】"));
        DicCodeExample dicCodeExample = new DicCodeExample();
        //设置分页对象
        dicCodeExample.setPage(pager);
        //创建查询条件
        DicCodeExample.Criteria dicCodeExampleCriteria = dicCodeExample.createCriteria();

        //如果菜单状态不为空，则更具菜单状态查询菜单列表
        if (!StrUtils.isBlank(dicCode.getDictStatue())) {
            dicCodeExampleCriteria.andDictStatueEqualTo(dicCode.getDictStatue());
        }else{
            dicCodeExampleCriteria.andDictStatueEqualTo(Constant.STRING_1);
        }

        //则根据码表dicDataValue查询地区列表
        if (!StrUtils.isBlank(dicCode.getDictdataValue())) {
            dicCodeExampleCriteria.andDictdataValueEqualTo(dicCode.getDictdataValue());
        }
        //唯一值
        if (!StrUtils.isBlank(dicCode.getDictKey())) {
            dicCodeExampleCriteria.andDictKeyEqualTo(dicCode.getDictKey());
        }

        //父类dicPvalue下的地区列表
        if (!StrUtils.isBlank(dicCode.getDictPvalue())) {
            dicCodeExampleCriteria.andDictPvalueEqualTo(dicCode.getDictPvalue());
        }

        //根据码表名：模糊查询
        if (!StrUtils.isBlank(dicCode.getDictdataName())) {
            dicCodeExampleCriteria.andDictdataNameLike("%" + dicCode.getDictdataName() + "%");
        }

        //如排序字段不为空，则根据此字段排序【demo：USR_CREATEDATE DESC】
        // 【注意：某个实体类可增加lpSort字段，可与前台插件字段排序结合】
        if(!StrUtils.isBlank(dicCode.getLpsort())){
            dicCodeExample.setOrderByClause(dicCode.getLpsort());
        }
        List<DicCode> dics=dicCodeMapper.selectByExample(dicCodeExample);

        pager.setPagerInfo(dics,dicCodeMapper.countByExample(dicCodeExample));

        return pager;

    }


    @Override
    public boolean save(DicCode entry) {
        return false;
    }

    @Override
    public DicCode get(String id) {
        return null;
    }

    @Override
    public boolean update(DicCode entry) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<DicCode> getList(DicCode entry) {
        return null;
    }

    @Override
    public Pager<DicCode> getPageList(DicCode entry, Pager pager) {
        return null;
    }
}
