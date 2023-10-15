package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnection {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/testdb";
	private static final String USER = "root";
	private static final String PASSWORD = "admin";
	
	public static Connection getConnection() throws SQLException {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWORD);
		return DriverManager.getConnection(URL, prop);
		//return DriverManager.getConnection(URL, USER, PASSWORD);
		//return DriverManager.getConnection(URL+"?user=root&password=admin");
	}
}
