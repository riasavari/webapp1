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
									<li id="homeUserTab"><a href="/homeuser"><strong>Home</strong></a></li> 
									<li id="homeAdminTab"><a href="/homeAdmin"><strong>Home</strong></a></li> 
									<li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li> 
								</ul>
					  </div> 
					  
			  	 <!-- <div class="topbar"></div>  --> 
				<div id="content" class="content-width">
				  	<div class="container">
        <div id="userid"  style="display:none;">
				${email}
			</div>
      <div id="username"  style="display:none;">
				${name}
			</div>
       <div id="allusers"  style="display:none;">
				${peopleList}
			</div>
			  <!-- <div id="search"  class="well well-sm" style="display:block;">
				Please do a search to find a name in this list.
				Refresh the page to see latest additions.
			</div> -->
      <h3 class="form-heading">QuakeCoRE Community</h3>
        <div class="jumbotron">
 			<!-- <span style="white-space: nowrap"> -->
			<div style="white-space: nowrap" align="center">
			 <c:choose>
           <c:when test="${empty peopleList}"><c:out value="Sorry, currently no publications to list" /></c:when> 
			
      		 <c:otherwise>
		        <table border="1" cellpadding="5" width="relative">
		            
		            <!-- <tr>
		                
		                <th>Name</th>
						
		            </tr> -->
		            <c:forEach var="person" items="${peopleList}">
		                <tr>
		                  <td><img src="graphics/person-icon-sm.png" /></td> <td><b><c:out value="${person.firstname}" />&nbsp<c:out value="${person.lastname}" />.</b><c:out value="${person.position}" /><br><i><c:out value="${person.organisation}" /></i></td> 
		                   
		                </tr>
		            </c:forEach>
		        </table>
		</c:otherwise>
		</c:choose>
		    </div>
		<!-- </span> -->
	</div>
	 </div>
			  	 </div>	
			    
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:info@quakecore.nz">info@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
		  <%-- <%@include file="popup.jsp" %>   --%>
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		<script  src="/js/viewAuthorise.js"></script>
		</body>
		</html>