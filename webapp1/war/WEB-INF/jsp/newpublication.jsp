<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"> -->
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<div id="userid"  style="display:none;">
				${email}
			</div>
			<div id="editpub"  style="display:none;">
				${editPub}
			</div>
			<div id="buttonid"  style="display:none;">
				
			</div>
		<div id="wrapper">
		
			<div id="temp" style="display:none;">
			<div>${year}</div>
			<div>${fund}</div>
		 	<div>${status}</div>
		 	<div>${article}</div>
		 	<div>${author}</div>
		 	<div>${title}</div>
		    <div>${venueName}</div>
		    <div>${volume}</div>
		    <div>${page}</div>
		    <div>${location}</div>
		 	<div>${url}</div>
		    <div>${publishDate}</div>
		    <div>${publisher}</div>
		    <div>${publicationNo}</div>
		     <div>${descOutputOther}</div>
		     <div>${project}</div>
		</div>

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
        
      <h3 class="form-heading">My Publication</h3>
        <div class="jumbotron">
  <form  method="post"  class="fillform" name="formLogin" action="newpublication">

  
   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="err"></span>
            
        </p>
    </div>
    <br><br><br>
    <div class="form-group" >
      		<input type="hidden" class="form-control" name="editNo" id="editNo">
    	 </div>
    	 <!-- copy from here for editPublication -->
		 <div class="form-group">
      		<label class="col-xs-4 control-label">Year</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="year" id="year">
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
                <option value="2019">2019</option>
                <option value="2020">2020</option>
            </select>
        </div>
        </div>
        <div class="form-group">
        <label class="col-xs-4 control-label">Funding</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="fund" id="fund">
                <option value="Aligned">Aligned</option>
                <option value="Direct">Direct</option>
            </select>
        </div>
    	 </div>
    	  <div class="form-group">
      		<label class="col-xs-4 control-label">Status</label>
        <div class="col-xs-5 selectContainer"><!-- if you change/add the value names in this dropdown list,change in js files accordingly -->
            <select class="form-control selectwidthauto" name="status" id="status">
                <option value="Submitted">Submitted</option>
                <option value="Accepted">Accepted</option>
                <option value="Published">Published</option>
            </select>
        </div>
    	 </div>
    	  <div class="form-group">
      		<label class="col-xs-4 control-label">Article Type</label>
        <div class="col-xs-5 selectContainer"><!-- if you change/add the value names in this dropdown list,change in js files accordingly -->
            <select class="form-control selectwidthauto" name="article" id="article">
                <option value="Journal">Journal Article (peer-reviewed)</option>
                <option value="Conference">Conference Article (peer-reviewed)</option>
                <option value="Book">Book (peer-reviewed)</option>
                 <option value="Book chapter">Book Chapter (peer-reviewed)</option>
                <option value="Peer-reviewed">Other (peer-reviewed)</option>
                <option value="Non peer-reviewed">Other (non peer-reviewed)</option>
            </select>
        </div>
    	 </div>
    	<div class="form-group">
      		<input type="text" class="form-control" name="project" id="project" placeholder="project(s),if applicable (e.g: 16002, 16004 or TP4)">
    	 </div>
    	  <div class="form-group">
      		<input type="text" class="form-control" name="author" id="author" placeholder="Authors (e.g: Carter C, Smith A, Bruce N)">
    	 </div>
    	 
		 <div class="form-group" >
      		<input type="text" class="form-control" name="title" id="title" placeholder="Article Title">
    	 </div>
    	 <div id="optional">
		 <div class="form-group" style="display:none;" id="venueDiv"> 
      		<input type="text" class="form-control" name="venueName" id="venueName" placeholder="Journal / Conference / Workshop / Book Title">
    	 </div>
    	 
    	  <div class="form-group" style="display:none;" id="descDiv"> 
      		<input type="text" class="form-control" name="descOutputOther" id="descOutputOther" placeholder="Description of output (e.g: Technical report)">
    	 </div> 
    	
		 <div class="form-group" style="display:none;" id="pageDiv">
      		<input type="text" class="form-control" name="page" id="page"  placeholder="Number of pages">
    	 </div>
    	 <div class="form-group" style="display:none;" id="volumeDiv">
      		<input type="text" class="form-control" name="volume" id="volume" placeholder="Volume,issue no, if available (e.g: 143,8)">
    	 </div>
    	 
    	 <div class="form-group" style="display:none;" id="locationDiv">
      		<input type="text" class="form-control" name="location" id="location" placeholder="Location, if available (e.g: Berlin,Germany)">
    	 </div>
    	 
		 <div class="form-group" style="display:none;" id="urlDiv">
      		<input type="text" class="form-control" name="url" id="url" placeholder="DOI/UID/PubMedID, if available">
    	 </div>
    	 
    	 <div class="form-group" style="display:none;" id="dateDiv">
      		<input type="text" class="form-control" name="dates" id="dates" placeholder="Dates (e.g: 7-13 May 2016)">
    	 </div>
    	 
    	  <div class="form-group" style="display:none;" id="publisherDiv">
      		<input type="text" class="form-control" name="publisher" id="publisher" placeholder="Publisher">
    	 </div>
			</div>
		<button type="submit" class="myButton" name="submitBtn" id="btn-new-pub" onclick="return validate(id)">Submit</button>
		<button type="submit" class="myButton" name="submitBtn" id="btn-edit-pub" onclick="return validate(id)">Submit</button>
		<a href="/homeuser" class="btn-lnk">Cancel</a>
	 </form>
	</div>
	 </div>
			  	 </div>	
			    
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:info@quakecore.nz">info@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
		 	  <%@include file="confirmpopup.jsp" %> 
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		<script  src="/js/newpublication.js"></script>
		</body>
		</html>