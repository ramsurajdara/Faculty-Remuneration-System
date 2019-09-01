
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
 * Servlet implementation class FacultyLoginServ
 */
@WebServlet("/FacultyLoginServ")
public class FacultyLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyLoginServ() {
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
		FacultyLoginDAO fdo=new FacultyLoginDAO();
		PrintWriter pw=response.getWriter();
		if(act.equalsIgnoreCase("Login"))
		{
			String id=request.getParameter("id");
			String pswd=request.getParameter("pswd");
			Faculty f=new Faculty();
			f.setID(id);
			f.setPassword(pswd);
			try {
				boolean ack=fdo.loginFaculty(f);
				if(ack)
				{
					HttpSession session=request.getSession(true);  
			        session.setAttribute("id", id);
					RequestDispatcher rd=request.getRequestDispatcher("FacultyOp.jsp");
					rd.forward(request, response);
				}
				else
					pw.println("Invalid User/Password");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
