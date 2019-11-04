
package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.ApiNumLimt;
import com.gla.datacenter.domain.CatalogUserMap;
import com.gla.datacenter.domain.InformationApi;
import com.gla.datacenter.domain.RcsResourceCate;
import com.gla.datacenter.model.ApiManagerModel;
import com.gla.datacenter.model.ApiTestModel;
import com.gla.datacenter.service.ApiManagerClientService;
import com.limp.framework.core.annotation.Access;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.OPERATION;
import com.limp.framework.utils.TextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin
@RestController
@Api(value = "api管理消费者",description = "api管理消费者")
public class ApiManagerControllerFeign {

    private Logger loger = LoggerFactory.getLogger(ApiManagerControllerFeign.class);

    @Autowired
    private ApiManagerClientService apiManagerClientService;


    /**
     *
     * 功能描述: api列表查询(生产者视图)
     *
     * @param: [informationApi]
     * @return: String
     * @auther: zhangbo
     * @date: 2018/9/25 10:16
     */
    @ApiOperation(value = "api生产者列表查询")
    @GetMapping(value = "/api/provider/list")
    @Access(login = true)
    public String getProviderList(InformationApi informationApi){

        loger.info("------api生产者列表查询-------");
        return apiManagerClientService.getProviderList(informationApi);
    }

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
    @Access(login = true)
    public String startMonitor(){
        return apiManagerClientService.startMonitor();
    }

    /**
     *
     * 功能描述: 获取生产者测试中心检测数据
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2019/1/2 9:40
     */
    @RequestMapping(value = "/api/provider/monitor/getdata")
    @Access(login = true)
    public String getProviderMonitorData(){
        return apiManagerClientService.getProviderMonitorData();
    }

    /**
     *
     * 功能描述: 获取api列表(消费者分页查询包含组合条件)
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/26 15:03
     */
    @ApiOperation(value = "api消费者列表查询")
    @GetMapping(value = "/api/consumer/list")
    @Access(login = true)
    public String getConsumerList(InformationApi informationApi){
        return apiManagerClientService.getConsumerList(informationApi);
    }

    /**
     *
     * 功能描述: 校验当前已加入的api是否存在，并返回存在的值
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/17 16:56
     */
    @GetMapping(value = "/api/check/join")
    public String checkJoinApi(InformationApi informationApi){
        return apiManagerClientService.checkJoinApi(informationApi);
    }

    /**
     *
     * 功能描述: 获取2.0api列表(消费者分页查询包含组合条件)
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 9:34
     */
    @RequestMapping(value = "/api/consumer/list/v2")
    @Access(login = true)
    public String getConsumerListTwo(InformationApi informationApi){
        return apiManagerClientService.getConsumerListTwo(informationApi);
    }

    /**
     *
     * 功能描述: 获取api列表(管理者分页查询包含组合条件)
     *
     * @param:
     * @param informationApi
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/26 18:30
     */
    @ApiOperation(value = "api管理者列表查询")
    @GetMapping(value = "/api/manager/list")
    @Access(login = true)
    public String getManagerList(InformationApi informationApi){
        return apiManagerClientService.getManagerList(informationApi);
    }

    /**
     *
     * 功能描述: 获取2.0管理者api列表(包含分页查询条件)
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/20 10:28
     */
    @GetMapping(value = "/api/manager/list/v2")
    @Access(login = true)
    public String getManagerListTwo(InformationApi informationApi){
        return apiManagerClientService.getManagerListTwo(informationApi);
    }

    /**
     *
     * 功能描述: 2.0统计管理者下委办局和各委办局下api数量和部门数量
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 15:46
     */
    
    @Access(login = true)
    @RequestMapping(value = "/api/manager/count")
    public String countDeptAndApi(){
        return apiManagerClientService.countDeptAndApi();
    }

    /**
     *
     * 功能描述: 新增保存api
     *
     * @param: []
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 14:19
     */
    @ApiOperation(value = "新增保存api")
    @PostMapping(value = "/api/manager/save")
    @Access(login = true,operationLog = OPERATION.INSERT,operationIntro = "新增API")
    public String saveApi(@RequestBody ApiManagerModel apiManagerModel){
        return apiManagerClientService.saveApi(apiManagerModel);
    }

    /**
     *
     * 功能描述: 根据主键获取API信息
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/25 13:36
     */
    @ApiOperation(value = "生产者根据主键获取API信息")
    @GetMapping(value = "/api/{id}")
    @Access(login = true)
    public String getApiById(@PathVariable("id") String id){
        return apiManagerClientService.getApiById(id);
    }

    /**
     *
     * 功能描述: 消费者根据主键获取API信息
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/9 11:20
     */
    @Access(login = true)
    @ApiOperation(value = "消费者根据主键获取API信息")
    @GetMapping(value = "/api/consumer/{id}")
    public String getConsumerApiById(@PathVariable("id") String id){
        return apiManagerClientService.getConsumerApiById(id);
    }


    /**
     *
     * 功能描述: 删除API(逻辑删除)
     *
     * @param: [id]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 10:51
     */
    @ApiOperation(value = "删除API(逻辑删除)",notes = "根据主键逻辑删除API")
    @DeleteMapping(value = "/api/delete/{id}")
    @Access(login = true,operationLog = OPERATION.DELETE,operationIntro = "删除API")
    public String deleteApi(@PathVariable(value = "id") String id){

        return apiManagerClientService.deleteApi(id);
    }

    /**
     *
     * 功能描述: 给用户授权api(添加授权)
     *
     * @param: [apiNumLimt]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 15:33
     */
    @ApiOperation(value = "给用户授权api(添加授权)")
    @PostMapping(value = "/api/empower/set")
    @Access(login = true,operationLog = OPERATION.INSERT,operationIntro = "授权API")
    public String empowerUser(@RequestBody ApiNumLimt apiNumLimt){
        return apiManagerClientService.empowerUser(apiNumLimt);
    }

    /**
     *
     * 功能描述: 批量api授权
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/5 15:01
     */
    @PostMapping(value = "/api/empower/sets")
    @Access(login = true,operationLog = OPERATION.INSERT,operationIntro = "批量授权API")
    public String batchEmpowerUser(@RequestBody ApiNumLimt apiNumLimt){
        return apiManagerClientService.batchEmpowerUser(apiNumLimt);
    }

    /**
     *
     * 功能描述: 授权管理-api列表
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 17:05
     */
    @ApiOperation(value = "授权管理-api列表")
    @GetMapping(value = "/api/empower/list")
    @Access(login = true)
    public String empowerList(InformationApi informationApi){
        return apiManagerClientService.empowerList(informationApi);
    }

    /**
     *
     * 功能描述: 查看授权管理-api授权详情
     *
     * @param: [id]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/29 17:51
     */
    @ApiOperation(value = "查看授权管理-api授权详情")
    @GetMapping(value = "/api/empower/look/{id}")
    @Access(login = true)
    public String lookEmpower(@PathVariable("id") String id){
        return apiManagerClientService.lookEmpower(id);
    }

    /**
     *
     * 功能描述: 取消授权
     *
     * @param: [apiNumLimt]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 12:07
     */
    
    @ApiOperation(value = "取消授权")
    @DeleteMapping(value = "/api/empower/del")
    @Access(login = true,operationLog = OPERATION.UPDATE,operationIntro = "取消授权")
    public String delEmpower(@RequestBody ApiNumLimt apiNumLimt){
        return apiManagerClientService.delEmpower(apiNumLimt);
    }

    /**
     *
     * 功能描述: 根据userId批量取消授权
     *
     * @param: 
     * @param apiNumLimt
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/1/28 14:43
     */
    @ApiOperation(value = "根据userId批量取消授权")
    @DeleteMapping(value = "/api/empower")
    @Access(login = true,operationLog = OPERATION.UPDATE,operationIntro = "根据account批量取消授权")
    public String delEmpowerByUserId(@RequestBody ApiNumLimt apiNumLimt){
        return apiManagerClientService.delEmpowerByUserId(apiNumLimt);
    }

    /**
     *
     * 功能描述: 查询当前用户所在机构的目录树(接口作废)
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/9/25 14:31
     */
    /*@ApiOperation(value = "查询目录树(生产者)")
    @GetMapping(value = "/category")
    @Access(login = true)
    public String getCategoryTree(CategoryApi categoryApi){
        return apiManagerClientService.getCategoryTree(categoryApi);
    }*/

    /**
     *
     * 功能描述: 获取全量api分组(接口作废)
     *
     * @param: [categoryApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/12 13:47
     */
    /*@ApiOperation(value = "获取全量api分组")
    @GetMapping(value = "/all/category")
    @Access(login = true)
    public String getAllCategoryTree(CategoryApi categoryApi){
        return apiManagerClientService.getAllCategoryTree(categoryApi);
    }*/

    /**
     *
     * 功能描述: 根据目录id删除目录(逻辑删除)
     *
     * @param: [categoryApi]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 14:35
     */
    @ApiOperation(value = "根据目录id删除目录")
    @DeleteMapping(value = "/api/category/delete/{id}")
    @Access(login = true)
    public String deleteCategory(@PathVariable("id") String id){
        return apiManagerClientService.deleteCategory(id);
    }

    /**
     *
     * 功能描述: 查询当前目录是否存在子目录或存在Api(返回值>=1提示不能删除该目录)
     *
     * @param: [id]
     * @return: int
     * @auther: zhangbo
     * @date: 2018/9/25 14:50
     */
    @ApiOperation(value = "查询当前目录是否存在Api")
    @GetMapping(value = "/api/category/check/{id}")
    @Access(login = true)
    public int checkCategory(@PathVariable("id") String id){
        return apiManagerClientService.checkCategory(id);
    }

    /**
     *
     * 功能描述: 根据目录code获取api列表(分页)
     *
     * @param:
     * @param resourceCode
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/1 9:43
     */
    @GetMapping(value = "/api/resource/{code}")
    public String getApiListByResourceCode(@RequestBody InformationApi  informationApi, @PathVariable("code") String resourceCode){
        return apiManagerClientService.getApiListByResourceCode(informationApi,resourceCode);
    }

    /**
     *
     * 功能描述: 添加api目录(接口作废)
     *
     * @param: [categoryApi]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 15:59
     */
    /*@ApiOperation(value = "添加Api目录")
    @PostMapping(value = "/category/add")
    @Access(login = true)
    public String addCategory(CategoryApi categoryApi){
        return apiManagerClientService.addCategory(categoryApi);
    }*/

    /**
     *
     * 功能描述: 修改目录信息(接口作废)
     *
     * @param: [categoryApi]
     * @return: boolean
     * @auther: zhangbo
     * @date: 2018/9/25 16:12
     */
    /*@ApiOperation(value = "修改目录信息")
    @PutMapping(value = "/category/update")
    @Access(login = true)
    public String updateCategory(CategoryApi categoryApi){
        return apiManagerClientService.updateCategory(categoryApi);
    }*/

    /**
     *
     * 功能描述: api测试列表查询
     *
     * @param: [informationApi]
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/30 21:10
     */
    
    @ApiOperation(value = "api测试列表查询")
    @GetMapping(value = "/api/manager/getTest")
    @Access(login = true)
    public String getApiTest(InformationApi informationApi){

        return apiManagerClientService.getApiTest(informationApi);
    }

    /**
     *
     * 功能描述: API可视化界面测试
     *
     * @param: []
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/8 13:18
     */
    @ApiOperation(value = "API可视化界面测试")
    @RequestMapping(value = "/api/test")
    @Access(login = true)
    public String apiTest(@RequestBody ApiTestModel apiTestModel){

        long startTime = System.currentTimeMillis();
        String result = apiManagerClientService.apiTest(apiTestModel);
        long endTime = System.currentTimeMillis();

        loger.debug("测试请求调用相应时间:{}",endTime - startTime);
        return result;

    }

    /**
     *
     * 功能描述: 获取APIcode
     *
     * @param: []
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/10/25 17:04
     */
    @ApiOperation(value = "获取APIcode")
    @GetMapping(value = "/api/code")
    @Access(login = true)
    public String createApiCode(){
        
        return apiManagerClientService.createApiCode();
    }

    /**
     *
     * 功能描述: 根据apicode获取api基本信息
     *
     * @param: 
     * @param code
     * @return: Map<String,Object>
     * @auther: zhangbo
     * @date: 2018/12/10 14:57
     */
    @GetMapping("/api/getOne")
    public Map<String, Object> getApiInformationByCode(String code){
        return apiManagerClientService.getApiInformationByCode(code);
    }

    /**
     *
     * 功能描述: v2获取api总数、可用、异常数量
     *
     * @param: 假定不需要参数
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/11/27 15:57
     */
    @Access(login = true)
    @GetMapping(value = "/api/provider/count")
    public String countApiStatusAndNum(){
        return apiManagerClientService.countApiStatusAndNum();
    }

    /**
     *
     * 功能描述: v2获取消费者api总数、未申请、申请中、开放、已授权个数
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 9:56
     */
    @Access(login = true)
    @GetMapping(value = "/api/consumer/count")
    public String countConsumerApi(){
        return apiManagerClientService.countConsumerApi();
    }

    /**
     *
     * 功能描述: 加入申请(若当前api为开放的，直接授权)
     *
     * @param:
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/19 11:28
     */
    @Access(login = true)
    @PostMapping(value = "/api/consumer/apply")
    public String addApply(@RequestBody ApiNumLimt apiNumLimt){
        return apiManagerClientService.addApply(apiNumLimt);
    }

    /**
     *
     * 功能描述: 根据用户账号模糊查询消费者
     *
     * @param: account
     * @return: java.lang.String
     * @auther: zhangbo
     * @date: 2018/12/13 19:50
     */
    @Access(login = true)
    @GetMapping(value = "/api/like/user")
    public String getUserAccountByLike(@RequestParam("account") String account){
        return apiManagerClientService.getUserAccountByLike(account);
    }

    /**
     * 功能描述: 订阅目录
     * @param:
     * @param catalogUserMap 用户与目录关系实体
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/4 17:24
     */
    @Access(login = true)
    @RequestMapping(value = "/catalogUserMap",method = RequestMethod.POST)
    public String saveCatalogUserMap(@RequestBody CatalogUserMap catalogUserMap) {
        loger.debug(TextUtils.format("用户订阅资源目录{0}"), catalogUserMap);
        return apiManagerClientService.saveCatalogUserMap(catalogUserMap);
    }

    /**
     *
     * 功能描述: 用户资源目录订阅列表
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/1 14:38
     */
    @Access(login = true)
    @RequestMapping(value = "/resource/subscribe")
    public String getSubscribeResourcePageByUserId(RcsResourceCate rcsResourceCate){
        return apiManagerClientService.getSubscribeResourcePageByUserId(rcsResourceCate);
    }

    /**
     *
     * 功能描述: 消费者查看资源目录列表
     *
     * @param: 
     * @param rcsResourceCate
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/4/2 9:43
     */
    @Access
    @RequestMapping(value = "/resource/consumer/catalog")
    public String getResourceCatalogConsumerPages(RcsResourceCate rcsResourceCate){
        return apiManagerClientService.getResourceCatalogConsumerPages(rcsResourceCate,rcsResourceCate.getCode());
    }


    /**
     * 功能描述: 消费者查看已授权api与app个数
     * @param:
     * @return: java.lang.String
     * @auther: zhengshien
     * @date: 2019/3/25 10:11
     */
    @RequestMapping(value = "/api/app/counts",method = RequestMethod.GET)
    public String apiAndAppCounts(){
        return apiManagerClientService.apiAndAppCounts();
    }

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
    @RequestMapping(value = "/applying",method = RequestMethod.GET)
    public String applying(@RequestParam("type") String type,
                           @RequestParam(value = "initial",required = false) String initial,
                           @RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "code",required = false) String code,
                           @RequestParam(value = "desc",required = false) String desc,
                           Pager pager){
        return apiManagerClientService.applying(type,initial,name,code,desc,pager);
    }

    /**
     *
     * 功能描述: 根据url和requestType查询是否存在已有的api
     *
     * @param: 
     * @param informationApi
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/5/15 10:04
     */
    @RequestMapping(value = "/api/num/conditions")
    public String getNumByConditions(@RequestBody InformationApi informationApi){
        return apiManagerClientService.getNumByConditions(informationApi);
    }

    /**
     *
     * 功能描述: 管理者获取所有的部门数据
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/5/28 14:42
     */
    @RequestMapping(value = "/dept/list")
    public String getDeptListByManager(){
        return apiManagerClientService.getDeptListByManager();
    }

    /**
     *
     * 功能描述: 根据部门id查询api调用次数
     *
     * @param: 
     * @param deptCode
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/5/28 14:43
     */
    @RequestMapping(value = "/api/dept/count")
    public String countApiUseByDept(@RequestParam(value = "deptCode",required = false) String deptCode){
        return apiManagerClientService.countApiUseByDept(deptCode);
    }

}

