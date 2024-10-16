package com.fod.ddutils;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBUtils 
{
	private static Connection con=null;
	private static String url="jdbc:mysql://localhost:3306/karthikapp";
	private static String username="root";
	private static String password="Balaji@123";
	
	public static Connection myConnect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
	}

}
