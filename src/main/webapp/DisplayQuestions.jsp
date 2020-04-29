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
<style>
body {
	background-image: url('assets/images/bg22.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</style>
<body>
<% HttpSession sess = request.getSession();
int categoryid = (Integer) sess.getAttribute("Category_Id");
%>
<center>
		<br /></br>
		<h1
			style="color: white; font-size: 35px; font-family: courier; text-align: centre;">
			<b>INTERVIEW QUESTIONS - </b> <a href="AddQuestion.jsp?categoryid=<%=categoryid%>"><button
					type="button" class="btn btn-primary">ADD_QUESTION</button></a>
		</h1>
	</center>
	<br />
	<%
		List<Question> list = (List<Question>) request.getAttribute("QUESTION");
	%>
	<center>
		<div class="row row-cols-1 row-cols-md-4">
			<%
				for (Question q : list) {
			%>
			<div class="col mb-4">
           <div class="card border-dark h-100">
			<div class="card-body">
					<div class="card-body text-dark">
						<h4 class="card-title"><%=q.getQuestion()%></h4>
					</div>
				</div>
				<div class="card-footer bg-transparent border-dark">
					<a href="AddAnswer.jsp?questionid=<%=q.getQuestionId()%>"
						class="btn btn-danger">ADD_ANSWER</a>
				</div>
				</br>
			</div>
			</div>
			<%
				}
			%>
		</div>
	</center>
</body>
</html>