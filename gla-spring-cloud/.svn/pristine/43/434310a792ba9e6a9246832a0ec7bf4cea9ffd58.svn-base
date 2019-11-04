package com.gla.datacenter.service.impl;

import com.gla.datacenter.bean.MetaBean;
import com.gla.datacenter.service.DictService;
import com.limp.framework.utils.StrUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @intro ：
 * @auth ： shinians
 * @time ： 2019/5/29 17:04
 * @website： www.shinians.com
 */
@Service
public class DictServiceImpl implements DictService {
//    private  static  final String solrUrl="http://127.0.0.1:8983/solr/metadata_db";
    private  static  final String solrUrl="http://192.168.26.160:8983/solr/metadata_db";

    //定义要要操作的collection名称
    private static final String COLLECTION_META_NAME="metadata_db";


    @Autowired
    SolrTemplate solrTemplate;

    @Autowired
    private SolrClient client;
    /**
     * 删除doc
     * @param ids 逗号分割的字符串
     * @return 删除是否成功
     */
    @Override
    public boolean delteByIds(String ids) {
        try {
            //根据ID集合批量删除
            solrTemplate.deleteByIds(COLLECTION_META_NAME,Arrays.asList(ids.split(",")));
            solrTemplate.commit(COLLECTION_META_NAME);
        } catch (Exception e) {
            //删除失败
            e.printStackTrace();
            return  false;
        }
        return true;
    }



    /**
     * 根据查询条件获取bean集合
     * @param sql  查询语句
     * @param fqSql  过滤语句
     * @return
     */
    public List<MetaBean> metaBeansList(String sql, String fqSql){

        //创建Solr的客户端链接对象
//        SolrClient solrServer =  new HttpSolrClient.Builder(solrUrl).build();
        //创建solr的查询对象
        SolrQuery sq=new SolrQuery();
        //设置查询条件【1】这里*:*表示获取所有数据，第一个*对应field，第二个对应查询的条件。
        //sq.set("q","item_title:3 AND item_desc:东西  OR item_sell_point:好看" );
        sq.set("q",sql );

        //设置分页【注】
        sq.setStart(0);
        sq.setRows(20);

        //排序【注】   SolrQuery.ORDER.desc   SolrQuery.ORDER.asc
        // sq.addSort("sortFieldName ", SolrQuery.ORDER.asc);

        //设置过滤条件【2】
        if(!StrUtils.isBlank(fqSql)){
            sq.set("fq", fqSql);
//          sq.setFilterQueries("author_name:出山","filesize:[* TO 4000000]");
        }
        //【3】“fl” 只查询指定域  ；是solr返回数据时返回哪些字段;*表示返回所有存在字段，后面加上“score”就表示返回数据时同时返回该条数据匹配的score。
        sq.set("fl", "*,score");
        //设置高亮【4】
        //1.打开开关
        sq.setHighlight(false);
        //2.指定高亮域
        sq.addHighlightField("md_name");
        //3.前缀
        sq.setHighlightSimplePre("<font style='color:red'>");
        //后缀
        sq.setHighlightSimplePost("</font>");
        QueryResponse qr= null;
        try {
            //执行查询
            qr = client.query(sq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取查询结果
        SolrDocumentList sds=qr.getResults();
        //获取查询的记录数【5】
        long total=sds.getNumFound();
        System.out.println("数量："+total);

        //获取返回结果的最大得分【6】
        float scoreMax=sds.getMaxScore();
        System.out.println("score："+scoreMax);

        //获取返回结果的偏移量
        long start=sds.getStart();

        List<MetaBean> metaBeanList =new ArrayList<>();
        for(SolrDocument sd:sds){//默认取出10条记录
            MetaBean metaBean=new MetaBean();
            //查询出的结果标题设置高亮
            Map<String, Map<String, List<String>>> highlighting =  qr.getHighlighting();
            List<String > list = highlighting.get(sd.get("id")).get("md_name");
            String md_name;
            if(list != null && list.size()>0){
//                md_name = list.get(0);
                md_name = (String)sd.get("md_name");
            }else {
                md_name = (String)sd.get("md_name");
            }
            /******************初始化实体对象****************************/

            String id=(String) sd.getFieldValue("id");
//            String name=(String) sd.getFieldValue("md_name");
            String code=(String) sd.getFieldValue("md_code");
            String typeName=(String) sd.getFieldValue("md_type_name");
            String intro=(String) sd.getFieldValue("md_intro");
            String score=sd.getFieldValue("score")+"";
            String md_relations=(String) sd.getFieldValue("md_relations");
            metaBean.setId(id);
            metaBean.setName(md_name);
            metaBean.setScore(Float.parseFloat(score));
            metaBean.setMaxScore(scoreMax+"");
            metaBean.setCode(code);
            metaBean.setTypeName(typeName);
            metaBean.setIntro(intro);
            metaBean.setRelation(md_relations);
            //添加到list集合
            metaBeanList.add(metaBean);
        }
        return  metaBeanList;

    }
    public List<MetaBean> metaBeansList1(String sql, String fqSql){

          Query simpleQuery=new SimpleQuery(sql);
//          simpleQuery.addCriteria(new Criteria("fl:*,score"));
          //+"&fl=*,score"

//        fl=*,score
        //设置分页
          simpleQuery.setOffset(0L);
          simpleQuery.setRows(20);
        //排序【注】   SolrQuery.ORDER.desc   SolrQuery.ORDER.asc
        // sq.addSort("sortFieldName ", SolrQuery.ORDER.asc);
//          simpleQuery.addSort()
        // 过滤
//           simpleQuery.addFilterQuery(new Filter)
        //设置过滤条件【2】
       /* if(!StrUtils.isBlank(fqSql)){
            sq.set("fq", fqSql);
//          sq.setFilterQueries("author_name:出山","filesize:[* TO 4000000]");
        }*/

       /*  // 设置查询条件(Criterial)
        Criteria criteria = new Criteria("item_brand").contains("2");
        criteria = criteria.and("item_seller").contains("2");
        query.addCriteria(criteria);*/
//        new Sort(Sort.Direction.DESC, "description").and(new Sort(Sort.Direction.ASC, "id"))


        /**
         *    SimpleHighlightQuery query = new SimpleHighlightQuery();
         // 设置高亮选项对象
         HighlightOptions highlightOptions = new HighlightOptions();
         highlightOptions.addField("item_title");// 设置高亮域
         highlightOptions.setSimplePrefix("<span style='color: red;'>");// 设置高亮前缀
         highlightOptions.setSimplePostfix("</span>");// 设置高亮后缀
         // 设置高亮选项
         query.setHighlightOptions(highlightOptions);// 普通搜索
         */
        ScoredPage<MetaBean> pageMeta= solrTemplate.queryForPage(COLLECTION_META_NAME,simpleQuery,MetaBean.class);
//        Page<MetaBean> pageMeta= solrTemplate.query(COLLECTION_META_NAME,simpleQuery,MetaBean.class);
//        float scoreMax=pageMeta.();
//        System.out.println("score："+scoreMax);
        System.out.println("总记录数:"+pageMeta.getTotalElements());
        System.out.println("总记录数:"+pageMeta.getTotalElements());
         /* solrTemplate.saveBean(item);
          solrTemplate.commit();*/

        return  null;
    }

    public static void main(String[] args) {
        DictServiceImpl dictService=new DictServiceImpl();
        dictService.delteByIds("testtest");
    }
}
