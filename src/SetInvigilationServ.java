

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetData
 */
@WebServlet("/SetData")
public class SetInvigilationServ extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetInvigilationServ() {
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
		String room=request.getParameter("roomno");
		String time=request.getParameter("time");
		String dept1=request.getParameter("dept1");
		String dept2=request.getParameter("dept2");
		SetInvigilationDAO sid=new SetInvigilationDAO();
		int ack;
		try {
			ack = sid.setFaculty(dt,room,time,dept1,dept2);
			System.out.println(ack);
			if(ack==1)
				pw.println("<script>alert('Entry Success');location.href='Entry.html'</script>");
			else if(ack==0)
				pw.println("<script>alert('Entry Failure');location.href='Entry.html'</script>");
			else
				pw.println("<script>alert('DB Error');location.href='Entry.html'</script>");				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
