<%@page import="java.util.List"%>
<%@page
	import="com.chainsys.trainingplacementapp.domain.QuestionCategory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Categories</title>
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
	<center>
		<br /></br>
		<h1
			style="color: white; font-size: 35px; font-family: courier; text-align: centre;">
			<b>INTERVIEW QUESTION CATEGORIES - </b> <a href="AddCategory.jsp"><button
					type="button" class="btn btn-primary">ADD_CATEGORY</button></a>
		</h1>
	</center>
	<br />
	<%
		List<QuestionCategory> list = (List<QuestionCategory>) request.getAttribute("CATEGORY");
	%>
	<center>
		<div class="row row-cols-1 row-cols-md-4">
			<%
				for (QuestionCategory c : list) {
			%>
			<div class="col mb-4">
           <div class="card border-dark h-100">
			<div class="card-body">
					<div class="card-body text-dark">
						<h4 class="card-title"><%=c.getCategoryName()%></h4>
					</div>
				</div>
				<div class="card-footer bg-transparent border-dark">
					<a href="DisplayQuestionsServ?categoryid=<%=c.getCategoryId()%>"
						class="btn btn-danger">ADD_QUESTIONS</a>
				</div>
				</br>
			</div>
			</div>
			<% HttpSession ses=request.getSession();
ses.setAttribute("categoryid", c.getCategoryId());
%>
			<%
				}
			%>
		</div>
	</center>
</body>
</html>