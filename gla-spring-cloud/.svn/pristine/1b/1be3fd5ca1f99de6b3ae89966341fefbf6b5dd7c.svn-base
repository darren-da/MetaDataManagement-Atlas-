

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var orderList={
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"servicesTable",
		//分页id
		tablePageId:"servicesTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#servicesTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){
					orderList.saveDomain();
				},
				//更新操作
				updateSaveDomain:function(){
					orderList.updateDomain();
				}
			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#servicesTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#order_method_name").val())){
						param['serviceName']=$("#order_method_name").val();
					}
					if(!system.isBlank($("#orderno").val())){
						param['orderNo']=$("#orderno").val();
					}
					orderList.initDomainTable(param);
				}
			}
		})


		$("#"+orderList.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");
			orderList.initDetail(detailId);
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
				{key :'id',name:"checkbox",width : 35},
				{key :'NO.',name:"序号",width : 35},
				{key :'orderNo',name : '订单号',sort:'ORDER_NO'},
				{key :'serviceName',name : '方法名称'},
				{key :'idt',name : '创建时间',sort:'IDT'},
				{key :'usrid',name : '请求用户ID'},
				{key :'parms',name : '请求参数'},
				{key :'OP',name : '操作',formatters:function(domain){
					var  iterm='<a title="详细信息" class="detail" data-value="'+domain.orderNo+'" href="javascript:;"> <i class="layui-icon">&#xe63c;</i> </a>';
					  return iterm;
				}
				}
			]

		};

		if(system.isBlank(params)){
			params={};
		}
		if(system.isBlank(params['page'])){
			//获取当前页数
			var curNum=$("#"+orderList.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+orderList.cons.tableId).LPTable("/orders",params,option);


	},


	initDetail:function(detailNo){

		var options=[
			[{key:"id",name:"ID"},{key:"orderResult",name:"orderResult"}],
		];

		var endDiv=$('<div></div>');
		var div=$('<div class="weadmin-body"></div>');
		var form=$('<div> <pre class="layui-code" id="port-code"> </pre> </div>');
		div.append(form);
		endDiv.append(div);

		system.post("/orderDetails",{orderNo:detailNo,type:4},function(data){
			console.log(data);
			system.open(endDiv.html(),{title:"详细信息",area:["800px","350px"]},function(){
				$("#port-code").text(JSON.stringify(data.result.dataList[0].orderResult));
				layui.use('code', function(){ //加载code模块
					layui.code(); //引用code方法
				})
			})
		})

	}
}
layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;

	//初始化表格数据
	orderList.initDomainTable();
	//绑定监听类方法
	orderList.listenFun();

})
