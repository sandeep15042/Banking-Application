package Bank_Package;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/dep")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		double dm=Long.parseLong(request.getParameter("depositM"));
		//long a=Long.parseLong(request.getParameter("ano"));
		AccountBean a1=new AccountBean();
		a1.setBalance(dm);
		//a1.setAccno(a);
		
		HttpSession hs=request.getSession();
		long accNo = (long) hs.getAttribute("acc");
		a1.setAccno(accNo);
		
			int k = Deposit_DAO.dep(a1);
			response.setContentType("text/html");
			pw.print("<html><body bgcolor='pink' text='purple'>");
			pw.print("<i>");
			if(k>0)
			{
			pw.println("deposit succusfully......"+a1.getBalance());
			RequestDispatcher rd=request.getRequestDispatcher("deposit.html");
			rd.include(request, response);
		}
		else
		{
			pw.println("try to deposit");
		}
			pw.print("</i></body></html>");
	}

}
