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
 * Servlet implementation class LoginBankServlet
 */
@WebServlet("/log")
public class LoginBankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginBankServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		long accno=Long.parseLong(request.getParameter("accno"));
		String hname=request.getParameter("holdername");
		AccountBean a=new AccountBean();
		a.setAccno(accno);
		a.setAccountholdername(hname);
		AccountBean a1=(AccountBean)LoginBankDAO.log(a);
		response.setContentType("text/html");
		pw.print("<html><body bgcolor='pink' text='cyan'>");
		pw.print("<h1>");
		//System.out.println(a1.getAccountholdername());
		if(a1!=null)
		{
			//pw.println("login succusfully....."+a1.getAccountholdername());
			HttpSession hs=request.getSession();
			hs.setAttribute("acc", accno);
			RequestDispatcher rd=request.getRequestDispatcher("loginsuccus.jsp");
					rd.include(request, response);
		}
		else
		{
			pw.println("try to login......");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		pw.print("<h1></body></html>");
	}

}
