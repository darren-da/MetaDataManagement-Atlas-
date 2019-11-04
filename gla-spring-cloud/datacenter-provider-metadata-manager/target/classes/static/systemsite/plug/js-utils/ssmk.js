///开始定义全局内容
var fouce_li_num = -1;// /默认没有选择任何下拉内容
var width_ = 90;// 这里设置的是搜索框的宽度，目的为了与下面的列表宽度相同
var li_color = "#F8F8F8";// 默认的下拉背景颜色
var li_color_ = "#fff";// 当下拉选项获取焦点后背景颜色
$(function() {
   runOneSearch("ssxlmk","keyWord","key","foraspcn");
   runOneSearch("ssxlmk1","keyWord1","key","foraspcn1");
});
/**
 *
 * @param spanId    绑定span的Id  ：ssxlmk1
 * @param keyWordId 输入框的Id  ：keyWord1
 * @param keyName  输入框的Name值   key1
 * @param foraspcnId 样式quantum_pedigree.css
 */
function runOneSearch(spanId,keyWordId,keyName,foraspcnId){
    $("input[name="+keyName+"]").keyup(
        function(event) {
            var keycode = event.keyCode;
            //TODO   如下代码 只有按空格才进行查询 请求平凡 速度过慢
            /*if (delkeycode(keycode))
                return; */
            if ("32,40,38,13".indexOf(keycode)==-1)
                return;
            keyCodeEffect(keycode,this,keyWordId,keyName,foraspcnId)

        });
    showHide(spanId,foraspcnId);

}
function keyCodeEffect(keycode,that,keyWordId,keyValue,foraspcnId){
    var key_ = $(that).val();// 获取搜索值
    var top_ = $(that).offset().top;// 获搜索框的顶部位移
    var left_ = $(that).offset().left;// 获取搜索框的左边位移
    if (keycode == 13) {// enter search
        if (fouce_li_num >= 0) {
            if("keyWord"==keyWordId){ //文字添加到指定位置 TODO keyWord3特殊
                $(that).val(
                    $.trim($(
                        "#"+foraspcnId+" >li:eq(" + fouce_li_num
                        + ")").text()));
                console.log("执行查询")
                $("#search_submit").click();
            }else{  //TODO 其他的添加到输入框
                $(that).val(
                    $.trim($(
                        "#"+foraspcnId+" >li:eq(" + fouce_li_num
                            + ")").text()));
            }
            fouce_li_num = -1;
        } else {
            // ///当没有选中下拉表内容时 则提交form 这里可以自定义提交你的搜索
        }
        $("#"+foraspcnId).hide();
    } else if (keycode == 40) {// 单击键盘向下按键
        console.log("0000"+foraspcnId)
        fouce_li_num++;
        var li_allnum = $("#"+foraspcnId+" >li").css("background-color",
            li_color).length;
        if (fouce_li_num >= li_allnum && li_allnum != 0) {// 当下拉选择不为空时
            fouce_li_num = 0;
        } else if (li_allnum == 0) {
            fouce_li_num--;
            return;
        }
        $("#"+foraspcnId+" >li:eq(" + fouce_li_num + ")").css(
            "background-color", li_color_);
    } else if (keycode == 38) {// 点击键盘向上按键
        fouce_li_num--;
        var li_allnum = $("#"+foraspcnId+" >li").css("background-color",
            li_color).length;
        if (fouce_li_num < 0 && li_allnum != 0) {// 当下拉选择不为空时
            fouce_li_num = li_allnum - 1;
        } else if (li_allnum == 0) {
            fouce_li_num++;
            return;
        }
        $("#"+foraspcnId+" >li:eq(" + fouce_li_num + ")").css(
            "background-color", li_color_);
    }else{
        fouce_li_num = -1;
        $("#"+foraspcnId).empty();
        var arrTemp=new Array();
        console.log("其他的")
        if($.trim($("#"+keyWordId).val()).length!=0){
            searchGSNames($("#"+keyWordId).val(),keyValue,foraspcnId);
        }
        // 赋值完毕后进行显示
        $("#"+foraspcnId).show().css({
            "top" : top_ + 30,
            "left" : left_ +40
        });

    }

}
/**
 * @param spanId 显示隐藏Id
 */
function showHide(spanId,foraspcnId){
    // 当焦点从搜索框内离开则，隐藏层
    $("#"+spanId).click(function() {
        $("#"+foraspcnId).hide();
    });
    // /创建隐藏的div，用来显示搜索下的内容 ssxlmk1
    $("#"+spanId).append("<div id='"+foraspcnId+"'></div>");
    $("#"+foraspcnId).css({
        "width" : "" + width_ + "%"
    });// 这里设置列下拉层的样式，默认为隐藏的
}
// 定义非开始运行函数
function delkeycode(keycode) {// 去除了不必要的按键反应，当比如删除，f1 f2等按键时，则返回
	var array = new Array();
	array = [  16, 19, 20, 27, 33, 34, 35, 36, 45, 46, 91, 112, 113, 114,
			115, 116, 117, 118, 119, 120, 121, 122, 123, 145, 192 ];
	for (i = 0; i < array.length; i++) {
		if (keycode == array[i]) {
			return true;
			break;
		}
	}
	return false;
}

/**
 * @param key 搜索关键字
 * @param keyValue 选中时填充的值
 */
function searchGSNames(key,keyValue,foraspcnId) {
    var stype=$(".s-active").attr("data-type");
    stype=system.isBlank(stype)?"":stype;
	$.post(get_root + '/index/s.action', {
		"key" : $.trim(key),
         page:1,
         type:stype,
         pagesize:10
	},// ajax 的post不能提交中文提交，在动作页面进行获取后需要解码，注意字符格式，然后搜索后返回
	function(data) {// 返回格式是json数据，至少是个数组也可自定义，然后再这里进行操作
		var dataMap = eval("(" + data + ")");
        data_array=eval("(" + dataMap.result + ")");
        console.log("ajax----");
        var num=data_array.length>10 ? 10:data_array.length;
        var lis="";
		for (i = 0; i <num; i++) {
			// 这里进行数据附加 返回数据格式为 关键词数组
            if("foraspcn1"==foraspcnId){
                width_=94;
            }
            lis+="<li style='width:" + width_ + "%;'>" + data_array[i].NAME+ "</li>";
        }
        $("#"+foraspcnId).html(lis)
		$("#"+foraspcnId+" >li").mouseover(function() {
			$(this).css("background-color", li_color_);
		});
		$("#"+foraspcnId+" >li").mouseout(function() {
			$(this).css("background-color", li_color);
		});
		$("#"+foraspcnId+" >li").click(function() {
            if("key"==keyValue){  //正对key处理，当鼠标单击时，填充到输入框
                $("input[name="+keyValue+"]").val($.trim($(this).text()));
                $(this).parent().hide();
                return;
            }
            var entName=$.trim($(this).text());
            if(entName==""){
                return;
            }
            $("#single_list").prepend("<li id='GS_"+entName+"'><p style='color:#24506B'>"+entName+"</p><span onclick=credit.removeLi('GS_"+entName+"')></span></li>")
            $("input[name="+keyValue+"]").val("请输入关键字");
            removeLi();//X标志
			$(this).parent().hide();
		});
	});
};
