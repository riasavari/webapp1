$(document).ready(function() 
{
	
	var userid=$('#userid').text();
	if(userid === null || $.trim(userid) === "")
	{
		//$("#logoutTab").hide();
		window.location.href = "expiry";
	}
	
});