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
             <div id="temp"  style="display:none;">
				${subslist}
			 </div>
			<div id="userid"  style="display:none;">
				${email}
			</div> 
              <h3 class="form-heading">Mailing List</h3>
             <div class="jumbotron">
  	<form  method="post"  class="fillform" name="formMailingList" action="done">
  
  	<!-- commented the below because no need for error message here (user can select none as his mailing preference) -->
	   <!-- <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
	        <p>
	            <span class="alert alert-danger" id="mailListErr"></span>
	        </p>
	    </div>
	     
	      <br> <br> <br> -->
		
		<div id="cbox-allnone">
			<div class="checkbox-inline">
			  <label><input type="checkbox" value="cbox-all"   id="cbox-all">All</label>
			</div>
			<div  class="checkbox-inline">
			  <label><input type="checkbox" value="cbox-none"  id="cbox-none">None</label>
			</div>
		</div>
		<div  class="longNameFields" id="cbox-group">
			<div class="checkbox">
			  <label><input type="checkbox" value="m1" id="cbox-newsletter">  QuakeCoRE Monthly Newsletter</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="t1" id="cbox-tech1">TP 1 - Large-scale laboratory facilities</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="t2" id="cbox-tech2">TP 2 - Field-testing and monitoring</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="t3" id="cbox-tech3">TP 3 - Multi-disciplinary community databases</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="t4" id="cbox-tech4">TP 4 - Computational simulation and visualization</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="f1" id="cbox-flag1">FP 1 - Ground Motion Simulation</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="f2" id="cbox-flag2">FP 2 - Liquefaction Impacts on Infrastructure</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="f3" id="cbox-flag3">FP 3 - Heritage, Safety and Economics: Addressing Earthquake-prone Buildings</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="f4" id="cbox-flag4">FP 4 - Next-generation Infrastructure: Low-damage and Repairable Solutions</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="f5" id="cbox-flag5">FP 5 - Pathways to Improved Resilience</label>
			</div>
			<div class="checkbox">
			  <label><input type="checkbox" value="f6" id="cbox-flag6">FP 6 - Spatially-distributed Infrastructure</label>
			</div>
	</div>
	
   		<button type="submit" class="myButton" id="btn-submit" onclick="return validate()">Submit</button>
   		<a href="/homeuser" class="btn-lnk">Cancel</a>
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
<script  src="/js/mailinglist.js"></script>
</body>
</html>		