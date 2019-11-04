

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysLoginLog={
    clickTreeId:"",
    //汇总所有相关的静态变量，统一全局调用，便于修正ID
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
                    if(!system.isBlank($("#type option:selected").val())){
                        param['type']=$("#type option:selected").val();
                    }
                    if(!system.isBlank($("#state option:selected").val())){
                        param['state']=$("#state option:selected").val();
                    }
                    if(!system.isBlank($("#start").val())){
                        param.idt=$("#start").val()
                    }
                    if(!system.isBlank($("#end").val())){
                        param.lpEndDate=$("#end").val();
                    }
                    if(!system.isBlank($("#account").val())){
                        param.account=$("#account").val();
                    }
                    sysLoginLog.initDomainTable(param);
                }
            }
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
                {key :'account',name : '账号',sort:'account'},
                {key :'ip',name : 'IP地址',sort:'ip'},
                {key :'type',name : '操作类型',sort:'type',formatters:function(data){
                    if(data.type == 1){
                        return "登陆";
                    }else if(data.type == 2){
                        return "注销";
                    }}
                },
                {key :'state',name : '登陆状态',sort:'state',formatters:function(data){
                    if(data.state == 1){
                        return "正常";
                    }else if(data.state == -1){
                        return "删除";
                    }}
                },
                {key : 'msg',name : '登录提示'},
                {key :'idt',name : '创建时间',sort:'idt'}
            ]

        };

        //var params={};
        if(system.isBlank(params['page'])){
            //获取当前页数
            var curNum=$("#"+sysLoginLog.cons.tablePageId+" .current").attr("data-value");
            params['page']=system.isBlank(curNum)?1:curNum;
        }
        params['lptype']=4;
        $("#"+sysLoginLog.cons.tableId).LPTable("/system/login/log/list",params,option);
    },

}
layui.use(['laydate','jquery','form'], function() {
    var $ = layui.jquery;
    var form = layui.form;

    var par = {};
    //初始化表格数据
    sysLoginLog.initDomainTable(par);
    //绑定监听类方法
    sysLoginLog.listenFun();

})
