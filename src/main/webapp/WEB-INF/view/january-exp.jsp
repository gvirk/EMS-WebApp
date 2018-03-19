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
<title>January Expends</title>
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
	            <h1>January</h1>
				<h6>Expends Management System</h6>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12 center">
		
			</div>
		</div>
		
		<!-- User Info & Logout -->
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12 user min center">
				<!--  Show user name and roles -->
				Logged as: <strong><security:authentication property="principal.username"/></strong>
				| Roles: <strong><security:authentication property="principal.authorities"/></strong>	
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<!-- Add logout button -->
				<form:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" class="btn btn-outline-secondary" style="position: absolute; bottom: 5px; right: 10px"/>
				</form:form>				
			</div>
        </div>
        
        <!-- NAVBAR -->
		<div class="row">
			<div class="nav col-md-12 col-sm-12 col-xs-12">
				<ul>
				  <li><a href="${pageContext.request.contextPath}">Home</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/january">January 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/february">February 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/march">March 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/april">April 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/may">May 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/june">June 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/july">July 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/august">August 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/september">September 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/october">October 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/november">November 2018</a></li>
				  <li><a href="${pageContext.request.contextPath}/user/december">December 2018</a></li>
				</ul>			
			</div>
		</div>
		
		<br />
        
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label>Total incomings:</label> 
					<!-- Show input with January Salary depend on username -->
					<c:forEach var="theUser" items="${user}">	
						<input type="text" class="form-control" name="incomings" id="incomings" value="${theUser.januarySalary}">
					</c:forEach>
					
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label>Total outgoings:</label> 
					<input type="text" class="form-control" name="outgoings" id="outgoings" value="${theSumJan[0]+theSumJan[1]+theSumJan[2]+theSumJan[3]+theSumJan[4]+theSumJan[5]+theSumJan[6]}">
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<div class="form-group">
					<label>Save Up:</label> 
					<input type="text" class="form-control" style="color: red; font-weight: bold" name="saveUp" id="result">
				</div>
			</div>
		</div>
		
	

        
        <div class="row">
	     	<div class="col-md-10 col-sm-10 col-xs-12">
		      	<div class="form-group">
				</div>
			</div>
	        <!-- ADD NEW EXPENDS BUTTON -->
	        <div class="col-md-2 col-sm-2 col-xs-12">
		        <div class="form-group">
             		<input type="button" value="Add new expends" class="btn btn-success btn-block" onclick="window.location.href='showFormForAddExpends'; return false;"/>
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
				<c:forEach var="tempJanExp" items="${januaryExpends}">
				
					<!-- construct an "update" link with row id -->
					<c:url var="updateLink" value="/user/showExpForUpdateJan">
						<c:param name="rowId" value="${tempJanExp.id}" />
					</c:url>
					
					<!-- construct an "delete" link with row id -->
					<c:url var="deleteLink" value="/user/deleteRowJan">
						<c:param name="rowId" value="${tempJanExp.id}" />
					</c:url>
				
					<tr>
						<td>${tempJanExp.id}</td>
						<td>${tempJanExp.date}</td>
						<td>${tempJanExp.eating}</td>
						<td>${tempJanExp.mobile}</td>
						<td>${tempJanExp.flat}</td>
						<td>${tempJanExp.fuel}</td>
						<td>${tempJanExp.tickets}</td>
						<td>${tempJanExp.payment}</td>
						<td>${tempJanExp.other}</td>
						<td><strong>${tempJanExp.total=tempJanExp.eating+tempJanExp.mobile+tempJanExp.flat+tempJanExp.fuel+tempJanExp.tickets+tempJanExp.payment+tempJanExp.other}</strong></td>
				
						<td><a href="${updateLink}" class="btn btn-warning btn-block btn-sm" role="button">Edit</a></td>
						<td><a href="${deleteLink}" class="btn btn-danger btn-block btn-sm" role="button" onClick="if (!(confirm('Are you sure you want to delete this expends?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
				
					<tr class="background">
						<td colspan="2"><strong>SUM:</strong></td>
						<td><strong>${theSumJan[0]}</strong></td>
						<td><strong>${theSumJan[1]}</strong></td>
						<td><strong>${theSumJan[2]}</strong></td>
						<td><strong>${theSumJan[3]}</strong></td>
						<td><strong>${theSumJan[4]}</strong></td>
						<td><strong>${theSumJan[5]}</strong></td>
						<td><strong>${theSumJan[6]}</strong></td>
						<td><strong>${theSumJan[0]+theSumJan[1]+theSumJan[2]+theSumJan[3]+theSumJan[4]+theSumJan[5]+theSumJan[6]}</strong></td>
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

<script type="text/javascript">
function showBalance()
{
	var x = document.getElementById("incomings").value;
	var y = document.getElementById("outgoings").value;
	var z = parseFloat(x) - parseFloat(y);
	document.getElementById("result").value = z;
}
</script>

</body>
</html>