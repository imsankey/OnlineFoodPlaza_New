<%@page import="java.util.Iterator"%>
<%@page import="com.foodplaza.pojo.FeedBack"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<caption>FeedBackList</caption>
<tr>
<th>FeedbackId</th>
<th>Name</th>
<th>EmailId</th>
<th>Feedback</th>
<th>Review</th>

</tr>
<%
List<FeedBack> feedlist=(List)session.getAttribute("feedback");
Iterator<FeedBack> it=feedlist.iterator();
while(it.hasNext()){
	FeedBack feed=it.next();


%>
<tr>
<td><%=feed.getFeedbackId() %></td>
<td><%=feed.getCustomername() %>
<td><%=feed.getEmailId() %></td>
<td><%=feed.getFeedback() %></td>
<td><%=feed.getRview() %>

</tr> 
<%} %>
</table>

<jsp:include page="Footer.jsp" ></jsp:include>
</body>
</html>