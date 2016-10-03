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
		window.location.href="expiry";
	}
	validate = function ()
		{
		var result=false;
		var list="";
		var name="";
		var email;
		 var emaillist={};
		
		$('#radio-group input').each(function(){
			if ($(this).prop('checked')) {
		       list=$(this).val();
		       name=$(this).attr('id');
		    }
		}); 
		   
				if(list !== null && list.length>0)
					{
					email    = document.getElementById("email").value;
					//alert(email);
					 if(isValid(email) && isValidEmail(email))
						 result=intoServer(list,name,email);
					 else
						 {
						//console.log("Please enter a valid email address");
			    		   $('#Err').html("Please enter a valid email address");
			       	   		$('#messagebox').fadeIn().delay(2000).fadeOut();
			       	   		document.getElementById("email").value="";  
			       	   		document.getElementById("email").focus(); 
			       	   		return false;
			    		   }
						 
					}
				else
					{
					//console.log("Please select a radio button");
					$('#Err').html("Please select a mailing list");
		            $('#messagebox').fadeIn().delay(2000).fadeOut();
					 return false;
					}
				 return result;
		}
	
	function intoServer(emaillist,name,email)
	{
		//alert("got inside of click" );
		//alert(emaillist);
		
$.ajax({
    type: 'POST', 
    url: '/getContactList', 
    data:{maillist:emaillist,emailid:email,listname:name},
    dataType:'text',
    success: function(data)
             {
			    		//alert(data);
			    	//console.log("SUCCESS");
			    	
			    	window.location=data;
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
	
