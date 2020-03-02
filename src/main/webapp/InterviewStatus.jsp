<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.trainingproject.dao.impl.JoinDAOImpl" %>
        <%@ page import="com.chainsys.trainingproject.model.JoinUserCompany" %>
            <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interview Status</title>
</head>
<style>
body {
  background-image: url('assets/images/bg22.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>

<%
JoinDAOImpl impl=new JoinDAOImpl();
List<JoinUserCompany> list=(List<JoinUserCompany>)request.getAttribute("Interview_Status");
%>
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">USER INTERVIEW STATUS</h1>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">USER ID</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">USER NAME</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">COMPANY ID</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">COMPANY NAME</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">MARKS</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">INTERVIEW STATUS</h1></th>
</tr>
</thead>

<%  for(JoinUserCompany j:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getUserId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getUserName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getClientId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getCompanyName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getMarks()%></h1>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getInterStatus()%></h1></td>
</tr>
<%} %>
</table>
<br/>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">
<a href="Index.jsp">Home</a></h1>
</body>
</html>