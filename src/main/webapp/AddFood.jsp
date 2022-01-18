<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
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
<form action="food" method="post" onsubmit="return validate()">
 <table>
    <caption>AddFood</caption>
    
    <tr>
       <td>FoodName</td>
       <td><input type="text" id="fname" name="foodname"></td>
       <td><span id="fnameError" style="color: red ;"></span></td>   
    </tr>
    <tr>
       <td>FoodType</td>
       <td><input type="text" id="ftype" name="foodtype"></td>
       <td><span id="ftypeError" style="color: red ;"></span></td>   
    </tr>
    
    <tr>
       <td>FoodCategory</td>
       <td><input type="text" id="fcat" name="foodcat"></td>
       <td><span id="fcatError" style="color: red ;"></span></td>   
    </tr>
    <tr>
       <td>FoodDescription</td>
       <td><input type="text" id="fdesc" name="fooddesc"></td>
       <td><span id="fdescError" style="color: red ;"></span></td>   
    </tr>
    <tr>
       <td>FoodImage</td>
       <td><input type="text" id="fImage" name="foodimage"></td>
       <td><span id="imageError" style="color: red ;"></span></td>   
    </tr>
    <tr>
       <td>FoodPrice</td>
       <td><input type="text" id="fprice" name="foodPrice"></td>
       <td><span id="priceError" style="color: red ;"></span></td>   
    </tr>
 
 
 </table>
 <input type="submit" name="action" value="FoodSave">
 <input type="reset" value="clear">

</form>

<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>