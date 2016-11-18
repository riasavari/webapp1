<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> -->
		 
		<link href="/css/styles.css" rel="stylesheet" type="text/css">
		<link href="/css/main.css" rel="stylesheet">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link href="/css/jumbotron-narrow.css" rel="stylesheet">
		
		<title>QuakeCoRE</title>
		
	
	</head>

	<body>
		<div id="wrapper">
				<div id="header">
				<h1>QuakeCoRE</h1>
				<h2>Centre for Earthquake Resilience</h2>
				</div>
				<div id="imagearea">
				</div>
					
			  	<div class="topbar"></div> 
				<div id="content" class="content-width">
				  	<div class="container">  
				        <div id="userid"  style="display:none;">
						${email}
						</div>
						
						 <h3 class="form-heading">Sign in</h3>
						 <div class="jumbotron">
						 <!-- <div class="modal" id="loadModal" style="display: none; position: absolute;z-index: 2001;">
						  <span   class="glyphicon glyphicon-refresh spinning" >Processing...</span>
							  </div> -->
							 
							  <form  method="post"  class="fillform" name="formLogin" action="select">
								   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
								        <p>
								            <span class="alert alert-danger" id="loginErr"></span>
								        </p>
								    </div>
							   	    <br><br><br>
<div id="modalbox" class="modal" role="dialog" data-keyboard="false" data-backdrop="static">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
     
      <div class="modal-body">
        <p><span class="glyphicon spinning"></span> Processing.Please wait.. </p>
      </div>
      
    </div>

  </div>
</div>
								    <div class="form-group">
								      <input type="text" class="form-control" id="email" placeholder="Email">
								     <!--  <table style="width:100%;"><tr><td><input type="email" class="form-control" id="email" placeholder="Email"></td><td><span style="color:red;">*</span></td></tr></table> -->
								    </div>
							      <div class="form-group">
								      <input type="password" class="form-control" id="password" placeholder="Password">
								    </div>
							  		
									<a href="forgotpassword" class="btn-link">Forgot Password</a> |
									<a href="signup" class="btn-link"> Sign up</a> |
									<a href="mailto:quakecore.nz@gmail.com">Problem signing in?</a>
								 	<button type="submit" class="myButton" id="btn-login" data-toggle="modal" data-target="#modalbox" onclick="return login()">Submit</button>
							  </form>
						 </div>
				 	 </div> 
			  	 </div>	
			    
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:info@quakecore.nz">info@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
			
			
		 <script  src="/lib/jquery-min-latest.js"></script>
		 <script  src="bootstrap/js/bootstrap.min.js"></script>
		 <script  src="/js/login.js"></script>
	</body>
	
</html>