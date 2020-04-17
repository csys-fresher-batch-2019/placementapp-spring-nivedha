<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.chainsys.trainingplacementapp.domain.Registration" %>
            <%@ page import="java.util.List" %>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details</title>
</head>
<style>
/* img {
  border-radius: 50%;
} */
body {
  background-image: url('assets/images/bg22.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<form action="ViewAllUsersServ">
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">STUDENT DETAILS</h1>
<%
List<Registration> list=(List <Registration>)request.getAttribute("Student_Details");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Profile</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User_Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">User_Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Password</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Email_Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Mobile_No</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Qualification</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Gender</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">City</h1></th>
</tr>
</thead>

<% for(Registration r:list)
{%>
<tr>
				<%
					if (r.getProfile() == null) {
							if ("female".equals(r.getGender())) {
				%>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;">
						<img src="assets/images/studentprofile/female.png" alt=""
							width="100" height="100">
					</h1></td>
				<%
					} else {
				%>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;">
						<img src="assets/images/studentprofile/male.png" alt=""
							width="100" height="100">
					</h1></td>

				<%
					}
						} else {
				%>
				<td><h1
						style="color: white; font-size: 20px; font-family: courier; text-align: centre;">
						<img src="assets/images/studentprofile/<%=r.getProfile()%>" alt=""
							width="100" height="100">
					</h1></td>
				<%} %>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getUserId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getUserName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getUserPassword()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getMailId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getMobileNo()%></h1>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getQualification()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getGender()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=r.getUserCity()%></h1></td>
</tr>
<%} %>
</table>
</form>
</body>
</html>