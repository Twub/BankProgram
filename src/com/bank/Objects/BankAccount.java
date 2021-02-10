package com.bank.Objects;

public class BankAccount extends Person{

    private double accountBalance;

    public BankAccount(String firstName, String lastName, double startBalance){
        super(firstName, lastName);
        this.accountBalance = startBalance;
    }

    public double getAccountBalance(){
        return accountBalance;
    }
}
