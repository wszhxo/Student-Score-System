package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlterPswDao;
import entity.Student;
import entity.User;

public class AlterPswServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		String id=request.getParameter("id");
		
		if(method.equals("alter")){//只是用于跳转
			request.setAttribute("idname", id);//用于数据回显
			request.getRequestDispatcher("/page/alterpsw.jsp").forward(request, response);
		}else if(method.equals("checkPsw")){
			String username=request.getParameter("username");
			String oldpassword=request.getParameter("oldpassword");
			boolean isExist=AlterPswDao.checkPsw1(username,oldpassword);
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String repassword=request.getParameter("repassword");
		if (password.equals(repassword)) {
			User user=new User();//储存账号密码
			user.setId(Integer.parseInt(username));
			user.setPassword(password);
			boolean b1 = AlterPswDao.teapsw(user);
			response.getWriter().write("{\"b1\":"+b1+"}");	
		}
		
	}

}
