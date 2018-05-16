/**
 * 操作wordDetail页面
 */


//$(document).ready(function(){
//layui.use(['form', 'layedit', 'laydate'], function(){
//		var form = layui.form
//		,layer = layui.layer
//		,layedit = layui.layedit
//		,laydate = layui.laydate;
//		
//		//表单初始赋值
//		form.val('example', {
//			"word_translate": [[${word.word_translate}]]
//			,"word_describe": [[${word.word_describe}]]
//			,"word_example_en1": [[${word.word_example_en1}]]
//			,"word_example_cn1": [[${word.word_example_cn1}]]
//			,"word_example_en2": [[${word.word_example_en2}]]
//			,"word_example_cn2": [[${word.word_example_cn2}]]
//			,"word_example_en3": [[${word.word_example_en3}]]
//			,"word_example_cn3": [[${word.word_example_cn3}]]
//			,"word_id":[[${word.word_id}]]
//			,"wordname":[[${word.wordname}]]
//		});
//	});
//	
//	function doSubmit(){
//		var word={};
//		word["word_translate"]=$("[name='word_translate']").val();
//		word["word_describe"]=$("[name='word_describe']").val();
//		word["word_example_en1"]=$("[name='word_example_en1']").val();
//		word["word_example_cn1"]=$("[name='word_example_cn1']").val();
//		word["word_example_en2"]=$("[name='word_example_en2']").val();
//		word["word_example_cn2"]=$("[name='word_example_cn2']").val();
//		word["word_example_en3"]=$("[name='word_example_en3']").val();
//		word["word_example_cn3"]=$("[name='word_example_cn3']").val();
//		word["word_id"]=$("[name='word_id']").val();
//		word["wordname"]=$("[name='wordname']").val();
//		$.ajax({
//			type:"get",
//			url:"/interLearn/word/updateWord",
//			data:word,
//			success:function(data){
//				alert("修改成功");
//			}
//		});
//	}