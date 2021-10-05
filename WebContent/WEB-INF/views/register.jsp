<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<title>Register</title>


</head>
<body>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
 
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/PersonMaviDev/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="register">Register</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="list">List</a>
      </li>
      
    </ul>
  </div>
</nav>
<div class="container" align="center">
<h1 align="center">Person Register</h1>
<form:form action="save" method="post" modelAttribute="person">
<table cellpadding="5">
<form:hidden path="id"/>
 <tr>
 
 <td>TCKN:</td>
 <td><form:input path="TCKN" /></td>
 </tr>
 <tr>
 
 <td>Name:</td>
 <td><form:input path="name" /></td>
 </tr>
  <tr>
 <td>Surname:</td>
 <td><form:input path="surname" /></td>
 </tr>
  <tr>
 <td>Age:</td>
 <td><form:input path="age" /></td>
 </tr>
  <tr>
 <td>Gender:</td>
 <td><form:radiobutton path = "gender" value = "M" label = "Male" checked="checked"/>
  <form:radiobutton path = "gender" value = "F" label = "Female"  /> </td>
 </tr>
  <tr>
 <td>E-mail:</td>
 <td><form:input path="email" /></td>
 </tr>
  <tr>
 <td>City:</td>
 <td><form:input path="city" /></td>
 </tr>
  <tr><td colspan="2" align="center"><input type="submit" value="Save" class="btn btn-success"/></td>
 </tr>
 </table>
</form:form>
</div>
</body>
</html>