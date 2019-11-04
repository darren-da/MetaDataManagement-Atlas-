

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysLoginLog={
    clickTreeId:"",
    //汇总所有相关的静态变量，统一全局调用，便于修正ID
    tables:"",
    cons:{
        //表格ID
        tableId:"logTable",
        //分页id
        tablePageId:"logTablePage"
    },

    /**
     * 事件监听函数：用户监听绑定的事件
     */
    listenFun:function(){

        //工具栏搜索事件绑定
        var search_lp = new Vue({
            el:"#logTableMain .table-search",
            data:{},
            methods:{
                //提交
                handleSeach:function(){
                    var param={};
                    if(!system.isBlank($("#optType option:selected").val())){
                        param['optType']=$("#optType option:selected").val();
                    }

                    if(!system.isBlank($("#start").val())){
                        param.optTime=$("#start").val();
                    }

                    sysLoginLog.initDomainTable(param);
                }
            }
        })
        //修改操作
        $("#"+sysLoginLog.cons.tableId).LPClickDelegate(".look",function(){
            var obj = [];
            var cols = [[]];
            var lookId=$(this).attr("data-value");
            system.post("/system/operation/log/look/"+lookId,{type:4},function(data){
                if(data.code=="200") {
                    var content = data.result.content;
                    obj = JSON.parse(content);
                    if(data.result.optType == 1){ //新增
                        cols = [[
                            {field: 'desc', title: '中文名', width: '25%'},
                            {field: 'name', title: '字段名', width: '25%'},
                            {field: 'afterValue', title: '新增后', width: '25%'},
                            {field: 'createId', title: '操作人', width: '25%'},
                        ]];
                    }else if(data.result.optType == 2){ //删除
                        cols = [[
                            {field: 'desc', title: '中文名', width: '25%'},
                            {field: 'name', title: '字段名', width: '25%'},
                            {field: 'afterValue', title: '删除前', width: '25%'},
                            {field: 'createId', title: '操作人', width: '25%'},
                        ]];
                    }else if(data.result.optType == 3){ //修改
                        cols = [[
                            {field: 'desc', title: '中文名', width: '20%'},
                            {field: 'name', title: '字段名', width: '20%'},
                            {field: 'beforeValue', title: '修改前', width: '20%'},
                            {field: 'afterValue', title: '修改后', width: '20%'},
                            {field: 'createId', title: '操作人', width: '20%'},
                        ]]
                    }
                }else{
                    system.tip("查询失败，请重试！",0)
                }
                system.open("<div id='lp'>"+$('#tkLooklog').html()+"</div>",{title:"查看详情",area:["500px","450px"]},function(layern,index){
                    layui.table.render({
                        elem:'#table1',
                        cols:cols,
                        data:obj,
                        even: true
                    })
                })
            })
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
                {key :'NO.',name : '序号',width:"35px",style:"text-align:center;"},
                {key :'type',name : '操作类型',sort:'type',formatters:function(data){
                    if(data.optType == 1){
                        return "新增";
                    }else if(data.optType == 2){
                        return "删除";
                    }else if(data.optType == 3){
                        return "修改";
                    }else if(data.optType == 4){
                        return "查看";
                    }}
                },
                {key :'content',name : '消息'},
                {key : 'pojoKey',name : '所属对象'},
                {key :'optTime',name : '创建时间',sort:'optTime'},
                {key :'OP',name : '操作',formatters:function(domain){
                    var itemObj=$('<span data-value="'+domain.id+'"></span>');
                    itemObj.append('<a title="查看详情" class="look"  data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe63c;</i> </a>');
                    return itemObj;
                }
                }
            ]

        };

        //var params={};
        if(system.isBlank(params['page'])){
            //获取当前页数
            var curNum=$("#"+sysLoginLog.cons.tablePageId+" .current").attr("data-value");
            params['page']=system.isBlank(curNum)?1:curNum;
        }
        params['type']=4;
        $("#"+sysLoginLog.cons.tableId).LPTable("/system/operation/log/list",params,option);
    },

}
layui.use(['laydate','jquery','form','table'], function() {
    var $ = layui.jquery;
    var form = layui.form;

    var par = {};
    //初始化表格数据
    sysLoginLog.initDomainTable(par);
    //绑定监听类方法
    sysLoginLog.listenFun();
    tables = layui.table;
    //form.on()

})
