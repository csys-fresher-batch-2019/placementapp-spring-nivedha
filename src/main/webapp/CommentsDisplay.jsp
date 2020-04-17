<%@page import="com.chainsys.trainingplacementapp.domain.CommentsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
	html,body{
			height: 100%;
		}
       .container{
       	height: 30%;
       	align-content: center;
       }

       .image_outer_container{
       	margin-top: auto;
       	margin-bottom: auto;
       	border-radius: 50%;
       	position: relative;
       }

       .image_inner_container{
       	border-radius: 50%;
       	padding: 5px;
        background: #833ab4; 
        background: -webkit-linear-gradient(to bottom, #fcb045, #fd1d1d, #833ab4); 
        background: linear-gradient(to bottom, #fcb045, #fd1d1d, #833ab4);
       }
       .image_inner_container img{
       	height: 200px;
       	width: 200px;
       	border-radius: 50%;
       	border: 5px solid white;
       }

       /* .image_outer_container .green_icon{
         background-color: #4cd137;
         position: absolute;
         right: 30px;
         bottom: 10px;
         height: 30px;
         width: 30px;
         border:5px solid white;
         border-radius: 50%;
       } */

p.a {
  font-family: "Times New Roman", Times, serif;
  font-weight: bold;
}

.checked {
	color: red;
}

.left {
	float: left;
	padding-left: 10px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 20px;
}
</style>
<body style='background-color: "#F7F9F9";'>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="Index.jsp"><h5>STUDENT SUCCESS</h5></a>
	</nav>
	</br>
	</br>
	<%
			List<CommentsDTO> list = (List<CommentsDTO>) request.getAttribute("COMMENTS");

			for (CommentsDTO c : list) {
		%>
	<div class="row">
		<div class="card" style="width: 27rem;">
		</br>
		<div class="container">
		<div class="d-flex justify-content-center h-50">
			<div class="image_outer_container">
				<div class="green_icon"></div>
				<div class="image_inner_container">
				 <%
					if (c.getProfile() == null) {
							if ("female".equals(c.getGender())) {
				%>
				<img src="assets/images/studentprofile/female.png">
				
				<%
					} else {
				%>
				<img src="assets/images/studentprofile/male.png">
				<%
					}
						} else {
				%>
				<img src="assets/images/studentprofile/<%=c.getProfile()%>">
				<%} %>
				</div>
			</div>
		</div>
	</div>		<div class="card-body">
				<center>

					<c:set var="userName" value="<%=c.getUserName()%>" />
					<c:set var="userName1" value="${fn:toUpperCase(userName)}" />
					<h3 class="card-title"><p class="a">${userName1}</p></h3>

					<h5 class="card-title">
						<%
							int ratings = c.getInstitutionRating();
						%>
						<jsp:include page="Rating.jsp">
							<jsp:param value="<%=ratings%>" name="rating" />
						</jsp:include>
					</h5>
					</br>

					<button type="button" class="btn btn-primary">
						<h6><%=c.getCourseName()%></h6>
					</button>

					<div class="card-body">
						<ul class="list-group list-group-flush">
							<p class="card-text"><%=c.getCourseComments()%></p>

							<c:set var="createdDate" value="<%=c.getCreatedDate()%>" />
							<fmt:parseDate value="${createdDate}"
								pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<li class="list-group-item"><p>
									<small class="text-muted">Last updated</br>
									<fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss a"
											value="${ parsedDateTime }" /></small>
								</p>
						</ul>
					</div>
			</div>
			</center>
		</div>
		<%
			}
		%>
	</div>
</body>
</html>