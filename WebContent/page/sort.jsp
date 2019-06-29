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
	    
			<form action="/myDemo/SortServlet" method="post">
			 	<p><select  name="courseid">
    					<option value="dd">--选择课程--</option>
    					<c:forEach var="sd" items="${sdcourse }" >
							<option value="${sd.id }">${sd.course }</option>
						</c:forEach>
					</select></p>
				<p>
				<p><select  name="hString">
    					<option value="dd">排序(默认高)</option>
						<option value="desc">从高到低</option>
						<option value="asc">从低到高</option>
					</select></p>
				<p><input type="submit"  value="排序"></p>
				
			</form>  
		</div>
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<thead class="theader">
    		<th width="25%">NO</th>
  			<th width="25%">学号</th>
  			<th width="25%">姓名</th>
  			<th width="25%">成绩</th>
    	</thead>
    	<tbody class="tbody">
    		<tr class="hehe">
    			<td colspan="2"><h3>当前课程平均分: ${avgscore}</h3></td>
    			<td colspan="2"><h3>当前课程为: ${mes}</h3></td>
    		</tr>
    		<c:forEach var="lS" items="${lScores }" varStatus="status">
    		<tr class="hehe">
    			<td>${status.count}</td>
    			<td>${lS.stuid}</td>
    			<td>${lS.stuname}</td>
    			<td>${lS.grade}</td>
    		</tr>
    		</c:forEach>
    	</tbody>
    	</table>
    </div>
  </div>
</div>
</body>
</html>