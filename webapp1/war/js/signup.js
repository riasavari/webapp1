

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
		var raceList;
		var gender;
		
			 $("#country").on("change", function(o){
			     var status = this.value;
			     
			   if(status=="NZ")
				   {
				   $('#ethnicDiv').show();
				   $('#e2').click(function() {
						
					    if ($(this).prop('checked')) {
					    	$("#iwiDiv").show();
					    } 
					    else
					    	{
					    	$("#iwiDiv").hide();
					    	document.getElementById("iwi").value="";  
							}
					});
			 		}
			   else
				   {
				   $('#ethnicDiv').hide();
				   $('#cbox-group input').prop('checked', false);
				   $("#iwiDiv").hide();
				   document.getElementById("iwi").value="";
				   }
			  });

		
		
		signup = function ()
		{ 
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
			var position		=	document.getElementById("position").value;
			var organisation	=	document.getElementById("organisation").value;
			var orcId			=	document.getElementById("orcId").value;
			var category		=	document.getElementById("category").value;
			var country			=	document.getElementById("country").value;
			var iwi				=	document.getElementById("iwi").value;
			var comments		=   $("#comments").val();
			var tick			=	document.getElementById('agree-cbox').checked;
			
			//console.log(email);console.log(firstname);console.log(lastname);console.log(password);console.log(confirmPassword);
			
			
			if(!isValid(email) && !isValid(firstname) && !isValid(lastname) && !isValid(password) && !isValid(confirmPassword) && !isValid(position) && !isValid(organisation) )
			{
				$('#modalbox').modal().hide();
				document.getElementById("firstname").value="";  
			    document.getElementById("firstname").focus(); 
		    $('#signupErr').html("Please fill in the details");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		    $("html, body").animate({ scrollTop: 0 }, "slow");
		   
			return false;
			}
			else if(!isValid(firstname) || !isValidName(firstname))
			{$('#modalbox').modal().hide();
			document.getElementById("firstname").value="";  
		    document.getElementById("firstname").focus(); 
		    $('#signupErr').html("Please enter a valid firstname with letters");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		  $("html, body").animate({ scrollTop: 0 }, "slow");
		    
			return false;
			}
			else if(!isValid(lastname) || !isValidName(lastname))
			{$('#modalbox').modal().hide();
			document.getElementById("lastname").value="";  
			document.getElementById("lastname").focus(); 
			$('#signupErr').html("Please enter a valid lastname with letters");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			$("html, body").animate({ scrollTop: 0 }, "slow");
			
			return false;
			}
			else if(!isValid(email) || !isValidEmail(email))
			{$('#modalbox').modal().hide();
			document.getElementById("email").value="";  
	        document.getElementById("email").focus(); 
		    $('#signupErr').html("Please enter a valid email address");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   $("html, body").animate({ scrollTop: 0 }, "slow");
		    
			return false;
			}
			else if(!isValid(password) || !isValidPassword(password))
			{$('#modalbox').modal().hide();
			document.getElementById("password").value="";  
		    document.getElementById("password").focus(); 
		    $('#signupErr').html("Password minimum length 6 with numbers and letters only");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		  $("html, body").animate({ scrollTop: 0 }, "slow");
		   
			return false;
			}
			else if(!isValid(confirmPassword)) 
			{$('#modalbox').modal().hide();
			document.getElementById("retype-password").value="";  
		    document.getElementById("retype-password").focus(); 
		    $('#signupErr').html("Please retype your password");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   $("html, body").animate({ scrollTop: 0 }, "slow");
		   
			return false;
			} 
			else if(password !== confirmPassword)
			{$('#modalbox').modal().hide();
			document.getElementById("password").value=""; 
	        document.getElementById("retype-password").value="";  
	        document.getElementById("password").focus(); 
		    $('#signupErr').html("Password and retyped password should be the same");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		   $("html, body").animate({ scrollTop: 0 }, "slow");
		    
			return false;
			}
			else if(!isValid(position) || !isValidName(position))
			{$('#modalbox').modal().hide();
			document.getElementById("position").value="";  
			document.getElementById("position").focus(); 
			$('#signupErr').html("Please enter the position with letters");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			$("html, body").animate({ scrollTop: 0 }, "slow");
			
			return false;
			}
			else if(!isValid(organisation) || !isValidName(organisation))
			{$('#modalbox').modal().hide();
			document.getElementById("organisation").value="";  
			document.getElementById("organisation").focus(); 
			$('#signupErr').html("Please enter the organisation with letters");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			$("html, body").animate({ scrollTop: 0 }, "slow");
			
			return false;
			}
			else if(isValid(orcId) && !isValidOrcId(orcId))
			{
			$('#modalbox').modal().hide();
			document.getElementById("orcId").value=""; 
	        document.getElementById("orcId").focus(); 
		    $('#signupErr').html("Not a valid ORCID");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		    $("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}	
			else if(isValid(comments) && comments.length>250)
			{
	        	$('#modalbox').modal().hide();
	        	//document.getElementById("comments").value=""; 
		        document.getElementById("comments").focus(); 
	        	$('#signupErr').html("Comments should be less than 250 letters");
	        	$('#messagebox').fadeIn().delay(2000).fadeOut();
		        $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
	        }
	        	
			else if(isValid(comments) && !isValidInput(comments))
			{
				$('#modalbox').modal().hide();
	        	//document.getElementById("comments").value=""; 
		        document.getElementById("comments").focus(); 
	        	$('#signupErr').html("Please avoid &,< and > symbols in comments");
	        	$('#messagebox').fadeIn().delay(2000).fadeOut();
		        $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
		   
			}
			else if ((!$('#Male').prop('checked')) && (!$('#Female').prop('checked'))) 
			{
				$('#modalbox').modal().hide();
			    $('#signupErr').html("Please select your gender");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
			}
			else if(country == 'select')
			{ 
				$('#modalbox').modal().hide();
			    $('#signupErr').html("Please select your country");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
			}
			else if(country == 'NZ')
			{ 
			$('#modalbox').modal().hide();
			raceList='';
			$('#cbox-group input').each(function(){
				if ($(this).prop('checked')) {
					raceList=raceList.concat($(this).val()+',');
			    }
			}); 
			
			if (raceList === null || $.trim(raceList) === "")
				{
				 $('#signupErr').html("Please provide ethnic details");
				    $('#messagebox').fadeIn().delay(2000).fadeOut();
				    $("html, body").animate({ scrollTop: 0 }, "slow");
				    return false;
				}
			else
				{//to check if maori, then ask for iwi
					if(raceList.indexOf("e2") > -1)
					{
						if(!isValid(iwi)|| !isValidName(iwi))
							{
							document.getElementById("iwi").value="";  
						    document.getElementById("iwi").focus(); 
						    $('#signupErr').html("Please enter a valid iwi with letters");
						    $('#messagebox').fadeIn().delay(2000).fadeOut();
							  $("html, body").animate({ scrollTop: 0 }, "slow");
							  return false;
							}
						else
						   {
							if($.trim(tick) === "false")
							{
							$('#modalbox').modal().hide();
							$('#signupErr').html("Please agree to the Terms and Conditions");
							$('#messagebox').fadeIn().delay(2000).fadeOut();
							$("html, body").animate({ scrollTop: 0 }, "slow");
							return false;
							}
						   }
					}
				else
				   {
					if($.trim(tick) === "false")
					{
					$('#modalbox').modal().hide();
					$('#signupErr').html("Please agree to the Terms and Conditions");
					$('#messagebox').fadeIn().delay(2000).fadeOut();
					$("html, body").animate({ scrollTop: 0 }, "slow");
					return false;
					}
				   }
				}
			}
			else if($.trim(tick) === "false")
			{
				$('#modalbox').modal().hide();
				$('#signupErr').html("Please agree to the Terms and Conditions");
				$('#messagebox').fadeIn().delay(2000).fadeOut();
				$("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
			}
			else
				{
				
				}
			//For gender
			if($('#Male').prop('checked'))
				gender=$('#Male').val();
			if($('#Female').prop('checked'))
				gender=$('#Female').val();
			
			//console.log("final validate in signup");
			var userInfo = {};
			userInfo["email"]	=	email;
			userInfo["firstname"]	=	$.trim(firstname);
			userInfo["lastname"]	=	$.trim(lastname);
			userInfo["password"]	=	password;
			userInfo["position"]	=	$.trim(position);
			userInfo["organisation"]	=	$.trim(organisation);
			userInfo["orcId"]	=	orcId;
			userInfo["category"]	=	category;
			userInfo["country"]	=	country;
			userInfo["comments"]	=	$.trim(comments);
			userInfo["ethnicity"]	=	$.trim(raceList);
			userInfo["iwi"]	=	$.trim(iwi);
			userInfo["gender"]	=	$.trim(gender);
			//console.log(userInfo);
			
			var result=intoServer(userInfo);
			return result;
		}
		
		function intoServer(userInfo)
		{//send JSON object
			var result=false;
			$.ajax({
			    type: 'POST', 
			    url: '/ifExistingUser', 
			    data:{userInfo:JSON.stringify(userInfo)},
			    dataType:'text',
			    async:false,
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
			            	 $('#modalbox').modal('hide');
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
		       // var namePattern =  /^[a-z]+$/i;
		        var namePattern = /^[a-zA-Z ]+$/;
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
	        if(password.length<6) 
	        	return false;
	        var passwordPattern =  /^[a-z0-9]+$/i;
	        flag = passwordPattern.test(password);
	        return flag;
	    }
	    var isValidOrcId = function(orcId) {
	    	 var flag = true;
	    	 if (orcId.length<16) 
	         	return false;
	    	 var orcidPattern =  /^(\d{4})-(\d{4})-(\d{4})-(\d{3}[0-9X])$/;
	         flag =orcidPattern.test(orcId);
	         return flag;
	    	
	    }
	    var isValidInput = function(text) {
	        var flag = true;
	       // var namePattern =  /^[a-z]+$/i;
	        if(text.indexOf('<') > -1 || text.indexOf('>') > -1 || text.indexOf('&') > -1)
	        flag = false;
	        return flag;
	    }
		
	});
