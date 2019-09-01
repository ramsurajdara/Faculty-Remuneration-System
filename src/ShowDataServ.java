

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
 * Servlet implementation class ShowDataServ
 */
@WebServlet("/ShowDataServ")
public class ShowDataServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDataServ() {
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
			HttpSession session = request.getSession();
			String id=(String) session.getAttribute("id");
			ShowDataDAO sdo=new ShowDataDAO();
			try {
				ResultSet rs=sdo.showData(id);
				pw.println("<link rel='stylesheet' type='text/css' href='webstyle.css'>");
				pw.println("<link rel='stylesheet' type='text/css' href='webstyle2.css'>");
				pw.println("<ul><li><a href='ShowDataServ'>Display Data</a></li><li><a href='TimeTableEntry.html'>TimeTable</a></li><li style='float:right'><a href='LogoutServ'><img width='80' height='20' src='Images/logout2.png'></a></li></ul>");
				pw.println("<br><br><table border='1' bgColor='white' align='center' width=80%>");
				pw.println("<tr><th>BILLNO</th><th>TYPE</th><th>PAY</th><th>STATUS</th></tr>");
				while(rs.next())
				{
					pw.print("<tr>");
					pw.println("<td>"+rs.getString(1)+"</td>"+"<td>"+rs.getString(2)+"</td>"+"<td>"+rs.getInt(3)+"</td>"+"<td>"+rs.getString(4)+"</td>");
					pw.println("</tr>");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.println("</table>");	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
