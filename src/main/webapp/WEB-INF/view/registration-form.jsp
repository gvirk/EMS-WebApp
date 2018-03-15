<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Register Form</title>
</head>
<body>

	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-3 col-sm-3 col-xs-12"></div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="form-container">
					<div class="center">
						<img src="${pageContext.request.contextPath}/resources/img/login2.png">
						<h1>Register Form</h1>
						<h6>Expends Management System</h6>
					</div>
					
					<hr><br />
					
					<!-- Registration form -->
					<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" modelAttribute="crmUser">
					
					<!-- Check for registration error -->
					<c:if test="${registrationError != null}">
					<!-- Error message -->
					<div class="alert alert-danger col-xs-offset-1 col-xs-10 center">	
						${registrationError}
					</div>
					</c:if>
					
					<div class="row">
			          <div class="col-md-6 col-sm-6 col-xs-12">
			          
			          	<!-- User name -->
			            <div class="form-group">
			              <label for="exampleInputUsername">Username:</label>
			              <form:input path="userName" type="text" class="form-control" name="username" required="required" placeholder="Enter username" />
			            </div>
			            
			            <!-- Password -->
			            <div class="form-group">
			              <label for="exampleInputPassword">Password:</label>
			              <form:input path="password" type="password" class="form-control" name="password" required="required" placeholder="Enter password" />
			            </div>
			            
			            
			            
			            
			            <div class="form-group">
			              <label for="exampleInputRePassword">Retype Password:</label>
			              <input type="password" class="form-control" name="repassword" required="required" placeholder="Enter password again">
			            </div>
			          </div>
			          <div class="col-md-6 col-sm-6 col-xs-12">
			            <div class="form-group">
			              <label for="exampleInputFirstName">First Name:</label>
			              <input type="text" class="form-control" name="firstname" required="required" placeholder="Enter your first name">
			            </div>
			            <div class="form-group">
			              <label for="exampleInputLastName">Last Name:</label>
			              <input type="text" class="form-control" name="lastname" required="required" placeholder="Enter your last name">
			            </div>
			            <div class="form-group">
			              <label for="exampleInputEmail">E-mail address:</label>
			              <input type="text" class="form-control" name="email" required="required" placeholder="Enter your email">
			            </div>
			            <div class="form-group">
			              <label for="exampleInputAge">Age:</label>
			              <input type="text" class="form-control" name="age" required="required" placeholder="Enter your age">
			            </div>
			        </div>
			      </div>
				  <div class="row">
		          
		          <!-- Register button -->
		          <div class="col-md-12 col-sm-12 col-xs-12">
		          	<div class="center">
		            	<button type="submit" class="btn btn-success btn-block">Register</button>
		            	<br />
		            	<a href="${pageContext.request.contextPath}/showMyLoginPage" style="color: #009999" >Click Here to Login</a>
		            </div>
		          </div>
		      	  </div>	
		      	  </form:form>
					
					
					
		
					
					
						
					<!-- Footer -->
					<div class="center">
						<label class="label-bottom">Copyright c 2018 by Jaroslaw Kowalczyk</label>
					</div>				
				</div>
					
					
					


				</div>
				<div class="col-md-3 col-sm-3 col-xs-12"></div>
			</div>
		</div>
	


</body>

</html>