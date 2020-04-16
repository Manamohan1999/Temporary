package com.kmbb.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","admin");
			Statement smt=conn.createStatement();
			smt.execute("use student");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}