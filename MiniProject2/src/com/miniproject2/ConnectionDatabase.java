package com.miniproject2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDatabase {
	
	public Connection getConnection() throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniproject", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			
		}
		return con;
		
	}

}
