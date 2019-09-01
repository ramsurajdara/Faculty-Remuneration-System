<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Admin Operations</title>
	<link rel="stylesheet" type="text/css" href="webstyle.css">
	<link rel="stylesheet" type="text/css" href="webstyle2.css">
	<%
		if(session==null||session.getAttribute("id")==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Invalid.html");
			rd.forward(request, response); 
		}
	%>
</head>
<body style="background: url(Images/bg4.jpg);">	
	<ul>	
		<li><a href="Entry.html">Set Invigilation<br>Data</a></li>
		<li><a href="FacultyRemunerationInvg.html">Invigilation Remuneration<br>Details</a></li>
		<li><a href="FacultyRemunerationForm.html">Other Remuneration<br>Details</a></li>		
		<li><a href="GetInvigilationData.html">Get Invigilation<br>Data</a></li>
		<li><a href="ChangeInvigilation.html">Change Invigilation<br>Data</a></li>
		<li><a href="Register.html">Register</a></li>
		<li><a href="InvgBillUpdation.html">Pay Invigilation<br>Remuneration</a>
		<li><a href="OtherBillUpdation.html">Pay Other<br>Remuneration</a>
		<li style="float:right"><a href="LogoutServ"><img width='90' height='20' src="Images/logout2.png"></a></li>
	</ul>
	<img width=100% height=100% src="Images/welcome3.jpg">	
</body>
</html>