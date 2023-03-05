package controller;

import java.sql.*;

public class ConnectionSQL {
	
	public static Connection getConnectionSQL()
	{
		final String url = "jdbc:sqlserver://localhost;database=QLTV1;encrypt=false";
		final String username = "sa";
		final String pass = "123";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if(DriverManager.getConnection(url,username,pass)!= null)
			{
				System.out.println("Connection");
			}
			else{
				System.out.println("Disconection");
			}
			return DriverManager.getConnection(url,username,pass);
				

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	public static void closeConnectionSQL(Connection c)
	{
		try {
	//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if(c != null)
			{
				c.close();
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
		
	}
}
