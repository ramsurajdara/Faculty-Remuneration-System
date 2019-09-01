import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
/**
 * Servlet implementation class StudentServ
 */
public class FacultyRegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacultyRegisterServ() {
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
		FacultyRegisterDAO fdo=new FacultyRegisterDAO();
		PrintWriter pw=response.getWriter();
		if(act.equalsIgnoreCase("Register"))
		{
			String id=request.getParameter("id");
			String dept=request.getParameter("dept");
			String pswd=request.getParameter("pswd");
			String email=request.getParameter("em");
			String phno=request.getParameter("phno");
			Faculty f=new Faculty();
			f.setID(id);
			f.setDept(dept);
			f.setPassword(pswd);
			f.setEmail(email);
			f.setPhno(phno);
			
			int ack=fdo.RegFaculty(f);
			
			if(ack==1)
				pw.println("<script>alert('Registration Success');location.href='Register.html';</script>");
			else if(ack==0)
				pw.println("<script>alert('Registration Failed');location.href='Register.html';</script>");
			else
				pw.println("<script>alert('DB Error');location.href='Register.html';</script>");
		}
	}

}
