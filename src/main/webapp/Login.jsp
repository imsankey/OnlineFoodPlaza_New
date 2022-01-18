<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function validate(){
	
	username=document.getElementById("uid").value
	if(username==""){
		document.getElementById("uidError").innerHTML="Enter username"
		return false
	}
	
	password=document.getElementById("pass").value
	if(password==""){
		document.getElementById("passError").innerHTML="Enter password"
		return false
	}
	
	return true;
}

</script>
</head>
<body>
<jsp:include page="Header.jsp" ></jsp:include>

<form action="login" method="post" onsubmit="return validate()">
<table>
<caption>Login</caption>
<tr>
<td>Select:</td>
<td><select name="type">
     <option select disabled>--------select--------</option>
     <option value="admin">Admin</option>
     <option value="user">User</option>


</select></td>

</tr>
<tr>
    <td>Enter Username</td>
    <td><input type="text" id="uid" name="username"></td>
    <td><span id="uidError" style="color :red ;"></span></td>
</tr>

<tr>
    <td>Enter Password</td>
    <td><input type="text" id="pass" name="password"></td>
    <td><span id="passError" style="color :red ;"></span></td>
</tr>
</table>

<input type="submit" name="action" value="Login" />
<input type="reset" value="clear">
 

 
</form>
<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>