


/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysMenu={
	clickTreeId:"",
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"menuTable",
		//分页id
		tablePageId:"menuTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#menuTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){

					sysMenu.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysMenu.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/user/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								sysMenu.initDomainTable();
								setTimeout(system.tip("删除成功",1),3000)
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				}
			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#menuTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#perms_serach_account").val())){
						param['perms']=$("#perms_serach_account").val();
					}

					sysMenu.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+sysMenu.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				//判断是否含有 子级 todo
				system.post("/system/menu/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						sysMenu.initDomainTable({parentId:system.isBlank(sysMenu.clickTreeId)?"0":sysMenu.clickTreeId});
						//重新加载树形结构
						sysMenu.initTree();
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+sysMenu.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			sysMenu.saveDomain(updId);
		})//修改操作


		//更改状态
		$("#"+sysMenu.cons.tableId).LPClickDelegate(".state",function(){
			var detailId=$(this).parent().attr("data-value");
			var params={};
			params["type"]=3;
			system.post("/system/user/"+detailId+"/state/1",params,function(data){
				if (data.code == "200") {
					sysMenu.initDomainTable();
					system.tip('修改成功!',1);
				} else {
					system.tip('操作失败，请刷新后重试!', 0);
				}
			});
		})
	},
	/**
	 * 加载菜单管理 属性结构
	 */
	initTree:function(){
		var setting = {
			data: {
				key: {
					title:"t"
				},
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick,
				onRightClick: OnRightClick
			}
		};
		function OnRightClick(event, treeId, treeNode, clickFlag) {
			if(!system.isBlank(treeNode)){
				$("#mId").val(treeNode.id);
				//SysMenu.initMenu(treeNode.id);
			}
			if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
				$.fn.zTree.getZTreeObj("treeDemo").cancelSelectedNode();
				showRMenu("root", event.clientX, event.clientY);
			} else if (treeNode && !treeNode.noR) {
				$.fn.zTree.getZTreeObj("treeDemo").selectNode(treeNode);
				showRMenu("node", event.clientX, event.clientY);
			}
		}
		function onBodyMouseDown(event){
			if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
				$("#rMenu").css({"visibility" : "hidden"});
			}
		}






		function beforeClick(treeId, treeNode, clickFlag) {
			console.log("[beforeClick ]" + treeNode.name );
			return (treeNode.click != false);
		}
		/**
		 *clickFlag===1: 普通选中;clickFlag===0:取消选中 ;追加选中
		 * @param event
		 * @param treeId
		 * @param treeNode
		 * @param clickFlag
		 */
		function onClick(event, treeId, treeNode, clickFlag) {
			if(1==clickFlag){
				//SysMenu.initMenu(main.menuData[treeNode.id]);
				sysMenu.clickTreeId=treeNode.id;
				sysMenu.initDomainTable({parentId:treeNode.id});

			}
		}
		var nodes=new Array();
		system.post("/system/menus",{type:4,rows:200},function(data){
			console.log("meun--data")
			console.log(data)
			for(var i in data.result.dataList){
				var domain=data.result.dataList[i];
				//bak menu数据
				system.cache[domain.id]=domain;
				var node={};
				node["id"]=domain.id+"";
				node["pId"]=domain.parentId+"";
				node["name"]=domain.name+"";
				node["t"]=domain.name+"";
				node["open"]=false;
				if("0"==domain.parentId){
					node["open"]=true;
				}
				nodes.push(node);
			}
			sysMenu.clickTreeId="";
			// zNodes=zNodes.concat(nodes)
			$.fn.zTree.init($("#treeDemo"), setting, nodes);
			$("#load_menu").hide();
		})
	}  ,
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
				{key :'NO.',name : '序号'},
				{key :'name',name : '菜单名称',sort:'name'},
				{key :'perms',name : '权限标识',sort:'state',formatter:function(cellvalue){
					var perms=system.isBlank(cellvalue)?'--': cellvalue;
					return perms;
				}
				},
				{key :'type',name : '菜单类型'},
				{key :'keyword',name : '菜单标识'},
				{key :'sort',name : '排序'},
				{key :'icon',name : '菜单图标'},
				{key :'url',name : 'url'},

				{key :'OP',name : '操作',formatters:function(domain){
					var itemObj=$('<span data-value="'+domain.id+'"></span>');
					if(domain.state==1){
						itemObj.append('<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>')
					}
					itemObj.append('<a  title="编辑" class="update"  data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>');
					  return itemObj;
				}
				}
			]

		};

		if(system.isBlank(params)){
			params={};
		}
		if(system.isBlank(params['page'])){
			//获取当前页数
			var curNum=$("#"+sysMenu.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysMenu.cons.tableId).LPTable("/system/menus",params,option);


	},

	/**
	 * menuId为则为新增操作，有值则为修改操作
	 * 新增/修改 实体类
	 */
	saveDomain:function(menuId){
		system.open("<div id='lp'>"+$('#tkAddMenu').html()+"</div>",{title:system.isBlank(menuId)?"新增菜单":"修改菜单",area:["630px","450px"]},function(layern,index){
				layui.use(['form','jquery'], function() {
					var form = layui.form;
					setTimeout(function(){
						console.log(sysMenu.clickTreeId);
						//重新渲染

						var menuObj={};
						//新增操作
						if(system.isBlank(menuId)){
							//点击了菜单
							if(sysMenu.clickTreeId){
								var obj=system.cache[sysMenu.clickTreeId];
								menuObj={parentId:obj.id,parentName:obj.name}
							}else {
								menuObj={parentId:"0",parentName:"一级目录"}
							}
						}else{
							menuObj=system.cache[menuId];
							var pname=system.isBlank(system.cache[menuObj.parentId])?"一级目录":system.cache[menuObj.parentId].name;
							menuObj['parentName']=pname;
						}
						 form.render();
						form.val("addFilter",menuObj);

						/******************自定义验证规则*************/
						form.verify({
							name: function(value) {
								if(system.isBlank(value)) {
									return '请输入菜单名称';
								}
							}
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
						form.on('submit(addFilterSubmit)', function(data) {
							var params = data.field;
							if(system.isBlank(menuId)) {
								params["lptype"] = 1;
								system.post("/system/menu", params, function (data) {
									if (data.code == "200") {
										layer.close(index);
										system.tip('新增成功!', 1);
										sysMenu.initDomainTable({parentId:system.isBlank(sysMenu.clickTreeId)?"0":sysMenu.clickTreeId});
										//重新加载树形结构
										sysMenu.initTree();
									} else {
										system.tip('操作失败，请刷新后重试!', 0);
									}
								});
							}
							//修改操作
							else{
								params["lptype"] = 3;
								system.post("/system/menu", params, function (data) {
									if (data.code == "200") {
										layer.close(index);
										system.tip('修改成功!', 1);
										sysMenu.initDomainTable({parentId:system.isBlank(sysMenu.clickTreeId)?"0":sysMenu.clickTreeId});
										//重新加载树形结构
										sysMenu.initTree();
									} else {
										system.tip('操作失败，请刷新后重试!', 0);
									}
								});
							}

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

	//初始化表格数据
	sysMenu.initDomainTable({parentId:"0"});
	//绑定监听类方法
	sysMenu.listenFun();
	sysMenu.initTree();


})
