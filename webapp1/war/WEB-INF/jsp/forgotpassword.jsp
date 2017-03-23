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
									<li id="homeTab"><a href="/">Home</a></li> 
									<!-- <li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li>  -->
								</ul>
					  </div> 
					    
			  	 <!--<div class="topbar"></div> -->
				<div id="content" class="content-width">
				  	<div class="container">  
      <h3 class="form-heading">Password reset</h3>
        <div class="jumbotron">
  <form  method="post"  class="fillform" name="formLogin" action="sendmail">
   <div id="loading" style="display: none; position: absolute;z-index: 2001;">...</div>
   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="err"></span>
            
        </p>
    </div>
    
    <br><br><br>
 
<div id="modalbox" class="modal" role="dialog" data-keyboard="false" data-backdrop="static">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
     <!--  <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div> -->
      <div class="modal-body">
        <p><span class="glyphicon glyphicon-refresh spinning"></span> Processing.Please wait.. </p>
      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div> -->
    </div>

  </div>
</div>
    
		 <div class="form-group">
      <input type="email" class="form-control" name="email" id="email" placeholder="Enter email address">
    </div>
			
		<button type="submit" class="myButton" id="btn-forgot-pwd" data-toggle="modal" data-target="#modalbox" onclick="return validate()">Send me password reset instructions</button>
	 </form>
	</div>
	 </div> 
			  	 </div>	
			    
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:research@quakecore.nz">research@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		<script  src="/js/forgotpassword.js"></script>
		</body>
		</html>