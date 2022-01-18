package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodplaza.utility.DBUTility;

public class LoginDaoImpl implements LoginDao
{

	Connection con=DBUTility.getConnect();
	@Override
	public boolean userLogin(String custEmailId, String custPassword) {
		try {
			String sql="select * from customer where EmailId=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, custEmailId);
			ps.setString(2, custPassword);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean userChangePassword(String custEmailId, String newPassword) {
		try {
			String sql="update customer set password=? where EmailId=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(2, custEmailId);
			ps.setString(1, newPassword);
			
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
				return false;
	}

	@Override
	public boolean adminLogin(String adminEmailId, String adminPassword) {
		try {
			String sql="select * from adminlogin where adminemailId=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, adminEmailId);
			ps.setString(2, adminPassword);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean adminChangePassword(String adminEmailId, String adminPassword) {
		try {
			String sql="update adminlogin set password=? where adminemailId=? ";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(2, adminEmailId);
			ps.setString(1, adminPassword);
			
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return false;
	}

}
