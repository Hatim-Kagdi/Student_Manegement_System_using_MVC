package in.keen.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	public static Connection getConnection() throws Exception{
		String url = "jdbc:mysql://localhost:3306/studentmanagementsystemmvc";
		String username = "root";
		String password = "$H@bbir0";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);
		return con;
	}
	
}
