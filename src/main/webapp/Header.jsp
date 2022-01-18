<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<% String customerEmailId=(String)session.getAttribute("user"); 
   String adminEmailId=(String)session.getAttribute("admin");


%>
<div id="templatemo_container">
	<div id="templatemo_header">
    	<div id="site_title"></div>
    </div> <!-- end of header -->
    
    <div id="templatemo_menu">
        <ul>
        <%if(customerEmailId==null && adminEmailId==null){ %>
        <li ><a href="index.jsp"><b>Home</b></a></li>
        <li ><a href="food"><b>foodList</b></a></li>
        <li ><a href="Login.jsp"><b>Login</b></a></li>
        <li ><a href="#"><b>Contact</b></a></li>
        <li ><a href="CustomerRegister.jsp"><b>Registration</b></a></li>
        <%} %>
        
        <%if(customerEmailId!=null && adminEmailId==null){ %>
         <li ><a href="food"><b>foodList</b></a></li>
        <li ><a href="cart"><b>CartList</b></a></li>
        <li ><a href="Feedback.jsp"><b>AddFeedback</b></a></li>
        <li ><a href=""><b>EditProfile</b></a></li>	
        <li><a href="ChangePassword.jsp"><b>Changepassword</b></a></li> 
         <li ><a href="login"><b>Logout</b></a></li>
          
          <%} %> 
          
          <%if(customerEmailId==null && adminEmailId!=null){ %> 
            
            <li ><a href="food"><b>foodList</b></a></li>
            <li ><a href="AddFood.jsp"><b>AddFood</b></a></li>
            <li ><a href="customer"><b>CustomerList</b></a></li>
            <li><a href="ChangePassword.jsp"><b>Changepassword</b></a></li> 
            <li><a href="feedback"><b>FeedbackList</b></a></li> 
            <li><a href="login"><b>Logout</b></a></li>
            <%} %> 
       
            
            
            
            
            
            
        </ul>
    </div> <!-- end of menu -->

</body>
</html>