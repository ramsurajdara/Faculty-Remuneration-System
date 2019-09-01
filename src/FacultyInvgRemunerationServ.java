

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FacultyInvgRemunerationServ
 */
@WebServlet("/FacultyInvgRemunerationServ")
public class FacultyInvgRemunerationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyInvgRemunerationServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String action=request.getParameter("action");
		int ack=0;
		PrintWriter pw=response.getWriter();
		if(action.equals("Submit"))
		{
			String dt=request.getParameter("dt");
			String time=request.getParameter("time");
			FacultyInvgRemunerationDAO fird=new FacultyInvgRemunerationDAO();
			try {
				ack=fird.setInvgRemData(dt,time);
				if(ack==1)
					pw.println("<script>alert('Entry Success');location.href='FacultyRemunerationInvg.html'</script>");
				else if(ack==0)
					pw.println("<script>alert('Entry Failure');location.href='FacultyRemunerationInvg.html'</script>");
				else
					pw.println("<script>alert('DB Error');location.href='FacultyRemunerationInvg.html'</script>");	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

}
