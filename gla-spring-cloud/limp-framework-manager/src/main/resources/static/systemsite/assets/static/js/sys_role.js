

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysRole={
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"roleTable",
		//分页id
		tablePageId:"roleTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#roleTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){
					sysRole.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysRole.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/role/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								system.tip("删除成功",1);
								sysRole.initDomainTable();
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				},
				//更新操作
				updateSaveDomain:function(){
					sysRole.updateDomain();
				}
			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#roleTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#user_serach_name").val())){
						param['name']=$("#user_serach_name").val();
					}
					sysRole.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+sysRole.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				system.post("/system/role/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						sysRole.initDomainTable()
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+sysRole.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			sysRole.updateDomain(updId);
		})
		//详细信息
		$("#"+sysRole.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");
			sysRole.initDetail(detailId);
		})
		//配置角色菜单
		$("#"+sysRole.cons.tableId).LPClickDelegate(".setRolePerms",function(){
			var detailId=$(this).attr("data-value");
			sysRole.setRolePerms(detailId);
		})
		//配置角色菜单
	},
	/**
	 * 加载树形权限
	 * @param menuIds
	 */
	initTreeAuto: function (roleId) {
		function beforeCheck(treeId, treeNode) {
			console.debug(" beforeCheck " + treeNode.name );
			return (treeNode.doCheck !== false);
		}
		function onCheck(e, treeId, treeNode) {
			console.debug(" onCheck" + treeNode.name );
		}

		function checkNode(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeAuthRole");
			type = e.data.type;
			if (type == "checkAllTrue") {
				zTree.checkAllNodes(true);
			} else if (type == "checkAllFalse") {
				zTree.checkAllNodes(false);
			}else if("submitRoleMenu"==type){//提交role配置的men
				var arr=zTree.getCheckedNodes();
				console.debug(arr)
			} else {

			}
		}

		function setAutoTrigger(e) {
			var zTree = $.fn.zTree.getZTreeObj("treeAuthRole");
			zTree.setting.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
			$("#autoCheckTriggerValue").html(zTree.setting.check.autoCheckTrigger ? "true" : "false");
		}

		var setting = {
			view: {
				selectedMulti: false,
				showIcon: false,
				showLine: true//是否显示节点之间的连线
			},
			check: {
//                enable: true
				enable: true,
				chkboxType:  { "Y": "", "N": "" }//不关联
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeCheck: beforeCheck,
				onCheck: onCheck
			}
		};
		var nodes = new Array();

		system.post("/system/menus",{type:4,roleId:roleId,rows:200}, function (data) {
			for (var i in data.result.dataList) {
				var domain = data.result.dataList[i];
				//bak menu数据
				//main.menuData[domain.id] = domain;
				var node={};
				node["id"]=domain.id+"";
				node["pId"]=domain.parentId+"";
				node["name"]=domain.name+"";
				node["t"]=domain.name+"";
				node["open"]=false;
				if("0"==domain.parentId){
					node["open"]=true;
				}
				if(domain.checked==true){
					node["checked"] = true;
				}
				nodes.push(node);
			}
			console.log(nodes);
			$.fn.zTree.init($("#treeAuthRole"), setting, nodes);
		},false)

	} ,
	/**
	 * 保存角色菜单
	 */
	saveRolePerms:function(roleId){
		var roleId=$("#roleId").val();
		var zTree = $.fn.zTree.getZTreeObj("treeAuthRole");
		var nodes = zTree.getCheckedNodes();
		if(system.isBlank(roleId)){
			system.tip("角色ID不可为空",0);
			return;
		}
		if(nodes.length==0){
			system.tip("选择菜单",0);
			return;
		}
		var menuIds="";
		for(var m in nodes){
			menuIds+=","+nodes[m].id;
		}
		menuIds=menuIds.substr(1,menuIds.length);
		console.log(roleId);
		console.log(menuIds);
		system.post("/system/role/"+roleId+"/menu",{type:"1","menuIds":menuIds}, function (data) {
			if("200"==data.code){
				layer.closeAll();
				system.tip("权限分派成功",1);
			}else{
				system.tip(data.msg,0);
			}

		})
	} ,

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
				{key :'name',name : '角色名称',sort:'name'},
				{key :'rc3',name : '角色类型',sort:'rc3'},
				{key :'keyword',name : '角色编码'},
				{key :'state',name : '状态',formatter:function(cellvalue){
					var state=cellvalue==1?'<span class="layui-btn layui-btn-normal layui-btn-xs">正常</span>':
						'<span class="layui-btn layui-btn-danger layui-btn-xs"> 已删除 </span>';
					return state;
				}
				},
				{key :'remarks',name : '描述'},
				{key :'OP',name : '操作',formatters:function(domain){
					var iterm='';
					if(domain.state==1){
						 iterm+='<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>';
					}else if(domain.state==-1){
						iterm+='<a  title="启用" href="javascript:;"> <i class="layui-icon">&#xe601;</i> </a>';
					}
					iterm+='<a title="配置权限" class="setRolePerms" data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe631;</i> </a>';
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
			var curNum=$("#"+sysRole.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysRole.cons.tableId).LPTable("/system/roles",params,option);


	},

	/**
	 * 新增实体类
	 */
	saveDomain:function(){
		system.open("<div id='lp'>"+$('#tkAddRole').html()+"</div>",{title:"新增角色",area:["500px","450px"]},function(layern,index){
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
						//失去焦点时判断值为空不验证，一旦填写必须验证
						$('input[name="email"]').blur(function(){
							//这里是失去焦点时的事件
							if($('input[name="email"]').val()){
								$('input[name="email"]').attr('lay-verify','email');
							}else{
								$('input[name="email"]').removeAttr('lay-verify');
							}
						});
						$('#lp_account').blur(function(){
							//这里是失去焦点时的事件|todo验证用户是否存在
						/*	if(!system.isBlank($('#lp_account').val())){
								system.post("/system/roles",{type:4,account:$('#lp_account').val()},function(data){
								console.log(data);
								})
							}*/
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
						form.on('submit(addFilterSubmit)', function(data) {
							//console.log(data.field);
							var params = data.field;
							params["type"]=1;
							//异步新增人员
							system.post("/system/role",params,function(data){
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
		system.open("<div id='lp'>"+$('#tkUpdateRole').html()+"</div>",
			{title:"修改角色"},function(layern,index) {
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
							system.post("/system/role",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('修改成功!',1);
									sysRole.initDomainTable();
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
			[{key:"name",name:"角色名称"},{key:"rc3",name:"角色类型"}],
			[{key:"keyword",name:"角色编码"},{key:"state",name:"状态"}],
			[{key:"remarks",name:"描述"}],
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
	},
	/**
	 * 保存菜单权限
	 * @param detailId
	 */
	setRolePerms:function(detailId){

		layer.open({skin:"lp-skin-fir",content:"<div id='lp'>"+$('#setRolePermsWin').html()+"</div>",title:"配置角色权限",area:["500px","450px"],btn: ['保存'],yes: function(){
			sysRole.saveRolePerms()
		},success:function(){
			sysRole.initTreeAuto(detailId);
			$("#roleId").val(detailId);
		}});
	}
}

layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;

	//初始化表格数据
	sysRole.initDomainTable();
	//绑定监听类方法
	sysRole.listenFun();

})