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
<link type="text/css" rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>Login Form</title>
</head>
<body>

	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<div class="center">
						<img src="${pageContext.request.contextPath}/resources/img/login2.png">
						<h1>Sign Up</h1>
						<h6>Expends Management System</h6>
					</div>
					
					<div style="padding-top: 30px" class="panel-body">
					<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

						<!-- Check for login error -->
						<c:if test="${param.error != null}">
						<div class="alert alert-danger col-xs-offset-1 col-xs-10 center">		
							Invalid username or password!
						</div>
						</c:if>
						
						<!-- Check for logout -->
						<c:if test="${param.logout != null}">
						<div class="alert alert-success col-xs-offset-1 col-xs-10 center">		
							You have been logged out.
						</div>
						</c:if>
						
						
						<!-- USER NAME -->
						<div class="input-group mb-3">
						  	<div class="input-group-prepend">
						    	<span class="input-group-text" id="basic-addon1"><i class="far fa-user fa-xs"></i></span>
						  	</div>
						  		<input type="text" name="username" required="required" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
						</div>
						
						<!-- PASSWORD -->
						<div class="input-group mb-3">
						  	<div class="input-group-prepend">
						    	<span class="input-group-text" id="basic-addon1"><i class="fas fa-key fa-xs"></i></span>
						  	</div>
						  		<input type="password" name="password" required="required" class="form-control" placeholder="Password" aria-label="Password" aria-describedby="basic-addon1">
						</div>						
				
						

						<!-- REMEMBER CHECKBOX -->
						<div class="form-check" style="margin-top: 15px">
							<input type="checkbox" class="form-check-input" id="exampleRemember1"> <label class="form-check-label" for="exampleCheck1">Remember me</label>
						</div>
						
						<!-- LOGIN BUTTON -->
						<div style="margin-top: 10px" class="form-group center">
							<div class="col-sm-12 controls center">
								<button type="submit" class="btn btn-success">Sign Up</button>
							</div>
						</div>
					</form:form>
					</div>
					
						<div  class="center">
						<a href="${pageContext.request.contextPath}/register/showRegistrationForm" style="color: #009999">Click Here to register new User</a>
						</div>
						
						<!-- Footer -->
						<div class="text-align: center">
							<label class="label-bottom">Copyright c 2018 by Jaroslaw Kowalczyk</label>
						</div>				
					</div>
		
				</div>
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	


</body>

</html>