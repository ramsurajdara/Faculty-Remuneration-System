<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>FacultyOp</title>
	<link rel="stylesheet" type="text/css" href="webstyle.css">
	<link rel="stylesheet" type="text/css" href="webstyle2.css">
</head>
<body style="background: url(Images/bg4.jpg);">
	<%
		if(session==null||session.getAttribute("id")==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Invalid.html");
			rd.forward(request, response); 
		}
	%>
	<ul>
		<li><a href="ShowDataServ">Display Data</a></li>
		<li><a href="TimeTableEntry.html">TimeTable</a></li>
		<li style="float:right"><a href="LogoutServ"><img width='90' height='20' src="Images/logout2.png"></a></li>
	</ul>
	<img width=100% height=100% src="Images/welcome3.jpg">
</body>
</html>