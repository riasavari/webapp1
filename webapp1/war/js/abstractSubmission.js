$(document).ready(function() 
	{
	//for user session display (to know whether user is logged in/out)
	var userid=$('#userid').text();
	console.log(userid);
	//if no session hide the logout link in the top
	if(userid === null || $.trim(userid) === "")
	{
		$("#logoutTab").hide();
	}
	//Contains proposal details
	var details=$('#temp').text();
	console.log(details);
	if(details === null || $.trim(details) === "")
	{
		
	}
	else
		{
		
		
		}
	validate=function()
	{
		var year			=	document.getElementById("year").value;
		var category		=	document.getElementById("category").value;
		var author			=	document.getElementById("author").value;
		var title			=	document.getElementById("title").value;
		var abstractDesc	=	$("#abstractDescription").val();//document.getElementById("abstractDescription").value;
		var project 		=	document.getElementById("project").value;
		var url				=	document.getElementById("url").value;
		
		if(!isValid(author))
		{
		document.getElementById("author").value="";  
	    document.getElementById("author").focus(); 
	    $('#err').html("Please enter author details");
	    $('#messagebox').fadeIn().delay(2000).fadeOut();
	    $("html, body").animate({ scrollTop: 0 }, "slow");
		return false;
		}
		if(!isValid(title))
		{
		document.getElementById("title").value="";  
	    document.getElementById("title").focus(); 
	    $('#err').html("Please enter article title");
	    $('#messagebox').fadeIn().delay(2000).fadeOut();
	    $("html, body").animate({ scrollTop: 0 }, "slow");
		return false;
		}
		if(abstractDesc.length<1)
		{alert("got in"); 
		document.getElementById("abstractDescription").value="";  
	    document.getElementById("abstractDescription").focus(); 
	    $('#err').html("Please enter the abstract");
	    $('#messagebox').fadeIn().delay(2000).fadeOut();
	    $("html, body").animate({ scrollTop: 0 }, "slow");
		return false;
		}
		if(!isValid(project))
		{
		document.getElementById("project").value="";  
	    document.getElementById("project").focus(); 
	    $('#err').html("Please enter article project");
	    $('#messagebox').fadeIn().delay(2000).fadeOut();
	    $("html, body").animate({ scrollTop: 0 }, "slow");
		return false;
		}
		if(!isValid(url))
		{
		document.getElementById("url").value="";  
	    document.getElementById("url").focus(); 
	    $('#err').html("Please enter article url");
	    $('#messagebox').fadeIn().delay(2000).fadeOut();
	    $("html, body").animate({ scrollTop: 0 }, "slow");
		return false;
		}
	return true;
}
var isValid = function(someValue) {
    if (someValue === null || $.trim(someValue) === "") 
    	return false;
    else
    	return true;
}
});