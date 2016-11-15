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
									<li id="homeTab"><a href="/homeAdmin"><strong>Home</strong></a></li> 
									<li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li> 
								</ul>
					  </div> 
					  
			  	 <!-- <div class="topbar"></div>  --> 
				<div id="content" class="content-width">
				  	<div class="container"> 
        <div id="userid"  style="display:none;">
				${email}
			</div>
     <div id="userAcc"  style="display:none;">
				${newUserAcc}
			</div>
     
      		 <div id="userActive"  style="display:none;">
				${active}
			</div>

			 
      <h3 class="form-heading">User Profile</h3>
    <div class="jumbotron">
	<form  method="get"  class="fillform form-horizontal" name="formActivate" action="activated">
	<!--  <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="profileErr"></span>
        </p>
    </div>
	 <br><br><br> -->
    	<!-- <div class="well well-lg" style="display: block; position: absolute;z-index: 2001;"> -->
       <label>Name: ${firstName} ${lastName}</label><br>
       <label>Position: ${position} </label><br>
        <label>Organisation: ${organisation}</label><br>
        <label>Category: ${category}</label><br>
        <label>Email:${newUserAcc}</label><br>
        <label>User account active?:<strong>${active}</strong></label><br>
        <%-- <c:set var="name" scope="application" value="${pub.publicationId}"/> --%>
        <div class="form-group" >
      		<input type="hidden" class="form-control" name="useremail" id="useremail" value="${newUserAcc}">
    	 </div>
    	 <div class="form-group" >
      		<input type="hidden" class="form-control" name="activeStatus" id="activeStatus" value="${active}">
    	 </div>
       <button type="submit" class="myButton" id="btn-activate" >Activate/Deactivate</button>
			 <!--  </div> -->
			  
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
		<script  src="/js/userActivation.js"></script>
		</body>
</html>