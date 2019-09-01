<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>	GET INVIGILATION</title>

</head>
<body>
	
	<%@page import="java.sql.*"%>
	<%
	Connection con=null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	}catch(Exception e)
	{
		System.out.println("The Exception:"+e);
	}
	String dt=request.getParameter("dt");
	String tm=request.getParameter("tm");
	PreparedStatement ps=con.prepareStatement("select * from invigilation where dt=? and time=?");
	ps.setString(1,dt);
	ps.setString(2,tm);
	ResultSet rs=ps.executeQuery();
	if(rs.next())
	{
	%>
	<b>DATE:<%=dt %></b><br>
	<b>TIME:<%=tm %></b>
	<table border="1" style="border-collapse:collapse" width=100%>
	<tr style="text-align:center"><td>ROOM NO</td>
	<td>DEPT 1</td>
	<td>DEPT 2</td>
	<td>FID 1</td>
	<td>FID 2</td></tr>	
	<%
		do
		{
	%>
		<tr style="text-align:center">
		<td><%=rs.getString(3) %></td>
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td><%=rs.getString(7) %></td>
		</tr>	
	<%
		}while(rs.next());
	}
	else
	{
		out.println("<script>alert('Invigilation yet to set');location.href='GetInvigilationData.html';</script>");
	}
	%>
	</table>
</body>
</html>