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
		request.setCharacterEncoding("utf-8");// ���ڵ�һ��
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");// �û���
		String password = request.getParameter("password");// ����
		
		String name = request.getParameter("name");//��ѯ����
		String depart = request.getParameter("depart");
		String sex = request.getParameter("sex");
		User user = new User();
		// ����ǿ�
		if (username != null && password != null) {// �����˺�����
			if (!StringUtil.isInteger(username)) {// �ж������Ƿ�Ϊ��ĸ
				request.setAttribute("msg2", "�ʺŲ���������ĸ!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);

			} else {
				user.setId(Integer.parseInt(username));
				user.setPassword(password);
			}
		}else {//Ϊ�����session�л�ȡ
			user = (User) session.getAttribute("loginName");
			if (user == null) {
				request.setAttribute("msg", "�������û���������");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		int result=LoginDao.tlogin(user);// ���ݿ���֤
		// �����˺�����
		String currentPage = request.getParameter("currentPage");// ��ҳ���
		// ��ȡ��ǰҳ,��һ��Ϊnull ������Ϊ1
		if (currentPage == null || "".equals(currentPage.trim())) {
			currentPage = "1";
		}
		Page<Student> pageStu = new Page<>();
		pageStu.setCurrentPage(Integer.parseInt(currentPage));
		StudentDao.getAll(pageStu, name,depart,sex);
		
		if (result==1) {// ��ʦ��¼
			request.setAttribute("student", pageStu);//ѧ����Ϣ
			session.setAttribute("loginName", user);//��¼��Ϣ
			request.getRequestDispatcher("/page/index.jsp").forward(request, response);
		} else if (result==2) {// ѧ����¼
			Student student=StudentDao.findById(Integer.parseInt(username));
			session.setAttribute("student1", student);
			request.setAttribute("result", result);//�������Ȩ��
			request.getRequestDispatcher("/page/index2.jsp").forward(request, response);
			
		} else {
			request.setAttribute("msg", "������û�������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

			

		
	}

}
