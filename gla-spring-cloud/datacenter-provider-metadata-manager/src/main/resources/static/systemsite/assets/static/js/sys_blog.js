

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysBlog={
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"blogTable",
		//分页id
		tablePageId:"blogTablePage",
        listMap:[]
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#blogTableMain .table-tools",
			data:{},
			methods:{

				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysBlog.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/blog/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								system.tip("删除成功",1);
								sysBlog.initDomainTable();
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				},

			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#blogTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#blog_serach_title").val())){
						param['title']=$("#blog_serach_title").val();
					}
					sysBlog.initDomainTable(param);
				}
			}
		})

		//详细信息
		$("#"+sysBlog.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");

            system.post("/system/run/"+detailId,{type:2},function(data) {
                var result=null;

                if (data.code == "200") {
                    result = data.result;
                    listMap= JSON.stringify(result);
                    console.log(result);
                } else {
                    system.tip('操作失败，请刷新后重试!', 0);
                }
            });
			sysBlog.initDetail(detailId);
		})
		//详细信息
		$("#"+sysBlog.cons.tableId).LPClickDelegate(".statue",function(){
			var detailId=$(this).attr("data-value");

            system.post("/system/blog",{id:detailId,state:1,type:3},function(data) {
                var result=null;

                if (data.code == "200") {
                    system.tip('已发布', 1);
                } else {
                    system.tip('操作失败，请刷新后重试!', 0);
                }
            });
			 sysBlog.initDomainTable();
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
				{key :'title',name : '标题'},
				{key :'sourceUrl',name : '原文地址',formatter:function(cellvalue) {
					return  '<a href="'+cellvalue+'" target="_blank">'+cellvalue+'</a>';
				}},

				{key :'state',name : '状态',formatter:function(cellvalue){
                    // 状态 1正常  2草稿信（未发布） 3.待审批  -1：已删除
					if(cellvalue==1){
						return '<span class="layui-btn layui-btn-normal layui-btn-xs">已发布</span>';
					}else if(cellvalue==2){
                        return '<span class="layui-btn layui-btn-normal layui-btn-xs">草稿信</span>';

                    }else if(cellvalue==3){
                        return '<span class="layui-btn layui-btn-danger layui-btn-xs">待审批</span>';

                    }else{
						return '<span class="layui-btn layui-btn-danger layui-btn-xs"> 已删除 </span>'
					}
				  }
				},{key :'blogType',name : '博客类型',formatter:function(cellvalue){
                    // 文章类型（1 原创 2  转载 3 翻译 ）
					if(cellvalue==1){
						return '<span class="layui-btn layui-btn-normal layui-btn-xs">原创</span>';
					}else if(cellvalue==2){
                        return '<span class="layui-btn layui-btn-normal layui-btn-xs">转载</span>';

                    }else{
						return '<span class="layui-btn layui-btn-normal layui-btn-xs"> 翻译 </span>'
					}
				  }
				},
				{key :'idt',name : '创建时间',formatter:function (val){
                    return val;
                }},
				{key :'OP',name : '操作',formatters:function(domain){
					var iterm='';
						iterm+='<a  title="发布" class="statue" data-value="'+domain.id+'" href="javascript:;"> 发布 </a>';
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
			var curNum=$("#"+sysBlog.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysBlog.cons.tableId).LPTable("/system/blogs",params,option);
    },
    initDetail:function(detailId){

        // var options=[
        //     {key:'result',name:"result"}
        // ];

        var endDiv=$('<div></div>');
        var div=$('<div class="weadmin-body"></div>');
        var form=$('<form class="layui-form" lay-filter="addFilter1"></form>');

        // for(var m in options){
        //     var arr1=options[m];
        //     var item=$('<div class="layui-form-item"></div>');
        //     for(var n in arr1){
        //         var obj=arr1[n];
        //         item.append('<label  class="layui-form-label">'+obj.name+':</label>');
        //         item.append('<div class="layui-input-inline"><input type="text" style="background-color: #eee;"  disabled name="'+obj.key+'"  autocomplete="off" class="layui-input"></div>');
        //     }
        //     form.append(item);
        // }

        div.append("<h2>").append("查询结果:").append(listMap).append("</h2>");
        endDiv.append(div);
        system.open(endDiv.html(),{title:"详细信息",area:["800px","350px"]},function(){
            layui.use(['form', 'jquery', "laydate"], function () {
                var form = layui.form;
                var laydate = layui.laydate;
                //需要延时
                setTimeout(function () {

                    var data={account:"张三",name:"zs",class:"5年级",age:"23岁"}
                    form.val("addFilter1", system.cache[detailId]);
                }, 400)
            })

        })
    },

}

layui.use(['laydate','jquery','form'], function() {
	var $ = layui.jquery;
	var form = layui.form;

	//初始化表格数据
	sysBlog.initDomainTable();
	//绑定监听类方法
	sysBlog.listenFun();

})