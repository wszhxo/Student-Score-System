<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:foreach -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../js/jquery-1.11.0.js" ></script>
<title>添加课程</title>
</head>
<body>
<div class="form-wrapper">
	<form id="addform" >
			<div class="form">
				<div class="form-item">
					<input type="text" name="coursename"  placeholder="课程名">
				</div>
				<div class="form-item">
					<input type="text" name="ename" placeholder="课程英文名">
				</div>
				<div class="form-item">
					<select  name="year">
    					<option>---学年---</option>
						<option value="1">2018(春)</option>
						<option value="2">2018(秋)</option>
						<option value="3">2019(春)</option>
						<option value="4">2019(秋)</option>
						<option value="7">2020(春)</option>
						<option value="8">2020(秋)</option>
					</select>
				</div>
				<div class="form-item">
					<input type="text" id="sco" name="credit" placeholder="课程学分">
				</div>
				<div class="button-panel">
					<input type="button" onclick="add();" class="button" value="添加课程">
				</div>
			</div>
		</form>
	</div>
</body>
<script>
	function add() {	//添加操作
		if($("#sco").val()==""){
			alert("输入框不能为空");
			return false;
		}
		$.ajax({
			type : 'post',
			url : "/myDemo/CourseServlet",
			dataType : 'json',
			data:$("#addform").serialize(),//序列化所有表单数据
			success : function(data) {
				if(data.b){
					alert("添加课程成功!")
					//成功则刷新页面
					window.location.href="/myDemo/login";
				}else{	
					alert("添加失败");
				}
	
			},
		});
	}
</script>
</html>