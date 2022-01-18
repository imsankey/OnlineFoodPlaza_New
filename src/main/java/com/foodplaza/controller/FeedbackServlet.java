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
import com.foodplaza.pojo.FeedBack;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet 
{
	FoodDaoImpl fdi=new FoodDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		List<FeedBack> feedlist=fdi.getAllFeedBack();
		if(feedlist!=null && !(feedlist.isEmpty()))
		{
			session.setAttribute("feedback", feedlist);
			resp.sendRedirect("Feedbacklist.jsp");
		}
		else
		{
			resp.sendRedirect("Fail.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		String action=req.getParameter("action");
		if(action!=null && action.equals("SaveFeedback")) {
			
		
		String Name=req.getParameter("customername");
		
		String EmailId=req.getParameter("cuemailId");
		
		String Feedback=req.getParameter("cufeed");
		
		String Review=req.getParameter("cureview");
		
		FeedBack feedback=new FeedBack(Name,EmailId,Feedback,Review);
		boolean b=fdi.addFeedback(feedback);
		if(b) {
			resp.sendRedirect("Success.jsp");
		}
		else {
			resp.sendRedirect("Fail.jsp");
		}
	}
	}

}
