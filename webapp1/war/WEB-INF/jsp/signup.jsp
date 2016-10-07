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
									<li id="homeTab"><a href="/"><strong>Home</strong></a></li> 
									<!-- <li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li>  -->
								</ul>
					  </div> 
					    
			  	 <!--<div class="topbar"></div> -->
				<div id="content" class="content-width">
				  	<div class="container">  
      <h3 class="form-heading">Sign up</h3>
    <div class="jumbotron">
	<form  method="post"  class="fillform" name="formSignup" action="newsignup">
	 <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="signupErr"></span>
        </p>
    </div>
	 <br><br><br>
<!-- Loading Spinner Modal -->
<div class="modal" id="modalbox">
 
  <div class="modal-body">
    <p>Loading…</p>
  </div>
  <!-- <div class="modal-footer">
    <a href="#" class="btn">Close</a>
    <a href="#" class="btn btn-primary">Save changes</a>
  </div> -->
</div>
<!-- Terms and Conditions Modal-->
<div class="modal" id="tandc-modalbox">
<div class="modal-content"> 
	<div class="modal-header">
     	<button type="button" class="close" data-dismiss="modal">&times;</button>
     	<h4 class="modal-title">Terms and Conditions</h4>
 	</div> 
    <div class="modal-body">
        <img src="graphics/TandC.png" />
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
    </div>
</div>
	<!-- <h2 class="form-heading">Please sign up</h2> -->
	 <div class="form-group form-horizontal">
        <label class="col-xs-3 control-label">Title</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control" name="title" id="title">
                <option value="Dr">Dr</option>
                <option value="Mr">Mr</option>
                <option value="Ms">Ms</option>
            </select>
        </div>
    </div>
    <br>
    <div class="form-group">
      <input type="text" class="form-control" name="firstname" id="firstname" placeholder="First name">
    </div>
     <div class="form-group">
      <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Last name">
    </div>
	<div class="form-group">
      <input type="text" class="form-control" name="email" id="email" placeholder="Email">
    </div>
    <div class="form-group">
      <input type="password" class="form-control" name="password" id="password" placeholder="Password">
    </div>
    <div class="form-group">
      <input type="password" class="form-control" name="retype-password" id="retype-password" placeholder="Re-enter password">
    </div>
  
    <div class="form-group">
      <input type="text" class="form-control" name="position" id="position" placeholder="Position">
    </div>
    <div class="form-group">
      <input type="text" class="form-control" name="organisation" id="organisation" placeholder="Organisation">
    </div>

	<div class="form-group form-horizontal">
        <label class="col-xs-3 control-label">Category</label>
        <div class="col-xs-9 selectContainer">
        
            <select class="form-control" name="category" id="category">
                <option value="University researcher">University researcher</option>
                <option value="Consulting researcher">Consulting researcher</option>
                <option value="Postdoctoral fellow">Postdoctoral fellow</option>
                <option value="Secondary school teacher">Secondary school teacher</option>
                <option value="Graduate student">Graduate student</option>
                <option value="Undergraduate student">Undergraduate student</option>
                <option value="QuakeCoRE staff">QuakeCoRE staff</option>
                <option value="Technician">Technician</option>
                <option value="Professional engineer">Professional engineer</option>
                <option value="Professional geologist">Professional geologist</option>
                <option value="Professional risk manager">Professional risk manager</option>
                <option value="Insurance">Insurance</option>
                <option value="Consultant">Consultant</option>
                <option value="Other">Other</option>
            </select>
        </div>
        
			<div>
			  <label class="checkbox-inline"><input type="checkbox" value="agree-cbox" id="agree-cbox"> I agree to the <a href="" data-toggle="modal" data-target="#tandc-modalbox">Terms and Conditions</a></label>
			</div>
			
    </div>
    
			 <br> <button type="submit" class="myButton" id="btn-signup" data-toggle="modal" data-target="#modalbox" onclick="return signup()" >Sign Up</button>
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
		<script  src="/js/signup.js"></script>
		</body>
</html>