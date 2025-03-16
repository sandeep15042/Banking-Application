package Bank_Package;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.http.HttpSession;
public class Deposit_DAO {
       public static int dep(AccountBean a)
       {
    	   AccountBean a1=a;
    	   int k=0;
    Connection con;
    try {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##sandeep","123");
    	   PreparedStatement p=con.prepareStatement("update bankaccount set ACCOUNTBALANCE=ACCOUNTBALANCE+? where ACCNO=?");
    	   double b= a.getBalance();
    	  long ano= a.getAccno();
    	  System.out.println(b);
    	  System.out.println(ano);
    	  p.setDouble(1, b);
    	  p.setLong(2, ano);
    	  k= p.executeUpdate();
    	
    	   }
    	   catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }
	    return k;
    	   
       }
}
