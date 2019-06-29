package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DbUtilPro{
 
	public static Connection getConnection() {
		/**
         * 读取src根目录下文件的配置文件 
         * jdbc.properties位于src目录
         */
		Properties dbconfig = new Properties();
		// 得到配置文件的输入流
		//得到类加载器对象
		ClassLoader cl = DbUtilPro.class.getClassLoader();
		//通过类加载器得到指定的资源的字节流
		InputStream is = cl.getResourceAsStream("jdbc.properties");
		//将文件的输入流通过dbconfig对象进行关联
		try {
			dbconfig.load(is);
		} catch (IOException e1) {
 			e1.printStackTrace();
		}
	   
		
        Connection con = null;
		try{
			Class.forName(dbconfig.getProperty("jdbc.driver"));
			con = DriverManager.getConnection(dbconfig.getProperty("jdbc.url"),
					dbconfig.getProperty("jdbc.username"), dbconfig.getProperty("jdbc.password"));
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	
	public static void closeConnection(Connection con, Statement st,ResultSet result) {		
	    // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
	    // 注意关闭的顺序，最后使用的最先关闭
		try{
		if (result != null)
		        result.close();
		    if (st != null)
		    	st.close();
		    if (con != null)
		        con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	


	
}