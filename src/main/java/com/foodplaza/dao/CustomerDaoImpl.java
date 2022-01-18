package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Customer;
import com.foodplaza.utility.DBUTility;

public class CustomerDaoImpl implements CustomerDao
{
	Connection con=DBUTility.getConnect();

	@Override
	public boolean addCustomer(Customer c) {
		
		try {
			String sql="insert into customer(cust_name,EmailId,password,address,contactNo) values(?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, c.getCust_name());
			ps.setString(2, c.getEmailId());
			ps.setString(3, c.getPassword());
			ps.setString(4, c.getAddress());
			ps.setString(5, c.getContactNo());
			int row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean updateCustomer(Customer c) {
		try {
			String sql="update customer set cust_name=?,password=?,address=?,contactNo=? where EmailId=?" ;
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, c.getCust_name());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getAddress());
			ps.setString(4, c.getContactNo());
			ps.setString(5, c.getEmailId());
		
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(String emailId) {
		try {
			String sql="delete from customer where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
		
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Customer> showAllCustomer() {
		List<Customer> alist=new ArrayList<>();
		try {
			String sql="select * from customer";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Customer c=new Customer();
				c.setCust_name(rs.getString(1));
				c.setEmailId(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setAddress(rs.getString(4));
				c.setContactNo(rs.getString(5));
				
				alist.add(c);
			}
			
		}catch(SQLException e)
		{
			
		}
		return alist;
	}

	@Override
	public Customer searchCustomerByEmail(String custemail) {
		Customer c=null;
		try {
			String sql="select * from customer where EmailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, custemail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				c=new Customer();
				c.setCust_name(rs.getString(1));
				c.setEmailId(rs.getString(2));
				c.setPassword(rs.getString(3));
				c.setAddress(rs.getString(4));
				c.setContactNo(rs.getString(5));
				
			}
			
		}catch(SQLException e)
		{
			
		}
		
		return c;
	}

	

}
