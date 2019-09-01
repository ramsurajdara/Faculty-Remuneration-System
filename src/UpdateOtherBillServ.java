

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateOtherBillServ
 */
@WebServlet("/UpdateOtherBillServ")
public class UpdateOtherBillServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOtherBillServ() {
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
		if(action.equals("Update"))
		{
			UpdatePaymentDAO upd=new UpdatePaymentDAO();
			String data=request.getParameter("bills");
			String bills[]=data.split(",");
			for(int i=0;i<bills.length;i++)
			{
				try {
					ack=upd.payInvg(bills[i]);
					if(ack==1)
						pw.println("<script>alert('Entry Success');location.href='InvgBillUpdation.html'</script>");
					else if(ack==0)
						pw.println("<script>alert('Entry Failure');location.href='InvgBillUpdation.html'</script>");
					else
						pw.println("<script>alert('DB Error');location.href='InvgBillUpdation.html'</script>");	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
