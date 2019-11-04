package com.gla.datacenter.service;


import com.gla.datacenter.domain.ApiNumLimt;
import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.*;
import com.gla.datacenter.model.ApiManagerModel;
import com.gla.datacenter.model.ApiTestModel;
import com.gla.datacenter.service.fallback.ApiManagerClientServiceFallbackFactory;
import com.limp.framework.core.bean.Pager;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(value = "DATACENTER-GATEWAY",path = "/api6",fallbackFactory=ApiManagerClientServiceFallbackFactory.class)
//@RequestMapping("/api")
public interface ApiManagerClientService {

    /**
     *
     * 功能描述: api生产者列表查询
     *
     * @param: [informationApi]
     * @return: String
     * @auther: zhangbo
     * @date: 2018/9/25 10:16
     */
    @RequestMapping(value = "/api/provider/getList")
    String getProviderList(@RequestBody InformationApi informationApi);

    /**
     *
     * 功能描述: api消费者列表查询
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/26 15:06
     */
    @RequestMapping(value = "/api/consumer/getList")
    String getConsumerList(@RequestBody InformationApi informationApi);

    /**
     *
     * 功能描述: api消费者列表查询(2.0)
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 9:36
     */
    @RequestMapping(value = "/api/consumer/getList/two")
    String getConsumerListTwo(@RequestBody InformationApi informationApi);

    /**
     *
     * 功能描述: api管理者列表查询
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 9:36
     */
    @RequestMapping(value = "/api/manager/getList")
    String getManagerList(@RequestBody InformationApi informationApi);

    /**
     *
     * 功能描述: 获取2.0管理者api列表(包含分页查询条件)
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/20 10:33
     */
    
    @RequestMapping(value = "/api/manager/list")
    String getManagerListTwo(InformationApi informationApi);

    /**
     *
     * 功能描述: 2.0统计管理者下委办局和各委办局下api数量和部门数量
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 15:47
     */
    @RequestMapping(value = "/api/manager/count")
    String countDeptAndApi();

    /**
     *
     * 功能描述: 新增保存api
     *
     * @param: []
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 14:19
     */
    @PostMapping(value = "/api/save")
    String saveApi(@RequestBody ApiManagerModel apiManagerModel);

    /**
     *
     * 功能描述: 删除API(逻辑删除)
     *
     * @param: [id]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 10:51
     */
    @DeleteMapping(value = "/api/delete/{id}")
    String deleteApi(@PathVariable("id") String id);

    /**
     *
     * 功能描述: 根据主键获取API信息
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/25 13:36
     */
    @GetMapping(value = "/api/{id}")
    String getApiById(@PathVariable("id") String id);

    /**
     *
     * 功能描述: 查询当前用户所在机构的目录树(接口作废)
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/25 14:31
     */
    /*@RequestMapping(value = "/api/category")
    String getCategoryTree(@RequestBody CategoryApi categoryApi);*/

    /**
     *
     * 功能描述: 获取全量api分组(接口作废)
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/12 13:48
     */
    
    /*@RequestMapping(value = "/api/all/category")
    String getAllCategoryTree(@RequestBody CategoryApi categoryApi);*/

    /**
     *
     * 功能描述: 根据目录id删除目录(逻辑删除)
     *
     * @param: [categoryApi]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 14:35
     */
    @DeleteMapping(value = "/api/category/delete/{id}")
    String deleteCategory(@PathVariable("id") String id);

    /**
     *
     * 功能描述: 查询当前目录是否存在子目录或存在Api(返回值>=1提示不能删除该目录)
     *
     * @param: [id]
     * @return: int
     * @auther: zhangbo
     * @date: 2018/9/25 14:50
     */
    @GetMapping(value = "/api/category/check/{id}")
    int checkCategory(@PathVariable("id") String id);

    /**
     *
     * 功能描述: 添加api目录(接口作废)
     *
     * @param: [categoryApi]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 15:59
     */
    /*@PostMapping(value = "/api/category/add")
    String addCategory(@RequestBody CategoryApi categoryApi);*/

    /**
     *
     * 功能描述: 修改目录信息(接口作废)
     *
     * @param: [categoryApi]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 16:12
     */
    /*@PutMapping(value = "/api/category/update")
    String updateCategory(@RequestBody CategoryApi categoryApi);*/

    @RequestMapping(value = "/api/test")
    String apiTest(@RequestBody ApiTestModel apiTestModel);

    /**
     *
     * 功能描述: 获取apiCode
     *
     * @param: []
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/7 17:14
     */
    
    @RequestMapping(value = "/api/code")
    String createApiCode();

    /**
     *
     * 功能描述: api测试列表(分页查询)
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/7 17:14
     */

    @GetMapping(value = "/api/getTest")
    String getApiTest(@RequestBody InformationApi informationApi);

    /**
     *
     * 功能描述: 授权新增
     *
     * @param: [apiNumLimt]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 12:08
     */
    
    @PostMapping(value = "/api/empower/set")
    String empowerUser(@RequestBody ApiNumLimt apiNumLimt);

    /**
     *
     * 功能描述: 授权管理-api列表
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 12:08
     */
    
    @RequestMapping(value = "/api/empower/list")
    String empowerList(InformationApi informationApi);

    /**
     *
     * 功能描述: 查看a授权管理-api授权详情
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 17:51
     */
    
    @RequestMapping(value = "/api/empower/look/{id}")
    String lookEmpower(@PathVariable("id") String id);

    /**
     *
     * 功能描述: 取消授权
     *
     * @param: [apiNumLimt]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 12:07
     */
    @DeleteMapping(value = "/api/empower/del")
    String delEmpower(@RequestBody ApiNumLimt apiNumLimt);

    /**
     *
     * 功能描述: 根据account批量取消授权
     *
     * @param: 
     * @param apiNumLimt
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/14 11:39
     */
    @DeleteMapping(value = "/api/empower")
    String delEmpowerByUserId(@RequestBody ApiNumLimt apiNumLimt);

    /**
     *
     * 功能描述: 消费者根据主键获取API信息
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/9 11:20
     */
    @GetMapping(value = "/api/consumer/{id}")
    String getConsumerApiById(@PathVariable("id") String id);

    /**
     *
     * 功能描述: v2获取api总数、可用、异常数量
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/27 16:00
     */
    @GetMapping(value = "/api/provider/statuscount")
    String countApiStatusAndNum();

    /**
     *
     * 功能描述: v2获取消费者api总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 9:57
     */
    @GetMapping(value = "/api/consumer/count")
    String countConsumerApi();

    /**
     *
     * 功能描述: 批量api授权
     *
     * @param: 
     * @param apiNumLimt
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/5 15:04
     */
    @RequestMapping(value = "/api/empower/sets")
    String batchEmpowerUser(@RequestBody ApiNumLimt apiNumLimt);

    /**
     *
     * 功能描述: 根据apicode获取api基本信息
     *
     * @param: 
     * @param code
     * @return: java.util.Map<java.lang.String,java.lang.Object>
     * @auther: zhangbo
     * @date: 2018/12/10 15:00
     */
    @RequestMapping(value = "/api/getOne")
    Map<String,Object> getApiInformationByCode(@RequestParam("code") String code);

    /**
     *
     * 功能描述:根据用户账号模糊查询消费者
     *
     * @param: account
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/13 19:50
     */
    @RequestMapping(value = "/api/user")
    String getUserAccountByLike(@RequestParam("account") String account);

    /**
     *
     * 功能描述: 加入申请(若当前api为开放的，直接授权)
     *
     * @param:
     * @param apiNumLimt
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/26 16:39
     */
    @RequestMapping(value = "/api/consumer/apply")
    String addApply(@RequestBody ApiNumLimt apiNumLimt);

    /**
     *
     * 功能描述: 生产者测试中心立即检测
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/26 16:38
     */
    @RequestMapping(value = "/api/provider/monitor")
    String startMonitor();

    /**
     *
     * 功能描述: 获取生产者测试中心检测数据
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2019/1/2 9:45
     */
    @RequestMapping(value = "/api/provider/monitor/getdata")
    String getProviderMonitorData();

    /**
     *
     * 功能描述: 校验当前已加入的api是否存在，并返回存在的值
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/17 16:58
     */
    @RequestMapping(value = "/api/check/join")
    String checkJoinApi(@RequestBody InformationApi informationApi);

    /**
     * 功能描述: 订阅目录
     * @param:
     * @param catalogUserMap 用户与目录关系实体
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/4 17:24
     */
    @RequestMapping(value = "/catalogUserMap")
    public String saveCatalogUserMap(@RequestBody CatalogUserMap catalogUserMap);



    @RequestMapping(value = "/apiCatalogChange", method = RequestMethod.GET)
    public String selectApiCatalogChange(@RequestBody ApiCatalogChange apiCatalogChange);

    /**
     * 功能描述: 消费者查看已授权api与app个数
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/25 10:11
     */
    @RequestMapping(value = "/api/app/counts")
    public String apiAndAppCounts();

    /**
     * 功能描述:
     * @param:
     * @param type 数据类型（值为'api'或'app'）
     * @param name 检索条件，根据名称检索
     * @param code 检索条件，根据编码检索
     * @param desc 检索条件，根据描述检索
     * @param pager 分页对象
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/4/3 10:57
     */
    @RequestMapping(value = "/applying")
    public String applying(@RequestParam("type") String type,
                           @RequestParam(value = "initial",required = false) String initial,
                           @RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "code",required = false) String code,
                           @RequestParam(value = "desc",required = false) String desc,@RequestBody Pager pager);

    /**
     * 功能描述: 新增用户与api关系（messageServiceImpl远程调用专用）
     * @param:
     * @param apiNumLimt
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/3/29 14:31
     */
    @RequestMapping(value = "/insertSelective")
    public Boolean insertSelective(@RequestBody ApiNumLimt apiNumLimt);

    /**
     * 功能描述: 根据条件查询api与用户关系列表
     * @param:
     * @param apiNumLimt
     * @return: java.util.List<com.gla.datacenter.domain.ApiNumLimt>
     * @auther: zhengshien
     * @date: 2019/3/29 14:46
     */
    @RequestMapping(value = "/selectByExample")
    public List<ApiNumLimt> selectByExample( ApiNumLimt apiNumLimt);

    /**
     * 功能描述: 根据senderid查询用户与api关系（messageServiceImpl远程调用专用）
     * @param:
     * @param senderid
     * @return: java.util.List<com.gla.datacenter.domain.ApiNumLimt>
     * @auther: zhengshien
     * @date: 2019/3/29 14:52
     */
    @RequestMapping(value = "/selectExample")
    public List<ApiNumLimt> selectExample(@RequestParam("senderid") String senderid);

    /**
     * 功能描述: 根据实体更新（messageServiceImpl远程调用专用）
     * @param:
     * @param apiNumLimt
     * @return: java.lang.Boolean
     * @auther: zhengshien
     * @date: 2019/3/29 15:09
     */
    @RequestMapping(value = "/updateByPrimaryKeySelective")
    public Boolean updateByPrimaryKeySelective(@RequestBody ApiNumLimt apiNumLimt);

    /**
     *
     * 功能描述: 根据目录code获取api列表(分页)
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/1 9:44
     */
    @RequestMapping(value = "/resource/{code}")
    String getApiListByResourceCode(@RequestBody InformationApi informationApi,@PathVariable("code") String resourceCode);

    /**
     *
     * 功能描述: 用户资源目录订阅列表
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/1 14:39
     */
    @RequestMapping(value = "/resource/subscribe")
    String getSubscribeResourcePageByUserId(@RequestBody RcsResourceCate rcsResourceCate);

    /**
     *
     * 功能描述: 用户订阅目录的资源编码集合
     *
     * @param: 
     * @param userId
     * @return: java.util.List<java.lang.String>
     * @author: zhangbo
     * @date: 2019/4/2 9:23
     */
    @RequestMapping(value = "/resource/subscribe/code")
    List<String> getSubscribeResourceByUserId(@RequestParam("userId") String userId);

    /**
     *
     * 功能描述: 消费者查看资源目录列表
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/2 9:44
     */
    @RequestMapping(value = "/resource/consumer/catalog")
    String getResourceCatalogConsumerPages(@RequestBody RcsResourceCate rcsResourceCate, @RequestParam("code") String code);


    /**
     *
     * 功能描述: 根据url和requestType查询是否存在已有的api
     *
     * @param:
     * @param informationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/5/15 10:05
     */
    @RequestMapping(value = "/api/num/conditions")
    String getNumByConditions(@RequestBody InformationApi informationApi);

    /**
     *
     * 功能描述: 管理者获取所有的部门数据
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/5/28 14:44
     */
    @RequestMapping(value = "/dept/list")
    String getDeptListByManager();

    /**
     *
     * 功能描述: 根据部门id查询api调用次数
     *
     * @param:
     * @param deptCode
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/5/28 14:44
     */
    @RequestMapping(value = "/api/dept/count")
    String countApiUseByDept(@RequestParam(value = "deptCode",required = false) String deptCode);
}
