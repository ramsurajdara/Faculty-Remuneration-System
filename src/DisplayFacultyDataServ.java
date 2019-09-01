

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DisplayFacultyData
 */
@WebServlet("/DisplayFacultyData")
public class DisplayFacultyDataServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayFacultyDataServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		FacultyDataDAO fdd=new FacultyDataDAO();
		System.out.println("Entered");
		ResultSet rs=null;
		String[] p={"8:40-9:30","9:30-10:20","10:20-11:10","11:10-12:00","12:00-12:50","12:50-1:40","1:40-2:30","2:30-3:20","3:20-4:10","4:10-5:00"};
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
		try {
			HttpSession session = request.getSession();
			String dept=(String) session.getAttribute("id");
			rs = fdd.getData(dept);
			pw.println("<body style='background:url(Images/bg1.jpg)'>");
			pw.println("<a href='LogoutServ' style='position:absolute;top: 0;right: 0;margin:0px 2px;'><img width='80' height='40' src='Images/logout1.png'></a>");
			pw.println("<form method='post' action='UpdateServ' name='gen'>");
			pw.println("<center><b style='color:white'>Enter the date:<b><input type='date' name='dt' placeholder='yyyy-mm-dd'></center><br>");
			pw.println("<center><b style='color:white'>Enter the time:<b><input type='text' name='tm'></center><br>");
			pw.println("<table border='1' bgColor='white' style='width:100%' align='center'>");
			while(rs.next())
			{
				
				pw.println("<tr><th style='color:blue' colspan=11><input type='checkbox' name='faculty' value='"+rs.getString(1)+"'>"+rs.getString(1)+"</th></tr>");
				pw.println("<tr><th></th><th>"+p[0]+"</th><th>"+p[1]+"</th><th>"+p[2]+"</th><th>"+p[3]+"</th><th>"+p[4]+"</th><th>"+
							p[5]+"</th><th>"+p[6]+"</th><th>"+p[7]+"</th><th>"+p[8]+"</th><th>"+p[9]+"</th><tr>");
				for(int j=2;j<=6;j++)
				{
					String d=rs.getString(j+1);
					pw.println("<tr><td>"+days[j-2]+"</td>");
						
					for(int i=0;i<p.length;i++)
					{
							if(d.contains(p[i]))
								pw.print("<td style='background:green;color:white'>Y</td>");
							else
								pw.print("<td style='background:red;color:white'>N</td>");
					}
					pw.println("</tr>");
				}
			}
			pw.println("</table>");
			pw.println("<center><input type='submit' name='action' value='Submit'></center></form>");
			pw.println("</body>");
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		FacultyDataDAO fdd=new FacultyDataDAO();
		System.out.println("Entered");
		ResultSet rs=null;
		String[] p={"8:40-9:30","9:30-10:20","10:20-11:10","11:10-12:00","12:00-12:50","12:50-1:40","1:40-2:30","2:30-3:20","3:20-4:10","4:10-5:00"};
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
		try {
			HttpSession session = request.getSession();
			String dept=(String) session.getAttribute("id");
			rs = fdd.getData(dept);
			System.out.println("entered");
			pw.println("<body style='background:url(Images/bg1.jpg)'>");
			pw.println("<a href='LogoutServ' style='position:absolute;top: 0;right: 0;margin:0px 2px;'><img width='80' height='40' src='Images/logout1.png'></a>");
			pw.println("<form method='post' action='UpdateServ' name='gen'>");
			pw.println("<center><b style='color:white'>Enter the date:<b><input type='date' name='dt' placeholder='yyyy-mm-dd'></center><br>");
			pw.println("<center><b style='color:white'>Enter the time:<b><input type='text' name='tm'></center><br>");
			pw.println("<table border='1' bgColor='white' style='width:100%' align='center'>");
			while(rs.next())
			{
				pw.println("<tr><th style='color:blue' colspan=11><input type='checkbox' name='faculty' value='"+rs.getString(1)+"'>"+rs.getString(1)+"</th></tr>");
				pw.println("<tr><th></th><th>"+p[0]+"</th><th>"+p[1]+"</th><th>"+p[2]+"</th><th>"+p[3]+"</th><th>"+p[4]+"</th><th>"+
							p[5]+"</th><th>"+p[6]+"</th><th>"+p[7]+"</th><th>"+p[8]+"</th><th>"+p[9]+"</th><tr>");
				for(int j=2;j<=6;j++)
				{
					String d=rs.getString(j+1);
					pw.println("<tr><td>"+days[j-2]+"</td>");
						
					for(int i=0;i<p.length;i++)
					{
							if(d.contains(p[i]))
								pw.print("<td style='background:green;color:white'>Y</td>");
							else
								pw.print("<td style='background:red;color:white'>N</td>");
					}
					pw.println("</tr>");
				}
			}
			pw.println("</table>");
			pw.println("<center><input type='submit' name='action' value='Submit'></center></form>");
			pw.println("</body>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
