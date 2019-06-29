<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header">
	<h3>学生成绩管理系统</h3>
	<p>欢迎您,
			<c:if test="${!empty loginName }">
			 ${loginName.username} 
		</c:if> 
		<c:if test="${!empty student1 }">
			 ${student1.name}
		</c:if>
		| <a href="/myDemo/ExitServlet">退出</a>
	</p>
	
</div>