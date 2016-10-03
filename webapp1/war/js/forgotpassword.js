
$(document).ready(function() 
{ $(document.body).keypress(function(event){
    if(event.keyCode == 13){
        $('#btn-signup').click();
      }
    });
	validate = function ()
	{
		//alert("hi");
		
		
	   var email    = document.getElementById("email").value;
	  
       if(!isValid(email) || (!isValidEmail(email)))
    		   {
    	   $("#modalbox").modal().hide();
    		   console.log("Please enter a valid email address");
       	   		document.getElementById("email").value="";  
       	   		document.getElementById("email").focus(); 
       	   		$('#err').html("Please enter a valid email address");
       	   		$('#messagebox').fadeIn().delay(2000).fadeOut();
       	   		return false;
    		   }
	   else
	       {
		   	console.log("correct email");
	   		   var result = intoServer(email);
			//alert(result);
			return result;
	           //return true;
	       }
	   
	}
	
	function intoServer(email)
	{
		console.log(email+"----------");
		var result=false;
$.ajax({
	async:false,
    type: 'GET', 
    url: '/ifExistingUserForgot', 
    data:{id : email},
    dataType:'text',
    success: function(response)
             {
			    		/*alert("hi");
			    	console.log("SUCCESS");
			    	console.log(response);*/
			    	var nextPage = "home";
			    	if(response === "existingUser")
			    	{
			    		//window.location = "select";
			    		result=true;
			    		return true;
			    	}
			    	
			    	else 
			    	{	 $("#modalbox").modal().hide();
			    		$('#err').html("No account exists. Please "+"<a href='signup'>Signup</a>");
			    		$('#messagebox').fadeIn().delay(2500).fadeOut();
			    		document.getElementById("email").value="";  
			    		document.getElementById("email").focus(); 
			    		return false;
			    	}
			    	
			    	
             },
             error: function(){
             } 
	});
	console.log(result);
	if(result)
		return result;
	else
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

