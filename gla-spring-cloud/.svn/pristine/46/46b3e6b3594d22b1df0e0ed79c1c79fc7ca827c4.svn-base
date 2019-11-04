

/**
 * 用户相关操作
 * @type {{initDomainTable: Function}}
 */
var sysUser={
    clickTreeId:"",
	//汇总所有相关的静态变量，统一全局调用，便于修正ID
	cons:{
		//表格ID
		tableId:"userTable",
		//分页id
		tablePageId:"userTablePage"
	},

	/**
	 * 事件监听函数：用户监听绑定的事件
	 */
	listenFun:function(){
		//工具栏事件绑定
		var tools_lp =new Vue({
			el:"#userTableMain .table-tools",
			data:{},
			methods:{
				//新增操作
				handleSaveDomain:function(){
					sysUser.saveDomain();
				},
				//删除操作
				handleDelDomains:function(){
				   var  arrIds= $("#"+sysUser.cons.tableId).LPTableCheckedIds();
					if(arrIds.length==0){
						system.tip("请选择删除的记录",0);
						return;
					}
					//开始删除
					system.confirm("",{title:"删除提示"},function(index){
						system.post("/system/user/"+arrIds.join(","),{type:2},function(data){
							if(data.code=="200") {
								sysUser.initDomainTable();
								setTimeout(system.tip("删除成功",1),3000)
							}else{
								system.tip("删除失败，请重试！",0)
							}
						})
					},function(index){ })
				},
				//更新操作
				updateSaveDomain:function(){
					sysUser.updateDomain();
				}
			}
		})
		//搜索
		var search_lp =new Vue({
			el:"#userTableMain .table-search",
			data:{},
			methods:{
				//提交
				handleSeach:function(){
					var param={};
					if(!system.isBlank($("#user_serach_account").val())){
						param['account']=$("#user_serach_account").val();
					}
					if(!system.isBlank($("#start").val())){
						param['createdate']=$("#start").val();
					}if(!system.isBlank($("#end").val())){
						param['lpEndDate']=$("#end").val();
					}
					sysUser.initDomainTable(param);
				}
			}
		})
		//删除操作
		$("#"+sysUser.cons.tableId).LPClickDelegate(".del",function(){
			var delId=$(this).attr("data-value");
			system.confirm("",{title:"删除提示"},function(index){
				system.post("/system/user/"+delId,{type:2},function(data){
					if(data.code=="200") {
						system.tip("删除成功",1);
						sysUser.initDomainTable()
					}else{
						system.tip("删除失败，请重试！",0)
					}
				})
			},function(index){ })
		})
		//修改操作
		$("#"+sysUser.cons.tableId).LPClickDelegate(".update",function(){
			var updId=$(this).attr("data-value");
			sysUser.updateDomain(updId);
		})//修改操作
		$("#"+sysUser.cons.tableId).LPClickDelegate(".detail",function(){
			var detailId=$(this).attr("data-value");
			sysUser.initDetail(detailId);
		})
		//设置权限
		$("#"+sysUser.cons.tableId).LPClickDelegate(".setUserRole",function(){
			var detailId=$(this).attr("data-value");
			sysUser.setUserRoles(detailId);
		})
		//更改状态
		$("#"+sysUser.cons.tableId).LPClickDelegate(".state",function(){
			var detailId=$(this).parent().attr("data-value");
			var params={};
			params["type"]=3;
			system.post("/system/user/"+detailId+"/state/1",params,function(data){
				if (data.code == "200") {
					sysUser.initDomainTable();
					system.tip('修改成功!',1);
				} else {
					system.tip('操作失败，请刷新后重试!', 0);
				}
			});
		})
	},
    /**
     * 加载部门信息管理 属性结构
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
                //sysUser.initMenu(treeNode.id);
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
        	console.log("----------");
        	console.log(treeNode);
            if(1==clickFlag){
                //sysUser.initArea(main.areaData[treeNode.id]);
                sysUser.clickTreeId=treeNode.code;

                console.log(sysUser.clickTreeId);
                sysUser.initDomainTable({unitcode:treeNode.code});
            }
        }
        var nodes=new Array();
        system.post("/system/deptsList",{type:4,rows:200},function(data){
            console.log("area--data")
            console.log(data)
            for(var i in data.result){
                var domain=data.result[i];
                //bak area数据
                system.cache[domain.id]=domain;
                var node={};
                node["id"]=domain.id+"";
                node["pId"]=domain.parentId+"";
                node["code"]=domain.code+"";
                node["name"]=domain.name+"";
                node["t"]=domain.name+"";
                node["open"]=false;
                if("0"==domain.parentId){
                    node["open"]=true;
                }
                nodes.push(node);
            }
            sysUser.clickTreeId="";
            // zNodes=zNodes.concat(nodes)
            console.log("------------")
            console.log(nodes)
            $.fn.zTree.init($("#treeDemo"), setting, nodes);
            $("#load_user").hide();
        })
    }  ,
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
				{key :'account',name : '账号',sort:"account"},
				{key :'name',name : '昵称',sort:'name'},
				{key :'rc1',name : '性别',sort:'rc1',formatter:function(cellvalue) {
					return system.isBlank(cellvalue)?"未知":cellvalue;
				}},
				{key :'createdate',name : '注册时间',sort:'createdate'},
				{key :'state',name : '用户状态',sort:'state',formatter:function(cellvalue){
					var state=cellvalue==1?'<span class="layui-btn layui-btn-normal layui-btn-xs">已启用</span>':
						'<span class="layui-btn layui-btn-danger layui-btn-xs"> 已删除 </span>';
					return state;
				}
				},
                {key :'unitcode',name : '单位编码',sort:'unitcode'},
				{key :'OP',name : '操作',formatters:function(domain){
					var itemObj=$('<span data-value="'+domain.id+'"></span>');
					if(domain.state==1){
						itemObj.append('<a title="删除" class="del" href="javascript:;" data-value="'+domain.id+'" > <i class="layui-icon">&#xe640;</i> </a>')
					}else if(domain.state==-1){
						itemObj.append('<a  title="启用" class="state" href="javascript:;"> <i class="layui-icon">&#xe601;</i> </a>');
					}
					itemObj.append('<a title="配置角色"  class="setUserRole" data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe631;</i> </a>');
					itemObj.append('<a title="详细信息" class="detail" data-value="'+domain.id+'" href="javascript:;"> <i class="layui-icon">&#xe63c;</i> </a>');
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
			var curNum=$("#"+sysUser.cons.tablePageId+" .current").attr("data-value");
			params['page']=system.isBlank(curNum)?1:curNum;
		}
		params['type']=4;
		$("#"+sysUser.cons.tableId).LPTable("/system/users",params,option);


	},

	/**
	 * 新增实体类
	 */
	saveDomain:function(code){
		system.open("<div id='lp'>"+$('#tkAddUser').html()+"</div>",{title:"新增人员",area:["500px","450px"]},function(layern,index){
				layui.use(['form','jquery',"laydate"], function() {
					var form = layui.form;
					var laydate = layui.laydate;
					//需要延时
					setTimeout(function(){

                        var codeObj={};
                        //新增操作
                        if(system.isBlank(code)){
                            //点击了单位部门管理
                            if(sysUser.clickTreeId){
                                var obj=system.cache[sysUser.clickTreeId];
                                codeObj={unitcode:obj.code,parentName:obj.name}
                            }else {
                                codeObj={unitcode:"0",parentName:"一级目录"}
                            }
                        }else{
                            codeObj=system.cache[code];
                            var pname=system.isBlank(system.cache[codeObj.code])?"一级目录":system.cache[codeObj.parentId].name;
                            codeObj['parentName']=pname;
                        }
						//重新渲染
                        form.render();
                        form.val("addFilter",codeObj);
						 // form.render(null, 'addFilter');

						//执行一个laydate实例 ： /*指定元素*/
						laydate.render({ elem: '#lp_expiredate'});

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
								system.post("/system/users",{type:4,account:$('#lp_account').val()},function(data){
								console.log(data);
								})
							}*/
						});

						/***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
						form.on('submit(addFilterSubmit)', function(data) {
							//console.log(data.field);
							var params = data.field;
							params["type"]=1;
							//checkbox swith开关处理：选中传递过来的为on此时变为1，其他的为0
							params["rc3"]=params["rc3"]=="on"?1:0;
							params["isautoexpire"]=params["isautoexpire"]=="on"?1:0;
							//异步新增人员
							system.post("/system/user",params,function(data){
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
		system.open("<div id='lp'>"+$('#tkUpdateUser').html()+"</div>",
			{title:"修改人员"},function(layern,index) {
				layui.use(['form', 'jquery', "laydate"], function () {
					var form = layui.form;
					var laydate = layui.laydate;
					//需要延时
					setTimeout(function(){
						form.render() //重新渲染
						form.val("updateFilter", domainInfo);
						laydate.render({ elem: '#lp_expiredate_1',format: 'yyyy-MM-dd HH:mm:ss'});
						/*
						 $("#XXX").prop('checked',true);*/
						form.on('submit(updateFilterSubmit)', function(data) {
							var params = data.field;
							params["type"]=3;
							//checkbox swith开关处理：选中传递过来的为on此时变为1，其他的为0
							params["rc3"]=params["rc3"]=="on"?1:0;
							params["isautoexpire"]=params["isautoexpire"]=="on"?1:0;
							//异步新增人员
							console.log(params)
							system.post("/system/user",params,function(data){
								if (data.code == "200") {
									sysUser.initDomainTable();
									layer.close(index);
									system.tip('修改成功!',1);
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
	setUserRoles:function(userId){

		var domainInfo=system.cache[userId];
		//判断是否为空
		if(system.isBlank(domainInfo)){
			return;
		}
		system.open("<div id='lp'>"+$('#tkSetUserRoles').html()+"</div>",
			{title:"设置角色",area:['500px','460px']},function(layern,index) {
				layui.use(['form', 'jquery'], function () {
					var form = layui.form;
					//加载角色
					var roleIds="";
					system.post("/system/user/"+userId+"/roles",{type:4},function(data){
						if(data.code=="200"){
							$("#roles-option").html(' ');
							$("#roles-option").append('<option value="">请选择角色</option>');
							for(var m in data.result){
								var domain=data.result[m];
								//var check=domain.checked
								if(domain.checked){
									roleIds=domain.id;
									$("#roles-option").prepend('<option checked="'+domain.checked+'" value="'+domain.id+'">'+domain.name+'</option>');
								}else{
									$("#roles-option").append('<option checked="'+domain.checked+'" value="'+domain.id+'">'+domain.name+'</option>');
								}
							}
						}
						domainInfo['roleIds']=roleIds;
						form.val("setUserRoleFilter", domainInfo);
						form.render() //重新渲染
						/*
						 $("#XXX").prop('checked',true);*/
						form.on('submit(setUserRoleFilterSubmit)', function(data) {
							var params = data.field;
							params["type"]=1;
							system.post("/system/user/" + data.field.id + "/roles", params, function (data) {
								if (data.code == "200") {
									system.tip('修改成功!', 1);
									layer.close(index);
								} else {
									system.tip('操作失败，请刷新后重试!', 0);
								}
							});
							//阻止提交表单
							return false;
						})

					})
				})
			})
	},
	initDetail:function(detailId){
		var options=[
			[{key:"account",name:"账号"},{key:"name",name:"昵称"}],
			[{key:"isautoexpire",name:"自动到期"},{key:"expiredate",name:"过期时间"}],
			[{key:"phone",name:"手机"},{key:"email",name:"邮箱"}],
			[{key:"state",name:"用户状态"},{key:"email",name:"邮箱"}],
			[{key:"rc3",name:"是否加密"},{key:"utype",name:"用户类型"}],
			[{key:"icn",name:"身份标识"},{key:"unitcode",name:"单位编码"}],
			[{key:"conaccount",name:"关联账号"},{key:"keypath",name:"秘钥路径"}],
			[{key:"remarks",name:"备注"}],
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
		system.open(endDiv.html(),{title:"详细信息",area:["800px","450px"]},function(){
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
	sysUser.initDomainTable();
	//绑定监听类方法
	sysUser.listenFun();

	sysUser.initTree();


})
