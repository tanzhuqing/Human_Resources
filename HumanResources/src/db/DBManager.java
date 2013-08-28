package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * java 与MySQL连接类
 * 
 * @author 小龙
 */
public class DBManager {
	// 数据库的驱动
	private static String driver;
	// 数据的连接： MySQL服务器的IP（或主机名）、端口号
	// 制定数据库
	private static String url;
	// 数据库用户名
	private static String userName;
	// 数据库用户密码
	private static String userPassword;

	static {
		getInstance();
	}// 静态的语句块

	private static void getInstance() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/power_resources";
		userName = "root";
		userPassword = "1234";
		// 将MySQL驱动加载到类中
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public synchronized static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, userPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
