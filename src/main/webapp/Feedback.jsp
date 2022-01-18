<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feedback</title>
<script type="text/javascript">
function validate()
{
	customername=document.getElementById("cname").value
	if(customername=="")
		{
		document.getElementById("cnameError").innerHTML="Enter the customer name"
		return false
		
		}
	
	cuemailId=document.getElementById("emailId").value
	if(cuemailId=="")
		{
		document.getElementById("cemailError").innerHTML="Enter the EmailId"
		return false
		
		}
	
	cufeed=document.getElementById("feedback").value
	if(cufeed=="")
		{
		document.getElementById("cfeedError").innerHTML="Enter the feedback"
		return false
		
		}
	
	cureview=document.getElementById("review").value
	if(cureview=="")
		{
		document.getElementById("creviewError").innerHTML="Enter the review"
		return false
		
		}
	
	return true;
	
}


</script>
</head>
<body>
<jsp:include page="Header.jsp" ></jsp:include>
<form action="feedback" method="post" onsubmit="return validate()">
<table>
<caption>AddFeedback</caption>
<tr>
<td>CustName</td>
<td><input type="text" id="cname" name="customername"></td>
<td><span id="cnameError" style="color:red"></span></td>
</tr>
<tr>
<td>CustEmailId</td>
<td><input type="text" id="emailId" name="cuemailId"></td>
<td><span id="cemailError" style="color:red"></span></td>
</tr>
<tr>
<td>CustomerFeedback</td>
<td><input type="text" id="feedback" name="cufeed"></td>
<td><span id="cfeedError" style="color:red"></span></td>
</tr>
<tr>
<td>CustomerReview</td>
<td><input type="text" id="review" name="cureview"></td>
<td><span id="creviewError" style="color:red"></span></td>
</tr>


</table>
<input type="submit" name="action" value="SaveFeedback">
<input type="reset" value="Clear">

</form>


<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>