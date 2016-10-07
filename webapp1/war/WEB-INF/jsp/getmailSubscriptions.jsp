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
					   
			  	 <!-- <div class="topbar"></div> --> 
				<div id="content" class="content-width">
				  	<div class="container"> 
   <div id="userid"  style="display:none;">
		${email}
	</div>
	 <h3 class="form-heading">Welcome Admin!</h3>
	<div class="jumbotron">
  <form  method="post"  class="fillform" name="adminhome" action="sent">
    <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-success" id="Err"></span>
        </p>
    </div>
   <br><br>
  <h4 class="form-heading">Choose your emailing list</h4>
    <div class="longNameFields"  id="radio-group">
        <!--  To keep a value cheked as default
        <label class="btn btn-default active">
            <input type="radio" name="radio-m1" value="radio-m1"  checked=""> QuakeCoRE Monthly Newsletter
        </label>-->
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="m1" id="QuakeCoRE Monthly Newsletter"> QuakeCoRE Monthly Newsletter
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="t1" id="Technology Platform 1">TP 1 - Large-scale laboratory facilities
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="t2" id="Technology Platform 2">TP 2 - Field-testing and monitoring
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="t3" id="Technology Platform 3">TP 3 - Multi-disciplinary community databases
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="t4" id="Technology Platform 4">TP 4 - Computational simulation and visualization
       </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="f1" id="Flagship 1">FP 1 - Ground Motion Simulation
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="f2" id="Flagship 2">FP 2 - Liquefaction Impacts on Infrastructure
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="f3" id="Flagship 3">FP 3 - Heritage, Safety and Economics: Addressing Earthquake-prone Buildings
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="f4" id="Flagship 4">FP 4 - Next-generation Infrastructure: Low-damage and Repairable Solutions
        </label></div>
        <div class="radio"><label>
            <input type="radio"  name="radioSubs" value="f5" id="Flagship 5">FP 5 - Pathways to Improved Resilience
        </label></div>
        <div class="radio"><label>
            <input type="radio" name="radioSubs" value="f6" id="Flagship 5">FP 6 - Spatially-distributed Infrastructure
        </label></div>
        
</div>
 <input type="email" class="form-control" name="email" id="email" placeholder="Enter email address"> 
    <button type="submit" class="myButton" id="btn-submit" onclick="return validate()">Email Contacts</button>
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
		<script  src="/js/contactlist.js"></script>
		</body>
	</html>