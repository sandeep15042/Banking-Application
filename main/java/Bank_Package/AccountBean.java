package Bank_Package;

public class AccountBean {
     private long accno;
     private String accountholdername;
     private double balance;
	public AccontBean(long accno, String accountholdername, double balance) {
		super();
		this.accno = accno;
		this.accountholdername = accountholdername;
		this.balance = balance;
	}
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public String getAccountholdername() {
		return accountholdername;
	}
	public void setAccountholdername(String accountholdername) {
		this.accountholdername = accountholdername;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "AccontBean [accno=" + accno + ", accountholdername=" + accountholdername + ", balance=" + balance + "]";
	}

     
}
