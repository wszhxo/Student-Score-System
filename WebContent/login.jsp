<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>登录</title>
<link rel="stylesheet" href="css/style.css">
<!-- 引入表单校验jquery插件 -->
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>

<script type="text/javascript">
	


$(document).ready(function(){
		$("#loginform").validate({
			rules:{
				"username":{
					"required":true,
				},
				"password":{
					"required":true,
				},
				
			},
			messages:{
				"username":{
					"required":"用户名不能为空",
				},
				"password":{
					"required":"密码不能为空",
				},
				
			}
		});
});

</script>
</head>
<body>
	<div class="form-wrapper">
		<div class="box">学生成绩管理系统</div>
		<form id="loginform" action="/myDemo/login" method="post">
			<div class="form">
				<div class="form-item">
					<input type="text" name="username"  placeholder="用户名">
				</div>
				<div class="form-item">
					<input type="password" name="password" placeholder="密码">
				</div>
				<div class="button-panel">
					<input type="submit" class="button" value="登录">
				</div>
			</div>
			<p>${msg}${msg2}</p>
		</form>
	</div>

</body>
</html>
