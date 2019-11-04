/**
 * system-site.js 用于后台站点应用的js；
 * 便于区分业务，便于升级开发
 */
if (!Array.prototype.indexOf)
{
    Array.prototype.indexOf = function(elt /*, from*/)
    {
        var len = this.length >>> 0;
        var from = Number(arguments[1]) || 0;
        from = (from < 0)
            ? Math.ceil(from)
            : Math.floor(from);
        if (from < 0)
            from += len;
        for (; from < len; from++)
        {
            if (from in this &&
                this[from] === elt)
                return from;
        }
        return -1;
    };
}


/**
 *
 * 所有的公用方法在此处定义  【全局方法】
 */
var system = {
    cache:{},//缓存字段，用于保存用户请求的数据
    MenuMap:{},
    authMap:{},
    userName:"",//用户登录名称
    userAccount:"",
    systemName:"",
    /***********分页常量**************/
    nowPage:0,//当前页
    PagesLen:3,//总页数
    PageNum:7,//分页链接接数(5个)
    /*************分页常量END****************/
    normalLogin: 2,//0:微信登录 其他: 用户名登录
    timer:null, //定时器
    /**
     * 处理字段
     * @param obj 要处理的字段
     * @param repMsg 如果为空要返回的字段 r
     * @returns {*}
     */
    dealBlank:function(obj,repMsg){
        if(typeof obj=="number"&&obj==0){    //如果是0则返回0
            return obj;
        }
        if(obj==undefined||obj==""||obj==null||"undefined"==obj){
            /* console.log("repMsg:repMsg==undefined")
             console.log(repMsg)
             console.log(repMsg==undefined?"":repMsg)*/
            return repMsg==undefined?"":repMsg;
        }
        return obj;
    },
    isNum: function (num) {
        num = num.replace("-", "");
        num = num.replace(".", "");
        //var reg=new RegExp("^([1-9]\d*\.?\d*)|(0\.\d*[1-9])$");
        if (/^\d+$/.test(num)) {
            return true;
        } else {
            return false;
        }

    },
    /**
     * 保存实体类 通用方法
     * @param formId
     */
    saveDomain:function(formId,loadType){
        loadType=loadType==false ? false:true;//解决新窗口打开问题[指定async可以新窗口打开]
        //验证是否为空
        if(system.isBlank(formId)){
            alert("formId should not null");
            return ;
        }
        //form id 根据id获取
        if(formId.indexOf("#")==-1){
            formId="#"+formId;
        }
        system.post($(formId).attr("action"),$(formId).serialize(),function(data){
            if("200"==data.code){
                system.tip(data.msg,1);
            }else{
                system.tip(data.msg,0);
            }
        },loadType)

    },
    saveDomainCall:function(formId,callback){
        //验证是否为空
        if(system.isBlank(formId)){
            alert("formId should not null");
            return ;
        }
        //form id 根据id获取
        if(formId.indexOf("#")==-1){
            formId="#"+formId;
        }
        console.log($(formId).attr("action"));
        system.post($(formId).attr("action"),$(formId).serialize(),callback)
    },
    //系统退出
    logout: function () {
        $.ajax({
            type: "POST",
            url: get_root+"/system/user/logOut.action",
            dataType: "json",
            success: function (data) {
                if(data.code==200){
                    //  tips(data.msg) ;
                    window.location.href=get_root+"/";
                }else{
                    //  tips(data.msg) ;
                }
            }
        });
    },
    /**
     * 是否是手机访问
     * @returns {boolean}
     * true：是 false 否
     */
    isPhone:function(){
        var vers = navigator.userAgent;
        if (vers.indexOf("Mobile") > "-1") {
            return true
        }
        return false;
    },
    isBlank:function(str){
        if(str==null||str==undefined||$.trim(str)==""){
            return true;
        }
        return false;
    },
    formatNum:function(num,size){
        if(num==undefined||num==null||num==""){
            return "/";
        }
        return num.toFixed(size);
    },
    format:function(val,msg){
        if(val==undefined||val==null||val==""){
            return msg==""?"--":msg;
        }
        return val;
    },

    /**
     * 提示信息类：
     * @param msg 提示内容
     * @param type 1正确提示 0 失败提示
     */
    tip:function(msg,type){
        layer.msg(msg,{
            time: 3000 //2s后自动关闭
        })
    },
    /**
     *
     * @param tip 提示信息
     * @param params params:{skin:"lp-skin-fir",btn : [ '立即删除', '考虑下' ]}
     * @param callBack1
     * @param callBack2
     */
    confirm:function(tip,params,callBack1,callBack2){
        var t=params['title'];
        if(t.indexOf("增加")>-1||t.indexOf("新增")>-1){
            params['title']='<i class="layui-icon">&#xe608;</i>&nbsp;'+t;
        }else if(t.indexOf("修改")>-1){
            params['title']='<i class="layui-icon">&#xe642;</i>&nbsp;'+t;
        }else if(t.indexOf("列表")>-1){
            params['title']='<i class="layui-icon">&#xe60a;</i>&nbsp;'+t;
        }else if(t.indexOf("查询")>-1){
            params['title']='<i class="layui-icon">&#xe615;</i>&nbsp;'+t;
        }else if(t.indexOf("设置")>-1){
            params['title']='<i class="layui-icon">&#xe620;</i>&nbsp;'+t;
        }else if(t.indexOf("删除")>-1){
            params['title']='<i class="layui-icon">&#xe640;</i>&nbsp;'+t;
        }

        layer.confirm(system.isBlank(tip)?'确认要删除吗？':tip, {
            btn :system.isBlank(params["btn"])?[ '立即删除', '考虑下' ]:params["btn"],//按钮
            title: system.isBlank(params['title'])?false:params['title'],
            skin:"lp-skin-fir"
        }, function(index) {
            console.log("正在删除");
            layer.close(index);
            callBack1 && callBack1.call(this, index);
            //此处请求后台程序，下方是成功后的前台处理……
        },callBack2);
    },
    /**
     * layer通用弹框
     * @param url 请求url地址
     * @param params 参数同layer参数 {title:"",type:1}  type=2 iframe加载
     * @param callback，回调函数function (layern, index){}
     */
    open:function(url,params,callback) {

        if(url == null || url == '') {
            layer.msg("url 不合法");
            return;
        };

        console.log(params['title']);
        if(!system.isBlank(params['title'])){
            var t=params['title'];
            if(t.indexOf("增加")>-1||t.indexOf("新增")>-1){
                params['title']='<i class="layui-icon">&#xe608;</i>&nbsp;'+t;
            }else if(t.indexOf("修改")>-1){
                params['title']='<i class="layui-icon">&#xe642;</i>&nbsp;'+t;
            }else if(t.indexOf("列表")>-1){
                params['title']='<i class="layui-icon">&#xe60a;</i>&nbsp;'+t;
            }else if(t.indexOf("查询")>-1){
                params['title']='<i class="layui-icon">&#xe615;</i>&nbsp;'+t;
            }else if(t.indexOf("设置")>-1){
                params['title']='<i class="layui-icon">&#xe620;</i>&nbsp;'+t;
            }
        }
        //弹框通用方法
        layer.open({
            skin: system.isBlank(params['skin'])?'lp-skin-fir':params['skin'],
            //title: '<i class="layui-icon">&#xe642;</i>新增人员',
            title: system.isBlank(params['title'])?false:params['title'],
            type: system.isBlank(params['type'])?1:params['type'],
            maxmin: system.isBlank(params['maxmin'])?false:params['maxmin'],
            shadeClose: system.isBlank(params['shadeClose'])?false:params['shadeClose'],
            shade: system.isBlank(params['shade'])?0.4:params['shade'],
            area: system.isBlank(params['area'])?['500px', '450px']:params['area'],
            content: system.isBlank(url)?"no data...":url,
            //content: "<div id='lp'>" + $('#tkAddUser').html() + "</div>", //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响：
            //可设置为隐藏状态，在结合vue初始化数据，获取当前div情况
            success:callback
        })
    },

    /**
     * post请求
     * @param action
     * @param paramData{type:"1"},请求需要请求type类型：传入数字即可:分别对应增删改查操作；默认POST请求
     * @param callback
     * @param async
     */
    post:function(action,paramData,callback,async){
        console.log("请求地址参数↓");
        console.log(action);
        console.log(paramData);
        console.log(paramData['type']);
        //console.log("↑End↑");

        //增删改查
        var typeEnum={1:"POST",2:"DELETE",3:"PUT",4:"GET"};

        //发送ajax类型
        var ajaxType=paramData['type']==undefined?"POST":typeEnum[paramData['type']];
        //如传到后台的参数也需为type属性，此时发送ajaxtype用lptype代替
        if(!system.isBlank(paramData['lptype'])){
            ajaxType=typeEnum[paramData['lptype']];
        }/*else{
            delete paramData.type;
        }*/
        //移除
        async=async==false ? false:true;//解决新窗口打开问题[指定async可以新窗口打开]
        $.ajax({
            dataType : "json",
            type:ajaxType,
            url:action,
            data:paramData,
            cache:false,
            async:async,
            beforeSend:function(XHR){
            },
            complete:function(XHR,TS){
            },
            success:callback,
            error: function (error) {
                console.info(error)
                console.info(error.responseText)
                var msg=error.message==""?"请求错误，请重试":error.message;
                if(!system.isBlank(error.responseText)&&error.responseText.indexOf("账号未登录")>-1){
                    if(confirm("请求错误, 请刷新页面后重试")){
                        //cons.sysHref(cons.sysWorkDeskUrl);
                        parent.location.reload();
                    }
                }else{
                    alert("操作异常，请重试");
                }
                 /*   if(confirm("会话已过期, 请重新登录")){
                        cons.sysHref(cons.sysWorkDeskUrl);
                    }*/
            }
        })
    },
    /**
     * 解决重复ent提交问题
     */
    submitNum:0,
    //提交表单    根据ID
    submitById:function(submitId){

        $(document).keypress(function(e) {
            // 回车键事件
            if(e.which == 13) {
                system.submitNum=system.submitNum+1;
                if(1==system.submitNum){
                    setTimeout(function(){
                        $("#"+submitId).click();
                        system.submitNum=0;
                    },500)
                }
            }
        });

    },
    /**
     * 重置form的表单：
     * @param formId form表单id
     * @param restBtnId  点击的重置按钮的id
     */
    resetById:function(formId,restBtnId){
        if(!system.isBlank(formId)&&system.isBlank(restBtnId)){
            formId=formId.indexOf("#")>0? formId:"#"+formId;
            $(formId)[0].reset();
        }
        //如果绑定按钮不为空
        if(!system.isBlank(restBtnId)){
            restBtnId=restBtnId.indexOf("#")>0? restBtnId:"#"+restBtnId;
            $(restBtnId).click(function(){
                system.resetById(formId);
            })

        }

    },
    //获得权限菜单的值     注意：请页面元素加载完毕后，再使用此方法$(function(){ 运行})
    getMenuValue:function(key){
        log.debug("-----初始化KEYMENU菜单---:")
        for (var m in main.menuData){
            var domain=main.menuData[m];
            system.MenuMap[domain.menKeyword]=domain;
        }
        return "";
    },

    //根据name名称获得checbox被选中的值 【逗号分隔】
    getCheckboxValues:function(checkBoxName){
        var checkValues="";
        $("input:checkbox[name='"+checkBoxName+"']:checked").each(function () {
            checkValues+=","+$(this).val();
        })
        checkValues=checkValues==""?"":checkValues.substr(1);
        return checkValues;
    },
    //根据name名称获得Radio被选中的值 【无则返回空】
    getRadioValues:function(radioName){
        var radioValues="";
        $("input:radio[name='"+radioName+"']:checked").each(function () {
            radioValues=$(this).val();
        })
        return radioValues;
    },
    /***
     * 进行全选操作
     * @param checkedName被选择 checkedname b
     * @param msgId 提示信息的id
     */
    toCheckedBox:function(checkedName,msgId){
        log.debug("进行全选操作")
        console.debug(msgId)
        //如果是全选操作
        if(!system.isBlank(msgId)){
            if("全选"== $.trim($("#"+msgId).text())){
                $("#"+msgId).text("全不选");
                $("input:checkbox[name='"+checkedName+"']").each(function () {
                    $(this).prop("checked", true)
                });
            }else if("全不选"== $.trim($("#"+msgId).text())){
                $("#"+msgId).text("全选");
                $("input:checkbox[name='"+checkedName+"']").each(function () {
                    $(this).prop("checked", false)
                });
            }
        } else {
            $("input:checkbox[name='"+checkedName+"']").each(function () {
                $(this).prop("checked", true)
            });
        }
    }  ,
    toCheckedBoxByName:function(checkedName,this_){
        console.log("全选操作")
        var checkedFlay=$(this_).is(':checked');
        //如果是全选操作
        $("input:checkbox[name='"+checkedName+"']").each(function () {
            $(this).prop("checked",checkedFlay)
        });
    }  ,
    toCheckedBoxByValue:function(checkedName,values){
        $("input:checkbox[name='"+checkedName+"']").each(function () {
            if(values.indexOf($(this).val())>-1){
                $(this).prop("checked", true)
            }else{
                $(this).prop("checked",false);
            }
        });
    }  ,
    //鼠标移入输入框【onFocus】，清除输入框默认值  onBlur="clearTextcity(this)
    cleanInputValue: function (field) {
        if (field.defaultValue == field.value) {
            field.value = '';
        }else if (field.value == '') field.value = field.defaultValue;
    },
    /***
     *    加密
     */
    encUrl:function(url){
        console.debug("发送请求链接")
        console.debug(url)
        var preUrl="?url=";  //前缀
        var decBase=new Base64();
        return preUrl+decBase.encode(url);;
    } ,
    preUrl:"?url=", //前缀
    //解密
    decUrl:function(url){
        var base=new Base64();
        url=base.decode(url.replace(system.preUrl,""));
        return url ;
    },
    //转化为16进制 加密  【原】
    decToHex: function (str) {
        var res = [];
        for (var i = 0; i < str.length; i++) {
            res[i] = ("00" + str.charCodeAt(i).toString(16)).slice(-4);
        }
        return "\\u" + res.join("\\u");;
    },
    //16进制转化为文字 解密  如entName,即可获得相应的文字
    /**
     *
     * @param vhref   window.location.search
     * @param name 如：companyname r
     * @return {*}
     * 样例：system.getQueryStringV(window.location.search, "companyname");
     */
    getQueryStringV: function (vhref, name) {
        //TODO 向下兼容 处理没有经过加密的数据
        if(vhref.indexOf(system.preUrl)>-1){
            var base=new Base64();
            vhref="?"+base.decode(vhref.replace(system.preUrl,""));
        }
        // log.debug("解析后的链接是:")
        // log.debug(vhref)
        // 如果链接没有参数，或者链接中不存在我们要获取的参数，直接返回空
        if (vhref.indexOf("?") == -1
            || vhref.indexOf(name + '=') == -1) {
            return '';
        }
        // 获取链接中参数部分
        var queryString = vhref.substring(vhref.indexOf("?") + 1);
        // 分离参数对 ?key=value&key2=value2
        var parameters = queryString.split("&");
        var pos, paraName, paraValue;
        for (var i = 0; i < parameters.length; i++) {
            // 获取等号位置
            pos = parameters[i].indexOf('=');
            if (pos == -1) {
                continue;
            }
            // 获取name 和 value
            paraName = parameters[i].substring(0, pos);
            paraValue = parameters[i].substring(pos + 1);

            if (paraName == name) {
                return unescape(paraValue.replace(/\\/g, "%"));
            }
        }
        return '';
    },

    //分页工具
    /**
     * 如点击 3 ，返回 1,5
     * @param p  当前的页数，即点击的页数
     * @return {string}返回 点击页数的前后页数
     * 分页start-end逗号隔开
     */
    getPagestartEnd:function(p){
        nowPage=this.nowPage= parseInt(p);
        PagesLen=parseInt(this.PagesLen);
        PageNum=this.PageNum;
        //内容变换  //TODO
        //分页链接变换
        var PageNum_2=PageNum%2==0?Math.ceil(PageNum/2)+1:Math.ceil(PageNum/2) ;//定义中间页
        var PageNum_3=PageNum%2==0?Math.ceil(PageNum/2):Math.ceil(PageNum/2)+1
        var strC="",startPage,endPage;
        if (PageNum>=PagesLen) {startPage=1;endPage=PagesLen}
        else if (nowPage<PageNum_2){
            startPage=1;endPage=PagesLen>PageNum?PageNum:PagesLen}//首页
        else {
            startPage=nowPage+PageNum_3-1>PagesLen?PagesLen-PageNum+1: nowPage-PageNum_2+1;var t=startPage+PageNum-1;endPage=t>PagesLen?PagesLen-1:t}
        //TODO 链接部分
        return (parseInt(startPage))+","+(parseInt(endPage)) ;
    } ,
    /**
     * 设置Cookie信息
     * @param cname cook名称
     * @param cvaluecookie值
     * @param expireDay 过期天数
     */
    setCookie:function(cname,cvalue,expireDay){
        var d=new Date();
        d.setTime(d.getTime()+(expireDay*24*60*60*1000)) ;
        var expire="expires="+ d.toUTCString();
        document.cookie=cname+"="+cvalue+";"+expire+";path=/";
    },
    /**
     * 根据名称取得cookie的value
     * @param cname值z
     * @returns {string}
     */
    getCookie:function(cname){
        var name=cname+"=";
        var ca=document.cookie.split(";");
        for(var i=0;i<ca.length;i++){
            var c=ca[i];
            while(c.charAt(0)==' ')c= c.substring(1);
            if(c.indexOf(name)!=-1)return c.substring(name.length, c.length);
        }
        return "";
    },
    //分页样式
    /**
     * 分页
     * 使用说明：：1）在页面中引入page.css样式，
     * 2）加载完数据运行loadPageLis方法 参照 mon_yd_more.js文件
     * @param num 页面
     * @param funName 点击li运行的函数
     * @param ULID lis内容填充到ul指定id下
     */
    loadPageLis: function (num,funName,ULID) {
        num = parseInt(num);
        var startEnd = system.getPagestartEnd(num);
        console.debug(startEnd)
        var Lis = "";

        var start = '<li title="尾页" onclick='+funName+'(1)><p class="prev" ></p></li> <li title="上一页"  onclick='+funName+'(' + (num - 1) + ')><p class="prev_p"></p></li> ';
        var begin = parseInt(startEnd.split(",")[0]);
        var end = parseInt(startEnd.split(",")[1]);
        for (var i = begin; i < end + 1; i++) {
            if (i == num) {
                Lis += '<li class="active" onclick='+funName+'(' + i + ')><p >' + i + '</p></li>';
            } else {
                Lis += '<li onclick='+funName+'(' + i + ')><p >' + i + '</p></li>';
            }
        }
        var endLis = '<li title="下一页" onclick='+funName+'(' + (num + 1) + ') ><p class="next_n" ></p></li> <li title="尾页" onclick='+funName+'(' + PagesLen + ')><p class="next" ></p></li>'
        if (0 == end) {   //
            $("#"+ULID).html("");
        } else {
            $("#"+ULID).html(start + Lis + endLis);
        }

    },
    /**
     * 获取指定格式的时间
     * @param time
     * @returns {string}
     */
    getCurrentTime:function(time){
        var date = new Date();
        this.year = date.getFullYear();
        this.month = date.getMonth() + 1;
        this.date = date.getDate();
        this.day = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六")[date.getDay()];
        this.hour = date.getHours() < 10 ?"0"+ date.getHours() : date.getHours();
        this.minute = date.getMinutes() < 10 ?"0"+ date.getMinutes() : date.getMinutes();
        this.second = date.getSeconds() < 10 ?"0"+ date.getSeconds() : date.getSeconds();
        if("time"==time){
            return this.hour +":"+ this.minute +":"+ this.second;
        }
    },
    fn:{
        login:function(){
            return "window.location.href='"+get_root+"/system/user/toLogin.action'";
        }
        ,personal:function(){
            return "window.location.href='"+get_root+"/system/user/index.action'";
        },point:function(){
            return "window.location.href='"+get_root+"/point/index.action'";
        },pay:function(){
            return "window.location.href='"+get_root+"/share/pay.action'";
        },pays:function(param){
            return "window.location.href='"+get_root+"/share/pays.action"+param+"'";
        }
    },
    /**
     *  $("#bd").mousedown(function(e){.....})
     * 获得鼠标的位置：
     * @param e
     * @returns {{x: number, y: number}}
     */
    getMousePos: function (e) {
        var posx = 0;
        var posy = 0;
        if (!e) var e = window.event;
        if (e.pageX || e.pageY) {
            posx = e.pageX;
            posy = e.pageY;
        }
        else if (e.clientX || e.clientY) {
            posx = e.clientX + document.body.scrollLeft
                + document.documentElement.scrollLeft;
            posy = e.clientY + document.body.scrollTop
                + document.documentElement.scrollTop;
        }
        return {
            x: posx,
            y: posy
        }
    } ,
    /**
     *  取窗口最高高度
     * @returns {number}
     */
    getclienMaxHeight:function()
    {
        var clientHeight=0;
        var max1=document.body.clientHeight;
        var max2=document.documentElement.clientHeight;
        if(max1){
            clientHeight=max1;
        }
        if(max2){
            clientHeight=max2>clientHeight?max2:clientHeight;
        }

        return clientHeight;
    },
    /**
     * 根据时间格式字符串获得当前时间
     * @param pattern  yyyy年MM月dd日 hh时mm分ss秒
     * @return {*} 时间字符串
     */
    getCurrentDate:function(pattern,foreDay){
        var now=new Date();
        if(!system.isBlank(foreDay)){
            now=new Date(now.getTime()-foreDay* 24 * 3600 * 1000)
        }
        var str=pattern;
        var month=parseInt(now.getMonth().toString())+1;
        str=str.replace(/yyyy|YYYY/,now.getFullYear())   ;//年
        str=str.replace(/MM/,month>9?month.toString():"0"+month.toString());//月
        str=str.replace(/M/g,month.toString());//月
        str=str.replace(/dd|DD/,now.getDate()>9?now.getDate().toString():"0"+now.getDate().toString());//月
        str=str.replace(/D|d/g,now.getDate().toString());//日
        str=str.replace(/hh|HH/,now.getHours()>9?now.getHours().toString():"0"+now.getHours().toString());//时
        str=str.replace(/h|H/g,now.getHours().toString());//时
        str=str.replace(/mm/,now.getMinutes()>9?now.getMinutes().toString():"0"+now.getMinutes().toString());//fen
        str=str.replace(/m/g,now.getMinutes().toString());//fen
        str=str.replace(/ss/,now.getSeconds()>9?now.getSeconds().toString():"0"+now.getSeconds().toString());//miao
        str=str.replace(/s/g,now.getSeconds().toString());//miao
        return str;
    } ,

    /**
     * 定义访问的action
     */
    action:{
        getUnitList:{
            intro:"获取单位列表",
            url:"/system/unit/list.action"
        }, getMenuById:{
            intro:"根据ID获取菜单详细信息",
            url:"/system/user/getMenuById.action"
        },
        getMenuList:{
            intro:"获取菜单列表",
            url:"/system/menu/getMenuList.action"
        },
        getPermissionList:{
            intro:"获取元素权限列表",
            url:"/system/permission/getPermissionList.action"
        },
        getRoleList:{
            intro:"获取角色列表",
            url:"/system/role/getRoleList.action"
        },
        getUserList:{
            intro:"获取用户列表",
            url:"/system/user/getUserList.action"
        },
        initSessionAuth:{
            intro:"更新用户权限配置",
            url:"/system/permission/initSessionAuth.action"
        },
        updateKV:{
            intro:"更新KV对应值",
            url:"/system/kv/updateKV.action"
        },
        getRoleListByKid:{
            intro:"获取Role的数据权限",
            url:"/system/kv/getRoleListByKid.action"
        },
        getLogList:{
            intro:"获取日志列表",
            url:"/system/log/getLogList.action"
        },
        getDictList:{
            intro:"获取数据字典列表",
            url:"/system/dict/getDictList.action"
        },
        getSurveyorList:{
            intro:"获取验船师列表",
            url:"/system/surveyor/getSurveyorList.action"
        },
        getRuleList:{
            intro:"获取安全策略列表",
            url:"/system/rule/getRuleList.action"
        },
        getCompanyUserList:{
            intro:"获取企业用户的数据",
            url:"/comp/user/getCompUserList.action"
        },
        getUserInfo:{
            intro:"获取人员编码",
            url:"/system/surveyor/getUserInfo.action"
        },

        getOrgPagerList:{
            intro:"获取检验机构列表-页面",
            url:"/system/org/getOrgPagerList.action"
        },
        exportSurveyor:{
            intro:"人员调出",
            url:"/system/surveyor/exportSurveyor.action"
        },
        getCompUserTreeInfo:{
            intro:"获取企业组织树",
            url:"/comp/user/getTreeInfo.action"
        },
        getCOMPUserList:{
            intro:"系统管理员查询所有企业人员信息",
            url:"/comp/user/getUserList.action"
        },
        getCompanyTypeList:{
            intro:"系统管理员查询所有企业人员信息",
            url:"/comp/type/getTypeList.action"
        },
        getCompanyList:{
            intro:"查询企业信息",
            url:"/comp/getCompList.action"
        },
        getPersonTree:{
            intro:"获取检验机构树",
            url:"/org/getTreeInfo.action"
        },
        getPersonList:{
            intro:"获取内部人员信息列表",
            url:"/person/getPersonList.action"
        },
        getOrgList:{
            intro:"获取机构信息列表",
            url:"/org/getOrgList.action"
        },
        getAppList:{
            intro:"获取应用系统信息列表",
            url:"/app/getAppList.action"
        },
        getOrgInfoList:{
            intro:"获取检验机构树",
            url:"/org/getOrgInfoList.action"
        }
    },

    handPic : function(temId,htmlId){
        // $('#'+htmlId).html(template(temId, data));

        $.fn.swBanner=function(options){
            var defaults={
                animateTime:500,
                delayTime:5000
            }
            var setting=$.extend({},defaults,options);

            return this.each(function(){
                $obj=$(this);
                var o=setting.animateTime;
                var d=setting.delayTime;
                var $oban=$obj.find(".banList li");
                var _len=$oban.length;
                var $nav=$obj.find(".fomW a");
                var _index=0;
                //图片轮换
                function showImg(n){
                    $oban.eq(n).addClass("active").siblings().removeClass("active");
                    $nav.eq(n).addClass("current").siblings().removeClass("current");
                }
                //自动播放
                function player(){
                    timer=setInterval(function(){
                        var _index=$obj.find(".fomW").find("a.current").index();
                        showImg((_index+1)%_len);
                    },d)
                }
                //
                $nav.click(function(){
                    if(!($oban.is(":animated"))){
                        _index=$(this).index();
                        showImg(_index);
                    }
                });
                //
                $oban.hover(function(){
                    //clearInterval(timer);

                },function(){
                    //player();

                });
                player();
            });
        }
    },
    cleanPic : function(){
        clearInterval(timer);
    },
    load : function(url){

        var url = get_root+"/index/main?loadUrl="+url+"&hideType=1";
        var index = layer.open({
            type: 2,
            area: ['100%', '100%'],
            skin:'jumpLayer',
            content : url,
            title : ""
        })
        layer.full(index);
    }
}
