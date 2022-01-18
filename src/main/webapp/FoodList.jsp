<%@page import="java.util.Iterator" %>
<%@ page language="java" import="com.foodplaza.pojo.Food,java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp" ></jsp:include>
<% 
   String customerEmailId=(String)session.getAttribute("user"); 
   String adminEmailId=(String)session.getAttribute("admin");

%>
<form action="food">



Enter the food name:<input type="text" name="foodName" >
<input type="submit" name="action" value="search"><br><br>

<!-- Enter the food Category:<input type="text" name="foodCat" >
<input type="submit" name="action" value="searchByCategory"><br><br>

Enter the food Type:<input type="text" name="foodType" >
<input type="submit" name="action" value="searchByType"> -->

</form>

<table border="1">
<caption>Foods</caption>
<tr>
<th>FoodId</th>
<th>Name</th>
<th>Type</th>
<th>Category</th>
<th>Description</th>
<th>Image</th>
<th>Price</th>

<%if(adminEmailId!=null && customerEmailId==null){ %>
<th colspan="2">Action</th>
<%} %>

<%if(adminEmailId==null && customerEmailId!=null){ %>
<th>Action</th>
<%} %>
</tr>

<%
List<Food> foodList=(List)session.getAttribute("foods");
Iterator<Food> it=foodList.iterator();
while(it.hasNext()){
	Food food=it.next();
%>
<tr>
<td><%= food.getFoodId() %></td>
<td><%= food.getFoodName() %></td>
<td><%= food.getFoodType() %></td>
<td><%= food.getFoodCat() %></td>
<td><%= food.getFoodDesc() %></td>
<td><%= food.getFoodImage() %></td>
<td><%= food.getPrice() %></td>
<%if(adminEmailId!=null && customerEmailId==null){ %>

<td><a href="UpdateFood.jsp?foodId=<%=food.getFoodId()%>">edit</a></td>
<td><a href="food?action=delete&foodId=<%=food.getFoodId()%>">delete</a></td>

<%} %>
<%if(adminEmailId==null && customerEmailId!=null){ %>

<td><a href="AddCart.jsp?foodId=<%=food.getFoodId()%>">AddToCArt</a></td>
<%} %>

</tr>




<%}%>
</table>

<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>