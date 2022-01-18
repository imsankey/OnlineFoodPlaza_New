package com.foodplaza.test;

import java.sql.Connection;

import com.foodplaza.utility.DBUTility;

public class ConnectionTest 
{

	public static void main(String[] args)
	{
		Connection con=DBUTility.getConnect();
		
		if(con!=null)
		{
			System.out.println("connection Succesfull");
			System.out.println(con);
		}
		else
		{
			System.out.println("fail");
		}

	}

}
