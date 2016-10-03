$(document).ready(function() 
	{
	update=function(curid)
	{
		console.log(curid);
	
		var obj=JSON.stringify(curid);
		console.log(obj);
		$.ajax({
		    type: 'POST', 
		    url: '/editthisAbstract', 
		    data:{absId:curid},
		    dataType:'text',
		    success: function(resultPage)
		             {
		    		
		    	
		    			//console.log(resultPage);
		    			//window.location=resultPage;
		             },
	             error: function(){
	             } 
		   
		});
		
	}
	
	
	});