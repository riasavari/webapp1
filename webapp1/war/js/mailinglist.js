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
	var ticked=$('#temp').text();
	console.log(ticked);
	if(ticked === null || $.trim(ticked) === "")
	{
		
	}
	else
		{
		console.log("got inside");
		$('#cbox-group input').each(function(){
			var value=$(this).val() ;
			
			if(ticked.indexOf(value) != -1)
			{
				$(this).prop('checked', true);
		    }
		});
		}
	
	$('#cbox-all').click(function() {
		//alert("all clicked");
	    if ($(this).prop('checked')) {
	        $('#cbox-group input').prop('checked', true);
	        $('#cbox-none').prop("checked", false);
	    } else {
	    	 $('#cbox-group input').prop('checked', false);
		      //  $('#cbox-none').prop("checked", true);
	    }
	});
	
	$('#cbox-none').click(function() {
		//alert("none clicked");
	    if ($(this).prop('checked')) {
	        $('#cbox-group input').prop('checked', false);
	        $('#cbox-all').prop("checked", false);
	    } 
	});
	
	$('#cbox-group input').click(function() {
		//alert("group clicked");
		if($('#cbox-none').prop("checked"))
		 $('#cbox-none').prop("checked", false);
		if($('#cbox-all').prop("checked"))
		 $('#cbox-all').prop("checked", false);
	    	
	});
	
	
	
	//client side validation
	validate = function ()
		{
		console.log("!!!!!!!!!!!!!!!!!!!!");
		
		var result=false;
		var list=[];
		 var emaillist={};
		 var ticked=
		$('#cbox-group input').each(function(){
			if ($(this).prop('checked')) {
		       list[list.length]=$(this).val();
		    }
		}); 
		
			result=intoServer(list);
		
		 return result;
		}
	
	function intoServer(emaillist)
	{
		//alert(emaillist);
		//alert("alrady ticked "+ticked);
		var listJson={};
		for (var index = 0; index < emaillist.length; index++) {
			var temp=emaillist[index].toString();
			listJson[temp]=temp;
		}
		
$.ajax({
    type: 'POST', 
    url: '/saveEmailList', 
    data:{maillist:JSON.stringify(listJson),old:ticked},
    dataType:'text',
    success: function(response)
             {
			    	//	alert("hi");
			    	console.log("SUCCESS");
			    	console.log(response);
			    	var nextPage = response;
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
       var emailPattern =  /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        flag_email = emailPattern.test(emailId);
        return flag_email;
    }
    
    
});	
	