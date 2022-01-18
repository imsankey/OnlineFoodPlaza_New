<%@page import="com.foodplaza.pojo.Food"%>
<%@page import="com.foodplaza.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddCart</title>
<script type="text/javascript">
function validate()
{
	custemail=document.getElementById("cmail").value
	if(custemail=="")
		{
		  document.getElementById("cmailError").innerHTML="Enter the EmailId"
		  return false
		}
	foodid=document.getElementById("fid").value
	if(foodid=="")
		{
		  document.getElementById("fidError").innerHTML="Enter the foodId"
		  return false
		}
	
	foodname=document.getElementById("fname").value
	if(foodname=="")
		{
		  document.getElementById("fnameError").innerHTML="Enter the foodname"
		  return false
		}
	
	foodPrice=document.getElementById("fprice").value
	if(foodPrice=="")
		{
		  document.getElementById("fpriceError").innerHTML="Enter the foodPrice"
		  return false
		} 
	
	foodQuantity=document.getElementById("fqty").value
	if(foodQuantity=="")
		{
		  document.getElementById("fqtyError").innerHTML="Enter the food Quantity"
		  return false
		} 
	
	TotalPrice=document.getElementById("ftprice").value
	if(TotalPrice=="")
		{
		  document.getElementById("ftpriceError").innerHTML="Enter the Total Price"
		  return false
		} 
return true;
}

</script>
</head>
<body>
<jsp:include page="Header.jsp" ></jsp:include>
<%
int foodId=Integer.parseInt(request.getParameter("foodId"));
FoodDaoImpl fdi=new FoodDaoImpl();
Food food=fdi.searchFoodById(foodId);
String customerEmailId=(String)session.getAttribute("user"); 

%>

<form action="cart" method="post" onsubmit="return validate()">

<table>
<caption>AddToCart</caption>



<tr>
<td>FoodId</td>
<td><input type="text" id="fid" name="foodId" value="<%=food.getFoodId()%>"></td>
<td><span id="fidError" style="color:red"></span></td>
</tr>

<tr>
<td>FoodName</td>
<td><input type="text" id="fname" name="foodname" value="<%=food.getFoodName() %>"></td>
<td><span id="fnameError" style="color:red"></span></td>
</tr>

<tr>
<td>EmailId</td>
<td><input type="text" id="cmail" name="emailId" value=<%=customerEmailId %>></td>
<td><span id="cmailError" style="color:red"></span></td>
</tr>

<tr>
<td>Price</td>
<td><input type="text" id="fprice" name="foodPrice" value="<%=food.getPrice() %>"></td>
<td><span id="fpriceError" style="color:red"></span></td>
</tr>

<tr>
<td>Quantity</td>
<td><input type="text" id="fqty" name="foodQuantity"></td>
<td><span id="fqtyError" style="color:red"></span></td>
</tr>

<tr>
<td>TotalPrice</td>
<td><input type="text" id="ftprice" name="TotalPrice" ></td>
<td><span id="ftpriceError" style="color:red"></span></td>
</tr>

</table>
<input type="submit" name="addCustomer" value="SaveCart"/>
<input type="reset" value="Clear">

</form>
<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>
