package com.cdac.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/productdb";
	
	private static final String USER = "root";
	
	private static final String PASSWORD= "root@123";
	
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL,USER, PASSWORD);
			
		}
		catch(Exception e) {
			e.printStackTrace();		
		}
		return con;
	}
}
