package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import util.DbUtilPro;
import entity.Page;
import entity.Student;

public class StudentDao {
	/**
	 * 创建人: 项目名: 学生信息crud 2018年10月11日-下午2:46:22
	 * @param sex 
	 * @param depart 
	 */
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet rs = null;
	public static void getAll(Page<Student> page,String name, String depart, String sex) {// 显示所有信息

		int totalCount = getLineNum(name,depart,sex);// 总记录数
		page.setTotalCount(totalCount);
		
		if (page.getCurrentPage() <= 1) {//上一页小于第一页 
			page.setCurrentPage(1);
		} else if (page.getCurrentPage() > page.getTotalPage()) {//下一页超过总页数
			page.setCurrentPage(page.getTotalPage());
		}
		int index = (page.getCurrentPage() - 1) * page.getPageCount();// 起始行=(当前页-1) *每页行数
		int pageCount = page.getPageCount();// 每页显示行数
		List<Student> lstudents = null;
		try {
			String sql = "select * from student where 1=1 and isdel=0";
			if (name!=null) {
				sql +=" and name like '%"+name+"%'";
			}
			if (depart!=null) {
				sql +=" and depart like '%"+depart+"%'";
			}
			if ("男".equals(sex)||"女".equals(sex)) {
				sql +=" and sex = '"+sex+"'";
			}
			sql +=" limit ?,? ";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, index);
			statement.setInt(2, pageCount);
			rs = (ResultSet) statement.executeQuery();
			lstudents = new ArrayList<Student>();
			Student student = null;
			while (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getTimestamp("age"));
				student.setDepart(rs.getString("address"));
				student.setAddress(rs.getString("depart"));
				lstudents.add(student);
			}
			page.setPageData(lstudents);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtilPro.closeConnection(connection, statement, rs);
		}
	}


	public static boolean add(Student student) {// 添加学生信息
		try {
			String sql = " INSERT into  student VALUES(?,?,?,?,?,'123456',2,0,? )";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, student.getId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getSex());
			statement.setString(4, student.getAddress());
			statement.setString(5, student.getDepart());
			statement.setDate(6, new Date (student.getAge().getTime()));
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}

	public static boolean delete(Integer id) {// 删除
		try {
			String sql = "UPDATE student set isdel=1 where id=?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			System.out.println("外键原因,请删除学生成绩");
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}

	public static boolean update(Student student) {// 修改
		try {
			String sql = "update student set name=? ,sex=?,age=? ,address=?,depart=? where id= ?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setString(2, student.getSex());
			statement.setDate(3, new Date (student.getAge().getTime()));
			statement.setString(4, student.getAddress());
			statement.setString(5, student.getDepart());
			statement.setInt(6, student.getId());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}

	public static Student findById(Integer id) {// 根据id查询整条
		Student student = null;
		try {
			String sql = "select * from student where id=? and isdel=0";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, id);
			rs = (ResultSet) statement.executeQuery();
			if (rs.next()) {
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setSex(rs.getString("sex"));
				student.setAge(rs.getTimestamp("age"));
				student.setDepart(rs.getString("address"));
				student.setAddress(rs.getString("depart"));
				student.setType(rs.getInt("type"));
			}
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtilPro.closeConnection(connection, statement, rs);
		}
	}

	public static int getLineNum(String name, String depart, String sex) {// 获取总记录数
		try {
			String sql = "select count(*) from student where 1=1 and isdel=0";
			//String sql = "select * from student where 1=1 ";
			if (name!=null) {
				sql +=" and name like '%"+name+"%'";
			}
			if (depart!=null) {
				sql +=" and depart like '%"+depart+"%'";
			}
			if ("男".equals(sex)||"女".equals(sex)) {
				sql +=" and sex = '"+sex+"'";
			}
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			rs = (ResultSet) statement.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtilPro.closeConnection(connection, statement, rs);
		}
	}
}
