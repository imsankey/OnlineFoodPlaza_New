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

import com.foodplaza.dao.CartDaoImp;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;


@WebServlet("/cart")
public class CartServlet extends HttpServlet 
{
	CartDaoImp cad=new CartDaoImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session= req.getSession();
		String customerEmailId=(String)session.getAttribute("user"); 
		
		String action=req.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int id=Integer.parseInt(req.getParameter("cartId"));
			boolean b=cad.deleteCart(id);
			if(b) {
				resp.sendRedirect("Success.jsp");
				
			}
			else {
				resp.sendRedirect("Fail.jsp");
			}
		}
		
		
		else {
		
		
		
		
		
		List<Cart> cartList=cad.showCart(customerEmailId);
		if(cartList!=null && !(cartList.isEmpty())) {
			
			session.setAttribute("carts", cartList);
			resp.sendRedirect("CartList.jsp");
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
			
			int id=Integer.parseInt(req.getParameter("foodId"));
			String foodName=req.getParameter("foodname");
			String emailId=req.getParameter("emailId");
			double foodPrice=Double.parseDouble(req.getParameter("foodPrice"));
			int quantity=Integer.parseInt(req.getParameter("foodQuantity"));
			double totalprice=Double.parseDouble(req.getParameter("TotalPrice"));
			
			//Cart( int foodId, int quantity, String emailId, String foodName, double foodPrice,double totalprice)
			Cart cart=new Cart(id,quantity,emailId,foodName,foodPrice,totalprice);
			
			boolean b=cad.addToCart(cart);
			if(b) {
				resp.sendRedirect("Success.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
			
		}
		
	}
	

