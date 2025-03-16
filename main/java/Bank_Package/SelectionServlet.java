package Bank_Package;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
/**
 * Servlet implementation class selectionServlet
 */
@WebServlet("/app")
public class SelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String option=request.getParameter("option");
		switch(option)
		{
		case "Deposit":
			RequestDispatcher rd=request.getRequestDispatcher("deposit.html");
			rd.forward(request, response);
			break;
		case "TransferMoney":
			RequestDispatcher rd1=request.getRequestDispatcher("transfer.html");
			rd1.forward(request, response);
		}
		
	}

}
