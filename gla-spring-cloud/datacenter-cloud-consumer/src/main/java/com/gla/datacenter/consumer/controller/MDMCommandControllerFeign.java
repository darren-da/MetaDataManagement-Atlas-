package com.gla.datacenter.consumer.controller;

import com.gla.datacenter.domain.Command;
import com.gla.datacenter.domain.DataModelManager;
import com.gla.datacenter.domain.MasterDataManager;
import com.gla.datacenter.domain.ModelField;
import com.gla.datacenter.model.MDMDataModelModels;
import com.gla.datacenter.model.PublishApiModel;
import com.gla.datacenter.service.MDMClientService;
import com.gla.datacenter.service.MDMCommondClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhangzenghuan  详情
 * @Date: 2019/6/18 14:54
 * @Description:
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/mdm")
public class MDMCommandControllerFeign {

    private Logger logger = LoggerFactory.getLogger(MDMCommandControllerFeign.class);

    @Autowired
    private MDMCommondClientService mdmCommondClientService;


    /**
     * 新增命令
     *
     * @param command
     * @return
     */
    @PostMapping(value = "/command/add")
    String saveCommand(@RequestBody Command command) {
        return mdmCommondClientService.saveCommand(command);
    }

    /**
     * 删除命令
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "/command/delete/{id}")
    String delCommand(@PathVariable("id") String id) {
        return mdmCommondClientService.delCommand(id);
    }

    /**
     * 更新命令
     *
     * @param command
     * @return
     */
    @PutMapping(value = "/command/update")
    String updateCommand(@RequestBody Command command) {
        return mdmCommondClientService.updateCommand(command);
    }

    ;

    /**
     * 获取命令详情
     *
     * @param id
     * @return
     */

    @RequestMapping(value = "/command/detail/{id}")
    String selectCommand(@PathVariable("id") String id) {
        return mdmCommondClientService.selectCommand(id);
    }

    /**
     * 查询用于列表
     *
     * @param command
     * @return
     */
    @RequestMapping(value = "/commands/list")
    String selectCommandList(Command command) {
        return mdmCommondClientService.selectCommandList(command);
    }


    /**
     * 根据API code运行某个命令
     *
     * @param code
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/{code}")
    public String api(@PathVariable("code") String code, @RequestParam Map<String, String> param) {
        return mdmCommondClientService.api(code, param);
    }

    /**
     *
     * 功能描述: 发布api
     *
     * @param:
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/7/10 9:14
     */
    @PostMapping(value = "/api/publish/{id}")
    public String publishApi(@PathVariable("id") String id, @RequestBody PublishApiModel publishApiModel){
        return mdmCommondClientService.publishApi(id,publishApiModel);
    }

    /**
     *
     * 功能描述: 远程调用重置api为可发布状态
     *
     * @param: 
     * @param codes
     * @return: java.lang.String
     * @author: zhangbo
     * @date: 2019/8/16 14:22
     */
    @RequestMapping(value = "/api/reset/state")
    public String resetApiStatusByCodeList(List<String> codes){
        return mdmCommondClientService.resetApiStatusByCodeList(codes);
    }

}