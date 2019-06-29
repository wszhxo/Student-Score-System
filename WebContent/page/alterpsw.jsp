<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width">
<title>登录</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/fort.css">
<script src="js/fort.js"></script>
<script src="js/jquery-1.11.0.js" type="text/javascript"></script>
<script src="js/jquery.validate.min.js" type="text/javascript"></script>

<script type="text/javascript">
	
	//自定义校验规则
	$.validator.addMethod(
		//规则的名称
		"checkPsw",
		//校验的函数
		function(value,element,params){
			
			//定义一个标志
			var flag = false;
			//value:输入的内容
			//element:被校验的元素对象
			//params：规则对应的参数值
			//目的：对输入的username进行ajax校验
			$.ajax({
				//同步
				"async":false,
				"url":"${pageContext.request.contextPath}/AlterPswServlet?username=${idname}&method=checkPsw",
				"data":{"oldpassword":value},
				"type":"get",
				"dataType":"json",
				"success":function(data){
					flag = data.isExist;
				}
			});
			return flag;
			
			
		}
		
	);


	$(function(){
		$("#alter").validate({
			rules:{
				"oldpassword":{
					"required":true,
					"checkPsw":true
				},
				"password":{
					"required":true,
				},
				"repassword":{
					"required":true,
					"equalTo":"#password"
				},
			},
			messages:{
				"oldpassword":{
					"required":"密码不能为空",
					"checkPsw":"原密码错误"
				},
				"password":{
					"required":"密码不能为空",
				},
				"repassword":{
					"required":"密码不能为空",
					"equalTo":"两次密码不一致"
				},
			}
		});
		
		
		
	});
	function update() {	//修改操作	 	
			if($("#oldpsw").val()==""){
				alert("原密码不能为空");
				return false;
			}else if($("#password").val()==""){
				alert("新密码不能为空");
				return false;
			}else{
				$.ajax({
					type : 'post',
					url : "/myDemo/AlterPswServlet",
					dataType : 'json',
					data:$("#alter").serialize(),//序列化所有表单数据
					success : function(data) {
						if(data.b1){
							alert("修改成功!请重新登录!")
							window.location.href="/myDemo/login.jsp";
						}else{	
							alert("修改失败");
						}
			
					},
				});
			}
	}	
	

		
</script>

</head>
<body>
	<div class="form-wrapper">
		<div class="box">修改密码</div>
		<form  id="alter">
			<div class="form">
				<div class="form-item">
					<input type="hidden"  name="username" value="${idname }">
					<input type="password" id="oldpsw"  oldpassword="oldpassword" name="oldpassword" placeholder="原密码">
				</div>
				<div class="form-item">
				<!-- password="password" 用于获取密码框的值 -->
					<input type="password" password="password" name="password" id ="password" placeholder="新密码">
				</div>
				<div class="form-item">
					<input type="password" repassword="repassword" name="repassword" placeholder="重新输入新密码">
				</div>
				<div class="button-panel">
					<input type="button" class="button" onclick="update()" value="确认修改"/>
				</div>
			</div>
		</form>
	</div>
</body>

</html>
