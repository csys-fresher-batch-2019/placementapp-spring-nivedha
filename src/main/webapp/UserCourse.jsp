<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.trainingplacementapp.dao.impl.UserCourseDAOImpl" %>
        <%@ page import="com.chainsys.trainingplacementapp.domain.UserCourseDTO" %>
            <%@ page import="java.util.List" %>
             <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Course Details</title>
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
<a href="Index.jsp">
<button type="button" class="btn btn-danger">HOME</button>
</a><form action="UserCourseServ">
<%
UserCourseDAOImpl impl=new UserCourseDAOImpl();
List<UserCourseDTO> list=(List <UserCourseDTO>)request.getAttribute("user_course");
int userId; 
HttpSession sess=request.getSession(false);
userId=Integer.parseInt((String) sess.getAttribute("userid"));
%>
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">USERCOURSE DETAILS</h1>
<br></br>
<h1 style="color:blue; font-size:20px; font-family:courier; text-align:centre;"><%=userId%> ENROLLMENT IS ADDED SUCCESSFULLY!!!</h1>
<br></br>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User_Course Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Course Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Start Date</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Complete Date</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Total Amount</h1></th>
</tr>
</thead>

<% for(UserCourseDTO uc:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=uc.getUserCourseId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=uc.getUserName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=uc.getCourseName()%></h1></td>

<c:set var="startDate" value="<%=uc.getStartDate()%>"/>
<fmt:parseDate var="parsedStartDate" value="${startDate}" type="date" pattern="yyyy-MM-dd"/>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${parsedStartDate}" /></h1></td>

<c:set var="completeDate" value="<%=uc.getCompletionDate()%>"/>
<fmt:parseDate var="parsedCompleteDate" value="${completeDate}" type="date" pattern="yyyy-MM-dd"/>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><fmt:formatDate pattern = "dd-MM-yyyy" value = "${parsedCompleteDate}" /></h1></td>

<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=uc.getTotalAmount()%></h1></td>
</tr>
<%} %>
</table>

</form>
</body>
</html>