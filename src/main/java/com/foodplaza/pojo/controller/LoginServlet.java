package com.foodplaza.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.LoginDaoImpl;
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	LoginDaoImpl ldi=new LoginDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect("Index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		System.out.println("Loginservlet");
		String action=req.getParameter("action");
	    String type=req.getParameter("type");
	    
	    String emailId=req.getParameter("username");
	    String pass=req.getParameter("password");
	    String newPass=req.getParameter("confirmpass");
	    
	    if(action!=null && action.equals("Login"))
	    {
	    	if(type.equals("user"))
	    	{
	    		boolean b=ldi.userLogin(emailId, pass);
	    		if(b) {
	    			
	    			session.setAttribute("user", emailId);
	    			resp.sendRedirect("Index.jsp");
	    		}
	    		else
	    		{
	    			resp.sendRedirect("Fail.jsp");
	    		}
	    	}
	    	if(type.equals("admin"))
	    	{
	    		boolean b=ldi.adminLogin(emailId, pass);
	    				if(b) {
	    					
	    					session.setAttribute("admin", emailId);
	    					resp.sendRedirect("Index.jsp");
	    				}
	    				else
	    				{
	    					resp.sendRedirect("Fail.jsp");
	    				}
	    	}
	    }
	    
	   
	    else  if(action!=null && action.equals("changepassword"))
	    {
	    	if(type.equals("user")) {
	    		boolean b=ldi.userChangePassword(emailId, newPass);
	    		if(b) {
	    			resp.sendRedirect("Success.jsp");
	    		}
	    		else {
	    			resp.sendRedirect("Fail.jsp");
	    		}
	    	}
	    
	    if(type.equals("admin"))
	    {
	    	boolean b=ldi.adminChangePassword(emailId, newPass);
	    	if(b) {
	    		resp.sendRedirect("Success.jsp");
	    		
	    	}
	    	else {
	    		resp.sendRedirect("Fail.jsp");
	    	}
	    }
	   
	}
	}
	
	

}
