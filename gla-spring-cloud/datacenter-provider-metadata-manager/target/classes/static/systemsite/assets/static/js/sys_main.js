/**
 * 首页操作相关
 * @type {{initDomainTable: Function}}
 */
$(function(){
	// sysMain.initLeftMenu("0");
})
var sysMain={
	initLeftMenu:function(menuId){
		system.post("/system/perm/getMenuById",{id:menuId},function(data){
            //初始化 左侧菜单
            for(var i in data.result){
                var domain=data.result[i]; //获得一级菜单选项|如系统管理，此模块不显示
                //菜单类型为5的不显示：如果是数据维度的菜单则不展示
                if("5"==domain.type||domain.type>9){
                    continue;
                }

                /**----------title大模块信息-1 级菜单content详细信息--循环第一层目录--------------**/
                for(var m in domain.children){
                    var child=domain.children[m];

                    //li 一级目录
                    var ulP=$('<li class=""></li>');

					//定义菜单图标
                     var clas=system.isBlank(child.icon) ? "layui-icon-circle" : child.icon;

                     var liFirst=' <a href="javascript:;">' +
                         '<i class="layui-icon  '+clas+'"></i>' +
                         '<cite>'+child.name+'</cite>' +
                         '<i class="iconfont nav_right"></i></a>';
                     ulP.append(liFirst);

                    //加载二级菜单
                    // var childSec=$('<ul></ul>');
                    var childFirst=$('<ul class="sub-menu" style="display: none;"></ul>');
                    for(var n in child.children){
                        var child1=child.children[n];
						//定义第二级 图标 【左侧】
                        var claSec=system.isBlank(child1.icon) ? "layui-icon-right" : child1.icon;
                        var hrefSec=system.isBlank(child1.url) ? "#" : child1.url;

					   var liC=$('<li> </li>');

					   //组装a标签内容
					   var aSec=$('<a _href="'+hrefSec+'"> </a>');
					   aSec.append('<i class="layui-icon  '+claSec+'"></i>' +
                           '<cite>'+child1.name+'</cite>');
					   //添加右方下级菜单
                        if(child1.children.length>0){
                            aSec.append('<i class="iconfont nav_right">&#xe697;</i>');
                        }
					   liC.append(aSec);

                        var childThird=$('<ul class="sub-menu"></ul>');

                        for(var j in child1.children){
                            var child2=child1.children[j];

                            childThird.append('<li><a _href="/system/nav/demo/2">' +
                                '<i class="iconfont"></i>' +
                                '<cite>'+child2.name+'</cite></a></li>');

                        }

                        if(child1.children.length>0){
                            liC.append(childThird);
                        }
                        //添加二级分类内容
                        childFirst.append(liC);

                    }
                    ulP.append(childFirst)    ;

                    $("#nav").append(ulP);
                }
            }

		})
	}
}