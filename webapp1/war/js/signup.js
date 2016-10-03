

	$(document).ready(function() 
	{
		/*$(document.body).keypress(function(event){
	        if(event.keyCode == 13){
	          $('#btn-signup').click();
	        }
	      });*/
		//for user session display (to know logged in/out)
		var userid=$('#userid').text();
		//if no session hide the logout link at the top
		if(userid === null || $.trim(userid) === "")
		{
			$("#logoutTab").hide();
		}
		
		
		signup = function ()
		{ 
			//console.log("inside signup () "); 
			//$("html, body").animate({ scrollTop: 0 }, "slow");
			$('#modalbox').modal('show');
			var emailid	=	document.getElementById("email").value;
			var endOutput=validate();
			return endOutput;
			
		}
		
	
		function validate()
		{
			//alert("comes to validate in js");
			
			var email			=	document.getElementById("email").value;
			var firstname		=	document.getElementById("firstname").value;
			var lastname		=	document.getElementById("lastname").value;
			var password		=	document.getElementById("password").value;
			var confirmPassword	=	document.getElementById("retype-password").value
			var title			=	document.getElementById("title").value;
			var position		=	document.getElementById("position").value;
			var organisation	=	document.getElementById("organisation").value;
			var category		=	document.getElementById("category").value;
			var tick			=	document.getElementById('agree-cbox').checked;
			
			//console.log(email);console.log(firstname);console.log(lastname);console.log(password);console.log(confirmPassword);
			
			
			if(!isValid(email) && !isValid(firstname) && !isValid(lastname) && !isValid(password) && !isValid(confirmPassword) && !isValid(position) && !isValid(organisation) )
			{
				$('#modalbox').modal().hide();
				document.getElementById("firstname").value="";  
			    document.getElementById("firstname").focus(); 
		    $('#signupErr').html("Please fill in the details");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   // $("html, body").animate({ scrollTop: 0 }, "slow");
		   
			return false;
			}
			else if(!isValid(firstname) || !isValidName(firstname))
			{$('#modalbox').modal().hide();
			document.getElementById("firstname").value="";  
		    document.getElementById("firstname").focus(); 
		    $('#signupErr').html("Please enter a valid firstname with letters only");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		  //  $("html, body").animate({ scrollTop: 0 }, "slow");
		    
			return false;
			}
			else if(!isValid(lastname) || !isValidName(lastname))
			{$('#modalbox').modal().hide();
			document.getElementById("lastname").value="";  
			document.getElementById("lastname").focus(); 
			$('#signupErr').html("Please enter a valid lastname with letters only");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			//$("html, body").animate({ scrollTop: 0 }, "slow");
			
			return false;
			}
			else if(!isValid(email) || !isValidEmail(email))
			{$('#modalbox').modal().hide();
			document.getElementById("email").value="";  
	        document.getElementById("email").focus(); 
		    $('#signupErr').html("Please enter a valid email address");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   // $("html, body").animate({ scrollTop: 0 }, "slow");
		    
			return false;
			}
			else if(!isValid(password) || !isValidPassword(password))
			{$('#modalbox').modal().hide();
			document.getElementById("password").value="";  
		    document.getElementById("password").focus(); 
		    $('#signupErr').html("Password is minimum 6 characters with numbers and letters only");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		  //  $("html, body").animate({ scrollTop: 0 }, "slow");
		   
			return false;
			}
			else if(!isValid(confirmPassword)) 
			{$('#modalbox').modal().hide();
			document.getElementById("retype-password").value="";  
		    document.getElementById("retype-password").focus(); 
		    $('#signupErr').html("Please retype your password");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   // $("html, body").animate({ scrollTop: 0 }, "slow");
		   
			return false;
			} 
			else if(password !== confirmPassword)
			{$('#modalbox').modal().hide();
			document.getElementById("password").value=""; 
	        document.getElementById("retype-password").value="";  
	        document.getElementById("password").focus(); 
		    $('#signupErr').html("Password and retyped password should be the same");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   // $("html, body").animate({ scrollTop: 0 }, "slow");
		    
			return false;
			}
			else if(!isValid(position))
			{$('#modalbox').modal().hide();
			document.getElementById("position").value="";  
			document.getElementById("position").focus(); 
			$('#signupErr').html("Please enter your position");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
		//	$("html, body").animate({ scrollTop: 0 }, "slow");
			
			return false;
			}
			else if(!isValid(organisation))
			{$('#modalbox').modal().hide();
			document.getElementById("organisation").value="";  
			document.getElementById("organisation").focus(); 
			$('#signupErr').html("Please enter your organisation");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			//$("html, body").animate({ scrollTop: 0 }, "slow");
			
			return false;
			}
			else if($.trim(tick) === "false")
			{
				$('#modalbox').modal().hide();
				$('#signupErr').html("Please agree to the Terms and Conditions");
				$('#messagebox').fadeIn().delay(2000).fadeOut();
				return false;
			}
			else
				{
				
				}
			//console.log("final validate in signup");
			var userInfo = {};
			userInfo["email"]	=	email;
			userInfo["firstname"]	=	firstname;
			userInfo["lastname"]	=	lastname;
			userInfo["password"]	=	password;
			userInfo["title"]	=	title;
			userInfo["position"]	=	position;
			userInfo["organisation"]	=	organisation;
			userInfo["category"]	=	category;
			console.log(userInfo);
			
			
			var result=intoServer(userInfo);
			return result;
		}
		
		function intoServer(userInfo)
		{//send JSON object
			var result=false;
			$.ajax({
				async:false,
			    type: 'POST', 
			    url: '/ifExistingUser', 
			    data:{userInfo:JSON.stringify(userInfo)},
			    dataType:'text',
			    success: function(response)
			             {
						    	//alert("1"+response);	
						    	if(response === "existingUser")
						    	{$('#modalbox').modal('hide');
						    		//alert("2");
						    		window.location="exusersignup";
						    		return false;
						    	}
						    	else if(response === "noAccount")
						    	{
						    		//alert("3");	
						    		result=true;
						    		return true;
						    	}
						    	else
						    		{$('#modalbox').modal('hide');
						    		//alert("4");	
						    		window.location="apologies";
						    		return false;
						    		}
						    	
			             },
			             error: function(){
			             }
			  
				});
			//alert("6")
	
		return result;
	
		}
		
		var isValid = function(someValue) {
	        if (someValue === null || $.trim(someValue) === "") 
	        	return false;
	        else
	        	return true;
	    }
		 var isValidName = function(name) {
		        var flag = true;
		        var namePattern =  /^[a-z]+$/i;
		        flag = namePattern.test(name);
		        return flag;
		    }
		
	    var isValidEmail = function(emailId) {
	        var flag_email = true;
	        var emailPattern =  /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	        flag_email = emailPattern.test(emailId);
	        return flag_email;
	    }
	    
	    var isValidPassword = function(password) {
	        var flag = true;
	        if (password.length<6) 
	        	return false;
	        var passwordPattern =  /^[a-z0-9]+$/i;
	        flag = passwordPattern.test(password);
	        return flag;
	    }
		
		
	});
