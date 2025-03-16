package Bank_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.http.HttpSession;

public class TransferDAO {
	public static int trensferMoney(TransferBean t) {
		
		int k3 = 0;
		long dou=0;
		Connection con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##sandeep", "123");
			PreparedStatement p = con.prepareStatement("select * from bankaccount where ACCno=?");
			p.setLong(1, t.getSenderAccNo());
			ResultSet r = p.executeQuery();
			int count = 0;
			if(r.next()) {
				count++;
				 dou = r.getLong(3);
			}
			System.out.println("sender acc no"+t.getSenderAccNo());
			System.out.println(" getter acc no"+t.getAccno());
			
			if (count > 0) {
				
				PreparedStatement p1 = con
						.prepareStatement("update bankaccount set ACCOUNTBALANCE=ACCOUNTBALANCE-? where Accno=?");
				if(dou>t.getAmount()) {
				p1.setDouble(1, t.getAmount());
                p1.setLong(2, t.getSenderAccNo());
                k3 =  p1.executeUpdate();
              
				PreparedStatement p3 = con
						.prepareStatement("update bankaccount set ACCOUNTBALANCE=ACCOUNTBALANCE+? where Accno=?");
				
				p3.setDouble(1, t.getAmount());
				p3.setLong(2, t.getAccno());
			    p3.executeUpdate();
				
			   PreparedStatement p5=con.prepareStatement("insert into transaction values(?,?,?,?)");
			   p5.setLong(1,t.getAccno() );
			   p5.setLong(2, t.getTransactionid());
			   p5.setString(3,t.getTransactiontime());
			   p5.setLong(4, t.getAmount());
			   p5.executeUpdate();
			
			}
				}
			return k3;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k3;

	}
}
