package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDao;
import entity.Course;
import entity.Score;

/**
 * 创建人: 项目名: servlet 2018年10月14日-下午4:18:20
 */
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("addScore")) {//添加成绩 ,需要回显 学号
			String scoreid = request.getParameter("scoreid");
			List<Course> lc=ScoreDao.listCourse(Integer.parseInt(scoreid),2);
			request.setAttribute("scoreid", scoreid);
			request.setAttribute("lc", lc);
			request.getRequestDispatcher("/page/addScore.jsp").forward(request, response);
		} else if (method.equals("findscore")) {// 用于列出学生的成绩
			String id = request.getParameter("id");//学号
			String result = request.getParameter("result");//用于添加成绩的权限
			request.setAttribute("result", result);
			List<Score> listScore2 = ScoreDao.list(Integer.parseInt(id),2);//查询出该学生的所有成绩
			List<Score> listScore1 = ScoreDao.list(Integer.parseInt(id),1);
			List<Score> listScore6 = ScoreDao.list(Integer.parseInt(id),6);
			request.setAttribute("id", id);
			request.setAttribute("listScore2", listScore2);
			request.setAttribute("listScore1", listScore1);
			request.setAttribute("listScore6", listScore6);
			
			double persavgcore2=ScoreDao.peravgscore(Integer.parseInt(id),2);//个人的平均成绩
			request.setAttribute("persavgcore2", persavgcore2);
			double persavgcore1=ScoreDao.peravgscore(Integer.parseInt(id),1);//个人的平均成绩
			request.setAttribute("persavgcore1", persavgcore1);
			double persavgcore6=ScoreDao.peravgscore(Integer.parseInt(id),6);//个人的平均成绩
			request.setAttribute("persavgcore6", persavgcore6);
			request.getRequestDispatcher("/page/score.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		List<Course> lcCourses=ScoreDao.listCourse(Integer.parseInt(id),2);
		String[] str = new String[lcCourses.size()];//储存课程
		int j=0;
		for (Course course : lcCourses) {
			str[j]=request.getParameter(course.getEname());
			j++;
		}
		boolean b = false;
		for (int i = 0; i < str.length; i++) {
			if (str[i]!=null) {//有一些成绩没有添加
				Score score = new Score();
				score.setStuid(Integer.parseInt(id));
				score.setGrade(Double.parseDouble(str[i]));//成绩
				score.setCourseid(i + 1);
				b = ScoreDao.add(score);
			}
		}
		response.getWriter().write("{\"b\":"+b+"}");
	}
}
