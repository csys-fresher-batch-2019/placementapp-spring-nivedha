<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE INTERVIEW STATUS</title>
</head>
<style>
body {
  background-image: url('assets/images/bg_1.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<form action="UpdateInterviewStatusServ">
<% String interviewid=request.getParameter("interviewid");%>
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                                INTERVIEW STATUS</h1>
</pre><pre>
<div style="text-align:center">
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">   INTERVIEW ID    <input type="number" name="interviewid" value="<%=interviewid%>" readonly required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">INTERVIEW MARKS    <input type="number" name="marks" placeholder="Enter marks 0-100"/>
</p>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;"><button type="submit" >UPDATE</button>
</div>
</pre>
</form>
</body>

</html>