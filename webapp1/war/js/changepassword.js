$(document.body).keypress(function(event){
        if(event.keyCode == 13){
          $('#btn-signup').click();
        }
      });
$(document).ready(function() 
{
	
	var userid=$('#userid').text();
	if(userid === null || $.trim(userid) === "")
	{
		//$("#logoutTab").hide();
		window.location.href = "expiry";
	}
	
	validate = function ()
	{
		console.log("inside the js");
		
		 var oldPassword    = document.getElementById("password").value;
		   var newPassword    = document.getElementById("newpassword").value;
		   var confirmPassword    = document.getElementById("retype-password").value;
		   var takeToServer=validation(oldPassword,newPassword,confirmPassword);

	return  takeToServer;
	   
	}
	function validation(oldPassword,newPassword,confirmPassword)
	{
		
		  // alert("into validation..");
		
	 if(!isValid(oldPassword) && !isValid(newPassword)  && !isValid(confirmPassword))
			   { //alert("1");
			   document.getElementById("password").value="";  
	  	   		document.getElementById("password").focus(); 
	  	   		$('#Err').html("Please fill in the details");
	  	   		$('#messagebox').fadeIn().delay(2000).fadeOut();
	  	   		return false;
			   }
		   else if(!isValid(oldPassword))
		   {//alert("2");
			    console.log("Please enter the password");
		   		document.getElementById("password").value="";  
		   		document.getElementById("password").focus(); 
		   		$('#Err').html("Please enter the password");
		   		$('#messagebox').fadeIn().delay(2000).fadeOut();
		   		return false;
		   }
		   else if(!isValid(newPassword) || (!isValidPassword(newPassword)))
	    		   {//alert("3");
	    		    console.log("Please enter a new password");
	       	   		document.getElementById("newpassword").value="";  
	       	   		document.getElementById("newpassword").focus(); 
	       	   		$('#Err').html("Password minimum length 6 with numbers and letters only");
	       	   		$('#messagebox').fadeIn().delay(2000).fadeOut();
	       	   		return false;
	    		   }
		   else if(newPassword != confirmPassword)
			{
			  // alert("newPassword != confirmPassword");
			   document.getElementById("newpassword").value="";
			   document.getElementById("retype-password").value="";   
	  	   		document.getElementById("newpassword").focus();
			    $('#Err').html("New password and retyped password should be the same");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
				return false;
			}
		   else if(!isValid(confirmPassword) || (!isValidPassword(confirmPassword)))
		   {//alert("4");
			    console.log("Please re-enter your new password");
		   		document.getElementById("retype-password").value="";  
		   		document.getElementById("retype-password").focus(); 
		   		$('#Err').html("Please re-enter your new password");
		   		$('#messagebox').fadeIn().delay(2000).fadeOut();
		   		return false;
		   }
		  
		   else if(newPassword === oldPassword)
			{
			   //alert("newPassword != confirmPassword");
			   document.getElementById("newpassword").value="";
			   document.getElementById("retype-password").value="";   
	 	   		document.getElementById("newpassword").focus();
			    $('#Err').html("Old and new password cannot be the same");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
				return false;
			} 
		   else
		       {
			   //alert("comes here for true");
		   		   
				
		           return true;
		       }
	}
	function intoServer(oldpassword,newpassword)
	{
		console.log(newpassword+"----------"+ "in intoServer");
		
$.ajax({
	async:false,
    type: 'POST', 
    url: '/getpasswordchanged', 
    data:{oldpwd : oldpassword,newpwd : newpassword},
    dataType:'text',
    success: function(response)
             {
    		console.log(response);
             },
             error: function(){
             } 
	});
	
	
	
	}
	var isValid = function(someValue) {
        if (someValue === null || $.trim(someValue) === "") 
        	return false;
        else
        	return true;

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

