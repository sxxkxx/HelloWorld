package co.yedam.bank;

public class Account {
	String accountNo;
	String name;
	int balance;
	
	public Account() {
		
	}
	
	Account(String accountNo, String name, int balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
