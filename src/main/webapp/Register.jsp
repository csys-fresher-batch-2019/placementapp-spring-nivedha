<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
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

<form method="POST" enctype="multipart/form-data" action="RegistrationServ" autocomplete="off">
<div style="text-align:centre">
<pre>
<br></br>
<h1 style="color:white; font-size:30px; font-family:courier; text-align:centre;">                                REGISTRATION</h1>
<%String errorMessage = (String)request.getAttribute("errorMessage");
if(errorMessage !=null)
{%>
<font color="red"style="font: bold">                                                                           <%=errorMessage%>
<%}%>

<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Name           <input type="text" name="name" placeholder="Enter Name" required autofocus/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Password       <input type="password" name="password" placeholder="Enter password" required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">City           <input type="text" name="city"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Mobile Number  <input type="text" name="mobileno"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Email Id       <input type="email" name="email"  required/>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Qualification        <select name="qualification" required>
                     <option value="BE-CS" > BE-CS </option>
                     <option value="BE-EEE" >BE-EEE </option>
                     <option value="BE-ECE" >BE-ECE </option>
                     <option value="BE-IT" >BE-IT </option>
                     <option value="BE-IT" >MCA </option>
                     <option value="BE-IT" >BCA </option>
                     </select>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">Gender              <input type="radio" name="gender" value="male" required> Male  
                    <input type="radio" name="gender" value="female" required>Female 
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">                    Profile  <input type="text" name="imagename"  required/><input type="file" name="image"/>
</pre>
<p style="color:white; font-size:20px; font-family:courier;text-align:center;">                     <button type="submit" >SIGN UP</button><br></br>
</div>
<br/><br/>
</form>
</body>
</html>