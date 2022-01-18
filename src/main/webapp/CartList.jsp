<%@page import="java.util.Iterator"%>
<%@ page language="java" import="com.foodplaza.pojo.Cart,java.util.List" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp" ></jsp:include>
<table border="1">
<caption>CartList</caption>
<tr>
<th>cartId</th>
<th>foodId</th>
<th>foodName</th>
<th>foodPrice</th>
<th>Quantity</th>
<th>TotalPrice</th>
<th>emailId</th>

</tr>

<%
List<Cart> cartList=(List)session.getAttribute("carts");
Iterator<Cart> it=cartList.iterator();
while(it.hasNext()){
	Cart cart=it.next();


%>

<tr>
<td><%= cart.getCartId() %></td>
<td><%= cart.getFoodId() %></td>
<td><%= cart.getFoodName() %></td>
<td><%= cart.getFoodPrice() %></td>
<td><%= cart.getQuantity() %></td>
<td><%= cart.getTotalprice() %></td>
<td><%= cart.getEmailId() %></td>
<td><a href="cart?action=delete&cartId=<%= cart.getCartId()%>">delete</a></td>

</tr>


<%}%>
</table>


<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>