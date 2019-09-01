

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeInvigilationServ
 */
@WebServlet("/ChangeInvigilationServ")
public class ChangeInvigilationServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInvigilationServ() {
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
		String dt=request.getParameter("dt");
		String tm=request.getParameter("tm");
		String room=request.getParameter("room");
		String fid=request.getParameter("fid");
		String rfid=request.getParameter("rfid");
		ChangeInvigilationDAO cid=new ChangeInvigilationDAO();
		int ack;
		try {
			ack = cid.replaceFaculty(dt,tm,room,fid,rfid);
			if(ack==1)
				pw.println("<script>alert('Entry Success');location.href='AdminOp.jsp'</script>");
			else if(ack==0)
				pw.println("<script>alert('Entry Failure');location.href='AdminOp.jsp'</script>");
			else
				pw.println("<script>alert('DB Error');location.href='AdminOp.jsp'</script>");				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
