package com.foodplaza.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;


@WebServlet("/food")
public class FoodServlet extends HttpServlet
{
	
	FoodDaoImpl fdi=new FoodDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession();
		
		
		String action=req.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int id=Integer.parseInt(req.getParameter("foodId"));
			boolean b=fdi.deleteFood(id);
			if(b) {
				resp.sendRedirect("Success.jsp");
				
			}
			else {
				resp.sendRedirect("Fail.jsp");
			}
		}
		
		
		  else if(action!=null && action.equals("search")) { 
		  String foodName=req.getParameter("foodName");
		  
		  List<Food> foodList=fdi.searchFoodByName(foodName);
		  List<Food> foodList1=fdi.searchFoodByCategory(foodName);
		  List<Food> foodList2=fdi.searchFoodByType(foodName);
		  if(foodList!=null && !(foodList.isEmpty())) {
		  
		           session.setAttribute("foods", foodList); 
		           resp.sendRedirect("FoodList.jsp"); }
		  
		if(foodList1!=null && !(foodList1.isEmpty())) {
			  
	           session.setAttribute("foods", foodList1); 
	           resp.sendRedirect("FoodList.jsp"); }
		if(foodList2!=null && !(foodList2.isEmpty())) {
			  
	           session.setAttribute("foods", foodList2); 
	           resp.sendRedirect("FoodList.jsp"); }
		
		
	  }
		
		
		
		
		
		  
			/*
			 * else if(action!=null && action.equals("searchByCategory")) { String
			 * foodCat=req.getParameter("foodCat"); List<Food>
			 * foodList=fdi.searchFoodByCategory(foodCat); if(foodList!=null &&
			 * !(foodList.isEmpty())) {
			 * 
			 * session.setAttribute("foods", foodList); resp.sendRedirect("FoodList.jsp"); }
			 * }
			 * 
			 * else if(action!=null && action.equals("searchByType")) { String
			 * foodType=req.getParameter("foodType"); List<Food>
			 * foodList=fdi.searchFoodByType(foodType); if(foodList!=null &&
			 * !(foodList.isEmpty())) {
			 * 
			 * session.setAttribute("foods", foodList); resp.sendRedirect("FoodList.jsp"); }
			 * }
			 */
		 
		
		
		
		
		
		else {
		List<Food> foodList=fdi.getAllFoods();
		if(foodList!=null && !(foodList.isEmpty())) {
			
			session.setAttribute("foods", foodList);
			resp.sendRedirect("FoodList.jsp");
		}
		else
		{
			resp.sendRedirect("Fail.jsp");
		}
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String action=req.getParameter("action");
		if(action!=null && action.equals("FoodSave")) {
		String foodName=req.getParameter("foodname");
		
		String foodType=req.getParameter("foodtype");
		
		String foodCat=req.getParameter("foodcat");
		
		String foodDesc=req.getParameter("fooddesc");
		
		String foodImage=req.getParameter("foodimage");
		
		double price=Double.parseDouble(req.getParameter("foodPrice"));
		
		
		Food food=new Food(foodName, foodType, foodCat, foodDesc, foodImage, price);
		boolean b=fdi.addFood(food);
		if(b) {
			resp.sendRedirect("Success.jsp");
		}
		else
		{
			resp.sendRedirect("Fail.jsp");
		}
	}
		else if(action!=null && action.equals("SaveupdateFood"))
		{
			int id=Integer.parseInt(req.getParameter("foodId"));
			String foodName=req.getParameter("foodname");
			String foodType=req.getParameter("foodtype");
			String foodCat=req.getParameter("foodcat");
			String foodDesc=req.getParameter("fooddesc");
			String foodImage=req.getParameter("foodimage");
			double foodPrice=Double.parseDouble(req.getParameter("foodPrice"));
			
			Food food=new Food(foodName, foodType, foodCat, foodDesc, foodImage,  foodPrice);
			food.setFoodId(id);
			
			boolean b=fdi.updateFood(food);
			if(b) {
				resp.sendRedirect("Success.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
			
			
			
			
			
		}
	}
}
