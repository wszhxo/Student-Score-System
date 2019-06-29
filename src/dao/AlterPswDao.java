package dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import entity.Student;
import entity.User;
import util.DbUtilPro;

public class AlterPswDao {
	/**
	*������:
	*��Ŀ��:	�޸�����
	*dao
	*2018��10��24��-����6:40:47
	*/
	static Connection connection = null;
	static PreparedStatement statement = null;
	static ResultSet rs = null;
	public static boolean stupsw(User user) {//ѧ���޸�����
		try {
			String sql = " update student set password=?  where id= ?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getPassword());
			statement.setInt(2, user.getId());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	public static boolean teapsw(User user) {//��ʦ�޸�����
		try {
			String sql = " update user set password=?  where id= ?";
			connection = (Connection) DbUtilPro.getConnection();
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setString(1, user.getPassword());
			statement.setInt(2, user.getId());
			int count = statement.executeUpdate();
			return count > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtilPro.closeConnection(connection, statement, null);
		}
	}
	
	
	public static boolean  checkPsw1(String username ,String oldpassword) {
		String sql = " select id,username,password,type from user WHERE id=? and password=? \r\n" + 
				"UNION\r\n" + 
				"SELECT id,name,password,type FROM student  WHERE id=? and password=? ";
		connection = (Connection) DbUtilPro.getConnection();
		try {
			statement = (PreparedStatement) connection.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(username));
			statement.setString(2, oldpassword);
			statement.setInt(3, Integer.parseInt(username));
			statement.setString(4, oldpassword);
			rs = (ResultSet) statement.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
