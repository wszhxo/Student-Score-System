<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:foreach -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生成绩管理系统</title>
	<link href="css/layout.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
</head>
<body>

	<div class="form-wrapper">
		<form id="addform" >
			<div class="form">
				<div class="form-item">
						<input type="hidden"  name="id" value="${scoreid}">
				</div>
				<c:forEach var="lcourse" items="${lc}">  	
					<div class="form-item">
						<input type="text" id="cname" name="${lcourse.ename}" value="${lcourse.grade}"  placeholder="${lcourse.course}"/>
					</div>
	    		</c:forEach>
				<div class="button-panel">
					<input type="button" onclick="add();" class="button" value="添加">
				</div>
			</div>
		</form>
	</div>

</body>
<script>
	function add() {	//添加操作
		if($("#cname").val()==""){
			alert("输入框不能为空");
			return false;
		}
		$.ajax({
			type : 'post',
			url : "/myDemo/ScoreServlet",
			dataType : 'json',
			data:$("#addform").serialize(),//序列化所有表单数据
			success : function(data) {
				if(data.b){
					alert("添加成绩成功!")
					//成功则刷新页面
					window.location.href="/myDemo/login";
				}else{	
					alert("添加失败,该成绩已存在");
				}
	
			},
		});
	}
</script>
</html>