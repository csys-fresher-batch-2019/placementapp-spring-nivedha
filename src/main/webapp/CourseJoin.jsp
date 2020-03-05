<%@page import="com.chainsys.trainingplacementapp.domain.UserCourse"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>COURSE JOIN</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
</a>
<form action="CourseEnrollmentServ">
<% HttpSession sess=request.getSession(false);
UserCourse userCourse = (UserCourse)session.getAttribute("userCourse");
%>
<center>
<br/>
<br/>
<br/>
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">USER COURSE DETAILS</h1>
<div class="col">
<div class="card" style="width: 25rem;">
<div class="card-body">
<h5 class="card-title"></h5>
<span class="btn btn-primary">      USER ID:   <%=userCourse.getUserId()%></span><br></br>
<span class="btn btn-primary">    COURSE ID:   <%=userCourse.getCourseId()%></span><br></br>
<span class="btn btn-primary">   START DATE:   <%=userCourse.getStartDate()%></span><br></br>
<span class="btn btn-primary">COMPLETE DATE:   <%=userCourse.getCompletionDate()%></span><br></br>
<span class="btn btn-primary"> TOTAL AMOUNT:   <%=userCourse.getTotalAmount()%></span>
<br></br>
<a href="CourseEnrollmentServ">
<button type="button" class="btn btn-danger">JOINED</button>
</a>
</div>
</div>
</div>
</center>
</form>
</body>
</html>