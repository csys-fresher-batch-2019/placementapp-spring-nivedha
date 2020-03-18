<%@page import="com.chainsys.trainingplacementapp.dao.impl.JoinDAOImpl"%>
<%@page import="com.chainsys.trainingplacementapp.domain.UserCompanyDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

            <%@ page import="java.util.List" %>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VIEW STATUS</title>

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

<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">VIEW INTERVIEW STATUS</h1>
<%
	JoinDAOImpl impl=new JoinDAOImpl();
List<UserCompanyDTO> list=(List<UserCompanyDTO>)request.getAttribute("view_status");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Qualification</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">EMail Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Client Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Company Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Marks</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Interview Status</h1></th>
</tr>
</thead>

<%
	for(UserCompanyDTO j:list)
{
%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getUserId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getUserName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getQualification()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getMailId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getClientId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getCompanyName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getMarks()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=j.getInterviewStatus()%></h1></td>
</tr>
<%} %>
</table>
<br/>
<a href="Admin.jsp"><button type="submit">HOME</button></a>
</body>
</html>