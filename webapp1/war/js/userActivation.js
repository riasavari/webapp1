$(document).ready(function() 
{
	var userid=$('#userid').text();
	if(userid === null || $.trim(userid) === "")
	{
		$("#logoutTab").hide();
		
	}
	/*var active=$('#userActive').text();
	if($.trim(active) == 'false')
	{
		
		
	}
	else
		{
		$("#btn-activate").hide();
		}*/
});