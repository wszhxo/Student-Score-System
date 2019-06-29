<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:foreach -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改</title>
	<link href="css/layout.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
</head>
<body>
<div id="container">
<!-- 引入header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>
  <div id="mainContent">
    <div id="content">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<thead class="theader">
  			<th width="12%">学号</th>
  			<th width="12%">姓名</th>
  			<th width="12%">性别</th>
  			<th width="12%">年龄</th>
  			<th width="12%">系别</th>
  			<th width="20%">地址</th>
  			<th width="20%">操作</th>
    	</thead>
    	<tbody class="tbody">
    	<form  id="addForm">
    		<tr class="selete">
    			<td><input type="text"  name="id" /></td>
    			<td><input type="text" name="name" placeholder="名字" /></td>
    			<td><select  name="sex">
    					<option>---性别---</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select></td>
					<td><input type="text" name="age" placeholder="出身日期" /></td>
    			<td><input type="text" name="depart" placeholder="系别" id="depart"/></td>
    			<td><input type="text" name="address" placeholder="地址" /></td>
    			<td><input type="button" onclick="add();" value="添加"></td>
    		</tr>
    	</form>
    	</tbody>
    	</table>
    </div>
  </div>
  <div id="footer"><p>学生管理系统 By ZHX</p></div>
</div>
</body>
<script>
	function add() {	//添加操作
		if($("#depart").val()==""){
			alert("输入框不能为空");
			return false;
		}
		$.ajax({
			type : 'post',
			url : "/myDemo/StudentServlet?mtd=add",
			dataType : 'json',
			data:$("#addForm").serialize(),//序列化所有表单数据
			success : function(data) {
				if(data.b){
					alert("添加成功!")
					//成功则刷新页面
					window.location.href="/myDemo/login";
				}else{	
					alert("请输入正确	且不重复的学号");
				}
	
			},
		});
	}
</script>
</html>