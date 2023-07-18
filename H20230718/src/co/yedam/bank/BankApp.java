package co.yedam.bank;

public class BankApp {

	// 싱글톤 방식
	private static BankApp instance = new BankApp();

	Account[] accounts;
	int accountNum = 0;

	Account acc = new Account();

	// 생성자
	private BankApp() {
		accounts = new Account[10];
	}

	public static BankApp getInstance() {
		return instance;
	}

	void registerAccount(Account cnt) {
		accounts[accountNum++] = cnt;
	}

	int accCheck(String accountNo) {
		int ox = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accountNo.equals(accounts[i].accountNo)) {
				ox = 1;
			}

		}
		return ox;

	}

	int deposit(String accountNo, int dps) {
		int balance = 0;
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && accountNo.equals(accounts[i].accountNo)) {
				balance = accounts[i].balance += dps;

			}
		}
		return balance;
	}

	boolean withdraw(int balance, int wdr) {

		if (balance - wdr < 0) {
			return false;
		}
		balance -= wdr;
		return true;

	}

	void accountList() {
		for (int i = 0; i < accounts.length; i++) {

		}
	}
}
