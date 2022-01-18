<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ChangePassword</title>
<script type="text/javascript">
function validate()
{
	username=document.getElementById("uname").value
	if(username=="")
		{
		  document.getElementById("unameerror").innerHTML="Enter the username"
		  return false
		}
	
	newpass=document.getElementById("npass").value
	if(newpass=="")
		{
		  document.getElementById("npasserror").innerHTML="Enter the new password"
		  return false
		}
	
	confirmpass=document.getElementById("cpass").value
	if(confirmpass=="")
		{
		  document.getElementById("cpasserror").innerHTML="Enter the confirm password"
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
<td>User Name:</td>
<td><input type="text" id="uname" name="username"></td>
<td><span id="unameerror" style="color:red"></span></td>
</tr>

<tr>
<td>New Password:</td>
<td><input type="text" id="npass" name="newpass"></td>
<td><span id="npasserror" style="color:red"></span></td>
</tr>

<tr>
<td>Confirm Password:</td>
<td><input type="text" id="cpass" name="confirmpass"></td>
<td><span id="cpasserror" style="color:red"></span></td>
</tr>

</table>

<input type="submit" name="action" value="changepassword">
<input type="reset" value="Reset">
</form>

<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>
    