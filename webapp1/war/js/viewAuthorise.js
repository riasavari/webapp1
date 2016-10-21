$(document).ready(function() 
{

//for user session display (to know logged in/out)
var userid=$('#userid').text();
//if no session hide the logout link at the top

if($.trim(userid) === 'quakecore.nz@gmail.com')//if admin,hide userhome link
{
	$("#homeUserTab").hide();
}
else//else, hide adminhome link
	{
	$("#homeAdminTab").hide();
	}
if(userid === null || $.trim(userid) === "")
{
	$("#logoutTab").hide();
}
});