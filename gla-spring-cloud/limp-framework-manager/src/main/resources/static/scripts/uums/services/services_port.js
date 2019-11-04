

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var servicePort={
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

		$("#"+servicePort.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");
			servicePort.initDetail(detailId);
		})
		//点击操作
		$("#port-list").LPClickDelegate("button",function(){
			$("#port-list button").each(function(){
				if($(this).hasClass("lp-click")){
					$(this).removeClass("lp-click")
				}
			})
			$(this).addClass("lp-click");
			var portDomain=system.cache[$(this).attr("value")];
			var params={};
			params['type']='4';
			params['serviceid']=$(this).attr("value");
			//查询最近订单情况

				var optionOrder={
				async:true,//action请求是否异步，true为为异步请求【默认为true异步请求】
				pageFlay:false,//是否分页，默认为true 进行分页；为false则不进行分页
				//【浏览器缓存】是否需要缓存  会缓存到system.cache[""]
				cache:false,
				//缓存的key值，取值方法 system.cache["id"]
				cacheKey:"id",
				//控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
				table:{thStyle:"text-align:left;white-space: nowrap;cursor:pointer",tdStyle:"text-align:left;"},
				colModel : [
					{key :'serviceName',name : 'service方法',sort:'SERVICE_METHOD'},
					{key :'idt',name : '订单创建时间'},
					{key :'parms',name : '请求参数'},
					{key :'OP',name : '操作',formatters:function(domain){
						var iterm='';
						iterm+='<a title="详细信息" class="detail" data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe63c;</i> </a>';
						return iterm;
					}
					}
				]

			};

			$("#ordertable").LPTable("/orders",{type:"4",rows:3,serviceName:portDomain.serviceMethod,lpsort:"IDT DESC"},optionOrder)

			system.post("/servicesParams",params,function(data){
				console.log(data);
				//http://114.112.193.6:39000/service
				var form=$('<form id="services-form" onsubmit="return false"></form>');
				var paramsSend=$("<tbody></tbody>");
				paramsSend.append('<tr><td style="text-align:right;">访问URL地址</td><td style="text-align:left;">' +
				'<input type="text" name="url" class="layui-input" value="http://192.168.120.89:8089/service"></td>');
				paramsSend.append('<tr><td style="text-align:right;" >账户UID</td><td><input type="text" name="uid" value="0" class="layui-input"></td><tr>');
				paramsSend.append('<tr><td style="text-align:right;">方法Method</td><td><input type="text" name="service"  value="'+portDomain.serviceMethod+'" class="layui-input"></td><tr>');

				if(data.code=="200"){
					for(var n in data.result.dataList){
						var domain=data.result.dataList[n];
						paramsSend.append('<tr><td style="text-align:right;">'+domain.paramName+'</td><td><input name="'+domain.paramKey+'" type="text" placeholder="'+domain.paramKey+'" class="layui-input"></td><tr>');
					}
				}

				//提交
				paramsSend.append('<tr><td colspan="2" style="text-align:center;"><button class="layui-btn" onclick=servicePort.sendServiceForm()>提交</button></td></tr>');
				form.append(paramsSend);
				$("#servicesTable").html(form);


			})
		})
	},
	sendServiceForm:function(formId){
		//services-form 如果没有给input加name属性， 是不会生成字符串的
		var arrForm=$("#services-form").serializeArray();
		var params={};
		params['type']=4;
		for(var n in arrForm){
			var objMap=arrForm[n]
			params[objMap.name]=objMap.value;
		}
		console.log(params);
		system.post("/servicesPort",params,function(data){
			console.log(data);
			if(data.code=='200'){
				console.log("/**url返回数据***/");
				console.log(data.result);
				$("#port-code").text(JSON.stringify(data.result));

				layui.use('code', function(){ //加载code模块
					layui.code(); //引用code方法
				})
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

		params['type']=4;
		params['rows']=100;
		system.post("/services",params,function(data){
			console.log(data);
			if(data.code=="200"){
				for( var m in data.result.dataList){
					var domain=data.result.dataList[m];
					system.cache[domain.id]=domain;
					$("#port-list").append('<span><button class="layui-btn" style="height: 28px !important; line-height: 28px !important;margin: 3px 3px;" value="'+domain.id+'">'+m+"、"+domain.serviceName+'</button></span>');
				}
			}
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
	servicePort.initDomainTable();
	//绑定监听类方法
	servicePort.listenFun();

})
