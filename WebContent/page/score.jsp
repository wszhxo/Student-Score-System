<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
			<c:if test="${result!=2}">
			<div class="selete">
				<p><a href="/myDemo/ScoreServlet?method=addScore&scoreid=${id}">添加成绩</a></p>
			</div>
			</c:if>

    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<tbody >
    		<tr ><td colspan="100%"><h3>2018(秋)成绩</h3></td></tr>
	    	<tr class="theader">
	    		<th>课程</th>
	    		<c:forEach var="lsl" items="${listScore2}">  		
		    			<th>${lsl.name}</th>
	    		</c:forEach>
	    		<th>平均分</th>
    		</tr>
    		<tr class="hehe">
    			<td>分数</td>
				<c:forEach var="ls" items="${listScore2}">  		
		    			<td>${ls.grade}</td>
	    		</c:forEach>
	    		<td>${persavgcore2 }</td>
    		</tr>
    		<tr class="hehe">
    			<td>学分</td>
				<c:forEach var="ls" items="${listScore2}">  		
		    			<td>${ls.credit}</td>
	    		</c:forEach>
    		</tr>
    	</tbody>
    	
    	<tbody >
    	<tr ><td colspan="100%"><h3>2018(春)成绩</h3></td></tr>
	    	<tr class="theader">
	    		<th>课程</th>
	    		<c:forEach var="lsl" items="${listScore1}">  		
		    			<th>${lsl.name}</th>
	    		</c:forEach>
    		<th>平均分</th>
    		</tr>
    		<tr class="hehe">
    			<td>分数</td>
				<c:forEach var="ls" items="${listScore1}">  		
		    			<td>${ls.grade}</td>
	    		</c:forEach>
	    		<td>${persavgcore1 }</td>
    		</tr>
    		<tr class="hehe">
    			<td>学分</td>
				<c:forEach var="ls" items="${listScore1}">  		
		    			<td>${ls.credit}</td>
	    		</c:forEach>
    		</tr>
    	</tbody>
    	<tbody>
    	<tr><td colspan="100%"><h3>2017(秋)成绩</h3></td></tr>
	    	<tr class="theader">
	    		<th>课程</th>
	    		<c:forEach var="lsl" items="${listScore6}">  		
		    			<th>${lsl.name}</th>
	    		</c:forEach>
    		<th>平均分</th>
    		</tr>
    		<tr class="hehe">
    			<td>分数</td>
				<c:forEach var="ls" items="${listScore6}">  		
		    			<td>${ls.grade}</td>
	    		</c:forEach>
	    		<td>${persavgcore6 }</td>
    		</tr>
    		<tr class="hehe">
    			<td>学分</td>
				<c:forEach var="ls" items="${listScore6}">  		
		    			<td>${ls.credit}</td>
	    		</c:forEach>
    		</tr>
    	</tbody>
    	</table>
    </div>
  </div>
  
</div>
</body>
</html>