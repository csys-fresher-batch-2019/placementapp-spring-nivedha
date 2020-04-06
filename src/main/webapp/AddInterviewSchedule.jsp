<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.time.LocalDate"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD INTERVIEW SCHEDULE</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
body {
  background-image: url('assets/images/bbg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<form action="AddInterviewSheduleServ" autocomplete="off">
<div style="text-align:centre">
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                       ADD INTERVIEW SCHEDULE DETAILS</h1>
<% 		LocalDate today = LocalDate.now();
 %>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red" style="font: bold" size="5"><center><%=errorMessage%></center></font>
<%}%>

<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Client Id        <input type="number" name="clientid" required autofocus/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Job Title        <input type="text" name="title"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Job Requirement    <input type="text" name="requirement" required/>  
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Created Date        <input type="date" name="createdate"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Interview Date      <input type="date" id="interviewdate" name="interviewdate"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Interview Time               <input type="time" id="time" name="time" min="09:00" max="18:00" required>

</pre>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">                     <button type="submit" >ADD</button><br></br>
</div>
<br/><br/>
</form>
<script>
		function setTodayDate() {
			var today = new Date();
			console.log(today);
			var dateStr = today.toJSON().substr(0, 10); //toJSON returns "2020-02-20T09:32:45.644Z" ( get only date)
			console.log(dateStr);
			$("#interviewdate").val(dateStr);
			$("#interviewdate").attr("min", dateStr);
		}
		setTodayDate();
	</script>
</body>
</html>