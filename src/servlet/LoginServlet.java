package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDao;
import dao.StudentDao;
import entity.Page;
import entity.Student;
import entity.User;
import util.StringUtil;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 放在第一行
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");// 用户名
		String password = request.getParameter("password");// 密码
		
		String name = request.getParameter("name");//查询条件
		String depart = request.getParameter("depart");
		String sex = request.getParameter("sex");
		User user = new User();
		// 输入非空
		if (username != null && password != null) {// 储存账号密码
			if (!StringUtil.isInteger(username)) {// 判断输入是否为字母
				request.setAttribute("msg2", "帐号不允许用字母!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);

			} else {
				user.setId(Integer.parseInt(username));
				user.setPassword(password);
			}
		}else {//为空则从session中获取
			user = (User) session.getAttribute("loginName");
			if (user == null) {
				request.setAttribute("msg", "请输入用户名或密码");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		int result=LoginDao.tlogin(user);// 数据库验证
		// 储存账号密码
		String currentPage = request.getParameter("currentPage");// 分页相关
		// 获取当前页,第一次为null 则设置为1
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
		}
		Page<Student> pageStu = new Page<>();
		pageStu.setCurrentPage(Integer.parseInt(currentPage));
		StudentDao.getAll(pageStu, name,depart,sex);
		
		if (result==1) {// 老师登录
			request.setAttribute("student", pageStu);//学生信息
			session.setAttribute("loginName", user);//登录信息
			request.getRequestDispatcher("/page/index.jsp").forward(request, response);
		} else if (result==2) {// 学生登录
			Student student=StudentDao.findById(Integer.parseInt(username));
			session.setAttribute("student1", student);
			request.setAttribute("result", result);//用于添加权限
			request.getRequestDispatcher("/page/index2.jsp").forward(request, response);
			
		} else {
			request.setAttribute("msg", "密码或用户名错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

			

		
	}

}
