package com.bank.Objects;
/*
    This is the account class.
    This class extends the person class to get the person properties (firstname, lastname)
 */
public class BankAccount extends Person{

    // account balance
    private double accountBalance;

    public BankAccount(String firstName, String lastName, double startBalance){
        super(firstName, lastName);
        this.accountBalance = startBalance;
    }

    // returns the account balance.
    public double getAccountBalance(){
        return accountBalance;
    }
}
