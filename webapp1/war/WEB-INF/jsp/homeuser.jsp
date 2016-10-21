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
		
		<!-- <meta name="Keywords" content="QuakeCoRE, research in earthquake resilience, University of Canterbury, New Zealand, University, ">
		<meta name="Description" content="QuakeCoRE Home Page, University of Canterbury, Christchurch, New Zealand"> -->
		
		<!-- <style type="text/css">
		</style> -->
	
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
									<!-- <li id="homeTab"><a href="/"><strong>Home</strong></a></li>  -->
									<li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li> 
								</ul>
					  </div> 
					   
			  	 <!-- <div class="topbar"></div> --> 
				<div id="content" class="content-width">
				<div id="msg" style="display:block;">
						<h4>${msg}</h4>
						</div>
				  	<div class="container">  
				        <div id="userid"  style="display:none;">
						${email}
						</div>
	 <h3 class="form-heading">Welcome ${name}!</h3>
		<div class="jumbotron">
				<form  method="post"  class="fillform" name="formUserSelection" action="">
					 <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
				        <p>
				            <span class="alert alert-success" id="Err"></span>
				        </p>
				     </div>
			   		 <br>
			         <ul class="nav nav-pills">
							  <a href="changepassword" class="btn btn-default btn-block" role="button" >Change password</a>
							  <a href="editprofile" class="btn  btn-default btn-block" role="button" >Edit profile</a>
							  <a href="mailinglist" class="btn  btn-default btn-block" role="button">Mailing list subscription</a>
							  <a href="newpublication" class="btn  btn-default btn-block" role="button">Get QuakeCoRE article number</a>
							   <a href="viewmypublications" class="btn  btn-default btn-block" role="button">Update article details</a>
							   <a href="viewpeople" class="btn  btn-default btn-block" role="button">QuakeCoRE community</a>
							  <a href="viewpublication" class="btn  btn-default btn-block" role="button">QuakeCoRE publications</a>
							  <br><br>
							   <!--  <a href="abstractSubmission" class="btn btn-round" role="button">Submit abstract</a> 
							   <a href="viewMyAbstractSubmissions" class="btn btn-round" role="button">View my abstract submissions</a> -->
			  		 </ul>
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
		<script  src="/js/session.js"></script>
	</body>
</html>