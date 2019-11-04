

/**
 * 地区信息相关操作
 * @type {{initDomainTable: Function}}
 */
var metaData={
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
                    if(!system.isBlank($("#perms_serach_name").val())){
                        param['name']=$("#perms_serach_name").val();
                    }
                    if(!system.isBlank($("#perms_type_name").val())){
                        param['typeName']=$("#perms_type_name").val();
                    }
                    metaData.initDomainTable(param);
				}
			}
		})

		//修改操作
		$("#"+metaData.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).parent().attr("data-value");
			metaData.saveDomain(updId);
		})//修改操作



	},

	/**
	 * 初始化地区信息
	 */
	initDomainTable:function(params){

		if(system.isBlank(params)){
			params={};
		}
		if(system.isBlank(params['name'])){
			params={"name":"*元数据*"};
		}

		params['type']=4;
		system.post("http://127.0.0.1:9991/search",params,function(data){
			console.log(data);
			var items=$("#test").html('');
			for(var m in data.result){
				var domain=data.result[m];
				system.cache[domain.id]=domain;
				console.log(domain)
				var id=domain.id.length>5?domain.id.substr(0,5)+"...":domain.id;
                var item=' <tr><td style="text-align:left;">'+id+'</td>' +
					'<td style="text-align:left;">'+domain.name+'</td>' +
					'<td style="text-align:left;">'+domain.code+'</td>' +
					'<td style="text-align:left;">'+domain.score+'</td>' +
					'<td style="text-align:left;">'+domain.typeName+'</td>' +
					'<td style="text-align:left;" title="'+domain.intro+'">'+domain.intro+'</td>' +
					'<td style="text-align:left;" title="'+domain.relation+'">详情</td>' +
					'<td style="text-align:left;cursor: pointer" onclick=metaData.connFunction("'+domain.id+'")>关联该词</td>' +
					'</tr>'
                items.append(item);
            }
		});
	},
	connFunction:function(id){
        var domain=system.cache[id];
        if(!system.isBlank($("#perms_serach_name").val())){
            domain['relation']=domain.relation+","+$("#perms_serach_name").val()
        }

        system.post("http://127.0.0.1:9991/conn",domain,function(data){
        	if(data.code=="200"){
        		system.tip("关联成功",1)
			}
		})
        console.log(domain);

	},

	/**
	 * code为则为新增操作，有值则为修改操作
	 * 新增/修改 实体类
	 */
	saveDomain:function(code){
		system.open("<div id='lp'>"+$('#tkDomain').html()+"</div>",{title:system.isBlank(code)?"元数据信息":"元数据信息",area:["630px","450px"]},function(layern,index){
				layui.use(['form','jquery'], function() {
					var form = layui.form;
					setTimeout(function(){
						console.log(metaData.clickTreeId);
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
					},200)

				})
		});
	}

}
layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;

	//初始化表格数据
	metaData.initDomainTable();
	//绑定监听类方法
	metaData.listenFun();


});
