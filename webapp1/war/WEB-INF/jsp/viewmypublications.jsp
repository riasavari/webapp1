<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
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
							<div id="pubs"  style="display:none;">
								${mypubs}
							</div>
							<div id="singlepub"  style="display:none;">
								${singlePub}
							</div>
							<div id="buttonid"  style="display:none;">
								
							</div>
							<div id="refresh"  class="well well-sm" style="display:block;">
								Contact <a href="mailto:quakecore.nz@gmail.com">admin</a> to remove any item.
							</div>
      				</div>
      <!--  <span id="myPublications" class="hide"> -->
      <h3 class="form-heading">View my publications</h3>
        <div class="jumbotron">
        <form  method="post" name="formLogin" action="newpublication">
       <!--  <span style="white-space: nowrap"> -->
          <div style="white-space: nowrap" align="center">
          <c:choose>
           <c:when test="${empty mypubs}"><c:out value="Sorry, currently no publications to update" /></c:when> 
			
      		 <c:otherwise>
		        <table  border="1" cellpadding="5">
		            
		            <tr id="rowFont">
		                <th>ID</th>
		                <th>Details</th>
						<th>Funding</th>
						<th>Article</th>
						<th>Status</th>
						<th>Year</th>
						<th>Action</th>
						
		            </tr>
					
		            <c:forEach var="pub" items="${mypubs}">
		                 <tr id="rowFont">
							 
							<%--  <c:set var="pubStatus" scope="application" value="${pub.status}"/> --%>
							 
							  <c:if test="${not empty pub.pubIdStr4digit}"><td><c:out value="${pub.pubIdStr4digit}" /></td></c:if> 
		                   <td> 
							<c:if test="${not empty pub.author}"><c:out value="${pub.author}"/>'</c:if> 
							<c:if test="${not empty pub.title}"><c:out value="${pub.title}"/>',</c:if> 
							<c:if test="${not empty pub.venueName}"><i><c:out value="${pub.venueName}"/></i><c:if test = "${pub.status == 'Published'}">,</c:if></c:if>
							<c:if test="${not empty pub.location}"><c:out value="${pub.location}"/>.</c:if>
							<c:if test="${not empty pub.publisher}"><c:out value="${pub.publisher}"/>.</c:if>
							<c:if test="${not empty pub.volume}"><b><c:out value="${pub.volume}"/></b>:</c:if>
							<c:if test="${not empty pub.page}"><c:out value="${pub.page}"/></c:if>
							<c:if test="${not empty pub.url}">,<c:out value="${pub.url}"/></c:if>
							<c:if test="${not empty pub.publishDate}">,<c:out value="${pub.publishDate}"/>.</c:if>
							</td>
							<c:if test="${not empty pub.fund}"><td><c:out value="${pub.fund}"/></td></c:if> 
							<c:if test="${not empty pub.article}"><td><c:out value="${pub.article}"/></td></c:if> 
							<c:if test="${not empty pub.status}"><td><c:out value="${pub.status}" /></td></c:if> 
							<c:if test="${not empty pub.year}"><td><c:out value="${pub.year}" /></td></c:if>
							<td><button type="submit" class="myButton" name="actionBtn" value="<c:out value="${pub.publicationId}" />">Update</button ></td>
							
		                </tr>
		            </c:forEach>
		
		        </table>
		</c:otherwise>
		</c:choose>
		    </div>
		<!-- </span> -->
		</form>
		</div>
		
		<!-- </span> -->
	 </div>  
	 
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:research@quakecore.nz">research@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
		<%--  <span id="editPublication" class="hide">
		<%@ include file="newpublication.jsp" %>
	</span>  --%>
		 
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		 <!-- <script  src="/js/viewmypublication.js"></script> -->
		</body>
		</html>