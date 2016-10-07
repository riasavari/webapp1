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
									<li id="homeTab"><a href="/homeuser"><strong>Home</strong></a></li> 
									<li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li> 
								</ul>
					  </div> 
					  
			  	 <!-- <div class="topbar"></div>  --> 
				<div id="content" class="content-width">
				  	<div class="container"> 
        <div id="userid"  style="display:none;">
				${email}
			</div>
      </div>
      		<div id="temp" style="display:none;">
		 	<div>${firstName}</div>
		 	<div>${lastName}</div>
		 	<div>${title}</div>
		    <div>${position}</div>
		    <div>${organisation}</div>
		    <div>${category}</div>
		</div>

			 
      <h3 class="form-heading">User Profile</h3>
    <div class="jumbotron">
	<form  method="post"  class="fillform form-horizontal" name="formSignup" action="changed">
	 <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="profileErr"></span>
        </p>
    </div>
	 <br><br><br>
	
    <div class="form-group">
        <label class="col-xs-4 control-label">Title</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control" name="title" id="title">
                <option value="Dr">Dr</option>
                <option value="Mr">Mr</option>
                <option value="Ms">Ms</option>
            </select>
        </div>
    </div>
     <div class="form-group">
      <label class="control-label col-xs-4">First Name</label>
     <div class="col-xs-8"> <input type="text" class="form-control" name="firstname" id="firstname" placeholder="First name"></div>
    </div>
     <div class="form-group">
     <label class="control-label col-xs-4">Last Name</label>
       <div class="col-xs-8"> <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Last name"></div>
    </div>
    <div class="form-group">
    <label class="control-label col-xs-4">Position</label>
       <div class="col-xs-8"> <input type="text" class="form-control" name="position" id="position" placeholder="Position"></div>
    </div>
    <div class="form-group">
    <label class="control-label col-xs-4">Organisation</label>
       <div class="col-xs-8"> <input type="text" class="form-control" name="organisation" id="organisation" placeholder="Organisation"></div>
    </div>

	<div class="form-group form-horizontal">
        <label class="col-xs-4 control-label">Category</label>
        <div class="col-xs-8 selectContainer">
        
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
    </div>
    		
			 <button type="submit" class=" btn-lnk" id="btn-editprofile" onclick="return save()">Submit</button>
	<a href="/homeuser" class="btn-lnk">Cancel</a>
			  
	 </form>
	</div>
	  </div> 
			  	 
			    
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:info@quakecore.nz">info@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		<script  src="/js/editprofile.js"></script>
		</body>
</html>