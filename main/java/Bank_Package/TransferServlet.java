package Bank_Package;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.io.PrintWriter;

@WebServlet("/tran")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TransferServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		long accno=Long.parseLong(request.getParameter("TNo"));
		long tamount=Long.parseLong(request.getParameter("Tamount"));
	
		TransferBean t=new TransferBean();
		t.setAccno(accno);
		t.setAmount(tamount);
		t.setTransactionid((long)(Math.random()*12345));
		t.setTransactiontime(new Date().toString());
		HttpSession h=request.getSession();
		long value= (long)h.getAttribute("acc");
		System.out.println(value);
		
		t.setSenderAccNo(value);
		int t2=TransferDAO.trensferMoney(t);
		System.out.println(t2);
	  response.setContentType("text/html");
	  pw.print("<html><head></head>");
	  pw.print("<style>");
	  pw.print("body{background-color:red");
	  pw.print("</style>");
	  pw.print("<body id='c'> ");
	  pw.print("<i>");
		if(t2>0)
		{
			pw.println("trensfer succusfully......");
			h.setAttribute("acc",t2);
			RequestDispatcher rd=request.getRequestDispatcher("transactionsuccus.jsp");
			rd.forward(request, response);
			//pw.print(t2.getAccno());
		}
		else
		{
			pw.println("try to transfer....");
			RequestDispatcher rd=request.getRequestDispatcher("transactionfail.jsp");
			rd.forward(request, response);
		}
		
		pw.print("</i></body></html>");
				
		
		
	}

}
