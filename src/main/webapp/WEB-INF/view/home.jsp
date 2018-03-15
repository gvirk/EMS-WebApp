<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
	<h2>Welcome to Home Page</h2>
	
	<br />
	<!--  Show username and roles -->
	<p>Hello user: <security:authentication property="principal.username"/></p>
	<p>Your role: <security:authentication property="principal.authorities"/></p>
	
	
	<br />
	
	
	<!-- Content display only for MANAGER role -->
	<security:authorize access="hasRole('MANAGER')">
		<p><a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting (Only for Manager)</a></p>
	</security:authorize>
	
	<!-- Content display only for ADMIN role -->
	<security:authorize access="hasRole('ADMIN')">	
		<p><a href="${pageContext.request.contextPath}/systems">IT Systems Meeting (Only for Admins)</a></p>
	</security:authorize>

	<hr>
	
	<br />
	
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>