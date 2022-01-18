package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.FeedBack;
import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUTility;

public class FoodDaoImpl implements FoodDao
{
	Connection con=DBUTility.getConnect();

	@Override
	public boolean addFood(Food food) {
		
		try {
			String sql="insert into food(foodName,foodType,foodCat,foodDesc,foodImage,foodPrice) values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodType());
			ps.setString(3, food.getFoodCat());
			ps.setString(4, food.getFoodDesc());
			ps.setString(5, food.getFoodImage());
			ps.setDouble(6, food.getPrice());
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	

	@Override
	public boolean updateFood(Food food) {
		
		try {
			String sql="update food set foodName=?,foodType=?,foodCat=?,foodDesc=?,foodImage=?,foodPrice=? where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, food.getFoodName());
			ps.setString(2, food.getFoodType());
			ps.setString(3, food.getFoodCat());
			ps.setString(4, food.getFoodDesc());
			ps.setString(5, food.getFoodImage());
			ps.setDouble(6, food.getPrice());
			ps.setInt(7, food.getFoodId());
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
			}
			else {
				return false;
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		
		
		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		
		try {
			String sql="delete from food where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
			int row=ps.executeUpdate();
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Food searchFoodById(int foodId) {
		Food food=null;
		try {
			String sql="select * from food where foodId=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				food=new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));
				food.setFoodCat(rs.getString(4));
				food.setFoodDesc(rs.getString(5));
				food.setFoodImage(rs.getString(6));
				food.setPrice(rs.getDouble(7));
			}
		}catch(SQLException e)
		{
			
		}
		
		return food;
	}
	
//	+--------+----------+----------+---------+----------+-----------+-----------+
//	| foodId | foodName | foodType | foodCat | foodDesc | foodImage | foodPrice |
//	+--------+----------+----------+---------+----------+-----------+-----------+
//	|      1 | kk       | io       | gff     | uyt      | pou       |     20.00 |
//	|      2 | samosa   | snacks   | nasta   | sas      | veg       |     20.00 |
//	+--------+----------+----------+---------+----------+-----------+-----------+

	@Override
	public List<Food> getAllFoods() {
		List<Food> alist=new ArrayList<>(); 
		try {
			String sql="select * from food";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Food food=new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));
				food.setFoodCat(rs.getString(4));
				food.setFoodDesc(rs.getString(5));
				food.setFoodImage(rs.getString(6));
				food.setPrice(rs.getDouble(7));
				alist.add(food);	
			}
			
		}catch(SQLException e)
		{
			
		}
		
		
		return alist;
		
	}

	@Override
	public List<Food> searchFoodByName(String foodName) {
		List<Food> alist=new ArrayList<>();
		try {
			String sql="select * from food where foodName=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, foodName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Food food=new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));
				food.setFoodCat(rs.getString(4));
				food.setFoodDesc(rs.getString(5));
				food.setFoodImage(rs.getString(6));
				food.setPrice(rs.getDouble(7));
				alist.add(food);	
			}
		}catch(SQLException e)
		{
			
		}
		
		
		return alist;
		
		
		
		
	}

	@Override
	public List<Food> searchFoodByType(String foodType) {
		List<Food> alist=new ArrayList<>();
		try {
			String sql="select * from food where foodType=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, foodType);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Food food=new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));
				food.setFoodCat(rs.getString(4));
				food.setFoodDesc(rs.getString(5));
				food.setFoodImage(rs.getString(6));
				food.setPrice(rs.getDouble(7));
				alist.add(food);	
			}
		}catch(SQLException e)
		{
			
		}
		
		
		return alist;
		
	
	}

	@Override
	public List<Food> searchFoodByCategory(String foodCat) {
		List<Food> alist=new ArrayList<>();
		try {
			String sql="select * from food where foodCat=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, foodCat);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Food food=new Food();
				food.setFoodId(rs.getInt(1));
				food.setFoodName(rs.getString(2));
				food.setFoodType(rs.getString(3));
				food.setFoodCat(rs.getString(4));
				food.setFoodDesc(rs.getString(5));
				food.setFoodImage(rs.getString(6));
				food.setPrice(rs.getDouble(7));
				alist.add(food);	
			}
		}catch(SQLException e)
		{
			
		}
		
		
		return alist;
			
		}


	@Override
	public boolean addFeedback(FeedBack feedback) {
		
		try {
		String sql="insert into feedback(name,emailId,feedback,review) values(?,?,?,?)";
		
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, feedback.getCustomername());
			ps.setString(2, feedback.getEmailId());
			ps.setString(3, feedback.getFeedback());
			ps.setString(4, feedback.getRview());
			
			int row=ps.executeUpdate();
			if(row>0) {
				return true;
				
			}
			else
			{
				return false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public List<FeedBack> getAllFeedBack() {
		
		List<FeedBack> alist=new ArrayList();
		
		try {
		String sql="select * from Feedback";
		
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FeedBack feedback=new FeedBack();
				
				feedback.setFeedbackId(rs.getInt(1));
				feedback.setCustomername(rs.getString(2));
				feedback.setEmailId(rs.getString(3));
				feedback.setFeedback(rs.getString(4));
				feedback.setRview(rs.getString(5));
				
				alist.add(feedback);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return alist;
	}
		
		
	

	

}
