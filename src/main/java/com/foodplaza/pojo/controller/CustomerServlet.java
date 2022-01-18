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

import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet
{
	CustomerDaoImpl cdi=new CustomerDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
     HttpSession session= req.getSession();
     
     
     String action=req.getParameter("action");
		if(action!=null && action.equals("delete")) {
			String emailId=req.getParameter("emailId");
			boolean b=cdi.deleteCustomer(emailId);
			if(b) {
				resp.sendRedirect("Success.jsp");
				
			}
			else {
				resp.sendRedirect("Fail.jsp");
			}
		}
		
		else {List<Customer> customerList=cdi.showAllCustomer();
		if(customerList!=null && !(customerList.isEmpty())) {
			
			session.setAttribute("customer", customerList);
			resp.sendRedirect("CustomerList.jsp");
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
		if(action!=null && action.equals("Register")) {
			
			String cust_name=req.getParameter("customerName");
			String emailId=req.getParameter("emailId");
			String password=req.getParameter("password");
			String contactNo=req.getParameter("contactNumber");
			String address=req.getParameter("address");
			
			Customer customer=new Customer(cust_name,emailId,password,contactNo,address);
			boolean b=cdi.addCustomer(customer);
			
			if(b) {
				resp.sendRedirect("Success.jsp");
			}
			else
			{
				resp.sendRedirect("Fail.jsp");
			}
		}
		
		else if(action!=null && action.equals("UpdateCustomer")){
			
			String emailId=req.getParameter("emailId");
			String cust_name=req.getParameter("customerName");
			String password=req.getParameter("password");
			String contactNo=req.getParameter("contactNumber");
			String address=req.getParameter("address");
			
			Customer customer=new Customer(cust_name,emailId,password,contactNo,address);
			boolean b=cdi.updateCustomer(customer);
			
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
