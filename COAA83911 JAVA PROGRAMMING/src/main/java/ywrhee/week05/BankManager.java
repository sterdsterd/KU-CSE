package ywrhee.week05;

import ywrhee.week04.TV;

import java.util.Scanner;

public class BankManager {
	
	public String branchName;
	public final int NUM;

	public int count = 0;
	public BankAccount[] bankAccount;

	private TV tv = new TV();
	
	public static Scanner scan = new Scanner(System.in);
	
	public BankManager(String branchName, int num) {
		this.branchName = branchName;
		this.NUM = num;
		bankAccount = new BankAccount[NUM];
	}
	
	public void createAccount() {
		System.out.println("-------- 계좌 개설 --------");
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("입금할 금액 : ");
		double amount = scan.nextDouble();

		if (count < NUM) {
			this.bankAccount[count++] = BankAccount.getInstance(name, amount);
			System.out.println("계좌 개설 완료");
		} else {
			System.out.println("계좌 개설 불가");
		}
	}
	
	public void deposit() {
		System.out.println("-------- 입금 --------");
		System.out.print("계좌번호 : ");
		int account = scan.nextInt();
		BankAccount target = findAccount(account);

		if (target != null) {
			System.out.print("입금할 금액: ");
			double amount = scan.nextDouble();
			target.deposit(amount);
			System.out.println("입금 완료");
		}

	}
	
	public void withdraw() {
		System.out.println("-------- 출금 --------");
		System.out.print("계좌번호 : ");
		int account = scan.nextInt();
		BankAccount target = findAccount(account);

		if (target != null) {
			System.out.print("출금할 금액: ");
			double amount = scan.nextDouble();
			target.withdraw(amount);
			System.out.println("출금 완료");
		}
	}

	public void transfer() {
		System.out.println("-------- 이체 --------");
		System.out.print("송금하는 계좌번호 : ");
		int account1 = scan.nextInt();
		System.out.print("송금받는 계좌번호 : ");
		int account2 = scan.nextInt();
		BankAccount target1 = findAccount(account1);
		BankAccount target2 = findAccount(account2);

		if (target1 != null && target2 != null) {
			System.out.print("송금할 금액: ");
			double amount = scan.nextDouble();
			target1.transfer(target2, amount);
			System.out.println("출금 완료");
		}
		
	}

	public BankAccount findAccount(int account) {
		System.out.println("-------- 계좌 검색 --------");
		for (int i = 0; i < count; i++) {
			if (this.bankAccount[i].getAccountNumber() == account) {
				System.out.println("계좌 검색 완료");
				return this.bankAccount[i];
			}
		}
		System.out.println("계좌번호 확인 요망");
		return null;
	}
}
