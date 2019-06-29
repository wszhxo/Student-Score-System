package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import entity.Course;
import entity.Score;
import util.DbUtilPro;

public class ScoreDao{
	/**
	*������:
	*��Ŀ��:	
	*dao
	*2018��10��14��-����9:22:23
	*/
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet rs = null;
	public static List<Score> list(Integer stuid,Integer year) {// ĳ��ݸ�ѧ�������гɼ�
		List<Score> lScores = null;

		try {
			String sql = " select score.stuid,score.grade,score.courseid,course.`year`,course.`credit`,course.`name`\r\n" + 
					"from score\r\n" + 
					"left JOIN course\r\n" + 
					"ON score.courseid=course.id\r\n" + 
					"where score.stuid=? and year=?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, stuid);
			statement.setInt(2, year);
			rs = (ResultSet) statement.executeQuery();
			lScores = new ArrayList<Score>();
			Score score = null;
			while (rs.next()) {
				score = new Score();
				score.setStuid(rs.getInt("stuid"));
				score.setGrade(rs.getDouble("grade"));
				score.setCourseid(rs.getInt("courseid"));
				score.setYear(rs.getInt("year"));
				score.setName(rs.getString("name"));
				score.setCredit(rs.getDouble("credit"));
				lScores.add(score);
			}
			return lScores;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DbUtilPro.closeConnection(connection, statement, rs);
		}

	}
	
	
	public static String courseById(Integer id){//���ڲ鿴�ɼ�
		String name=null;
		try {
			String sql="select * from course where id=?";
			connection=(Connection) DbUtilPro.getConnection();
			statement=(PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			rs=(ResultSet) statement.executeQuery();		
			if (rs.next()) {
				name= rs.getString("name");
			}	
			return name;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DbUtilPro.closeConnection(connection, statement, rs);
		}
		
	}
	
	public static boolean add(Score score) {//��ӳɼ�
		try {
			String sql = " INSERT into  score(stuid,grade,courseid) VALUES(?,?,?) ";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, score.getStuid());
			statement.setDouble(2, score.getGrade());
			statement.setInt(3, score.getCourseid());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�κ�"+score.getCourseid()+"�����ݿ�����������");
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	
	
	public static void delete(Integer id) {// ɾ�����гɼ�
		try {
			String sql = "delete from score  where stuid= ?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}


	public static List<Course> listCourse(Integer stuid,Integer year) {//Ҫ�������пγ�,���Ҷ����еĳɼ��������ݻ���,
		List<Course> lCourses=new ArrayList<>();
		try {
			
			String sql="select sc.stuid,sc.grade,course.ename,course.`year`,course.`name`\r\n" + 
					"from (select score.stuid,score.grade,score.courseid from score where score.stuid=?) sc\r\n" + 
					"right JOIN course\r\n" + 
					"ON sc.courseid=course.id\r\n" + 
					"where year=?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, stuid);
			statement.setInt(2, year);
			rs=(ResultSet) statement.executeQuery();
			Course course=null;
			while (rs.next()) {
				course=new Course();
				course.setStuid(rs.getInt("stuid"));
				course.setCourse(rs.getString("name"));
				course.setEname(rs.getString("ename"));
				course.setYear(rs.getInt("year"));
				course.setGrade(rs.getDouble("grade")==0.0?null:rs.getDouble("grade"));//����Ĭ��Ϊ0.0
				lCourses.add(course);
			}
			return lCourses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	
	
	
	public static boolean addCourse(Course course) {//��ӿγ�
		try {
			String sql = "insert into course(id,name,ename,credit,year) VALUES(?,?,?,?,?)";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, course.getId());
			statement.setString(2, course.getCourse());
			statement.setString(3, course.getEname());
			statement.setDouble(4, course.getCredit());
			statement.setInt(5, course.getYear());
			int count = statement.executeUpdate();
			
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	
	public static int countCourse() {//���سɼ�����
		try {
			String sql = "select count(*) from course ";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs=(ResultSet) statement.executeQuery();
			if (rs.next()) {
			}
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 100;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	
	public static double peravgscore(Integer stuid,Integer year) {//����ƽ���ɼ�
		try {
			String sql = "select avg(grade) from (SELECT score.grade,score.stuid,course.year FROM score LEFT JOIN course on score.courseid=course.id where course.`year`=?) s where s.stuid=?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, year);
			statement.setInt(2, stuid);
			rs=(ResultSet) statement.executeQuery();
			if (rs.next()) {
			}
			return rs.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}

	
	public static List<Course> findcourse() {//��ѯ�γ̱�
		List<Course> lCourses=new ArrayList<>();
		try {
			String sql = "select * from Course ";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs=(ResultSet) statement.executeQuery();
			Course course = null;
			while (rs.next()) {
				course = new Course();
				course.setId(rs.getInt("id"));
				course.setCourse(rs.getString("name"));
				lCourses.add(course);
			}
			return lCourses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	
	
	public static List<Score> avgscore(Integer courseid,String h) {//ĳ�ɼ����� �ߵ�
		List<Score> lScores = null;
		try {
			String sql = "SELECT student.`name`,student.id ,score.grade ,score.courseid from student LEFT JOIN score\r\n" + 
					"on score.stuid=student.id  where courseid=?  ORDER BY grade "+h;
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, courseid);
			rs=(ResultSet) statement.executeQuery();
			lScores = new ArrayList<Score>();
			Score score = null;
			while (rs.next()) {
				score = new Score();
				score.setStuid(rs.getInt("id"));
				score.setGrade(rs.getDouble("grade"));
				score.setCourseid(rs.getInt("courseid"));
				score.setStuname(rs.getString("name"));
				lScores.add(score);
			}
			return lScores;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	public static double avgscore(Integer courseid) {//ĳ�γ�ƽ����
		try {
			String sql = "select avg(grade) from score where courseid=?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, courseid);
			rs=(ResultSet) statement.executeQuery();
			if (rs.next()) {
			}
			return rs.getDouble(1);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
}
