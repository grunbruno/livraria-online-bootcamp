package br.com.alura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/grundb?useTimezone=true&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static Connection getConnection() {
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
}
