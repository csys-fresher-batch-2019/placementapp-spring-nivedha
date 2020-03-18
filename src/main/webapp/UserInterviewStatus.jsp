<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.trainingplacementapp.dao.impl.InterviewPerformanceDAOImpl" %>
        <%@ page import="com.chainsys.trainingplacementapp.domain.InterviewPerformance" %>
            <%@ page import="java.util.List" %>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Status</title>
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

<form action="SearchByStatusServ" autocomplete="off">
<div style="text-align:center">
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">SEARCH BY STATUS</h1>
<p style="color:white; font-size:20px; font-family:courier;text-align:centre;"><input type="text" name="status"><button type="submit">SEARCH</button>
</p>
</div>
</form>
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">INTERVIEW DETAILS</h1>
<%
InterviewPerformanceDAOImpl impl=new InterviewPerformanceDAOImpl();
List<InterviewPerformance> list=(List <InterviewPerformance>)request.getAttribute("interviewstatus");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Interview Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Client Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Interview Marks</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Interview Status</h1></th>
</tr>
</thead>

<% for(InterviewPerformance i:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getPerformId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getClientId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getUserId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getMarks()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getInterviewStatus()%></h1>
<td><a href="UpdateInterviewStatus.jsp?interviewid=<%=i.getPerformId()%>">
<h1 style="color:red; font-size:20px; font-family:courier; text-align:centre;">UPDATE</a>
</tr>
<% HttpSession ses=request.getSession();
ses.setAttribute("interviewid", i.getPerformId());
%>
<%} %>
</table>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">
<a href="Admin.jsp">Home</a></h1>
</body>
</html>