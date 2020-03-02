<%@page import="com.chainsys.trainingproject.model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Details</title>
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
<center>
<h1 style="color:white; font-size:25px; font-family:courier;">COURSE DETAILS</h1><br/>
</center>
<%
List<Course> list = (List<Course>) request.getAttribute("COURSE_LIST");

for(Course c : list)
{%>
<center>
<div class="col">
<div class="card" style="width: 25rem;">
<img src="assets/images/<%=c.getCourseImage()%>" class="card-img-top" alt="...">
<div class="card-body">
<h5 class="card-title"><span class="btn btn-light btn-sm">Course Name: <%=c.getCourseName() %></span></p> </h5>
<p class="card-text">
<span class="btn btn-light btn-sm">Course Id: <%=c.getCourseId()%></span></p>
<span class="btn btn-light btn-sm">Course Duration: <%=c.getCourseDuration() %></span></p>
<span class="btn btn-light btn-sm">Course Fees: <%=c.getCourseFees() %> </span>
<br></br>
<a href="assets/pdf/<%=c.getCoursePdf() %>" class="btn btn-primary">Syllabus</a><br></br>
<a href="CourseJoinServ">
<button type="button" class="btn btn-danger">JOIN</button>
</a>
<% 
HttpSession s=request.getSession();
s.setAttribute("courseid", c.getCourseId());
}%>


</center>
</div>
</div>
</div>

</body>
</html>