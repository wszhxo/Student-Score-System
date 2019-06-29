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
	 * ������: ��Ŀ��: ��¼ 2018��10��11��-����7:34:09
	 */
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet rs = null;
	
	public static int tlogin(User user) {//��ʦ��¼
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
				user.setUsername(rs.getString("username"));//������ʾ��ҳ���ڵ�¼���û�
				user.setType(rs.getInt("type"));
			}
			return rs.getInt("type");//1��ʾ��ʦ��¼2��ʾѧ��
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
