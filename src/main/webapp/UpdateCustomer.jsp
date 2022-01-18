<%@page import="com.foodplaza.pojo.Customer"%>
<%@page import="com.foodplaza.dao.CustomerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validate(){
	
	emailId=document.getElementById("eid").value
	if(emailId==""){
		document.getElementById("eidError").innerHTML="Enter customer email"
		return false
	}
	
	customerName=document.getElementById("cname").value
	if(customerName==""){
		document.getElementById("cnameError").innerHTML="Enter customer name"
		return false
	}
	
	password=document.getElementById("cpass").value
	if(password==""){
		document.getElementById("cpassError").innerHTML="Enter password"
		return false
	}
	
	contactNumber=document.getElementById("cno").value
	if(contactNumber==""){
		document.getElementById("cnoError").innerHTML="Enter customer contact number"
		return false
	}
	
	address=document.getElementById("cadd").value
	if(address==""){
		document.getElementById("caddError").innerHTML="Enter customer Address"
		return false
	}
	
	
	return true;
	
}
</script>
<body>

<jsp:include page="Header.jsp" ></jsp:include>
<%
   String emailId=request.getParameter("emailId");
CustomerDaoImpl cdi=new CustomerDaoImpl();
Customer customer=cdi.searchCustomerByEmail(emailId);
  


%>

<form action="customer" method="post" onsubmit="return validate()">
<table>
<caption>UpdateCustomer</caption>
<tr>
  <td>Enter existing EmailId</td>
  <td><input type="text" id="eid" name="emailId" value=<%=customer.getEmailId() %>></td>
  <td><span id="eidError" style="color :red ;"></span></td>
</tr>

<tr>
  <td>CustomerName</td>
  <td><input type="text" id="cname" name="customerName" value=<%=customer.getCust_name() %>></td>
  <td><span id="cnameError" style="color :red ;"></span></td>
</tr>

<tr>
  <td>Password</td>
  <td><input type="text" id="cpass" name="password" value=<%=customer.getPassword() %>></td>
  <td><span id="cpassError" style="color :red ;"></span></td>
</tr>

<tr>
  <td>ContactNumber</td>
  <td><input type="text" id="cno" name="contactNumber" value=<%=customer.getContactNo() %>></td>
  <td><span id="cnoError" style="color :red ;"></span></td>
</tr>

<tr>
  <td>Address</td>
  <td><input type="text" id="cadd" name="address" value=<%=customer.getAddress() %>></td>
  <td><span id="caddError" style="color :red ;"></span></td>
</tr>
</table>
<input type="submit" name="action" value="UpdateCustomer">
 <input type="reset" value="clear">
</form>
<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>