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
<title>Registration Confirmation</title>
</head>
<body>

	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-container">
					<div class="center">
						<img src="${pageContext.request.contextPath}/resources/img/login2.png">
						<h1>Register Form</h1>
						<h6>Expends Management System</h6>
					</div>
					
					<hr><br />
					
						<!-- Register successfully message -->
						<div class="alert alert-success col-xs-offset-1 col-xs-10 center">	
						User registered successfully!
						</div>
						
					<br />
					
					<a href="${pageContext.request.contextPath}/showMyLoginPage" class="btn btn-success btn-block">Login with new user</a>
					
					
						
					<!-- Footer -->
					<div class="center">
						<label class="label-bottom">Copyright c 2018 by Jaroslaw Kowalczyk</label>
					</div>				
				</div>
					

				</div>
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	


</body>

</html>