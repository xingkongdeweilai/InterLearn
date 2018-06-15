/**
 * 注册页面验证
 */

// user
var username_Boolean = false;
var password_Boolean = false;
var rePassword_Boolean = false;
var eMail_Boolean = false;
var telephone_Boolean = false;
$('.reg_username').blur(function(){
	$('.username_hint').html("");
  if ((/^[a-zA-Z\u4E00-\u9FA5]{1}[0-9a-zA-Z\u4E00-\u9FA5]{2,9}$/).test($(".reg_username").val())){
    $('.username_hint').html("✔").css("color","green");
    username_Boolean = true;
  }else {
    $('.username_hint').html("用户名格式错误，长度为3-10位，支持大小写字母、汉字及数字，但不能以数字开头").css("color","red");
    username_Boolean = false;
  }
});
// password
$('.reg_password').blur(function(){
  if ((/^[a-zA-Z0-9,<>?+_-]{6,16}$/).test($(".reg_password").val())){
    $('.password_hint').html("✔").css("color","green");
    password_Boolean = true;
  }else {
    $('.password_hint').html("密码格式错误，长度为6-16位，支持大小写字母、数字，可用符号包含,<>?+_-").css("color","red");
    password_Boolean = false;
  }
});


// password_confirm
$('.reg_rePassword').blur(function(){
  if (($(".reg_password").val())==($(".reg_rePassword").val())){
    $('.rePassword_hint').html("✔").css("color","green");
    rePassword_Boolean = true;
  }else {
    $('.rePassword_hint').html("两次密码输入不一致").css("color","red");
    rePassword_Boolean = false;
  }
});


// Email
$('.reg_eMail').blur(function(){
  if ((/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/).test($(".reg_eMail").val())){
    $('.eMail_hint').html("✔").css("color","green");
    eMail_Boolean = true;
  }else {
    $('.eMail_hint').html("邮箱格式错误").css("color","red");
    eMail_Boolean = false;
  }
});


// Mobile
$('.reg_telephone').blur(function(){
  if ((/^1[34578]\d{9}$/).test($(".reg_telephone").val())){
    $('.telephone_hint').html("✔").css("color","green");
    telephone_Boolean = true;
  }else {
    $('.telephone_hint').html("电话号码格式错误").css("color","red");
    telephone_Boolean = false;
  }
});


// click
$('.regester').click(function(){
  
});

function doSubmit(){
	if(username_Boolean && password_Boolean && rePassword_Boolean && eMail_Boolean && telephone_Boolean){
		var obj = {};
		obj.username=$('[name="username"]').val().trim();
		obj.password=$('[name="password"]').val().trim();
		obj.sex=$("input[name='sex']:checked").val();
		obj.mobile=$('[name="mobile"]').val().trim();
		obj.eMail=$('[name="eMail"]').val().trim();
		obj.birthDay=$('[name="birthDay"]').val();
		console.log(obj);
		/*$.post('127.0.0.1:8081/interLearn/user/addUser.do',obj,function(result){
			alert("success!");
			console.log(result);
		});*/
		$.ajax({
			type:"post",
			url:"/interLearn/user/addUser",
			data:obj,
			success:function(data){
				alert("注册成功，可以登录了");
				$(location).attr('href', encodeURI('http://127.0.0.1:8082/interLearn/user/login?username='+data.data.username));
			}
		});
	}else {
	    alert("请完善信息");
	}
}