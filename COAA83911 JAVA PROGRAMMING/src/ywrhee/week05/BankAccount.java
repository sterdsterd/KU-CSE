package ywrhee.week05;

public class BankAccount {	
	private int accountNumber;
	private String customerName;
	private double accountBalance;
	private static int count = 0;

	{
		this.accountNumber = ++count;
	}

	private BankAccount(String customerName) {
		this(customerName, 0);
	}

	private BankAccount(String customerName, double accountBalance) {
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public static BankAccount getInstance(String customerName, double accountBalance) {
		BankAccount account = new BankAccount(customerName, accountBalance);
		return account;
	}

	public void deposit(double amount) {
		this.accountBalance -= amount;
		System.out.println(amount + "원 입금 완료");
	}
	
	public void withdraw(double amount) {
		if (this.accountBalance >= amount) {
			this.accountBalance -= amount;
			System.out.println(amount + "원 출금 완료");
		} else {
			System.out.println("잔액 부족 : 현재 잔액 " + this.accountBalance + "원");
		}
	}
	
	public void transfer(BankAccount account, double amount) {
		if (this.accountBalance >= amount) {
			this.accountBalance -= amount;
			account.accountBalance += amount;
			System.out.println(amount + "원 이체 완료");
		} else {
			System.out.println("잔액 부족 : 현재 잔액 " + this.accountBalance + "원");
		}
	}

	@Override
	public String toString() {
		return customerName + "(" + accountNumber + ")님 잔액은 " + accountBalance + "원 입니다.";
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}
