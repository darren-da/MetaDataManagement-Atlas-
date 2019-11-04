package com.gla.datacenter.service;

import com.gla.datacenter.domain.ApiNumLimt;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.model.ApiManagerModel;
import com.gla.datacenter.model.ApiTestModel;
import com.limp.framework.core.bean.Pager;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 功能描述: api管理接口
 *
 * @auther: zhangbo
 * @date: 2018/9/25 10:27
 */
public interface ApiManagerService {

    /**
     * 功能描述: api生产者列表查询
     *
     * @param: [informationApi, pager]
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.InformationApi>
     * @auther: zhangbo
     * @date: 2018/9/27 14:56
     */
    String getProviderList(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: api消费者列表查询
     *
     * @param: [informationApi, pager]
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.InformationApi>
     * @auther: zhangbo
     * @date: 2018/11/7 16:50
     */

    Pager<InformationApi> getConsumerList(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: v2获取消费者api总数、未申请、申请中、开放、已授权个数
     *
     * @param informationApi
     * @param pager
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.InformationApi>
     * @author: zhangbo
     * @date: 2019/1/17 17:00
     */
    String getConsumerListTwo(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: 校验当前已加入的api是否存在，并返回存在的值
     *
     * @param informationApi
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/17 17:00
     */
    String checkJoinApi(InformationApi informationApi);

    /**
     * 功能描述:
     *
     * @param: [informationApi, pager]
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.InformationApi>
     * @auther: zhangbo
     * @date: 2018/11/7 16:51
     */

    Pager<InformationApi> getApiTest(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: api管理者列表查询
     *
     * @param informationApi
     * @param pager
     * @param:
     * @return: com.limp.framework.core.bean.Pager<com.gla.datacenter.domain.InformationApi>
     * @auther: zhangbo
     * @date: 2018/11/26 18:18
     */
    Pager<InformationApi> getManagerList(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: 获取2.0管理者api列表(包含分页查询条件)
     *
     * @param informationApi
     * @param pager
     * @param:
     * @return: java.util.List<com.gla.datacenter.domain.InformationApi>
     * @auther: zhangbo
     * @date: 2018/12/20 10:32
     */
    String getManagerListTwo(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: 2.0统计管理者下委办局和各委办局下api数量和部门数量
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 15:49
     */
    String countDeptAndApi();

    /**
     * 功能描述: API保存
     *
     * @param: [apiManagerModel]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 14:59
     */
    String saveApi(ApiManagerModel apiManagerModel);

    /**
     * 功能描述: API删除
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 14:59
     */
    String deleteApi(String id);

    /**
     * 功能描述: 根据APIID查看API详情
     *
     * @param: [id]
     * @return: com.gla.datacenter.model.ApiManagerModel
     * @auther: zhangbo
     * @date: 2018/9/27 14:59
     */
    ApiManagerModel getApiById(String id);

    /**
     * 功能描述: 消费者根据主键查询api详情
     *
     * @param: [id]
     * @return: com.gla.datacenter.model.ApiManagerModel
     * @auther: zhangbo
     * @date: 2018/11/9 11:27
     */
    String getConsumerApiById(String id);

    /**
     * 功能描述: 根据ApiId获取Api信息(包含参数)
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/28 13:33
     */
    String getApiInfoById(String id);

    /**
     *
     * 功能描述: 获取目录树
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 14:59
     */
    /*String getCategoryTree(CategoryApi categoryApi);*/

    /**
     *
     * 功能描述: 获取全量api分组
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/12 13:49
     */

    /*String getAllCategoryTree(CategoryApi categoryApi);*/

    /**
     *
     * 功能描述: 根据目录id删除目录(接口作废)
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 15:00
     */
    /*String deleteCategory(String id);*/

    /**
     * 功能描述: 检查目录下是否存在API
     *
     * @param: [id]
     * @return: int
     * @auther: zhangbo
     * @date: 2018/9/27 15:00
     */
    int checkCategory(String id);

    /**
     *
     * 功能描述: 新增目录
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 15:01
     */
    /*String addCategory(CategoryApi categoryApi);*/

    /**
     * 功能描述: 修改目录
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/27 15:01
     */
    /*String updateCategory(CategoryApi categoryApi);*/

    String apiTest(ApiTestModel apiTestModel);

    void apiTestTask(String threshold_value);

    void monitorDB();

    /**
     * 功能描述: 获取apiCode
     *
     * @param: []
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/25 17:06
     */
    String createApiCode();


    /**
     * 功能描述:给用户授权API
     *
     * @param: []
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 15:38
     */

    String empowerUser(ApiNumLimt apiNumLimt);

    /**
     * 功能描述: 查询授权管理-api列表(分页)
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 17:07
     */

    String empowerList(InformationApi informationApi, Pager pager);

    /**
     * 功能描述: 查看a授权管理-api授权详情
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 17:52
     */

    String lookEmpower(String id);

    /**
     * 功能描述: 删除授权
     *
     * @param: [apiNumLimt]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 12:10
     */

    String delEmpower(ApiNumLimt apiNumLimt);


    String delEmpowerByUserId(ApiNumLimt apiNumLimt);


    /**
     * 功能描述: v2获取api总数、可用、异常数量
     *
     * @param: 正常:useCount;异常:errorCount;总数:count
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/27 16:02
     */
    String countApiStatusAndNum();

    /**
     * 功能描述: 批量api授权
     *
     * @param apiNumLimt
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/5 15:05
     */
    String batchEmpowerUser(ApiNumLimt apiNumLimt);

    /**
     * 功能描述: 根据apicode获取api基本信息
     *
     * @param code
     * @param:
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/12/10 15:03
     */
    Map<String, Object> getApiInformationByCode(String code);

    /**
     * 功能描述: 定时任务监控过期api并更新状态
     *
     * @param:
     * @return: void
     * @auther: zhangbo
     * @date: 2018/12/12 14:57
     */
    void monitorExpireApi();

    /**
     * 功能描述: 根据用户账号模糊查询消费者
     *
     * @param account
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/13 19:48
     */
    String getUserAccountByLike(String account);

    /**
     * 功能描述: v2获取消费者api总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 10:03
     */
    String countConsumerApi();

    /**
     * 功能描述: 加入申请(若当前api为开放的，直接授权)
     *
     * @param apiNumLimt
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/26 16:39
     */
    String addApply(ApiNumLimt apiNumLimt);

    /**
     * 功能描述: 生产者测试中心立即检测
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/26 16:39
     */
    String startMonitor();

    /**
     * 功能描述: 生产者测试中心获取最近一次检测数据
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/28 9:46
     */
    String getProviderMonitorData();

    String apiAndAppCounts();

    Pager applying(String type,String initial, String name, String code, String desc, Pager pager);

    Boolean insertSelective(ApiNumLimt apiNumLimt);

    List<ApiNumLimt> selectByExample(ApiNumLimt apiNumLimt);

    List<ApiNumLimt> selectExample(String senderid);

    Boolean updateByPrimaryKeySelective(ApiNumLimt apiNumLimt);

    String getApiListByResourceCode(Pager pager, String resourceCode);

    String getSubscribeResourcePageByUserId(RcsResourceCate rcsResourceCate);

    String getSubscribeResourceByUserId(String userId);

    String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate, String code);

    boolean save(CatalogUserMap catalogUserMap);

    String getNumByConditions(InformationApi informationApi);

    String getDeptListByManager();

    String countApiUseByDept(String deptCode);
}
