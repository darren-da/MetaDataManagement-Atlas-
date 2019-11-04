


/**
 * 数据库操作API快速构建
 * @type {{initDomainTable: Function}}
 */
var sysCommandDB={

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

					sysCommandDB.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysCommandDB.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/user/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								sysCommandDB.initDomainTable();
								setTimeout(system.tip("删除成功",1),3000)
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				}
			}
		})


	},
	/**
	 * 加载菜单管理 属性结构
	 */
	initTree:function(){
		var setting = {
			data: {
				key: {
					title:"title"
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
				//sysCommandDB.initMenu(treeNode.id);
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
				//sysCommandDB.initMenu(main.menuData[treeNode.id]);
				sysCommandDB.clickTreeId=treeNode.id;
				sysCommandDB.initDomainTableStatic({tableName:treeNode.id});
				$("#addAPI").html("操作表:"+treeNode.id+" &nbsp;("+treeNode.title+")");

			}
		}
		var nodes=new Array();
		system.post("/system/api/MYSQL_SELECT_ALL_TABLES",{type:4,rows:200},function(data){
			console.log("meun--data")
			console.log(data)
			for(var i in data.result){
				var domain=data.result[i];
				//bak menu数据
				system.cache[domain.tableName]=domain;
				var node={};
				node["id"]=domain.tableName+"";
				node["pId"]="0";
				node["name"]=domain.tableName+"";
				node["title"]=domain.comment+"";
				node["open"]=false;
				if("0"==domain.parentId){
					node["open"]=true;
				}
                node["icon"]="/systemsite/assets/static/images/tb.png";

                nodes.push(node);
			}
            nodes.push({id:"0",pid:"1",name:"DB",title:"数据库",icon:"/systemsite/assets/static/images/db.png"});

            sysCommandDB.clickTreeId="";
			// zNodes=zNodes.concat(nodes)
			$.fn.zTree.init($("#treeDemo"), setting, nodes);
			$("#load_menu").hide();
		})
	}  ,
    /**
	 * 展示表所有的字段
     * @param params
     */
	initDomainTableStatic:function (params) {
		system.post("/system/api/MYSQL_SELECT_ALL_COLUMN",params,function(data){
            layui.use(['laydate','table','jquery','form'], function() {
                var $ = layui.jquery;
                var form = layui.form;
                var table = layui.table;
                /****初始化数据**********/
                var dataCol=[];
				for(var m in data.result){
                    var  domain=data.result[m];
                    var col={};
                    dataCol.push(domain['字段名']);

                }

                $("#code").val(params.tableName);
                $("#csql").val("select "+dataCol.join(",")+" from "+params.tableName);
                //执行一个 table 实例
                table.render({
                    elem: '#menuTable'
                    ,height: 420
                    ,title: '用户表'
                    ,limit: 50
                    ,page: false //开启分页
                    // ,toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
                    ,totalRow: true //开启合计行
					, height: 'full'
                    ,cols: [[ //标题栏
                        {type:'checkbox',fixed: 'left'},
                        {field: '字段名', title: '字段名', width: 180, sort: true}
                        ,{field: '字段说明', title: '字段说明', minWidth: 150}
                        ,{field: '字段类型', title: '字段类型', width: 120}
                        ,{field: '约束', title: '约束', minWidth: 80}
                    ]]
                    ,data:data.result
					/*	[{
                        "id": "10001"
                        ,"username": "杜甫"
                        ,"joinTime": "2016-10-14"
                    },*/
                });





            })

        })


    },
    skimData:function(){
		var sql=$("#csql").val();
		if(system.isBlank(sql)){
			alert("请输入有效sql");
			return;
		}
		if(sql.indexOf("{")>-1){
            alert("请输入有效sql,预览功能参数需要初始化");
            return;
		}

        system.post("/system/api-test",{sql:sql},function(data) {
            var result=null;

            if (data.code == "200") {
                result = data.result;
               var listMap= JSON.stringify(result);
                var endDiv=$('<div></div>');
                var div=$('<div class="weadmin-body"></div>');
                var form=$('<form class="layui-form" lay-filter="addFilter1"></form>');
                div.append("<h2>").append("查询结果:").append(JSON.stringify(JSON.parse(listMap), null, 4)).append("</h2>");
                var codeDiv=$('<pre class="layui-code" id="port-code"></pre>');
                codeDiv.append(div)
                endDiv.append(codeDiv);
                system.open(endDiv.html(),{title:"详细信息",area:["600px","650px"]},function(){
                    layui.use(['form', 'jquery', "laydate"], function () {
                        var form = layui.form;
                        var laydate = layui.laydate;
                    })

                })

            } else {
                system.tip('操作失败，请刷新后重试!', 0);
            }
        });

	},
	//获取选中的列,生成sql
    checkStatus:function(){
        layui.use(['laydate','table','jquery','form'], function() {
            var $ = layui.jquery;
            var form = layui.form;
            var table = layui.table;
            var checkStatus = table.checkStatus('menuTable')
                ,data = checkStatus.data;
			if(data.length==0){
                layer.alert("请选择生成SQL的字段");
            	return ;
			}
			var dataCol=[];
			for(var  m in data){
                dataCol.push(data[m]['字段名'])
			}
            $("#csql").val("select "+dataCol.join(" ,  ")+" from "+data[0]['表名']);
		})
	},
	/**
	 * 初始化菜单信息
	 */
	initDomainTable:function(params){
		var option={
			async:true,//action请求是否异步，true为为异步请求【默认为true异步请求】
			pageFlay:false,//是否分页，默认为true 进行分页；为false则不进行分页
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
			var curNum=$("#"+sysCommandDB.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysCommandDB.cons.tableId).LPTable("/system/run/MYSQL_SELECT_ALL_COLUMN",params,option);


	},

	/**
	 * menuId为则为新增操作，有值则为修改操作
	 * 新增/修改 实体类
	 */
	saveDomain:function(menuId){
		system.confirm("是否立即构建API接口？",{title:"增加API接口",btn :['立即构建','考虑一下']},function(){
            var params={};
            params["type"]=1;
            params["code"]=$("#code").val();
            params["csql"]=$("#csql").val();
            params["rc1"]=$("#rc1").val();
            params["name"]=$("#name").val();
            params["ctype"]=2;
            console.log(params);
            system.post("/system/command", params, function (data) {
                if (data.code == "200") {
                    system.tip('新增成功!', 1);
                } else {
                    system.tip('不可重复添加!', 0);
                }
            });
		},function(){

			}
		)



	}

}
layui.use(['laydate','table','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;
	var table = layui.table;

	//初始化表格数据
	// sysCommandDB.initDomainTable({parentId:"0"});
	//绑定监听类方法
	sysCommandDB.listenFun();
	sysCommandDB.initTree();




})
