<%@page import="com.foodplaza.pojo.Food"%>
<%@page import="com.foodplaza.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
	foodId=document.getElementById("fid").value
	if(foodId==""){
		document.getElementById("fidError").innerHTML="Enter food Id"
		return false
	
}
	foodname=document.getElementById("fname").value
	if(foodname==""){
		document.getElementById("fnameError").innerHTML="Enter food name"
		return false
	}
	
	foodType=document.getElementById("ftype").value
	if(foodType==""){
		document.getElementById("ftypeError").innerHTML="Enter food Type"
		return false
	}
	
	foodcategory=document.getElementById("fcat").value
	if(foodcategory==""){
		document.getElementById("fcatError").innerHTML="Enter food category"
		return false
	}
	
	fooddescription=document.getElementById("fdesc").value
	if(fooddescription==""){
		document.getElementById("fdescError").innerHTML="Enter food description"
		return false
	}
	
	foodimage=document.getElementById("fImage").value
	if(foodimage==""){
		document.getElementById("imageError").innerHTML="Enter food image"
		return false
	}
	
	foodprice=document.getElementById("fprice").value
	if(foodprice==""){
		document.getElementById("priceError").innerHTML="Enter food price"
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

%>>
<form action="food" method="post" onsubmit="return validate()">
<table >
<caption>UpdateFood</caption>
  <tr>
    <td>FoodID</td>
    <td><input type="text" id="fid" name="foodId" value="<%=food.getFoodId() %>" ></td>
    <td><span id="fidError" style="color :red ;"></span></td>
  </tr>
  
  <tr>
    <td>FoodName</td>
    <td><input type="text" id="fname" name="foodname" value="<%=food.getFoodName() %>"></td>
    <td><span id="fnameError" style="color :red ;"></span></td>
  </tr>
  
  <tr>
    <td>FoodType</td>
    <td><input type="text" id="ftype" name="foodtype" value="<%=food.getFoodType() %>" ></td>
    <td><span id="ftypeError" style="color :red ;"></span></td>
  </tr>
  
  <tr>
    <td>FoodCategory</td>
    <td><input type="text" id="fcat" name="foodcat" value="<%=food.getFoodCat() %>"></td>
    <td><span id="fcatError" style="color :red ;"></span></td>
  </tr>
  
  <tr>
       <td>FoodDescription</td>
       <td><input type="text" id="fdesc" name="fooddesc" value="<%=food.getFoodDesc() %>"></td>
       <td><span id="fdescError" style="color: red ;"></span></td>   
   </tr>
   
   <tr>
       <td>FoodImage</td>
       <td><input type="text" id="fImage" name="foodimage" value="<%=food.getFoodImage() %>"></td>
       <td><span id="imageError" style="color: red ;"></span></td>   
    </tr>
    
    <tr>
       <td>FoodPrice</td>
       <td><input type="text" id="fprice" name="foodPrice" value="<%=food.getPrice() %>"></td>
       <td><span id="priceError" style="color: red ;"></span></td>   
    </tr>
    
    
</table>

<input type="submit" name="action" value="SaveupdateFood" />
 <input type="reset" value="clear">

</form>
<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>