<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
img {
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>

</head>
<body>
<a href="Index.jsp">
<button type="button" class="btn btn-danger">HOME</button>
</a>
<br></br>

<div class="row">

    <div class="card" style="width:20rem;height:15rem;">
      <a href="CourseDetailsServ?courseName=java">
        <img src="assets/images/java.png" class="card-img-top" alt="java" style=" width:100%;height=30%"> </a>         
         <div class="card-body">
            <h5 class="card-title" align="center">JAVA</h5>
     </div>
     </div>
     
     
  <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=sap">
     <img src="assets/images/sap.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">SAP</h5>
     </div>
     </div>
     
   <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=.net">
     <img src="assets/images/net.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">.NET</h5>
     </div>
     </div> 
     
   <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=j2EE">
     <img src="assets/images/j2ee.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">J2EE</h5>
     </div>
     </div> 
     
   <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=selinium">
     <img src="assets/images/selenium.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">SELENIUM</h5>
     </div>
     </div> 
     
     
   <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=angularjs">
     <img src="assets/images/angular.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">ANGULAR JS</h5>
     </div>
    </div> 
     
   <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=cloudcomputing">
     <img src="assets/images/cloud.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">CLOUD COMPUTING</h5>
     </div>
     </div> 
     
      <div class="card" style="width:20rem;height:15rem;">
    <a href="CourseDetailsServ?courseName=web design">
     <img src="assets/images/web.png" class="card-img-top" alt="sap" style="width:100%;height=30%"></a>
      <div class="card-body">
       <h5 class="card-title" align="center">WEB DESIGNING</h5>
     </div>
     </div> 
     
     
  </div>
</body>
</html>