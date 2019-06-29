package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDao;
import dao.StudentDao;
import entity.Student;

public class StudentServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	*创建人:
	*项目名:	
	*servlet
	*2018年10月12日-下午9:28:32
	*/
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method=req.getParameter("method");
		String id=req.getParameter("id");
		if (method.equals("delete")) {
				boolean b = StudentDao.delete(Integer.parseInt(id));//课程id外键存在,会出错所以要捕获异常
				ScoreDao.delete(Integer.parseInt(id));//删除该学生的所有成绩
				resp.getWriter().write("{\"b\":"+b+"}");
		}else if(method.equals("update")){
			Student student=StudentDao.findById(Integer.parseInt(id));
			req.setAttribute("stuUpdate", student);
			req.getRequestDispatcher("/page/update.jsp").forward(req, resp);
		}else if(method.equals("add")){
			req.getRequestDispatcher("/page/add.jsp").forward(req, resp);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");//放在第一行
	    resp.setCharacterEncoding("UTF-8");
	    resp.setContentType("text/html; charset=UTF-8");
	    String method=req.getParameter("mtd");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String age=req.getParameter("age");
		String depart=req.getParameter("depart");
		String address=req.getParameter("address");
		Student student=new Student();
		student.setId(Integer.parseInt(id));
		student.setName(name);
		student.setSex(sex);
		try {
			student.setAge(new SimpleDateFormat("yyyy-MM-dd").parse(age));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setDepart(address);
		student.setAddress(depart);
		if (method.equals("add")) {
			boolean b = StudentDao.add(student);
			resp.getWriter().write("{\"b\":"+b+"}");
		}else if (method.equals("update")) {
			boolean b = StudentDao.update(student);
			resp.getWriter().write("{\"b\":"+b+"}");
		}
	}
}
