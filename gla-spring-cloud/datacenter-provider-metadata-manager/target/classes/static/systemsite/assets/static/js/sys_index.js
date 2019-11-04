/**
 * 首页操作相关
 * @type {{initDomainTable: Function}}
 */
$(function(){
	console.log("init index....");
    sysIndex.initLeftMenu(0)
})

var sysIndex={
	initLeftMenu:function(menuId){
		system.post("/system/perm/getMenuById",{id:"7"},function(data){
			console.log("/---左侧菜单数据---/");
			console.log(data);
		 var iterms=$("#index-show");
		 for(var m  in data.result){

		     var domain=data.result[m];
             iterms.append(' <div class="layui-inline">\n' +
                 '        <img src="/systemsite/assets/static/images/flower.png" class="layui-circle">' +
                 '<a href="'+domain.url+'" style="cursor: pointer"> '+domain.name+'</a></div>');
         }

            //初始化 左侧菜单

		})
	}
}