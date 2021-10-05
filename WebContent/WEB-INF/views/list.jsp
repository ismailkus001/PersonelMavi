<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


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
<div class="container" align="center ">
<h1 align="center">Person List</h1>
<table class="table table-hover table-dark">
<thead>
	<tr>
	 <th scope="col">ID</th>
	  <th scope="col">TCKN</th>
	 <th scope="col">Name</th>
	 <th scope="col">Surname</th>
	 <th scope="col">Age</th>
	 <th scope="col">Gender</th>
	 <th scope="col">E-mail</th>
	 <th scope="col">City</th>
	 <th scope="col">Action</th>
	
	
	
	</tr>
	</thead>
	<tbody>
	
	<c:forEach items="${listPerson }" var="Person" varStatus="status">
	<tr> 
		 <th scope="row">${Person.id }</th>
		<td>${Person.TCKN }</td> 
		<td>${Person.name }</td>
		<td>${Person.surname }</td>
		<td>${Person.age}</td>
		<td>${Person.gender}</td>
		<td>${Person.email}</td>
		<td>${Person.city}</td>
		<td>
		<a href="edit?id=${Person.id }" type="button" class="btn btn-warning">Edit</a>
		&nbsp;&nbsp;
		<a href="delete?id=${Person.id }" type="button" class="btn btn-danger">Delete</a>
		</td>
	
	
	
	
	</tr>
</c:forEach>
</form>
<tbody>
</table>



</div>

</body>
</html>