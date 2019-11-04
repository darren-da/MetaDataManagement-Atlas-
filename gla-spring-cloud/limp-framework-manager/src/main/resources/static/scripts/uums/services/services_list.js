

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var serviceList={
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
					serviceList.saveDomain();
				},
				//更新操作
				updateSaveDomain:function(){
					serviceList.updateDomain();
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
					if(!system.isBlank($("#services_serach_name").val())){
						param['serviceName']=$("#services_serach_name").val();
					}
					if(!system.isBlank($("#services_serach_method").val())){
						param['serviceMethod']=$("#services_serach_method").val();
					}
					serviceList.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+serviceList.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				system.post("/system/role/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						serviceList.initDomainTable()
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+serviceList.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			serviceList.updateDomain(updId);
		})//详细操作
		$("#"+serviceList.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");
			serviceList.initDetail(detailId);
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
				{key :'serviceMethod',name : 'service方法',sort:'SERVICE_METHOD'},
				{key :'serviceName',name : 'service名称'},
				{key :'rc1',name : '缓存时间(s)'},
				{key :'serviceKey',sort:"SERVICE_KEY",name : 'serviceBeanID'},
				{key :'OP',name : '操作',formatters:function(domain){
					var iterm='';
					if(domain.state==1){
						 iterm+='<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>';
					}else if(domain.state==-1){
						iterm+='<a  title="启用" href="javascript:;"> <i class="layui-icon">&#xe601;</i> </a>';
					}
					iterm+='<a title="配置权限" href="javascript:;"> <i class="layui-icon">&#xe631;</i> </a>';
					iterm+='<a title="详细信息" class="detail" data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe63c;</i> </a>';
					iterm+='<a  title="编辑" class="update"  data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>';
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
			var curNum=$("#"+serviceList.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+serviceList.cons.tableId).LPTable("/services",params,option);

	},

	/**
	 * 新增实体类
	 */
	saveDomain:function(){
		system.open("<div id='lp'>"+$('#tkAddServices').html()+"</div>",{title:"新增service",area:["500px","450px"]},function(layern,index){
				layui.use(['form','jquery',"laydate"], function() {
					var form = layui.form;
					var laydate = layui.laydate;
					//需要延时
					setTimeout(function(){

						//重新渲染
						 form.render(null, 'addFilter');


						/******************自定义验证规则*************/
						form.verify({
							account: function(value) {
								if(value.length < 5) {
									return '账号至少得5个字符';
								}
							},
							password: [/(.+){6,12}$/, '密码必须6到12位'],
							repassword: function(value) {
								if($('#lp_password').val() != $('#lp_repassword').val()) {
									return '两次密码不一致';
								}
							}
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
						form.on('submit(addFilterSubmit)', function(data) {
							//console.log(data.field);
							var params = data.field;
							params["type"]=1;
							//异步新增人员
							system.post("/services",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('新增成功!',1);
								} else {
									system.tip('操作失败，请刷新后重试!', 0);
								}
							});
							//阻止提交表单
							 return false;
						})

					},200)

				})
		});
	},
	/**
	 *
	 */
	updateDomain:function(domainID){
		var domainInfo=system.cache[domainID];
		//判断是否为空
		if(system.isBlank(domainInfo)){
			return;
		}
		system.open("<div id='lp'>"+$('#tkUpdateService').html()+"</div>",
			{title:"修改services"},function(layern,index) {
				layui.use(['form', 'jquery', "laydate"], function () {
					var form = layui.form;
					var laydate = layui.laydate;
					//需要延时
					setTimeout(function(){
						form.render() //重新渲染
						form.val("updateFilter", domainInfo);
						/*
						 $("#XXX").prop('checked',true);*/
						form.on('submit(updateFilterSubmit)', function(data) {
							var params = data.field;
							params["type"]=3;
							console.log("提交数据为...")
							console.log(params)
							system.post("/services",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('修改成功!',1);
									serviceList.initDomainTable();
								} else {
									system.tip('操作失败，请刷新后重试!', 0);
								}
							});
							//阻止提交表单
							return false;
						})

					},300)

				})
			})


	},
	initDetail:function(detailId){
		var options=[
			[{key:"id",name:"ID"},{key:"serviceMethod",name:"service方法"}],
			[{key:"serviceName",name:"service名称"},{key:"rc1",name:"缓存时间"}],
			[{key:"serviceKey",name:"serviceBeanID "}],
		];

		var endDiv=$('<div></div>');
		var div=$('<div class="weadmin-body"></div>');
		var form=$('<form class="layui-form" lay-filter="addFilter1"></form>');

		for(var m in options){
			var arr1=options[m];
			var item=$('<div class="layui-form-item"></div>');
			for(var n in arr1){
				var obj=arr1[n];
				item.append('<label  class="layui-form-label">'+obj.name+':</label>');
				item.append('<div class="layui-input-inline"><input type="text" style="background-color: #eee;"  disabled name="'+obj.key+'"  autocomplete="off" class="layui-input"></div>');
			}
			form.append(item);
		}

		div.append(form);
		endDiv.append(div);
		system.open(endDiv.html(),{title:"详细信息",area:["800px","350px"]},function(){
			layui.use(['form', 'jquery', "laydate"], function () {
				var form = layui.form;
				var laydate = layui.laydate;
				//需要延时
				setTimeout(function () {
					form.render() //重新渲染
					var data={account:"张三",name:"zs",class:"5年级",age:"23岁"}
					form.val("addFilter1", system.cache[detailId]);
				}, 400)
			})

		})
	}
}
layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;

	//初始化表格数据
	serviceList.initDomainTable();
	//绑定监听类方法
	serviceList.listenFun();

})