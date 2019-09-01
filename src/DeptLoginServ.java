

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
 * Servlet implementation class DeptLoginServ
 */
@WebServlet("/DeptLoginServ")
public class DeptLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptLoginServ() {
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
		if(act.equalsIgnoreCase("Login"))
		{
			
			String dept=request.getParameter("dept");
			String pswd=request.getParameter("pswd");
			DeptLoginDAO ddo=new DeptLoginDAO();
			try {
				boolean ack=ddo.loginDept(dept, pswd);
				System.out.println(ack);
				if(ack)
				{
					HttpSession session=request.getSession();  
			        session.setAttribute("id", dept);
					RequestDispatcher rd=request.getRequestDispatcher("DisplayFacultyDataServ");
					rd.forward(request, response);
				}
				else
					pw.println("Invalid password");
	
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			
		}
	}

}
