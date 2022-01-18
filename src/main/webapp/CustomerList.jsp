<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" import="com.foodplaza.pojo.Customer,java.util.List" contentType="text/html; charset=ISO-8859-1"
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
<caption>Customer</caption>
<tr>
<th>emailId</th>
<th>cust_name</th>
<th>password</th>
<th>contactNo</th>
<th>address</th>
</tr>
<%
List<Customer> customerList=(List)session.getAttribute("customer");
Iterator<Customer> it=customerList.iterator();
while(it.hasNext()){
	Customer customer=it.next();

%>
<tr>
<td><%= customer.getEmailId() %></td>
<td><%= customer.getCust_name() %></td>
<td><%= customer.getPassword() %></td>
<td><%= customer.getContactNo() %></td>
<td><%= customer.getAddress() %></td>
<td><a href="UpdateCustomer.jsp?emailId=<%=customer.getEmailId()%>">edit</a> </td>
<td><a href="customer?action=delete&emailId=<%=customer.getEmailId()%>">delete</a></td>

</tr>


<%} %>
</table>
<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>