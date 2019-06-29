<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- c:foreach -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 时间格式化问题 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>学生成绩管理系统</title>
	<link href="css/layout.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.11.0.js" ></script>
</head>
<script>
	function del(id) {	//删除操作
		 if (confirm("确认删除吗???删除之后,成绩也会清空!!!") ) { 
			$.ajax({
				type : 'get',
				url : "/myDemo/StudentServlet?method=delete&id="+id,
				dataType : 'json',
				success : function(data) {
					if(data.b){
						alert("删除学生成功!")
						//成功则刷新页面
						window.location.href="/myDemo/login";
					}else{
						alert("删除成绩成功!请再点击删除!")
					}
					
		
				},
			});
		 }
	}
	
	
</script>
<body >
<div id="container">
  <!-- 引入header.jsp -->
	<jsp:include page="header.jsp"></jsp:include>
  <div id="mainContent">
    <div id="content">
			<div class="selete">
			<form action="/myDemo/login" method="post">
			 	<p><input type="text" name="name" placeholder="姓名"></p>
			 	<p><input type="text" name="depart" placeholder="系别"></p>
			 	<p><select  name="sex">
    					<option>---性别---</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select></p>
				<p><input type="submit" placeholder="" value="查询"></p>
			</form>  
			<p><a href="/myDemo/StudentServlet?method=add">添加学生信息</a></p>
			<p><a href="/myDemo/AlterPswServlet?method=alter&id=${loginName.id}">修改密码</a></p>
			<p><a href="/myDemo/page/addCourse.jsp">添加课程</a></p>
			<p><a href="/myDemo/SortServlet">成绩排序</a></p>
			</div>

    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<thead class="theader">
  			<th width="12%">学号</th>
  			<th width="12%">姓名</th>
  			<th width="12%">性别</th>
  			<th width="12%">出身日期</th>
  			<th width="12%">系别</th>
  			<th width="20%">地址</th>
  			<th width="20%">操作</th>
    	</thead>
    	<tbody class="tbody">
    	
			<c:forEach var="stu" items="${student.pageData}"  >  		
    		<tr class="hehe">
    			<td>${stu.id}</td>
    			<td>${stu.name}</td>
    			<td>${stu.sex}</td>
    			<td><fmt:formatDate value="${stu.age}" pattern="yyyy-MM-dd "/></td>
    			<td>${stu.address}</td>
    			<td>${stu.depart}</td>
    			<td><a href="/myDemo/StudentServlet?method=update&id=${stu.id}">修改</a>
    			<a href="javascript:void(0)" onclick="del(${stu.id});">删除</a>
    			<a href="/myDemo/ScoreServlet?method=findscore&id=${stu.id}">成绩</a></td>
    		</tr>
    		</c:forEach>
    		
    	</tbody>
    	</table>
    	<div class="page">
	  		<a href="javascript:void(0)">${student.currentPage}/${student.totalPage}页</a>
			<a href="/myDemo/login?currentPage=1">首页</a>
	  		<a href="/myDemo/login?currentPage=${student.currentPage-1}">上页</a>
	  		<a href="/myDemo/login?currentPage=${student.currentPage+1}">下页</a>
	  		<a href="/myDemo/login?currentPage=${student.totalPage}">尾页</a>
    	</div>
    </div>
  </div>
  <div id="footer"><p>学生管理系统 By ZHX</p></div>
</div>
</body>
</html>