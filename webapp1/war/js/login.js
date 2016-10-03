
$(document).ready(function() 
{
	$(document.body).keypress(function(event){
        if(event.keyCode == 13){
          $('#btn-login').click();
        }
      });
	
	var userid=$('#userid').text();
	if(userid === null || $.trim(userid) === "")
	{
		$("#logoutTab").hide();
		
	}
	
	login = function ()
	{
		
		var email	=	document.getElementById("email").value;
		var password	=	document.getElementById("password").value;
		var takeToServer	=	validate(email,password);
		
		if(takeToServer)
	    {
			var result = intoServer(email,password);
			
			return result;
			
	    }
		else
			return takeToServer;
		
	}
	
	//client side validation
	function validate(email,password)
		{
		
		if((!isValid(email)) && (!isValid(password)))
			{
				$("#modalbox").modal().hide();
				document.getElementById("email").focus(); 
				$('#loginErr').html("Please fill in the details");
	            $('#messagebox').fadeIn().delay(2000).fadeOut();
				 return false;
			}
		else if((!isValid(email)) || (!isValidEmail(email)))
		{ 	$("#modalbox").modal().hide();
			 document.getElementById("email").value="";  
             document.getElementById("password").value="";  
             document.getElementById("email").focus(); 
             $('#loginErr').html("Please enter a valid email address");
             $('#messagebox').fadeIn().delay(2000).fadeOut();
			 return false;
		}
		else if(!isValid(password))
			{ $("#modalbox").modal().hide();
			document.getElementById("password").value="";  
	        document.getElementById("password").focus(); 
			$('#loginErr').html("Please enter your password");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			return false;
			}
		else
			{
			
			 return true;
				
			}
	          
		}
	
	function intoServer(email,password)
	{
		//console.log(email+"----------"+password);
$.ajax({
    type: 'POST', 
    url: '/checklogin', 
    data:{id : email,pwd : password},
    dataType:'text',
    success: function(response)
             {
			    	console.log("SUCCESS");
			    	console.log(response);
			    	var nextPage = "home";
			    	if(response === "adminMatched")
			    	{
			    		nextPage = "homeAdmin";
			    	}
			    	else if(response === "adminMismatched" ||	response === "userMismatched")
			    	{ 
			    	$('#modalbox').modal('hide');
			    	document.getElementById("password").value="";  
		    		document.getElementById("password").focus(); 
			    		$('#loginErr').html("Incorrect password");
			    		$('#messagebox').fadeIn().delay(2000).fadeOut();
			    		
			    		return false;
			    	}
			    	else if(response === "noAccount")
			    	{ 
			    		$('#modalbox').modal('hide');
			    	document.getElementById("email").value="";  
		    		document.getElementById("password").value="";  
		    		
			    		$('#loginErr').html("Email not found");
			    		$('#messagebox').fadeIn().delay(2000).fadeOut();
			    		
			    		return false;
			    	}
			    	else if(response === "notActive")
			    		{
			    		$('#modalbox').modal('hide');
				    	document.getElementById("email").value="";  
			    		document.getElementById("password").value="";  
			    		 
				    		$('#loginErr').html("Account not activated yet");
				    		$('#messagebox').fadeIn().delay(2000).fadeOut();

				    		return false;
			    		}
			    	else 
			    	{
			    		nextPage = "homeuser";
			    	}
			    	
			    	window.location=nextPage;
			    	return true;
             }
	});

	return false;
	}
	
	var isValid = function(someValue) {
        if (someValue === null || $.trim(someValue) === "") 
        	return false;
        else
        	return true;
    }

    var isValidEmail = function(emailId) {
    	var flag_email = true;
        if (emailId == null && $.trim(emailId) == "") 
        	return false;
        var emailPattern =  /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        flag_email = emailPattern.test(emailId);
        return flag_email;
    }
});	
	
