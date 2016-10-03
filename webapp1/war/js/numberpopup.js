$(document).ready(function() 
{
	var pubid=$('#pubid').text();
	
	if(pubid === null || $.trim(pubid) === "")
		{
		$('#numberModal').modal('hide');
		}
	else
		{
		$('#numberModal').modal('show');
		}
});