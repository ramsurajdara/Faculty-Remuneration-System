

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateServ
 */
@WebServlet("/UpdateServ")
public class UpdateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServ() {
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
		PrintWriter pw=response.getWriter();
		String fac[]=request.getParameterValues("faculty");
		String time=request.getParameter("tm");
		String dt=request.getParameter("dt");
		UpdateDAO upd=new UpdateDAO();
		HttpSession session = request.getSession();
		String dept=(String) session.getAttribute("id");
		try {
			int ack=upd.setFaculty(fac,dept,dt,time);
			if(ack==1)
				pw.println("<script>alert('Entry Success');location.href='DisplayFacultyDataServ'</script>");
			else if(ack==0)
				pw.println("<script>alert('Entry Failed');location.href='DisplayFacultyDataServ'</script>");
			else
				pw.println("<script>alert('DB Error');location.href='DisplayFacultyDataServ'</script>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

}
