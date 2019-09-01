

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TimeTableServ
 */
@WebServlet("/TimeTableServ")
public class TimeTableServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeTableServ() {
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
		String act=request.getParameter("action");		
		PrintWriter pw=response.getWriter();
		if(act.equalsIgnoreCase("submit"))
		{
			String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
			HttpSession session = request.getSession();
			String id=(String) session.getAttribute("id");
			String data[][]=new String[5][10];
			for(int j=0;j<5;j++)
			{
				data[j] = request.getParameterValues(days[j]) ;
			}
			TimeTableDAO ttd=new TimeTableDAO();
			try {
				int ack=ttd.setData(data,id);
				if(ack==1)
					pw.println("<script>alert('Entry Success');location.href='FacultyOp.jsp';</script>");
				else if(ack==0)
					pw.println("<script>alert('Failed');location.href='FacultyOp.jsp';</script>");
				else
					pw.println("<script>alert('DB Error');location.href='FacultyOp.jsp';</script>");
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
