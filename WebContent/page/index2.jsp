<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:foreach -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生成绩管理系统</title>
	<link href="css/layout.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<div id="container">
<!-- 引入header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>
  <div id="mainContent">
    <div id="content">
	    <div class="selete">
			<p><a href="/myDemo/AlterPswServlet?method=alter&id=${student1.id}">修改密码</a></p>
		</div>
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
    		<tr class="hehe">
    			<td rowspan="7">${student1.id}</td>
    			<td>${student1.name}</td>
    			<td>${student1.sex}</td>
    			<td>${student1.age}</td>
    			<td>${student1.address}</td>
    			<td>${student1.depart}</td>
    			<td><a href="/myDemo/ScoreServlet?method=findscore&id=${student1.id}&result=${result}">成绩</a></td>
    			
    		</tr>
    		
    	</tbody>
    	</table>
    </div>
  </div>
  <div id="footer"><p>学生管理系统 By ZHX</p></div>
</div>
</body>
</html>