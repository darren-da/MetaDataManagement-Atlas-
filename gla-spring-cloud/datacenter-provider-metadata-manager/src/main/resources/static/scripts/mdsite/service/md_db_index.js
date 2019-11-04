

/**
 * 地区信息相关操作ss
 * @type {{initDomainTable: Function}}
 */
var dbSource={
	clickTreeId:"",
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"areaTable",
		//分页id
		tablePageId:"areaTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){

		//搜索
		var search_lp =new Vue({
			el:"#areaTableMain .table-search",
			data:{},
			methods:{

				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#perms_serach_code").val())){
						param['dbCode']=$("#perms_serach_code").val();
					}

                    if(!system.isBlank($("#perms_serach_name").val())){
                        param['name']=$("#perms_serach_name").val();
                    }

                    dbSource.initDomainTable(param);
				}
			}
		})
		var tool_utils =new Vue({
			el:"#areaTableMain .table-tools",
			data:{},
			methods:{
                //新增操作
                handleSaveDomain:function(){
                    dbSource.saveDomain();
                },

			}
		})
        //删除操作
        $("#"+dbSource.cons.tableId).LPClickDelegate(".del",function(){
            var delId=$(this).attr("data-value");
            system.confirm("",{title:"删除提示"},function(index){
                system.post("/db/dbsource/"+delId,{type:2},function(data){
                    if(data.code=="200") {
                        system.tip("删除成功",1);
                        dbSource.initDomainTable();
                    }else{
                        system.tip("删除失败，请重试！",0)
                    }
                })
            },function(index){ })
        })
		//修改操作
		$("#"+dbSource.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).parent().attr("data-value");
			dbSource.saveDomain(updId);
		})//修改操作



	},

	/**
	 * 初始化地区信息
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
				{key :'name',name : '数据库资源名称'},
				{key :'dbCode',name : '接数据库实例'},
				{key :'url',name : '连接地址'},
				{key :'username',name : '用户账号'},
				{key :'idt',name : '创建时间'},
			/*	{key :'上下文路径信息',name : '上下文路径信息',formatter:function(){

					return "/数据库/DSB/表/用户表/这些都是测试字段";
				}},*/
				// {key :'pcode',name : '上级编码',sort:'pcode'},

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
			var curNum=$("#"+dbSource.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+dbSource.cons.tableId).LPTable("/db/dbsource",params,option);


	},

	/**
	 * code为则为新增操作，有值则为修改操作
	 * 新增/修改 实体类
	 */
	saveDomain:function(code){
		system.open("<div id='lp'>"+$('#tkDomain').html()+"</div>",{title:system.isBlank(code)?"数据资源信息":"数据资源信息",area:["630px","450px"]},function(layern,index){
				layui.use(['form','jquery'], function() {
					var form = layui.form;
					setTimeout(function(){
						console.log(dbSource.clickTreeId);
						//重新渲染

						var areaObj={};
						//新增操作
						if(!system.isBlank(code)){
							areaObj=system.cache[code];
						}
						console.log(code);
						console.log(areaObj);
						form.render();
						form.val("addFilter",areaObj);

						/******************自定义验证规则*************/
						form.verify({
							name: function(value) {
								if(system.isBlank(value)) {
									return '请输入地区名称';
								}
							}
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
                        /***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
                        form.on('submit(addFilterSubmit)', function(data) {
                            var params = data.field;
                            if(system.isBlank(code)) {
                                params["lptype"] = 1;
                                // params["name"]="zs";
                                system.post("/db/dbsource", params, function (data) {
                                    if (data.code == "200") {
                                        layer.close(index);
                                        system.tip('新增成功!', 1);
                                        dbSource.initDomainTable({});
                                    } else {
                                        system.tip('操作失败，请刷新后重试!', 0);
                                    }
                                });
                            }
                            //修改操作
                            else{
                                params["lptype"] = 3;
                                system.post("/db/dbsource", params, function (data) {
                                    if (data.code == "200") {
                                        layer.close(index);
                                        system.tip('修改成功!', 1);
                                        dbSource.initDomainTable();
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
	dbSource.initDomainTable();
	//绑定监听类方法
	dbSource.listenFun();


});
