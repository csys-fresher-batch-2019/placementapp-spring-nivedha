<%@page import="com.chainsys.trainingplacementapp.domain.Question"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Questions</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
<br/>
<center>
		<h1 style="color: #cc0000; font-size: px; font-family: courier;"><b>INTERVIEW QUESTIONS</b></h1>
		<br />
	</center>
<%
		List<Question> list = (List<Question>) request.getAttribute("QUESTIONS");
		for (Question q : list) {
	%>
	<br/>

<div class="card w-75">
  <div class="card-body">
  <ul class="list-group list-group-flush">
    <h3 class="card-title"><%=q.getQuestion()%></h3>
     <li class="list-group-item">
    <a href="AnswerServ?Question_id=<%=q.getQuestionId()%>" class="btn btn-danger">Show Answer</a>
  </li>
  </ul>
  </div>
</div>
<br/>
	<%}%>

</body>
</html>