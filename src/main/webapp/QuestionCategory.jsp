<%@page import="com.chainsys.trainingplacementapp.domain.QuestionCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Interview Questions</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<style>
body {
  background-color: #F0F0F0;
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<br/>
<center>

		<h1 style="color: #cc0000; font-size: px; font-family: courier;"><b>INTERVIEW QUESTIONS CATEGORY</b></h1>
		<br />
	</center>
	<%
		List<QuestionCategory> list = (List<QuestionCategory>) request.getAttribute("QUESTION_CATEGORY");
		for (QuestionCategory qc : list) {
	%>
<center>
<div class="card w-50">
  <div class="card-body">
    <h3 class="card-title"><%=qc.getCategoryName()%></h3>
    <a href="QuestionServ?Category_id=<%=qc.getCategoryId()%>" class="btn btn-danger">Get In</a>
  </div>
</div>
</center>
<br/>
<%} %>
</body>
</html>