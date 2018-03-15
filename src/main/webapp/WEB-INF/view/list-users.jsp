<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<title>List Users</title>
</head>

<body>

<div class="container-fluid bg">
  <div class="row">
    <div class="col-md-1 col-sm-1 col-xs-12"></div>
	<div class="col-md-10 col-sm-10 col-xs-12">

	<div class="form-container">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12">

			</div>
			<div class="col-md-4 col-sm-4 col-xs-12 center">
				<img src="../resources/img/login2.png">
	            <h1>Users list</h1>
				<h6>Expends Management System</h6>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12 center">
		
			</div>
		</div>
		
		<!-- NAVBAR -->
		<div class="row">
			<div class="nav col-md-4 col-sm-4 col-xs-12">
				<ul>
				  <li><a href="#">Home</a></li>
				  <li><a href="#">News</a></li>
				  <li class="dropdown">
				    <a href="javascript:void(0)" class="dropbtn">Drop down</a>
				    <div class="dropdown-content">
				      <a href="#">Link 1</a>
				      <a href="#">Link 2</a>
				      <a href="#">Link 3</a>
				    </div>
				  </li>
				</ul>			
			</div>
			<div class="nav col-md-4 col-sm-4 col-xs-12 user min center">
				<!--  Show user name and roles -->
				Logged as: <strong><security:authentication property="principal.username"/></strong>
				| Roles: <strong><security:authentication property="principal.authorities"/></strong>	
			</div>
			<div class="nav col-md-4 col-sm-4 col-xs-12">
				<!-- Add logout button -->
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" class="btn btn-outline-secondary" style="position: absolute; bottom: 5px; right: 10px"/>
				</form:form>				
			</div>
        </div>
        
        <br />
        <br />
  
	     <!-- SEARCH BOX --> 
	     <form:form action="search" method="POST"> 
	     <div class="row">
	     	<div class="col-md-5 col-sm-5 col-xs-12">
		      	<div class="input-group mb-3">
				  <input type="text" name="theSearchName" class="form-control" placeholder="Search..." aria-label="Search..." aria-describedby="basic-addon2">
					  <div class="input-group-append">
					    <input type="submit" value="Search" class="btn btn-outline-secondary" />
					  </div>
				</div>
			</div>
				<div class="col-md-5 col-sm-5 col-xs-12">
		         	<div class="form-group">
		        </div>
	        </div>	
				        
	        <!-- BUTTON add User -->
	        <security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
	        <div class="col-md-2 col-sm-2 col-xs-12">
		        <div class="form-group">
             		<input type="button" value="Add new user" class="btn btn-success btn-block" onclick="window.location.href='showFormForAdd'; return false;"/>
		        </div>
	        </div>
	        </security:authorize>
	        
		 </div>
	  	 </form:form>    
        

		<!--  HTML TABLE -->
		
		<div class="table-responsive center">
			<table class="table table-hover table-sm">
				<thead class="thead-light">	
					<tr>
						<th scope="col">Id</th>
						<th scope="col">User name</th>
						
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<th scope="col">Password</th>
						</security:authorize>
						
						<th scope="col">First Name</th>
						<th scope="col">Last Name</th>
						<th scope="col">Email</th>
						<th scope="col">Age</th>
						
						<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
						<th colspan="2" scope="col">Action</th>
						</security:authorize>
						
					</tr>
				</thead>
				<tbody>
				
				<!-- loop over and print users -->
				<c:forEach var="tempUser" items="${users}">
				
					<!-- construct an "update" link with user id -->
					<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					<c:url var="updateLink" value="/user/showFormForUpdate">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>
					</security:authorize>
					
					<!-- construct an "delete" link with user id -->
					<security:authorize access="hasRole('ADMIN')">
					<c:url var="deleteLink" value="/user/delete">
						<c:param name="userId" value="${tempUser.id}" />
					</c:url>
					</security:authorize>
					
					<tr>
						<td>${tempUser.id}</td>
						<td>${tempUser.username}</td>
						
						<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						<td>${tempUser.password}</td>
						</security:authorize>
						
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>${tempUser.email}</td>
						<td>${tempUser.age}</td>
						
						<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
						<td><a href="${updateLink}" class="btn btn-warning btn-block btn-sm" role="button">Edit</a></td>
						</security:authorize>
						
						<security:authorize access="hasAnyRole('ADMIN')">
						<td><a href="${deleteLink}" class="btn btn-danger btn-block btn-sm" role="button" onClick="if (!(confirm('Are you sure you want to delete this user?'))) return false">Delete</a></td>
						</security:authorize>
						
					</tr>
				</c:forEach>
	
				</tbody>
			</table>
		</div>
		
		<!-- Footer -->
		<div class="text-align: center">
			<label class="label-bottom">Copyright c 2018 by Jaroslaw Kowalczyk</label>
		</div>
		
	</div>
	<div class="col-md-1 col-sm-1 col-xs-12"></div>
  </div>
  </div>
</div>


</body>
</html>