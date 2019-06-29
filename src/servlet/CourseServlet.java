package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDao;
import entity.Course;

public class CourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");// 放在第一行
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String coursename = request.getParameter("coursename");
		String ename = request.getParameter("ename");
		String year = request.getParameter("year");
		String credit = request.getParameter("credit");
		Course course = new Course();
		course.setCourse(coursename);
		//因为存在外键,不能自动增长,手动实现自动增长
		course.setId(ScoreDao.countCourse()+1);
		course.setEname(ename);
		course.setCredit(Double.parseDouble(credit));
		course.setYear(Integer.parseInt(year));
		boolean b = ScoreDao.addCourse(course);
		response.getWriter().write("{\"b\":" + b + "}");
	}

}
