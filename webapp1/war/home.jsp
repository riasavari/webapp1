<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	 <link  rel="stylesheet" href="/css/main.css">
		<script  src="/lib/jquery-min-latest.js"></script>
		<script  src="bootstrap/js/bootstrap.min.js"></script>
		<script  src="/js/login.js"></script>
		
<head><title>Sign in</title></head>
<body>
	
            
  <form  method="post"  class="fillform" name="formLogin" action="select">
   <div id="messagebox" class="alertbox" style="display: none; position: absolute;z-index: 2001;">
        <p>
            <span class="alert alert-danger" id="loginErr"></span>
        </p>
    </div>
    <br>
  <h2 class="form-heading">Please sign in</h2>
  
  
    <div class="form-group">
     <!--  <label for="email">Email:</label>-->
      <input type="email" class="form-control" id="email" placeholder="Email address">
    </div>
    <div class="form-group">
      <!-- <label for="pwd">Password:</label>-->
      <input type="password" class="form-control" id="password" placeholder="Password">
    </div>
   <!--   <div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>-->
   
			<a href="signup" class="btn btn-link">New User</a>
	<a href="forgotpassword" class="btn btn-link">Forgot Password</a>
    <button type="submit" class="btn btn-primary" id="btn-login" onclick="return login()">Submit</button>
  
    </div>
  </form>

</body>
</html>