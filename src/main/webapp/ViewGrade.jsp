<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.trainingplacementapp.dao.impl.GradeDAOImpl" %>
        <%@ page import="com.chainsys.trainingplacementapp.domain.Grade" %>
            <%@ page import="java.util.List" %>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Grade Details</title>

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

<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">GRADE DETAILS</h1>
<%
GradeDAOImpl impl=new GradeDAOImpl();
List<Grade> list=(List <Grade>)request.getAttribute("view_grade");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">MINIMUM MARKS</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">MAXIMUM MARKS</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">INTERVIEW STATUS</h1></th>
</tr>
</thead>

<% for(Grade g:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=g.getMinMarks()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=g.getMaxMarks()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=g.getStatus()%></h1></td>
</tr>
<%} %>
</table>
<br/>
<a href="ChangeGrade.jsp">
<p style="color:white; font-size:20px; font-family:courier;text-align:center;"><button type="submit" >CHANGE MARKS</button><br></br>
</a>
<a href="Admin.jsp">
<p style="color:white; font-size:20px; font-family:courier;text-align:center;"><button type="submit" >HOME</button><br></br>
</a>

</body>
</html>