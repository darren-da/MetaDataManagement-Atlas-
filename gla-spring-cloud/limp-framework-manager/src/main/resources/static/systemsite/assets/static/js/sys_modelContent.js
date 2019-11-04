

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysModelContent={
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"modelContentTable",
		//分页id
		tablePageId:"modelContentTablePage",
        listMap:[]
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#modelContentTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){
					sysModelContent.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysModelContent.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/modelContent/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								system.tip("删除成功",1);
								sysModelContent.initDomainTable();
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				},
				//更新操作
				updateSaveDomain:function(){
					sysModelContent.updateDomain();
				}
			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#modelContentTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#modelContent_serach_title").val())){
						param['title']=$("#modelContent_serach_title").val();
					}
                    if(!system.isBlank($("#modelContent_serach_code").val())){
                        param['code']=$("#modelContent_serach_code").val();
                    }
					sysModelContent.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+sysModelContent.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				system.post("/system/modelContent/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						sysModelContent.initDomainTable()
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+sysModelContent.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			sysModelContent.updateDomain(updId);
		})
		$("#"+sysModelContent.cons.tableId).LPClickDelegate(".setModelContentPerms",function(){
			var detailId=$(this).attr("data-value");
			sysModelContent.setModelContentPerms(detailId);
		})
		//配置模板菜单
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
				{key :'title',name : '标题',sort:'title'},
				{key :'code',name : '编码',sort:'code'},
				{key :'content',name : '内容',sort:'content'},
				{key :'intro',name : '描述'},
				{key :'param',name : '参数说明'},
				{key :'modelType',name : '类型'},
				{key :'modelSort',name : '排序'},
				{key :'status',name : '状态',formatter:function(cellvalue){
					var status=cellvalue==1?'<span class="layui-btn layui-btn-normal layui-btn-xs">正常</span>':
						'<span class="layui-btn layui-btn-danger layui-btn-xs"> 已删除 </span>';
					return status;
				}
				},
                {key :'idt',name : '创建时间',formatter:function (time){
                    var udt='';
                    if (!system.isBlank(time)){
                        var date = new Date(time);
                        var year = date.getFullYear(),
                            month = date.getMonth()+1,//月份是从0开始的
                            day = date.getDate();
                        udt = year + '-' +
                            (month < 10? '0' + month : month) + '-' +
                            (day < 10? '0' + day : day)
                    }else {
                        udt='新建模板，未曾修改';
                    }
                    return udt;}},
				{key :'udt',name : '修改时间',formatter:function (time){
                    var udt='';
					if (!system.isBlank(time)){
                    var date = new Date(time);
                    var year = date.getFullYear(),
                        month = date.getMonth()+1,//月份是从0开始的
                        day = date.getDate();
                     udt = year + '-' +
                        (month < 10? '0' + month : month) + '-' +
                        (day < 10? '0' + day : day)
                    }else {
						udt='新建模板，未曾修改';
					}
                    return udt;
                }},
				{key :'OP',name : '操作',formatters:function(domain){
					var iterm='';
					if(domain.status==1){
						 iterm+='<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>';
					}else if(domain.status==-1){
						iterm+='<a  title="启用" href="javascript:;"> <i class="layui-icon">&#xe601;</i> </a>';
					}
					// iterm+='<a title="配置权限" class="setModelContentPerms" data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe631;</i> </a>';
					//  iterm+='<a title="运行SQL" class="detail" data-value="'+domain.code+'" href="javascript:;"> <i class="layui-icon">&#xe63c;</i> </a>';
					iterm+='<a  title="修改" class="update"  data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>';
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
			var curNum=$("#"+sysModelContent.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysModelContent.cons.tableId).LPTable("/system/modelContents",params,option);




    },

	/**
	 * 新增实体类
	 */
	saveDomain:function(){
		system.open("<div id='lp'>"+$('#tkAddModelContent').html()+"</div>",{title:"新增模板",area:["500px","380px"]},function(layern,index){
				layui.use(['form','jquery',"laydate"], function() {
					var form = layui.form;
					var laydate = layui.laydate;
					//需要延时
					setTimeout(function(){

						//重新渲染
						 form.render(null, 'addFilter');


						/******************自定义验证规则*************/
						form.verify({
                            name: function(name) {
								if(system.isBlank(name)) {
									return '请输入模板名称';
								}
							}
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
						form.on('submit(addFilterSubmit)', function(data) {
							//console.log(data.field);
							var params = data.field;
							params["type"]=1;
							//异步新增人员
							system.post("/system/modelContent",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('新增成功!',1);
									sysModelContent.initDomainTable()
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
		system.open("<div id='lp'>"+$('#tkUpdateModelContent').html()+"</div>",
			{title:"修改模板",area:["500px","380px"]},function(layern,index) {
				layui.use(['form', 'jquery', "laydate"], function () {
					var form = layui.form;
					// var laydate = layui.laydate;
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
							system.post("/system/modelContent",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('修改成功!',1);
									sysModelContent.initDomainTable();
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


	}

}

layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;

	//初始化表格数据
	sysModelContent.initDomainTable();
	//绑定监听类方法
	sysModelContent.listenFun();

})