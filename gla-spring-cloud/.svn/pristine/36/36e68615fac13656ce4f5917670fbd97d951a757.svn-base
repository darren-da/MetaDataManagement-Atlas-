var layIndex="";
//  readme: 适用于框架的后台快速开发-- 所有插件会以LP开头，便于查找提示以及避免插件命名重复 ;
(function($){
    /* 为什么使用严格模式:
     消除Javascript语法的一些不合理、不严谨之处，减少一些怪异行为;
     消除代码运行的一些不安全之处，保证代码运行的安全；
     提高编译器效率，增加运行速度；
     为未来新版本的Javascript做好铺垫。*/
    'use strict';
    /**
     * 【提示loading层】
     * 加载数据的loading 加载方法调用方法（默认左上角）
     * 使用方法：$("#id").LPshowLoading();
     * @param type  type为默认的加载方法，type=1可继续扩展
     * @constructor
     */
    $.fn.LPshowLoading=function(type){
        layIndex= layer.msg('努力中...', {icon: 16,shade: [0.1, '#f5f5f5'],scrollbar: false,offset: 'auto', time:10000}) ;
    };

    /**
     * 参照：jqGrid扩展
     * 参考网址：http://blog.mn886.net/jqGrid/
     *调用方法 ：$("#userTable").LPTable(get_root+system.action["getUserList"]["url"],params,options);
     *
     *colModel：详解-->
     * -------------------------------------------------------
     * key      :指定取实体类中的那个字段
     * name     ：表格的表头命名（如果为checkbox则为复选框）
     * width    ：宽度
     * style    :样式
     * formatter：function(cellvalue){ return "处理后的值" } 处理当前td值
     * formatterS：function(domainvalue){ return "处理后的值" } 处理实体类的值
     * ----------------------------------------
     *参考魔板:option
     *
     */

    /**
     * $("#commonBtn").LPTable(".clas","funName");
     * className :传递过来需要绑定的元素：如class传递过来 .className
     * callback:回调函数
     */
    $.fn.LPClickDelegate=function(className,callBack){
        var lpClickId=$(this).attr("id");//loadingID

        //$(document).off("click","#commonBtn .clas").delegate("#commonBtn .clas","click",function(){
        if(!system.isBlank(className)){
            lpClickId=lpClickId+"  " +className;
        }
        //console.log("绑定元素-->"+lpClickId)
        $(document).off("click","#"+lpClickId).delegate("#"+lpClickId,"click",callBack)
    },
        /**
         * 获取lptable 中选中checked的id值
         * $("#tableId").LPTableCheckedIds();
         * return 选中的数组ids
         */
        $.fn.LPTableCheckedIds=function(){
            var lpTableId=$(this).attr("id");//loadingID
            var idsCheckedArr=new Array();
            $("#"+lpTableId+" .layui-form-checked").each(function(){
                var idChecked=$(this).attr("data-id");
                if(!system.isBlank(idChecked)){
                    idsCheckedArr.push(idChecked);
                }
            })
            return idsCheckedArr;
        },

        /**
         *[table:样式为table table-bordered table-striped cf 则是带网格的table]
         * @param action 请求的 action
         * @param paramData  url链接参数 {cache:true、false}
         * @param options 指定返回对象
         * @constructor
         */
        $.fn.LPTable=function(action,paramData,options){

            var lpId=$(this).attr("id");//loadingID
            var boxName=lpId+"Checked";//loadingID
            var pageId=lpId+"Page";//分页div id
            var async=false==options["async"]?false:true
            var this_=this;
            $("#"+lpId).LPshowLoading(1);
            console.debug("/---查询参数---/");
            console.debug(action);
            console.debug(paramData);
            if(!system.isBlank(action)){
                system.post(action,paramData,function(data){
                    console.debug("/---插件返回数据如下---/");
                    console.debug(data);
                    if(!system.isBlank(layIndex)){
                        layer.close(layIndex);
                    }else{
                        //todo:
                        //layer.closeAll();
                    }
                    console.log("33325553")
                    console.log(paramData)
                    //定义页数
                    var page= system.isBlank(paramData["page"])?"0":paramData["page"];
                    //加载用户列表
                    options["colData"]=data.result.dataList;
                    console.log("33323")
                    console.log(paramData)
                    $(this).html('');
                    $("#"+lpId).html('');
                    /*******************组装title*******************************/
                    var lpTitle=$('<thead></thead>')
                    var lpTitleTR=$('<tr></tr>');
                    for(var t in options["colModel"]){
                        var domain=options["colModel"][t];
                        var  thTitle=$('<th></th>');
                        if("checkbox"==domain["name"]){
                            //thTitle.append('<input type="checkbox" onclick=system.toCheckedBoxByName("'+boxName+'",this)>');
                            thTitle.append('<div class="layui-unselect header layui-form-checkbox" id="'+boxName+'" name="'+boxName+'" lay-skin="primary"><i class="layui-icon"></i></div>');
                            /* thTitle.append('' +
                             ' <input type="checkbox" name="'+boxName+'" lay-skin="primary"  id="'+boxName+'">');*/
                        }else if("radio"==domain["name"]){
                            thTitle.append('<input type="radio" name="'+boxName+'">');
                        }else if(!system.isBlank(domain["sort"])){
                            var key=domain["sort"];
                            var lpsortParam=paramData["lpsort"];
                            //是否显示
                            var spanClass=!system.isBlank(lpsortParam)&&lpsortParam.indexOf(key)>-1?"":"lphide";
                            //var sortSpan=$('<span style="color: #ccc" class="lpsort '+spanClass+'"></span>');
                            var sortSpan=$('<span class="layui-table-sort layui-inline '+spanClass+'" value="'+key+'" lay-sort="asc"></span>');

                            //var sortAsc=$('<span class="fontawesome-sort-up" value="'+key+' ASC"></span>')    ;
                            var sortAsc=$('<i class="layui-edge layui-table-sort-asc" value="'+key+' ASC"></i>')    ;
                            //<span class="layui-table-sort layui-inline" lay-sort="asc"><i class="layui-edge layui-table-sort-asc"></i><i class="layui-edge layui-table-sort-desc"></i></span>
                            //   var sortDesc=$('<span class="fontawesome-sort-down lpclick" style=" margin-left: -9px; "  value="'+key+' DESC">');
                            var sortDesc=$('<i class="layui-edge layui-table-sort-desc" value="'+key+' DESC"></i>');
                            if(system.isBlank(spanClass)&&lpsortParam.indexOf("desc")>-1){
                                //sortAsc.addClass("lpclick");
                                //sortDesc.removeClass("lpclick");
                                sortSpan.attr("lay-sort","desc")
                            }
                            sortSpan.append(sortAsc,sortDesc);
                            thTitle.append(domain["name"]+"&nbsp;",sortSpan);
                            //thTitle.append(sortSpan);
                        }else{
                            thTitle.append(domain["name"]);
                        }
                        //加载宽度属性
                        if(!system.isBlank(domain["width"])){
                            thTitle.attr("width",domain["width"]);
                        }
                        if(!system.isBlank(domain["style"])){
                            thTitle.attr("style",domain["style"]);
                        }
                        //优先级比较高（标题样式）
                        if(!system.isBlank(domain["styleTh"])){
                            thTitle.attr("style",domain["styleTh"]);
                        }//如：单个标题样式为空，则判断全局样式是否为空，设置全局样式
                        else if(!system.isBlank(options["table"])&&!system.isBlank(options["table"]["thStyle"])){
                            thTitle.attr("style",options["table"]["thStyle"]);
                        }
                        lpTitleTR.append(thTitle);
                    }
                    lpTitle.append(lpTitleTR);
                    /*******************组装tbody*******************************/
                    var lpTbody=$('<tbody></tbody>');
                    for(var m in options["colData"]){

                        var domain=options["colData"][m];//实体记录
                        //是否保存缓存
                        if(!system.isBlank(options["cache"])&&true==options["cache"]){
                            system.cache[domain[options["cacheKey"]]]=domain;
                        }
                        var lpTbodyTR=$("<tr></tr>");
                        for(var n in options["colModel"]){
                            var colMap=options["colModel"][n];
                            var tdPrams=$("<td></td>");
                            if("checkbox"==colMap["name"]){
                                //tdPrams.append('<input type="checkbox" name="'+boxName+'" value="'+domain[colMap["key"]]+'">');

                                //tdPrams.append('<input type="checkbox" name="'+boxName+'" value="'+domain[colMap["key"]]+'">');
                                //tdPrams.append('<input type="checkbox"  lay-filter="choose" name="'+boxName+'" lay-skin="primary"  value="'+domain[colMap["key"]]+'">');
                                tdPrams.append('<div class="layui-unselect layui-form-checkbox" name="'+boxName+'" lay-skin="primary" data-id="'+domain[colMap["key"]]+'"><i class="layui-icon"></i></div>');

                            }else if("radio"==colMap["name"]){
                                tdPrams.append('<input type="radio" name="'+boxName+'" value="'+domain[colMap["key"]]+'">');
                            }
                            //序号
                            else if("NO."==colMap["key"]){
                                try{
                                    tdPrams.append(parseInt(m)+1);
                                }catch(e){

                                }
                            }
                            //操作 按钮
                            else if("OPT."==colMap["key"]){
                                if(!system.isBlank(colMap["formatters"])){
                                    var optMain=$('<div class="dropdown"></div>');
                                    //添加操作图标
                                    optMain.append('<div data-toggle="dropdown" aria-haspopup="false" aria-expanded="true"><span class="operation"></span></div> ');
                                    //定义功能按钮：UL
                                    var optBtn=$('<ul class="dropdown-menu dropdown-menu-opt" aria-labelledby="dLabel"></ul>');
                                    //UL 初始化li元素
                                    optBtn.append(colMap["formatters"](domain));
                                    optMain.append(optBtn);
                                    //操作 拼装
                                    tdPrams.append(optMain);
                                }
                            }
                            else{
                                //格式此列数据
                                if(!system.isBlank(colMap["formatter"])){
                                    tdPrams.append(colMap["formatter"](domain[colMap["key"]]));
                                }
                                //格式此列数据：传入参数是实体类
                                else if(!system.isBlank(colMap["formatters"])){
                                    tdPrams.append(colMap["formatters"](domain));
                                }else{
                                    tdPrams.append(domain[colMap["key"]]);
                                }
                            }
                            //获取样式属性
                            var domainStyle=options["colModel"][n];
                            //加载宽度属性
                            if(!system.isBlank(domainStyle["width"])){
                                tdPrams.attr("width",domainStyle["width"]);
                            }
                            if(!system.isBlank(domainStyle["style"])){
                                tdPrams.attr("style",domainStyle["style"]);
                            }
                            else if(!system.isBlank(options["table"])&&!system.isBlank(options["table"]["tdStyle"])){
                                tdPrams.attr("style",options["table"]["tdStyle"]);
                            }
                            // Tr添加一条td（循环添加）
                            lpTbodyTR.append(tdPrams);
                        }
                        lpTbody.append(lpTbodyTR);
                    }
                    //***************end加载数据************************//
                    //组装tfoot
                    var lpTfoot=$('<tfoot></tfoot>');
                    if(!system.isBlank(options["tfoot"])){
                        lpTfoot.append(options["tfoot"]);
                    };
                    $(this_).append(lpTitle,lpTbody,lpTfoot);



                    //--------------------------分页列表-------------------------------------/
                    var divPage=$('<div  class="page page-div"></div>');
                    var pageList=$('<div  id="'+pageId+'"></div>');

                    system.PagesLen = parseInt(data.result.pageCount);  //总页数
                    var pageArr = system.getPagestartEnd(parseInt(page)).split(",");  //起始终止页数

                    //var pageList = $("#user_page").html('');//&laquo;
                    if(parseInt(page)>1){
                        pageList.append('<a href="javascript:void(0)" style="color: #ccc;cursor: default;">共'+system.dealBlank(data.result.rowCount,0)+'条数据</a> ');
                        pageList.append('<a href="javascript:void(0)" title="第1页" data-value="1">首页</a></li> '); //第一页
                        pageList.append('<a href="javascript:void(0)" title="" data-value="'+(parseInt(page)-1)+'">上一页</a> '); //第一页
                    }else{
                        pageList.append('<a href="javascript:void(0)" style="color: #ccc;cursor: default;">共'+system.dealBlank(data.result.rowCount,0)+'条数据</a> ');
                        pageList.append('<a href="javascript:void(0)" title="第1页" style="color: #ccc;cursor: default;">首页</a> '); //第一页
                        pageList.append('<a href="javascript:void(0)" title="" style="color: #ccc;cursor: default;" >上一页</a> '); //第一页
                    }
                    for (var i = parseInt(pageArr[0]); i <= pageArr[1]; i++) {
                        var curr = i;
                        if (page == i) {
                            pageList.append('<span class="current"  data-value="' + curr + '">' + i + '</span> ');
                        } else {
                            pageList.append(' <a  class="num" href="javascript:void(0)" data-value="' + curr + '">' + i + '</a> ');
                        }
                    }
                    //&raquo;
                    if(parseInt(page)<system.PagesLen){
                        pageList.append('<a href="javascript:void(0)" title="下一页" data-value="' + (parseInt(page)+1) + '">下一页</a> ');
                        pageList.append('<a href="javascript:void(0)" title="第' + system.PagesLen + '页" data-value="' + system.PagesLen + '">尾页</a> ');
                    }else{
                        pageList.append('<a href="javascript:void(0)" title="下一页" style="color: #ccc;cursor: default;" >下一页</a></li> ');
                        pageList.append('<a href="javascript:void(0)"  style="color: #ccc;cursor: default;" title="第' + system.PagesLen + '页" >尾页</a> ');

                    }
                    //分页点击事件
                    divPage.append(pageList);
                    $(this_).parent().find(".page-div").remove();
                    if(system.PagesLen==0){
                        $(this_).after('<div style="text-align: center" class="page-div">暂无数据</div>');
                    }else{
                        //若分页数量不为0，则加载分页

                        //如pageFlay 为空或者为true则显示分页属性；
                        if(system.isBlank(options["pageFlay"])||true==options["pageFlay"]){
                            $(this_).after(divPage);
                        }
                    }
                    $("#"+pageId+ " a").click(function () {
                        var pageCurr=$(this).attr("data-value");
                        //如果data-value为空则不再进行分页查询
                        if(system.isBlank(pageCurr)){
                            return;
                        }
                         paramData["page"]=pageCurr;
                        console.log("3333")
                        console.log(paramData)
                        $("#"+lpId).LPTable(action,paramData,options);
                    });

                    $("#"+lpId+" th").click(function(){
                        if($(this).find("span").hasClass("layui-table-sort")){
                            if($(this).find("span").hasClass("lphide")){
                                //所有的都制成隐藏状态
                                $(".layui-table-sort").each(function(){
                                    $(this).addClass("lphide");
                                });
                                //当前点击可见
                                $(this).find("span").removeClass("lphide");
                            }else{
                                var changeSort=$(this).find("span").eq(0).attr("lay-sort")=="asc"?"desc":"asc";
                                $(this).find("span").eq(0).attr("lay-sort",changeSort);
                                //$(this).find(".lpclick").removeClass("lpclick").siblings().addClass("lpclick");
                            }
                            //paramData["lpsort"]=$(this).find(".lpclick").attr("value");
                            paramData["lpsort"]=$(this).find("span").eq(0).attr("value")+" "+$(this).find("span").eq(0).attr("lay-sort");;
                           console.log("1111")
                           console.log(paramData)
                            $("#"+lpId).LPTable(action,paramData,options);
                        }
                    })
                    console.log("45554")
                    console.log(paramData)
                    /******************************8******/
                    layui.use(["form"],function() {
                        var form = layui.form;
                        /* 渲染表单 */
                        form.render();
                        $("#"+lpId).LPClickDelegate(".layui-form-checkbox",function(){
                            var flay = $(this).hasClass("layui-form-checked");
                            if(boxName==$(this).attr("id")) {
                                $("#" + lpId + " .layui-form-checkbox").each(function () {
                                    if (flay) {
                                        $(this).removeClass("layui-form-checked");
                                    } else {
                                        $(this).addClass("layui-form-checked");
                                    }
                                });
                            }else{
                                if (flay) {
                                    $(this).removeClass("layui-form-checked");
                                } else {
                                    $(this).addClass("layui-form-checked");
                                }
                            }

                        })

                    })
                    /******************************8******/
                },async)

            }


        }


})(jQuery);
/**
 * LPTable魔板
 * @type {{cache: boolean, cacheKey: string, colModel: [{key:"",name:"",style:"",styleTh:""
 * sort:"",width:"",formatter/formatters:""}{}]}}
 *1、序号： key=NO.
 * 2、指定宽度 width
 * 3、格式数据formatter（单个值） formatters（多值，包含全部的实体类）
 * 4、指定style（标题和内容）样式：style:"text-align:left"
 * 5、指定标题样式：styleTh：相应的css控制 white-space: nowrap; 禁止换行
 * 6、指定key=OPT.  返回样例：formatters=<li><a href="javascript:void(0)"><span class="opera-layer-logo"><span class="icon-document-edit" style="color: #428bca; font-size: 17px" title="修改"></span></span>修改 </a></li>
 * 7、sort：排序字段，可支持点击排序
 */
var option= {
    tfoot:"",//表格的foot样式，传入相应的div即可
    async:true,//action请求是否异步，true为为异步请求【默认为true异步请求】
    pageFlay:true,//是否分页，默认为true 进行分页；为false则不进行分页
    //【浏览器缓存】是否需要缓存  会缓存到system.cache[""]
    cache:false,
    //缓存的key值，取值方法 system.cache["id"]
    cacheKey:"id",
    //控制全局table样式，td【thStyle】和th【tdStyle】；优先级低于单个表格设置的样式【低于colModel中style和styleTh的样式】
    table:{thStyle:"text-align:left;white-space: nowrap;cursor:pointer",tdStyle:"text-align:left;"},
    colModel : [
        {key :'personId',name:"checkbox",width : 55},
        {key :'personName',name : '姓名',sort:'PERSON_NAME',formatters:function(domainvalue){
            var personName=domainvalue.personManage=="1"?
                '<p style="background: red; color: white; border-radius: 10px;" title="系统管理员">'+domainvalue.personName+'</p>'
                : '<p>'+domainvalue.personName+'</p>';
            return personName;

        }},//,style:"background-color: red;font-size: 16px;"
        {key :'personAccount',name : '账号'},
        {key :'personSort',name : '排序'},
        {key :'personState',name : '是否验船师',formatter:function(cellvalue){
            var zt=cellvalue=="0"? "否":"是";
            return zt;
        }},
        {key :'personAccountState',name : '状态',formatter:function(cellvalue){
            var zt=cellvalue=="0"? "正常": (cellvalue=="1"?"已停用":"已注销");
            return zt;
        }},
        {key :'orgName',name : '所在单位'},
        {key :'personCreatedate',name : '创建时间'},
        {key :'usrState',name :'操作',formatters:function(domainvalue){
            //var zt=domainvalue=="-1"? "已删除": (cellvalue=="1"?"正常":"待审核");
            var upState=domainvalue.personAccountState=="0"? '<a href="javascript:void(0)" data-value="'+domainvalue.personId+'" onclick="PersonInfo.updateS(this,1)">停用&nbsp;&nbsp;</a>':
                '<a href="javascript:void(0)" data-value="'+domainvalue.personId+'" onclick="PersonInfo.updateS(this,0)">启用&nbsp;&nbsp;</a>';
            var manageS=domainvalue.personManage=="1"?'<a href="javascript:void(0)" data-value="'+domainvalue.personId+'"onclick="PersonInfo.setManage(this, 0)">取消管理员&nbsp;&nbsp;</a>':
                '<a href="javascript:void(0)" data-value="'+domainvalue.personId+'" onclick="PersonInfo.setManage(this, 1)">设为管理员&nbsp;&nbsp;</a>';
            var optBtn=upState +manageS
            //'<a href="#" onclick=PersonInfo.setManage("3fda62bb38c541cba8985db148a03bad", 1)>设为管理员&nbsp;&nbsp;</a>' +
            '<a href="javascript:void(0)" onclick=PersonInfo.account("3fda62bb38c541cba8985db148a03bad")>账号管理&nbsp;&nbsp;</a>' +
            '</td>';
            return optBtn;
        }}
    ]

};
var  options1={
    colModel : [
        {key :'id',name:"checkbox",index : 'id',width : 55},
        {key :'id',name : 'ID',width : 55},
        {key :'invdate',name : '入职时间',width : 90},
        {key :'name',name :'姓名',width : 100},
        {key :'amount',name : '账户余额',width : 80,align : "right"},
        {key :'tax',name:'邮箱',width : 80,align : "right"},
        {key :'note',name :'备注',width : 150,sortable : false}
    ],
    colData:[{id:"0",invdate:"2020年11月11日",name:"张三1",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"1",invdate:"2020年11月11日",name:"张三2",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"2",invdate:"2020年11月11日",name:"张三3",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"3",invdate:"2020年11月11日",name:"张三4",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"4",invdate:"2020年11月11日",name:"张三5",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"5",invdate:"2020年11月11日",name:"张三6",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"6",invdate:"2020年11月11日",name:"张三7",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"7",invdate:"2020年11月11日",name:"张三8",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"8",invdate:"2020年11月11日",name:"张三9",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."},
        {id:"9",invdate:"2020年11月11日",name:"张三10",amount:"188$",tax:"LPTable@limp.com","note":"这人很有钱..."}
    ]
};