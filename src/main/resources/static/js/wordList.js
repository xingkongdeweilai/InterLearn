/**
 * 操作wordList页面
 */

/**
 * 分页
 */
//layui.use('laypage', function(){
//  var laypage = layui.laypage;
//  
//  //执行一个laypage实例
//  laypage.render({
//    elem: 'test3' //注意，这里的 test1 是 ID，不用加 # 号
//    ,count: 50 //数据总数，从服务端得到
//  });
//});

/**
 * 操作表格
 */
layui.use(['table','laypage'], function(){
  var table = layui.table
  ,laypage = layui.laypage;
  
  //渲染表格
  table.render({
	    elem: '#test3'
	    ,url: '/interLearn/word/wordList' //数据接口
	    ,page: {
	    	 layout: ['prev', 'page', 'next', 'skip', 'count']
	    } //开启分页
	    ,initSort:{
	    	field:'wordname'
	    	,type:'asc'
	    }//初始排序
	    ,response:{
	    	statusCode:99
	    }
	    ,cols: [[ //表头
	       {type:'checkbox'}
	      ,{field:'word_id', width:50,minWidth:50,title:"序号",type:'numbers'}
	      ,{field:'wordname', width:120, sort: true, edit: 'text',title:"单词"}
	      ,{field:'word_describe',width:360,event: 'setDescribe', minWidth: 150,title:"描述"}
	      ,{field:'word_translate',width:360,event: 'setTranslate',title:"翻译"} 
	      ,{fixed: 'right', align:'center', toolbar: '#barDemo'}
	    ]]
	  });
  
//执行一个laypage实例
//  laypage.render({
//    elem: '#test3' //注意，这里的 test1 是 ID，不用加 # 号
//    ,count: [[${count}]] //数据总数，从服务端得到
//    ,layout: ['count', 'prev', 'page', 'next', 'skip','refresh'] //自定义分页布局
//  	,first: false //不显示首页
//    ,last: false //不显示尾页
//    ,jump:function(obj, first){
//        //obj包含了当前分页的所有参数，比如：
//        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
//        console.log(obj.limit); //得到每页显示的条数
//        
//        //首次不执行
//        if(!first){
//          //do something
//        }
//      }
//  });
  
  //监听单词单元格编辑
  table.on('edit(test3)', function(obj){
    var value = obj.value //得到修改后的值
    ,data = obj.data //得到所在行所有键值
    ,field = obj.field; //得到字段
    $.ajax({
		type:"get",
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
  table.on('tool(test3)', function(obj){
	  var data = obj.data //得到所在行所有键值
	  if(obj.event === 'detail'){
		$(location).attr('href', encodeURI('/interLearn/word/queryDetailById?word_id='+data.word_id));
    	//查询example
//        $.ajax({
//    		type:"get",
//    		url:"/interLearn/word/queryDetailById",
//    		data:data,
//    		success:function(result){
//    			console.log(result.wordname);
//    			var example = jsonarrayToStr(result);
//    			layer.prompt({
//    	    		  formType: 2,
//    	    		  value: example,
//    	    		  title: '查看例句',
//    	    		  area: ['800px', '350px'] //自定义文本域宽高
//    	    		}, function(value, index, elem){
//    	    			$.ajax({
//    	    				type:"get",
//    	    				url:"/interLearn/word/updateExample",
//    	    				data:value,
//    	    				success:function(){
//    	    					layer.msg("修改成功");
//    	    				},
//    	    				error:function(){
//    	    					layer.msg("修改失败，请联系相关人员");
//    	    				}
//    	    			});
//    	    		  layer.close(index);
//    	    		});
//    		},
//    		error:function(){
//    			layer.msg("查询失败，请联系相关人员");
//    		}
//    	});
    	
    } else if(obj.event === 'del'){
      layer.confirm('真的删除行么', function(index){
        obj.del();
        layer.close(index);
      });
    } else if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data));
    //监听描述单元格事件
    }else if(obj.event==='setDescribe'){
    	layer.prompt({
            formType: 2
            ,title: '编辑'+data.wordname+'的描述'
            ,value: data.word_describe
          }, function(value, index){
            layer.close(index);
            data.word_describe=value;
            $.ajax({
        		type:"get",
        		url:"/interLearn/word/updateWord",
        		data:data,
        		success:function(result){
        			layer.msg(result.data.wordname + ' 描述更改为：'+ value);
        		}
        	});
            //同步更新表格和缓存对应的值
            obj.update({
              word_describe: value
            });
          });
    //监听翻译单元格事件
    }else if(obj.event==='setTranslate'){
    	layer.prompt({
            formType: 2
            ,title: '编辑'+data.wordname+'的翻译'
            ,value: data.word_translate
          }, function(value, index){
            layer.close(index);
            data.word_translate=value;
            $.ajax({
        		type:"get",
        		url:"/interLearn/word/updateWord",
        		data:data,
        		success:function(result){
        			layer.msg(result.data.wordname + ' 翻译更改为：'+ value);
        		}
        	});
            //同步更新表格和缓存对应的值
            obj.update({
              word_translate: value
            });
          });
    }
  });
  
  var $ = layui.$, active = {
    getCheckData: function(){ //获取选中数据
      var checkStatus = table.checkStatus('test3')
      ,data = checkStatus.data;
      layer.alert(JSON.stringify(data));
    }
    ,getCheckLength: function(){ //获取选中数目
      var checkStatus = table.checkStatus('test3')
      ,data = checkStatus.data;
      layer.msg('选中了：'+ data.length + ' 个');
    }
    ,isAll: function(){ //验证是否全选
      var checkStatus = table.checkStatus('test3');
      layer.msg(checkStatus.isAll ? '全选': '未全选')
    }
    ,addNewWord: function(){//添加新单词
    	$(location).attr('href', encodeURI('/interLearn/word/queryDetailById?word_id=0'));
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

//json数组转换成字符串
function jsonarrayToStr(jsonarray){
	var result="";
	for(var i in jsonarray){
		result = result.concat(JSON.stringify(jsonarray[i]));
	}
	return result;
}