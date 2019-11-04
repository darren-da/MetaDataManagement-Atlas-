


/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysCommand={
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"commandTable",
		//分页id
		tablePageId:"commandTablePage",
        listMap:[]
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#commandTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){
					sysCommand.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysCommand.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/command/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								system.tip("删除成功",1);
								sysCommand.initDomainTable();
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				},
				//更新操作
				updateSaveDomain:function(){
					sysCommand.updateDomain();
				}
			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#commandTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#command_serach_name").val())){
						param['name']=$("#command_serach_name").val();
					}
                    if(!system.isBlank($("#command_serach_code").val())){
                        param['code']=$("#command_serach_code").val();
                    }
					sysCommand.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+sysCommand.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				system.post("/system/command/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						sysCommand.initDomainTable()
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+sysCommand.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			sysCommand.updateDomain(updId);
		})
		//详细信息
		$("#"+sysCommand.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");
            system.post("/system/run/"+detailId,{type:4},function(data) {
                var result=null;

                if (data.code == "200") {
                    result = data.result;
                    sysCommand.cons.listMap= JSON.stringify(result);
                    console.log("wwww");
                    // console.log(listMap);
                    sysCommand.initDetail(detailId);

                } else {
                    system.tip('操作失败，请刷新后重试!', 0);
                }
            });

		})
		//配置命令菜单
	/*	$("#"+sysCommand.cons.tableId).LPClickDelegate(".setCommandPerms",function(){
			var detailId=$(this).attr("data-value");
			sysCommand.setCommandPerms(detailId);
		})*/
		//配置命令菜单
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
				{key :'name',name : '名称',sort:'name'},
				{key :'code',name : '编码',sort:'code'},
				{key :'ctype',name : '类型',formatter:function(val){
					return val==1?"系统命令":"API接口";
				}},
				{key :'intro',name : '介绍'},
				{key :'csql',name : 'sql语句',formatter:function(val){
					var reVal=val.length>30?val.substr(0,30)+"...":val;
					return  '<a title="'+val+'">'+reVal+'</a>';
				}},
				{key :'state',name : '状态',formatter:function(cellvalue){
					var state=cellvalue==1?'<span class="layui-btn layui-btn-normal layui-btn-xs">正常</span>':
						'<span class="layui-btn layui-btn-danger layui-btn-xs"> 已删除 </span>';
					return state;
				}
				},
				{key :'udt',name : '修改时间',sort:'udt',formatter:function (time){
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
						udt='新建命令，未修改';
					}
                    return udt;
                }},
				{key :'OP',name : '操作',formatters:function(domain){
					var iterm='';
					if(domain.state==1){
						 iterm+='<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>';
					}else if(domain.state==-1){
						iterm+='<a  title="启用" href="javascript:;"> <i class="layui-icon">&#xe601;</i> </a>';
					}
					iterm+='<a  title="修改" class="update"  data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>';
                    iterm+='<a title="运行SQL" class="detail" style="color: #00B83F" data-value="'+domain.code+'" href="javascript:;"> <i class="layui-icon">&#xe652;</i> </a>';
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
			var curNum=$("#"+sysCommand.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysCommand.cons.tableId).LPTable("/system/commands",params,option);




    },
    /**
	 * 查看详情
     * @param detailId
     */
    initDetail:function(detailId){

        var endDiv=$('<div></div>');
        var div=$('<div class="weadmin-body"></div>');
        var form=$('<form class="layui-form" lay-filter="addFilter1"></form>');
		//JSON.stringify(JSON.parse(listMap), null, 4) 解决json不格式化显示的问题
        div.append("<h2>").append("查询结果:").append(JSON.stringify(JSON.parse(sysCommand.cons.listMap), null, 4)).append("</h2>");
        var codeDiv=$('<pre class="layui-code" id="port-code"></pre>');
        codeDiv.append(div)
        endDiv.append(codeDiv);
        system.open(endDiv.html(),{title:"详细信息[IP/system/api/{apicode}?参数..]",area:["600px","380px"]},function(){
            layui.use(['form', 'jquery', "laydate"], function () {
                var form = layui.form;
                var laydate = layui.laydate;

            })

        })
    },

	/**
	 * 新增实体类
	 */
	saveDomain:function(){
		system.open("<div id='lp'>"+$('#tkAddCommand').html()+"</div>",{title:"新增命令",area:["600px","380px"]},function(layern,index){
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
									return '请输入命令名称';
								}
							}
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
						form.on('submit(addFilterSubmit)', function(data) {
							//console.log(data.field);
							var params = data.field;
							params["type"]=1;
							//异步新增人员
							system.post("/system/command",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('新增成功!',1);
									sysCommand.initDomainTable()
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
		system.open("<div id='lp'>"+$('#tkUpdateCommand').html()+"</div>",
            {title:"修改命令",area:["600px","380px"]},function(layern,index) {
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
							system.post("/system/command",params,function(data){
								if (data.code == "200") {
									layer.close(index);
									system.tip('修改成功!',1);
									sysCommand.initDomainTable();
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
	sysCommand.initDomainTable();
	//绑定监听类方法
	sysCommand.listenFun();

})