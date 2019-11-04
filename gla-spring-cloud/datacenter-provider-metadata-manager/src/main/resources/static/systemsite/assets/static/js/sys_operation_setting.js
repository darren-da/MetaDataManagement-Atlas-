

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysOperationSetting={
    clickTreeId:"",
    //汇总所有相关的静态变量，统一全局调用，便于修正ID
    cons:{
        //表格ID
        tableId:"settingTable",
        //分页id
        tablePageId:"settingTablePage"
    },

    /**
     * 事件监听函数：用户监听绑定的事件
     */
    listenFun:function(){

        //工具栏搜索事件绑定
        var search_lp = new Vue({
            el:"#settingTableMain .table-search",
            data:{},
            methods:{
                //提交
                handleSeach:function(){
                    var param={};
                    if(!system.isBlank($("#logTypes option:selected").val())){
                        param['logType']=$("#logTypes option:selected").val();
                    }
                    if(!system.isBlank($("#bussinessName").val())){
                        param.bussinessName=$("#bussinessName").val();
                    }

                    sysOperationSetting.initDomainTable(param);
                }
            }
        })

        var tools_lp =new Vue({
            el:"#settingTableMain .table-tools",
            data:{},
            methods:{
                //新增操作
                handleSaveDomain:function(){
                    sysOperationSetting.saveDomain();
                },
                //批量删除操作
                handleDelDomains:function(){
                    var  arrIds= $("#"+sysOperationSetting.cons.tableId).LPTableCheckedIds();
                    if(arrIds.length==0){
                        system.tip("请选择删除的记录",0);
                        return;
                    }
                    //开始删除
                    system.confirm("",{title:"删除提示"},function(index){
                        system.post("/system/operation/setting/delete/"+arrIds.join(","),{type:2},function(data){
                            if(data.code=="200") {
                                var param={};
                                if(!system.isBlank($("#logTypes option:selected").val())){
                                    param['logType']=$("#logTypes option:selected").val();
                                }
                                if(!system.isBlank($("#bussinessName").val())){
                                    param.bussinessName=$("#bussinessName").val();
                                }
                                sysOperationSetting.initDomainTable(param);
                                system.tip("删除成功",1);
                            }else{
                                system.tip("删除失败，请重试！",0)
                            }
                        })
                    },function(index){ })
                },
                /*//更新操作
                updateSaveDomain:function(){
                    sysOperationSetting.updateDomain();
                }*/
            }
        })

        //删除操作
        $("#"+sysOperationSetting.cons.tableId).LPClickDelegate(".del",function(){
            var delId=$(this).attr("data-value");
            system.confirm("",{title:"删除提示"},function(index){
                system.post("/system/operation/setting/delete/"+delId,{type:2},function(data){
                    if(data.code=="200") {
                        var param={};
                        if(!system.isBlank($("#logTypes option:selected").val())){
                            param['logType']=$("#logTypes option:selected").val();
                        }
                        if(!system.isBlank($("#bussinessName").val())){
                            param.bussinessName=$("#bussinessName").val();
                        }
                        sysOperationSetting.initDomainTable(param);
                        system.tip("删除成功",1);
                    }else{
                        system.tip("删除失败，请重试！",0)
                    }
                })
            },function(index){ })
        })
        //修改操作
        $("#"+sysOperationSetting.cons.tableId).LPClickDelegate(".update",function(){
            var updId=$(this).attr("data-value");
            sysOperationSetting.saveDomain(updId);
        })


    },

    /**
     * 初始化菜单信息
     */
    initDomainTable:function(params){
        var option={
            async:true,//action请求是否异步，true为为异步请求【默认为true异步请求】
            pageFlay:true,//是否分页，默认为true 进行分页；为false则不进行分页
            //【浏览器缓存】是否需要缓存  会缓存到system.cache[""]
            cache:true,

            //缓存的key值，取值方法 system.cache["id"]
            cacheKey:"id",
            //控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
            table:{thStyle:"text-align:left;white-space: nowrap;cursor:pointer",tdStyle:"text-align:left;"},
            colModel : [
                {key :'id',name:"checkbox",width : 35},
                {key :'NO.',name : '序号',width:"35px",style:"text-align:center;"},
                {key :'bussinessName',name : '业务名称'},
                {key : 'pojoKey',name : '所属对象'},
                {key :'logType',name : '日志类型',sort:'logType',formatters:function(data){
                    if(data.logType == 1){
                        return "新增";
                    }else if(data.logType == 2){
                        return "删除";
                    }else if(data.logType == 3){
                        return "修改";
                    }else if(data.logType == 4){
                        return "查看";
                    }}
                },
                {key :'fieldTemplate',name : '监控字段',style:"width:30%"},
                {key :'idt',name : '创建时间',sort:'idt'},
                {key :'OP',name : '操作',formatters:function(domain){
                    var itemObj=$('<span data-value="'+domain.id+'"></span>');
                    if(domain.state != -1){
                        itemObj.append('<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>')
                    }
                    itemObj.append('<a title="编辑" class="update"  data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>');
                    return itemObj;
                }
                }
            ]

        };

        //var params={};
        if(system.isBlank(params['page'])){
            //获取当前页数
            var curNum=$("#"+sysOperationSetting.cons.tablePageId+" .current").attr("data-value");
            params['page']=system.isBlank(curNum)?1:curNum;
        }
        params['type']=4;
        $("#"+sysOperationSetting.cons.tableId).LPTable("/system/operation/setting/list",params,option);
    },


    /**
     * menuId为则为新增操作，有值则为修改操作
     * 新增/修改 实体类
     */
    saveDomain:function(menuId){

        system.open("<div id='lp'>"+$('#tkAddSetting').html()+"</div>",{title:system.isBlank(menuId)?"新增":"修改",area:["630px","450px"]},function(layern,index){
            layui.use(['form','jquery'], function() {
                var form = layui.form;
                setTimeout(function(){
                    console.log(sysOperationSetting.clickTreeId);
                    //重新渲染
                    var menuObj={};
                    //新增操作
                    if(system.isBlank(menuId)){
                        //return false;
                    }else{
                        menuObj=system.cache[menuId];
                    }
                    form.render();
                    form.val("addFilter",menuObj);
                    //form.render('select');

                    /******************自定义验证规则*************/
                    form.verify({
                        bussinessName: function(value) {
                            if(system.isBlank(value)) {
                                return '请输入业务名称';
                            }
                        }
                    });

                    /***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
                    form.on('submit(addFilterSubmit)', function(data) {
                        var params = data.field;
                        params.logType=$("#logType option:selected").val();
                        if(system.isBlank(menuId)) {
                            params["lptype"] = 1;
                            system.post("/system/operation/setting/save", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('新增成功!', 1);
                                    sysOperationSetting.initDomainTable({});
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }
                        //修改操作
                        else{
                            params["lptype"] = 1;
                            system.post("/system/operation/setting/save", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('修改成功!', 1);
                                    sysOperationSetting.initDomainTable({parentId:system.isBlank(sysOperationSetting.clickTreeId)?"0":sysOperationSetting.clickTreeId});
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }

                        sysOperationSetting.initDomainTable({parentId:"0"});
                        //阻止提交表单
                        return false;
                    })
                },200)

            })
        });
    }

}
layui.use(['laydate','jquery','form'], function() {
    var $ = layui.jquery;
    var form = layui.form;

    var par = {};
    //初始化表格数据
    sysOperationSetting.initDomainTable(par);
    //绑定监听类方法
    sysOperationSetting.listenFun();

})
