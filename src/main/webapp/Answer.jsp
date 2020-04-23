<%@page import="com.chainsys.trainingplacementapp.domain.Answer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ANSWERS</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<body>
<br/>
<center>
		<h1 style="color: #cc0000; font-size: px; font-family: courier;"><b>INTERVIEW QUESTION AND ANSWER</b></h1>
		<br />
	</center>
<%
		List<Answer> list = (List<Answer>) request.getAttribute("ANSWERS");
		for (Answer a : list) {
	%>
	<br/>

<div class="card w-75">
  <div class="card-body">
  <ul class="list-group list-group-flush">
    <h3 class="card-title"><%=a.getQuestion()%></h3>
     <li class="list-group-item">
     <p class="card-text"><%=a.getAnswer()%></p>
  </li>
  </ul>
  </div>
</div>
<br/>
	<%}%>

</body>
</html>