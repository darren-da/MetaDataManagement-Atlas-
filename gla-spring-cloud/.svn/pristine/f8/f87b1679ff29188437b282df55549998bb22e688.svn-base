package com.gla.datacenter.controller;

import com.gla.datacenter.bean.MetaBean;
import com.gla.datacenter.service.DictService;
import com.gla.datacenter.utils.AlgorithmUtill;
import com.limp.framework.core.bean.Result;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2019/6/12 15:26
 * @website： www.shinians.com
 */
@RestController
@CrossOrigin
public class DictMetaController {
    @Autowired
    SolrTemplate solrTemplate;

    /**
     * dict Service服务
     */
    @Autowired
    private DictService dictService;

    //定义要要操作的collection名称
    private static final String COLLECTION_META_NAME="metadata_db";

    @Autowired
    private SolrClient client;

    @GetMapping("search")
    public String search(MetaBean metaBean){
        //定义查询语句
        String fqSql = "";
        if (!StrUtils.isBlank(metaBean.getTypeName())) {
            fqSql = "md_type_name:" + metaBean.getTypeName();
        }

        //md_name加权展示
        List<MetaBean> metaBeanList = dictService.metaBeansList("md_name:" + metaBean.getName() + "^2", fqSql);
        //如果为空，则在copy中查询
        if (StrUtils.isBlank(metaBeanList)||metaBeanList.size() == 0) {
            metaBeanList = dictService.metaBeansList("md_copy:" + metaBean.getName(), fqSql);
//          metaBeanList= metaBeansList("md_relations:*"+keyWord+"*");
        }
        //排序
        List<MetaBean>newmetaBeanList= AlgorithmUtill.decTreeScoreSort(metaBeanList,metaBean);
        //searchType=1 返回一条推荐结果
        if(Constant.STRING_1.equalsIgnoreCase(metaBean.getSearchType())){
            return newmetaBeanList.size()>0? JsonUtils.toJson(newmetaBeanList.get(0)):null;
        }
        //searchType=2 返回20条推荐结果
        if(Constant.STRING_2.equalsIgnoreCase(metaBean.getSearchType())){
            return JsonUtils.toJson(newmetaBeanList);
        }
        return Result.getInstance("200", "success", metaBeanList, null).getJson();

    }

    /**
     * 建立关系
     *
     * @param metaBean
     * @return
     */
    @RequestMapping("conn")
    public String conn(MetaBean metaBean) {
        //创建Solr的客户端链接对象
//        SolrClient solrServer =  new HttpSolrClient.Builder(solrUrl).build();
        //创建一个文档对象
        SolrInputDocument sd = new SolrInputDocument();
        //添加域
        sd.addField("id", metaBean.getId());
        sd.addField("md_name", metaBean.getName());
        sd.addField("md_code", metaBean.getCode());
        sd.addField("md_relations", metaBean.getRelation());
        try {
            client.add(sd);
            client.commit();
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.getInstance("200", "success", "", null).getJson();
    }

}
