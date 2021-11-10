package com.yesenia.bankaccountclass;

import java.util.Random;

public class BankAccount {
	/*The class should have the following attributes:
	(double) checking balance, (double) savings balance.*/
	private double checkingBalance;
	private double savingBalance;
	private String accountNumber;
	private static String randmTenDigit() {
		String subst = "";
		Random rand = new Random();
		for(int i = 0; i<10; i++) {
			subst += rand.nextInt(10);// nextInt from java random feature
		}
		return subst;
	}

	/*Create a class member (static) that has 
	the number of accounts created thus far.*/
	public static int createdAccounts = 0;
	
	/*Create a class member (static) that tracks the total amount of 
	money stored in every account created.*/
	public static double trackTotalAmount = 0;
	
	//Increment the account
	public BankAccount() {
		BankAccount.createdAccounts += 1;
		this.checkingBalance = 0;
		this.savingBalance = 0;
		this.accountNumber = BankAccount.randmTenDigit();
	}	
	/*Create a getter method for the user's checking account balance*/
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	/*Create a getter method for the user's saving account balance*/
	public double getSavingBalance() {
		return this.savingBalance;
	}
		
	/*Create a method that will allow a user to deposit money into 
	either the checking or saving, be sure to add to total amount 
	stored.*/
	public void depositMoney(double amount, String accountType){
		if(accountType.equals("savings"))
			this.savingBalance += amount;
		else if(accountType.equals("checking"))
			this.checkingBalance += amount;
		BankAccount.trackTotalAmount += amount;
	}
	
	/*Create a method that will allow a user to withdraw money from 
	one balance. Do not allow them to withdraw money if there are 
	insufficient funds.*/
	public void withdrawMoney(double amount, String accountType) {
		boolean doIt = false;
		if(accountType.equals("savings")) {
			if(this.savingBalance - amount >= 0) {
				doIt = true;
				this.savingBalance -= amount;
			}
		}
		else if(accountType.equals("checking")) {
			if(this.checkingBalance - amount >= 0) {
				doIt = true;
				this.checkingBalance -= amount;
			}
		}
		if(doIt) {
			BankAccount.trackTotalAmount -= amount;
		}
	}
	
	/*Create a method to see the total money 
	from the checking and saving.*/
	public void showTotalAccount() {
		System.out.println(String.format("Savings: %f, Checking: %f", this.savingBalance, this.checkingBalance));
	}//f string format for numbers
}
