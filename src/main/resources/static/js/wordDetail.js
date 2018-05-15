/**
 * 操作wordDetail页面
 */


//$(document).ready(function(){
//	/**
//	 * 从参数中取word_id
//	 */
//	alert();
//	var url = decodeURI(location.search);
//	if(url.indexOf("word_id=")==-1){
//		return;
//	}
//	var word_id = url.slice(url.search(/\=/)+1);
//	
//	//查询example
// 	$.ajax({
//		type:"get",
//		url:"/interLearn/word/queryDetailById",
//		data:word_id,
//		success:function(result){
//			console.log(result.wordname);
//			var example = jsonarrayToStr(result);
//			layer.prompt({
//	    		  formType: 2,
//	    		  value: example,
//	    		  title: '查看例句',
//	    		  area: ['800px', '350px'] //自定义文本域宽高
//	    		}, function(value, index, elem){
//	    			$.ajax({
//	    				type:"get",
//	    				url:"/interLearn/word/updateExample",
//	    				data:value,
//	    				success:function(){
//	    					layer.msg("修改成功");
//	    				},
//	    				error:function(){
//	    					layer.msg("修改失败，请联系相关人员");
//	    				}
//	    			});
//	    		  layer.close(index);
//	    		});
//		},
//		error:function(){
//			layer.msg("查询失败，请联系相关人员");
//		}
//	});
//});