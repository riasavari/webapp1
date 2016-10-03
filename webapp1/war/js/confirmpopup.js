$(document).ready(function() 
{
	var editpub=$('#editpub').text();
	//alert("+++"+editpub);
	if($.trim(editpub) == "edit")
	{
		//alert("+++");
	}
	else
		{
		$('#confirmModal').modal('show');
		}
	
	
});