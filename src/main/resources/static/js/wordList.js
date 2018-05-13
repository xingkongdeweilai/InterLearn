/**
 * 操作wordList页面
 */


/**
 * 操作表格
 */
layui.use('table', function(){
  var table = layui.table;
  
  //渲染表格
  table.render({
	    elem: '#test3'
	    ,url: '/interLearn/word/wordList' //数据接口
	    ,page: true //开启分页
	    ,initSort:{
	    	field:'wordname'
	    	,type:'asc'
	    }
	    ,response:{
	    	statusCode:99
	    }
	    ,cols: [[ //表头
	       {type:'checkbox'}
	      ,{field:'word_id', width:50,minWidth:50, sort: true,title:"ID",type:'numbers'}
	      ,{field:'wordname', width:120, sort: true, edit: 'text',title:"单词"}
	      ,{field:'word_describe',width:360, minWidth: 150, edit: 'text',title:"描述"}
	      ,{field:'word_translate', edit: 'text',title:"翻译"} 
	      ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
	    ]]
	  });
  
  //监听单元格编辑
  table.on('edit(test3)', function(obj){
    var value = obj.value //得到修改后的值
    ,data = obj.data //得到所在行所有键值
    ,field = obj.field; //得到字段
    $.ajax({
		type:"post",
		url:"/interLearn/word/updateWord",
		data:data,
		success:function(data){
			layer.msg(field + ' 字段更改为：'+ value);
		}
	});
  });
  
  //监听表格复选框选择
  table.on('checkbox(test3)', function(obj){
    console.log(obj);
  });
//监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.id + ' 的查看操作');
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
  });
  
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据
      var checkStatus = table.checkStatus('idTest')
      ,data = checkStatus.data;
      layer.alert(JSON.stringify(data));
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus('idTest')
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus('idTest');
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
  };
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    active[type] ? active[type].call(this) : '';
  });
});

/**
 * 操作导航栏
 */
layui.use('element', function(){
	  var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
	  
	  //监听导航点击
	  element.on('nav(demo)', function(elem){
	    //console.log(elem)
	    layer.msg(elem.text());
	  });
});