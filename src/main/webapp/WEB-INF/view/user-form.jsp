<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Save user</title>
</head>


<body>

<div class="container-fluid bg">
  <div class="row">
    <div class="col-md-1 col-sm-1 col-xs-12"></div>
	<div class="col-md-10 col-sm-10 col-xs-12">
	<div class="form-container">
		<div class="center">
			<img src="../resources/img/login2.png">
            	<h1>Add new User</h1>
				<h6>Expends Management System</h6>
		</div>
        
        <br />
        
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
        
        <!-- SAVE NEW USER -->
        <form:form action="saveUser" modelAttribute="user" method="POST">
        	
       	<!-- need to associate this data with user id -->
       	<form:hidden path="id"/>
        
       <div class="row">
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>Username:</label>
              <form:input path="username" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>Password:</label>
              <form:input path="password" type="password" class="form-control" required="required"/>
            </div>
          </div>
            
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>First Name:</label>
              <form:input path="firstName" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>Last Name:</label>
              <form:input path="lastName" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>Email:</label>
              <form:input path="email" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-1 col-sm-1 col-xs-12">
            <div class="form-group">
              <label>Age:</label>
              <form:input path="age" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-1 col-sm-1 col-xs-12"> 
            <div class="form-group">
              <label>Action:</label>
              <input type="submit" value="Save" class="btn btn-success btn-block" />
            </div>
          </div> 
	   </div> 
	 
	   <hr>
	      
	   <!-- SALARY -->
       <div class="row">
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>January salary:</label>
              <form:input path="januarySalary" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
              <label>February salary:</label>
              <form:input path="februarySalary" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>March salary:</label>
              <form:input path="marchSalary" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
              <label>April salary:</label>
              <form:input path="aprilSalary" type="text" class="form-control" required="required"/>
            </div>
          </div>
            
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>May salary:</label>
              <form:input path="maySalary" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
              <label>June salary:</label>
              <form:input path="juneSalary" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>July salary:</label>
              <form:input path="julySalary" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
              <label>August salary:</label>
              <form:input path="augustSalary" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>September salary:</label>
              <form:input path="septemberSalary" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
              <label>October salary:</label>
              <form:input path="octoberSalary" type="text" class="form-control" required="required"/>
            </div>
          </div>
          
          <div class="col-md-2 col-sm-2 col-xs-12">
            <div class="form-group">
              <label>November salary:</label>
              <form:input path="novemberSalary" type="text" class="form-control" required="required"/>
            </div>
            <div class="form-group">
              <label>December salary:</label>
              <form:input path="decemberSalary" type="text" class="form-control" required="required"/>
            </div>
          </div>
	    </div>   

	   </form:form>
	   
	   
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