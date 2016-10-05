<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<div id="paper"  style="display:none;">
				${singlePub}
			</div>
      <h3 class="form-heading">Edit Publication</h3>
        <div class="jumbotron">
  <form  method="post"  class="fillform" name="formLogin" action="newpublication">

   <div id="loading" style="display: none; position: absolute;z-index: 2001;">...</div>
   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="err"></span>
            
        </p>
    </div>
    <br><br><br>
    
     <div class="form-group">Publication Number : 
      		<label class="col-xs-4 control-label"><c:if test="${not empty singlePub.publicationId}"><c:out value="${singlePub.publicationId}" /></c:if> </label>
      		</div>
      		 
		 <div class="form-group">
      		<label class="col-xs-4 control-label">Year</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="year" id="year">
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
            </select>
        </div>
    	 </div>
    	  <div class="form-group">
      		<label class="col-xs-4 control-label">Status</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="status" id="status">
                <option value="Submitted">Submitted</option>
                <option value="Accepted">Accepted</option>
                <option value="Published">Published</option>
            </select>
        </div>
    	 </div>
    	  <div class="form-group">
      		<label class="col-xs-4 control-label">Article Type</label>
        <div class="col-xs-5 selectContainer">
            <select class="form-control selectwidthauto" name="article" id="article">
                <option value="journal">Journal</option>
                <option value="conference">Conference</option>
                <option value="book">Book</option>
                 <option value="bookchapter">Book Chapter</option>
                <option value="peerreviewed">Other (peer-reviewed)</option>
                <option value="nonpeerreviewed">Other (non peer-reviewed)</option>
            </select>
        </div>
    	 </div>
    	
    	  <div class="form-group">
      		<input type="text" class="form-control" name="author" id="author" placeholder="Authors (e.g: Carter C, Smith A, Bruce N)">
    	 </div>
    	 
		 <div class="form-group" >
      		<input type="text" class="form-control" name="title" id="title" placeholder="Article Title">
    	 </div>
    	 
		 <div class="form-group"> 
      		<input type="text" class="form-control" name="venueName" id="venueName" placeholder="Journal / Conference / Workshop / Book Title">
    	 </div>
    	 
    	 <!-- <div class="form-group"> 
      		<input type="text" class="form-control" name="proceedName" id="proceedName" placeholder="Proceedings Title">
    	 </div> -->
    	
    	 <div id="optional">
		 <div class="form-group" style="display:none;" id="volumeDiv">
      		<input type="text" class="form-control" name="volume" id="volume" placeholder="Volume,issue no, if available (e.g: 143,8)">
    	 </div>
    	 
		 <div class="form-group" style="display:none;" id="pageDiv">
      		<input type="text" class="form-control" name="page" id="page"  placeholder="Number of pages">
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
      		<input type="text" class="form-control" name="publisher" id="publisher" placeholder="Publisher, if available">
    	 </div>
			</div>
		<button type="submit" class="myButton" id="btn-edit-pub" onclick="return validate()">Update</button>
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
		<!-- <script  src="/js/editpublication.js"></script> -->
		</body>
		</html>