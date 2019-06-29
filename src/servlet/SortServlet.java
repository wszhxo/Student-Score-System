package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import dao.ScoreDao;
import entity.Score;

public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hString=null;
		hString=request.getParameter("hString");
		String courseid=null;
		courseid=request.getParameter("courseid");
		//为了解决第一次进入页面为空
		//多选框为中文的问题
		if (hString==null||hString.equals("dd")) {
			hString="desc";
		}
		if (courseid==null||courseid.equals("dd")) {
			courseid="1";
		}
		
		List<Score> lScores =ScoreDao.avgscore(Integer.parseInt(courseid), hString);
		double avgscore=ScoreDao.avgscore(Integer.parseInt(courseid));
		request.setAttribute("lScores",lScores);
		request.setAttribute("sdcourse", ScoreDao.findcourse());
		request.setAttribute("avgscore", avgscore);
		request.setAttribute("mes", ScoreDao.courseById(Integer.parseInt(courseid)));
		
		request.getRequestDispatcher("/page/sort.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
