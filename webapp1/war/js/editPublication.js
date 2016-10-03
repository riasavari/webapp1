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
	
	var paperDetails=$('#paper').text();
	//alert(paperDetails);
	
	
	
	
    $("select").change(function(){
    	var article	=	document.getElementById("article").value;
    	var status			=	document.getElementById("status").value;
    	
    	document.getElementById("author").value			=	"";  
        document.getElementById("author").focus(); 
        document.getElementById("title").value			=	""; 
    //    document.getElementById("proceedName").value	=	""; 
    	document.getElementById("venueName").value		=	""; 
    	document.getElementById("page").value			=	""; 
    	document.getElementById("location").value		=	""; 
    	document.getElementById("url").value			=	""; 
    	document.getElementById("dates").value			=	""; 
    	document.getElementById("publisher").value		=	""; 
		
    	if(status === "published" && article === "journal")
		{
    	$("#venueName").show();
		//$("#proceedName").hide();
		$("#volumeDiv").show();
		$("#urlDiv").show();
		$("#pageDiv").show();
		$("#locationDiv").hide();
		$("#dateDiv").hide();
		$("#publisherDiv").hide();
		}
		else if(status === "published" && article === "conference")
		{
		$("#venueName").show();
		$("#locationDiv").show();
	//	$("#proceedName").show();
		$("#pageDiv").show();
		$("#dateDiv").show();
		$("#volumeDiv").hide();
		$("#urlDiv").hide();
		$("#publisherDiv").hide();
		}
		else if(status === "published" && article === "book")
		{
		$("#venueName").hide();
		$("#pageDiv").show();
		$("#publisherDiv").show();
		//$("#proceedName").hide();
		$("#locationDiv").hide();
		$("#dateDiv").hide();
		$("#volumeDiv").hide();
		$("#urlDiv").hide();
		}
		else if(status === "published" && article === "bookchapter")
		{
		$("#venueName").show();
		$("#pageDiv").show();
		$("#publisherDiv").show();
		$("#locationDiv").hide();
		//$("#proceedName").hide();
		$("#dateDiv").hide();
		$("#volumeDiv").hide();
		$("#urlDiv").hide();
		}
		else if(status === "published" && (article === "peerreviewed" || article === "nonpeerreviewed"))
		{
		$("#locationDiv").show();
		$("#pageDiv").show();
		$("#dateDiv").show();
		$("#venueName").hide();
		//$("#proceedName").hide();
		$("#publisherDiv").hide();
		$("#volumeDiv").hide();
		$("#urlDiv").hide();
		}
		else if((status === "accepted" || status === "submitted") && article === "book" )
		{
    	$("#venueName").hide();
		//$("#proceedName").hide();
		$("#pageDiv").hide();
		$("#volumeDiv").hide();
		$("#urlDiv").hide();
		$("#locationDiv").hide();
		$("#dateDiv").hide();
		$("#publisherDiv").hide();
		}
		else
		{
		$("#venueName").show();
		//$("#proceedName").hide();
		$("#pageDiv").hide();
		$("#volumeDiv").hide();
		$("#urlDiv").hide();
		$("#locationDiv").hide(); 
		$("#dateDiv").hide();
		$("#publisherDiv").hide();
		}
    }).change();
    
validate=function()
{
	var year			=	document.getElementById("year").value;
	var status			=	document.getElementById("status").value;
	var article			=	document.getElementById("article").value;
	var author			=	document.getElementById("author").value;
	var title			=	document.getElementById("title").value;
	//var proceedName 	=	document.getElementById("proceedName").value;
	var venueName		=	document.getElementById("venueName").value;
	var volume 			=	document.getElementById("volume").value;
	var page			=	document.getElementById("page").value;
	var location 		=	document.getElementById("location").value;
	var url				=	document.getElementById("url").value;
	var dates			=	document.getElementById("dates").value
	var publisher		=	document.getElementById("publisher").value;
	
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
	if(article === "journal" || article === "conference" ||  article === "bookchapter")
	{
		if(!isValid(venueName))
		{
		document.getElementById("venueName").value="";  
	    document.getElementById("venueName").focus(); 
	    $('#err').html("Please enter venue details");
	    $('#messagebox').fadeIn().delay(2000).fadeOut();
	    $("html, body").animate({ scrollTop: 0 }, "slow");
		return false;
		}
	}
	if(status === "published")
		{
			if(!isValid(page))
			{
			document.getElementById("page").value="";  
		    document.getElementById("page").focus(); 
		    $('#err').html("Please enter number of pages");
		    $('#messagebox').fadeIn().delay(2000).fadeOut();
		    $("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
			}
			if( article === "book" ||  article === "bookchapter" )
			{
				if(!isValid(publisher))
				{
				document.getElementById("publisher").value="";  
			    document.getElementById("publisher").focus(); 
			    $('#err').html("Please enter publisher details");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
				}
			}
		
			if(article === "journal" )
			{
				if(!isValid(volume))
				{
				document.getElementById("volume").value="";  
			    document.getElementById("volume").focus(); 
			    $('#err').html("Please enter volume and issue numbers");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
				}
			}
			if(article === "conference" )
			{
				if(!isValid(location))
				{
				document.getElementById("location").value="";  
			    document.getElementById("location").focus(); 
			    $('#err').html("Please enter the location");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
				}
				if(!isValid(dates))
				{
				document.getElementById("dates").value="";  
			    document.getElementById("dates").focus(); 
			    $('#err').html("Please enter the dates");
			    $('#messagebox').fadeIn().delay(2000).fadeOut();
			    $("html, body").animate({ scrollTop: 0 }, "slow");
				return false;
				}
				
			}
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