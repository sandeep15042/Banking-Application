package Bank_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginBankDAO {
     public static AccountBean log(AccountBean a)
     {
    	 AccountBean a1=null;
    	 Connection con;
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##sandeep","123");
    		PreparedStatement p=con.prepareStatement("select * from bankaccount where accholdername=? and  accno=?");
    		long accno=a.getAccno();
    		String ahno=a.getAccountholdername();
    		
    		p.setString(1, ahno);
    		p.setLong(2, accno);
    		ResultSet r=p.executeQuery();
    		if(r.next())
    		{
    				a1=new AccountBean();
    		a1.setAccountholdername(r.getString(2));
    		a1.setAccno(r.getLong(1));
    		
    		}
    		
    	   	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return a1;
     }
}
