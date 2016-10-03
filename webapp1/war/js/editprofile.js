
$(document.body).keypress(function(event){
        if(event.keyCode == 13){
          $('#btn-signup').click();
        }
      });

	$(document).ready(function() 
	{
		console.log("inside of editprofile.js "+($($('#temp > div')[4]).html()));
		var firstName	=	($($('#temp > div')[0]).html() != "") ? ($($('#temp > div')[0]).html()) : {};
		var lastName	=	($($('#temp > div')[1]).html() != "") ? ($($('#temp > div')[1]).html()) : {};
		var title	=	($($('#temp > div')[2]).html() != "") ? ($($('#temp > div')[2]).html()) : {};
		var position	=	($($('#temp > div')[3]).html() != "") ? ($($('#temp > div')[3]).html()) : {};
		var organisation	=	($($('#temp > div')[4]).html() != "") ? ($($('#temp > div')[4]).html()) : {};
		var category	=	($($('#temp > div')[5]).html() != "") ? ($($('#temp > div')[5]).html()) : {};
		//alert(firstName+" -- "+categories);
		
		//for user session display (to know whether user is logged in/out)
		var userid=$('#userid').text();
		//if no session hide the logout link in the top
		if(userid === null || $.trim(userid) === "")
		{
			$("#logoutTab").hide();
		}
		console.log(userid);
		
		//To set user details in iput fields
		$('#firstname').val(firstName);
		$('#lastname').val(lastName);
		$('#title').val(title);
		$('#position').val(position);
		$('#organisation').val(organisation);
		$('#category').val(category);
		
		
		save = function ()
		{
				var endOutput=validate();
				return endOutput;
			
		}
		
		function validate()
		{
			
			var firstname		=	document.getElementById("firstname").value;
			var lastname		=	document.getElementById("lastname").value;
			var title			=	document.getElementById("title").value;
			var position		=	document.getElementById("position").value;
			var organisation	=	document.getElementById("organisation").value;
			var category		=	document.getElementById("category").value;;
			console.log(category);
			//console.log(email);console.log(firstname);console.log(lastname);console.log(password);console.log(confirmPassword);
			
			
			if(!isValid(firstname) && !isValid(lastname) && !isValid(position) && !isValid(organisation) )
			{
			document.getElementById("firstname").value="";  
	        document.getElementById("firstname").focus(); 
		    $('#profileErr').html("Please fill in the details");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
			return false;
			}
			else if(!isValid(firstname) || !isValidName(firstname))
			{
			document.getElementById("firstname").value="";  
		    document.getElementById("firstname").focus(); 
		    $('#profileErr').html("Please enter a valid name with letters only");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
			return false;
			}
			else if(!isValid(lastname) || !isValidName(lastname))
			{
			document.getElementById("lastname").value="";  
			document.getElementById("lastname").focus(); 
			$('#profileErr').html("Please enter a valid name with letters only");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			return false;
			}
			else if(!isValid(position))
			{
			document.getElementById("position").value="";  
			document.getElementById("position").focus(); 
			$('#profileErr').html("Please enter your position");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			return false;
			}
			else if(!isValid(organisation))
			{
			document.getElementById("organisation").value="";  
			document.getElementById("organisation").focus(); 
			$('#profileErr').html("Please enter your organisation");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			return false;
			}
			else
				{
				
				}
			console.log("final validate in editprofile.js");
			var userInfo = {};
			
			userInfo["firstname"]	=	firstname;
			userInfo["lastname"]	=	lastname;
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
			//alert(userInfo);
			var result=false;
			$.ajax({
				async:false,
			    type: 'POST', 
			    url: '/editUserDetails', 
			    data:{userInfo:JSON.stringify(userInfo)},
			    dataType:'text',
			    success: function(response)
			             {
						    	//alert("1"+response);	
						    	if(response === "saved")
						    	{
						    		//alert("2");
						    		window.location="changed";
						    		return false;
						    	}
						    	else if(response === "noAccount")
						    	{
						    		//alert("3");	
						    		window.location="expiry";
						    		return false;
						    	}
						    	else
						    		{
						    		//alert("4");	
						    		window.location="expiry";
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
	});