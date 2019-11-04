package com.gla.datacenter.controller;

import com.limp.framework.auth.AuthUtils;
import com.limp.framework.utils.RSAUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户相关controller
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 22:21 2018/6/2
 * @modified By:
 * @RestController：是controller和ResponseBody的集合
 */
@Controller
@RequestMapping("/page")
public class PageController {
    private Logger loger= LoggerFactory.getLogger(PageController.class);


    /*********************业务层*******************************/

    /**
     * servies列表
     * @return
     */
    @RequestMapping(value = "main")
    public String main() {
        loger.debug("visit main ...");
        return "mdsite/pages/main";
    }
    /**
     * servies列表
     * @return
     */
    @RequestMapping(value = "metadata")
    public String metadata() {
        loger.debug("visit main ...");
        return "mdsite/pages/tree/md_metadata_tree";
    }

    /**
     * search列表
     * @return
     */
    @RequestMapping(value = "search")
    public String metadataSearch() {
        loger.debug("visit main ...");
        return "mdsite/pages/tree/md_metadata_search";
    }
    @RequestMapping(value = "searchDemo")
    public String searchDemo() {
        loger.debug("visit main ...");
        return "mdsite/pages/tree/md_metadata_search_demo";
    }
    /**
     * search列表
     * @return
     */
    @RequestMapping(value = "db")
    public String metadatadb() {
        loger.debug("visit main ...");
        return "mdsite/pages/db/md_db_index";
    }
    /**
     * 统计分析
     * @return
     */
    @RequestMapping(value = "analysis")
    public String analysis() {
        loger.debug("visit main ...");
        return "mdsite/pages/analysis/md_analysis_index";
    }

    public static void main(String[] args) {
        System.out.println(AuthUtils.encodeMD5("12345678",""));

    }

}
