package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Cart;
import com.foodplaza.utility.DBUTility;

public class CartDaoImp implements CartDao 
{
	Connection con=DBUTility.getConnect();

	@Override
	public boolean addToCart(Cart cart) {
		try {
			String sql="insert into cart(cartId,foodId,foodName,foodPrice,quantity,totalPrice,EmailId) values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cart.getCartId());
			ps.setInt(2, cart.getFoodId());
			ps.setString(3, cart.getFoodName());
			ps.setDouble(4, cart.getFoodPrice());
			ps.setInt(5, cart.getQuantity());
			ps.setDouble(6, cart.getTotalprice());
			ps.setString(7, cart.getEmailId());
			
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
	public List<Cart> showCart(String EmailId) {
		List<Cart> alist=new ArrayList<>();
		try {
			String sql="select * from cart where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, EmailId);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Cart cart=new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setFoodId(rs.getInt(2));
				cart.setFoodName(rs.getString(3));
				cart.setFoodPrice(rs.getDouble(4));
				cart.setQuantity(rs.getInt(5));
				cart.setTotalprice(rs.getDouble(6));
				cart.setEmailId(rs.getString(7));
				alist.add(cart);
			}
		}catch(SQLException e)
		{
			
		}
		
		return alist;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try {
			String sql="delete from cart where cartId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, cartId);
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
	public boolean clearCart(String emailId) {
		try {
			String sql="delete from cart where emailId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, emailId);
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

}
