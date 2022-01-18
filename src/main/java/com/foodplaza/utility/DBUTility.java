package com.foodplaza.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTility 
{
	public static Connection getConnect() {
	Connection con=null;
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinefoodplaza_ct_ol_22_sanket","root","1234");
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	return con;
	
	}

}
