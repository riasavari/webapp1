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
					   
					 <div id="topnavbar"><button id="nav-button">Toggle Navigation</button>
								<ul>
									<li id="homeTab"><a href="/homeuser"><strong>Home</strong></a></li> 
									<li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li> 
								</ul>
					  </div> 
					    
			  	<!-- <div class="topbar"></div> --> 
				<div id="content" class="content-width">
				  	<div class="container">
        <div id="userid"  style="display:none;">
		${email}
	</div>
	<div id="pubid"  style="display:none;">
				${pubNo}
			</div>
			
	<div id="singlepub"  style="display:none;">
				${singlePub}
			</div>
    <div class="jumbotron">
  <h3 class="form-heading">The details have been successfully updated.</h3>
   </div>
   		</div> 
			  	 </div>	
			    
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:info@quakecore.nz">info@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
  	 <%@include file="numberpopup.jsp" %> 
	<script  src="/lib/jquery-min-latest.js"></script>
	<script  src="bootstrap/js/bootstrap.min.js"></script>
	<script  src="/js/session.js"></script>
	</body>
</html>