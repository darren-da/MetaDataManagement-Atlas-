


/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var pageLogList={
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"pageLogTable",
		//分页id
		tablePageId:"pageLogTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		//搜索
		var search_lp =new Vue({
			el:"#pageLogTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#userid").val())){
						param['userid']=$("#userid").val();
					}
					if(!system.isBlank($("#optParams").val())){
						param['optParams']=$("#optParams").val();
					}
                    if(!system.isBlank($("#start").val())){
                        param['idt']=$("#start").val();
                    }
                    if(!system.isBlank($("#end").val())){
                        param['lpEndDate']=$("#end").val();
                    }
					pageLogList.initDomainTable(param);
				}
			}
		})

	},
	/**
	 * 初始化用户信息
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
				{key :'NO.',name:"序号",width : 35},
				{key :'userid',name : '用户账号',sort:'userid'},
                {key :'optType',name : '操作类型',sort:'optType'},
                {key :'idt',name : '创建时间',sort:'idt'},
                {key :'optDetail',name : '操作模块'},

                // {key :'menuid',name : '操作菜单id',sort:'menuid'},
				{key :'optUrl',name : '请求地址'},
				{key :'optParams',name : '操作参数',formatter:function(val){
					if(val&&val.length>50){
						val="<a title='"+val+"'>"+val.substr(0,10)+"...</a>"
					}
					return val;
				}},
				// {key :'optForeParams',name : '原参数'},
				{key :'remarks',name : '备注'}


			]

		};

		if(system.isBlank(params)){
			params={};
		}
		if(system.isBlank(params['page'])){
			//获取当前页数
			var curNum=$("#"+pageLogList.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+pageLogList.cons.tableId).LPTable("/system/pageLogs",params,option);


	},

}
layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;


	//初始化表格数据
	pageLogList.initDomainTable();
	//绑定监听类方法
	pageLogList.listenFun();

})
