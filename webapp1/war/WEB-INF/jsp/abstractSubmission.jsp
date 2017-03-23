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
     
      <h3 class="form-heading">Abstract Submission</h3>
        <div cl ass="jumbotron">
  <form  method="post"  class="fillform" name="formAbstractSub" action="abstractSubmission">

   <div id="loading" style="display: none; position: absolute;z-index: 2001;">...</div>
   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="err"></span>
            
        </p>
    </div>
    <br><br><br>
		 <div class="form-group">
      		<label class="col-xs-4 control-label">Year</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="year" id="year">
                <option value="2016">2016</option>
                <!-- <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option> -->
            </select>
        </div>
    	 </div>
    	  
    	  <div class="form-group">
      		<label class="col-xs-4 control-label">Category</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="category" id="category">
                <option value="f1">Flagship 1</option>
                <option value="f2">Flagship 2</option>
                <option value="f3">Flagship 3</option>
                <option value="f4">Flagship 4</option>
                <option value="f5">Flagship 5</option>
                <option value="f6">Flagship 6 </option>
                <option value="t1">TP 1</option>
                <option value="t2">TP 2</option>
                <option value="t3">TP 3</option>
                <option value="t4">TP 4</option>
                
            </select>
        </div>
    	 </div> 
    	 
    	  <div class="form-group">
      		<input type="text" class="form-control" name="author" id="author" placeholder="Authors (e.g: Carter C, Smith A, Bruce N)">
    	 </div>
    	 
		 <div class="form-group" >
      		<input type="text" class="form-control" name="title" id="title" placeholder="Title">
    	 </div>
    	 
		 <div class="form-group">
    <textarea rows="4" cols="50" class="form-control" name="abstractDescription" id="abstractDescription" placeholder="abstract"></textarea>
    	 </div>
    	 
    	 <div class="form-group"> 
      		<input type="text" class="form-control" name="project" id="project" placeholder="Project">
    	 </div>
    	
    	<div class="form-group"> 
      		<input type="text" class="form-control" name="url" id="url" placeholder="URL">
    	 </div> 
		<button type="submit" class="myButton" id="btn-new-abstract" onclick="return validate()">Get me abstract no</button>
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
		  <script  src="/js/abstractSubmission.js"></script>
		</body>
		</html>