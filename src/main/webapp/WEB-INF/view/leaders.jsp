<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
	<h2>Welcome to Leaders Home Page</h2>
	
	<h2>ONLY FOR LEADERS</h2>

	<br />
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
	<br />
	
	<!-- Add logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>