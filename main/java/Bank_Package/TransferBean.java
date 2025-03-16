package Bank_Package;

public class TransferBean {
    private long accno;
    private long senderAccNo;
    private long transactionid;
    private String transactiontime;
    private long amount;
	public long getAccno() {
		return accno;
	}
	public void setAccno(long accno) {
		this.accno = accno;
	}
	public long getSenderAccNo() {
		return senderAccNo;
	}
	public void setSenderAccNo(long senderAccNo) {
		this.senderAccNo = senderAccNo;
	}
	public long getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}
	public String getTransactiontime() {
		return transactiontime;
	}
	public void setTransactiontime(String transactiontime) {
		this.transactiontime = transactiontime;
	}
	public long getAmount() {
		return amount;
	}
	public long setAmount(long amount) {
		return this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransferBean [accno=" + accno + ", transactionid=" + transactionid + ", transactiontime="
				+ transactiontime + ", amount=" + amount + "]";
	}
	
    
}
