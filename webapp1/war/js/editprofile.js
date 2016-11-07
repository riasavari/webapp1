
$(document.body).keypress(function(event){
        if(event.keyCode == 13){
          $('#btn-signup').click();
        }
      });

	$(document).ready(function() 
	{
		//alert("inside of editprofile.js "+($($('#temp > div')[4]).html()));
		var firstName	=	($($('#temp > div')[0]).html() != "") ? ($($('#temp > div')[0]).html()) : "";
		var lastName	=	($($('#temp > div')[1]).html() != "") ? ($($('#temp > div')[1]).html()) : "";
		var title		=	($($('#temp > div')[2]).html() != "") ? ($($('#temp > div')[2]).html()) : "";
		var position	=	($($('#temp > div')[3]).html() != "") ? ($($('#temp > div')[3]).html()) : "";
		var organisation=	($($('#temp > div')[4]).html() != "") ? ($($('#temp > div')[4]).html()) : "";
		var category	=	($($('#temp > div')[5]).html() != "") ? ($($('#temp > div')[5]).html()) : "";
		var gender		=	($($('#temp > div')[6]).html() != "") ? ($($('#temp > div')[6]).html()) : "";
	 	var country		=	($($('#temp > div')[7]).html() != "") ? ($($('#temp > div')[7]).html()) : "";
	 	var ethnicity	=	($($('#temp > div')[8]).html() != "") ? ($($('#temp > div')[8]).html()) : "";
	    var iwi			=	($($('#temp > div')[9]).html() != "") ? ($($('#temp > div')[9]).html()) : "";
	    var comments	=	($($('#temp > div')[10]).html() != "") ? ($($('#temp > div')[10]).html()) : "";
	    var orcId		=	($($('#temp > div')[11]).html() != "") ? ($($('#temp > div')[11]).html()) : "";
	
		
		var raceList;
		
		//for user session display (to know whether user is logged in/out)
		var userid=$('#userid').text();
		//if no session hide the logout link in the top
		if(userid === null || $.trim(userid) === "")
		{
			$("#logoutTab").hide();
		}
		console.log(userid);
		
		//To set user details in input fields
		if(firstName.length != 0)
		$('#firstname').val(firstName);
		else
			$('#firstname').val("");
		if(lastName.length != 0)
		$('#lastname').val(lastName);
		else
			$('#lastname').val("");
		
		if(title.length != 0)
		$('#title').val(title);
		
		if(position.length != 0)
		$('#position').val(position);
		else
			$('#position').val("");
		if(organisation.length != 0)
		$('#organisation').val(organisation);
		else
			$('#organisation').val("");
		if(category.length != 0)
		$('#category').val(category);
		if(orcId.length != 0)
		$('#orcId').val(orcId);
		else
			$('#orcId').val("");
		if(country.length != 0)
		$('#country').val(country);
		if(comments.length != 0)
		$('#comments').val(comments);
		else
			$('#comments').val("");
		if(iwi.length != 0)
		$('#iwi').val(iwi);
		else
			$('#iwi').val("");
		
		//to set gender value in radio button
		if(gender == 'Male')
			$('#Male').prop('checked', true);
		if(gender == 'Female')
			$('#Female').prop('checked', true);
		
		//to display the stored values in country,ethnicity fields
		if(country=="NZ")
		{
			 $('#ethnicDiv').show();
				$('#cbox-group input').each(function(){
					var value=$(this).val() ;
					if(ethnicity.indexOf(value) != -1)
					{
						$(this).prop('checked', true);
				    }
				});
				
				if(ethnicity.indexOf('e2') > -1)
					{
					$("#iwiDiv").show();
					
					}
				
				
		}
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
		//to change values in country,ethnicity fields
		 /*$("#country").on("change", function(o){
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
		  });*/
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
			var orcId			=	document.getElementById("orcId").value;
			var country			=	document.getElementById("country").value;
			var iwi				=	document.getElementById("iwi").value;
			var comments		=   $("#comments").val();
			console.log(comments);
			//console.log(email);console.log(firstname);console.log(lastname);console.log(password);console.log(confirmPassword);
			
			
			if(!isValid(firstname) && !isValid(lastname) && !isValid(position) && !isValid(organisation) )
			{
			document.getElementById("firstname").value="";  
	        document.getElementById("firstname").focus(); 
		    $('#profileErr').html("Please fill in the details");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		    $("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}
			else if(!isValid(firstname) || !isValidName(firstname))
			{
			document.getElementById("firstname").value="";  
		    document.getElementById("firstname").focus(); 
		    $('#profileErr').html("Please enter a valid name with letters only");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		    $("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}
			else if(!isValid(lastname) || !isValidName(lastname))
			{
			document.getElementById("lastname").value="";  
			document.getElementById("lastname").focus(); 
			$('#profileErr').html("Please enter a valid name with letters only");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			$("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}
			else if(!isValid(position) || !isValidName(position))
			{
			document.getElementById("position").value="";  
			document.getElementById("position").focus(); 
			$('#profileErr').html("Please enter the position with letters");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			$("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}
			else if(!isValid(organisation) || !isValidName(organisation))
			{
			document.getElementById("organisation").value="";  
			document.getElementById("organisation").focus(); 
			$('#profileErr').html("Please enter the organisation with letters");
			$('#messagebox').fadeIn().delay(2000).fadeOut();
			$("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}
			else if(isValid(orcId) && !isValidOrcId(orcId))
			{
			$('#modalbox').modal().hide();
			document.getElementById("orcId").value=""; 
	        document.getElementById("orcId").focus(); 
		    $('#profileErr').html("Not a valid ORCID");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		    $("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}	
			else if(isValid(comments) && comments.length>250)
			{
	        	$('#modalbox').modal().hide();
	        	//document.getElementById("comments").value=""; 
		        document.getElementById("comments").focus(); 
	        	$('#profileErr').html("Comments should be less than 250 letters");
	        	$('#messagebox').fadeIn().delay(2000).fadeOut();
		        $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
	        }
	        	
			else if(isValid(comments) && !isValidInput(comments))
			{
				$('#modalbox').modal().hide();
	        	//document.getElementById("comments").value=""; 
		        document.getElementById("comments").focus(); 
	        	$('#profileErr').html("Please avoid &,< and > symbols in comments");
	        	$('#messagebox').fadeIn().delay(2000).fadeOut();
		        $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
		   
			}
			else if ((!$('#Male').prop('checked')) && (!$('#Female').prop('checked'))) 
			{
				$('#modalbox').modal().hide();
			    $('#profileErr').html("Please select your gender");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
			}
			else if(country == 'select')
			{ 
				$('#modalbox').modal().hide();
			    $('#profileErr').html("Please select your country");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
			}
			else if(country === 'NZ')
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
					 $('#profileErr').html("Please provide ethnic details");
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
						    $('#profileErr').html("Please enter a valid iwi with letters");
						    $('#messagebox').fadeIn().delay(2000).fadeOut();
							$("html, body").animate({ scrollTop: 0 }, "slow");
							  return false;
							}
					}
				
				}
			
			}
			else
				{
				
				}
			//For gender
			if($('#Male').prop('checked'))
				gender=$('#Male').val();
			if($('#Female').prop('checked'))
				gender=$('#Female').val();
			
			console.log("final validate in editprofile.js");
			var userInfo = {};
			
			userInfo["firstname"]	=	$.trim(firstname);
			userInfo["lastname"]	=	$.trim(lastname);
			userInfo["title"]	=	title;
			userInfo["position"]	=	$.trim(position);
			userInfo["organisation"]	=	$.trim(organisation);
			userInfo["category"]	=	category;
			userInfo["orcId"]	=	orcId;
			userInfo["country"]	=	country;
			userInfo["comments"]	=	$.trim(comments);
			userInfo["ethnicity"]	=	$.trim(raceList);
			userInfo["iwi"]	=	$.trim(iwi);
			userInfo["gender"]	=	$.trim(gender);
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
		       // var namePattern =  /^[a-z]+$/i;
		        var namePattern = /^[a-zA-Z ]+$/;
		        flag = namePattern.test(name);
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