<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD COURSE DETAILS</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
body {
  background-image: url('assets/images/blackbg.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
<body>
<form action="AddCourseServ" autocomplete="off">
<div style="text-align:centre">
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                             ADD COURSE DETAILS</h1>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red" style="font: bold" size="5"><center><%=errorMessage%></center></font>
<%}%>

<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Course Name         <input type="text" name="name" required autofocus/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Course Duration       <input type="number" name="duration" required/>  
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Course Fees         <input type="number" name="fees"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">               Course Pdf         <input type="file" name="pdf"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">               Course Image       <input type="file" name="image"  required/>
</pre>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">                     <button type="submit" >ADD</button><br></br>
</div>
<br/><br/>
</form>
</body>
</html>