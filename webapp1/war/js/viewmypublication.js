$(document).ready(function() 
	{
		$("button").click(function() {
		    //alert(this.id);
		
		var buttonId=this.id;
		//alert(buttonId);
		$("#buttonid").html(buttonId);
		/*$.ajax({
			type: "POST",
            url: "/updatePublication",
            data:{id:buttonId},
            success: function(response) {
			   			
		    			console.log(response);
		    			 window.location=response;
		    			//document.getElementById("statusMessage").innerHTML = "Joined!";
		             },
	             error: function(){
	             } 
		   
		});*/
		
	});
	/*alert("1");
	window.onload=function() {
		alert("2");
   document.getElementById("updateLink").onclick=function() {
	   alert("3");
	   
     var myForm = document.createElement("form");
     myForm.action=this.href;// the href of the link
     myForm.target="update";
     myForm.method="POST";
     myForm.submit();
     return false; // cancel the actual link
   }
// }
*/	
	

		 /* $("#updateLink").on("click",function(e) {
		    e.preventDefault(); // cancel the link itself
		    alert("3");
		    var value=document.documentElement.id
		    	document.getElementById("myText").value;
		    alert(value);
		    $.post(this.href,function(value) {
		    	console.log("----");
		    	console.log(value);
		      //$("#someContainer").html(data);
		    });
		  });*/
		
	
	});