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
			<div id="abs"  style="display:block;">
				${myabs}
			</div>
      </div>
      <!--  <span id="myPublications" class="hide"> -->
      <h3 class="form-heading">View my abstracts</h3>
        <div class="jumbotron">
			<div align="center">
		        <table border="1" cellpadding="5">
		            <tr>
		                <th>ID</th>
						<th>Title</th>
						<th>Action</th>
		            </tr>
		            <c:forEach var="oneAbstract" items="${myabs}">
		                 <tr>
		                    <c:if test="${not empty oneAbstract.abstractId}"><td><c:out value="${oneAbstract.abstractId}" /></td></c:if> 
		                   <td> 
							 
							<c:if test="${not empty oneAbstract.title}"><c:out value="${oneAbstract.title}"/></c:if> 
							
							</td>
							
							<td><button onclick="update(${oneAbstract.abstractId})">Update</button ></td>
		                </tr>
		            </c:forEach>
		        </table>
		    </div>
		</div>
		<!-- </span> -->
	 </div>  
	 
				  <div id="footer"><p><strong>QuakeCoRE | 
				  </strong><a href="mailto:info@quakecore.nz">info@quakecore.nz</a><strong> | </strong> </p>
				  </div> 
		</div>
		<%--  <span id="editPublication" class="hide">
		<%@ include file="newpublication.jsp" %>
	</span>  --%>
		 
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		 <script  src="/js/viewmyabstract.js"></script>
		</body>
		</html>