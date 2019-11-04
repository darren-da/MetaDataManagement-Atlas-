

/**
 * 码表相关操作
 * @type {{initDomainTable: Function}}
 */
var sysCode={
	clickTreeId:"",
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"codeTable",
		//分页id
		tablePageId:"codeTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#codeTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){
					sysCode.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysCode.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/sys/code/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								sysCode.initDomainTable();
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
			el:"#codeTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#perms_serach_code").val())){
						param['dictdataValue']=$("#perms_serach_code").val();
					}

                    if(!system.isBlank($("#perms_serach_name").val())){
                        param['dictdataName']=$("#perms_serach_name").val();
                    }

					sysCode.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+sysCode.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				system.post("/sys/code/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						sysCode.initDomainTable({parentId:system.isBlank(sysCode.clickTreeId)?"0":sysCode.clickTreeId});
						//重新加载树形结构
						sysCode.initTree();
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+sysCode.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			sysCode.saveDomain(updId);
		})//修改操作


		//更改状态
		$("#"+sysCode.cons.tableId).LPClickDelegate(".state",function(){
			var detailId=$(this).parent().attr("data-value");
			var params={};
			params["type"]=3;
			system.post("/sys/code/"+detailId+"/state/1",params,function(data){
				if (data.code == "200") {
					sysCode.initDomainTable();
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
				//sysCode.initMenu(treeNode.id);
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
				//sysCode.initMenu(main.menuData[treeNode.id]);
				sysCode.clickTreeId=treeNode.id;
                console.log('========treeid========')
                console.log(sysCode.clickTreeId);
				sysCode.initDomainTable({dictPvalue:treeNode.id});

			}
		}
		var nodes=new Array();
		system.post("/sys/codeList/",{type:4,rows:200},function(data){
			console.log("code--data")
			console.log(data)
			for(var i in data.result){
				var domain=data.result[i];
				//bak code数据
				system.cache[domain.dictdataValue]=domain;
				var node={};
				node["id"]=domain.dictdataValue+"";
				node["pId"]=domain.dictPvalue+"";
				node["name"]=domain.dictdataName+"";
				node["t"]=domain.dictdataName+"";
				node["open"]=false;
				if("0"==domain.dictPvalue){
					node["open"]=true;
				}
				nodes.push(node);
			}
			sysCode.clickTreeId="";
			// zNodes=zNodes.concat(nodes)
			$.fn.zTree.init($("#treeDemo"), setting, nodes);
			$("#load_code").hide();
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
			cacheKey:"dictdataValue",
			//控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
			table:{thStyle:"text-align:left;white-space: nowrap;cursor:pointer",tdStyle:"text-align:left;"},
			colModel : [
				{key :'NO.',name : '序号'},
				/*{key :'perms',name : '权限标识',sort:'state',formatter:function(cellvalue){
					var perms=system.isBlank(cellvalue)?'--': cellvalue;
					return perms;
				}
				},*/

				{key :'dictdataName',name : '码表名称'},
				{key :'dictdataValue',name : '码表编号',sort:'dictdataValue'},
                {key :'dictPvalue',name : '上级码表编号',sort:'dictPvalue'},
				{key :'dictIntro',name : '码表介绍'},
				// {key :'url',name : 'url'},

				{key :'OP',name : '操作',formatters:function(domain){
					var itemObj=$('<span data-value="'+domain.id+'"></span>');
					if(domain.dictStatue==1){
						itemObj.append('<a title="删除" class="del" href="javascript:;" data-value="'+domain.dictdataValue+'" > <i class="layui-icon">&#xe640;</i> </a>')
					}
					itemObj.append('<a  title="编辑" class="update"  data-value="'+domain.dictdataValue+'" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>');
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
			var curNum=$("#"+sysCode.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysCode.cons.tableId).LPTable("/sys/codes",params,option);


	},

	/**
	 * dictdataValue为则为新增操作，有值则为修改操作
	 * 新增/修改 实体类
	 */
	saveDomain:function(dictdataValue){
		system.open("<div id='lp'>"+$('#tkAddCode').html()+"</div>",{title:system.isBlank(dictdataValue)?"新增码表":"修改码表",area:["630px","450px"]},function(layern,index){
				layui.use(['form','jquery'], function() {
					var form = layui.form;
					setTimeout(function(){
						console.log(sysCode.clickTreeId);
						//重新渲染

						var codeObj={};
						//新增操作
						if(system.isBlank(dictdataValue)){
							//点击了码表管理
							if(sysCode.clickTreeId){
								var obj=system.cache[sysCode.clickTreeId];
								codeObj={dictPvalue:obj.dictPvalue,parentName:obj.dictdataName}
							}else {
								codeObj={dictPvalue:"0",parentName:"一级码表"}
							}
						}else{
							codeObj=system.cache[dictdataValue];
							var pname=system.isBlank(system.cache[codeObj.dictPvalue])?"一级目录":system.cache[codeObj.dictPvalue].dictdataName;
							codeObj['parentName']=pname;
						}
						 form.render();
						form.val("addFilter",codeObj);

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
							if(system.isBlank(dictdataValue)) {
								params["lptype"] = 1;
								system.post("/sys/code", params, function (data) {
									if (data.code == "200") {
										layer.close(index);
										system.tip('新增成功!', 1);
										sysCode.initDomainTable({parentId:system.isBlank(sysCode.clickTreeId)?"0":sysCode.clickTreeId});
										//重新加载树形结构
										sysCode.initTree();
									} else {
										system.tip('操作失败，请刷新后重试!', 0);
									}
								});
							}
							//修改操作
							else{
								params["lptype"] = 3;
								system.post("/sys/code", params, function (data) {
									if (data.code == "200") {
										layer.close(index);
										system.tip('修改成功!', 1);
										sysCode.initDomainTable({parentId:system.isBlank(sysCode.clickTreeId)?"0":sysCode.clickTreeId});
										//重新加载树形结构
										sysCode.initTree();
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
	sysCode.initDomainTable({dictPvalue:"0"});
	//绑定监听类方法
	sysCode.listenFun();
	sysCode.initTree();


})
