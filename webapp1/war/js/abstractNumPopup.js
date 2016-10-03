$(document).ready(function() 
{
	var absid=$('#absid').text();
	console.log(absid);
	if(absid === null || $.trim(absid) === "")
		{
		$('#numberModal').modal('hide');
		}
	else
		{
		$('#numberModal').modal('show');
		}
});