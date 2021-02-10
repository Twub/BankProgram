package com.bank.Objects;

import java.util.ArrayList;

/*
    This is the account class.
    This class extends the person class to get the person properties (firstname, lastname)
 */
public class BankAccount extends Person{

    // account balance
    private double accountBalance;
    private ArrayList<String> transactions = new ArrayList<String>();

    public BankAccount(String firstName, String lastName, double startBalance){
        super(firstName, lastName);
        this.accountBalance = startBalance;
    }

    // returns the account balance.
    public double getAccountBalance(){
        return accountBalance;
    }

    public void addMoney(double money){
        this.accountBalance += money;
        String transText = "Added: " + money;
        transactions.add(transText);
    }

    public boolean takeOut(double money){
        boolean success = false;
        if (accountBalance > money){
            accountBalance -= money;
            String transText = "Removed: " + money;
            transactions.add(transText);
            success = true;
        }
        return success;
    }

    public ArrayList<String> getTransactions() {
        return transactions;
    }
}
