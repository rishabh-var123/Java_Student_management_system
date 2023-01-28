package pojo;

import java.sql.DriverManager;

import java.sql.Connection;
public class CP {
	static Connection con;
	public static Connection createC() 
	{
	try {
		//1.load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2.create the connection
		String user="root";
		String password="root";
		//String url="jdbc:mysql://localhost:3306/student_manage?characterEncoding=utf8";
		String url="jdbc:mysql://localhost:3306/student_manage?autoReconnect=true&useSSL=false";
		con= DriverManager.getConnection(url, user, password);
		//create the connection...
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	return con;
	
	}

	

}
