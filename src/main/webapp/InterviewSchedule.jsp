<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="com.chainsys.trainingplacementapp.dao.impl.InterviewScheduleDAOImpl" %>
        <%@ page import="com.chainsys.trainingplacementapp.domain.InterviewSchedule" %>
            <%@ page import="java.util.List" %>
             <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interview Schedule</title>
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



<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">INTERVIEW SCHEDULES</h1>
<%
InterviewScheduleDAOImpl impl=new InterviewScheduleDAOImpl();
List<InterviewSchedule> list=(List <InterviewSchedule>)request.getAttribute("interview_schedule");
Integer noOfCourses = (Integer)request.getAttribute("NO_OF_COURSES_ENROLLED");

%>
<% if ( noOfCourses == 0) { %>
<font color="red">Note: You should complete minimum course to be eligible to attend interview.
</font>
<%} %>
<table border="1">
<thead>
<tr>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Interview_Id</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Client_Id</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Job_Title</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Job_Requirement</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Interview_Date</h1></th>
<th><h1 style="color:blue; font-size:25px; font-family:courier; text-align:centre;">Interview_Time</h1></th>
</tr>
</thead>

<% 
for(InterviewSchedule i:list)
{		
%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getInterviewId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getClientId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getJobTitle()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getJobRequirement()%></h1></td>

<c:set var="interviewDate" value="<%=i.getInterviewDate()%>"/>
<fmt:parseDate var="parsedInterviewDate" value="${interviewDate}" type="date" pattern="yyyy-MM-dd"/>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${parsedInterviewDate}" /></h1></td>

<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=i.getInterviewTime()%></h1></td>
<td> <% if ( noOfCourses > 0) { %>
<a href="AttendInterviewServ?Client_id=<%=i.getClientId()%>" >
<h1 style="color:red; font-size:20px; font-family:courier;text-align:centre;">ATTEND</a>
<%} %>
</td>
</tr>
<%} %>
</table>
<br/>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">
<a href="Index.jsp">Home</a></h1>
</body>
</html>