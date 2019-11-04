package com.limp.framework.boss.service.impl;

import com.limp.framework.boss.domain.Command;
import com.limp.framework.boss.domain.CommandExample;
import com.limp.framework.boss.mapper.oracle.CommandMapper;
import com.limp.framework.boss.service.CommandService;
import com.limp.framework.core.bean.Pager;
import com.limp.framework.core.constant.Constant;
import com.limp.framework.utils.JsonUtils;
import com.limp.framework.utils.StrUtils;
import com.limp.framework.utils.TextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author:shinians email:shiniandate@163.com
 * @description:
 * @date:Created in 13:42 2018/8/18
 * @modified By:
 */
@Service
public class CommandServiceImpl implements CommandService {

    private Logger log = LoggerFactory.getLogger(CommandServiceImpl.class);

    /**
     * 注入mapper
     */
    @Autowired
    private CommandMapper commandMapper;

    /**
     * 新增命令
     *
     * @param entry 需要保存的实体类
     * @return
     */
    @Override
    public boolean save(Command entry) {
        if (StrUtils.isBlank(entry.getId())) {
            entry.setId(StrUtils.randomUUID());
        }
        log.debug(TextUtils.format("新增命令{0}", entry.getId()));
        entry.setState(Constant.NUMBER_1);
        entry.setIdt(new Date());
        try {
            return commandMapper.insertSelective(entry) == 1 ? true : false;
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据id查询命令
     *
     * @param id 主键id
     * @return
     */
    @Override
    public Command get(String id) {
        if (StrUtils.isBlank(id)) {
            return null;
        }
        log.debug(TextUtils.format("根据命令Id{0},获取实体类信息", id));
        CommandExample commandExample = new CommandExample();
        commandExample.createCriteria().andIdEqualTo(id);
        List<Command> list = commandMapper.selectByExample(commandExample);
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 更新命令
     *
     * @param entry 当前实体类信息
     * @return
     */
    @Override
    public boolean update(Command entry) {
        if (StrUtils.isBlank(entry.getId())) {
            return false;
        }
        entry.setUdt(new Date());
        log.debug(TextUtils.format("根据Id{0},更新实体类信息", entry.getId()));
        return commandMapper.updateByPrimaryKeySelective(entry) == 1 ? true : false;  //To change body of implemented methods use File | Settings | File Templates.

    }

    /**
     * 根据id删除命令
     *
     * @param id 需要删除的Id
     * @return
     */
    @Override
    public boolean delete(String id) {
        log.debug(TextUtils.format("根据Id{0},删除实体命令信息", id));

        //逻辑删除
        Command entry = new Command();
        entry.setId(id);
        entry.setState(Integer.parseInt(Constant.STRING_DEL_STATE));
        //更新时间
        entry.setUdt(new Date());
        return commandMapper.updateByPrimaryKeySelective(entry) == 1 ? true : false;
    }

    /**
     * 查询所有命令
     *
     * @param entry 查询条件：精确查询|不带模糊查询条件
     * @return
     */
    @Override
    public List<Command> getList(Command entry) {
        //初始化Example
        CommandExample entryExample = new CommandExample();

        //创建查询条件
        CommandExample.Criteria criteria = entryExample.createCriteria();

        //如果命令状态不为空，则根据命令状态查询命令列表
        if (!StrUtils.isBlank(entry.getState())) {
            criteria.andStateEqualTo(entry.getState());
        }
        //根据id查询
        if (!StrUtils.isBlank(entry.getId())) {
            criteria.andIdEqualTo(entry.getId());
        }
        //根据编码精确查询
        if (!StrUtils.isBlank(entry.getCode())) {
            criteria.andCodeEqualTo(entry.getCode());
        }
        //根据名称模糊查询
        if (!StrUtils.isBlank(entry.getName())) {
            criteria.andNameLike(entry.getName());
        }

        return commandMapper.selectByExample(entryExample);
    }

    /**
     * 查询所有命令信息，并进行分页
     *
     * @param command
     * @param pager   分页信息
     * @return
     */
    @Override
    public Pager<Command> getPageList(Command command, Pager pager) {

        log.debug(TextUtils.format("根据条件,查询命令列表【分页方法】"));
        //初始化Example
        CommandExample entityExample = new CommandExample();
        //设置分页对象
        entityExample.setPage(pager);
        //创建查询条件
        CommandExample.Criteria criteria = entityExample.createCriteria();

        //如果命令状态不为空，则根据命令状态查询命令列表
        if (!StrUtils.isBlank(command.getState())) {
            criteria.andStateEqualTo(command.getState());
        }
        //根据id查询
        if (!StrUtils.isBlank(command.getId())) {
            criteria.andIdEqualTo(command.getId());
        }
        //根据编码精确查询
        if (!StrUtils.isBlank(command.getCode())) {
            criteria.andCodeEqualTo(command.getCode());
        }
        //根据ctype类型查询
        if (!StrUtils.isBlank(command.getCtype())) {
            criteria.andCtypeEqualTo(command.getCtype());
        }
        //根据名称模糊查询
        if (!StrUtils.isBlank(command.getName())) {
            criteria.andNameLike("%"+command.getName()+"%");
        }
        if(!StrUtils.isBlank(command.getLpsort())){
            entityExample.setOrderByClause(command.getLpsort());
        }
        criteria.andStateEqualTo(Constant.NUMBER_1);

        List<Command> commands = commandMapper.selectByExample(entityExample);

        pager.setPagerInfo(commands, commandMapper.countByExample(entityExample));

        return pager;

    }

    /**
     * 执行预览sql
     * @param sql
     * @param param
     * @return
     */
    public List<Map<String, Object>> runTestSQL(String sql,Map<String,String> param) {
        List<Map<String,Object>> listMap=new ArrayList<Map<String, Object>>();
        //判断是否是非法sql
        if(!StrUtils.isCommandIllSql(sql)){
            //格式话参数
            param.remove("sql");
            if(!StrUtils.isBlank(param)&&param.size()>0){
                    sql=TextUtils.formatCode(sql,param);
            }
            log.debug("/**********执行sql*****************/");
            log.debug(sql);
            //错误信息
            if(sql.indexOf("{")>-1){
                Map<String,Object> errMap=new HashMap<>();
                errMap.put("error","参数未被实例化");
                errMap.put("msg","预览页面暂不支持传参,请接口调用");
                listMap.add(errMap);
                return  listMap;
            }
            listMap=commandMapper.selectDynamicCommandSql(sql);
        }
        return listMap;
    }


    @Override
    public List<Map<String, Object>> runCommand(String code,Map<String,String> param) {
        if(StrUtils.isBlank(param)){
            param=new HashMap<String,String>();
        }
        //判断code是否为空
        if(StrUtils.isBlank(code)){
            return null;
        }
        //定义返回数据集合 listMap
        List<Map<String,Object>> listMap=new ArrayList<Map<String, Object>>();
        //构建查询条件
        CommandExample commandExample=new CommandExample();
        commandExample.createCriteria().andCodeEqualTo(code);
        //查询实体API
        List<Command> list=commandMapper.selectByExample(commandExample);
        if(list.size()==1){
            Command command=list.get(0);
            String sql=command.getCsql();
            //判断是否是非法sql
            if(!StrUtils.isCommandIllSql(sql)){

                //增加mysql分页功能
                //如果没有页数则展示第一页数据
                if(param.size()==0||!param.containsKey("page")){
                    param.put("page",Constant.STRING_1);
                }
                //默认每页10条数据
                if(!param.containsKey("rows")){
                    param.put("rows","10");
                }
                //mysql分页
                if(sql.indexOf("limit")==-1&&sql.indexOf("LIMIT")==-1){
                    Integer page=Integer.parseInt(param.get("rows"))*(Integer.parseInt(param.get("page"))-1);
                    Integer rows=Integer.parseInt(param.get("rows"));
                    sql="select row_.* from ("+sql+") row_  LIMIT  "+page+" , "+rows+" ";
                }
                //格式话参数
                if(!StrUtils.isBlank(param)&&param.size()>0){
                    //获取参数定义
                    List  paramMapList= JsonUtils.convertJsonStrToArray(command.getRc1());
                   if(!StrUtils.isBlank(paramMapList)){
                       sql=TextUtils.formatCode(sql,param);
                   }

                }
                log.debug("/**********执行sql*****************/");
                log.debug(sql);
                //错误信息
                if(sql.indexOf("{")>-1){
                    Map<String,Object> errMap=new HashMap<>();
                    errMap.put("error","参数未被实例化.");
                    errMap.put("msg","预览页面暂不支持传参,请接口调用");
                    listMap.add(errMap);
                    return  listMap;
                }
                try{

                    listMap=commandMapper.selectDynamicCommandSql(sql);
                }catch (Exception e){
                    Map<String,Object> error=new HashMap<>();
                    error.put("error","sql异常");
                    error.put("msg",e.getMessage());
                    listMap.add(error);
                    return  listMap;
                }
            }
        }
        return listMap;
    }

    @Override
    public String  getFormatSqlByCode(String code,Map<String,String> param) {
        if(StrUtils.isBlank(code)){
            return null;
        }
        List<Map<String,Object>> listMap=new ArrayList<Map<String, Object>>();
        CommandExample commandExample=new CommandExample();
        commandExample.createCriteria().andCodeEqualTo(code);
        List<Command> list=commandMapper.selectByExample(commandExample);
        if(list.size()==1){
            Command command=list.get(0);
            String sql=command.getCsql();
            if(!StrUtils.isCommandIllSql(sql)){
                //格式话参数
                if(!StrUtils.isBlank(param)&&param.size()>0){
                    List  paramMapList= JsonUtils.convertJsonStrToArray(command.getRc1());
                    if(!StrUtils.isBlank(paramMapList)){
                        sql=TextUtils.formatCode(sql,param);
                    }

                }
                log.debug("/**执行sql:{}**/",sql);
                //错误信息
                if(sql.indexOf("{")>-1){
                    log.error("sql error ...{}",sql);
                    return "参数未被实例化";
                }
                return   sql;
            }

        }
        return null;
    }
}
