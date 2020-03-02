<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.trainingproject.dao.impl.TrainerDAOImpl" %>
        <%@ page import="com.chainsys.trainingproject.model.Trainer" %>
            <%@ page import="java.util.List" %>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Trainer Details</title>
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
<form action="TrainerDetailsServ">
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">TRAINER DETAILS</h1>
<%
TrainerDAOImpl impl=new TrainerDAOImpl();
List<Trainer> list=(List <Trainer>)request.getAttribute("Trainer_Details");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Trainer Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Trainer Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Qualification</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Specialist</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Experience</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Email Id</h1></th>
</tr>
</thead>

<% for(Trainer t:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=t.getTrainerId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=t.getTrainerName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=t.getTrainerQualification()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=t.getTrainerSpecialist()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=t.getTrainerExperience()%></h1>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=t.getEmailId()%></h1></td>
</tr>
<%} %>
</table>
</form>
</body>
</html>