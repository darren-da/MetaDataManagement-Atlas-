/**
 * 地区信息相关操作
 * @type {{initDomainTable: Function}}
 */
var metaMain = {
    clickTreeId: "",
    //汇总所有相关的静态变量，统一全局调用，便于修正ID
    cons: {
        //表格ID
        tableId: "areaTable",
        //分页id
        tablePageId: "areaTablePage"
    },



    /**
     * 事件监听函数：用户监听绑定的事件
     */
    listenFun: function () {
        //工具栏事件绑定
        var tools_lp = new Vue({
            el: "#areaTableMain .table-tools",
            data: {},
            methods: {
                //新增操作
                handleSaveDomain: function () {
                    metaMain.saveDomain();
                },
                //删除操作
                handleDelDomains: function () {
                    var arrIds = $("#" + metaMain.cons.tableId).LPTableCheckedIds();
                    if (arrIds.length == 0) {
                        system.tip("请选择删除的记录", 0);
                        return;
                    }
                    //开始删除
                    system.confirm("", {title: "删除提示"}, function (index) {
                        system.post("/sys/area/" + arrIds.join(","), {type: 2}, function (data) {
                            if (data.code == "200") {
                                metaMain.initDomainTable();
                                setTimeout(system.tip("删除成功", 1), 3000)
                            } else {
                                system.tip("删除失败，请重试！", 0)
                            }
                        })
                    }, function (index) {
                    })
                }
            }
        });
        //搜索
        var search_lp = new Vue({
            el: "#areaTableMain .table-search",
            data: {},
            methods: {
                //提交
                handleSeach: function () {
                    var param = {};
                    if (!system.isBlank($("#perms_serach_code").val())) {
                        param['code'] = $("#perms_serach_code").val();
                    }

                    if (!system.isBlank($("#perms_serach_name").val())) {
                        param['name'] = $("#perms_serach_name").val();
                    }

                    metaMain.initDomainTable(param);
                }
            }
        })
        //删除操作
        $("#" + metaMain.cons.tableId).LPClickDelegate(".del", function () {
            var delId = $(this).parent().attr("data-value");
            system.confirm("", {title: "删除提示"}, function (index) {
                system.post("/metaDataTree/" + delId, {type: 2}, function (data) {
                    if (data.code == "200") {
                        system.tip("删除成功", 1);
                        metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                        //重新加载树形结构
                        metaMain.initTree();
                    } else {
                        system.tip("删除失败，请重试！", 0)
                    }
                })
            }, function (index) {
            })
        })

        //修改操作
        $("#" + metaMain.cons.tableId).LPClickDelegate(".update", function () {
            var updId = $(this).parent().attr("data-value");
            metaMain.saveDomain(updId);
        })//修改操作


        //更改状态
        $("#" + metaMain.cons.tableId).LPClickDelegate(".state", function () {
            var detailId = $(this).parent().attr("data-value");
            var params = {};
            params["type"] = 3;
            system.post("/sys/area/" + detailId + "/state/1", params, function (data) {
                if (data.code == "200") {
                    metaMain.initDomainTable();
                    system.tip('修改成功!', 1);
                } else {
                    system.tip('操作失败，请刷新后重试!', 0);
                }
            });
        })

        $("#addMetaData").click(function () {
            metaMain.saveDomain();
        })

        $("#setDB").click(function(){
            alert(1);
        })
        $("#reloadDB").click(function(){

            system.confirm("重新抽取将清空原有数据", {title: "是否抽取数据",btn:[ '立即抽取', '考虑下' ]}, function (index) {
                if(!metaMain.clickTreeId){
                    alert("请选择元数据节点");
                    return  ;
                }
                //判断是否是数据库节点
               var  node=system.cache[metaMain.clickTreeId];

                if(node.connModelCode!="M_REL_DB"){
                    alert("请选择元数据节点");
                    return ;
                }
                console.log(node)
                system.post("/etl/loadTable", {type: 1, nodeId: node.id}, function (data) {
                    if (data.code == "200") {
                        system.tip("加载成功", 1);

                    } else {
                        system.tip("加载失败", 0)
                    }
                })
            }, function (index) {
            })
        })
    },
    /**
     * 删除元数据管理
     * @param targetId
     */
    delRelation:function(targetId) {
        var delId = targetId;
        var sourceId = $("#meta_id").val();
        system.confirm("", {title: "删除提示"}, function (index) {
            system.post("/delMetaRelation", {type: 1, sourceId: sourceId, targetIds: delId}, function (data) {
                if (data.code == "200") {
                    system.tip("删除成功", 1);
                    metaMain.initRelactionTable({sourceId: sourceId});

                } else {
                    system.tip("删除失败，请重试！", 0)
                }
            })
        }, function (index) {
        })
    },
    /**
     * 加载地区信息管理 属性结构
     */
    initTree: function () {
        var setting = {
            data: {
                key: {
                    title: "t"
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
            if (!system.isBlank(treeNode)) {
                $("#mId").val(treeNode.id);
                //metaMain.initMenu(treeNode.id);
            }
          /*  if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
                $.fn.zTree.getZTreeObj("treeDemo").cancelSelectedNode();
                showRMenu("root", event.clientX, event.clientY);
            } else if (treeNode && !treeNode.noR) {
                $.fn.zTree.getZTreeObj("treeDemo").selectNode(treeNode);
                showRMenu("node", event.clientX, event.clientY);
            }*/
        }

        function onBodyMouseDown(event) {
            if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length > 0)) {
                $("#rMenu").css({"visibility": "hidden"});
            }
        }


        function beforeClick(treeId, treeNode, clickFlag) {
            console.log("[beforeClick ]" + treeNode.name);
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
            if (1 == clickFlag) {
                //metaMain.initArea(main.areaData[treeNode.id]);
                metaMain.clickTreeId = treeNode.id;
                console.log(metaMain.clickTreeId);
                //判断是否含有url，含有则 进行加载
                metaMain.initDomainTable({pid:treeNode.id});


                var domain = system.cache[metaMain.clickTreeId];
                if (!system.isBlank(domain.url)) {

                    $(".layui-tab-content .layui-tab-item").each(function () {
                        $(this).removeClass("layui-show")
                    })
                    $("#iframeUrl").parent().addClass("layui-show");
                    $("#iframeUrl").attr("src", domain.url)
                    $("#tagName").html(domain.name)
                } else {
                    $("#nav-1").addClass("layui-show");
                    $("#nav-2").removeClass("layui-show");
                    if (!system.isBlank(domain)) {
                        $("#code_id").html(domain.code);
                        $("#name_id").html(domain.name);
                        $("#type_id").html(domain.type);
                        $("#intro_id").html(domain.intro);
                        $("#idt_id").html(domain.idt);
                        $("#tagName").html(domain.name);

                    }
                }
            }
        }

        var nodes = new Array();
        system.post("/metaDataTree", {lptype: 4, rows: 10000}, function (data) {
            for (var i in data.result.dataList) {
                var domain = data.result.dataList[i];
                //bak area数据
                system.cache[domain.id] = domain;
                var node = {};
                node["id"] = domain.id + "";
                node["pId"] = domain.pid + "";
                node["name"] = domain.name + "";
                node["code"] = domain.code + "";
                node["t"] = domain.name + "";
                node["open"] = false;
                if ("0" == domain.pcode) {
                    node["open"] = true;
                }
                if (domain.icon == "03") {
                    node["icon"] = "/systemsite/assets/static/images/db.png";
                }
                //表目录
                else if (domain.icon == "04") {
                    node["icon"] = "/systemsite/assets/static/images/tb_box.png";
                }
                //表
                else if (domain.icon == "05") {
                    node["icon"] = "/systemsite/assets/static/images/tb.png";
                }  //视图
                else if (domain.icon == "06") {
                    node["icon"] = "/systemsite/assets/static/images/st.png";
                } //视图
                else if (domain.icon == "07") {
                    node["icon"] = "/systemsite/assets/static/images/st_list.png";
                } else if (domain.icon == "08") {
                    node["icon"] = "/systemsite/assets/static/images/field.png";
                } else if (!system.isBlank(domain.icon)) {
                    node["icon"] = domain.icon;
                }
                nodes.push(node);
            }
            metaMain.clickTreeId = "";
            // zNodes=zNodes.concat(nodes)
            console.log("------------")
            console.log(nodes)
            $.fn.zTree.init($("#treeDemo"), setting, nodes);
            $("#load_area").hide();
        })
    },

    /**
     * 选择新建模型类型
     */
    ckModelTree: function () {
        layer.open({
            skin: "lp-skin-fir",
            content: "<div id='lp'>" + $('#tkCkMeta').html() + "</div>",
            title: "选择模型",
            area: ["500px", "450px"],
            btn: ['确定'],
            yes: function (index) {
                var zTreeObj = $.fn.zTree.getZTreeObj("treeModelSet");  //ztree的Id  zTreeId
                var checkedNodes = zTreeObj.getCheckedNodes();
                if (checkedNodes.length == 0) {
                    alert("请选择模型");
                    return;
                }
                var node = system.cache[checkedNodes[0].id];
                $("#modelName").val(node.name);
                $("#modelId").val(node.id);
                $("#icon").val(node.icon);
                $("#connCode").val(node.code);
                // $("#p_type").val(node.type);
                console.log(node);
                layer.close(index);

            },
            success: function () {
                metaMain.initTreeAuto();
                console.log(123)
                // $("#roleId").val(detailId);
            }
        });
    },
    /**
     * 初始化元数据信息
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
                {key :'name',name : '元数据名称'},
                {key :'code',name : '元数据编码',sort:'code'},
                // {key :'pcode',name : '上级编码',sort:'pcode'},

                {key :'OP',name : '操作',formatters:function(domain){
                    var itemObj=$('<span data-value="'+domain.id+'"></span>');
                    if(domain.state==1){
                        itemObj.append('<a title="删除" class="del" href="javascript:;" data-value="'+domain.code+'" > <i class="layui-icon">&#xe640;</i> </a>')
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
            var curNum=$("#"+metaMain.cons.tablePageId+" .current").attr("data-value");
            params['page']=system.isBlank(curNum)?1:curNum;
        }
        params['lptype']=4;
        $("#"+metaMain.cons.tableId).LPTable("/metaDataTree",params,option);


    },
    /**
     * 加载树形权限
     * @param menuIds
     */
    initTreeAuto: function () {
        function beforeCheck(treeId, treeNode) {
            console.debug(" beforeCheck " + treeNode.name);
            return (treeNode.doCheck !== false);
        }

        function onCheck(e, treeId, treeNode) {
            console.debug(" onCheck" + treeNode.name);
        }

        function checkNode(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeModelSet");
            type = e.data.type;
            if (type == "checkAllTrue") {
                zTree.checkAllNodes(true);
            } else if (type == "checkAllFalse") {
                zTree.checkAllNodes(false);
            } else if ("submitRoleMenu" == type) {//提交role配置的men
                var arr = zTree.getCheckedNodes();
                console.debug(arr)
            } else {

            }
        }

        function setAutoTrigger(e) {
            var zTree = $.fn.zTree.getZTreeObj("treeModelSet");
            zTree.setting.check.autoCheckTrigger = $("#autoCallbackTrigger").attr("checked");
            $("#autoCheckTriggerValue").html(zTree.setting.check.autoCheckTrigger ? "true" : "false");
        }

        var setting = {
            view: {
                selectedMulti: false,
                showIcon: false,
                showLine: true//是否显示节点之间的连线
            },
            //单选框|radioType:"level", 每一层可以选择一个
            check: {
                chkStyle: "radio",
                radioType: "all",
                enable: true,
                // chkboxType:  { "Y": "", "N": "" }//不关联
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            callback: {
                beforeCheck: beforeCheck,
                onCheck: onCheck
            }
        };
        var nodes = new Array();
        system.post("/metaDataTree", {lptype: 4, type: 10, rows: 5000}, function (data) {
            for (var i in data.result.dataList) {
                var domain = data.result.dataList[i];
                //bak area数据
                system.cache[domain.id] = domain;
                var node = {};
                node["id"] = domain.id + "";
                node["pId"] = domain.pid + "";
                node["name"] = domain.name + "";
                node["t"] = domain.name + "";
                node["open"] = false;
                if ("0" == domain.pcode) {
                    node["open"] = true;
                }
                if (domain.icon == "03") {
                    node["icon"] = "/systemsite/assets/static/images/db.png";
                }
                //表目录
                else if (domain.icon == "04") {
                    node["icon"] = "/systemsite/assets/static/images/tb_box.png";
                }
                //表
                else if (domain.icon == "05") {
                    node["icon"] = "/systemsite/assets/static/images/tb.png";
                }  //视图
                else if (domain.icon == "06") {
                    node["icon"] = "/systemsite/assets/static/images/st.png";
                } //视图
                else if (domain.icon == "07") {
                    node["icon"] = "/systemsite/assets/static/images/st_list.png";
                } else if (domain.icon == "08") {
                    node["icon"] = "/systemsite/assets/static/images/field.png";
                } else if (!system.isBlank(domain.icon)) {
                    node["icon"] = domain.icon;
                }
                nodes.push(node);
            }
            metaMain.clickTreeId = "";
            $.fn.zTree.init($("#treeModelSet"), setting, nodes);
        })


    },
    /**
     * 初始化地区信息
     */
    initDomainTable: function (params) {
        var option = {
            async: true,//action请求是否异步，true为为异步请求【默认为true异步请求】
            pageFlay: true,//是否分页，默认为true 进行分页；为false则不进行分页
            //【浏览器缓存】是否需要缓存  会缓存到system.cache[""]
            cache: true,
            //缓存的key值，取值方法 system.cache["id"]
            cacheKey: "code",
            //控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
            table: {thStyle: "text-align:left;white-space: nowrap;cursor:pointer", tdStyle: "text-align:left;"},
            colModel: [
                {key: 'NO.', name: '序号'},
                {key: 'name', name: '元数据名称'},
                {key: 'code', name: '元数据编码', sort: 'code'},
                // {key :'pcode',name : '上级编码',sort:'pcode'},

                {
                    key: 'OP', name: '操作', formatters: function (domain) {
                    var itemObj = $('<span data-value="' + domain.id + '"></span>');
                    if (domain.state == 1) {
                        itemObj.append('<a title="删除" class="del" href="javascript:;" data-value="' + domain.code + '" > <i class="layui-icon">&#xe640;</i> </a>')
                    }
                    itemObj.append('<a  title="编辑" class="update"  data-value="' + domain.code + '" href="javascript:;"> <i class="layui-icon">&#xe642;</i> </a>');
                    return "无";
                }
                }
            ]

        };

        if (system.isBlank(params)) {
            params = {};
        }
        if (system.isBlank(params['page'])) {
            //获取当前页数
            var curNum = $("#" + metaMain.cons.tablePageId + " .current").attr("data-value");
            params['page'] = system.isBlank(curNum) ? 1 : curNum;
        }
        params['type'] = 4;
        $("#" + metaMain.cons.tableId).LPTable("/metaDataTree", params, option);


    },
    checkModel: function (code) {
        system.open("<div id='lp'>" + $('#tkAddMeta').html() + "</div>", {
            title: system.isBlank(code) ? "新增元数据信息" : "修改元数据信息",
            area: ["730px", "350px"]
        }, function (layern, index) {
            layui.use(['form', 'jquery'], function () {
                var form = layui.form;
                setTimeout(function () {
                    console.log(metaMain.clickTreeId);
                    //重新渲染

                    var areaObj = {};
                    //新增操作
                    if (system.isBlank(code)) {
                        //点击了行政区划管理
                        if (metaMain.clickTreeId) {
                            var obj = system.cache[metaMain.clickTreeId];
                            console.log(obj);
                            areaObj = {pid: obj.id, parentName: obj.name}
                        } else {
                            areaObj = {pid: "0", parentName: "一级等级"}
                        }
                    } else {
                        areaObj = system.cache[code];

                    }
                    form.render();
                    form.val("addFilter", areaObj);

                    /******************自定义验证规则*************/
                    form.verify({
                        name: function (value) {
                            if (system.isBlank(value)) {
                                return '请输入地区名称';
                            }
                        }
                    });

                    /***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
                    form.on('submit(addFilterSubmit)', function (data) {
                        var params = data.field;
                        if (system.isBlank(code)) {
                            params["lptype"] = 1;
                            // params["name"]="zs";
                            system.post("/metaDataTree", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('新增成功!', 1);
                                    metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                                    //重新加载树形结构
                                    metaMain.initTree();
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }
                        //修改操作
                        else {
                            params["lptype"] = 3;
                            system.post("/metaDataTree", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('修改成功!', 1);
                                    metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                                    //重新加载树形结构
                                    metaMain.initTree();
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }

                        //阻止提交表单
                        return false;
                    })
                }, 200)

            })
        });
    },

    updateRelationModel: function (code) {
        system.open("<div id='lp'>" + $('#tkAddRelationMeta').html() + "</div>", {
            title: system.isBlank(code) ? "维护元数据信息关系" : "维护元数据信息关系",
            area: ["930px", "750px"]
        }, function (layern, index) {
            layui.use(['form', 'jquery'], function () {
                var form = layui.form;
                setTimeout(function () {
                    //初始化选中的元数据
                    metaMain.initMetaTable();

                   var  clickMetaDomain= system.cache[metaMain.clickTreeId];
                   if(clickMetaDomain){
                       //初始化 需要维护的关系
                       $("#meta_code").val(clickMetaDomain.code);
                       $("#meta_name").val(clickMetaDomain.name);
                       $("#meta_id").val(clickMetaDomain.id);
                       metaMain.initRelactionTable({sourceId:clickMetaDomain.id});
                   }
                    console.log(metaMain.clickTreeId);
                    //重新渲染

                    var areaObj = {};
                    //新增操作
                    if (system.isBlank(code)) {
                        //点击了行政区划管理
                        if (metaMain.clickTreeId) {
                            var obj = system.cache[metaMain.clickTreeId];
                            console.log(obj);
                            areaObj = {pid: obj.id, parentName: obj.name}
                        } else {
                            areaObj = {pid: "0", parentName: "一级等级"}
                        }
                    } else {
                        areaObj = system.cache[code];

                    }
                    form.render();
                    form.val("addFilter", areaObj);

                    /******************自定义验证规则*************/
                    form.verify({
                        name: function (value) {
                            if (system.isBlank(value)) {
                                return '请输入地区名称';
                            }
                        }
                    });

                    /***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
                    form.on('submit(addFilterSubmit)', function (data) {
                        var params = data.field;
                        if (system.isBlank(code)) {
                            params["lptype"] = 1;
                            // params["name"]="zs";
                            system.post("/metaDataTree", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('新增成功!', 1);
                                    metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                                    //重新加载树形结构
                                    metaMain.initTree();
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }
                        //修改操作
                        else {
                            params["lptype"] = 3;
                            system.post("/metaDataTree", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('修改成功!', 1);
                                    metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                                    //重新加载树形结构
                                    // metaMain.initTree();
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }

                        //阻止提交表单
                        return false;
                    })
                }, 200)

            })
        });
    },
    // 维护关系选择  列表
    initMetaTable: function (params) {
        var option = {
            async: true,//action请求是否异步，true为为异步请求【默认为true异步请求】
            pageFlay: true,//是否分页，默认为true 进行分页；为false则不进行分页
            //【浏览器缓存】是否需要缓存  会缓存到system.cache[""]
            cache: true,
            //缓存的key值，取值方法 system.cache["id"]
            cacheKey: "code",
            //控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
            table: {thStyle: "text-align:left;white-space: nowrap;cursor:pointer", tdStyle: "text-align:left;"},
            colModel: [
                {key: 'id', name: 'checkbox'},
                {key: 'code', name: '元数据编码', sort: 'code'},
                {key: 'name', name: '元数据名称'},

                {
                    key: 'OP', name: '上下文路径', formatters: function (domain) {
                     return "无";
                }
                }
            ]

        };

        if (system.isBlank(params)) {
            params = {};
        }
        if (system.isBlank(params['page'])) {
            //获取当前页数
            var curNum = $("#metaTable .current").attr("data-value");
            params['page'] = system.isBlank(curNum) ? 1 : curNum;
        }
        params['lptype'] = 4;
        params['rows'] = 7;
        $("#metaTable").LPTable("/metaDataTree", params, option);


    },
    // 维护关系  列表
    initRelactionTable: function (params) {
        var option = {
            async: true,//action请求是否异步，true为为异步请求【默认为true异步请求】
            pageFlay: false,//是否分页，默认为true 进行分页；为false则不进行分页
            //【浏览器缓存】是否需要缓存  会缓存到system.cache[""]
            cache: false,
            //缓存的key值，取值方法 system.cache["id"]
            cacheKey: "code",
            //控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
            table: {thStyle: "text-align:left;white-space: nowrap;cursor:pointer", tdStyle: "text-align:left;"},
            colModel: [
                {key: 'NO.', name: '序号'},
                {key: 'code', name: '元数据编码', sort: 'code'},
                {key: 'name', name: '元数据名称'},
                // {key :'pcode',name : '上级编码',sort:'pcode'},

                {
                    key: 'OP', name: '操作', formatters: function (domain) {
                    var itemObj = $('<span data-value="' + domain.id + '"></span>');
                        itemObj.append('<a title="删除"  href="javascript:;" onclick=metaMain.delRelation("'+domain.targetId+'") > <i class="layui-icon">&#xe640;</i> </a>')
                    return itemObj;
                }
                }
            ]

        };

        if (system.isBlank(params)) {
            params = {};
        }
        if (system.isBlank(params['page'])) {
            //获取当前页数
            var curNum = $("#relactionTable .current").attr("data-value");
            params['page'] = system.isBlank(curNum) ? 1 : curNum;
        }
        params['lptype'] = 4;
        params['rows'] = 6;
        $("#relactionTable").LPTable("/metaRelations", params, option);


    },

    relactionSubmit:function(){
        var  arrIds= $("#metaTable").LPTableCheckedIds();
        var fromId=$("#meta_id").val();
        var params={};
        if(arrIds.length==0) {
            alert("请选择元数据");
            return;
        }
        params['targetIds']=arrIds.join(",");
        params['sourceId']=fromId;
        params['type']=1;
        //新增操作
        system.post("/metaRelation",params,function(data){
            console.log(data);
            if(data.code=="200"){
                metaMain.initRelactionTable({sourceId:fromId});
                system.tip("新增成功",1);
            }
        })
        console.log(arrIds);
        console.log(fromId);
    },

    /**
     * code为则为新增操作，有值则为修改操作
     * 新增/修改 实体类
     */
    saveDomain: function (code) {
        system.open("<div id='lp'>" + $('#tkAddMeta').html() + "</div>", {
            title: system.isBlank(code) ? "新增元数据信息" : "修改元数据信息",
            area: ["730px", "350px"]
        }, function (layern, index) {
            layui.use(['form', 'jquery'], function () {
                var form = layui.form;
                setTimeout(function () {
                    console.log(metaMain.clickTreeId);
                    //点击节点父节点
                    $("#p_id").val(metaMain.clickTreeId);
                    //重新渲染
                    var areaObj = {};
                    //新增操作
                    if (system.isBlank(code)) {
                        //点击了行政区划管理
                        if (metaMain.clickTreeId) {
                            var obj = system.cache[metaMain.clickTreeId];
                            console.log(obj);
                            areaObj = {pid: obj.id, parentName: obj.name}
                        } else {
                            areaObj = {pid: "0", parentName: "一级等级"}
                        }
                    } else {
                        areaObj = system.cache[code];

                    }
                    form.render();
                    form.val("addFilter", areaObj);

                    /******************自定义验证规则*************/
                    form.verify({
                        name: function (value) {
                            if (system.isBlank(value)) {
                                return '请输入地区名称';
                            }
                        }
                    });

                    /***********************监听提交操作【1、获取用户填写信息 2、组装信息 3、提交ajax请求 4、关闭弹框】*********************/
                    form.on('submit(addFilterSubmit)', function (data) {
                        var params = data.field;
                        if (system.isBlank(code)) {
                            params["lptype"] = 1;
                            console.log(params);
                            // params["name"]="zs";
                            system.post("/metaDataTree", params, function (data) {
                                if (data.code == "200") {
                                    layer.close(index);
                                    system.tip('新增成功!', 1);
                                    metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                                    //重新加载树形结构
                                    metaMain.initTree();
                                } else {
                                    system.tip('操作失败，请刷新后重试!', 0);
                                }
                            });
                        }
                        /*  //修改操作
                          else {
                              params["lptype"] = 3;
                              system.post("/metaDataTree", params, function (data) {
                                  if (data.code == "200") {
                                      layer.close(index);
                                      system.tip('修改成功!', 1);
                                      metaMain.initDomainTable({pid: system.isBlank(metaMain.clickTreeId) ? "0" : metaMain.clickTreeId});
                                      //重新加载树形结构
                                      metaMain.initTree();
                                  } else {
                                      system.tip('操作失败，请刷新后重试!', 0);
                                  }
                              });
                          }*/

                        //阻止提交表单
                        return false;
                    })
                }, 200)

            })
        });
    }
}
layui.use(['laydate', 'jquery', 'form'], function () {
    var $ = layui.jquery;
    var form = layui.form;

    //初始化表格数据
    metaMain.initDomainTable({pid: "0"});
    //绑定监听类方法
    metaMain.listenFun();
    metaMain.initTree();


});
