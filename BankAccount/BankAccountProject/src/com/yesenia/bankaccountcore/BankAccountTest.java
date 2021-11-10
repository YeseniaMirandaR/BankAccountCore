package com.yesenia.bankaccountcore;
import com.yesenia.bankaccountclass.BankAccount;

public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount();
		
		bankAccount.depositMoney(200, "checking");
		bankAccount.depositMoney(45, "savings");
		bankAccount.showTotalAccount();
		
		System.out.println(String.format("Total:"));
		System.out.println(BankAccount.trackTotalAmount);
		
		bankAccount.withdrawMoney(45,"checking");
		bankAccount.withdrawMoney(75,"savings");
		bankAccount.showTotalAccount();
		
		System.out.println(String.format("Total:"));
		System.out.println(BankAccount.trackTotalAmount);
	}
}
