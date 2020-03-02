<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.chainsys.trainingproject.dao.impl.ClientCompanyDAOImpl" %>
        <%@ page import="com.chainsys.trainingproject.model.ClientCompany" %>
            <%@ page import="java.util.List" %>
        
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Company Details</title>

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

<form action="CompanyDetailsServ">
<h1 style="color:white; font-size:25px; font-family:courier; text-align:centre;">COMPANY DETAILS</h1>
<%
ClientCompanyDAOImpl impl=new ClientCompanyDAOImpl();
List<ClientCompany> list=(List <ClientCompany>)request.getAttribute("Company_Details");
%>
<table border="1">
<thead>
<tr>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Client Id</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Company Name</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Company Type</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Company Address</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Contact Number</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Contact Person</h1></th>
<th><h1 style="color:red; font-size:25px; font-family:courier; text-align:centre;">Email Id</h1></th>
</tr>
</thead>

<% for(ClientCompany c:list)
{%>
<tr>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getClientId()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getCompanyName()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getCompanyType()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getCompanyAddress()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getPhoneNo()%></h1>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getContactPerson()%></h1></td>
<td><h1 style="color:white; font-size:20px; font-family:courier; text-align:centre;"><%=c.getEmailId()%></h1></td>
</tr>
<%} %>
</table>
</form>
</body>
</html>