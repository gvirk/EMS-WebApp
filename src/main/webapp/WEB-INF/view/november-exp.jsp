<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/global.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<title>November Expends</title>
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
	            <h1>November</h1>
				<h6>Expends Management System</h6>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12 center">
		
			</div>
		</div>
		

     	<!-- NAVBAR -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
		  <a class="navbar-brand" href="#">Navbar</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		    <span class="navbar-toggler-icon"></span>
		  </button>
		  
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <li class="nav-item active font-size-nav">
		        <a class="nav-link" href="${pageContext.request.contextPath}">Home <span class="sr-only">(current)</span></a>
		      </li>
		      <li class="nav-item active dropdown font-size-nav">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Expends 2018'
		        </a>
		        <div class="dropdown-menu font-size-nav" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/january">January 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/february">February 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/march">March 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/april">April 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/may">May 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/june">June 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/july">July 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/august">August 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/september">September 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/october">October 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/november">November 2018</a>
		          <a class="dropdown-item" href="${pageContext.request.contextPath}/user/december">December 2018</a>
		         </div>
		      </li>
		      <li>
		      	<!-- Add logout button -->
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" class="btn btn-outline-secondary btn-sm" style="margin: 5px 10px" />
				</form:form>
		      </li>
		    </ul>
		    	<div class="user min">
		    	<!--  Show user name and roles -->
				Logged as: <strong><security:authentication property="principal.username"/></strong>
				| Roles: <strong><security:authentication property="principal.authorities"/></strong>	
				</div>
		  </div>
		</nav>      
      
		<br />
		
        <!-- Show input with Salary depend on username -->
        <c:forEach var="theUser" items="${user}">	
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label>Total incomings:</label> 
					<input type="text" class="form-control" id="incomings" value="${theUser.novemberSalary}">
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label>Total outgoings:</label> 
					<input type="text" class="form-control" id="outgoings" value="${theSumNov[0]+theSumNov[1]+theSumNov[2]+theSumNov[3]+theSumNov[4]+theSumNov[5]+theSumNov[6]}">
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label>Save Up:</label> 
					<input type="text" class="form-control" style="color: red; font-weight: bold" id="result" value="${theUser.novemberSalary-theSumNov[0]-theSumNov[1]-theSumNov[2]-theSumNov[3]-theSumNov[4]-theSumNov[5]-theSumNov[6]}">
				</div>
			</div>
		</div>
		</c:forEach>
	

        
        <div class="row">
	     	<div class="col-md-10 col-sm-10 col-xs-12">
		      	<div class="form-group">
				</div>
			</div>
	        <!-- ADD NEW EXPENDS BUTTON -->
	        <div class="col-md-2 col-sm-2 col-xs-12">
		        <div class="form-group">
             		<input type="button" value="Add new expends" class="btn btn-success btn-block" onclick="window.location.href='showFormForAddExpendsNov'; return false;"/>
		        </div>
	        </div>
		</div>

		<!--  HTML TABLE -->
		
		<div class="table-responsive center">
			<table class="table table-hover table-sm table-bordered">
				<thead class="thead-light">	
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Date</th>
						<th scope="col">Eating</th>
						<th scope="col">Mobile</th>
						<th scope="col">Flat</th>
						<th scope="col">Fuel</th>
						<th scope="col">Tickets</th>
						<th scope="col">Payment</th>
						<th scope="col">Other</th>
						<th scope="col">Total</th>
						<th colspan="2" scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
				
				<!-- loop over and print expends -->
				<c:forEach var="tempNovExp" items="${novemberExpends}">
				
					<!-- construct an "update" link with row id -->
					<c:url var="updateLink" value="/user/showExpForUpdateNov">
						<c:param name="rowId" value="${tempNovExp.id}" />
					</c:url>
					
					<!-- construct an "delete" link with row id -->
					<c:url var="deleteLink" value="/user/deleteRowNov">
						<c:param name="rowId" value="${tempNovExp.id}" />
					</c:url>
				
					<tr>
						<td>${tempNovExp.id}</td>
						<td>${tempNovExp.date}</td>
						<td>${tempNovExp.eating}</td>
						<td>${tempNovExp.mobile}</td>
						<td>${tempNovExp.flat}</td>
						<td>${tempNovExp.fuel}</td>
						<td>${tempNovExp.tickets}</td>
						<td>${tempNovExp.payment}</td>
						<td>${tempNovExp.other}</td>
						<td><strong>${tempNovExp.total=tempNovExp.eating+tempNovExp.mobile+tempNovExp.flat+tempNovExp.fuel+tempNovExp.tickets+tempNovExp.payment+tempNovExp.other}</strong></td>
				
						<td><a href="${updateLink}" class="btn btn-warning btn-block btn-sm" role="button">Edit</a></td>
						<td><a href="${deleteLink}" class="btn btn-danger btn-block btn-sm" role="button" onClick="if (!(confirm('Are you sure you want to delete this expends?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
				
					<tr class="background">
						<td colspan="2"><strong>SUM:</strong></td>
						<td><strong>${theSumNov[0]}</strong></td>
						<td><strong>${theSumNov[1]}</strong></td>
						<td><strong>${theSumNov[2]}</strong></td>
						<td><strong>${theSumNov[3]}</strong></td>
						<td><strong>${theSumNov[4]}</strong></td>
						<td><strong>${theSumNov[5]}</strong></td>
						<td><strong>${theSumNov[6]}</strong></td>
						<td><strong>${theSumNov[0]+theSumNov[1]+theSumNov[2]+theSumNov[3]+theSumNov[4]+theSumNov[5]+theSumNov[6]}</strong></td>
						<td colspan="2"></td>
					</tr>
				
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