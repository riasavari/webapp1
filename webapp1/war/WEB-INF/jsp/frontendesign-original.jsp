<!DOCTYPE html>
<html><!-- InstanceBegin template="/Templates/main.dwt" codeOutsideHTMLIsLocked="false" --><head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 
<link href="/css/styles.css" rel="stylesheet" type="text/css">
<link href="/css/main.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
		<link href="/css/jumbotron-narrow.css" rel="stylesheet">
	 
<script type="text/javascript" src="scripts/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="scripts/custom.js"></script>
<script type="text/javascript" src="scripts/jquery.rsv-2.5.1.js"></script>
<script type="text/javascript" src="scripts/respond.min.js"></script>
 
<!-- InstanceBeginEditable name="doctitle" -->
<title>QuakeCoRE | Home</title>

<meta name="Keywords" content="QuakeCoRE, research in earthquake resilience, University of Canterbury, New Zealand, University, ">
<meta name="Description" content="QuakeCoRE Home Page, University of Canterbury, Christchurch, New Zealand">

<!-- InstanceEndEditable -->
<!-- InstanceBeginEditable name="head" -->
<style type="text/css">
</style>
<!-- InstanceEndEditable -->



</head>

<body>
<div id="wrapper">

<div id="header">
<h1>QuakeCoRE</h1>
<h2>Centre for Earthquake Resilience</h2>
</div>
    
 

<div id="imagearea">

</div>
    

 <!--   <div id="topnavbar"><button id="nav-button">Toggle Navigation</button>
	<ul>
		<li id="homeTab"><a href="/"><strong>Home</strong></a></li> 
		<li id="logoutTab"><a href="/logout"><strong>Logout</strong></a></li> 
	</ul>
</div>  --> 
  <div class="topbar"></div> 

	<div id="content" class="content-width"><!-- InstanceBeginEditable name="Content" -->
	  
  		       <div class="container">  
												         <!--  <div class="header">
												        <nav>
												          <ul class="nav nav-pills pull-right">
												            <li id="homeTab" role="presentation" class="active"><a href="">Home</a></li>
												            <li id="logoutTab" role="presentation"><a href="/logout">Logout</a></li>
												            
												          </ul>
												        </nav>
												       <h3 class="text-muted">QuakeCoRE</h3> 
												       
												      </div> -->
        <div id="userid"  style="display:none;">
		${email}
		</div>
	 <h3 class="form-heading">Sign in</h3>
	 
	<div class="jumbotron">
	
  <form  method="post"  class="fillform" name="formLogin" action="select">
   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="loginErr"></span>
        </p>
    </div>
    <br><br><br>
    <div class="form-group">
     <!--  <label for="email">Email:</label>-->
      <input type="email" class="form-control" id="email" placeholder="Email">
     <!--  <table style="width:100%;"><tr><td><input type="email" class="form-control" id="email" placeholder="Email"></td><td><span style="color:red;">*</span></td></tr></table> -->
    </div>
    
    <div class="form-group">
      <!-- <label for="pwd">Password:</label>-->
      <input type="password" class="form-control" id="password" placeholder="Password">
    </div>
  
		<a href="forgotpassword" class="btn-link">Forgot Password</a> |
		 <a href="signup" class="btn-link"> Sign up</a>
	 <button type="submit" class="myButton" id="btn-login" onclick="return login()">Submit</button>
  </form>
 </div>
 	
  </div> 
 	</div>	
    
  
    
		<div id="footer"><p><strong>QuakeCoRE | 
  </strong><a href="mailto:research@quakecore.nz">research@quakecore.nz</a><strong> | </strong> </p>
<!-- <p>Banner image used with permission from <a href="http://commons.wikimedia.org/wiki/File:CanterburyCollegeChemistry_gobeirne.jpg">Greg O'Beirne</a></p> -->
</div>
</div>

 <script  src="/lib/jquery-min-latest.js"></script>
	<script  src="bootstrap/js/bootstrap.min.js"></script>
	<script  src="/js/login.js"></script>

<!-- InstanceEnd -->
</body>

</html>