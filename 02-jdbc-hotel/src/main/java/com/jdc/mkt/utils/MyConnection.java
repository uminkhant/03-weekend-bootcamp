package com.jdc.mkt.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
		
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				Con.URL.getValue(),
				Con.USER.getValue(), 
				Con.PASS.getValue());
	}
	
	private enum Con{
		URL("jdbc:mysql://localhost:3306/hotel_db"),
		USER("root"),
		PASS("admin");
		
		private String value ;
		
		Con(String value){
			this.value = value;
		}
		
		String getValue() {
			return value;
		}
		
	}
}
