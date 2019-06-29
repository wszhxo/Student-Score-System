package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import entity.Student;
import entity.User;
import util.DbUtilPro;

public class LoginDao {
	/**
	 * 创建人: 项目名: 登录 2018年10月11日-下午7:34:09
	 */
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet rs = null;
	
	public static int tlogin(User user) {//老师登录
		String sql = " select id,username,password,type from user WHERE id=? and password=? \r\n" + 
				"UNION\r\n" + 
				"SELECT id,name,password,type FROM student  WHERE id=? and password=? ";
		connection = (Connection) DbUtilPro.getConnection();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, user.getId());
			statement.setString(2, user.getPassword());
			statement.setInt(3, user.getId());
			statement.setString(4, user.getPassword());
			rs = (ResultSet) statement.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));//用于显示主页正在登录的用户
				user.setType(rs.getInt("type"));
			}
			return rs.getInt("type");//1表示老师登录2表示学生
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
